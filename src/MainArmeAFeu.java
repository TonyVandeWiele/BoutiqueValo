import métier.ArmeAFeu;
import métier.Rarete;
import métier.Skin;

import java.io.Serializable;

public class MainArmeAFeu implements Serializable
{
    public static void main(String[] args)
    {
        ArmeAFeu arme1 = new ArmeAFeu();
        arme1.Affiche();
        ArmeAFeu arme2 = new ArmeAFeu("AK-47",new Skin("Revear", 200, Rarete.epique, "/pc/"),"Assaut",300,"Pas de desc",10,5,30,30);
        arme2.Affiche();

        if(arme1.equals(arme2))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }

        arme2.Save("Data.bin",arme2);

        ArmeAFeu arme =new ArmeAFeu();

        arme = (ArmeAFeu) arme.Load("Data.bin");

        arme.Affiche();



    }
}