package model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private int expirienceYears;
    private boolean isFree;

    public Doctor(int id, String name, String specialization, int expirienceYears){
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.expirienceYears = expirienceYears;
        this.isFree = true;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        System.out.println("Doctor name is: ");
        return name;
    }
    public String getSpecialization(){
        System.out.println("Doctor specialization is: ");
        return specialization;
    }
    public int getExpirienceYears(){
        return expirienceYears;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public void setExpirienceYears(int expirienceYears){
        this.expirienceYears = expirienceYears;
    }
    public void assignPatient(){
        isFree = false;
        System.out.println("Doctor " + name + " now is busy with a patient");
    }
    public void finishAppoinment(){
        isFree = true;
        System.out.println("The Doctor is free now");
    }
    @Override
    public String toString() {
        return "Doctor[id: " + this.id +", " + "name: " + this.name +", " + "specialization: " + this.specialization + ", " + "expirience: " + this.expirienceYears + " years] ";
    }
}
