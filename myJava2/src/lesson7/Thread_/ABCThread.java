package lesson7.Thread_;

public class ABCThread {
	private static class MyRunnable implements Runnable {
		public void run() {
			for (char zeichen = 'a'; zeichen <= 'z'; zeichen++) {
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				System.out.println(zeichen);
			}
		}
	}

	private static class MyThread extends Thread {
		public void run() {
			for (char zeichen = 'z'; zeichen >= 'a'; zeichen--) {
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
					System.out.println("\t" + ex.getMessage());
				}
				System.out.println("\t" + zeichen);
			}
		}
	}

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread runnableDemo = new Thread(myRunnable);
		Thread thread = new MyThread();
		thread.setPriority(10);
		runnableDemo.setPriority(1);
		runnableDemo.start();
		thread.start();
	}
}
