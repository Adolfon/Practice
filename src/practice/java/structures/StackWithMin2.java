package practice.java.structures;

import java.util.Stack;

/*  PROBLEM:
 * 
 * How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time
 */

/* This solution mantain another stack of mins, that everytime that
 * I am going to add or remove an element check the last element (which
 * is the min so far) and remove, add or do nothing to the min stack 
 * base on its value (lower, bigger)
 */
	public class StackWithMin2 extends Stack<Integer> {
		Stack<Integer> s2;
		 public StackWithMin2() {
			 s2 = new Stack<Integer>(); //stack of mins
		 }
		
		public void push(int value){
			if (value <= min()) { //is it the lowest so far?
				s2.push(value);
			}
			super.push(value); //It is not the minimum so I don't touch the min stack just the normal stack
		}
		
		public Integer pop() {
			int value = super.pop();//Pop the normal stack
			if (value == min()) {
				s2.pop(); //and if this values is a min then update the min stack as well..
			}
			return value;
		}
		
		public int min() {
			if (s2.isEmpty()) 
				return Integer.MAX_VALUE; //So we assure the next value starts the min stack
			else 				
				return s2.peek();										
		}//min()
		
		
		public String toString(){
			
			if (this.capacity()==0) return null;
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<this.size();i++){
				sb.append(String.valueOf(this.elementAt(i).intValue())+" ,");
			}			
			return sb.toString();
		}
		
		
		public static void main(String[] args){
			StackWithMin2 stack= new StackWithMin2();
			stack.push(7);
			stack.push(5);
			stack.push(8);
			System.out.println("Inserted: "+stack.toString());
			System.out.println("top: "+stack.peek());
			stack.pop();
			System.out.println("top: "+stack.peek());
			stack.pop();
			System.out.println("top: "+stack.peek());
			stack.pop();
			System.out.println("top: "+stack.peek());
		}
		
		
	 }//Class

