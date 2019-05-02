package TSR;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main1{

	public static void main(String[] args) throws ParseException {
		Function<String, Integer> l = (s) -> s.length();
		Function<Integer, Boolean> c = i -> i <10;
		Function<String, Boolean> f = l.andThen(c);
		System.out.println(f.apply("Java8"));
		
		List<Integer> n = Arrays.asList(1,2,3,4,5);
		List<Integer> r = n.stream()
				.skip(2)
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(r.toString());
		
		
		Stream.of("m", "o", "b").filter(x-> {
			System.out.println(x);
			return true;
		});
		
		System.out.println("----------");
		List<String> fs = new ArrayList<String>();
		fs.add("m");
		fs.add("o");
		fs.add("b");
		
		Stream<String> fst = fs.parallelStream();
		fst.filter(t -> {
			System.out.println(t);
			return false;
		}).forEach(b -> {});
		
		
}
	public static void show(String name) {
		System.out.println("Welcome " + name);
	}
	

}
