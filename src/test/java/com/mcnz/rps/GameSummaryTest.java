package com.mcnz.rps;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;

public class GameSummaryTest {

	@Test
	public void testGetClientGesture() {
		GameSummary gameSummary = new GameSummary("rock", "scissors", "win");
		Assert.assertTrue(gameSummary.getClientGesture().equals("rock"));
		Assert.assertNotEquals("scissors", gameSummary.getClientGesture() );
	}

	@Test
	public void testGetServerGesture() {
		GameSummary gameSummary = new GameSummary("rock", "scissors", "win");
		Assert.assertTrue(gameSummary.getServerGesture().equals("scissors"));
	}

	@Test
	public void testGetResult() {
		GameSummary gameSummary = new GameSummary("rock", "scissors", "win");
		Assert.assertEquals( "win", gameSummary.getResult());
	}

	@Test
	public void testGetDate() {
		GameSummary gameSummary = new GameSummary("rock", "scissors", "win");
		Assert.assertNotNull(gameSummary.getDate());
	}

}
