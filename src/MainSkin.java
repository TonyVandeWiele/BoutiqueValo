import Model.*;

import java.io.IOException;

public class MainSkin {
    public static void main(String[] args) throws IOException {
        Skin SkinBase = new Skin();
        SkinBase.Affiche();

        Skin SkinPerso = new Skin("Revear", Rarete.rare,"/img");
        SkinPerso.Affiche();

        if(SkinPerso.equals(SkinBase))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }

        SkinPerso.Save("DataSkin.csv",SkinPerso);

        SkinBase.Affiche();
    }
}