package metier;
import java.util.ArrayList;

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
            if(arme.getCategorie().equalsIgnoreCase("Assaut"))
            {
                getAssautList().add((ArmeAFeu) arme);
            } else if (arme.getCategorie().equalsIgnoreCase("SMG")) {
                getSMGList().add((ArmeAFeu) arme);
            }
            else if (arme.getCategorie().equalsIgnoreCase("Sniper")){
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
            if(arme.getCategorie().equalsIgnoreCase("Assaut"))
            {
                getAssautList().remove((ArmeAFeu) arme);
            } else if (arme.getCategorie().equalsIgnoreCase("SMG")) {
                getSMGList().remove((ArmeAFeu) arme);
            }
            else {
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
    public void Save(String fileName, Object data)
    {
        return;
    }
    public Object Load(String fileName)
    {
        return new Object();
    }
}
