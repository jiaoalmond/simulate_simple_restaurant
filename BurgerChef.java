//Jinyu JIAO 260881046

// You are free to add any attributes or methods you need.
public class BurgerChef implements Runnable {
	private String name = "BurgerChef";
	private int WAIT_TIME = 1000;
	private int MAKE_TIME = 3000;

	@Override
	public void run() {
		while (true) {
			// when burger number is smaller than 5, chef will take 3 seconds to make a
			// burger
			if (KitchenTable.burgerCount < KitchenTable.limit) {
				try {
					Thread.sleep(MAKE_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[Action] " + name + " adds a burger on the kitchen table" + "\n" + "[Status] "
						+ "burgers left: " + KitchenTable.addBurgerNum());
				if (ReadyTable.comboNum < ReadyTable.limit && KitchenTable.burgerCount > 0
						&& KitchenTable.friesCount > 0) {
					KitchenTable.makeCombo(); // when burger and fries are both greater than 0, and combo is smaller
												// than 3, trigger makeComno method
				}
			} else if (KitchenTable.burgerCount >= KitchenTable.limit) {
				// if burger number is greater than 5, but combo number below 3, trigger
				// makeCombo method only
				if (ReadyTable.comboNum < ReadyTable.limit) {
					KitchenTable.makeCombo();
					// if combo number is over 3, chef needs to wait
				} else if (ReadyTable.comboNum >= ReadyTable.limit) {
					try {
						Thread.sleep(WAIT_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
