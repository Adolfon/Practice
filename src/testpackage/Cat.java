package testpackage;

import inheritance.Animal;

public class Cat extends Animal{
		
        public static void testClassMethod() {
            System.out.println("The class method" + " in Cat.");
        }
        
//        @Override
//        public void testInstanceMethod() {
//            System.out.println("The instance method" + " in Cat.");
//        }

        public static void main(String[] args) {
            Cat myCat = new Cat();
            Animal myAnimal = myCat;
            myAnimal.testClassMethod();
            //myAnimal.testInstanceMethod();
            
           
            Animal cat = new Cat();

            
            //cat.testInstanceMethod(); // Not allowed, because compiler doesn't know that runtime type of cat is Cat

            ((Cat) cat).testInstanceMethod(); // Allowed
            
        }
    }
