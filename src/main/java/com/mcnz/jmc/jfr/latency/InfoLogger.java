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

/**
 * This class contains our problematic logger.
 */
public class InfoLogger {
	private static InfoLogger myInstance = new InfoLogger();

	public static InfoLogger getLogger() {
		return myInstance;
	}

	public synchronized void  log(String text) {
		LogEvent event = new LogEvent(text);
		event.begin();
		// Do logging here
		// Write the text to a database or similar...
		try {
			// Simulate that this takes a little while.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Don't care.
		}
		event.end();
		event.commit();
	}
}
