<?php

namespace App\Controller;

use App\Repository\AdministradorRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/control12api/administrador')]
class AdministradorController extends AbstractController
{
    private AdministradorRepository $administradorRepository;

    public function __construct(AdministradorRepository $administradorRepository)
    {
        $this->administradorRepository = $administradorRepository;
    }

    #[Route('/todos', name: 'app_administradores')]
    public function administradores(): JsonResponse
    {
        $administradores = $this->administradorRepository->findAll();
        return $this->json($administradores);
    }

    #[Route('/{id}', name: 'app_administrador')]
    public function administrador($id): JsonResponse
    {
        $administrador = $this->administradorRepository->find($id);
        return $this->json($administrador);
    }

    #[Route('/nombre/{nombre}', name: 'app_administrador_nombre')]
    public function administradorNombre($nombre): JsonResponse
    {
        $administrador = $this->administradorRepository->findOneBy(['nombre' => $nombre]);
        return $this->json($administrador);
    }

    #[Route('/apellidos/{apellidos}', name: 'app_administrador_apellidos')]
    public function administradorApellidos($apellidos): JsonResponse
    {
        $administrador = $this->administradorRepository->findOneBy(['apellidos' => $apellidos]);
        return $this->json($administrador);
    }

    #[Route('/nombre/{nombre}/apellidos/{apellidos}', name: 'app_administrador_nombre_apellidos')]
    public function administradorNombreApellidos($nombre, $apellidos): JsonResponse
    {
        $administrador = $this->administradorRepository->findOneBy(['nombre' => $nombre, 'apellidos' => $apellidos]);
        return $this->json($administrador);
    }
}
