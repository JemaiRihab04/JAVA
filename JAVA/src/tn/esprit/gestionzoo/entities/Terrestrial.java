package tn.esprit.gestionzoo.entities;
import tn.esprit.gestionzoo.interfaces.Omnivore;

public class Terrestrial extends Animal implements Omnivore<Food>{
    private int nbrLegs;

    public Terrestrial() {
        super();
    }
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs)
            throws InvalidAgeException{
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }
    public String toString() {
        return super.toString() + ", Nombre de pattes : " + nbrLegs;
    }

    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " mange de la viande ");
        } else {
            System.out.println(getName() + " ne mange pas de viande ");
        }
    }
    public void eatPlant(Food plant) {
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(getName() + " mange des plantes ");
        } else {
            System.out.println(getName() + " ne mange pas de plantes ");
        }
    }
    public void eatPlantAndMeet(Food food) {
        if (food == Food.BOTH) {
            System.out.println(getName() + " mange de tout ");
        } else {
            System.out.println(getName() + " préfère une nourriture mixte ");
        }
    }
}
