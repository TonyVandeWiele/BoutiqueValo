import Model.*;

public class MainArmeCAC {
    public static void main(String[] args)
    {
        ArmeCAC armeBase = new ArmeCAC();
        armeBase.Affiche();

        ArmeCAC armeCAC = new ArmeCAC("Vandal",new Skin("Reaver", Rarete.epique,"/img"), Categorie.CAC,200,50);
        armeCAC.Affiche();

        if(armeBase.equals(armeCAC))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }

        //armeCAC.Save("Data.bin",armeCAC);

        //ArmeCAC armeLoad =new ArmeCAC();
        //armeLoad = (ArmeCAC) armeLoad.Load("Data.bin");

        //armeLoad.Affiche();
    }
}