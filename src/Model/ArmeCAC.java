package Model;

import java.io.Serializable;

public class ArmeCAC extends Arme implements Serializable
{
    private final int degatTranchant;

    public int getDegatTranchant() {
        return degatTranchant;
    }

    public ArmeCAC()
    {
        super();
        degatTranchant=0;
    }
    public ArmeCAC(String vNom, Skin vSkin,Categorie vCategorie,int vPrix,int vDegatTranchant)
    {
        super(vNom, vSkin,vCategorie, vPrix);
        degatTranchant=vDegatTranchant;
    }

    @Override
    public String toString() {
        //return super.toString() + "\nDégat Tranchant : " + getDegatTranchant();
        return super.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ArmeCAC armeCAC = (ArmeCAC) obj;
        return super.equals(armeCAC) && getDegatTranchant() == armeCAC.getDegatTranchant();
    }
    @Override
    public void Affiche() {
        System.out.println(this);
    }
}
