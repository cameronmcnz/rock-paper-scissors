/*
 * Copyright (c) 2018, Marcus Hirt
 * 
 * jmc-tutorial is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jmc-tutorial is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jmc-tutorial. If not, see <http://www.gnu.org/licenses/>.
 */
package com.mcnz.jfr.jmc.exceptions;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.mcnz.jmc.jfr.hotmethods.HotMethodMonster;

/**
 * Example which will throw two different kinds of exceptions.
 */
public final class HandleZeroInputGracefully implements Runnable {
	// The poor lab laptops will probably need one spare
	// hardware thread.
	private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors() - 1;
	public long scaryCounter;

	public static void main(String[] args) throws Exception {

			System.out.println("Starting " + NUMBER_OF_THREADS + " exception throwing threads!");

			
			ThreadGroup threadGroup = new ThreadGroup("Exception Workers");
			Thread[] threads = new Thread[NUMBER_OF_THREADS];
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(threadGroup, new HandleZeroInputGracefully(), "Graceful Exceptions Thread " + i);
				threads[i].setDaemon(true);
				threads[i].start();
			}
			JOptionPane.showInputDialog("Please enter data.");
			for (int i = 0; i < threads.length; i++) {
				System.out.println("Stopping thread...");
				threads[i].stop();
			}

	}
	
	@Override
	public void run() {
		loop();
	}

	private void loop() {
		while (true) {
			try {
				handleBlankInput();
			} catch (Exception e) {
				// Swallow the exception
			}
			sleep(10);
		}
	}

	private void handleBlankInput() throws Exception {
		implementBlankInputLogic();
	}

	private void implementBlankInputLogic() throws Exception {
		long mod = System.currentTimeMillis() % 10;
		//System.out.println(mod);
		if (mod < 1) {
			System.out.println("BD Exception Thrown");
			throw new BlankDataException("Blank Data");
		}
		if (mod<6) {
			System.out.println("NI Exception Thrown");
			throw new NoInputException("No input");
		}
		if (mod<10) {
			System.out.println("NMC Exception Thrown");
			throw new NoMatchingConditionException("No match");
		}
	}


	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
