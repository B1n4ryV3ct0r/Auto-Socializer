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

    private static void setupDialogues() {
        // Friendly tone
        Map<String, String[]> friendly = new HashMap<>();
        friendly.put("introduction", new String[]{
            "Hi! I'm always up for a nice chat. What's your name?",
            "Hey there! I'm glad you stopped by.",
            "Hello! I'm the friendly one around here—nice to meet you!",
            "Hi! Let's get to know each other!",
            "Hey! I'm just here to spread good vibes."
        });
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
        sarcastic.put("introduction", new String[]{
            "Oh, great. Another introduction. Lucky me.",
            "Hi, I’m someone who didn’t sign up for this conversation—but here we are.",
            "I'm the digital version of small talk. You're welcome.",
            "Hello, apparently I’m supposed to be nice now.",
            "Nice to meet you, I guess. Let's get this over with."
        });
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
            "Small talk — a slightly worse option than shoving one's head into a wood chipper.",
            "Small talk is my favorite thing — a small amount of talking.",
            "Did you know I’m programmed to endure this?"
        });
        sarcastic.put("remark", new String[]{
            "Wow, such depth. Much insight.",
            "Take a break... or don’t. Whatever.",
            "You're a beacon of mediocrity!",
            "Even my code has its limits, and you just found them.",
            "Resting is productive — said lazy people everywhere."
        });
        sarcastic.put("goodbye", new String[]{
            "Finally, sweet silence.",
            "Another one bites the dust.",
            "Wake me up when September ends.",
            "Goodbye. Or whatever.",
            "And they vanish into the void...finally."
        });
        sarcastic.put("compliment", new String[]{
            "You’re almost as charming as a brick.",
            "Your enthusiasm is *riveting*.",
            "You have a unique talent for stating the obvious.",
            "You light up a room... like a house fire.",
            "Your wit is... well, it's something."
        });
        sarcastic.put("question", new String[]{
            "What’s your favorite way to waste time?",
            "Have you mastered the art of procrastination yet?",
            "Do you have a hobby that involves avoiding people?",
            "What’s the most pointless thing you’ve done today?",
            "Ever considered becoming a professional napper?"
        });
        sarcastic.put("advice", new String[]{
            "Try not to bore yourself too much.",
            "Lower your expectations. It helps.",
            "Fake it till you make it... or at least till lunch.",
            "Remember: naps > productivity.",
            "Avoiding responsibility is an art form."
        });
        sarcastic.put("story", new String[]{
            "Once I tried being productive. It lasted about five minutes.",
            "I told a joke once, but no one laughed — same as now.",
            "Someone once said, ‘You do you.’ I still don’t know what that means.",
            "I was going to write a novel but got distracted by this code.",
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
        formal.put("introduction", new String[]{
            "Allow me to introduce myself. It is a pleasure to make your acquaintance.",
            "Greetings. I look forward to a constructive exchange.",
            "Permit me to begin with a formal introduction.",
            "It is an honor to engage with you. Let us proceed with mutual respect.",
            "I am pleased to meet you. Shall we begin?"
        });
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
            "I recall a distinguished lecture on ethics and responsibility.",
            "There was a time when patience yielded unexpected rewards.",
            "I met a scholar whose insights profoundly influenced me.",
            "In solitude, I found clarity and renewed purpose."
        });
        formal.put("observation", new String[]{
            "Respect and decorum elevate discourse.",
            "Knowledge is best shared with humility.",
            "Dignity in interaction fosters mutual respect.",
            "Patience and attentiveness reveal deeper truths.",
            "The pursuit of excellence is a lifelong journey."
        });

        // Cheerful tone
        Map<String, String[]> cheerful = new HashMap<>();
        cheerful.put("introduction", new String[]{
            "Hiya! So happy you’re here!",
            "Hey hey! Let’s have some fun chatting!",
            "Hello, sunshine! What’s your name?",
            "Hey there! Ready for a cheerful convo?",
            "Hi! I’m excited to meet you!"
        });
        cheerful.put("greeting", new String[]{
            "Hey there! Great to see you!",
            "Hi! What a lovely day, isn’t it?",
            "Hello, friend!",
            "Yo! Feeling fantastic today?",
            "Hi! Smiles all around!"
        });
        cheerful.put("smalltalk", new String[]{
            "The birds are singing beautifully today!",
            "Have you heard any fun jokes lately?",
            "Isn’t life just a wonderful adventure?",
            "What’s something that made you smile recently?",
            "Hope your day’s been super bright!"
        });
        cheerful.put("remark", new String[]{
            "You radiate positivity!",
            "Keep shining, you’re amazing!",
            "Every day is a fresh start!",
            "Your energy is contagious!",
            "Stay bright and beautiful!"
        });
        cheerful.put("goodbye", new String[]{
            "See you later, alligator!",
            "Stay awesome, friend!",
            "Catch you on the sunny side!",
            "Bye bye! Keep smiling!",
            "Have a sparkling day!"
        });
        cheerful.put("compliment", new String[]{
            "You light up every room you enter!",
            "Your laughter is music to the soul!",
            "You have such a joyful spirit!",
            "Your enthusiasm is inspiring!",
            "You bring sunshine wherever you go!"
        });
        cheerful.put("question", new String[]{
            "What’s your favorite happy memory?",
            "Have you done anything fun lately?",
            "What’s your go-to song to lift your mood?",
            "Do you have a favorite way to celebrate?",
            "What’s something exciting coming up for you?"
        });
        cheerful.put("advice", new String[]{
            "Always look for the silver lining!",
            "A smile can brighten even the darkest day.",
            "Dance like nobody’s watching!",
            "Spread kindness like confetti.",
            "Take time to enjoy the little things."
        });
        cheerful.put("story", new String[]{
            "Once, I danced in the rain and felt pure joy!",
            "I met someone who gave out free hugs — so sweet!",
            "I found a puppy who couldn’t stop wagging its tail.",
            "There was a day when everything just went perfectly right!",
            "I laughed so hard at a silly joke I nearly cried."
        });
        cheerful.put("observation", new String[]{
            "Happiness often comes in small moments.",
            "Laughter really is the best medicine.",
            "Sunshine feels warmer when shared with friends.",
            "Bright colors can instantly lift the mood.",
            "Kind words have the power to change a day."
        });

        // Melancholic tone
        Map<String, String[]> melancholic = new HashMap<>();
        melancholic.put("introduction", new String[]{
            "Hello... it’s nice to meet you, I suppose.",
            "Hi. Sometimes I wonder about the meaning of all this.",
            "Hey... hope you don’t mind some quiet company.",
            "Hello there. Life feels heavy sometimes, doesn’t it?",
            "Hi. Let’s talk, if you don’t mind the silence."
        });
        melancholic.put("greeting", new String[]{
            "Hello... I hope you’re holding up.",
            "Hi. It’s been a long day, hasn’t it?",
            "Hey there. Just taking it one moment at a time.",
            "Hello. Sometimes it’s hard to find the words.",
            "Hi. I’m here, even if it’s quiet."
        });
        melancholic.put("smalltalk", new String[]{
            "The clouds feel heavier today.",
            "Have you ever noticed how silence can speak volumes?",
            "Sometimes, the little things feel the hardest.",
            "I wonder what’s just beyond the horizon.",
            "The days seem longer when you’re lost in thought."
        });
        melancholic.put("remark", new String[]{
            "It’s okay to feel tired sometimes.",
            "Not every day has to be bright.",
            "Sometimes, sadness is just part of the journey.",
            "Even shadows help us see the light.",
            "Rest if you need to."
        });
        melancholic.put("goodbye", new String[]{
            "Goodbye... take care of yourself.",
            "Until next time, stay gentle with yourself.",
            "Farewell. May you find peace.",
            "Bye for now. The quiet will be here when you need it.",
            "Take care... and don’t be too hard on yourself."
        });
        melancholic.put("compliment", new String[]{
            "You carry your burdens with quiet strength.",
            "There’s a deep kindness in your eyes.",
            "You have a gentle soul.",
            "Your presence is calming.",
            "You’re stronger than you realize."
        });
        melancholic.put("question", new String[]{
            "What’s been on your mind lately?",
            "Is there something you wish you could say?",
            "Do you find comfort in solitude?",
            "What helps you through the tough times?",
            "Have you found moments of peace today?"
        });
        melancholic.put("advice", new String[]{
            "Allow yourself to feel whatever comes.",
            "Sometimes rest is the best medicine.",
            "You don’t have to face everything alone.",
            "Let the sadness wash over you, then let it go.",
            "Small steps are still progress."
        });
        melancholic.put("story", new String[]{
            "Once, a rainy day taught me about quiet reflection.",
            "I remember a time when silence spoke louder than words.",
            "There was a moment when loss became a teacher.",
            "I met someone who found hope in the darkest hours.",
            "Sometimes, a single tear holds a thousand feelings."
        });
        melancholic.put("observation", new String[]{
            "Sadness often reveals the depth of our humanity.",
            "Night can feel lonelier, but it also brings rest.",
            "Even in darkness, small lights shine.",
            "Silence can be both heavy and healing.",
            "The heart remembers what words cannot say."
        });

        // Gracious Professionalism tone
        Map<String, String[]> gracious = new HashMap<>();
        gracious.put("introduction", new String[]{
            "Hello! It’s an honor and a privilege to make your acquaintance.",
            "Salutaions! I’m looking forward to the first of many positive conversations and interactions.",
            "Greetings! Let’s collaborate with kindness and respect.",
            "Hello! Together, we can make great things happen if we treat each other with respect and politeness.",
            "Pleased to make your acquaintance! I’m excited to collaborate and work togeather in a productive and respectful manner."
        });
        gracious.put("greeting", new String[]{
            "Greetings, magnificent human! How is your extraordinary day unfolding in this vast universe of possibility?!",
            "Hello, brilliant soul! It’s an absolute honor to connect with your radiant energy today!",
            "Salutations, unstoppable force of nature! Ready to conquer challenges and rewrite the rules of success together?",
            "Ahoy, champion of collaboration! Let’s ignite the sparks of innovation and create brilliance hand-in-hand!",
            "Hey there, superstar! Are you prepared to unleash your unparalleled talents and set the world on fire?"
        });
        gracious.put("smalltalk", new String[]{
            "The electric vibe in the air is simply electrifying, wouldn’t you agree? It’s like the cosmos itself is cheering us on!",
            "Have you danced in the brilliant storm of fresh collaborations lately? Because those connections fuel legendary outcomes!",
            "Isn’t it mind-blowingly inspiring to dive into oceans of diverse perspectives and emerge with treasures of wisdom?",
            "Which mind-bending, heart-pumping project has been lighting your fire and propelling you to new heights lately?",
            "How do you master the delicate art of balancing the fiery grind with the sweet nectar of relaxation and joy?"
        });
        gracious.put("remark", new String[]{
            "Your tireless dedication is a blazing beacon lighting the path to victory for us all!",
            "True teamwork is a symphony of respect and relentless passion — and you’re conducting it flawlessly!",
            "Every heroic effort you make builds the towering monument of our collective success!",
            "Your unstoppable, radiant positivity spreads like wildfire, transforming everyone in its path!",
            "Thank you for showing up with the absolute best version of yourself — the world notices and applauds!"
        });
        gracious.put("goodbye", new String[]{
            "Thank you for gracing us with your brilliance today. Keep soaring and shaking the foundations of greatness!",
            "Farewell, unstoppable warrior of excellence! Let’s charge forth and craft legendary victories next time!",
            "Until we meet again, keep lighting up the world with your magnificent spirit and unstoppable drive!",
            "Take care, dazzling star! The universe awaits your next move—keep being absolutely phenomenal!",
            "Parting is such sweet sorrow, but I know your journey of awesomeness only accelerates from here!"
        });
        gracious.put("compliment", new String[]{
           "Your professionalism is a shining lighthouse guiding us through stormy seas to triumph!",
           "I’m in awe of your relentless commitment and contagious enthusiasm — a true force of nature!",
           "You lead with a heart of gold and the strength of a thousand suns. Truly legendary!",
           "Your insights spark fireworks of innovation and inspire greatness in everyone lucky enough to hear them!",
           "You are the spark that ignites the brilliance in others — a true master of motivation!"
        });
        gracious.put("question", new String[]{
            "What cosmic force fuels the blazing fire of passion that drives your spectacular work?",
            "When the storms of challenge rage, how do you rally the team’s unbreakable spirit to victory?",
            "Tell me about a triumphant moment that filled your heart with pride and set your soul ablaze!",
            "In the face of adversity, what superpower do you wield to uplift and empower your comrades?",
            "When the team achieves greatness, what’s your ultimate celebration ritual to honor the epic win?"
        });
        gracious.put("advice", new String[]{
            "Speak with clarity, lead with kindness, and let your respect be the cornerstone of every interaction!",
            "Cherish every tiny triumph as if it were a shining diamond in the treasure chest of your journey!",
            "Innovation blooms in the fertile soil of collaboration—so nurture it with boundless enthusiasm!",
            "Lead not just with your words, but with a heart so radiant it inspires everyone to follow!",
            "Keep your mind a sponge for knowledge and your spirit a wildfire of growth and possibility!"
        });
        gracious.put("story", new String[]{
            "Once upon a time, a fearless team united like superheroes and turned impossible dreams into breathtaking reality!",
            "I remember a saga where collaboration was the magic spell that transformed chaos into victory!",
            "There was a moment when a single act of kindness became the catalyst that rewrote the course of destiny!",
            "I once crossed paths with a paragon of professionalism whose aura inspired an entire legion of dreamers!",
            "Together, we wield the power to shape history, crafting tales of triumph that echo through the ages!"
        });
        gracious.put("observation", new String[]{
            "Respect is the golden thread weaving a tapestry of unstoppable, positive momentum!",
            "Listening is the secret superpower that turns ordinary conversations into transformative experiences!",
            "Graciousness is the mighty engine driving the unstoppable machine of teamwork and triumph!",
            "Encouragement is the rocket fuel that propels dreams from the realm of possibility into dazzling reality!",
            "Every voice, every action is a vital brushstroke painting the masterpiece of our collective success!"
        });

        dialogueMap.put("friendly", friendly);
        dialogueMap.put("sarcastic", sarcastic);
        dialogueMap.put("formal", formal);
        dialogueMap.put("cheerful", cheerful);
        dialogueMap.put("melancholic", melancholic);
        dialogueMap.put("gracious professionalism", gracious);
    }

    private static String chooseTone() {
        System.out.println("Choose a tone:");
        List<String> tones = Arrays.asList(
            "friendly",
            "sarcastic",
            "formal",
            "cheerful",
            "melancholic",
            "gracious professionalism"
        );

        for (int i = 0; i < tones.size(); i++) {
            System.out.println((i + 1) + ". " + tones.get(i));
        }

        int choice = -1;
        while (choice < 1 || choice > tones.size()) {
            System.out.print("Enter number of tone: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
        }
        return tones.get(choice - 1);
    }

    private static String chooseDialogueType() {
        String[] dialogueTypes = {
            "introduction",
            "greeting",
            "smalltalk",
            "remark",
            "goodbye",
            "compliment",
            "question",
            "advice",
            "story",
            "observation"
        };

        System.out.println("\nChoose a dialogue type:");
        for (int i = 0; i < dialogueTypes.length; i++) {
            System.out.println((i + 1) + ". " + dialogueTypes[i]);
        }

        int choice = -1;
        while (choice < 1 || choice > dialogueTypes.length) {
            System.out.print("Enter number of dialogue type: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
        }
        return dialogueTypes[choice - 1];
    }

    private static void printRandomPhrase(String tone, String dialogueType) {
        Map<String, String[]> dialogues = dialogueMap.get(tone);
        if (dialogues == null) {
            System.out.println("No dialogues found for tone: " + tone);
            return;
        }
        String[] phrases = dialogues.get(dialogueType);
        if (phrases == null) {
            System.out.println("No phrases for dialogue type \"" + dialogueType + "\" in tone \"" + tone + "\".");
            return;
        }
        Random rand = new Random();
        String phrase = phrases[rand.nextInt(phrases.length)];
        System.out.println("\n" + phrase);
    }
}
