import java.util.Arrays;
import java.util.List;
import java.util.Random;

//A table which the meals are put as soon as they become ready
//You need to handle race condition here.
public class ReadyTable {
	public static int limit = 3;
	public static int comboNum = 0; // created a shared attribute to count combo

	// create a list of burgerchef and frieschef, and give one of the name randomly
	public static String giveRandName() {
		List<String> nameList = Arrays.asList("BurgerChef", "FriesChef");
		Random rand = new Random();
		String randName = nameList.get(rand.nextInt(nameList.size()));
		return randName;
	}

	synchronized static void addCombo(int burgerNum, int friesNum) {
		// set up conditions, when burger and fries number are bigger than 0,
		// increase the combo number, and decrease the burger and fries number
		// separately. Print out the result.
		if (burgerNum > 0 && friesNum > 0) {
			burgerNum--;
			friesNum--;
			ReadyTable.comboNum++;
			KitchenTable.burgerCount = burgerNum;
			KitchenTable.friesCount = friesNum;
		}
		System.out.println("[Action] " + giveRandName() + " makes Burger and Fries and place it on the ready table"
				+ "\n" + "[Status] " + "burgers left: " + burgerNum + ", fires left: " + friesNum + ", meals left: "
				+ comboNum);
		System.out.println("================================================================================");
	}

	// create serveMeal method to decrease the combo number after the waitress
	// server
	synchronized static int serveMeal() {
		ReadyTable.comboNum--;
		return ReadyTable.comboNum;
	}
}
