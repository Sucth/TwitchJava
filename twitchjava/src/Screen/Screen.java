package Screen;

import Streamer.Streamer;
import Chat.Chat;

import java.util.*;

public class Screen {
    private List<Streamer> streamers;
    private List<String> pseudoList;
    private List<Streamer> favorites;

    private List<String> chatList;
    private int menu;

    private boolean activationChat = true;
    private boolean exitRequested;

    Chat chatTwitch;

    public Screen(List<Streamer> streamers) {
        this.streamers = streamers;
        favorites = new ArrayList<>();
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
        System.out.println("11. Afficher les streamers");
        System.out.println("12. Quitter");

        System.out.println("Quelle option vous intéresse ?");
        int inputMenu = Integer.parseInt(scanner.nextLine());

        if (inputMenu == 11) {
            printFavorites();

            printInfo();
            return;
        }


            boolean foundStreamer = false;
            int count = 1;
            List<Streamer> streamersFromActivity = new ArrayList<>();

            for (Streamer streamer : streamers) {
                if (streamer.getActivity().equals(getActivityFromInput(inputMenu))) {
                    streamersFromActivity.add(streamer);
                    System.out.println(count + ". " + streamer.getViewerCount() + " viewers " + streamer.getStreamerName());
                    foundStreamer = true;
                    count++;
                }
            }

            if (!foundStreamer) {
                System.out.println("Aucun streamer en train de jouer à " + getActivityFromInput(inputMenu) + ".");
                menu = 2;
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
            System.out.println("Nombre de subscriptions : " + chosenStreamer.getSubscriberCount());
            System.out.println("En live : " + chosenStreamer.isLive() + "\n");
            System.out.println("Vous regardez " + chosenStreamer.getStreamerName());

            System.out.println("1. Quitter L'app");
            System.out.println("2. Retourner au Menu");
            System.out.println("3. Chat");
            System.out.println("4. Favori");

            System.out.println("Quelle option vous intéresse ?");
            int inputMenus = Integer.parseInt(scanner.nextLine());

            if (inputMenus == 3) {
               chatFunction();
            } else if (inputMenus == 4) {
               favori(chosenStreamer);
         }

         menu = inputMenus;

    }


    public void favori(Streamer streamer) {
        Scanner scanner = new Scanner(System.in);
        favorites.add(streamer);
        System.out.println("Le streamer " + streamer.getStreamerName() + " a été ajouté aux favoris.");


        System.out.println("Quelle option vous intéresse ?");

        System.out.println("1. Retourner au Menu");
        int input = Integer.parseInt(scanner.nextLine());
        if (input == 1){
            printInfo();
        }
    }

    public void afficherStreamers() {
        System.out.println("Liste des streamers :");
        for (int i = 0; i < streamers.size(); i++) {
            Streamer streamer = streamers.get(i);
            System.out.println((i + 1) + ". " + streamer.getStreamerName());
            System.out.println("   Activité : " + streamer.getActivity());
            System.out.println("   Spectateurs : " + streamer.getViewerCount());
            System.out.println("   Heures de streaming : " + streamer.getStreamHours());
            System.out.println("   Followers : " + streamer.getFollowerCount());
            System.out.println("   Subscriptions : " + streamer.getSubscriberCount());
            System.out.println("   En live : " + streamer.isLive());
            System.out.println();
        }
    }


    private void printFavorites() {
        System.out.println("Liste des streamers favoris :");
        for (int i = 0; i < favorites.size(); i++) {
            Streamer streamer = favorites.get(i);
            System.out.println((i + 1) + ". " + streamer.getStreamerName());
            System.out.println("   Activité : " + streamer.getActivity());
            System.out.println("   Spectateurs : " + streamer.getViewerCount());
            System.out.println("   Heures de streaming : " + streamer.getStreamHours());
            System.out.println("   Followers : " + streamer.getFollowerCount());
            System.out.println("   Subscriptions : " + streamer.getSubscriberCount());
            System.out.println("   En live : " + streamer.isLive());
            System.out.println();
        }
    }


    public boolean isChatActive(){
        return activationChat;
    }

    public void chatFunction(){
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
                    chatFunction();
                    break;
                } else if (line.equals("")) {
                    timer.cancel();
                    activationChat = false;
                    break;
                }
            }
        }
    }

    public void setMenuOption(int menu){
        this.menu = menu;
    }

    public int getMenuOption(){
        return menu;
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
