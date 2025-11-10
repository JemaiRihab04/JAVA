package services;

import entities.Employe;
import interfaces.IGestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {

    private ArrayList<Employe> employes;


    public SocieteArrayList() {
        employes = new ArrayList<>();
    }


    @Override
    public void ajouterEmploye(Employe e) {
        employes.add(e);
    }


    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean rechercherEmploye(Employe e) {
        return employes.contains(e); // utilise equals() d'Employe
    }


    @Override
    public void supprimerEmploye(Employe e) {
        employes.remove(e);
    }


    @Override
    public void displayEmploye() {
        for (Employe e : employes) {
            System.out.println(e);
        }
    }


    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
    }


    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(employes, new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int res = e1.getNom().compareTo(e2.getNom());
                if (res != 0) return res;

                res = e1.getNomDepartement().compareTo(e2.getNomDepartement());
                if (res != 0) return res;

                return e1.getGrade() - e2.getGrade();
            }
        });
    }
}
