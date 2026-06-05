import java.util.HashMap;
import java.util.Scanner;

// NLP Processor Class
class NLPProcessor {

    public String processInput(String input) {
        return input.toLowerCase().trim();
    }
}

// Chatbot Class
class Chatbot {

    private HashMap<String, String> knowledgeBase;

    public Chatbot() {
        knowledgeBase = new HashMap<>();

        // FAQ Training Data
        knowledgeBase.put("hello", "Hello! How can I help you today?");
        knowledgeBase.put("hi", "Hi! Nice to meet you.");
        knowledgeBase.put("how are you", "I am doing well. Thanks for asking!");
        knowledgeBase.put("what is java",
                "Java is a popular object-oriented programming language.");
        knowledgeBase.put("who created java",
                "Java was developed by James Gosling at Sun Microsystems.");
        knowledgeBase.put("what is ai",
                "Artificial Intelligence is the simulation of human intelligence by machines.");
        knowledgeBase.put("what is machine learning",
                "Machine Learning enables systems to learn from data and improve automatically.");
        knowledgeBase.put("what is oop",
                "OOP stands for Object-Oriented Programming.");
        knowledgeBase.put("thank you",
                "You're welcome!");
        knowledgeBase.put("bye",
                "Goodbye! Have a great day!");
    }

    public String getResponse(String userInput) {

        for (String question : knowledgeBase.keySet()) {
            if (userInput.contains(question)) {
                return knowledgeBase.get(question);
            }
        }

        return "Sorry, I don't understand that question. Please try asking something else.";
    }
}

// Main Class
public class AIChatbot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        NLPProcessor nlp = new NLPProcessor();
        Chatbot chatbot = new Chatbot();

        System.out.println("=================================");
        System.out.println("      ARTIFICIAL INTELLIGENCE CHATBOT");
        System.out.println("=================================");
        System.out.println("Type 'bye' to exit.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = scanner.nextLine();

            String processedInput = nlp.processInput(userInput);

            String response = chatbot.getResponse(processedInput);

            System.out.println("Bot: " + response);

            if (processedInput.equals("bye")) {
                break;
            }
        }

        scanner.close();
    }
}
