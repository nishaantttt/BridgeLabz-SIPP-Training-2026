interface StreamingService {

    void streamMovie();

    default void showSubscriptionDetails() {
        System.out.println(
                "Streaming Subscription Active");
    }
}

interface GamingService {

    void playGame();

    default void showSubscriptionDetails() {
        System.out.println(
                "Gaming Subscription Active");
    }
}

class SmartTV implements StreamingService,
                         GamingService {

    String[] movies = {
            "Inception",
            "Avatar",
            "Interstellar"
    };

    String[] games = {
            "FIFA",
            "Minecraft",
            "GTA V"
    };

    @Override
    public void streamMovie() {

        System.out.println("Available Movies:");

        for(String movie : movies)
            System.out.println(movie);
    }

    @Override
    public void playGame() {

        System.out.println("\nAvailable Games:");

        for(String game : games)
            System.out.println(game);
    }

    @Override
    public void showSubscriptionDetails() {

        StreamingService.super
                .showSubscriptionDetails();

        GamingService.super
                .showSubscriptionDetails();
    }
}

public class SmartTVDemo {

    public static void main(String[] args) {

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();
        tv.streamMovie();
        tv.playGame();
    }
}