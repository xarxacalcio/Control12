<?php

namespace App\Controller;

use App\Entity\Alumno;
use App\Entity\DatosEmpresa;
use App\Entity\Pago;
use App\Entity\TipoPago;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\PagoRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

#[Route('/control12api/pago')]

class PagoController extends AbstractController
{
    private $pagoRepository;
    private EntityManagerInterface $entityManager;

    public function __construct(PagoRepository $pagoRepository, EntityManagerInterface $entityManager)
    {
        $this->pagoRepository = $pagoRepository;
        $this->entityManager = $entityManager;
    }



    #[Route('/todos', name: 'app_pago')]
    public function index(): JsonResponse
    {
        $pagos = $this->pagoRepository->findAllPagosWithSelectedFields();
        //return $this->json($pagos, Response::HTTP_OK, [], ['groups' => 'grupo-pago']);
       return $this->json($pagos);
    }

    // Crear un nuevo PAGO 
    #[Route('/nuevo-pago', name: 'app_nuevo_pago', methods: ['POST'])]
    public function nuevoPago(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);
            $pago = new Pago();
            $alumno = $this->entityManager->getRepository(Alumno::class)->find($data['alumno']['id']);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            $pago->setAlumno($alumno);
            $tipoPago = $this->entityManager->getRepository(TipoPago::class)->find($data['tipoPago']['id']);
            if (!$tipoPago) {
                return $this->json(['status' => 'Tipo de pago no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            $pago->setTipoPago($tipoPago);
            $datosEmpresa = $this->entityManager->getRepository(DatosEmpresa::class)->find($data['datosEmpresa']['id']);
            if (!$datosEmpresa) {
                return $this->json(['status' => 'Datos de empresa no encontrados'], JsonResponse::HTTP_NOT_FOUND);
            }
            $pago->setDatosEmpresa($datosEmpresa);
            $pago->setFecha(new \DateTime($data['fecha']));
            $pago->setHora($data['hora']);
            $pago->setImporte($data['importe'] ?? 0.0);
            $this->entityManager->persist($pago);

            if (isset($data['lineaDetalles']) && is_array($data['lineaDetalles'])) {
                foreach ($data['lineaDetalles'] as $lineaDetalleData) {
                    $lineaDetalle = new \App\Entity\LineaDetalle();
                    $articulo = $this->entityManager->getRepository(\App\Entity\CatalogoProducto::class)->find($lineaDetalleData['catalogoProducto']['id']);
                    if (!$articulo) {
                        return $this->json(['status' => 'Articulo no encontrado'], JsonResponse::HTTP_NOT_FOUND);
                    }
                    $lineaDetalle->setCatalogoProducto($articulo);
                    $lineaDetalle->setUndidades($lineaDetalleData['unidades'] ?? 0);
                    $lineaDetalle->setPrecio($lineaDetalleData['precio'] ?? 0.0);
                    $lineaDetalle->setPago($pago);
                    $this->entityManager->persist($lineaDetalle);
                    $pago->addLineaDetalle($lineaDetalle);
                }
            }

            


            $this->entityManager->flush();

        } catch (\Exception $e) {
            return $this->json(['status' => 'Error creando pago: '.$e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }

        return $this->json(['status' => 'pago creado!'], JsonResponse::HTTP_CREATED);
    }

    #[Route('/existe-pago/{id}', name: 'app_existe_pago', methods: ['GET'])]
    public function existePago(int $id): JsonResponse
    {
        $alumno = $this->entityManager->getRepository(Alumno::class)->find($id);
        if (!$alumno) {
            return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
        }

        $pago = $this->pagoRepository->findOneBy(['alumno' => $alumno]);
        $existePago = $pago !== null;

        return $this->json(['existePago' => $existePago], JsonResponse::HTTP_OK);
    }
}
