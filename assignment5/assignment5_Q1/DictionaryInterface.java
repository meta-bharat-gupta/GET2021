package assignment5_Q1;

// Dictionary Interface to implemented in Dictionary class
public interface DictionaryInterface {

	public void add(int key, String value);
	public void remove(int key);
	public String get(int key);
	public void sort();
	public void sortInRange(int k1, int k2);
}
