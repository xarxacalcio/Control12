<?php

namespace App\Controller;

use App\Repository\TipoAsistenciaRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/control12api/tipoasistencia')]
class TipoAsistenciaController extends AbstractController
{
    private TipoAsistenciaRepository $tipoAsistenciaRepository;

    public function __construct(TipoAsistenciaRepository $tipoAsistenciaRepository)
    {
        $this->tipoAsistenciaRepository = $tipoAsistenciaRepository;
    }

    #[Route('/todos', name: 'app_tipo_asistencias')]
    public function tipoAsistencias(): JsonResponse
    {
        $tipoAsistencias = $this->tipoAsistenciaRepository->findAll();
        return $this->json($tipoAsistencias);
    }

    #[Route('/{id}', name: 'app_tipo_asistencia')]
    public function tipoAsistencia($id): JsonResponse
    {
        $tipoAsistencia = $this->tipoAsistenciaRepository->find($id);
        return $this->json($tipoAsistencia);
    }

    #[Route('/nombre/{nombre}', name: 'app_tipo_asistencia_nombre')]
    public function tipoAsistenciaNombre($nombre): JsonResponse
    {
        $tipoAsistencia = $this->tipoAsistenciaRepository->findOneBy(['nombre' => $nombre]);
        return $this->json($tipoAsistencia);
    }


}
