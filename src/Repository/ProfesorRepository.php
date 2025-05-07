<?php

namespace App\Repository;

use App\Entity\Profesor;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Doctrine\ORM\EntityManagerInterface;

/**
 * @extends ServiceEntityRepository<Profesor>
 */
class ProfesorRepository extends ServiceEntityRepository
{
    private EntityManagerInterface $entityManager;

    public function __construct(ManagerRegistry $registry, EntityManagerInterface $entityManager)
    {
        parent::__construct($registry, Profesor::class);
        $this->entityManager = $entityManager;
    }
   

        /**
        * @return Profesor[] Returns an array of Profesor objects
        */
    public function findByApellidos($value): array
        {
            return $this->createQueryBuilder('p')
               ->andWhere('p.apellidos = :val')
               ->setParameter('val', $value)
               ->orderBy('p.id', 'ASC')
               //->setMaxResults(100)
               ->getQuery()
            ->getResult()
        ;
        }
        public function save(Profesor $profesor): void
        {
            $this->entityManager->persist($profesor);
            $this->entityManager->flush();
        }
    //    public function findOneBySomeField($value): ?Profesor
    //    {
    //        return $this->createQueryBuilder('p')
    //            ->andWhere('p.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }

    public function flush(): void
    {
        $this->entityManager->flush();
    }
}
