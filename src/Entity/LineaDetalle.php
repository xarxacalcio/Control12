<?php

namespace App\Entity;

use App\Repository\LineaDetalleRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: LineaDetalleRepository::class)]
class LineaDetalle
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column]
    #[Groups(['grupo-pago'])]
    private ?int $undidades = null;

    #[ORM\Column]
    #[Groups(['grupo-pago'])]
    private ?float $precio = null;

    #[ORM\ManyToOne(inversedBy: 'lineaDetalles')]
    #[ORM\JoinColumn(nullable: false)]
    private ?Pago $pago = null;

    #[ORM\ManyToOne]
    #[Groups(['grupo-pago'])]
    #[ORM\JoinColumn(nullable: false)]
    private ?CatalogoProducto $catalogoProducto = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getUndidades(): ?int
    {
        return $this->undidades;
    }

    public function setUndidades(int $undidades): static
    {
        $this->undidades = $undidades;

        return $this;
    }

    public function getPrecio(): ?float
    {
        return $this->precio;
    }

    public function setPrecio(float $precio): static
    {
        $this->precio = $precio;

        return $this;
    }

    public function getPago(): ?Pago
    {
        return $this->pago;
    }

    public function setPago(?Pago $pago): static
    {
        $this->pago = $pago;

        return $this;
    }

    public function getCatalogoProducto(): ?CatalogoProducto
    {
        return $this->catalogoProducto;
    }

    public function setCatalogoProducto(?CatalogoProducto $catalogoProducto): static
    {
        $this->catalogoProducto = $catalogoProducto;

        return $this;
    }
}
