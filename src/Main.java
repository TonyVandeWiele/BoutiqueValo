import métier.*;
public class Main {
    public static void main(String[] args)
    {
        Inventaire inventaire = Inventaire.getInstance();

        inventaire.AjouterArme(new ArmeAFeu("Spectrum", new Skin("Reaver",Rarete.rare,"/reaver"),"SMG" ,200,"Arme trop bien",10,10,50,30));

        ArmeAFeu arme = inventaire.getSMGList().get(0);

        arme.Affiche();
    }
}