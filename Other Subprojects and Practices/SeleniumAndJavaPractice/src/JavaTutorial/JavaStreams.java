package JavaTutorial;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class JavaStreams {
	
	@Test
	public void regular() {
		/* TODO
		 1 - Create an ArrayList and save names.
		 2 - Filter this list using streams and print elements that start with 'a'.
		 3 - First, show the bad approach.
		 4 - Then, show the best approach using the filter method.
		 5 - Create a a separated methods.
		 9 - Use the map method to convert elements to uppercase.
		10 - Sort the elements that start with 'a'.
		11 - Concatenate two elements.
		12 - Compare an element with another value and return true or false. Use this flag with assertions.
		13 - Use Stream.of, ArrayList.
		14 - Use distinct, then sort elements of an Integer list, and print their positions.

		Questions:

		- What is the use of the @Test annotation above function declarations?
		- What is the purpose of streams, and how do they differ from using only ArrayList, List, Map, HashMap, etc.?
		- What are the differences between forEach, map, filter, sorted, concat, collect, Collectors, toMap, toList, distinct etc.? Provide an explanation that helps understand how all these relate to streams.
		*/

		ArrayList<String> array = new ArrayList<String>();
		array.add("Adofo");
		array.add("Ema");
		array.add("Lorena");
		array.add("Agustina");
		array.add("Rebeca");
		
		for (int i = 0; i < array.size()-1; i++) {
			if (array.get(i).startsWith("A")) {
				System.out.println(array.get(i));
			}
		}
		
		array.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));

	}

	/* 6 - Save everything in this method.
	 7 - Create a new array and filter elements with length greater than four.
	  7.1 - Use "asList" to created most easly elements
	 8 - Limit the output to only one result.*/
	@Test
	public void Limit() {
		List<String> list = Arrays.asList("Adolfo", "rebe", "Alfonsina", "Lore");	
		
		list.stream().filter(s -> s.length() > 4 ).forEach(s -> System.out.println(s));
		
	}
	
	
}
