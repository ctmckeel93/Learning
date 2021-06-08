import java.util.ArrayList;
public class Portfolio  {
    public ArrayList<Project> Projects;

    Portfolio() {
        this.Projects = new ArrayList<Project>();
    }

    public void addToPortfolio(Project addition) {
        Projects.add(addition);
    }

    public String getPortfolio() {

        return Projects.toString();
    }

    public double getPortfolioCost() {
        double cost = 0;
        for (Project p : Projects) {
            cost += p.getCost();

        }
        return cost;
    }

    public void showPortfolio() {
        
          for (Project p : Projects) {
              System.out.println(p.elevatorPitch());
          }
    }
}