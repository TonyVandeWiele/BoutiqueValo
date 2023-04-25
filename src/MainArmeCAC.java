import métier.ArmeAFeu;
import métier.ArmeCAC;
import métier.Rarete;
import métier.Skin;

public class MainArmeCAC {
    public static void main(String[] args)
    {
        ArmeCAC armecac1 = new ArmeCAC();
        ArmeCAC armecac3 = new ArmeCAC();
        armecac1.Affiche();

        ArmeCAC armecac2 = new ArmeCAC("AK-47",new Skin("Revear", 200, Rarete.epique, "/pc/"),"Assaut",300,"Pas de desc",20);
        armecac2.Affiche();

        if(armecac1.equals(armecac3))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }
    }
}