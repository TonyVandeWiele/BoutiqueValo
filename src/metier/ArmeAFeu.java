package metier;

import java.io.*;

public class ArmeAFeu extends Arme implements Serializable
{
    private int degatsTete;
    private int degatsCorps;
    private int portee;
    private int capaciteChargeur;
    public int getDegatsTete()
    {
        return degatsTete;
    }
    public int getDegatsCorps()
    {
        return degatsCorps;
    }
    public int getPortee()
    {
        return portee;
    }
    public int getCapaciteChargeur()
    {
        return capaciteChargeur;
    }
    public ArmeAFeu()
    {
        super();
        degatsTete=0;
        degatsCorps=0;
        portee=0;
        capaciteChargeur=0;
    }
    public ArmeAFeu(String vNom, Skin vSkin,Categorie vCategorie,float vPrix,int vDegTete,int vDegCorps,int vPortee,int vChargeur)
    {
        super(vNom, vSkin,vCategorie, vPrix);
        degatsTete=vDegTete;
        degatsCorps=vDegCorps;
        portee=vPortee;
        capaciteChargeur=vChargeur;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDegat dans la Tete : " + getDegatsTete() + "\nDegat dans le corps : " + getDegatsCorps()+ "\nPortée de l'arme : " + getPortee() + "\nCapacité du chargeur : " + getCapaciteChargeur();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ArmeAFeu armeAFeu = (ArmeAFeu) obj;
        if(super.equals(armeAFeu) && getDegatsTete() == armeAFeu.getDegatsTete() && getPortee() == armeAFeu.getPortee() && getCapaciteChargeur() == armeAFeu.getCapaciteChargeur())
        {
            return true;
        }
        return false;
    }

    public void Affiche()
    {
        System.out.println(toString());
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
