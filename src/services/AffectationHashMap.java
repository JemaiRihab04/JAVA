package services;

import entities.Employe;
import entities.Departement;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AffectationHashMap {


    private Map<Employe, Departement> affectations;


    public AffectationHashMap() {
        affectations = new HashMap<>();
    }


    public void ajouterEmployeDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e)) {
            System.out.println("Attention : L'employé " + e.getNom() + " est déjà affecté au département "
                    + affectations.get(e).getNom() + ". La nouvelle affectation remplacera l'ancienne.");
        }
        affectations.put(e, d);
    }


    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation trouvée.");
            return;
        }
        System.out.println("--- Employés et leurs départements ---");
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println(entry.getKey().getNom() + " -> " + entry.getValue().getNom());
        }
    }


    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }


    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        } else {
            System.out.println("L'employé " + e.getNom() + " n'est pas affecté au département " + d.getNom());
        }
    }

    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé trouvé.");
            return;
        }
        System.out.println("--- Liste des employés ---");
        for (Employe e : affectations.keySet()) {
            System.out.println(e.getNom());
        }
    }


    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département trouvé.");
            return;
        }
        System.out.println("--- Liste des départements ---");
        for (Departement d : affectations.values()) {
            System.out.println(d.getNom());
        }
    }


    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }


    public TreeMap<Employe, Departement> trierMap() {
        return new TreeMap<>(affectations);
    }
}
