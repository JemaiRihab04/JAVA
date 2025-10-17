<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\BookRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\RedirectResponse;
use App\Entity\Book;
use App\Form\BookType;
use App\Repository\AuthorRepository;
use App\Entity\Author; 



final class BookController extends AbstractController
{
    #[Route('/book/controller/php', name: 'app_book_controller_php')]
    public function index(): Response
    {
        return $this->render('book_controller_php/index.html.twig', [
            'controller_name' => 'BookController',
        ]);
    }
    #[Route('/books', name: 'list_books')]
    public function listBooks(BookRepository $bookRepository): Response
    {
        
        $books = $bookRepository->findAll();

        
        return $this->render('book/list.html.twig', [
            'books' => $books
        ]);
    }

     #[Route('/book/delete/{id}', name: 'delete_book')]
    public function deleteBook($id, BookRepository $bookRepository, EntityManagerInterface $em): RedirectResponse

    {
        
        $book = $bookRepository->find($id);

        
             if ($book !== null) {
        $em->remove($book);
        $em->flush();
    }


        
        return $this->redirectToRoute('list_books'); 
    }
    #[Route('/book/add', name: 'add_book')]
public function addBook(Request $request, EntityManagerInterface $em): Response
{
    $book = new Book();

    $form = $this->createForm(BookType::class, $book, [
    'submit_label' => 'Ajouter', // label du bouton
]);
    $form->handleRequest($request);

    if ($form->isSubmitted() ) {
        $em->persist($book);
        $em->flush();

        return $this->redirectToRoute('list_books');
    }

    return $this->render('book/add.html.twig', [
        'form' => $form->createView()
    ]);
}
#[Route('/book/edit/{id}', name: 'edit_book')]
public function editBook(int $id, Request $request, BookRepository $bookRepository, EntityManagerInterface $em): Response
{
    
    $book = $bookRepository->find($id);

    if (!$book) {
        
        return $this->redirectToRoute('list_books');
    }

    
    $form = $this->createForm(BookType::class, $book, [
    'submit_label' => 'Mettre à jour', 
]);


    $form->handleRequest($request);

    
    if ($form->isSubmitted() ) {
        $em->persist($book); 
        $em->flush();        

        return $this->redirectToRoute('list_books');
    }

    
    return $this->render('book/edit.html.twig', [
        'form' => $form->createView(),
        'book' => $book
    ]);
}


    #[Route('/books/stats/{id}', name: 'books_stats')]
    public function showStats(BookRepository $bookRepository, AuthorRepository $authorRepository, $id): Response
    {
        
        $author = $authorRepository->find($id);

        
        $nbrBooksDQL = $bookRepository->getNbrBooksDQL();
        $nbrBooksQB  = $bookRepository->getNbrBooksQB();

        // Livres par auteur
        $booksByAuthorDQL = $bookRepository->getBooksByAuthorDQL($author);
        $booksByAuthorQB  = $bookRepository->getBooksByAuthorQB($author);

        return $this->render('book/stats.html.twig', [
            'nbrBooksDQL' => $nbrBooksDQL,
            'nbrBooksQB'  => $nbrBooksQB,
            'booksByAuthorDQL' => $booksByAuthorDQL,
            'booksByAuthorQB'  => $booksByAuthorQB,
            'author' => $author
        ]);
    }


}
