package GuessingGame;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class GuessingGameClass extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	int lives = 10;
	private int range1, range2;
	
	
	public void checkGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";
		String hint = "Made by GI.Corp";
		
		try {
		int guess = Integer.parseInt(guessText);
		hint = "From " + range1 + " to " + range2;
		
		if (lives > 0) {
			
		if (guess < theNumber)
		{
			lives--;
			message = guess + " is too low. Try again. " +
					"Your lives: " + lives;
		}
		else if (guess > theNumber)
		{
			lives--;
			message = guess + " is too high. Try again. " +
			"Your lives: " + lives;
		}
		else	{
			lives+=10;
			message = guess + " is correct. You win! Let's play again! " +
					"Your lives: " + lives;
			newGame();
		}}
		else
		{
			message = "Oops, you lose :( Starting new game..";
			lives=6;
			newGame();
		}
		} catch (Exception e)
		{
			message = "Enter a whole number between 1 and 100.";
		} finally {
			
		lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
	}
	}
	public void newGame()
	{
		theNumber = (int)(Math.random() * 100 + 1);
		range1 = theNumber - (int)(Math.random() * 30 + 1);
		range2 = theNumber + (int)(Math.random() * 30 + 1);
		//System.out.println("From " + range1 + " to " + range2);
	}
	
	public GuessingGameClass() {
		getContentPane().setBackground(new Color(51, 0, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Guess My Number Game");
		getContentPane().setLayout(null);
		
		JLabel lblGuessMyNumber = new JLabel("Guess My Number Game");
		lblGuessMyNumber.setForeground(new Color(255, 165, 0));
		lblGuessMyNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessMyNumber.setFont(new Font("Rough Draft", Font.BOLD, 50));
		lblGuessMyNumber.setBounds(235, 40, 866, 125);
		getContentPane().add(lblGuessMyNumber);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100: ");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessANumber.setForeground(new Color(255, 255, 255));
		lblGuessANumber.setFont(new Font("Rough Draft", Font.PLAIN, 24));
		lblGuessANumber.setBounds(416, 234, 504, 69);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setFont(new Font("Taco Salad", Font.PLAIN, 70));
		txtGuess.setForeground(new Color(255, 255, 255));
		txtGuess.setBackground(new Color(51, 0, 51));
		txtGuess.setBounds(565, 330, 206, 114);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		txtGuess.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				checkGuess();
			}
				});
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.setToolTipText("");
		btnGuess.setForeground(new Color(255, 255, 255));
		btnGuess.setBackground(new Color(102, 0, 102));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Rough Draft", Font.PLAIN, 25));
		btnGuess.setBounds(416, 486, 504, 52);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess");
		lblOutput.setForeground(new Color(255, 165, 0));
		lblOutput.setFont(new Font("Rough Draft", Font.PLAIN, 22));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(309, 592, 719, 69);
		getContentPane().add(lblOutput);
		
		JLabel lblMadeByGicorp = new JLabel("Made by GI.Corp");
		lblMadeByGicorp.setForeground(Color.WHITE);
		lblMadeByGicorp.setFont(new Font("Rough Draft", Font.PLAIN, 16));
		lblMadeByGicorp.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeByGicorp.setBounds(554, 672, 217, 36);
		getContentPane().add(lblMadeByGicorp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGameClass theGame = new GuessingGameClass();
		theGame.newGame();
		theGame.setSize(new Dimension(1366, 768));
		theGame.setVisible(true);
	}
}
