package modele;

public class Personne {

    private Integer iSexePersonne;
    private Integer iAgePersonne;
    private String strNomPersonne;

    // Constructeurs
    public Personne(Integer iSexe, String strNom, Integer iAge) {
        super();
    }

    public Personne(Integer iSexePersonne, Integer iAgePersonne, String strNomPersonne) {
        super();
        this.iSexePersonne = iSexePersonne;
        this.iAgePersonne = iAgePersonne;
        this.strNomPersonne = strNomPersonne;
    }

    // Getters et Setters
    public Integer getiSexePersonne() {
        return iSexePersonne;
    }

    public void setiSexePersonne(Integer iSexePersonne) {
        this.iSexePersonne = iSexePersonne;
    }

    public Integer getiAgePersonne() {
        return iAgePersonne;
    }

    public void setiAgePersonne(Integer iAgePersonne) {
        this.iAgePersonne = iAgePersonne;
    }

    public String getStrNomPersonne() {
        return strNomPersonne;
    }

    public void setStrNomPersonne(String strNomPersonne) {
        this.strNomPersonne = strNomPersonne;
    }



}
