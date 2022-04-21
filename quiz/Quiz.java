package lab4;

/**
 * Represents quiz with questions
 */
public class Quiz {
	/** Stores questions in the array */
	private Question[] questions;
	/** Number of questions */
	private int nQuestions = 0;

	/**
	 * Creates a new Quiz with the given nQuestions.
	 * 
	 * @param nQuestions number of questions
	 */
	public Quiz(int nQuestions) {
		this.nQuestions = nQuestions;
		this.questions = new Question[nQuestions];
	}

	/**
	 * Assigns given question at position n to the array question.
	 * 
	 * @param n position/index -array
	 * @param q question object
	 */
	public void setQuestion(int n, Question q) throws IllegalArgumentException {
		if (n >= nQuestions) {
			throw new IllegalArgumentException();
		}
		questions[n] = q;
	}

	/**
	 * Prints the whole quiz, one guestion at the time.
	 */
	public void printQuiz() {
		for (int i = 0; i < nQuestions; i++) {
			questions[i].printQuestion();
		}
	}

	/**
	 * returns true when no question is null and no queston return false from
	 * validate method
	 */
	public boolean validate() {
		for (int i = 0; i < nQuestions; i++) {
			if (questions[i] != null && questions[i].validate() == true) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
