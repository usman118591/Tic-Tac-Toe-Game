import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe
    extends JApplet
{

	private JButton btnA1, btnA2, btnA3, btnB1, btnB2, btnB3, btnC1, btnC2, btnC3;

	private TicTacToeBoard board;

	public void init()
	{
		// Set up the grid
		this.setSize(300,300);
		JPanel panel1 = new JPanel();
	    panel1.setSize(300,300);
	    panel1.setLayout(new GridLayout(3,3));
	    btnA1 = createButton("A1");
	    btnA2 = createButton("A2");
	    btnA3 = createButton("A3");
	    btnB1 = createButton("B1");
	    btnB2 = createButton("B2");
	    btnB3 = createButton("B3");
	    btnC1 = createButton("C1");
	    btnC2 = createButton("C2");
	    btnC3 = createButton("C3");
		panel1.add(btnA1);
		panel1.add(btnA2);
		panel1.add(btnA3);
		panel1.add(btnB1);
		panel1.add(btnB2);
		panel1.add(btnB3);
		panel1.add(btnC1);
		panel1.add(btnC2);
		panel1.add(btnC3);
	    this.add(panel1);
	    this.setVisible(true);

		// Start the game
		board = new TicTacToeBoard();

	}

	private JButton createButton(String square)
	{
		JButton btn = new JButton();
		btn.setPreferredSize(new Dimension(50, 50));
		Font f = new Font("Dialog", Font.PLAIN, 72);
		btn.setFont(f);
		btn.addActionListener(e -> btnClick(e, square));
		return btn;
	}

	private void btnClick(ActionEvent e, String square)
	{
		if (board.getSquare(square) != 0)
			return;

		JButton btn = (JButton)e.getSource();
		btn.setText("X");


		board.playAt(square, 1);

		if (board.isGameOver() == 3)
		{
			JOptionPane.showMessageDialog(null,
				"It's a draw!", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}

		if (board.isGameOver() == 1)
		{
			JOptionPane.showMessageDialog(null,
				"You beat me!", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}

		String computerMove = board.getNextMove();
		board.playAt(computerMove,2);

		switch (computerMove)
		{
			case "A1":
				btnA1.setText("O");
				break;
			case "A2":
				btnA2.setText("O");
				break;
			case "A3":
				btnA3.setText("O");
				break;
			case "B1":
				btnB1.setText("O");
				break;
			case "B2":
				btnB2.setText("O");
				break;
			case "B3":
				btnB3.setText("O");
				break;
			case "C1":
				btnC1.setText("O");
				break;
			case "C2":
				btnC2.setText("O");
				break;
			case "C3":
				btnC3.setText("O");
				break;
		}

		if (board.isGameOver() == 2)
		{
			JOptionPane.showMessageDialog(null,
				"I beat you!", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}
	}

	private void resetGame()
	{
		board.reset();
		btnA1.setText("");
		btnA2.setText("");
		btnA3.setText("");
		btnB1.setText("");
		btnB2.setText("");
		btnB3.setText("");
		btnC1.setText("");
		btnC2.setText("");
		btnC3.setText("");
	}
}
