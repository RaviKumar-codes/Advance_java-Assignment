//All functions performed by parent class should be inherited directly by is child class without any modification. 
// Base class representing a Bird
abstract class Bird {
    void makeSound() { } // Common behavior for all birds
}      

// Interface for birds that can fly
interface Flyable {
    void fly();
}

// A specific type of bird that can fly
class Eagle extends Bird implements Flyable {
    public void fly() {
        System.out.println("Eagle is soaring high");
    }
    
    void makeSound() {
        System.out.println("Eagle screeches");
    }// this call is simple extends from the common abstarct clas
    
    void hunt() {
        System.out.println("Eagle is hunting for prey");
    }
}

// A specific type of bird that cannot fly
class Penguin extends Bird {
    void makeSound() {
        System.out.println("Penguin honks");
    }// this call is simple extends from the common abstarct clas
    
    void swim() {
        System.out.println("Penguin is swimming");
    }
    
    void slideOnIce() {
        System.out.println("Penguin is sliding on ice");
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Flyable flyingBird = new Eagle();
        flyingBird.fly(); // Valid operation

        Bird eagle = new Eagle();
        eagle.makeSound();
        ((Eagle) eagle).hunt();

        Bird penguin = new Penguin();
        penguin.makeSound(); // Valid operation
        ((Penguin) penguin).swim();
        ((Penguin) penguin).slideOnIce();
        
        // Flyable nonFlyingBird = new Penguin(); //The following is NOT allowed because Penguin is not Flyable
    }
}
