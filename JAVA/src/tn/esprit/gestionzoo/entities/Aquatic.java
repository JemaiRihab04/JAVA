package tn.esprit.gestionzoo.entities;
import tn.esprit.gestionzoo.interfaces.Carnivore;

public abstract  class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic() {
        super();
    }
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String toString() {
        return super.toString() + ", Habitat : " + habitat;
    }
    public abstract void swim();
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aquatic other = (Aquatic) obj;
        return this.getName().equals(other.getName()) &&
                this.getAge() == other.getAge() &&
                this.habitat.equals(other.habitat);
    }
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT) {
            System.out.println(getName() + " mange de la viande ");
        } else {
            System.out.println(getName() + " ne mange pas ça ");
        }
    }
}
