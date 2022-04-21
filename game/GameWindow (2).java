package game;

//package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener {


	private boolean player = true;

	private GameButton[][] buttons;
	private GameButton resetButton;
	private JLabel statusLabel;

	public GameWindow(int size) {
		super("Let's play a game!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		statusLabel = new JLabel(" ");

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(size, size));

		buttons = new GameButton[size][];
		for (int i = 0; i < size; i++) {
			buttons[i] = new GameButton[size];
			for (int j = 0; j < size; j++) {
				GameButton button = new GameButton();
				button.setFont(button.getFont().deriveFont(25.0f));
				button.setPreferredSize(new Dimension(100, 100));
				buttonPanel.add(button);
				buttons[i][j] = button;
				button.addActionListener(this);

			}
		}

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(statusLabel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);

		resetButton = new GameButton("Reset");
		getContentPane().add(resetButton, BorderLayout.SOUTH);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < buttons.length; i++) {
					for (int j = 0; j < buttons.length; j++) {
						buttons[i][j].reset();
					}
				}
				statusLabel.setText(" ");
				player = true;
			}
		});

		pack();
	}

	// if a button is clicked it responds with assigning symbol to the button and
	// checks if there is a winner
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if (buttons[i][j] == e.getSource()) {
					if (player) {
						buttons[i][j].setSymbol("1");
						statusLabel.setText("Current player 2");
						player = false;
						checkIfWinner();
					} else {
						buttons[i][j].setSymbol("2");
						statusLabel.setText("Current player 1");
						player = true;
						checkIfWinner();
					}
				}
			}
		}
	}

	// deactivates all buttons so that they cannot be pressed
	public void buttonsDisabled() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
	}

	public void twoByTwo(GameButton[] arr) {
		if (arr[0].getSymbol() != null && arr[1].getSymbol() != null && arr[2].getSymbol() != null
				&& arr[3].getSymbol() != null) {
			if ((arr[0].getSymbol()).equals("1") && (arr[1].getSymbol()).equals("1") && (arr[2].getSymbol()).equals("1")
					&& (arr[3].getSymbol()).equals("1")) {
				statusLabel.setText("Winner: player 1");
				buttonsDisabled();
			}
			if ((arr[0].getSymbol()).equals("2") && (arr[1].getSymbol()).equals("2") && (arr[2].getSymbol()).equals("2")
					&& (arr[3].getSymbol()).equals("2")) {
				statusLabel.setText("Winner: player 2");
				buttonsDisabled();
			}

		}
	}

	// check if any of players has square two by two
	public void checkIfWinner() {
		// if all buttons been used then disable them
		int counter = 0;
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if (buttons[i][j].getSymbol() != null) {
					counter++;

				}
			}
		}
		if (counter == 16) {
			statusLabel.setText("Board is full with no winner");
			buttonsDisabled();
		}
		counter = 0;

		GameButton[] arr = new GameButton[4];
		int arr_counter = 0;
		int c = -1;
		for (int d = 0; d < 9; d++) {
			if (d == 3 || d == 6) {
				c = -1;
			}
			// after first 3 squares increment i by 1 and iterate through next 3 squares
			if (d >= 3 && d < 6) {
				c = c + 1;

				for (int i = 1; i < 3; i++) {
					for (int j = 0; j < 2; j++) {
						arr[arr_counter] = buttons[i][j + c];
						arr_counter++;
					}
				}
				twoByTwo(arr);
				arr_counter = 0;
			}
			// after 6 squares been checked increment i by 1 and check the last 3 squares
			else if (d >= 6) {
				c = c + 1;

				for (int i = 2; i < 4; i++) {
					for (int j = 0; j < 2; j++) {
						arr[arr_counter] = buttons[i][j + c];
						arr_counter++;
					}
				}
				twoByTwo(arr);
				arr_counter = 0;
				if (d == 8) {
					c = -1;
				}
			} else {
				c = c + 1;

				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						arr[arr_counter] = buttons[i][j + c];
						arr_counter++;
					}
				}
				twoByTwo(arr);
				arr_counter = 0;

			}
		}

	}

	/**
	 * Main method -- just creates and displays the window.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameWindow(4).setVisible(true);
			}
		});
	}
}
