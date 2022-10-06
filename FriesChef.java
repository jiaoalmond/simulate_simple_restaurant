//Jinyu JIAO 260881046
// You are free to add any attributes or methods you need.
public class FriesChef implements Runnable {
	private String name = "FriesChef";
	private int WAIT_TIME = 1000;
	private int MAKE_TIME = 2000;

	@Override
	public void run() {
		while (true) {
			// if fires number is below 5, chef will take 2 seconds to make fries
			if (KitchenTable.friesCount >= KitchenTable.limit) {
				try {
					Thread.sleep(WAIT_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (KitchenTable.friesCount < KitchenTable.limit) {
				try {
					Thread.sleep(MAKE_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[Action] " + name + " adds a fires on the kitchen table" + "\n" + "[Status] "
						+ "fires left: " + KitchenTable.addFriesNum());
				// if fries number reach the maximum, chef waits
			}
		}
	}
}
