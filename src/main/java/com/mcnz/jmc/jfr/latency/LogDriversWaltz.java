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
package com.mcnz.jmc.jfr.latency;

import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Class used to run the latency problem example.
 */
public class LogDriversWaltz {
	public static void main(String[] args) throws InterruptedException, IOException {
		ThreadGroup threadGroup = new ThreadGroup("Workers");
		Thread.sleep(2000);
		Thread[] threads;
		threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(threadGroup, new LogWorker(i, 30_000_000), "Worker Thread " + i);
			threads[i].setDaemon(true);
			System.out.println("Starting " + threads[i].getName() + "...");
			threads[i].start();
		}
        int n = JOptionPane.showConfirmDialog(
                null,
                "Do you want the result?",
                "Rock Paper Scissors",
                JOptionPane.YES_NO_OPTION);
        if (n==0) {
        	System.exit(0);
        }
		for (int i = 0; i < threads.length; i++) {
			threads[i].stop();
		}
	}
}
