package Screen;

import Streamer.Streamer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {
    private List<Streamer> streamers;

    public Screen(List<Streamer> streamers) {
        this.streamers = streamers;
    }

    public void printInfo() {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("En live : " + chosenStreamer.isLive());
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