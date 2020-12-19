/*
 * Copyright (c) 2021, Cameron McKenzie GNU General Public License
 * 
 * www.mcnz.com
 * 
 * this is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 */
package com.mcnz.jfr.jmc.gc;

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;


public final class MikeTyson implements Runnable {
	
	private final Map<Long, SnoopLong> map = new HashMap<>();

	public MikeTyson() {
		for (long i = 0; i < 10_000; i++) {
			map.put(i, new SnoopLong(i));
		}
	}
 
	@Override
	public void run() {
		long yieldCounter = 0;
		while (true) {
			Collection<SnoopLong> copyOfValues = map.values();
			for (SnoopLong snoopIntCopy : copyOfValues) {
				if (!map.containsKey(snoopIntCopy.getId()))
					System.out.println("That's weird... That's suspicious.");
				if (++yieldCounter % 100000 == 0)
					System.out.println("Boxing and unboxing");
					Thread.yield();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		ThreadGroup threadGroup = new ThreadGroup("Workers");
		Thread[] threads = new Thread[8];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(threadGroup, new MikeTyson(), "Allocator Thread " + i);
			threads[i].setDaemon(true);
			threads[i].start();
		}
        int yesOrNo = JOptionPane.showConfirmDialog(
                null,
                "Are you ready for the result?",
                "Rock Paper Scissors",
                JOptionPane.YES_NO_OPTION);
        if (yesOrNo==1) {
        	System.out.println("Exiting");
        	for(int i = 0; i<100; i++) {
        		try {throw new Exception("Hey!");
				} catch (Exception e) {}
        	}
        	System.exit(0);
        }
	}
}
