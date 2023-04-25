package métier;

import java.io.Serializable;
import java.util.Objects;

public class Skin implements Serializable
{
    private String nom;
    private int prix;
    private String image;
    private  Rarete rarete;

    public Skin()
    {
        nom="Pas de Nom";
        prix=0;
        rarete=Rarete.commun;
        image="Pas de Repertoire";
    }
    public Skin(String vNom, int vPrix, Rarete vRarete,String vImage)
    {
        nom=vNom;
        prix=vPrix;
        rarete=vRarete;
        image=vImage;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public int getPrix() {
        return prix;
    }
    public String getImage() {
        return image;
    }
    public String getNom() {
        return nom;
    }
    public Rarete getRarete() {
        return rarete;
    }

    public void Affiche()
    {
        System.out.println("\n Nom : " + getNom() + "  Prix : " + getPrix() + "  Rareté : " + getRarete() +
                            "  Repertoire Image : " + getImage());
    }

    @Override
    public String toString() {
        return "Skin{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", image='" + image + '\'' +
                ", rarete=" + rarete +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Skin skin = (Skin) obj;
        if (prix == skin.prix && Objects.equals(nom, skin.nom) && Objects.equals(image, skin.image) && rarete == skin.rarete)
        {
            return true;
        }
        return false;
    }
}
