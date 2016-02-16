
package example.adt;

import java.util.Iterator;

public class CircularArray<T> {
	private T[] items;
	private int head = 0;
	
	
	
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}
			
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		int val=(head + index) % items.length; //Modulus is the remainder after the division. It always gives the first element of the total number of elements.
		//for example the 3rd position of an array of 3 elements would be the first (0 position), the 4th would be the second (1 position). so it simulates a circular array perfectly. 
		return val;
	 }
	 
	public void rotate(int shiftRight) {
		head = convert(shiftRight);	
	}
	
	public T get(int i) {
		if (i < 0 | i >= items.length) {
			//throw new java.lang.lndexOutOfBoundsException("...");
			throw new java.lang.ArrayIndexOutOfBoundsException("...");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item) {	
		items[convert(i)] = item;	
	}
}

// -----------------------------------------------  same but implementing Iterable --------------------------------------

 class CircularArray2<T> implements Iterable<T> {  //you cannot make it public bc the name of the file..

	private T[] items;
	private int head = 0;
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		int val=(head + index) % items.length; //Modulus is the remainder after the division. It always gives the first element of the total number of elements.
		//for example the 3rd position of an array of 3 elements would be the first (0 position), the 4th would be the second (1 position). so it simulates a circular array perfectly. 
		return val;
	 }
	
	public void set(int i, T item) {	
		items[convert(i)] = item;	
	}

	public CircularArray2(int size) {
		items = (T[]) new Object[size];
	}
	
	public Iterator<T> iterator() {	
		return new CircularArrayIterator<T>(this);
	 }
	 
	 private class CircularArrayIterator<TI> implements Iterator<TI>{
		 /* current reflects the offset from the rotated head, not
		 * from the actual start of the raw array. */
		 private int _current = -1;
		 private TI[] _items;
		 
		 
		 
		public CircularArrayIterator(CircularArray2<TI> array)
		{
			_items = array.items;
		 }
		 
		 @Override
		 public boolean hasNext() {
		 return _current < items.length - 1;
		 }
		 
		 
		@Override
		public TI next() {
			 _current++;
			 TI item = (TI) _items[convert(_current)];
			 return item;
		 }
		 
		 @Override
		 public void remove() {
			 throw new UnsupportedOperationException("...");		
		}
		 
	}//CircularArrayIterator
 }// CircularArray2

//-----------------------------------------------  End implementing Iterable Part --------------------------------------

class execADT{
	
	public static void main(String args[]){
		CircularArray<String> cas=new CircularArray<String>(3);
		cas.set(0, new String("first "));
		cas.set(1, new String("second "));
		cas.set(2, new String("third "));
		System.out.println("First pos: "+cas.get(0));
		System.out.println("Third pos: "+cas.get(2));
		
		
		System.out.println("Rotate 1 position....");
		cas.rotate(1); //makes the head to be 1 instead of 0
		System.out.println("First position: "+cas.get(0));
		System.out.println("Third position: "+cas.get(2)); //Throws ArrayOutIndexBoundException if 3 is passed.
		
		System.out.println("Rotate another 2 positions...");
		cas.rotate(2);
		System.out.println("First pos: "+cas.get(0));
		System.out.println("Third pos: "+cas.get(2));
		
		// For the iterable one...
		
		CircularArray2<String> ca2=new CircularArray2<String>(3);
		ca2.set(0, new String("first2 "));
		ca2.set(1, new String("second2 "));
		ca2.set(2, new String("third2 "));
		System.out.println("------------ Iterable way...");
		for (String s:ca2)
			System.out.println(s);
		
		
	}//exec
	
}//class
