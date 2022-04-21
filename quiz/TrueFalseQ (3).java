package lab4;

/**
 * Represents a True/False question.
 */
public class TrueFalseQ extends Question {

	/**
	 * Sets the correct answer, which must be "True" or "False".
	 * 
	 * @param correctAnswer The answer to set
	 */
	public void setAnswer(String correctAnswer) throws IllegalArgumentException {
		// if given answer is neither "True" or "False" throws exception
		if (correctAnswer.equals("True") || correctAnswer.equals("False")) {
			super.setAnswer(correctAnswer);
		} else {
			System.out.println("A valid answer must be either \"True\" or \"False\".");
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Prints the question, along with a prompt to answer either "True" or "False".
	 */
	public void printQuestion() {
		super.printQuestion();
		System.out.println("Please answer \"True\" or \"False\".");
	}

	/**
	 * If answer is not null and is either "True" or "False" returs true otherwise
	 * returns false.
	 */
	public boolean validate() {
		if ((answer != null) && (answer.equals("True") || answer.equals("False"))) {
			return true;
		}
		return false;
	}

}
