package com.mcnz.rps.moai;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/RoshamboWebServlet", "/roshamboservlet", "/playroshambo" })
public class RoshamboWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayableGame playableGame = new RpsApplicationLogic();
		AggregateProcessor aggregateProcessor = new AggregateProcessor();
		UserSessionManager sessionManager = new UserSessionManager(request.getSession());
		
		String clientChoice = request.getParameter("choice");
		if (clientChoice.equalsIgnoreCase("reset")) {
			sessionManager.getGameHistory().clear();
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(clientChoice);
		Gesture clientGesture = Gesture.valueOf(clientChoice.toUpperCase());
		Gesture serverGesture = Gesture.valueOf("ROCK");
		Result result = playableGame.playTheGame(clientGesture, serverGesture);
		GameSummary summary = new GameSummary(clientGesture, serverGesture, result);
		sessionManager.addGameSummary(summary);
		
		Score score = aggregateProcessor.updateScore(result);
		this.getServletContext().setAttribute("score", score);
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(clientChoice).append(result.toString());
		
		List<GameSummary> history = sessionManager.getGameHistory();
		
		for (GameSummary gameSummary : history) {
			System.out.println(gameSummary.getResult());
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
