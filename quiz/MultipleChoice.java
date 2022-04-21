package lab4;

/**
 * Represents a question with up to four multiple-choice options.
 */
public class MultipleChoice extends Question {

	/** The list of choices */
	private String[] choices;
	/** Which choice will be added next */
	private int choiceCounter = 0;
	// number of choices to add
	private int nChoices;

	/**
	 * Creates a new MultipleChoice with the given nChoices.
	 * 
	 * @param nChoices number of choices
	 */
	public MultipleChoice(int nChoices) throws IllegalArgumentException {
		// check if nChoices is not equal to 0 or less if so throws an exception
		if (nChoices <= 0) {
			throw new IllegalArgumentException();
		}
		this.nChoices = nChoices;
		this.choices = new String[nChoices];
	}

	/**
	 * Adds the given choice to the list if there is space.
	 * 
	 * @param choice  The choice to add
	 * @param correct Whether the choice should be considered correct
	 */
	public void addChoice(String choice, boolean correct) {
		// if user wants to add more then nChoices throws an exception
		if (choiceCounter >= nChoices) {
			throw new IllegalArgumentException();
		}
		if (choiceCounter < nChoices) {
			choices[choiceCounter] = choice;
			choiceCounter++;

			if (correct) {
				String answer = id + "." + choiceCounter + "";
				setAnswer(answer);
			}
		}
	}

	/**
	 * Prints the question followed by all of the multiple-choice options.
	 * 
	 * @see Question#printQuestion()
	 */
	public void printQuestion() {
		super.printQuestion();
		for (int i = 0; i < nChoices; i++) {
			if (choices[i] != null) {
				System.out.println(id + "." + (i + 1) + " " + choices[i]);
			}
		}
	}

	/**
	 * Returns true only when all choices are defined not equal to null and no two
	 * choices are identical to each other
	 */
	public boolean validate() {
		for (int i = 0; i < nChoices; i++) {
			if (choices[i] == null) {
				return false;
			}
			if (i == nChoices - 1) {
				continue;
			} else {
				for (int j = i + 1; j < nChoices; j++)
					if (choices[i].equals(choices[j]) == true)
						return false;
			}
		}
		return true;
	}

}
