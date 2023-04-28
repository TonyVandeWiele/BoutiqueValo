package metier;

import java.io.IOException;

public interface ISaveLoad {

    void Save(String fileName, Object data) throws IOException;
    // Cette méthode prend en entrée un nom de fichier et un objet à sauvegarder

    Object Load(String fileName);
    // Cette méthode prend en entrée un nom de fichier et retourne l'objet sauvegardé précédemment
}
