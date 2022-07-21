public class Dog extends Animal {
    // The following objects are specific to dogs, not necessarily all of the other creatures that fit in the animal category
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes , int legs, int tail, int teeth, String coat) {
        // The parameters from the animal class have been used to create the constructor for the dog class
        super(name, 1, 1, size, weight);
        // All animals have a brain and a body , so the programmer should not have tp re define them
        // super means call the constructor that the class is extending/inheriting from

        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;this.coat = coat;


    }
    private void chew(){ // This method will only work for the dog because it is private
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }
    public void walk(){
        System.out.println("Dog.walk() called");
       move(5);

    }
    public void run(){
        System.out.println("Dog.run() called");
        move(10);
    }
    public void moveLegs(int speed){
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
