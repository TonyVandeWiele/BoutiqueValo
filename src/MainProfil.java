import metier.Profil;

public class MainProfil {
    public static void main(String[] args)
    {
        Profil profil1 = new Profil();
        profil1.Affiche();

        Profil profil3 = new Profil();
        profil1.Affiche();

        Profil profil2 = new Profil("TonyV50",3,"Pas d'avatar");
        profil2.Affiche();

        if(profil1.equals(profil3))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }
        profil2.Save("Data.bin",profil2);
    }
}