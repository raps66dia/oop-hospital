package model;

public abstract class Person {
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
    public void setName(String name) {
        if(name == null && name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;

    }
    public void setId(int id){
        if(id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Cannot be negative");
        }
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public abstract void work();

    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + "]" + "name: " + name + "(" + " id: "+ id + ", age: " + age + ")";
    }

}
