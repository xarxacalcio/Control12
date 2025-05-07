<?php

namespace App\Entity;

use App\Repository\CatalogoProductoRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: CatalogoProductoRepository::class)]
class CatalogoProducto
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    #[Groups(['grupo-pago'])]
    private ?string $nombre = null;

    #[ORM\Column]
    private ?int $numeroHoras = null;

    #[ORM\Column]
    private ?float $precio = null;

    #[ORM\Column]
    private ?float $iva = null;

    #[ORM\ManyToOne(targetEntity: TipoAsistencia::class, fetch: "EAGER")]
    #[ORM\JoinColumn(nullable: false)]
    private ?TipoAsistencia $tipoAsistencia = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    public function setNombre(string $nombre): static
    {
        $this->nombre = $nombre;

        return $this;
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

    public function getPrecio(): ?float
    {
        return $this->precio;
    }

    public function setPrecio(float $precio): static
    {
        $this->precio = $precio;

        return $this;
    }

    public function getIva(): ?float
    {
        return $this->iva;
    }

    public function setIva(float $iva): static
    {
        $this->iva = $iva;

        return $this;
    }

    public function getTipoAsistencia(): ?TipoAsistencia
    {
        return $this->tipoAsistencia;
    }

    public function setTipoAsistencia(?TipoAsistencia $tipoAsistencia): static
    {
        $this->tipoAsistencia = $tipoAsistencia;

        return $this;
    }
}
