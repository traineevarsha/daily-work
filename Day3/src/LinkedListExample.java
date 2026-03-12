import java.util.*;
public class LinkedListExample {
	public static void main(String[] args) {
		List<String> cities = createListOfCities();
		//System.out.println(cities.remove("Delhi"));
		System.out.println(cities.contains("Delhi"));
		System.out.println(cities.lastIndexOf("Delhi"));
		System.out.println(cities.set(0,"Chennai"));
		System.out.println(cities);

	}

	private static List<String> createListOfCities() {
		List <String> cities = new ArrayList<>();
		cities.add("Delhi");
		cities.add("Delhi");
		cities.add("Mumbai");
		cities.add("Blr");
		return cities;
	}

	private static void DefensiveDowncatsing(List<String> cities) {
		if(cities instanceof LinkedList<String> ) {
		LinkedList <String> LinkedList = ( (LinkedList)cities) ;
		LinkedList.addFirst("Chennai"); 
		}
	}

	}
