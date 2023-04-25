package métier;

import java.io.*;

public class Profil implements ISaveLoad, Serializable {
    private String pseudo;
    private int niveau;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Profil()
    {
        pseudo="Pas de pseudo";
        niveau=0;
        avatar="Pas d'avatar";
    }
    public Profil(String vPseudo, int vNiveau, String vAvatar)
    {
        pseudo=vPseudo;
        niveau=vNiveau;
        avatar=vAvatar;
    }

    public void Affiche()
    {
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "\nPseudo : " + getPseudo() + "\nNiveau : " + getNiveau() + "\nAvatar : " +getAvatar();
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profil profil = (Profil) obj;
        if(getPseudo().equals(profil.getPseudo()) && getNiveau() == profil.getNiveau() && getAvatar().equals(profil.getAvatar()))
        {
            return true;
        }
        return false;
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
