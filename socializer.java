import java.util.Random;

public class HumanConversationSimulator {

    public static void main(String[] args) throws InterruptedException {
        String[] greetings = {
            "Hey! How's it going?",
            "Hi there!",
            "Hello! Nice to see you.",
            "Yo! What’s up?",
            "Good to see you!"
        };

        String[] smallTalk = {
            "The weather’s been pretty wild lately, huh?",
            "Have you seen any good shows or movies recently?",
            "I can't believe it's already September!",
            "Been working on anything interesting?",
            "Time flies, doesn't it?"
        };

        String[] thoughtfulRemarks = {
            "Sometimes doing nothing is the best way to recharge.",
            "It's okay to not be okay. Seriously.",
            "You're doing better than you think.",
            "Even robots need rest—so I imagine humans definitely do!",
            "Taking breaks is productive, actually."
        };

        String[] goodbyes = {
            "Alright, I’ll catch you later!",
            "Take care of yourself.",
            "Don’t forget to drink water!",
            "Have a great rest of your day!",
            "Bye for now!"
        };

        printRandomPhrase("Greeting", greetings);
        Thread.sleep(2000);
        printRandomPhrase("Small Talk", smallTalk);
        Thread.sleep(2500);
        printRandomPhrase("Remark", thoughtfulRemarks);
        Thread.sleep(2000);
        printRandomPhrase("Goodbye", goodbyes);
    }

    private static void printRandomPhrase(String type, String[] phrases) {
        Random random = new Random();
        int index = random.nextInt(phrases.length);
        System.out.println("[" + type + "] " + phrases[index]);
    }
}
