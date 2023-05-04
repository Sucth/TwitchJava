package Twitch;

public class Twitch {
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
            throw new IllegalStateException("Le streamer doit être en streaming pour pouvoir démarrer.");
        }
        // Logique de démarrage du streaming
    }

    public void stopStreaming() {
        if (!"streaming".equals(activity)) {
            throw new IllegalStateException("Le streamer doit être en streaming pour pouvoir s'arrêter.");
        }
        // Logique d'arrêt du streaming
    }
}
