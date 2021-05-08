package com.mcnz.rps.moai;

public class AggregateProcessor {
	public static Score score = new Score();
	
	public Score updateScore(Result result) {
		if (result == Result.WIN) {
			this.increaseWins();
		}
		
		if (result == Result.LOSE) {
			this.increaseLosses();
		}
		
		if (result == Result.TIE) {
			this.increaseTies();
		}
		return score;
	}

	public Score increaseWins() {
		score.increaseWins();
		return score;
	}

	public Score increaseLosses() {
		score.increaseLosses();
		return score;
	}

	public Score increaseTies() {
		score.increaseTies();
		return score;
	}


	public int getWins() {
		return score.getWins();
	}

	public int getLosses() {
		return score.getLosses();
	}

	public int getTies() {
		return score.getTies();
	}
	
	public Score getScore() {
		return score;
	}

}
