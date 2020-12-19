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
package com.mcnz.jfr.jmc.memory;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Simple memory leak demo.
 */
public class MemoryLeak {
	
	public static long COUNT = 0;
	




	private static class DemoThread implements Runnable {
		private Hashtable<DataObject, String> table;
		private int threshold = 90;

		DemoThread(Hashtable<DataObject, String> table, int threshold) {
			this.table = table;
			this.threshold = threshold;
			System.out.println("This thread's memory threshold % is: " + threshold);
		}

		public void run() {
			
			boolean exit = false;
			try {
				int total = 0;
				while (!exit) {
					for (int i = 0; i <= 100; i++) {
						put(total + i);
						//Thread.yield();
					}

					for (int i = 0; i < 100; i++) {
						remove(total);
						i++;
						//Thread.yield();
					}

					total += 101;

					for (int i = 0; i < 10; i++) {
						Thread.yield();
					}
					COUNT++;
					exit = isMemoryThresholdMet();
				}
			} catch (Throwable t) {
				System.out.println("That's weird... That's suspicious." + t.getClass());
			}
		}

		private boolean isMemoryThresholdMet() {
			try {
				
				if ((COUNT % 250) == 0) {
					MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
					MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
					long maxMemory = heapUsage.getMax() / (1024 * 1024);
					long usedMemory = heapUsage.getUsed() / (1024 * 1024);
					long percentageUsed = (long)(100.0*((1.0*usedMemory)/(1.0*maxMemory)));
					if (percentageUsed>this.threshold) {
						System.out.print("A threshold was met..");
						COUNT = 0;
						if (this.threshold>95) {
							System.out.println(" Memory Use : " + usedMemory + "M/" + maxMemory + "M " + percentageUsed + "%");
							if (percentageUsed>97) {
								System.out.println("About to clear " + percentageUsed + " : " +this.threshold);
								this.table.clear();
							}
						} else {
							System.out.println("Killing the thread");
							return true;
						}
					}
					if (this.threshold>95) {
						System.out.println(" Memory Use : " + usedMemory + "M/" + maxMemory + "M " + percentageUsed + "%");
					}
				}
				Thread.sleep(1);
			} catch (Exception e) {
				System.out.println(e.getClass());
			}
			return false;
		}

		private void put(int n) {
			
		}

		private String remove(int n) {
			return table.remove(new DataObject(n));
		}
	}

	public static void main(String[] args) throws IOException {

		Hashtable<DataObject, String> hashTable = new Hashtable<DataObject, String>();
		Thread[] threads;

		int threadCount = 10;
		threads = new Thread[threadCount];

		System.out.println(String.format("Starting leak with %d threads...", threadCount));
		System.out.print("Starting threads... ");

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new DemoThread(hashTable, (98 - (7*i))));
			threads[i].setDaemon(true);
			threads[i].setUncaughtExceptionHandler(new LastChanceHandler());
			threads[i].start();
		}
		Thread.setDefaultUncaughtExceptionHandler(new LastChanceHandler());
		JOptionPane.showMessageDialog(null, "Leave this open to keep program running.");

	}

}
