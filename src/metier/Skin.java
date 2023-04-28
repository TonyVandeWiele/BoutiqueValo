package metier;

import java.io.*;
import java.util.Objects;

public class Skin implements Serializable {
    private String nom;
    private String image;
    private Rarete rarete;

    public Skin() {
        nom = "Pas de Nom";
        rarete = Rarete.commun;
        image = "Pas de Repertoire";
    }

    public Skin(String vNom, Rarete vRarete, String vImage) {
        nom = vNom;
        rarete = vRarete;
        image = vImage;
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

    public void Affiche() {
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
        if (Objects.equals(nom, skin.nom) && Objects.equals(image, skin.image) && rarete == skin.rarete) {
            return true;
        }
        return false;
    }

    public String toCsv() {
        return nom + "," + rarete + "," + image;
    }

    public static Skin LoadCsv(String csv) {
        String[] parts = csv.split(",");
        String nom = parts[0];
        Rarete rarete = Rarete.valueOf(parts[1]);
        String image = parts[2];
        return new Skin(nom, rarete, image);
    }

    public static void saveSkinsToCsv(String filename, Skin skins) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(skins.toCsv() + "\n");
        writer.close();
    }

    public static Skin[] loadSkinsFromCsv(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            count++;
        }
        bufferedReader.close();
        reader = new FileReader(filename);
        bufferedReader = new BufferedReader(reader);
        Skin[] skins = new Skin[count];

    }

}
