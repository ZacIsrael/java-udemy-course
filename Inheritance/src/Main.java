public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1,5,5);
        // Creates an animal named "Animal" with a brain size of 1, a body size of 1, a size of 5, and a weight of 5

        Dog dog = new Dog("YorkiE", 8, 20, 2, 4, 1, 20, "long silky");
        // Initializes a dog
        dog.eat();
        // this "eat" method works for the dog because it is publicly defined in the animal class
        dog.walk();
        dog.run();
    }

}
