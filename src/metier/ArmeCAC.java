package metier;

public class ArmeCAC extends Arme
{
    private int degatTranchant;

    public int getDegatTranchant() {
        return degatTranchant;
    }

    public ArmeCAC()
    {
        super();
        degatTranchant=0;
    }
    public ArmeCAC(String vNom, Skin vSkin,String vCategorie,int vPrix,int vDegatTranchant)
    {
        super(vNom, vSkin,vCategorie, vPrix);
        degatTranchant=vDegatTranchant;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDégat Tranchant : " + getDegatTranchant();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ArmeCAC armeCAC = (ArmeCAC) obj;
        if(super.equals(armeCAC) && getDegatTranchant() == armeCAC.getDegatTranchant())
        {
            return true;
        }
        return false;
    }
    @Override
    public void Affiche() {
        System.out.println(toString());
    }
}
