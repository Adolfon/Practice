//Lambda expressions are used primarily to define inline implementation of
//a functional interface, i.e., an interface with a single method only.
//In the above example, we've used various types of lambda expressions to 
//define the operation method of MathOperation interface. Then we have 
//defined the implementation of sayMessage of GreetingService.
//
//Lambda expression eliminates the need of anonymous class and gives a 
//very simple yet powerful functional programming capability to Java.




package example.lambda.easy;

public class Calculator {
	
	interface IntegerMath {
        int operation(int a, int b);

        default IntegerMath swap() {
          return (a, b) -> operation(b, a);
        }
    }
	

    private static int apply(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    
    //Static so you can access directly with its name 
    private static int apply(int a,int b){
    	IntegerMath im = null;
    	return im.operation(a,b);
    }
    
    public void otherPackageCall(){
    	System.out.println("Sucess in the call to Calculator-otherPackageCall");
    }

    public static void main(String... args) {
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b; 
        IntegerMath operation= (a,b)->b;
        System.out.println("40 + 2 = " + apply(40, 2, addition));
        System.out.println("20 - 10 = " + apply(20, 10, subtraction));
        System.out.println("10 - 20 = " + apply(20, 10, subtraction.swap()));          
        System.out.println("Default interface operation 1 ,2 swap and see second: "+apply(1,2,operation));
        
        
    }

}
