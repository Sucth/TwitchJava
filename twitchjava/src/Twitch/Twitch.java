package Twitch;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Twitch {
    private static final Logger logger = Logger.getLogger(Twitch.class.getName());
    private String streamerName;
    private int viewerCount;
    private String activity;

    public Twitch(String streamerName, int viewerCount, String activity) {
        if (viewerCount < 0) {
            throw new IllegalArgumentException("Le nombre de viewers ne peut pas être négatif.");
        }
        this.streamerName = streamerName;
        this.viewerCount = viewerCount;
        this.activity = activity;
    }

    public String getStreamerName() {
        return streamerName;
    }

    public void setStreamerName(String streamerName) {
        if (streamerName == null) {
            throw new NullPointerException("Le nom du streamer ne peut pas être null.");
        }
        this.streamerName = streamerName;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public void setViewerCount(int viewerCount) {
        if (viewerCount < 0) {
            throw new IllegalArgumentException("Le nombre de téléspectateurs ne peut pas être négatif.");
        }
        this.viewerCount = viewerCount;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        if (activity == null) {
            throw new NullPointerException("L'activité ne peut pas être null.");
        }
        this.activity = activity;
    }

    public void startStreaming() {
        if (!"streaming".equals(activity)) {
            String errorMessage = "Le streamer doit être en streaming pour pouvoir démarrer.";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        // Logique de démarrage du streaming
    }

    public void stopStreaming() {
        if (!"streaming".equals(activity)) {
            String errorMessage = "Le streamer doit être en streaming pour pouvoir s'arrêter.";
            logger.log(Level.SEVERE, errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        // Logique d'arrêt du streaming
    }
}