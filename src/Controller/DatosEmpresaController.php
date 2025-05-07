<?php

namespace App\Controller;

use App\Repository\DatosEmpresaRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/control12api/datos_empresa')]
class DatosEmpresaController extends AbstractController
{
    private DatosEmpresaRepository $datosEmpresaRepository;

    public function __construct(DatosEmpresaRepository $datosEmpresaRepository)
    {
        $this->datosEmpresaRepository = $datosEmpresaRepository;
    }

    #[Route('/todos', name: 'app_datos_empresa_todos')]
    public function todosDatos(): JsonResponse
    {
        $datosEmpresa = $this->datosEmpresaRepository->findAll();
        return $this->json($datosEmpresa);
    }

    #[Route('/{id}', name: 'app_datos_empresa_id')]
    public function datosPorId($id): JsonResponse
    {
        $datoEmpresa = $this->datosEmpresaRepository->find($id);
        return $this->json($datoEmpresa);
    }

    #[Route('/nombre/{nombre}', name: 'app_datos_empresa_nombre')]
    public function datosPorNombre($nombre): JsonResponse
    {
        $datoEmpresa = $this->datosEmpresaRepository->findOneBy(['nombre' => $nombre]);
        return $this->json($datoEmpresa);
    }

    #[Route('/cif/{cif}', name: 'app_datos_empresa_cif')]
    public function datosPorCif($cif): JsonResponse
    {
        $datoEmpresa = $this->datosEmpresaRepository->findOneBy(['cif' => $cif]);
        return $this->json($datoEmpresa);
    }
}

