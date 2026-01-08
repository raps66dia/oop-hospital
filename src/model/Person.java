package model;

public class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person (){
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
    }

    public int getId() {
        return id;
    }
    public void work() {
        System.out.println(name + " is in hospital");
    }
    public String getRole(){
        return "Person";
    }
    @Override
    public String toString() {
        return "[" + getRole() + "]" + "name: " + name + "(" + " id: "+ id + ", age: " + age + ")";
    }

}
