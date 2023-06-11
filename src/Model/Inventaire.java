package Model;

import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Inventaire
{
    private static Inventaire INSTANCE = null;
    private ArrayList<ArmeAFeu> AssautList;
    private ArrayList<ArmeAFeu> SMGList;
    private ArrayList<ArmeAFeu> SniperList;
    private ArrayList<ArmeCAC> CACList;
    private ArrayList<Skin> SkinList;
    private ArrayList<Arme> BoutiqueList;
    private Profil User;

    public Inventaire() {
        AssautList = new ArrayList<>();
        SMGList = new ArrayList<>();
        SniperList = new ArrayList<>();
        CACList = new ArrayList<>();
        BoutiqueList = new ArrayList<>();
        SkinList = new ArrayList<>();
    }

    public static Inventaire getInstance() {
        if(INSTANCE == null)
        {
            INSTANCE = new Inventaire();
        }
        return INSTANCE;
    }

    public ArrayList<ArmeAFeu> getAssautList() {
        return AssautList;
    }
    public ArrayList<ArmeAFeu> getSMGList() {
        return SMGList;
    }
    public ArrayList<ArmeAFeu> getSniperList() { return SniperList; }
    public ArrayList<ArmeCAC> getCACList() { return CACList; }
    public ArrayList<Arme> getBoutiqueList() {
        return BoutiqueList;
    }
    public ArrayList<Skin> getSkinList() { return SkinList; }
    public Profil getUser() { return User; }

    public void setAssautList(ArrayList<ArmeAFeu> assautList) {
        AssautList = assautList;
    }

    public <T extends Arme> void AjouterArme(int choix, T arme)
    {
        if(choix == 1)
        {
            if(arme instanceof ArmeAFeu)
            {
                if(arme.getCategorie().equals(Categorie.Assaut))
                {
                    getAssautList().add((ArmeAFeu) arme);
                } else if (arme.getCategorie().equals(Categorie.SMG)) {
                    getSMGList().add((ArmeAFeu) arme);
                }
                else if (arme.getCategorie().equals(Categorie.Sniper)){
                    getSniperList().add((ArmeAFeu) arme);
                }
            } else if (arme instanceof ArmeCAC) {
                getCACList().add((ArmeCAC) arme);
            }
        }
        else
        {
            if(arme instanceof Arme)
            {
                getBoutiqueList().add(arme);
            }
        }
    }
    public <T extends Arme> void SupprimerArme(T arme)
    {
        if(arme instanceof ArmeAFeu)
        {
            if(arme.getCategorie().equals(Categorie.Assaut))
            {
                getAssautList().remove((ArmeAFeu) arme);
            } else if (arme.getCategorie().equals(Categorie.SMG)) {
                getSMGList().remove((ArmeAFeu) arme);
            }
            else if (arme.getCategorie().equals(Categorie.Sniper)) {
                getSniperList().remove((ArmeAFeu) arme);
            }
        } else if (arme instanceof ArmeCAC) {
            getCACList().remove((ArmeCAC) arme);
        }
    }

    public void setUser(String pseudo, String avatar, float argent)
    {
        User = new Profil(pseudo,avatar,argent);
    }
    public void AjouterArgent(float argent)
    {
        getUser().setArgent(getUser().getArgent() + argent);
    }
    public void RetirerArgent(float argent)
    {
        getUser().setArgent(getUser().getArgent() - argent);
    }

    public void SaveListFeu(ArrayList<ArmeAFeu> armeAFeuList, String nomFichier)
    {
        try
        {
            // Créer un flux de sortie pour écrire les données binaires dans le fichier
            FileOutputStream fichierSortie = new FileOutputStream(nomFichier);

            // Créer un flux d'objet pour sérialiser la liste
            ObjectOutputStream objetSortie = new ObjectOutputStream(fichierSortie);

            // Écrire la liste d'objets dans le fichier binaire
            objetSortie.writeObject(armeAFeuList);

            // Fermer les flux
            objetSortie.close();
            fichierSortie.close();

            System.out.println("La liste d'objets a été sauvegardée dans le fichier " + nomFichier);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<ArmeAFeu> LoadListFeu (String nomFichier)
    {
        ArrayList<ArmeAFeu> listeObjets = new ArrayList<>();
        try
        {
            // Créer un flux d'entrée pour lire les données binaires du fichier
            FileInputStream fichierEntree = new FileInputStream(nomFichier);

            // Créer un flux d'objet pour désérialiser la liste
            ObjectInputStream objetEntree = new ObjectInputStream(fichierEntree);

            // Lire la liste d'objets depuis le fichier binaire
            listeObjets = (ArrayList<ArmeAFeu>) objetEntree.readObject();

            // Fermer les flux
            objetEntree.close();
            fichierEntree.close();

            System.out.println("La liste d'objets a été chargée depuis le fichier " + nomFichier);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeObjets;
    }

    public void save(String nomFichier) {
        try {
            // Créer un flux de sortie pour écrire les données binaires dans le fichier
            FileOutputStream fichierSortie = new FileOutputStream(nomFichier);

            // Créer un flux d'objet pour sérialiser l'inventaire
            ObjectOutputStream objetSortie = new ObjectOutputStream(fichierSortie);

            // Écrire l'inventaire dans le fichier binaire
            objetSortie.writeObject(this);

            // Fermer les flux
            objetSortie.close();
            fichierSortie.close();

            System.out.println("L'inventaire a été sauvegardé dans le fichier " + nomFichier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Inventaire load(String nomFichier) {
        Inventaire inventaire = null;
        try {
            // Créer un flux d'entrée pour lire les données binaires du fichier
            FileInputStream fichierEntree = new FileInputStream(nomFichier);

            // Créer un flux d'objet pour désérialiser l'inventaire
            ObjectInputStream objetEntree = new ObjectInputStream(fichierEntree);

            // Lire l'inventaire depuis le fichier binaire
            inventaire = (Inventaire) objetEntree.readObject();

            // Fermer les flux
            objetEntree.close();
            fichierEntree.close();

            System.out.println("L'inventaire a été chargé depuis le fichier " + nomFichier);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return inventaire;
    }
}
