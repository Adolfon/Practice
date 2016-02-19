package practice.algoritm;

//Learning things
//Head reference is always the same since you create the list until you 
//erase the last element which that element should be the head.
// In a single list the "head" element never changes. This is important bc
//if you lose the head reference you lose the list.
//You always add the new element or check all the elements knowing that the
//last element next field value is null. 

public class Sllist {

	
	//implement operations add, delete, traverse or toString.
	
	class Node{
		Node next;
		Object data;
	}
	
	int counter;
	Node head;
	
	public boolean addToEnd(Object data){
		if (head==null){
			head=new Node();
			head.data=data; //Now head is the head (first element) and I have to keep it that way
			return true;
		}else{
			Node newNode=new Node(); //it an extra node (the inserted one)
			newNode.data=data;
			newNode.next=null;
			
			Node actual=head;
			while (actual.next!=null)
				actual=actual.next;			
			actual.next=newNode;
			//actual.next.data=data;
			counter++;
			//head=newNode; never modify head bc you lose the list
			return true;
		}
	}
	
	public boolean removeAt(int index){
		//There are 3 case to consider on top of error management for bad index parameter
		//Delete the first element which is the head, the head changes
		//Delete in the middle which just change pointer next to next.next
		//Delete at the end, so you need to modify the previous pointer, so in
		//that case you need another Node previous that helps to change that pointer.
		//We assume logic 0 in the position for the delete node.
		
		//Validation
		if (index<0)
			return false;
		if (head==null)
			return false;
		
		//One element list
		if (head.next==null&&index==0){
			head=null;
			return true;
		}else
			if(head.next==null) //Position not equal 0 but not further elements				
				return false;
			else if (index==0){//removing head or position 0
				head=head.next; //just move the head make lose the element (Is not accessible)
			}
		//More than 1 element list
		//helpers
		int count=1;
		Node aux,prev;
		aux=head.next;
		prev=head;
		while(aux.next!=null&&count<index){
			count++;
			prev=aux;
			aux=aux.next;
		}//while now I am in the position where I want to erase the element
		if (count!=index) //We reach the end of the list so the index was Out of the limit
			return false;  //OutOftheBoundsException  index parameter higher than the list size
		prev.next=aux.next; //erase the element		
		return true;
	}
	
	
	public void traverse(){
		Node actual=head;
		while (actual.next!=null){
			System.out.print("{"+actual.data+"}-->");
			actual=actual.next;
		}				
		System.out.print("{"+actual.data+"}-->NULL,");
		System.out.println();
	}//traverse
	
	
	//return from the kth element to the end of the list // NOT WORKING AS EXPECTED it is difficult
	//because when you return from the recursivity method (in this case) you are at the tail of the list
	//but the number "i" gives you the length of the list and k where you want to start so I can not find
	//a direct condition which prints the node info of the actual node. (I think I need another parameter 
	//in the method that I can modify accordingly.
	//the best way would be knowing the length of the list with a counter (ADT with it)
	public static int ntoLast(Node head,int k){
		//it reachs the end of the list
		if (head==null)
			return 0;
		int i=ntoLast(head.next,k)+1;	
		Integer intValue=Integer.valueOf(head.data.toString());
		if (i>=intValue.intValue()){
			System.out.println("["+head.data+"]-->"+"i:k="+i+":"+k);
		}
		return i;
	}
	
	//I went crazy the original question in CCI is:
	//Implement an algorithm to find the kth to last element of a singly linked list.
// You pass the list position and it will print the element in that position and the rest of the elements until the end (NULL)
	//If you pass a positon bigger that the list itself then it will print the whole list..
	public static int nthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		 }
		 int i = nthToLast(head.next, k) + 1; //It will go over the whole list no matter what..
		 if (i <= k) {
			 System.out.println("Data: "+head.data+", i: "+i+", k: "+k);			 
		 }	
