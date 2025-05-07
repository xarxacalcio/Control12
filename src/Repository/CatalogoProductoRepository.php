<?php

namespace App\Repository;

use App\Entity\CatalogoProducto;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Doctrine\ORM\EntityManagerInterface;

/**
 * @extends ServiceEntityRepository<CatalogoProducto>
 */
class CatalogoProductoRepository extends ServiceEntityRepository
{
    private EntityManagerInterface $entityManager;

    public function __construct(ManagerRegistry $registry, EntityManagerInterface $entityManager)
    {
        parent::__construct($registry, CatalogoProducto::class);
        $this->entityManager = $entityManager;
    }

    /**
     * @return CatalogoProducto[] Returns an array of CatalogoProducto objects
     */
    public function findByNombre($value): array
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.nombre = :val')
            ->setParameter('val', $value)
            ->orderBy('c.id', 'ASC')
            ->getQuery()
            ->getResult();
    }

    /**
     * Save the CatalogoProducto entity to the database.
     */
    public function save(CatalogoProducto $catalogoProducto): void
    {
        $this->entityManager->persist($catalogoProducto);
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
