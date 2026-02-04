package model;

public class Doctor extends Person {
    private String specialization;
    private int experienceYears;
    private boolean isFree;

    public Doctor(int id, String name, int age, String specialization, int experienceYears){
        super(id, name, age);
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.isFree = true;
    }
    public Doctor(){
        super(0, "unknown", 0);
        this.specialization = "Null";
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setSpecialization(String specialization){
        if (specialization == null && specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Warning: write correct!");
        }
        this.specialization = specialization;
    }
    public String getSpecialization(){
        return specialization;
    }

    public void setExperienceYears(int experienceYears){
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Can't be negative!");
        }
        this.experienceYears = experienceYears;
    }
    public int getExperienceYears(){
        return experienceYears;
    }

    public void assignPatient(){
        isFree = false;
        System.out.println("Doctor " + name + " now is busy with a patient");
    }
    public void finishAppoinment(){
        isFree = true;
        System.out.println(name + " is free now");
    }
    @Override
    public String toString() {
        return "Doctor[id: " + this.id +", " + "name: " + this.name +", " + "specialization: " + this.specialization + ", " + "expirience: " + this.experienceYears + " years] ";
    }
    @Override
    public void work(){
        System.out.println("Doctor " + name + " is treating patients.");
    }
    @Override
    public String getRole(){
        return "Doctor";
    }
}
