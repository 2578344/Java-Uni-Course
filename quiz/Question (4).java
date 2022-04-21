package lab4;

/**
 * Represents a single quiz question;
 */
public abstract class Question {

	/** The content of the question */
	private String text;
	/** The correct answer */
	protected String answer;
	/** The question number */
	protected int id;
	/** Stores the next question number to use */
	private static int nextId = 1;

	/**
	 * Creates a new Question with the given text and answer.
	 * 
	 * @param text   The question text
	 * @param answer The correct answer
	 */
	public Question(String text, String answer) {
		this.text = text;
		this.answer = answer;
		this.id = Question.nextId++;
	}

	/**
	 * Creates a new Question with empty strings for the text and answer.
	 */
	public Question() {
		this("", "");
	}

	/**
	 * Sets the question text.
	 * 
	 * @param textQuestion The question to use
	 */
	public void setText(String textQuestion) {
		this.text = textQuestion;
	}

	/**
	 * Sets the question answer.
	 * 
	 * @param correctAnswer The answer to set
	 */
	public void setAnswer(String correctAnswer) {
		this.answer = correctAnswer;
	}

	/**
	 * Checks whether the given response matches the correct answer.
	 * 
	 * @param response The response to check
	 * @return Whether the response is correct
	 */
	public boolean checkAnswer(String response) {
		return response.equals(answer);
	}

	/**
	 * Prints the question number and text.
	 */
	public void printQuestion() {
		System.out.println(id + ". " + text);
	}

	/**
	 * Checks if question is made correct
	 */
	public abstract boolean validate();
}