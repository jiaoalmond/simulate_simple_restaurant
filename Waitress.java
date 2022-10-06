//Jinyu JIAO 260881046

// You are free to add any attributes or methods you need.
public class Waitress implements Runnable {
	private String name = "Waitress";
	private int WAIT_TIME = 1000;
	private int SERVE_TIME = 10000; // 10 second

	@Override
	public void run() {
		// check every 1 second whether the combo is ready or not
		if (ReadyTable.comboNum == 0) {
			try {
				Thread.sleep(WAIT_TIME);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			run();
		}
		// if the combo number is greater than 0, waitress serves a meal, and it takes
		// 10 seconds
		if (ReadyTable.comboNum > 0) {
			System.out.println(
					"[Action] " + name + " serve a meal" + "\n" + "[Status] meals left:" + ReadyTable.serveMeal() + "\n"
							+ "--------------------------------------------------------------------------------");
		}
		try {
			Thread.sleep(SERVE_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		run();
	}

}
