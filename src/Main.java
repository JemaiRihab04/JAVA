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

        Animal lion = new Animal("Felidae", "Simba", 5, true);

        Zoo myZoo = new Zoo(nom, "Tunis", cages);


        myZoo.animals[0] = lion;


        myZoo.displayZoo();
        System.out.println(myZoo); // appelle automatiquement obj.toString() toString() est héritée de Object.
        System.out.println(myZoo.toString());

        lion.displayAnimal();
        System.out.println(lion);

        System.out.println(lion.toString());

        sc.close();
    }
}
