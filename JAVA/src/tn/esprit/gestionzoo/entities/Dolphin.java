package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin() {
        super();
    }
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed)
            throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }


    public String toString() {
        return super.toString() + ", Vitesse de nage : " + swimmingSpeed + " km/h";
    }

    public void swim() {

        System.out.println(getName() + " nage rapidement et saute hors de l'eau !");
    }
}


