
class Person {
    private int id;
    private String name;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    void BslanhOun(){
        System.out.println("Hello");
    }

}
class Animal{
  
    void sound(){
        System.out.println("Hello");        
    }
}
class Dog extends Animal {
    @Override
    void sound(){
        System.out.println("Wooffff!");
    }
}
class Cat extends Animal{
    @Override 
    void sound(){
        System.out.println("Meowwww");
    }
}



public class helloWorld {

    public static void LoveMeymey() {
        System.out.println("Love U babe");
        System.out.println("\033[38;2;255;0;255m Love You MEYMEY <3");
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println("Hello world");
        LoveMeymey();
        Cat c = new Cat();
        c.sound();
        Person p = new Person();
        p.setId(12);
        

    }
}