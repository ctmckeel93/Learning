import java.util.*;



public class Project {
    private String name;
    private String description;
    private double initialCost;

    Project() {
        this("Empty Project", "No description for this project yet", 50);
    }

    Project(String name) {
        this.name = name;
        this.initialCost = 50;
        this.description = "No description for this project yet";
    }

    Project(String name, String desc, double cost){
        this.name = name;
        this.description = desc;
        this.initialCost = cost;
    }


    // getters & setters   
    public String getName() {
            return this.name;
    }

    public void setName(String rename) {
        this.name = rename;
    }

    public String getInfo() {
        return this.description;
    }

    public void setInfo(String newInfo) {
        this.description = newInfo;
    }

    public double getCost() {
        return this.initialCost;
    }

    public void setCost(double newCost) {
        this.initialCost = newCost;
    }
    //********************************/

    public String elevatorPitch() {
        return this.name + String.format("($%.2f)", this.initialCost) + ": " + this.description;
    }

}