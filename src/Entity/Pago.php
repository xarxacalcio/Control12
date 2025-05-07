<?php

namespace App\Entity;

use App\Repository\PagoRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: PagoRepository::class)]
class Pago
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(type: Types::DATE_MUTABLE)]
    #[Groups(['grupo-pago'])]
    private ?\DateTimeInterface $fecha = null;

    #[ORM\Column(type: Types::STRING, length: 8)]
    #[Groups(['grupo-pago'])]
    private ?string $hora = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(['grupo-pago'])]
    private ?Alumno $alumno = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(['grupo-pago'])]
    private ?TipoPago $tipoPago = null;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(['grupo-pago'])]
    private ?DatosEmpresa $datosEmpresa = null;

    #[ORM\Column(type: Types::FLOAT)]
    #[Groups(['grupo-pago'])]
    private ?float $importe = 0.0;


    

    /**
     * @var Collection<int, LineaDetalle>
     */
    #[ORM\OneToMany(targetEntity: LineaDetalle::class, mappedBy: 'pago', orphanRemoval: true)]
    #[Groups(['grupo-pago'])]
    private Collection $lineaDetalles;

    public function __construct()
    {
        $this->lineaDetalles = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getFecha(): ?\DateTimeInterface
    {
        return $this->fecha;
    }

    public function setFecha(\DateTimeInterface $fecha): static
    {
        $this->fecha = $fecha;

        return $this;
    }

    public function getHora(): ?string
    {
        return $this->hora;
    }

    public function setHora(string $hora): static
    {
        $this->hora = $hora;

        return $this;
    }

    public function getAlumno(): ?Alumno
    {
        return $this->alumno;
    }

    public function setAlumno(?Alumno $alumno): static
    {
        $this->alumno = $alumno;

        return $this;
    }

    public function getTipoPago(): ?TipoPago
    {
        return $this->tipoPago;
    }

    public function setTipoPago(?TipoPago $tipoPago): static
    {
        $this->tipoPago = $tipoPago;

        return $this;
    }

    public function getDatosEmpresa(): ?DatosEmpresa
    {
        return $this->datosEmpresa;
    }

    public function setDatosEmpresa(?DatosEmpresa $datosEmpresa): static
    {
        $this->datosEmpresa = $datosEmpresa;

        return $this;
    }

    /**
     * @return Collection<int, LineaDetalle>
     */
    public function getLineaDetalles(): Collection
    {
        return $this->lineaDetalles;
    }

    public function addLineaDetalle(LineaDetalle $lineaDetalle): static
    {
        if (!$this->lineaDetalles->contains($lineaDetalle)) {
            $this->lineaDetalles->add($lineaDetalle);
            $lineaDetalle->setPago($this);
        }

        return $this;
    }

    public function removeLineaDetalle(LineaDetalle $lineaDetalle): static
    {
        if ($this->lineaDetalles->removeElement($lineaDetalle)) {
            
            if ($lineaDetalle->getPago() === $this) {
                $lineaDetalle->setPago(null);
            }
        }

        return $this;
    }

    public function getImporte(): ?float
    {
        return $this->importe;
    }

    public function setImporte(float $importe): static
    {
        $this->importe = $importe;

        return $this;
    }
}
