package métier;

public class ArmeAFeu extends Arme
{
    private int degatsTete;
    private int degatsCorps;
    private int portee;
    private int capaciteChargeur;
    public int getDegatsTete()
    {
        return degatsTete;
    }
    public int getDegatsCorps()
    {
        return degatsCorps;
    }
    public int getPortee()
    {
        return portee;
    }
    public int getCapaciteChargeur()
    {
        return capaciteChargeur;
    }
    public ArmeAFeu()
    {
        super();
        degatsTete=0;
        degatsCorps=0;
    }
    public ArmeAFeu(String vNom,String vType,int vPrix,String vDescription,int vDegTete,int vDegCorps,int vPortee,int vChargeur)
    {
        super(vNom, vType, vPrix, vDescription);
        degatsTete=vDegTete;
        degatsCorps=vDegCorps;
        portee=vPortee;
        capaciteChargeur=vChargeur;
    }

    public void Affiche()
    {
        super.Affiche();
        System.out.println("\nDegat dans la Tete : " + getDegatsTete() + "\nDegat dans le corps : " + getDegatsCorps()+ "\nPortée de l'arme : " + getPortee() + "\nCapacité du chargeur : " + getCapaciteChargeur());
    }
}
