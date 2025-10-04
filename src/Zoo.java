public class Zoo {
    Animal[] animals = new Animal[25];
    String name;
    String city;
    int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + this.name + ", Ville : " + this.city + ", Nombre de cages : " + this.nbrCages);
    }
    //Redéfinir toString() permet que l’affichage soit lisible et compréhensible.
    public String toString() {
        return "Zoo : " + name + ", Ville : " + city + ", Nombre de cages : " + nbrCages;
    }
}
