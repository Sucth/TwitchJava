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
        System.out.println("0. FAVORI");
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


        System.out.println("Quelle Activité vous intéresse ?");
        int inputStringactivchoice = Integer.parseInt(scanner.nextLine());

        if (inputStringactivchoice == 0) {
            System.out.println("1. Mettre un streamer en favori");
            System.out.println("2. Voir les streamers favoris");
            System.out.println("Entrez le numéro de l'option :");
            int optionNumber = Integer.parseInt(scanner.nextLine());

            if (optionNumber == 1) {
                System.out.println("Liste de tous les streamers :");
                int count = 1;
                for (Streamer streamer : streamers) {
                    System.out.println(count + ". " + streamer.getStreamerName());
                    count++;
                }

                System.out.println("Entrez le numéro du streamer à ajouter aux favoris :");
                int streamerNumber = Integer.parseInt(scanner.nextLine());
                Streamer chosenStreamer = streamers.get(streamerNumber - 1);
                favorites.add(chosenStreamer);
                System.out.println("Le streamer " + chosenStreamer.getStreamerName() + " a été ajouté aux favoris.\n");
            } else if (optionNumber == 2) {
                System.out.println("Liste des streamers favoris :");
                int count = 1;
                for (Streamer streamer : favorites) {
                    System.out.println(count + ". " + streamer.getStreamerName());
                    count++;
                }
                System.out.println();

                System.out.println("Choisissez un streamer en entrant le numéro correspondant :");
                int streamerNumber = Integer.parseInt(scanner.nextLine());
                Streamer chosenStreamer = favorites.get(streamerNumber - 1);

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

                System.out.println("Quelle option vous intéresse ?");
                int inputMenu = Integer.parseInt(scanner.nextLine());

                if (inputMenu == 3) {
                    chatFunction();
                } else if (inputMenu == 1) {
                    System.out.println("Exit Twitch ...........");
                    return;
                }
                menu = inputMenu;
            }

        }
        else {
            boolean foundStreamer = false;
            int count = 1;
            List<Streamer> streamersFromActivity = new ArrayList<>();

            for (Streamer streamer : streamers) {
                if (streamer.getActivity().equals(getActivityFromInput(inputStringactivchoice))) {
                    streamersFromActivity.add(streamer);
                    System.out.println(count + ". " + streamer.getViewerCount() + " viewers " + streamer.getStreamerName());
                    foundStreamer = true;
                    count++;
                }
            }

            if (!foundStreamer) {
                System.out.println("Aucun streamer en train de jouer à " + getActivityFromInput(inputStringactivchoice) + ".");
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

            System.out.println("Quelle option vous intéresse ?");
            int inputMenu = Integer.parseInt(scanner.nextLine());

            if (inputMenu == 3){
                chatFunction();
            }
            menu = inputMenu;
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
