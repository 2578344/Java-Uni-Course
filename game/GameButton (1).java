package game;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Color;

public class GameButton extends JButton {
	// store button's symbol(1 or 2)
	private String symbol;

	// create a new gameButton
	public GameButton() {
	}

	// create a new gameButton and set symbol to be shown on the button
	public GameButton(String text) {
		this.setText(text);
	}

	// set symbol to be shown and change button's colour
	public void setSymbol(String symbol) {

		this.setText(symbol);
		// if given symbol is 1 then set red colour if 2 set blue
		if (symbol.equals("1")) {
			this.setBackground(Color.red);
		} else {
			this.setBackground(Color.blue);
		}
		// deactivates button so that it cannot be pressed
		this.setEnabled(false);
		this.symbol = symbol;

	}

	// return stored symbol if there's no symbol return null
	public String getSymbol() {
		if (symbol == null) {
			return null;
		}
		return symbol;
	}

	// reset all of the changes made in setSymbol
	public void reset() {

		this.setText("");
		this.setBackground(null);
		this.setEnabled(true);
		symbol = null;
	}

}
