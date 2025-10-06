<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

final class ServiceController extends AbstractController
{
    #[Route('/service', name: 'app_service')]
    public function index(): Response
    {
        return $this->render('service/index.html.twig', [
            'controller_name' => 'ServiceController',
        ]);
    }

    #[Route('/show/{name}', name: 'showname')]
    public function showService($name): Response
    {
        return new Response('service'.$name)
       ;
    }
    #[Route('/goToIndex/{name}', name: 'index ')]
    public function goToIndex($name): Response
    {
        return $this->redirectToRoute('showname', [
            'name' => $name
        ]);

       
    }

    #[Route('/go-home', name: 'service_go_home')]
public function goToIndex2(): Response
{
    
    return $this->redirectToRoute('bienvenue_etud'); // jeya mn class  AbstractController
}



}
