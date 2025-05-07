<?php

namespace App\Controller;

use App\Repository\TipoPagoRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;

#[Route('/control12api/tipo_pago')]
class TipoPagoController extends AbstractController
{
    private TipoPagoRepository $tipoPagoRepository;

    public function __construct(TipoPagoRepository $tipoPagoRepository)
    {
        $this->tipoPagoRepository = $tipoPagoRepository;
    }

    #[Route('/todos', name: 'app_tipo_pago_todos')]
    public function tiposPago(): JsonResponse
    {
        $tiposPago = $this->tipoPagoRepository->findAll();
        return $this->json($tiposPago);
    }

    #[Route('/{id}', name: 'app_tipo_pago_id')]
    public function tipoPagoPorId($id): JsonResponse
    {
        $tipoPago = $this->tipoPagoRepository->find($id);
        return $this->json($tipoPago);
    }

    #[Route('/nombre/{nombre}', name: 'app_tipo_pago_nombre')]
    public function tipoPagoPorNombre($nombre): JsonResponse
    {
        $tipoPago = $this->tipoPagoRepository->findOneBy(['nombre' => $nombre]);
        return $this->json($tipoPago);
    }
}



