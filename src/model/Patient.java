package model;

public class Patient extends Person{
    private String illness;
    private boolean admitted;

    public Patient(int id, int age, String illness, String name){
        super(id, name, age);
        this.illness = illness;
    }
    public Patient(){
        super(0, "Unknown", 0);
        this.illness = "Unknown";
    }
    public void setIllness(String illness){
        if (illness != null && !illness.trim().isEmpty()) {
            this.illness = illness;
        } else {
            System.out.println("Warning: illness empty!");
        }
    }
    public String getIllness() {
        return illness;
    }

    public boolean isAdmitted(){
        return admitted;
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
        return "Patient[id: " + id +", " + "name: " + name +", age: " + age + ", illness: " + illness + "]";
    }
    @Override
    public void work() {
        System.out.println("Patient " + name + " is being treated.");
    }
    @Override
    public String getRole() {
        return "Patient";
    }
}