//		 if (i == k) {
//			 System.out.println("Data: "+head.data+", i: "+i+", k: "+k);
//			 //And If I want to the end of the list then put here the rest of the code until the end.. (I think...)
//		 }	
		 return i;
	}//nthToLast

	
	//Using a wrapper
	/*
	 * We described earlier that the issue was that we couldn't simultaneously return a counter
and an index. If we wrap the counter value with simple class (or even a single element
array), we can mimic passing by reference.
*/
	
		
		class IntWrapper {
			public int value = 0;
			}
		//You pass the position of the list and it returns the element (Node)	
		 Node nthToLastR2(Node head, int k, IntWrapper i) {
			 if (head == null) {
				 return null;			
			  }
			 Node node = nthToLastR2(head.next, k, i);
			 i.value = i.value + 1;
			 if (i.value == k) { // We've found the kth element			
				 return head;
			 }
			 return node;
		 }//function
		 

		 
		 //Now the iterative solution to nth element to the end of the list..
		 //This method return the head of the sublist from the searched element to the end of the list
		 //it uses to pointers the first to the k element and the other to the end of the list
		 
		 
		 //I think this algorithm is all wrong you dont need 2 pointers for returning a sublist with the k-element as a head
		 //On the other end if what you want to accomplish is to do a sublist of k elements from the k-element still this 
		 // algorithm would be wrong but in that case you need 2 pointers, one from the head of the sublist or k-element and
		 // the other delimiting the end of the list in the case k length is smaller than the number of elements from k to the 
		 //end of the list.
		 Node nthToLastIterative(Node head, int k) { //WRONG WRONG WRONG , COPIED DIRECTLY FROM THE BOOK....
			 
			 //bad input parameter check
			 if (k <= 0) return null;			 
			 Node p1 = head;			 
			 Node p2 = head;
			
			 // Move p2 -forward k nodes into the list. (p2 pointer points to the k element)			 
			 for (int i = 0; i < k - 1; i++) {			 
				 if (p2 == null) return null; // Error check
				 p2 = p2.next;
			 }
			 if (p2 == null) return null;
			 /* Now, move pi and p2 at the same speed. When p2 hits the end,
			 * pi will be at the right element. */
			 while (p2.next != null) {
				 p1 = p1.next;
				 p2 = p2.next;
			  }
			 return p1;
		}//function

		 
		 
		 
//Each of these recursive solutions takes 0(n) space due to the recursive calls.

//Sum to numbers represented by single digits in every Node.
// the list are represented opposite to the value of the number (for example:number 712 would be list 2->1->7
		 //Is decimal
		
		 class LinkedListNode{
			 Integer carry,n1,n2,data;
			 LinkedListNode next;
			 
			 public void setNext(LinkedListNode x){
				 this.next=x;
			 }
			 LinkedListNode(Integer carry,Integer n1, Integer n2){
				 this.carry=carry;
				 this.n1=n1;
				 this.n2=n2;
			 }
		 }//LinkedListNode
		 
		 
		 class AnotherList{
			 
			 //Now because the nodes are different I should create the structures  ...or perhaps copy the other...
			 
		 
			 LinkedListNode addLists(Node l1, Node l2, int carry) {
					 
					 /* We're done if both lists are null AND the carry value is 0 */
					 
					 if (l1 == null && l2 == null && carry == 0) {				 
						 return null;
					 }
					 
					  LinkedListNode result = new LinkedListNode(carry, null, null);
					  					 
					 /* Add value, and the data from 11 and 12 */				 
					 int value = carry;//Initialized to carry value
					 if (l1 != null) {
						 value += Integer.valueOf((String) l1.data);
					  }
					  if (l2 != null) {
						  value += Integer.valueOf((String)l2.data);
					  }
					  
					  result.data = value % 10; /* Second digit of number */
					 
					 /* Recurse */
					 if (l1 != null || l2 != null) {				 
						 LinkedListNode more = addLists( l1 == null ? null : l1.next,
														 l2 == null ? null : l2.next,
														 value >= 10 ? 1 : 8);
						//Should be add to the LinkedList structure the node result. AddLinkedList.addNode(more);
						result.setNext(more);//I think She meant add to the list another Node (which I think is a GEC just how it is the method now, u should not mix the Node class with the list class..)(Grave Error de Concepto)
					 }
					 return result;
			 	}
		 }//AnotherList class
		 
		 
		 //Solutions from "http://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list"
		 //Detect if a list has a loop  O(n) 
		 
		 boolean hasLoop(Node first) {
			    Node slow = first;
			    Node fast = first;

			    while(fast != null && fast.next != null) {
			        slow = slow.next;          // 1 hop
			        fast = fast.next.next;     // 2 hops 

			        if(slow == fast)  // fast caught up to slow, so there is a loop
			            return true;
			    }
			    return false;  // fast reached null, so the list terminates
			}
		 
		 
		 //Best possible solution??  it is supposedly quicker than the given as good solution..
		 
		 public static boolean hasLoop2(Node root){
			    if(root == null) return false;

			    Node slow = root, fast = root;
			    int taken = 0, limit = 2;

			    while (fast.next != null) {
			        fast = fast.next;
			        taken++;
			        if(slow == fast) return true;

			        if(taken == limit){
			            taken = 0;
			            limit <<= 1;    // equivalent to limit *= 2;
			            slow = fast;    // teleporting the turtle (to the hare's position) 
			        }
			    }
			    return false;
			}

		 
	//CCI book problem
		 //Given a circular linked list, implement an algorithm which returns the node at the
