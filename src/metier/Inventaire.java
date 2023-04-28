package metier;
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
    private Profil User;

    private Inventaire() {
        AssautList = new ArrayList<>();
        SMGList = new ArrayList<>();
        SniperList = new ArrayList<>();
        CACList = new ArrayList<>();
        SkinList = new ArrayList<>();
        User = new Profil();
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
    public ArrayList<Skin> getSkinList() { return SkinList; }
    public Profil getUser() { return User; }

    public void setAssautList(ArrayList<ArmeAFeu> assautList) {
        AssautList = assautList;
    }

    public <T extends Arme> void AjouterArme(T arme)
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
}
