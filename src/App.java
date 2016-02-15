import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class App {

	// 1-D array
	public static String[] vehicles = { "ambulance", "helicopter", "lifeboat" };

	// 2-D array
	public static String[][] drivers = { { "Fred", "Sue", "Pete" },
			{ "Sue", "Richard", "Bob", "Fred" }, { "Pete", "Mary", "Bob" }, };

	// If you can define classes to simplify you should rather
	// than using a complex data structure.

	public static void main(String[] args) {

		// Set<String> is nested in the Map
		// new HashMap<String, Set<String>> Java 6 or Lower
		// new HashMap<> Java 7 and above
		Map<String, Set<String>> personnel = new HashMap<String, Set<String>>();

		for (int i = 0; i < vehicles.length; i++) {

			String vehicle = vehicles[i];
			String[] driversList = drivers[i];
			System.out.println(vehicles[i]);

			// create a set to hold the drivers

			// I'm using a sortedSet which means either a TREESET or
			// LINKEDHASHSET
			// TREESET would sort them in alphabetical order - we don't want
			// that
			// we want them to remain in the order we had them in so we use a
			// LINKEDHASHSET. It would remove any duplicates from the data
			// source,
			// have no duplicates.

			Set<String> driverSet = new LinkedHashSet<String>();

			// iterator through the list of drivers

			for (String driver : driversList) {
				driverSet.add(driver);
				System.out.println(driver);
			}

			personnel.put(vehicle, driverSet);

		}

		// The code below is shortened to a FOREACH with a nested FOREACH
		// Just showing for reference and how it works.

		// retrieves those drivers qualified to fly the helicopter
		System.out.println("These drivers are qualified to fly a helicopter");
		Set<String> driversListA = personnel.get("helicopter");

		for (String driver : driversListA) {
			System.out.println(driver);
		}

		System.out.println("These drivers are qualified to drive an ambulance");
		Set<String> driversListB = personnel.get("ambulance");

		for (String driver : driversListB) {
			System.out.println(driver);
		}

		System.out
				.println("These drivers are qualified to captian an lifeboat");
		Set<String> driversListC = personnel.get("lifeboat");

		for (String driver : driversListC) {
			System.out.println(driver);
		}

		// ///Iterate through keySet helicopter, lifeboat and ambulance

		for (String vehicle : personnel.keySet()) {
			System.out.println(vehicle);
		}

		for (String vehicle : personnel.keySet()) {
			System.out.print(vehicle);
			System.out.print(": ");
			Set<String> driversList = personnel.get(vehicle);

			for (String driver : driversList) {
				System.out.print(driver);
				System.out.print(" ");
			}
			System.out.println("");
		}

	}

}
