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
    public Doctor(){
        this.id = 0;
        this.name = "Unknown";
        this.specialization = "Null";
        this.expirienceYears = 0;
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
    public int getExpirienceYears(){
        return expirienceYears;
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
    public void setExpirienceYears(int expirienceYears){
        if (expirienceYears > 0) {
            this.expirienceYears = expirienceYears;
        } else {
            this.expirienceYears = 0;
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
        return "Doctor[id: " + this.id +", " + "name: " + this.name +", " + "specialization: " + this.specialization + ", " + "expirience: " + this.expirienceYears + " years] ";
    }
}
