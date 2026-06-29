interface TextModeration {

    boolean isOffensive(String post);

    default void displayModerationPolicy() {

        System.out.println(
                "Offensive content is prohibited");
    }

    static boolean containsRestrictedWords(
            String post) {

        String[] words = {
                "hate",
                "abuse",
                "violence"
        };

        post = post.toLowerCase();

        for(String word : words) {

            if(post.contains(word))
                return true;
        }

        return false;
    }
}

interface SpamDetection {

    boolean isSpam(String post);

    default void displayModerationPolicy() {

        System.out.println(
                "Spam content is prohibited");
    }
}

class ContentModerator
        implements TextModeration,
                   SpamDetection {

    @Override
    public boolean isOffensive(
            String post) {

        return TextModeration
                .containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(
            String post) {

        return post.toLowerCase()
                .contains("buy now");
    }

    @Override
    public void displayModerationPolicy() {

        TextModeration.super
                .displayModerationPolicy();

        SpamDetection.super
                .displayModerationPolicy();
    }

    void moderatePosts(String[] posts) {

        for(String post : posts) {

            if(isSpam(post))
                System.out.println(
                        "\"" + post +
                        "\" -> Spam Post");

            else if(isOffensive(post))
                System.out.println(
                        "\"" + post +
                        "\" -> Offensive Post");

            else
                System.out.println(
                        "\"" + post +
                        "\" -> Valid Post");
        }
    }
}

public class ModerationDemo {

    public static void main(String[] args) {

        String[] posts = {
                "Buy now and get 50% discount",
                "I hate this community",
                "Welcome everyone",
                "Violence should stop",
                "Enjoy your day"
        };

        ContentModerator moderator =
                new ContentModerator();

        moderator.displayModerationPolicy();
        System.out.println();

        moderator.moderatePosts(posts);
    }
}