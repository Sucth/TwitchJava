package Streamer;

import Twitch.Twitch;

public class Streamer extends Twitch {
    private int streamHours;
    private int followerCount;
    private int subscriberCount;
    private boolean isLive;

    public Streamer(String streamerName, int viewerCount, String activity, int streamHours, int followerCount, int subscriberCount, boolean isLive) {
        super(streamerName, viewerCount, activity);
        this.streamHours = streamHours;
        this.followerCount = followerCount;
        this.subscriberCount = subscriberCount;
        this.isLive = isLive;
    }

    public int getStreamHours() {
        return streamHours;
    }

    public void setStreamHours(int streamHours) {
        if (streamHours < 0) {
            throw new IllegalArgumentException("Le nombre d'heures de streaming ne peut pas être négatif.");
        }
        this.streamHours = streamHours;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        if (followerCount < 0) {
            throw new IllegalArgumentException("Le nombre d'abonnés ne peut pas être négatif.");
        }
        this.followerCount = followerCount;
    }

    public int getSubscriberCount() {
        return subscriberCount;
    }

    public void setSubscriberCount(int subscriberCount) {
        if (subscriberCount < 0) {
            throw new IllegalArgumentException("Le nombre d'abonnés ne peut pas être négatif.");
        }
        this.subscriberCount = subscriberCount;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        if (isLive && !"streaming".equals(getActivity())) {
            throw new IllegalStateException("Le streamer doit être en streaming pour pouvoir être en direct.");
        }
        this.isLive = isLive;
    }

    public void gainFollower(int followerCount) {
        if (followerCount < 0) {
            throw new IllegalArgumentException("Le nombre d'abonnés ne peut pas être négatif.");
        }
        this.followerCount += followerCount;
    }

    public void gainSubscriber(int subscriberCount) {
        if (subscriberCount < 0) {
            throw new IllegalArgumentException("Le nombre d'abonnés ne peut pas être négatif.");
        }
        this.subscriberCount += subscriberCount;
    }
}
