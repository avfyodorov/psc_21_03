package cons01.lecture.collect;

public class Main {

    public static void main(String[] args) {
	    List<String> strings = new LinkedList<>();

	    strings.add("Hello!");
	    strings.add("Marsel");
	    strings.add("Bye");
	    strings.add("Java");
	    strings.add("C++");
	    strings.add("Python");

	    Iterator<String> stringIterator = strings.iterator();

	    while (stringIterator.hasNext()) {
			System.out.println(stringIterator.next());
		}

		Iterator<String> stringIterator2 = strings.iterator();

		while (stringIterator2.hasNext()) {
			System.out.println(stringIterator2.next());
		}

	    int i = 0;
    }
}
