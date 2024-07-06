import java.util.Random;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        Question[] questions = new Question[5];
        questions[0] = new Question("Which company do you work?", new String[]{"1. Osttra", "2. S&P", "3.Cvent", "4. maste"}, 1);
        questions[1] = new Question("Who is teaching us java ?", new String[]{"DEEP", "2. GAURAV", "3. KARTIK", "4. YASH"}, 3);
        questions[2] = new Question("what does osttra do", new String[]{"1. play", "2. post trade", "3. trade", "4. Banking"}, 2);
        questions[3] = new Question("WhWhat is 8+8 ?", new String[]{"1. 0", "2. 16", "3. 10", "4. 2"}, 2);
        questions[4] = new Question("Who found 0?", new String[]{"1. Charles ", "2. Aryabhatta", "3. William Shakespeare", "4. Gaurav"}, 3);

        int score = 0;
        int remainingQuestions = questions.length;

        for (int i = 0; i < questions.length; i++) {
            int questionIndex = random.nextInt(remainingQuestions);
            Question question = questions[questionIndex];

            System.out.println(question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == question.correctAnswer) {
                score++;
            }

            // Move the used question to the end of the array
            remainingQuestions--;
            Question temp = questions[questionIndex];
            questions[questionIndex] = questions[remainingQuestions];
            questions[remainingQuestions] = temp;
        }

        System.out.println("You scored " + score + " out of " + questions.length);
        scanner.close();
    }
}
        