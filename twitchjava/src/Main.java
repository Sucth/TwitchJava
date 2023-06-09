import java.util.ArrayList;
import java.util.List;
import Streamer.Streamer;
import Screen.Screen;
import Chat.Chat;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            FileHandler fileHandler = new FileHandler("error.log", true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erreur lors de la configuration du fichier de log.", e);
        }

        try {
            List<Streamer> streamerlist = new ArrayList<>();

            streamerlist.add(new Streamer("Gotaga", 12000, "Valorant", 4, 300000, 8450, true));
            streamerlist.add(new Streamer("Sardoche", 8000, "LOL", 6, 250000, 6300, true));
            streamerlist.add(new Streamer("ZeratoR", 6000, "The Last of Us", 3, 200000, 4800, true));
            streamerlist.add(new Streamer("Doigby", 5000, "LOL", 5, 180000, 4100, true));
            streamerlist.add(new Streamer("Laink", 4000, "GTA", 7, 150000, 3500, true));
            streamerlist.add(new Streamer("Jiraya", 3500, "Just Chatting", 10, 130000, 3100, true));
            streamerlist.add(new Streamer("Chap", 3000, "F1", 2, 120000, 2800, true));
            streamerlist.add(new Streamer("Gius", 2500, "Valorant", 5, 100000, 2500, true));
            streamerlist.add(new Streamer("Kamet0", 2000, "LOL", 3, 90000, 2200, true));
            streamerlist.add(new Streamer("MisterMV", 1500, "The Last of Us", 8, 75000, 1900, true));
            streamerlist.add(new Streamer("Nems", 1000, "GTA", 4, 50000, 1500, true));
            streamerlist.add(new Streamer("Ponce", 800, "Just Chatting", 12, 40000, 1300, true));
            streamerlist.add(new Streamer("Maxildan", 700, "F1", 1, 35000, 1200, true));
            streamerlist.add(new Streamer("SardocheLIVE", 600, "LOL", 4, 30000, 1100, true));
            streamerlist.add(new Streamer("Maghla", 500, "Just Chatting", 6, 25000, 1000, true));
            streamerlist.add(new Streamer("Xari", 400, "GTA", 5, 20000, 900, true));
            streamerlist.add(new Streamer("Domingo", 300, "Valorant", 3, 15000, 800, true));
            streamerlist.add(new Streamer("Bastossavoie", 200, "LOL", 2, 10000, 700, true));
            streamerlist.add(new Streamer("Lutti", 100, "The Last of Us", 1, 5000, 600, true));
            streamerlist.add(new Streamer("Zankou", 50, "Just Chatting", 2, 2500, 500, true));

            Screen screen = new Screen(streamerlist);

            screen.printInfo();

            while (true) {
                if (screen.getMenuOption() == 2 || screen.getMenuOption() == 3) {
                    screen.setMenuOption(0);
                    screen.printInfo();
                } else if (screen.isChatActive() == false) {
                    screen.setMenuOption(0);
                    screen.printInfo();
                } else if (screen.getMenuOption() == 1){
                    System.out.println("Exit Twitch ...........");
                    break;
                }
            }

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Erreur lors de la création d'un streamer.", e);
            System.exit(1); // Sortie du programme avec un code d'erreur
        }






    }
}
