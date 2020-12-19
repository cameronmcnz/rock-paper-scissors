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
package com.mcnz.jmc.jfr.hotmethods;
import java.util.*;

import javax.swing.JOptionPane;


public class HotMethodMonster implements Runnable {
	
	private static final int NUMBER_OF_THREADS = 4;

	public static void main(String[] args) throws Exception {
		ThreadGroup threadGroup = new ThreadGroup("Hot Method Workers");
		Thread[] threads = new Thread[NUMBER_OF_THREADS];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(threadGroup, new HotMethodMonster(), "Hot Method Worker Thread " + i);
			threads[i].setDaemon(true);
			threads[i].start();
		}
		System.out.print("Press enter to quit!");
		JOptionPane.showInputDialog("Play again?");
		for (int i = 0; i < threads.length; i++) {
			threads[i].stop();
		}
		System.out.flush();
		System.in.read();
	}
	
	public void run() {
		while (true) {
			HotMethodWorkEvent event = new HotMethodWorkEvent();
			event.begin();
			Collection<Integer> firstBunch = new LinkedList<>();
			Collection<Integer> secondBunch = new LinkedList<>();
			//Collection<Integer> firstBunch = new HashSet<>();
			//Collection<Integer> secondBunch = new HashSet<>();
			
			initialize(firstBunch, 3);
			initialize(secondBunch, 2);
			int intersectionSize = countMatches(firstBunch, secondBunch);
			
			event.setIntersectionSize(intersectionSize);
			event.end();
			event.commit();
			Thread.yield();
		}
	}
	
	public void initialize(Collection<Integer> collection, int modulus) {
		collection.clear();
		for (int i = 1; i < 100000; i++) {
			if ((i % modulus) != 0)
				collection.add(i);
		}
	}
	
	public int countMatches(Collection<Integer> first, Collection<Integer> second) {
		int count = 0;
		for (Integer i : first) {
			if (second.contains(i)) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
	
}
