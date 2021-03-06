package core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

import logmanager.Logger;

/**
 * Launches a number of threads and lets them grab work from the work queue.
 * 
 * @author 150021237
 *
 */
public class ThreadPoolExecutor implements Executor {

	public final int THREAD_COUNT;
		
	private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	private static Logger logger = Logger.getInstance();
	
	/**
	 * Define the number of threads to work off the work queue.
	 * 
	 * @param nrThreads
	 */
	public ThreadPoolExecutor(int nrThreads) {
		THREAD_COUNT = nrThreads;
		
		for (int i = 0; i < THREAD_COUNT; i++) {
			activateWorkerThread();
		}
		logger.info(1, "ThreadPool with " + nrThreads + " Thread initiated.");
	}

	private void activateWorkerThread() {
		
		Runnable workerJob = () -> {
				try {
					while (true) {
						queue.take().run();
					}
				} catch (InterruptedException e) {
					logger.error("Worker Thread died", e);
				}
		};
		new Thread(workerJob).start();
	}

	/**
	 * Adds a work packet to the work queue.
	 * 
	 * @param command work
	 */
	@Override
	public void execute(Runnable work) {
		queue.offer(work);
	}
}
