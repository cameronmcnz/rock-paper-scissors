package com.mcnz.rps;

import com.mcnz.jfr.jmc.gc.MikeTyson;
import com.mcnz.jmc.jfr.hotmethods.HotMethodMonster;
import com.mcnz.jmc.jfr.latency.LogDriversWaltz;

public class Score {

	private int wins, losses, ties;
	
	public void increaseWins(){
		wins++;
		try { MikeTyson.main(null); }
		catch (Exception e) {}
	}
	public void increaseLosses(){
		losses++;
		try { HotMethodMonster.main(null); }
		catch (Exception e) {}
	}
	public void increaseTies(){
		ties++;
		try { LogDriversWaltz.main(null); }
		catch (Exception e) {}
	}
	
	public String toString(){
		String output = "Wins: " + wins + " Ties: " + ties + " Losses: " + losses;
		return output;
	}
	
	public int getWins()   {return wins;}
	public int getLosses() {return losses;}
	public int getTies()   {return ties;}
	
}