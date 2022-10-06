//A work table which for chefs to place burger or Fries.
//You need to handle race condition here.
public class KitchenTable {
	public static int limit = 5;
	// create static attributes to share the value of burger and fries
	public static int burgerCount = 0;
	public static int friesCount = 0;

	// create synchronized static methods of burger numbers, fries numbers and combo
	// numbers to avoid race condition
	synchronized static int addBurgerNum() {
		burgerCount++;
		return KitchenTable.burgerCount;
	}

	synchronized static int addFriesNum() {
		friesCount++;
		return KitchenTable.friesCount;
	}

	synchronized static void makeCombo() {
		ReadyTable.addCombo(KitchenTable.burgerCount, KitchenTable.friesCount);
	}

}
