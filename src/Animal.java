public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;


    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    public void displayAnimal() {
        System.out.println("Animal : " + name + ", Famille : " + family + ", Âge : " + age + ", Mammifère : " + isMammal);
    }


    public String toString() {
        return "Animal : " + name + ", Famille : " + family + ", Âge : " + age + ", Mammifère : " + isMammal;
    }
}
