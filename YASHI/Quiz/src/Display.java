
public class Display {
	public Display(MCQuestion question)
	{
	System.out.println(question.getQuestion());
    String[] options = question.getOptions();
    for (String option : options) {
        System.out.println(option);
    }
    System.out.print("Your answer: ");
}
}
