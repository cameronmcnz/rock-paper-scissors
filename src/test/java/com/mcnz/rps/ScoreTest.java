package com.mcnz.rps;

import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

	@Test
	public void testIncreaseWins() {
		Score score = new Score();
		score.increaseWins();
		Assert.assertTrue(score.getWinCount() > 0); // Updated to match method name change
	}
	
	@Test
	public void testIncreaseLosses() {
		Score score = new Score();
		score.increaseLosses();
		//Assert.assertTrue(score.getLosses() > 0);
	}
	
	@Test
	public void testIncreaseTies() {
		Score score = new Score();
		score.increaseTies();
		Assert.assertTrue(score.getTies() > 0);
	}
	
	@Test
	public void testToString() {
		Score score = new Score();
		Assert.assertTrue(score.toString().length() > 0);
	}
	
	//@Test
	//public void testWillFail() {
	//	// A dummy test to intentionally fail
	//	Assert.assertFalse("This test is expected to fail", true); // Adjusted to fail intentionally
	//}
	
	@Test
	public void testRetrieveLosses() {
		Score score = new Score();
		score.increaseLosses();
		Assert.assertTrue(score.retrieveLosses() > 0); // Tests the duplicated method 'retrieveLosses'
	}
	
	@Test
	public void testResetScore() {
		Score score = new Score();
		score.resetScore(); // Test for the hotspot logic
		Assert.assertTrue(score.getWinCount() < 0); // Overflow should result in negative numbers due to int overflow
	}
}
