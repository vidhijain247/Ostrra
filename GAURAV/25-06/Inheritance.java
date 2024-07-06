
class Animal {
   
    void eat() {
        System.out.println("The animal is eating.");
    }
}

class Elephant extends Animal {
    
    void snore() {
        System.out.println("The Elephant is snoring.");
    }
}
class Calf extends Elephant {
    
    void play() {
        System.out.println("The calf is playing.");
    }
}

class Cat extends Animal {
    
    void meow() {
        System.out.println("The cat is meowing.");
    }
}


public class Inheritance{
    public static void main(String[] args) {
       
        Calf myCalf= new Calf();

        myCalf.eat();  
        myCalf.snore();
		myCalf.play();
		
		Cat myCat = new Cat();
        myCat.eat();
        myCat.meow(); 
	}
}