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

        zoo.zooName = nom;
        zoo.nbrCages = cages;

        System.out.println("Le nom du zoo : " + zoo.zooName + " et il contient " + zoo.nbrCages + " cages.");

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

        sc.close();
    }
}
