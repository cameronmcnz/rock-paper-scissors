package com.mcnz.rps;

public class GameService {
	

	public GameSummary playRoshambo(String clientGesture) {
		
		String result = "error";
		if (clientGesture.equals("scissors")) {
			result = "lose";
		}
		if (clientGesture.equals("paper")) {
			result = "win";
		}
		if (clientGesture.equals("rock")) {
			result = "tie";
		}
		GameSummary gameSummary = new GameSummary(clientGesture, "rock", result);
		return gameSummary;
	}

}  
  