//import java.util.Random;
import java.util.Scanner;
class MCQquiz{
	MCQuestion[] questions;
    int current;
    Scanner scanner;
    
    public MCQquiz()
    {
	questions = new MCQuestion[5];
    
    questions[0] = new MCQuestion("What is the capital of India?",
            new String[]{"A. Paris", "B. Rome", "C. London", "D. Delhi"}, 3);
    questions[1] = new MCQuestion("Which planet is known as the Red Planet?",
            new String[]{"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"}, 1);
    questions[2] = new MCQuestion("What is the color of apple'?",
            new String[]{"A. Blue", "B. Yellow", "C. Red", "D. White"}, 2);
    questions[3] = new MCQuestion("What is the Capital of UP?",
            new String[]{"A. Lucknow", "B. Delhi", "C. Agra", "D. Meerut"}, 0);
    questions[4] = new MCQuestion("When is Indian Independence day?",
            new String[]{"A. 1 aug", "B. 15 aug", "C. 2 oct", "D. 26 jan"}, 1);
    
    
    current=0;
    
    scanner = new Scanner(System.in);
    }
    
    public void start()
    {
    	System.out.println("Welcome to the Multiple Choice Quiz!");
        System.out.println("Choose the correct option (A, B, C, D) for each question.");
        System.out.println("+5 for each correct answer.");
        System.out.println();
        System.out.println("Type 'next' to go to the next question, 'prev' to go to the previous question.");
        int score=0;

        while (current< questions.length && current >= 0) {
            MCQuestion currentQuestion = questions[current];
            Display d = new Display(currentQuestion);

            String userAnswer = scanner.nextLine().toUpperCase();
            if (userAnswer.equals("NEXT")) {
                current++;
            } else if (userAnswer.equals("PREV")) {
                current--;
            
            } else if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                int selectedOptionIndex = userAnswer.charAt(0) - 'A';
                if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
                    System.out.println("Correct!"); score +=5;
                } else {
                    System.out.println("Incorrect!");
                }
                current++;
                System.out.println("---------------------------------------------------------------");
            } else {
                System.out.println("Invalid input. Please enter A, B, C, D, 'next'or 'prev'.");
            }
        }
       
        System.out.println("Quiz ended. Thank you for playing!");
        System.out.println("Your score is - "+score);
        
    }
}