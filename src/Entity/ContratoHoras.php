<?php

namespace App\Entity;

use App\Repository\ContratoHorasRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: ContratoHorasRepository::class)]
class ContratoHoras
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column]
    private ?int $numeroHoras = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    private ?CatalogoProducto $catalogoProducto = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNumeroHoras(): ?int
    {
        return $this->numeroHoras;
    }

    public function setNumeroHoras(int $numeroHoras): static
    {
        $this->numeroHoras = $numeroHoras;

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
