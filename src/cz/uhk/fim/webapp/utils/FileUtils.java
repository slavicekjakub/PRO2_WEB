package cz.uhk.fim.webapp.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static String loadStringFromFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static void saveStringToFile(String filepath, byte [] data) throws IOException {
        Path path = Paths.get(filepath);
        Files.write(path,data);
    }


    /*
    TODO: pridat Listenery na tlacitka LOAD a SAVE
    TODO: Napsat metodu validateInput() - je to boolean
    TODO: pridat nejaky JLabel lblError cerveny text a bude nad nebo pod txtInputField- vypise ze to posral
          3 typy chyb: pro LOAD, SAVE a validate
          chytí to catch
          pokud to bude ok tak se to znovu zmizi
    */
}
