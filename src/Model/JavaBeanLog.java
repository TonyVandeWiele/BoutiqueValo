package Model;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaBeanLog {
    private final String pathLog;

    public JavaBeanLog()
    {
        pathLog= "src/Data/Log.txt";
    }
    public void logPurchase(String NomArme, float Prix, String Acheteur) {
        String logEntry = createLogEntry(NomArme, Prix, Acheteur);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathLog, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createLogEntry(String NomArme, float Prix, String Acheteur) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedTimestamp = timestamp.format(formatter);
        return "[" + formattedTimestamp + "] Purchase: Item: " + NomArme + " | Price: " + Prix + " | Acheteur: " + Acheteur;
    }
}
