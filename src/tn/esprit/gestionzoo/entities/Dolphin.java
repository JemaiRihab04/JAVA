package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic{
    private float swimmingSpeed;

    public Dolphin() {
        super();
    }
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat); // appel du constructeur Aquatic
        this.swimmingSpeed = swimmingSpeed;
    }
    public String toString() {
        return super.toString() + ", Vitesse de nage : " + swimmingSpeed + " km/h";
    }
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }
}
