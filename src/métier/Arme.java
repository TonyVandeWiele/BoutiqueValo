package métier;

abstract class Arme
{
    private String nom;
    private Skin[] skin;
    private String type;
    private int prix;
    private String description;

    public Arme()
    {
        nom="Pas de Nom";
        skin=new Skin[5];
        skin[0] = new Skin("Default Skin",0,Rarete.commun,"TEST");
        type="Pas de Type";
        prix=0;
        description="Pas de Description";
    }
    public Arme(String n,String t,int p,String d)
    {
        nom=n;
        type=t;
        prix=p;
        description=d;
    }
    public String getNom()
    {
        return nom;
    }
    public String getType()
    {
        return type;
    }
    public  int getPrix()
    {
        return prix;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void ajouteSkin(Skin vSkin)
    {
        int i=1;
        while(i<5 && skin[i] != null)
        {
            i++;
        }
        if(i<5)
        {
            skin[i] = vSkin;
        }
    }

    public void retireSkin(String vNom)
    {
        int i=1;
        while(i<5 && skin[i] != null)
        {
            if(skin[i].getNom().compareToIgnoreCase(vNom) == 0)
            {
                skin[i] = null;
            }
            i++;
        }
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public void setType(String type) {
        this.type = type;
    }

    public  String getDescription()
    {
        return description;
    }
    public String ToString()
    {
        return "\nNom :" + getNom() + "\nType :" + getType() + "\nPrix :"+getPrix()+"\nDescription :"+getDescription()+"\n";
    }
    public void Affiche()
    {
        System.out.println("Voici une arme : " + ToString());
        System.out.print("Voici ces skins : ");

        int i=0;
        while(i<5)
        {
            if(skin[i] != null)
            {
                skin[i].Affiche();
            }
            i++;
        }
    }
}
