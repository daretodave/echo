package com.echo;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Core {
	
	private static ScheduledExecutorService backbone = Executors.newScheduledThreadPool(4);
	
	public static Future<?> submit(Runnable runnable) {
		return backbone.submit(runnable);
	}

}
