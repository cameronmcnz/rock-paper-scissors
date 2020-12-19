package com.mcnz.jfr.jmc.memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class LastChanceHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
    	System.out.println("Last chance for romance..");
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
		long maxMemory = heapUsage.getMax() / (1024 * 1024);
		long usedMemory = heapUsage.getUsed() / (1024 * 1024);
		System.out.println(" Memory Use :" + usedMemory + "M/" + maxMemory + "M");
		System.out.println("Dat's weird... Dat's suspicious.");
    }
}

