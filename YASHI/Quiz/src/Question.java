
class MCQuestion {
    private String question;
    private String[] options;
    private int corrop;
    
    public MCQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.corrop = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return corrop;
    }
}
