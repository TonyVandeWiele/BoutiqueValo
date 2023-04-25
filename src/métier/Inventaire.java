package métier;
import java.util.ArrayList;

public class Inventaire {
    private static Inventaire INSTANCE = null;
    private ArrayList<ArmeAFeu> AssautList;
    private ArrayList<ArmeAFeu> SMGList;
    private ArrayList<ArmeAFeu> SniperList;
    private ArrayList<ArmeCAC> CACList;

    private Inventaire() {}

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

    public ArrayList<ArmeAFeu> getSniperList() {
        return SniperList;
    }

    public ArrayList<ArmeCAC> getCACList() {
        return CACList;
    }
}
