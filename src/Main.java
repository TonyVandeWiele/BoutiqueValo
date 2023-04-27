import metier.ArmeAFeu;
import metier.Inventaire;
import metier.Rarete;
import metier.Skin;

public class Main {
    public static void main(String[] args)
    {
        Inventaire.getInstance().AjouterArme(new ArmeAFeu("Spectrum", new Skin("Reaver", Rarete.rare,"/reaver"),"SMG" ,200,10,10,50,30));

        ArmeAFeu arme = Inventaire.getInstance().getSMGList().get(0);


        Inventaire.getInstance().AjouterArgent(3);
        Inventaire.getInstance().RetirerArgent(3);

        arme.Affiche();
    }
}