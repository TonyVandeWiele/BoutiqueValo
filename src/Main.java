import metier.*;

public class Main {
    public static void main(String[] args)
    {
        ArmeAFeu armeBaseAssaut = new ArmeAFeu();

        ArmeAFeu armeAssaut = new ArmeAFeu("Vandal",new Skin("Reaver",Rarete.epique,"/img"),Categorie.Assaut,300,60,30,90,35);

        Inventaire.getInstance().AjouterArme(armeBaseAssaut);
        Inventaire.getInstance().AjouterArme(armeAssaut);

        for ( ArmeAFeu armeAssautList : Inventaire.getInstance().getAssautList())
        {
            armeAssautList.Affiche();
        }
    }
}