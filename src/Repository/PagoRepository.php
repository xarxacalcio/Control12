<?php

namespace App\Repository;

use App\Entity\Pago;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Pago>
 */
class PagoRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Pago::class);
    }

    //    /**
    //     * @return Pago[] Returns an array of Pago objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('p')
    //            ->andWhere('p.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('p.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?Pago
    //    {
    //        return $this->createQueryBuilder('p')
    //            ->andWhere('p.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }

    public function save(Pago $pago): void
    {
        $entityManager = $this->getEntityManager();
        $entityManager->flush();
    }
    public function findAllPagosWithSelectedFields(): array
    {
        return $this->createQueryBuilder('p')
            ->select('p.id', "CONCAT(a.nombre, ' ', a.apellidos) AS nombre", 'p.fecha', 'p.importe')
            ->join('p.alumno', 'a')
            ->orderBy('p.fecha', 'DESC')
            ->getQuery()
            ->getResult();
    }
}
