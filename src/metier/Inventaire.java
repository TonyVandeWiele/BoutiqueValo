package metier;
import java.util.ArrayList;
import java.io.*;

public class Inventaire implements ISaveLoad
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

    public void Save(String fileName, Object data) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            System.out.println("Données enregistrées avec succès dans " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données : " + e.getMessage());
        }
    }

    public Object Load(String fileName) {
        Object data = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Données chargées avec succès depuis " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement des données : classe introuvable.");
        }

        return data;
    }
}
