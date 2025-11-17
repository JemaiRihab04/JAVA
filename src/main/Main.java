package main;

import entities.Employe;
import services.SocieteArrayList;
import entities.Departement;
import services.DepartementHashSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        SocieteArrayList societe = new SocieteArrayList();


        Employe e1 = new Employe(101, "Ben Ali", "Ali", "Informatique", 2);
        Employe e2 = new Employe(102, "Haddad", "Sami", "Finance", 1);
        Employe e3 = new Employe(103, "Ben Ali", "Sara", "Marketing", 3);
        Employe e4 = new Employe(104, "Kacem", "Omar", "Informatique", 2);

        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);

        System.out.println("=== Liste des employés ===");
        societe.displayEmploye();


        System.out.println("\nRecherche employé nom 'Ben Ali' : " + societe.rechercherEmploye("Ben Ali"));
        System.out.println("Recherche employé e2 : " + societe.rechercherEmploye(e2));

        societe.trierEmployeParId();
        System.out.println("\n=== Liste triée par ID ===");
        societe.displayEmploye();


        societe.trierEmployeParNomDépartementEtGrade();
        System.out.println("\n=== Liste triée par Nom, Département et Grade ===");
        societe.displayEmploye();


        societe.supprimerEmploye(e3);
        System.out.println("\n=== Liste après suppression de e3 ===");
        societe.displayEmploye();
        // atelier 10
        DepartementHashSet gestion = new DepartementHashSet();
        Departement d1 = new Departement(3, "IT", 30);
        Departement d2 = new Departement(1, "RH", 15);
        Departement d3 = new Departement(2, "Finance", 20);
        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);

        System.out.println("LISTE DES DÉPARTEMENTS :");
        gestion.displayDepartement();

        System.out.println("Recherche du département IT : " +
                gestion.rechercherDepartement("IT"));


        System.out.println("\n TRI PAR ID (TreeSet) :");
        TreeSet<Departement> sorted = gestion.trierDepartementById();
        for (Departement d : sorted) {
            System.out.println(d);
        }

        System.out.println("Suppression du département RH...");
        gestion.supprimerDepartement(d2);

        System.out.println("\n LISTE APRÈS SUPPRESSION :");
        gestion.displayDepartement();




    }
}
