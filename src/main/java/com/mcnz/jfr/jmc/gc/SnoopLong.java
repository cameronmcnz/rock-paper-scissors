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

public final class SnoopLong {
	final long id;

	SnoopLong(long id) { this.id = id; }

	long getId() { return id; }
}
 