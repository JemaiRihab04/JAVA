<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;

use Symfony\Component\Routing\Attribute\Route;


use App\Entity\Author;
use App\Repository\AuthorRepository;
use Doctrine\Persistence\ManagerRegistry;

use Symfony\Component\HttpFoundation\Request;

use Symfony\Component\Form\Extension\Core\Type\TextType; //Classe fournie par Symfony pour créer un champ texte dans un formulaire.
use Symfony\Component\Form\Extension\Core\Type\EmailType; // Classe fournie par Symfony pour créer un champ email.
use Symfony\Component\Form\Extension\Core\Type\SubmitType; //Classe fournie par Symfony pour créer un bouton Envoyer ou Submit.

use App\Form\AuthorType;
use Doctrine\ORM\EntityManagerInterface;
use App\Entity\Book;




final class AuthorController extends AbstractController
{
    
    #[Route('/get2/{name}', name: 'show2')] 

public function ShowAuthor($name): Response 
 {   {
      return $this->render('author/index.html.twig', [
            'name' => $name
        ]);
    }
} 

  #[Route('/authors', name: 'list_authors')]
public function listAuthors(): Response
{
    $authors = [
        [
            'id' => 1,
            'picture' => 'images/Victor-Hugo.jpg',
            'username' => 'Victor Hugo',
            'email' => 'victor.hugo@gmail.com',
            'nb_books' => 100
        ],
        [
            'id' => 2,
            'picture' => 'images/william-shakespeare.jpg',
            'username' => 'William Shakespeare',
            'email' => 'william.shakespeare@gmail.com',
            'nb_books' => 200
        ],
        [
            'id' => 3,
            'picture' => 'images/Taha-Hussein.jpg',
            'username' => 'Taha Hussein',
            'email' => 'taha.hussein@gmail.com',
            'nb_books' => 300
        ],
    ];

    return $this->render('author/list.html.twig', [
        'authors' => $authors
    ]);
}

#[Route('/author/{id}', name: 'author_details')]
public function authorDetails($id): Response
{
    $authors = [
        ['id' => 1, 'picture' => 'images/Victor-Hugo.jpg', 'username' => 'Victor Hugo', 'email' => 'victor.hugo@gmail.com', 'nb_books' => 100],
        ['id' => 2, 'picture' => 'images/william-shakespeare.jpg', 'username' => 'William Shakespeare', 'email' => 'william.shakespeare@gmail.com', 'nb_books' => 200],
        ['id' => 3, 'picture' => 'images/Taha-Hussein.jpg', 'username' => 'Taha Hussein', 'email' => 'taha.hussein@gmail.com', 'nb_books' => 300],
    ];


    $author = $authors[$id - 1];

    return $this->render('author/showAuthor.html.twig', [
        'author' => $author
    ]);
}
// seance 5 ORM 

#[Route('/get', name: 'get_author')]
public function getAll(AuthorRepository $authRepo): Response 
{
    
    $authors = $authRepo->findAll();

    
    return $this->render('author/index.html.twig', [
        'authors' => $authors,
    ]);
}

#[Route('/author2/{id}', name: 'get_author_by_id')]
public function getById(AuthorRepository $authRepo, int $id): Response
{
    
    $author = $authRepo->find($id); 

    
    if (!$author) {
        throw $this->createNotFoundException("Auteur avec l'id $id non trouvé !");
    }

    
    return $this->render('author/index2.html.twig', [
        'author' => $author,
    ]);
}


    
#[Route('/add ', name: 'add_author')] 

public function addAuth(ManagerRegistry  $em): Response 
  {
    $auth1= new Author();
    $auth1->setUsername('author1');
    $auth1->setEmail('author1@esprit.tn');

    $auth2= new Author();
    $auth2->setUsername('author2');
    $auth2->setEmail('author2@esprit.tn');

    $em->getManager()->persist($auth1);
    $em->getManager()->persist($auth2);
    $em->getManager()->flush();





      return New Response ('Les auteurs ont été ajoutés avec succès !');
    }

   
    
    #[Route('/delete/{id}', name: 'delete_author')]
public function deleteAuthor(ManagerRegistry $em, AuthorRepository $authRepo, $id): Response
{
    
    $auth = $authRepo->find($id);

    
    if (!$auth) {
        return new Response('Auteur introuvable.');
    }

    
    $em->getManager()->remove($auth);
    $em->getManager()->flush();

    return new Response('Auteur supprimé avec succès.');
}


// rendu update 
#[Route('/update/{id}', name: 'update_author')]
public function updateAuthor(ManagerRegistry $em, AuthorRepository $authRepo, int $id): Response
{
    

    
    $author = $authRepo->find($id);

    if (!$author) {
        return new Response("Auteur avec l'id $id introuvable.");
    }

    
    $author->setUsername('nouveauUsername');
    $author->setEmail('nouveauEmail@esprit.tn');

    
    $em->getManager()->flush();

    return new Response("Auteur avec l'id $id mis à jour avec succès !");
}

//   1ère méthode: Création du formulaire dans le contrôleur

#[Route('/add-author', name: 'add_author')]
    public function addAuthor(Request $request): Response
    {
        // Création d'un objet Author
        $author = new Author();
        $author->setUsername('Écrire un nom d’utilisateur');
        $author->setEmail('email@example.com');

        // Création du formulaire lié à l'objet Author
        $form = $this->createFormBuilder($author) //createFormBuilder() permet de définir un formulaire
            ->add('username', TextType::class, [ //La méthode add() est utilisée dans Symfony pour ajouter des champs à un formulaire lors de sa création. 

                'label' => 'Nom d’utilisateur',
            ])
            ->add('email', EmailType::class, [
                'label' => 'Email',
            ])
            ->add('save', SubmitType::class, ['label' => 'Créer Auteur']) // save est le nom du bouton de soumission du formulaire.
            ->getForm();

        // Traitement de la soumission
        $form->handleRequest($request); 
        // classe Request :Dans les formulaires Symfony, elle est utilisée pour remplir automatiquement l’objet avec les données soumises.

        

        return $this->render('author/add.html.twig', [
            'form' => $form->createView(),
        ]);
    }
// 2eme methode 
#[Route('/add-author2', name: 'add_author2')]
    public function addAuthor2(Request $request, EntityManagerInterface $em): Response
    {
        
        $author = new Author();

        
        $form = $this->createForm(AuthorType::class, $author);

        // Récupère les données envoyées par le formulaire et remplir $author 
        $form->handleRequest($request);

        // Vérifie si le formulaire a été soumis 
        if ($form->isSubmitted()) {
            
            $em->persist($author); 
            $em->flush();          

            
            return $this->redirectToRoute('add_author2');
        }

        
        return $this->render('author/add.html.twig', [
            'form' => $form->createView(),
        ]);
    }
}

