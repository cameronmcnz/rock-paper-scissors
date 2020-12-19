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

import jdk.jfr.*;


/**
 * This is a JDK Flight Recorder event.
 */
@Label("ThreadWork")
@Category("Hot_Methods")
@Description("Data from one loop run in the worker thread")
public class HotMethodWorkEvent extends jdk.jfr.Event {
	@Label("Intersection Size")
	@Description("The number of values that were the same in the two collections")
	private int intersectionSize;

	public int getIntersectionSize() {
		return intersectionSize;
	}

	public void setIntersectionSize(int intersectionSize) {
		this.intersectionSize = intersectionSize;
	}
}
