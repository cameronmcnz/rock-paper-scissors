package com.mcnz.rps;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.mcnz.jfr.jmc.exceptions.HandleZeroInputGracefully;
import com.mcnz.jfr.jmc.memory.MemoryLeak;

public class DesktopGame {
	public enum Gesture {rock, paper, scissors, spock, lizard};

	public static void main(String[] args) {
		playTheGame();
	}

	private static void playTheGame() {
		String prompt = "Will it be rock, paper or scissors?";
		Score score = new Score();
		java.util.Vector<GameSummary> history = new java.util.Vector<GameSummary>();

		while (true) {
			String result = "error";
			String input = JOptionPane.showInputDialog(prompt);
			try {
				if (input.trim().equalsIgnoreCase("")) {
					HandleZeroInputGracefully.main(null);
				}
			} catch (Exception e1) {}
			if (input.equalsIgnoreCase(Gesture.lizard.toString())) {
				result = "lose";
				try {MemoryLeak.main(null);} 
				catch (IOException e) {e.printStackTrace();}
			}
			if (input.equalsIgnoreCase(Gesture.scissors.toString())) {
				result = "lose";
				score.increaseLosses();
			}
			if (input.equalsIgnoreCase(Gesture.paper.toString())) {
				result = "win";
				score.increaseWins();
			}
			if (input.equalsIgnoreCase(Gesture.rock.toString())) {
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


