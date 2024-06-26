package org.Osttra.QuizApp;

import java.util.Random;

class MCQquiz{
    private MCQuestion[] questions;
    private int current;
    MCQquiz(){
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
    }

    MCQuestion pick(){
    Random r = new Random();
    int index= r.nextInt(questions.length);
        return questions[index];
    }
   
}
