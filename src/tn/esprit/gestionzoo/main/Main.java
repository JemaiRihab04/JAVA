package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.ZooManagement;
import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Pingouin;
import tn.esprit.gestionzoo.entities.Terrestrial;


import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nom;
        int cages;


        do {
            System.out.print("Entrez le nom du zoo : ");
            nom = sc.nextLine();
            if (nom.trim().isEmpty()) {
                System.out.println("Erreur : le nom du zoo ne peut pas être vide !");
            }
        } while (nom.trim().isEmpty());


        do {
            System.out.print("Entrez le nombre de cages : ");

            cages = sc.nextInt();
            if (cages <= 0) {
                System.out.println("Erreur : le nombre de cages doit être positif !");
            }
        } while (cages <= 0);

        ZooManagement zoo = new ZooManagement();

        zoo.setZooName(nom);
        zoo.setNbrCages(cages);

        System.out.println("Le nom du zoo : " + zoo.getZooName()+ " et il contient " + zoo.getNbrCages() + " cages.");

        /*Animal lion = new Animal();
        lion.family = "Felidae";
        lion.name = "Simba";
        lion.age = 5;
        lion.isMammal = true;*/


        /*Zoo myZoo = new Zoo();
        myZoo.name = "myZoo";
        myZoo.city = "Tunis";
        myZoo.nbrCages = 20;


        myZoo.animals[0] = lion;*/

        Animal lion1 = new Animal("Felidae", "Simba", 5, true);
        Animal lion2 = new Animal("Felidae", "Simba", 5, true);
        Animal tigre = new Animal("Felidae", "Shere Khan", 4, true);
        Animal elephant = new Animal("Elephantidae", "Dumbo", 10, true);

        Zoo myZoo = new Zoo(nom, "Tunis");


        // fct ajouter
        System.out.println(myZoo.addAnimal(lion1));
        System.out.println(myZoo.addAnimal(lion2));
        System.out.println(myZoo.addAnimal(tigre));
        System.out.println(myZoo.addAnimal(elephant));

        myZoo.displayAnimals();
        // fct rechercher
        int index = myZoo.searchAnimal(lion2);
        System.out.println("Indice du lion : " + index);

        System.out.println("Avant suppression :");
        myZoo.displayAnimals();

        boolean result = myZoo.removeAnimal(lion1);
        System.out.println("Suppression du lion réussie ? " + result);

        System.out.println("Après suppression :");
        myZoo.displayAnimals();

        if (myZoo.isZooFull()) {
            System.out.println("Le zoo est plein !");
        } else {
            System.out.println("Il reste de la place dans le zoo.");
        }
        Zoo zoo1 = new Zoo("Safari Park", "Tunis");
        Zoo zoo2 = new Zoo("Animal Kingdom", "Sousse");
        zoo1.addAnimal(new Animal("Felidae", "Simba2", 5, true));
        zoo1.addAnimal(new Animal("Canidae", "Rex", 3, true));

        zoo2.addAnimal(new Animal("Felidae", "Shere Khan2", 4, true));
        Zoo zooPlusGrand = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Le zoo avec le plus d'animaux est : " + zooPlusGrand.getName());




        //myZoo.animals[0] = lion;


        myZoo.displayZoo();
        System.out.println(myZoo); // appelle automatiquement obj.toString() toString() est héritée de Object.
        System.out.println(myZoo.toString());

        lion1.displayAnimal();
        System.out.println(lion1);

        System.out.println(lion1.toString());


        // atelier 5
        Animal a = new Animal();
        Aquatic aq = new Aquatic();
        Terrestrial t = new Terrestrial();
        Dolphin d = new Dolphin();
        Pingouin p = new Pingouin();


        Aquatic aquatic = new Aquatic("Poisson", "Requin", 5, false, "Océan");
        Terrestrial terrestrial = new Terrestrial("Canidé", "Chien", 4, true, 4);
        Dolphin dolphin = new Dolphin("Cétacé", "Dauphin", 8, true, "Mer", 25.5f);
        Pingouin pingouin = new Pingouin("Oiseau", "Pingouin", 2, false, "Antarctique", 15.0f);

        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(pingouin);

        aquatic.swim();
        dolphin.swim();
        pingouin.swim(); //La classe Penguin hérite la méthode swim() de Aquatic → elle affiche le même message que Aquatic.

        sc.close();
    }
}
