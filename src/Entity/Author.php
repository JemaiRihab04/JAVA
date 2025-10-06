<?php

namespace App\Entity;

use App\Repository\AuthorRepository;
use Doctrine\ORM\Mapping as ORM; //orm jeya mn classe doctrine

#[ORM\Entity(repositoryClass: AuthorRepository::class)] 
class Author
{ 
    #[ORM\Id] // id est la clee primaire de la table  
    #[ORM\GeneratedValue] // id auto increment
    #[ORM\Column] 
    private ?int $id = null;

    

    #[ORM\Column(length: 255)]
    private ?string $email = null;

    

    #[ORM\Column(length: 255)]
    private ?string $username = null;

    public function getId(): ?int
    {
        return $this->id;
    }

   

    

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): static
    {
        $this->email = $email;

        return $this;
    }

   
    public function getUsername(): ?string
    {
        return $this->username;
    }

    public function setUsername(string $username): static
    {
        $this->username = $username;

        return $this;
    }
}
