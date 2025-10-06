<?php
namespace App\Controller; 

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response; // classe response 
use Symfony\Component\Routing\Attribute\Route;

final class StudentController extends AbstractController 
{
    #[Route('/student', name: 'app_student')] // chaque controller a une route et chaque route a une path (/student) et le nom du path (app_student)
    // annotation
    public function index(): Response //qui renvoie une réponse
    {
        return $this->render('student/index.html.twig', [ // fct trajaa l view (page) render trjaa page view w shnowa les parametres l bch nabaathhom fl view
            'controller_name' => 'StudentController', //controller_name variable /render tekhou page twig w tableau  d object 
        ]); // tableau  d object : des variables 
        // render trajaa page html.twig student/index.html.twig w tableau 'controller_name' => 'StudentController' 
    
    }
     
    #[Route('/student2', name: 'app_student2')]
    public function index2(): Response
    {
        $name = "Rihab";
        return $this->render('student/index.html.twig', [
            'name' => $name
        ]);
    }

// deux actions qui partagent le meme template twig student/index.html.twig donc il faut envoyer tous les deux les memes variables mais peut etre avec des contenus differentes
    #[Route('/student3', name: 'app_student3')]
public function index3(): Response
{
    return $this->render('student/index.html.twig', [
        'controller_name' => 'StudentController',
        'name' => 'Visiteur',
    ]);
}

#[Route('/student4', name: 'app_student4')]
public function index4(): Response
{
    return $this->render('student/index.html.twig', [
        'controller_name' => 'StudentController',
        'name' => 'Rihab',
    ]);
}



    //Chaque méthode doit avoir une route unique si tu veux y accéder depuis le navigateur. 
    #[Route('/path1', name: 'rihab')]
public function addStudent(): Response
{
    return new Response("added succc"); // jeya mn classe HttpFoundation
}




#[Route('/get/infoStudent', name: 'getI')] 
public function getIStudent(): Response 
 {   {
      return new Response("info student");
    } 






}
// routage avec parametre /student/parametre /student/3 /student/5 l parametre hedha ynajm ykoun name wle id... bch symfony yefhem {id}

#[Route('/get/{name}', name: 'getS')] 

public function getStudentName($name): Response 
 {   {
      return new Response("added succc ".$name);
    }
} 


// lezm les fonctions avec parametre nkhalehom ekher haja fl code 
 

//redirect to  route thezni l path ekher 
}






 
 

    
    
    
    
    
    
    