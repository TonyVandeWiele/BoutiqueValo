package Model;

import java.io.Serializable;
import java.util.Objects;
import java.io.*;

public class Skin implements ISaveLoad, Serializable
{
    private String nom;
    private String image;
    private  Rarete rarete;

    public Skin()
    {
        nom="Pas de Nom";
        rarete= Rarete.commun;
        image="Pas de Repertoire";
    }
    public Skin(String vNom, Rarete vRarete,String vImage)
    {
        nom=vNom;
        rarete=vRarete;
        image=vImage;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
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
        System.out.println("\n Nom : " + getNom() + "  Rareté : " + getRarete() +
                            "  Repertoire Image : " + getImage());
    }

    @Override
    public String toString() {
        return "Skin{" +
                "nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", rarete=" + rarete +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Skin skin = (Skin) obj;
        if (Objects.equals(nom, skin.nom) && Objects.equals(image, skin.image) && rarete == skin.rarete)
        {
            return true;
        }
        return false;
    }

    public String toCsv() {
        return nom + "," + rarete + "," + image;
    }

    public Object Load(String csv) {
        String[] parts = csv.split(",");
        String nom = parts[0];
        Rarete rarete = Rarete.valueOf(parts[1]);
        String image = parts[2];
        return new Skin(nom, rarete, image);
    }

    public void Save(String filename, Object obj) throws IOException {
        try {
            Skin skin = (Skin) obj;
            FileWriter writer = new FileWriter(filename);
            writer.write(skin.toCsv() + "\n");
            writer.close();
        }
        catch ( Exception I)
        {
            return;
        }
    }
}
