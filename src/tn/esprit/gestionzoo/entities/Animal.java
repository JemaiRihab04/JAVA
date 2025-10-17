package tn.esprit.gestionzoo.entities;

public class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;

    public Animal() { }


    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }
    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    public void setFamily(String family) { this.family = family; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur : l'âge d'un animal ne peut pas être négatif !");
            this.age = 0; // valeur par défaut
        }
    }

    public void setMammal(boolean isMammal) { this.isMammal = isMammal; }

    public void displayAnimal() {
        System.out.println("Animal : " + name + ", Famille : " + family + ", Âge : " + age + ", Mammifère : " + isMammal);
    }


    public String toString() {
        return "Animal : " + name + ", Famille : " + family + ", Âge : " + age + ", Mammifère : " + isMammal;
    }
}
