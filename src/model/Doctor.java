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
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getExperienceYears(){
        return experienceYears;
    }
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            System.out.println("Warning: id is not right! Setting to 0.");
            this.id = 0;
        }
    }
    public void setName(String name){
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty!");
        }
    }
    public void setSpecialization(String specialization){
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Warning: write correct!");
        }
    }
    public void setExperienceYears(int experienceYears){
        if (experienceYears > 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
        }
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
