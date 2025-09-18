/*Copyright [yyyy] [name of copyright owner]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
import java.util.*;

public class Socializer {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Map<String, Map<String, String[]>> dialogueMap = new HashMap<>();

    public static void main(String[] args) {
        setupDialogues();
        System.out.println("=== Human Conversation Simulator ===\n");

        while (true) {
            String tone = chooseTone();
            String type = chooseDialogueType();
            printRandomPhrase(tone, type);

            System.out.print("\nWould you like to generate another? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes") && !again.equals("y")) {
                System.out.println("Goodbye! Try not to talk to too many people!");
                break;
            }
            System.out.println("\n----------------------------------\n");
        }
    }

    // Step 1: Setup all dialogue phrases
    private static void setupDialogues() {
        // Friendly tone
        Map<String, String[]> friendly = new HashMap<>();
        friendly.put("greeting", new String[]{
            "Hey! How's it going?",
            "Hi there!",
            "Hello! Nice to see you.",
            "Yo! What’s up?",
            "Good to see you!"
        });
        friendly.put("smalltalk", new String[]{
            "The weather’s been nice lately, right?",
            "Seen anything good on Netflix?",
            "Time’s flying by these days.",
            "Been up to anything cool?",
            "Hope your week’s been chill."
        });
        friendly.put("remark", new String[]{
            "You're doing better than you think.",
            "It’s okay to take a break.",
            "One step at a time, yeah?",
            "We all need rest sometimes.",
            "You’ve got this!"
        });
        friendly.put("goodbye", new String[]{
            "Catch you later!",
            "Take care!",
            "Don't forget to hydrate!",
            "Have a great one!",
            "Bye for now!"
        });

        // Sarcastic tone
        Map<String, String[]> sarcastic = new HashMap<>();
        sarcastic.put("greeting", new String[]{
            "Oh, joy. You're here.",
            "Great, another human.",
            "Hi... I guess.",
            "What a pleasant surprise... not.",
            "Oh look, it's social time."
        });
        sarcastic.put("smalltalk", new String[]{
            "Sure, the weather is just *fascinating*.",
            "Seen anything worth not watching?",
            "Can’t believe it’s September... again.",
            "Doing anything remotely interesting?",
            "Small talk is my favorite thing — said no one ever."
        });
        sarcastic.put("remark", new String[]{
            "Wow, such depth. Much insight.",
            "Take a break... or don’t. Whatever.",
            "You're a beacon of mediocrity!",
            "Even AI has limits, and you just found them.",
            "Resting is productive — said lazy people everywhere."
        });
        sarcastic.put("goodbye", new String[]{
            "Finally, sweet silence.",
            "Later, social butterfly.",
            "Don't do anything I wouldn't pretend to care about.",
            "Goodbye. Or whatever.",
            "And they vanish into the void..."
        });

        // Formal tone
        Map<String, String[]> formal = new HashMap<>();
        formal.put("greeting", new String[]{
            "Greetings. I hope you are well.",
            "Good day to you.",
            "Pleasure to make your acquaintance.",
            "Hello. How do you do?",
            "Welcome."
        });
        formal.put("smalltalk", new String[]{
            "The current weather patterns have been notable.",
            "Have you engaged in any recent cultural activities?",
            "Time, as always, proceeds swiftly.",
            "May I inquire about your recent endeavors?",
            "Do you find the pace of life agreeable?"
        });
        formal.put("remark", new String[]{
            "It is both natural and necessary to rest.",
            "You are making commendable progress.",
            "Perfection is a process, not a destination.",
            "Clarity often follows contemplation.",
            "Balance is a virtue worth maintaining."
        });
        formal.put("goodbye", new String[]{
            "Farewell. Wishing you continued success.",
            "Until our paths cross again.",
            "Be well and take care.",
            "It has been a pleasure.",
            "Goodbye."
        });

        // Add tones to main map
        dialogueMap.put("friendly", friendly);
        dialogueMap.put("sarcastic", sarcastic);
        dialogueMap.put("formal", formal);
    }

    // Step 2: Let user choose tone
    private static String chooseTone() {
        List<String> tones = new ArrayList<>(dialogueMap.keySet());
        System.out.println("Choose a tone:");
        for (int i = 0; i < tones.size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, capitalize(tones.get(i)));
        }

        while (true) {
            System.out.print("Enter number of your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= tones.size()) {
                    return tones.get(choice - 1);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Try again.");
        }
    }

    // Step 3: Let user choose dialogue type
    private static String chooseDialogueType() {
        List<String> types = Arrays.asList("greeting", "smalltalk", "remark", "goodbye");
        System.out.println("\nChoose a dialogue type:");
        for (int i = 0; i < types.size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, capitalize(types.get(i)));
        }

        while (true) {
            System.out.print("Enter number of your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= types.size()) {
                    return types.get(choice - 1);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Try again.");
        }
    }

    // Step 4: Print random phrase based on tone + type
    private static void printRandomPhrase(String tone, String type) {
        Map<String, String[]> toneMap = dialogueMap.get(tone);
        if (toneMap == null || !toneMap.containsKey(type)) {
            System.out.println("Oops! Something went wrong with that combination.");
            return;
        }

        String[] options = toneMap.get(type);
        int index = new Random().nextInt(options.length);
        System.out.printf("\n[%s - %s] %s%n", capitalize(tone), capitalize(type), options[index]);
    }

    // Utility method
    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
