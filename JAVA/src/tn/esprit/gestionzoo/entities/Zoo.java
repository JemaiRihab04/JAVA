package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals = new Animal[25];
    private String name;
    private String city;
    private  int NBR_CAGES = 25;

    int compteur = 0;
    //s7
    private int aquaticCount = 0;
    private Aquatic[] aquaticAnimals = new Aquatic[10];



    public Zoo(String name, String city) {
        setName(name);
        this.city = city;

    }
    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.NBR_CAGES = nbrCages;
        this.animals = new Animal[nbrCages];
    }



    public String getName() { return name; }
    public String getCity() { return city; }
    public int getNbrCages() { return NBR_CAGES; }
    public int getCompteur() { return compteur; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : le nom du zoo ne peut pas être vide !");
            this.name = "Zoo Inconnu";
    }
        }

    public void setCity(String city) { this.city = city; }


    public void displayZoo() {
        System.out.println("Zoo : " + this.name + ", Ville : " + this.city + ", Nombre de cages : " + this.NBR_CAGES);
    }
    //Redéfinir toString() permet que l’affichage soit lisible et compréhensible.
    public String toString() {
        return "Zoo : " + name + ", Ville : " + city + ", Nombre de cages : " + NBR_CAGES;
    }

    /*public boolean addAnimal(Animal animal) {

        if (isZooFull()) {
            System.out.println("Impossible d'ajouter l'animal : le zoo est plein !");
            return false;
        }


        for (int i = 0; i < compteur; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("Impossible d'ajouter l'animal : il existe déjà dans le zoo !");
                return false;
            }
        }


        animals[compteur] = animal;
        compteur++;
        return true;
    }*/
    /*public void addAnimal(Animal animal) throws ZooFullException {
        if (isZooFull()) {
            throw new ZooFullException("Impossible d'ajouter l'animal : le zoo est plein !");
        }

        animals[compteur] = animal;
        compteur++;

        System.out.println("Animal ajouté : " + animal.getName() + ". Nombre total : " + compteur);
    }*/
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("L'âge de l'animal ne peut pas être négatif !");
        }

        if (isZooFull()) {
            throw new ZooFullException("Impossible d'ajouter l'animal : le zoo est plein !");
        }

        animals[compteur] = animal;
        compteur++;
        System.out.println("Animal ajouté : " + animal.getName() + ". Nombre total : " + compteur);
    }






    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        for (int i = 0; i < compteur; i++) {
            System.out.println("- " + animals[i].getName());
        }
    }
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < compteur; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }
    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < compteur; i++) {

            if (animals[i].getName().equals(animal.getName())) {

                for (int j = i; j < compteur - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[compteur - 1] = null;
                compteur--;
                return true;
            }
        }
        return false; // animal non trouvé
    }
    public boolean isZooFull() {
        return compteur >= NBR_CAGES;
    }
    public   static Zoo   comparerZoo(Zoo z1, Zoo z2) {
        if (z1.compteur >= z2.compteur) {
            return z1;
        } else {
            return z2;
        }
    }
    // s7
    public void addAquaticAnimal(Aquatic aquatic) {

        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("Impossible d'ajouter l'animal aquatique : espace plein !");
            return;
        }

        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        System.out.println(aquatic.getName() + " a été ajouté dans la zone aquatique.");
    }
    public void displaySwim() {
        System.out.println("Les animaux aquatiques nagent :");
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Pingouin) {
                Pingouin p = (Pingouin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > maxDepth) {
                    maxDepth = p.getSwimmingDepth();
                }
            }
        }

        return maxDepth;
    }
    public void displayNumberOfAquaticsByType() {
        int dolphinsCount = 0;
        int penguinsCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinsCount++;
            } else if (aquaticAnimals[i] instanceof Pingouin) {
                penguinsCount++;
            }
        }

        System.out.println("Nombre de dauphins : " + dolphinsCount);
        System.out.println("Nombre de pingouins : " + penguinsCount);
    }






}
