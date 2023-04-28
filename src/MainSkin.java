import metier.Profil;
import metier.Rarete;
import metier.Skin;

public class MainSkin {
    public static void main(String[] args)
    {
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

        SkinPerso.Save("");
    }
}