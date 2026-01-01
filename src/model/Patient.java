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
        this.id = 0;
        this.age = 0;
        this.illness = "Unknown";
        this.name = "Unknown";
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
        if (illness != null && !illness.trim().isEmpty()) {
            this.illness = illness;
        } else {
            System.out.println("Warning: illness empty!");
        }
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    public void setAge(int age){
        if(age >= 0) {
            this.age = age;
        } else {
            System.out.println("Warning: age cannot be negative!");
            this.age = 0;
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
