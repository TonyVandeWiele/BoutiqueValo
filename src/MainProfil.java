import metier.Profil;

public class MainProfil {
    public static void main(String[] args)
    {
        Profil profilBase = new Profil();
        profilBase.Affiche();

        Profil profilUser = new Profil("TonyV50","/img");
        profilUser.Affiche();

        if(profilBase.equals(profilUser))
        {
            System.out.println("Egal");
        }
        else
        {
            System.out.println("Pas Egal");
        }
        profilUser.Save("Data.bin",profilUser);

        Profil profilLoad = new Profil();
        profilLoad.Load("DataUser.bin");
    }
}