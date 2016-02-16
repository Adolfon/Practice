package practice.java.structures;

import java.util.BitSet;

public class Bitsets {

	public static void main(String args[]) {
	     BitSet bits1 = new BitSet(16);
	     BitSet bits2 = new BitSet(16);
	      
	     // set some bits
	     for(int i=0; i<16; i++) {
	        if((i%2) == 0) bits1.set(i);
	        if((i%5) != 0) bits2.set(i);
	     }
	     System.out.println("Initial pattern in bits1: ");
	     System.out.println(bits1);
	     System.out.println("\nInitial pattern in bits2: ");
	     System.out.println(bits2);

	     // AND bits
	     bits2.and(bits1);
	     System.out.println("\nbits2 AND bits1: ");
	     System.out.println(bits2);

	     // OR bits
	     bits2.or(bits1);
	     System.out.println("\nbits2 OR bits1: ");
	     System.out.println(bits2);

	     // XOR bits
	     System.out.println("\nAdddin 77 to bits1");
	     bits1.set(77);
	     bits2.xor(bits1);
	     System.out.println("\nbits2 XOR bits1: ");
	     System.out.println(bits2);
	     bits2.flip(0);
	     System.out.println( "\nFlipping the value (complement)" + bits2);
	  }
}
