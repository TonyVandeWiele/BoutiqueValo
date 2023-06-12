package Model;

import java.io.*;
import java.time.LocalDateTime;

public class Profil implements ISaveLoad, Serializable {
    private String pseudo;
    private String avatar;
    private float argent;
    private LocalDateTime datecreationProfil;

    public String getAvatar() { return avatar;}
    public String getPseudo() { return pseudo; }
    public float getArgent() { return argent; }
    public LocalDateTime getdateCreationProfil() { return datecreationProfil; }

    public void setArgent(float argent) {
        if(argent < 0)
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        this.argent = argent;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Profil()
    {
        pseudo="Pas de pseudo";
        avatar="Pas d'avatar";
        argent=0;
        datecreationProfil = LocalDateTime.now();
    }
    public Profil(String vPseudo, String vAvatar, float vArgent)
    {
        pseudo=vPseudo;
        avatar=vAvatar;
        argent=vArgent;
        datecreationProfil = LocalDateTime.now();
    }

    public void Affiche()
    {
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "\nPseudo : " + getPseudo() + "\nArgent" + getArgent() + "\nAvatar : " +getAvatar() + "\nDate création : " + getdateCreationProfil();
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profil profil = (Profil) obj;
        if(getPseudo().equals(profil.getPseudo()) && getAvatar().equals(profil.getAvatar()) && getdateCreationProfil().equals(profil.getdateCreationProfil()))
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
