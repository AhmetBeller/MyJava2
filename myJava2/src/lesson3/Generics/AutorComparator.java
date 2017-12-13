package lesson3.Generics;

import java.util.Comparator;

public class AutorComparator implements Comparator<Buch> {

	public int compare(Buch b1, Buch b2) {
		return b1.get_autor().compareTo(b2.get_autor());
	}
}
