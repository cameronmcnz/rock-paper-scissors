package com.mcnz.rps.moai;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UserSessionManager {
	HttpSession session;

	public UserSessionManager(HttpSession session) {
		this.session = session;
	}

	public void addGameSummary(GameSummary summary) {
		this.getGameHistory().add(summary);
		session.setAttribute("summary", summary);
	}
	
	public List<GameSummary> getGameHistory() {
		List<GameSummary> gameHistory = (List)session.getAttribute("gameHistory");
		if (gameHistory==null) {
			gameHistory = new ArrayList<GameSummary>();
			session.setAttribute("gameHistory", gameHistory);
		}
		return gameHistory;
	}
	
}
