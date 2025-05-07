<?php

namespace App\Controller;

use App\Repository\CatalogoProductoRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\CatalogoProducto;
use Doctrine\ORM\EntityManagerInterface;
use App\Entity\TipoAsistencia;

#[Route('/control12api/catalogo-producto')]
class CatalogoProductoController extends AbstractController
{
    private CatalogoProductoRepository $catalogoProductoRepository;
    private EntityManagerInterface $entityManager;

    public function __construct(CatalogoProductoRepository $catalogoProductoRepository, EntityManagerInterface $entityManager)
    {
        $this->catalogoProductoRepository = $catalogoProductoRepository;
        $this->entityManager = $entityManager;
    }

    // Obtener todos los productos del catálogo
    #[Route('/todos', name: 'app_catalogo_productos')]
    public function catalogoProductos(): JsonResponse
    {
        $productos = $this->catalogoProductoRepository->findAll();
        return $this->json($productos);
    }

    // Crear un nuevo producto en el catálogo
    #[Route('/nuevo-producto', name: 'app_nuevo_catalogo_producto', methods: ['POST'])]
    public function nuevoCatalogoProducto(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);
            $producto = new CatalogoProducto();
            $producto->setNombre($data['nombre']);
            $producto->setNumeroHoras($data['numeroHoras']);
            $producto->setPrecio($data['precio']);
            $producto->setIva($data['iva']);

            // Asignar el tipo de asistencia existente
            $tipoAsistencia = $this->entityManager->getRepository(TipoAsistencia::class)->find($data['tipoAsistencia']['id']);
            if (!$tipoAsistencia) {
                return $this->json(['status' => 'Tipo de asistencia no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            $producto->setTipoAsistencia($tipoAsistencia);
            

            $this->catalogoProductoRepository->save($producto);

        } catch (\Exception $e) {
            return $this->json(['status' => 'Error creando producto: '.$e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }

        return $this->json(['status' => 'Producto creado!'], JsonResponse::HTTP_CREATED);
    }

    // Modificar un producto existente en el catálogo
    #[Route('/modificar-producto', name: 'app_modificar_catalogo_producto', methods: ['POST'])]
    public function modificarCatalogoProducto(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);

            $producto = $this->catalogoProductoRepository->find($data['id']);
            if (!$producto) {
                return $this->json(['status' => 'Producto no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }

            $producto->setNombre($data['nombre']);
            $producto->setNumeroHoras($data['numeroHoras']);
            $producto->setPrecio($data['precio']);
            $producto->setIva($data['iva']);
            
            // Actualizar el tipo de asistencia
            $tipoAsistencia = $this->entityManager->getRepository(TipoAsistencia::class)->find($data['tipoAsistencia']['id']);
            if (!$tipoAsistencia) {
                return $this->json(['status' => 'Tipo de asistencia no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            $producto->setTipoAsistencia($tipoAsistencia);

            $this->catalogoProductoRepository->save($producto);

        } catch (\Exception $e) {
            return $this->json(['status' => 'Error actualizando producto: '.$e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }

        return $this->json(['status' => 'Producto actualizado!'], JsonResponse::HTTP_OK);
    }

    // Eliminar un producto del catálogo
    #[Route('/eliminar-producto', name: 'app_eliminar_catalogo_producto', methods: ['POST'])]
    public function eliminarCatalogoProducto(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);

            $producto = $this->catalogoProductoRepository->find($data['id']);
           
            if (!$producto) {
                return $this->json(['status' => 'Producto no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }

            $this->entityManager->remove($producto);
            $this->catalogoProductoRepository->flush();

        } catch (\Exception $e) {
            return $this->json(['status' => 'Error eliminando producto: '.$e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }

        return $this->json(['status' => 'Producto eliminado!'], JsonResponse::HTTP_OK);
    }

    // Obtener un producto por ID
    #[Route('/{id}', name: 'app_catalogo_producto')]
    public function catalogoProducto($id): JsonResponse
    {
        $producto = $this->catalogoProductoRepository->find($id);
        if (!$producto) {
            return $this->json(['status' => 'Producto no encontrado'], JsonResponse::HTTP_NOT_FOUND);
        }
        return $this->json($producto);
    }

    // Buscar producto por nombre
    #[Route('/nombre/{nombre}', name: 'app_catalogo_producto_nombre')]
    public function catalogoProductoNombre($nombre): JsonResponse
    {
        $producto = $this->catalogoProductoRepository->findOneBy(['nombre' => $nombre]);
        if (!$producto) {
            return $this->json(['status' => 'Producto no encontrado'], JsonResponse::HTTP_NOT_FOUND);
        }
        return $this->json($producto);
    }

    // Buscar productos por tipo de asistencia
    #[Route('/tipo-asistencia/{tipo_asistencia}', name: 'app_catalogo_producto_tipo_asistencia')]
    public function catalogoProductoTipoAsistencia($tipo_asistencia): JsonResponse
    {
        $productos = $this->catalogoProductoRepository->findBy(['tipoAsistencia' => $tipo_asistencia]);
        return $this->json($productos);
    }
}


