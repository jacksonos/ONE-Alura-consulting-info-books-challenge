package com.alura.bookchallenge.Animations;

import java.util.concurrent.locks.LockSupport;

public class LoadingAnimation {
	private volatile boolean running = true;
	private Thread thread;

	public void start() {
		thread = new Thread(() -> {
			String[] frames = {"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"};
			int i = 0;
			while (running) {
				System.out.print("\rLoading... " + frames[i % frames.length]);
				i++;
				LockSupport.parkNanos(200_000_000); // 200 ms en nanosecond
			}
		});
		thread.start();
	}

	public void stop() {
		running = false;
		if (thread != null) {
			try {
				thread.join(); // Ensure that the thread finishes before clearing the console
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.print("\r"); // Clean line
	}



}
