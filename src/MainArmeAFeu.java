import Model.*;

import java.io.Serializable;

public class MainArmeAFeu implements Serializable
{
    public static void main(String[] args)
    {
        ArmeAFeu armeBase = new ArmeAFeu();
        armeBase.Affiche();

        ArmeAFeu armeAssaut = new ArmeAFeu("Vandal",new Skin("Reaver", Rarete.epique,"/img"),Categorie.Assaut,300,60,30,90,35);
        armeAssaut.Affiche();

        if(armeBase.equals(armeAssaut))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }

        armeAssaut.Save("Data.bin",armeAssaut);

        ArmeAFeu armeAssautLoad =new ArmeAFeu();
        armeAssautLoad = (ArmeAFeu) armeAssautLoad.Load("Data.bin");

        armeAssautLoad.Affiche();
    }
}