import métier.*;
public class Main {
    public static void main(String[] args)
    {
        ArmeAFeu arme = new ArmeAFeu();

        arme.Affiche();

        arme.ajouteSkin(new Skin("Revear", 200, Rarete.epique, "/pc/"));

        arme.Affiche();

        arme.retireSkin("Revear");

        arme.Affiche();
    }
}