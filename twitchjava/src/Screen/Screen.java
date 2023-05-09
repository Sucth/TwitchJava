package Screen;

import Streamer.Streamer;
import Chat.Chat;

import java.util.*;

public class Screen {
    private List<Streamer> streamers;
    private List<String> pseudoList;

    private List<String> chatList;
    private int Menu;

    Chat chatTwitch;

    public Screen(List<Streamer> streamers) {
        this.streamers = streamers;
    }
    public void printInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====MENU====");
        System.out.println("1. VALORANT");
        System.out.println("2. F1");
        System.out.println("3. GTA");
        System.out.println("4. The Last of Us");
        System.out.println("5. Just Chatting");
        System.out.println("6. Rocket League");
        System.out.println("7. FIFA");
        System.out.println("8. CSGO");
        System.out.println("9. Minecraft");
        System.out.println("10. Quitter");

        System.out.println("Quelle Activité vous interesse ?");
        int inputString = Integer.parseInt(scanner.nextLine());

        boolean foundStreamer = false;
        int count = 1;
        List<Streamer> streamersFromActivity = new ArrayList<>();

        for (Streamer streamer : streamers) {
            if (streamer.getActivity().equals(getActivityFromInput(inputString))) {
                streamersFromActivity.add(streamer);
                System.out.println(count + ". " + streamer.getViewerCount() + " viewers " + streamer.getStreamerName());
                foundStreamer = true;
                count++;
            }
        }

        if (!foundStreamer) {
            System.out.println("Aucun streamer en train de jouer à " + getActivityFromInput(inputString) + ".");
            Menu = 2;
            return;
        }

        System.out.println("Choisissez un streamer en entrant le numéro correspondant :");
        int streamerNumber = Integer.parseInt(scanner.nextLine());
        Streamer chosenStreamer = streamersFromActivity.get(streamerNumber - 1);

        System.out.println("Nom du streamer : " + chosenStreamer.getStreamerName());
        System.out.println("Nombre de spectateurs : " + chosenStreamer.getViewerCount());
        System.out.println("Activité : " + chosenStreamer.getActivity());
        System.out.println("Nombre d'heures de streaming : " + chosenStreamer.getStreamHours());
        System.out.println("Nombre de followers : " + chosenStreamer.getFollowerCount());
        System.out.println("Nombre de subcriptions : " + chosenStreamer.getSubscriberCount());
        System.out.println("En live : " + chosenStreamer.isLive() + "\n");

        System.out.println("Vous regardez " + chosenStreamer.getStreamerName());

        System.out.println("1. Quitter L'app");
        System.out.println("2. Retourner au Menu");
        System.out.println("3. Chat");

        System.out.println("Quelle Activité vous interesse ?");
        int inputMenu = Integer.parseInt(scanner.nextLine());

        if (inputMenu == 3){
            Chatfct();
        }
        Menu = inputMenu;



    }

    public void Chatfct() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Chat chatTwitch = new Chat();
                String pseudo = chatTwitch.getRandomPseudo();
                String chatPhrase = chatTwitch.getRandomChatPhrase();
                System.out.println(pseudo + " : " + chatPhrase);
            }
        };
        timer.schedule(task, 0, 1000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("t")) {
                    timer.cancel();

                    System.out.println("Ecrivez");
                    String inputchat = scanner.nextLine();
                    System.out.println("Vous : " + inputchat);
                    Chatfct();
                    break;
                } else if (line.equals("")) {
                    timer.cancel();
                    setmenuopt(2);
                    System.out.println("gr");
                    getmenuopt();
                    break;
                }
            }
        }
    }

    public void setmenuopt(int Menu){
        this.Menu = Menu;
    }
    public int getmenuopt(){
        return Menu;
    }

    private String getActivityFromInput(int input) {
        switch (input) {
            case 1:
                return "Valorant";
            case 2:
                return "F1";
            case 3:
                return "GTA";
            case 4:
                return "The Last of Us";
            case 5:
                return "Just Chatting";
            case 6:
                return "Rocket League";
            case 7:
                return "FIFA";
            case 8:
                return "CSGO";
            case 9:
                return "Minecraft";
            default:
                return "";
        }
    }


}
