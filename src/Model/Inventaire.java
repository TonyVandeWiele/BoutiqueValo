package Model;

import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class Inventaire implements Serializable
{
    private static Inventaire INSTANCE = null;
    private ArrayList<ArmeAFeu> AssautList;
    private ArrayList<ArmeAFeu> SMGList;
    private ArrayList<ArmeAFeu> SniperList;
    private ArrayList<ArmeCAC> CACList;
    private ArrayList<Arme> BoutiqueList;
    private ArrayList<ArmeAFeu> BoutiqueFeu;
    private ArrayList<ArmeCAC> BoutiqueCAC;
    private Profil User;
    private String pathProfil;
    private String pathBoutique;

    public Inventaire() {
        AssautList = new ArrayList<>();
        SMGList = new ArrayList<>();
        SniperList = new ArrayList<>();
        CACList = new ArrayList<>();
        BoutiqueList = new ArrayList<>();
        BoutiqueFeu=new ArrayList<>();
        BoutiqueCAC=new ArrayList<>();
        pathProfil=new String("Data\\Profil.bin");
        pathBoutique=new String("Data\\Boutique.csv");
    }

    public static Inventaire getInstance() {
        if(INSTANCE == null)
        {
            INSTANCE = new Inventaire();
        }
        return INSTANCE;
    }

    public ArrayList<ArmeAFeu> getAssautList() {
        return AssautList;
    }
    public ArrayList<ArmeAFeu> getSMGList() {
        return SMGList;
    }
    public ArrayList<ArmeAFeu> getSniperList() { return SniperList; }
    public ArrayList<ArmeCAC> getCACList() { return CACList; }
    public ArrayList<Arme> getBoutiqueList() {
        return BoutiqueList;
    }
    public ArrayList<ArmeCAC> getBoutiqueCAC(){return BoutiqueCAC;}
    public ArrayList<ArmeAFeu> getBoutiqueFeu(){return BoutiqueFeu;}
    public Profil getUser() { return User; }

    public void setAssautList(ArrayList<ArmeAFeu> assautList) {
        AssautList = assautList;
    }
    public void setSMGList(ArrayList<ArmeAFeu> sMGList){SMGList=sMGList;}
    public void setSniperList(ArrayList<ArmeAFeu> sniperList){SniperList=sniperList;}
    public void setCACList(ArrayList<ArmeCAC> armeCACS){CACList=armeCACS;}
    public void setUser(Profil user){User=user;}
    public void setUser(String pseudo, String avatar, float argent)
    {
        User = new Profil(pseudo,avatar,argent);
    }
    public void setBoutiqueFeu(ArrayList<ArmeAFeu> armeAFeus){BoutiqueFeu=armeAFeus;}
    public void setBoutiqueCAC(ArrayList<ArmeCAC> armeCACS){BoutiqueCAC=armeCACS;}

    public <T extends Arme> void AjouterArme(int choix, T arme)
    {
        if(choix == 1)
        {
            if(arme instanceof ArmeAFeu)
            {
                if(arme.getCategorie().equals(Categorie.Assaut))
                {
                    getAssautList().add((ArmeAFeu) arme);
                } else if (arme.getCategorie().equals(Categorie.SMG)) {
                    getSMGList().add((ArmeAFeu) arme);
                }
                else if (arme.getCategorie().equals(Categorie.Sniper)){
                    getSniperList().add((ArmeAFeu) arme);
                }
            } else if (arme instanceof ArmeCAC) {
                getCACList().add((ArmeCAC) arme);
            }
        }
        else
        {
            if(choix==2)
            {
                //if(arme instanceof ArmeCAC)
                    //getBoutiqueCAC().add(arme);
            }
            if(arme instanceof Arme)
            {
                getBoutiqueList().add(arme);
            }
        }
    }
    public <T extends Arme> void SupprimerArme(T arme)
    {
        if(arme instanceof ArmeAFeu)
        {
            if(arme.getCategorie().equals(Categorie.Assaut))
            {
                getAssautList().remove((ArmeAFeu) arme);
            } else if (arme.getCategorie().equals(Categorie.SMG)) {
                getSMGList().remove((ArmeAFeu) arme);
            }
            else if (arme.getCategorie().equals(Categorie.Sniper)) {
                getSniperList().remove((ArmeAFeu) arme);
            }
        } else if (arme instanceof ArmeCAC) {
            getCACList().remove((ArmeCAC) arme);
        }
    }


    public void AjouterArgent(float argent)
    {
        getUser().setArgent(getUser().getArgent() + argent);
    }
    public void RetirerArgent(float argent)
    {
        getUser().setArgent(getUser().getArgent() - argent);
    }

    public void saveProfil() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(pathProfil,false))) {
            outputStream.writeObject(getUser());
            outputStream.writeObject(getAssautList());
            outputStream.writeObject(getSMGList());
            outputStream.writeObject(getSniperList());
            outputStream.writeObject(getCACList());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadProfil() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(pathProfil))) {
            setUser((Profil) inputStream.readObject());
            setAssautList((ArrayList<ArmeAFeu>) inputStream.readObject());
            setSMGList((ArrayList<ArmeAFeu>) inputStream.readObject());
            setSniperList((ArrayList<ArmeAFeu>) inputStream.readObject());
            setCACList((ArrayList<ArmeCAC>) inputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveBoutique() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathBoutique))) {
            // Sauvegarder les armes à feu
            for (ArmeAFeu arme : BoutiqueFeu) {
                String line = arme.getNom() + ","
                        + arme.getSkin().getNom() + ","
                        + arme.getSkin().getRarete().toString() + ","
                        + arme.getSkin().getImage() + ","
                        + arme.getCategorie().toString() + ","
                        + arme.getPrix() + ","
                        + arme.getDegatsTete() + ","
                        + arme.getDegatsCorps() + ","
                        + arme.getPortee() + ","
                        + arme.getCapaciteChargeur();
                writer.println(line);
            }

            // Sauvegarder les armes CAC
            for (ArmeCAC arme : BoutiqueCAC) {
                String line = arme.getNom() + ","
                        + arme.getSkin().getNom() + ","
                        + arme.getSkin().getRarete().toString() + ","
                        + arme.getSkin().getImage() + ","
                        + arme.getCategorie().toString() + ","
                        + arme.getPrix() + ","
                        + arme.getDegatTranchant();
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBoutique() {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathBoutique))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 9 || values.length == 7) {
                    String nom = values[0];
                    String skinNom = values[1];
                    Rarete rarete = Rarete.valueOf(values[2]);
                    String image = values[3];
                    Categorie categorie = Categorie.valueOf(values[4]);
                    int prix = Integer.parseInt(values[5]);

                    if (categorie == Categorie.Assaut || categorie == Categorie.SMG || categorie == Categorie.Sniper) {
                        int degatsTete = Integer.parseInt(values[6]);
                        int degatsCorps = Integer.parseInt(values[7]);
                        int portee = Integer.parseInt(values[8]);
                        int tailleChargeur = Integer.parseInt(values[9]);

                        Skin skin = new Skin(skinNom, rarete, image);
                        ArmeAFeu arme = new ArmeAFeu(nom, skin, categorie, prix, degatsTete, degatsCorps, portee, tailleChargeur);
                        BoutiqueFeu.add(arme);
                    } else if (categorie == Categorie.CAC) {
                        int degatsTranchant = Integer.parseInt(values[6]);

                        Skin skin = new Skin(skinNom, rarete, image);
                        ArmeCAC arme = new ArmeCAC(nom, skin, categorie, prix, degatsTranchant);
                        BoutiqueCAC.add(arme);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