//		 beginning of the loop.
		 
	
LinkedListNode FindBeginning(LinkedListNode head) {
	LinkedListNode slow = head;
	LinkedListNode fast = head;	
	// Find meeting point. This will be LOOP_SIZE - k steps into the
	// linked list. 
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) { // Collision
			break;
		}
	 }	 	 
	 /* Error check - no meeting point, and therefore no loop */
	 if (fast == null || fast.next == null) {
	  return null;
	 }	 
	 /* Move slow to Head. Keep fast at Meeting Point. Each are k
	 * steps from the Loop Start. If they move at the same pace,
	 * they must meet at Loop Start. */
	 slow = head;
	 while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	
	 }	 
	 /* Both now point to the start of the loop. */
	 return fast;
 }//function

	 	
	public static void main(String[] args){
		
		Sllist sl=new Sllist();
		sl.addToEnd("0");
		sl.addToEnd("1");
		sl.addToEnd("2");
		sl.addToEnd("3");
		sl.traverse();
		int i=66; boolean b;
		//This does not fails it is just the resulting list cannot erase inexisting positions
	//		b=sl.removeAt(0);
	//		sl.traverse();
	//		b=sl.removeAt(1);
	//		sl.traverse();
	//		b=sl.removeAt(2);
	//		sl.traverse();
	//		b=sl.removeAt(3);
	//		sl.traverse();
		
		
		
		
		b=sl.removeAt(i);
		System.out.println("Removed element: "+i+" (Starting from 0), Result: "+b);
		sl.traverse();
		ntoLast(sl.head, 33); // NOT WORKING AS EXPECTED (it prints 3 positions from the end)
		
		
		//----------------- Trying the recursive method simulating pass by reference using an Object
		//Print what we have...
		sl.traverse();
		System.out.println("------------");
		//Node
		Node nodee=sl.new Node();
		sl.addToEnd("4");sl.addToEnd("5");
		sl.traverse();
		//You pass the position of the list and it returns the element (Node)
		nodee=sl.nthToLastR2(sl.head, 6,sl.new IntWrapper());
		if (nodee!=null)
			System.out.println("Found: "+nodee.data);
		else
			System.out.println("Found: "+null);
		System.out.println("------------");
		// In this case would be from the 2nd element to the end (NULL) OK :)
		nthToLast(sl.head, 2);
		
	}//main
	
	
}//class Sllist
