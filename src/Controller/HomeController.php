<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
final class HomeController extends AbstractController 
{
    #[Route('/etudiant', name: 'bienvenue_etud')] // chaque controller a une route et chaque route a une path (/student) et le nom du path (app_student)
    public function index(): Response //qui renvoie une réponse
    {
        return new Response("Bonjour mes étudiants"); 
    }


    
}