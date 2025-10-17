<?php

namespace App\Repository;

use App\Entity\Book;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use App\Entity\Author; 


/**
 * @extends ServiceEntityRepository<Book>
 */
class BookRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Book::class);
    }

    //    /**
    //     * @return Book[] Returns an array of Book objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('b')
    //            ->andWhere('b.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('b.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?Book
    //    {
    //        return $this->createQueryBuilder('b')
    //            ->andWhere('b.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }
    //DQL
     public function getNbrBooksDQL()
    {
        $em = $this->getEntityManager();
        $query = $em->createQuery("SELECT COUNT(b.id) FROM App\Entity\Book b");
        return $query->getResult(); //tableau contenant une seule colonne nombre des livres


    }
//Version QueryBuilder 
    public function getNbrBooksQB()
    {
        $qb = $this->createQueryBuilder('b')
                   ->select('COUNT(b.id)');
        return $qb->getQuery()->getResult(); //tableau contenant une seule colonne nombre des livres

    }
    // Livres par auteur (DQL)
    public function getBooksByAuthorDQL(Author $author)
    {
        $em = $this->getEntityManager();
        $query = $em->createQuery("SELECT b FROM App\Entity\Book b WHERE b.author = :author");
        $query->setParameter('author', $author);
        return $query->getResult(); // retourne un tableau d'objets Book
    }

    // Livres par auteur (QueryBuilder)
    public function getBooksByAuthorQB(Author $author)
    {
        $qb = $this->createQueryBuilder('b')
                   ->where('b.author = :author')
                   ->setParameter('author', $author);
        return $qb->getQuery()->getResult();
    }

}
