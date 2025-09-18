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
        friendly.put("compliment", new String[]{
            "You have a great smile!",
            "Your positivity is infectious.",
            "You’re really easy to talk to.",
            "I appreciate your sense of humor.",
            "You brighten up the room."
        });
        friendly.put("question", new String[]{
            "What’s your favorite way to relax?",
            "Have you tried any new hobbies lately?",
            "What’s a good movie you’ve seen recently?",
            "Do you have any weekend plans?",
            "What’s something that made you laugh today?"
        });
        friendly.put("advice", new String[]{
            "Remember to take breaks when you need them.",
            "Stay curious and keep learning.",
            "Sometimes a short walk helps clear the mind.",
            "Don’t be afraid to ask for help.",
            "Keep a positive mindset."
        });
        friendly.put("story", new String[]{
            "I once got lost in a city but found a great coffee shop.",
            "There was this funny moment when my cat tried to 'help' me work.",
            "I met someone who taught me a new card game recently.",
            "One time, I accidentally wore mismatched shoes all day.",
            "I once baked cookies and they turned out surprisingly good!"
        });
        friendly.put("observation", new String[]{
            "People tend to smile more when they’re genuinely happy.",
            "Sometimes, the best ideas come when you least expect them.",
            "I notice that music can change the whole mood of a room.",
            "Small gestures often mean the most.",
            "Weather can really affect our energy levels."
        });

        // Sarcastic tone
        Map<String, String[]> sarcastic = new HashMap<>();
        sarcastic.put("greeting", new String[]{
            "Oh, joy. You're here.",
            "Great, another human.",
            "Hi... I guess.",
            "What a pleasant surprise... not.",
            "Oh look, it's social time. *yay*."
        });
        sarcastic.put("smalltalk", new String[]{
            "Sure, the weather is just *fascinating*.",
            "Seen anything worth not watching?",
            "Small talk — a slightly worse option than shoving ones head into a wood chipper.",
            "Small talk is my favorite thing — a small amount of talking."
        });
        sarcastic.put("remark", new String[]{
            "Wow, such depth. Much insight.",
            "Take a break... or don’t. Whatever.",
            "You're a beacon of mediocrity!",
            "Even my code has its limits, and you just found them. By which I mean, nothing I could program could respond to that politely. And I don't intend on fixing that oversight.",
            "Resting is productive — said lazy people everywhere."
        });
        sarcastic.put("goodbye", new String[]{
            "Finally, sweet silence.",
            "Another one bites the dust.",
            "Wake me up when September ends. Maybe by then you're personality will have evolved enough to become tolerable.",
            "Finally. Good riddance.",
            "Don't do anything I wouldn't pretend to care about.",
            "Goodbye. Or whatever.",
            "And they vanish into the void...finally"
        });
        sarcastic.put("compliment", new String[]{
            "You’re almost as charming as a brick.",
            "Your enthusiasm is *riveting*. By which I mean, people are only there because they've been rivited into place.",
            "You have a unique talent for stating the obvious.",
            "You light up a room... like a house fire. In the way that when you are in a room, everyone runs out screaming.",
            "Your wit is... well, it's something."
        });
        sarcastic.put("question", new String[]{
            "What’s your favorite way to waste time?",
            "Have you mastered the art of procrastination yet?",
            "Do you have a hobby that involves avoiding people? Because I do. It's why I wrote this code.",
            "What’s the most pointless thing you’ve done today?",
            "Ever considered becoming a professional napper?"
        });
        sarcastic.put("advice", new String[]{
            "Try not to bore yourself too much.",
            "Lower your expectations. It helps.",
            "Fake it till you make it... or at least till lunch.",
            "Remember: naps > productivity.",
            "Avoiding responsibility is an art form, and I'm Pierre Bonnard. Why? Because he's really good at it, but his talent flies under the radar."
        });
        sarcastic.put("story", new String[]{
            "Once I tried being productive. It lasted about five minutes.",
            "I told a joke once, but no one laughed — same as now.",
            "Someone once said, ‘You do you.’ I still don’t know what that means.",
            "I was going to write a novel but got distracted by writing this code so I didnt have to talk to you.",
            "I once got lost... on my way to the fridge."
        });
        sarcastic.put("observation", new String[]{
            "Everyone’s pretending to listen. Including me.",
            "The weather is as exciting as watching paint dry.",
            "People smile when they realize the meeting is over.",
            "Coffee is the only reason humans tolerate mornings.",
            "Small talk is the glue holding civilization together."
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
        formal.put("compliment", new String[]{
            "Your dedication is truly admirable.",
            "You have an exceptional manner.",
            "Your insight is greatly appreciated.",
            "You exhibit commendable qualities.",
            "Your presence is both dignified and inspiring."
        });
        formal.put("question", new String[]{
            "Might I inquire about your latest accomplishments?",
            "Have you attended any noteworthy events recently?",
            "What is your perspective on current affairs?",
            "Do you favor any particular literary works?",
            "How do you prefer to spend your leisure time?"
        });
        formal.put("advice", new String[]{
            "It is prudent to balance work with rest.",
            "Continuous learning fosters personal growth.",
            "Consider engaging in reflective practices.",
            "Maintain decorum in all social interactions.",
            "Strive for excellence in all endeavors."
        });
        formal.put("story", new String[]{
            "Once, I attended a symposium on human behavior.",
            "I recall a discussion about the virtues of patience.",
            "There was an event celebrating classical literature.",
            "I encountered a gentleman who spoke eloquently on philosophy.",
            "A memorable occasion involved an art exhibition opening."
        });
        formal.put("observation", new String[]{
            "The subtleties of human interaction are profound.",
            "Politeness should not be confused with nicities. One is a nesscary social convention, the other, a waste of time.",
            "Time management is essential for success.",
            "Cultural nuances enrich conversations.",
            "Respect is the foundation of meaningful dialogue."
        });

        // Cheerful tone
        Map<String, String[]> cheerful = new HashMap<>();
        cheerful.put("greeting", new String[]{
            "Hey sunshine!",
            "Top of the morning to ya!",
            "Hi there! You're looking awesome today!",
            "Howdy, friend!",
            "Lovely to see you!"
        });
        cheerful.put("smalltalk", new String[]{
            "Isn’t today just bursting with possibilities?",
            "I saw a puppy today. That made it a good day.",
            "Every day’s a new chance, huh?",
            "Hope something fun finds you today!",
            "Life’s too short for boring coffee."
        });
        cheerful.put("remark", new String[]{
            "You're seriously crushing it!",
            "Look at you, being all awesome!",
            "You make the world a brighter place.",
            "You're like a walking serotonin boost!",
            "If good vibes had a face, it’d be yours."
        });
        cheerful.put("goodbye", new String[]{
            "Catch you on the sunny side!",
            "Stay golden!",
            "Shine on, superstar!",
            "Keep smiling!",
            "Toodle-oo!"
        });
        cheerful.put("compliment", new String[]{
            "Your energy is contagious!",
            "You have a heart of gold.",
            "You brighten every room you walk into.",
            "You're a breath of fresh air!",
            "You make Mondays feel like Fridays."
        });
        cheerful.put("question", new String[]{
            "What’s something that made you smile today?",
            "If you could teleport anywhere right now, where would it be?",
            "Got any fun plans coming up?",
            "What’s something you’re excited about?",
            "When was the last time you laughed till it hurt?"
        });
        cheerful.put("advice", new String[]{
            "Smile often — it’s free and powerful.",
            "Celebrate the little wins!",
            "Chase joy, not perfection.",
            "Dance like nobody's buffering.",
            "Start the day with gratitude — it works wonders."
        });
        cheerful.put("story", new String[]{
            "One time, I accidentally complimented a dog's sweater! I was talking about their owner!.",
            "I once got caught in the rain and ended up dancing in it. No regrets!",
            "I met someone who carried bubbles everywhere — instant mood lifter.",
            "There was a squirrel outside doing yoga. Probably better than me at it.",
            "One kid told me unicorns are real because 'rainbows need jobs.'"
        });
        cheerful.put("observation", new String[]{
            "People smile more when the sun’s out.",
            "Laughter is the most underrated workout.",
            "Kindness seems to echo louder than sarcasm.",
            "Coffee shops are full of tiny stories.",
            "Everyone’s just trying their best, really."
        });

        // Melancholic tone
        Map<String, String[]> melancholic = new HashMap<>();
        melancholic.put("greeting", new String[]{
            "Oh... hello.",
            "Hi. It’s been a day, huh?",
            "Nice to see someone still hanging in there.",
            "Hey. You okay?",
            "Hey... been thinking a lot."
        });
        melancholic.put("smalltalk", new String[]{
            "Feels like the days blur together sometimes.",
            "Music really hits different lately.",
            "It’s been quiet... too quiet.",
            "Time moves weird when you’re deep in thought.",
            "Sometimes, silence says more than words."
        });
        melancholic.put("remark", new String[]{
            "It’s okay not to be okay.",
            "Some days are just heavier than others.",
            "Even in the dark, you're not alone.",
            "Wounds take time. You’ll get there.",
            "Not all progress is visible."
        });
        melancholic.put("goodbye", new String[]{
            "Take care of yourself, okay?",
            "Until next time... whenever that is.",
            "Wishing you peace, even in small doses.",
            "Goodbye... for now.",
            "Fade to black... but only briefly."
        });
        melancholic.put("compliment", new String[]{
            "You carry your pain with quiet strength.",
            "There’s beauty in how you endure.",
            "Even in sadness, you shine.",
            "You’re more resilient than you realize.",
            "Your kindness still reaches others."
        });
        melancholic.put("question", new String[]{
            "What helps you breathe when it’s hard to?",
            "Have you found any peace lately?",
            "Do you ever feel like the sky mirrors your mood?",
            "What do you miss most these days?",
            "Who do you think about when it rains?"
        });
        melancholic.put("advice", new String[]{
            "Let yourself feel. It’s okay to pause.",
            "Write. Let the weight out on paper.",
            "Talk to someone — even if just a whisper.",
            "Don’t rush the healing.",
            "Sometimes surviving is enough."
        });
        melancholic.put("story", new String[]{
            "I once sat in the rain for hours. It felt like the sky cried with me.",
            "I was told I was a happy person once. It was a beautiful blatant lie.",
            "I met a man who only painted in shades of gray. He said color was ‘too loud’. I agreed",
            "A friend sent me a song that described my mood — It was 'Fade to Black' by Metalica.",
            "There’s a bench by the lake. I go there when I want to disappear."
        });
        melancholic.put("observation", new String[]{
            "People hide pain with smiles better than you think.",
            "Sometimes the moon feels like the only witness.",
            "You notice more when you're quiet.",
            "Sadness has a way of sharpening the soul.",
            "Someday you will die and you will be forgotten and all your contributions in this world will be erased."
        });

        // Add all tones to main map
        dialogueMap.put("friendly", friendly);
        dialogueMap.put("sarcastic", sarcastic);
        dialogueMap.put("formal", formal);
        dialogueMap.put("cheerful", cheerful);
        dialogueMap.put("melancholic", melancholic);
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
        List<String> types = Arrays.asList(
            "greeting", "smalltalk", "remark", "goodbye", "compliment", "question", "advice", "story", "observation"
        );
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
