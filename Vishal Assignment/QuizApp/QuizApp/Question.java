package QuizApp;

public class Question {
    String ques;

    String options;

    char answerOption;

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public char getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(char answerOption) {
        this.answerOption = answerOption;
    }

    public Question(String ques, String options, char answerOption) {
        this.ques = ques;
        this.options = options;
        this.answerOption = answerOption;
    }
    public Boolean checkAns(char userInp) {return userInp==answerOption;}
    public void printQues(){ System.out.println(ques);
    System.out.println(options);}
    
    
}
