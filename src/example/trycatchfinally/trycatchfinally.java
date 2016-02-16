package example.trycatchfinally;

public class trycatchfinally {
	
	public static String lem() {
		System.out.println("lem");
		return "return from lem";
	 }
	 
	public static String foo() {	
		int x = 0;
		int y = 5;
		try {	
			System.out.println("start try");		
			int b = y / x;		
			System.out.println("end try");		
			return "returned from try";	
		} catch (Exception ex) {	
			System.out.println("catch");	
			return lem() + " | returned from catch";	
		} finally {
			System.out.println("finally");
		}
	}//foo
	
	 public static void bar() {
		System.out.println("start bar");
		String v = foo();
		System.out.println(v);
		System.out.println("end bar");
	 }
	
	 public static void main(String[] args) {
		 bar();
		 //second exercise (bellow)
		 String[] test = null;
		 try {
			 new trycatchfinally().new ExceptionTest().main(test);  //This is a very interesting line for nested Classes
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 class NewException extends Exception {
		 public NewException(){
			 System.out.println("Doing staff inside of the NewException class..");
		 }
		 }
	 class AnotherException extends Exception {
		 public AnotherException(){
			 System.out.println("Doing staff inside of the AnotherException class..");
		 }
	 }
	 class ExceptionTest{
		 public  void main(String[] args) throws Exception{
			 System.out.println("Hello from: "+this.getClass().getName());
			 try{
				 m2();
			 }//catch (NewException e){System.out.println("Catching NexException...");}
			 finally{
				 //try{
					 m3();
				 //}catch(AnotherException ae){System.out.println("Catching AnotherE..");}
			 }
			 //catch (NewException e){}  catch statement never can go after finally statement but of course it can go inside.
		 }		//As you can see...
	 public  void m2() throws NewException { throw new NewException();};
	 public  void m3() throws AnotherException{ throw new AnotherException();};
	 }
	 

	

}//class
/*  This is the program exit as it is now: 
start bar
start try
catch
lem
finally
return from lem | returned from catch
end bar
 */