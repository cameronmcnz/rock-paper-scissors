package com.mcnz.rps.moai;


public class RpsApplicationLogic implements PlayableGame {
	

	public Result playTheGame(Gesture clientGesture, Gesture serverGesture) {

		System.out.format("Client chose: %s and the server chose %s.", clientGesture, serverGesture);
		Result gameResult = null;
		
		if (clientGesture.equals(Gesture.ROCK)) {
			gameResult = Result.TIE;
		}
		if (clientGesture.equals(Gesture.PAPER)) {
			gameResult = Result.WIN;
		}
		if (clientGesture.equals(Gesture.SCISSORS)) {
			gameResult = Result.LOSE;
		}
	
		return gameResult;
	}

}
