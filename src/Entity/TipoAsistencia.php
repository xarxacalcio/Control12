<?php

namespace App\Entity;

use App\Repository\TipoAsistenciaRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: TipoAsistenciaRepository::class)]
class TipoAsistencia
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nombre = null;

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
}
