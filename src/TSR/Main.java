package TSR;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main{

	public static void main(String[] args) throws ParseException {
		List<Integer> l = (List<Integer>) Arrays.asList(10, 40,20,60,80,0,80,30,40)
				.stream().filter(v -> v > 18)
				.sorted().sequential().map(Integer::new).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
				;
		System.out.println(l.toString());
	}
	public static void show(String name) {
		System.out.println("Welcome " + name);
	}
	

}
