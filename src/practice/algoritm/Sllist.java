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
				head=head.next; //just move the head make lose the element (Is not accesible)
			}
		//More tha 1 element list
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
	
	
	//return from the kth element to the end of the list // NOT WORKING AS EXPECTED
	
	public static int ntoLast(Node head,int k){
		if (head==null)
			return 0;		
		int i=ntoLast(head.next,k)+1;		
		if (i==k)
			System.out.println("["+head.data+"]-->");
		return i;
	}
	
	public static void main(String[] args){
		
		Sllist sl=new Sllist();
		sl.addToEnd("0");
		sl.addToEnd("1");
		sl.addToEnd("2");
		sl.addToEnd("3");
		sl.traverse();
		int i=66; boolean b;
		//This fails and I don't know why, everything works separately..
		//b=sl.removeAt(0);b=sl.removeAt(1);b=sl.removeAt(2);b=sl.removeAt(3);
		b=sl.removeAt(i);
		System.out.println("Removed element: "+i+" (Starting from 0), Result: "+b);
		sl.traverse();
		//ntoLast(sl.head, 1); // NOT WORKING AS EXPECTED
	}
	
	
}//class Sllist
