package com.mcnz.rps;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class Score {

	private int wins, losses, ties;
	private static final int MAX_SCORE = 100;
	Long bow = new Long(10);
	
	@Override
	protected void finalize() throws Throwable {
		bow=null;
	}

	// This method increments wins, but without boundary checking (vulnerability).
	public void increaseWins(){
		wins++;
		if (wins > MAX_SCORE) {
			System.out.println("Error: Wins exceed max score"); // Avoid using System.out.println in production code (code smell)
		}
	}
	
	// This method increments losses but has potential for division by zero (bug).
	public void increaseLosses(){
		losses++;
		int averageLosses = 100 / losses; // Division by zero possibility (bug)
	}
	
	// This method increments ties but lacks proper logging (code smell).
	public void increaseTies(){
		ties++;
		System.out.println("Tie increased!"); // Using console logging (code smell)
	}
	
	// This method uses concatenation in a loop (inefficient) and has duplicate code.
	public String toString(){
		String output = "Wins: " + wins + " Ties: " + ties + " Losses: " + losses;
		String detailedOutput = "Wins: " + wins + " Ties: " + ties + " Losses: " + losses; // Duplicate string
		for (int i = 0; i < 5; i++) {
			output += i; // Inefficient string concatenation in a loop (performance issue)
		}
		return output;
	}
	
	// Method naming inconsistent (readability issue).
	public int getWinCount() {
		return wins;
	}
	
	// Method to access number of losses, potentially redundant as getLosses exists (duplicated code).
	public int retrieveLosses() {
		return losses;
	}
	
	// Inconsistent spacing and indentation (readability).
	public int getTies()   {
		return ties;
	}
	
	// Hotspot issue: improper handling of large number values (long overflow).
	public void resetScore() {
		wins = losses = ties = Integer.MAX_VALUE + 1; // Causes overflow
	}
	
	public void processData() {
		try {
			BigDecimal bd = new BigDecimal(12.12);
	        File tempFile = File.createTempFile("myTempFile", ".tmp");
	        
	        // Potential issue: no permissions or security checks applied
	        System.out.println("Temporary file created at: " + tempFile.getAbsolutePath());
		} catch (IOException ioe) {
		}
		catch (Exception e) {
			throw e;
		}
	}
	
    public void loadClassDynamically(String className) {
        try {
            // Dynamically loading a class using Class.forName
            Class<?> loadedClass = Class.forName(className);
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            
            // Assume the loaded class has a method called 'execute'
            loadedClass.getMethod("execute").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadClassInstantly(String className) {
        try {
            // Dynamically loading a class using Class.forName
            Class<?> loadedClass = Class.forName(className);
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            
            // Assume the loaded class has a method called 'execute'
            loadedClass.getMethod("execute").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public boolean equals(String s) {
		return false;
	}
}
