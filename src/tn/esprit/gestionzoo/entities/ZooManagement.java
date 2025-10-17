package tn.esprit.gestionzoo.entities;
import java.util.Scanner;
public class ZooManagement {
    private  int nbrCages ;
    private  String zooName ;

    // Getter
    public String getZooName() {
        return zooName;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    // Setter
    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public void setNbrCages(int nbrCages) {
        this.nbrCages = nbrCages;
    }
}
