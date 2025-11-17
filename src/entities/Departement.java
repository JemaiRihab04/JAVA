package entities;

import java.util.Objects;

public class Departement implements Comparable<Departement> {

    private int id;
    private String nom;
    private int nombreEmployes;


    public Departement() {}


    public Departement(int id, String nom, int nombreEmployes) {
        this.id = id;
        this.nom = nom;
        this.nombreEmployes = nombreEmployes;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getNombreEmployes() { return nombreEmployes; }
    public void setNombreEmployes(int nombreEmployes) { this.nombreEmployes = nombreEmployes; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        Departement d = (Departement) o;
        return id == d.id && Objects.equals(nom, d.nom);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }


    @Override
    public int compareTo(Departement d) {
        return this.id - d.id;
    }


    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nombreEmployes=" + nombreEmployes +
                '}';
    }
}
