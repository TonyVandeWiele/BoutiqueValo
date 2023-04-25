import métier.*;
public class Main {
    public static void main(String[] args)
    {
        ArmeAFeu arme = new ArmeAFeu();

        arme.Affiche();

        ArmeAFeu arme2 = new ArmeAFeu("AK-47",new Skin("Revear", 200, Rarete.epique, "/pc/"),"Assaut",300,"Pas de desc",10,5,30,30);


        arme2.Affiche();

    }
}