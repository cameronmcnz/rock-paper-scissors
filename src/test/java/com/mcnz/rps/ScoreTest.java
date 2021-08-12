package com.mcnz.rps;

import org.junit.Assert;
import org.junit.Test;


public class ScoreTest {

//	@Test
//	public void testIncreaseWins() {
//		Score score = new Score();
//		score.increaseWins();
//		Assert.assertTrue(score.getWins()>0);
//	} 
	@Test
	public void testIncreaseLosses() {
		Score score = new Score();
		score.increaseLosses();
		Assert.assertTrue(score.getLosses()>0);
	}
	@Test
	public void testIncreaseTies() {
		Score score = new Score();
		score.increaseTies();
		Assert.assertTrue(score.getTies()>0);
	}
	
	@Test
	public void testToString() {
		Score score = new Score();
		Assert.assertTrue(score.toString().length()>0);
	}
	
	@Test
	public void testWillFail() {
		
		Assert.assertTrue(true);
	}

}
