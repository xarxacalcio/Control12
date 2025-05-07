<?php

namespace App\Repository;

use App\Entity\Alumno;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Doctrine\ORM\EntityManagerInterface;

/**
 * @extends ServiceEntityRepository<Alumno>
 */
class AlumnoRepository extends ServiceEntityRepository
{
    private EntityManagerInterface $entityManager;

    public function __construct(ManagerRegistry $registry, EntityManagerInterface $entityManager)
    {
        parent::__construct($registry, Alumno::class);
        $this->entityManager = $entityManager;
    }

    /**
     * @return Alumno[] Returns an array of Alumno objects
     */
    public function findByApellidos($value): array
    {
        return $this->createQueryBuilder('a')
            ->andWhere('a.apellidos = :val')
            ->setParameter('val', $value)
            ->orderBy('a.id', 'ASC')
            ->getQuery()
            ->getResult();
    }

    /**
     * Save the Alumno entity to the database.
     */
    public function save(Alumno $alumno): void
    {
        $this->entityManager->persist($alumno);
        $this->entityManager->flush();
    }

    /**
     * Flush changes to the database.
     */
    public function flush(): void
    {
        $this->entityManager->flush();
    }
}
