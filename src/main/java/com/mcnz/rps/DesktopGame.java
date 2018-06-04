package com.mcnz.rps;

import javax.swing.JOptionPane;

public class DesktopGame {
	public enum Gesture {rock,paper,scissors};

	public static void main(String[] args) {

		String prompt = "Will it be rock, paper or scissors?";
		Score score = new Score();
		java.util.Vector<GameSummary> history = new java.util.Vector<GameSummary>();

		while (true) {
			String result = "error";
			String input = JOptionPane.showInputDialog(prompt);
			if (input.equals(Gesture.scissors.toString())) {
				result = "lose";
				score.increaseLosses();
			}
			if (input.equals(Gesture.paper.toString())) {
				result = "win";
				score.increaseWins();
			}
			if (input.equals(Gesture.rock.toString())) {
				result = "tie";
				score.increaseTies();
			}
			if (input.equalsIgnoreCase("quit")) {
				break;
			}
			GameSummary gs = new GameSummary(input, "rock", result);
			history.add(gs);

			JOptionPane.showMessageDialog(null, result);
			System.out.println(score);
			for (GameSummary gameSummary : history) {
				System.out.println(gameSummary);
			}
			
		}
	}
}


