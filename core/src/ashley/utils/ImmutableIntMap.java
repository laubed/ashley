package ashley.utils;

import java.util.Iterator;

public interface ImmutableIntMap<V> {
	public int size();
	public V get(int key);
	public V get(int key, V defaultValue);
	public boolean containsValue(Object object, boolean identity);
	public boolean containsKey(int key);
	public int findKey(Object object, boolean identity, int notFound);
	
	public Entries<V> immutableEntries();
	public Values<V> immutableValues();
	public Keys immutableKeys();
	
	public static interface Entries<V> extends Iterable<Entry<Integer, V>> {
		public void reset();
		public Entry<Integer, V> next();
		public boolean hasNext();
		public Iterator<Entry<Integer, V>> iterator();
	}
	
	public static interface Values<V>  extends Iterable<V> {
		public void reset();
		public V next();
		public boolean hasNext();
		public Iterator<V> iterator();
	}
	
	public static interface Keys extends Iterable<Integer> {
		public void reset();
		public Integer next();
		public boolean hasNext();
		public Iterator<Integer> iterator();
	}
}
