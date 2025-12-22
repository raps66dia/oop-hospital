package model;

public class Patient {
    private int id;
    private int age;
    private String illness;
    private String name;
    private boolean admitted;

    public Patient(int id, int age, String illness, String name){
        this.id = id;
        this.age = age;
        this.illness = illness;
        this.name = name;
    }
    public Patient(){

    }
    public int getID(){
        System.out.println("ID of patient: ");
        return id;
    }
    public String getName(){
        return name;
    }
    public String getIllness() {
        return illness;
    }
    public boolean isAdmitted(){
        return admitted;
    }
    public void setIllness(String illness){
        this.illness = illness;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age > 0) {
            this.age = age;
        }
    }
    public void admitPatient(){
        admitted = true;
        System.out.println(name + " has been admitted to the hospital");
    }
    public void dischargePatient(){
        admitted = false;
        System.out.println(name + " has been discharged from the hospital");
    }
    @Override
    public String toString() {
        return "Patient[id: " + id +", " + "name: " + name +", " + "illness: " + illness + "]";
    }
}
