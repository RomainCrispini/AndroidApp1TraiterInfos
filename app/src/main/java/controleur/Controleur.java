package controleur;

import modele.Personne;

public class Controleur {

    private static Controleur monInstance = null;
    private Personne maPersonne;

    // Constructeur du Controleur
    private Controleur(){
        super();
    }

    // Juste un Getter est nécessaire
    public static Controleur getMonInstance() {
        if(monInstance == null){
            Controleur.monInstance = new Controleur();
        }
        return monInstance;
    }

    public void creerPersonne(Integer iSexe, String strNom, Integer iAge){
        maPersonne = new Personne(iSexe, strNom, iAge);
    }

    public Personne getMaPersonne() {
        return maPersonne;
    }
}
