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
 * This is what will run in the worker threads. It will do some arbitrary work, and then log some
 * message about work being done.
 */
public class LogWorker implements Runnable {
	public final static InfoLogger LOGGER = InfoLogger.getLogger();
	private final int id;
	private final int loopCount;

	public LogWorker(int id, int loopCount) {
		this.id = id;
		this.loopCount = loopCount;
	}

	@Override
	public void run() {
		while (true) {
			LogWorkEvent event = new LogWorkEvent();
			event.begin();
			int x = 1;
			int y = 1;
			for (int i = 1; i < loopCount; i++) {
				x += 1;
				y = y % (this.loopCount + 3);
				if (x % (this.loopCount + 4) == 0 || y == 0) {
					System.out.println("Should not happen");
				}
			}
			event.end();
			event.commit();
			LOGGER.log("Worker " + id + " reporting work done");
			Thread.yield();
		}
	}
}
