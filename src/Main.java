import metier.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {

        Inventaire.getInstance().setAssautList(Inventaire.getInstance().LoadListFeu("DataListArme.bin"));
        for ( ArmeAFeu armeAssautList : Inventaire.getInstance().getAssautList())
        {
            armeAssautList.Affiche();
        }

    }
}