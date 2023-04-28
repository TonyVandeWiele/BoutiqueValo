package metier;
import java.io.*;

abstract class Arme implements ISaveLoad, Serializable
{
    private String nom;
    private Skin skin;
    private Categorie categorie;
    private float prix;

    public Arme()
    {
        nom="Pas de Nom";
        skin = new Skin();
        categorie=Categorie.Assaut;
        prix=0;
    }
    public Arme(String vNom,Skin vSkin,Categorie vCategorie,float vPrix)
    {
        nom=vNom;
        skin=vSkin;
        categorie=vCategorie;
        prix=vPrix;
    }
    public String getNom()
    {
        return nom;
    }
    public Categorie getCategorie()
    {
        return categorie;
    }
    public  float getPrix() { return prix; }

    public Skin getSkin() { return skin; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public void setCategorie(Categorie Categorie) {
        this.categorie = Categorie;
    }

    public void setSkin(Skin skin) { this.skin = skin; }


    public String toString()
    {
        return "\nNom :" + getNom() + "\nSkin : " + getSkin() + "\nCategorie :" + getCategorie() + "\nPrix :"+getPrix();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Arme arme = (Arme) obj;
        if(getNom().equals(arme.getNom()) && getCategorie().equals(arme.getCategorie()) && getSkin().equals(arme.getSkin()) && getPrix() == arme.getPrix())
        {
            return true;
        }
        return false;
    }
    public void Affiche()
    {
        System.out.println("Voici une arme : " + toString());
    }

    public void Save(String filename, Object obj) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            System.out.println("L'objet a été sauvegardé avec succès dans le fichier binaire " + filename);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la sauvegarde de l'objet dans le fichier binaire " + filename);
            e.printStackTrace();
        }
    }

    public Object Load(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            ois.close();
            fis.close();
            System.out.println("L'objet a été chargé avec succès depuis le fichier binaire " + filename);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Une erreur est survenue lors du chargement de l'objet depuis le fichier binaire " + filename);
            e.printStackTrace();
            return null;
        }
    }
}
