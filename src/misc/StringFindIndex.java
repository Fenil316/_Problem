package misc;

public class StringFindIndex {

	public static void main(String[] args) {
		StringFindIndex str = new StringFindIndex();
		String quote = "This life had to be a bit more accomodating, "
				+ "I wish I had a new life coz coping up with this one is tough";
		// Find all occurences of c:
		str.printAllOccurencesOf('c', quote);
	}
	
	public void printAllOccurencesOf(char c, String q) {
		int index = q.indexOf(c);
		while(index > 0) {
			System.out.println("Index: " + index);
			index = q.indexOf(c, index + 1);
		}
	}
	
}
