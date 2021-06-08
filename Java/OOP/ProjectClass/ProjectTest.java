

public class ProjectTest {
    public static void main(String[] args) {
        // Test Code
        Project project1 = new Project();
        Project project2 = new Project("Stringify");
        Portfolio portfolio = new Portfolio();
        // System.out.println(project1.getName());
        // System.out.println(project2.getName());
        // System.out.println(project2.elevatorPitch());

        portfolio.AddToPortfolio(project2);
        portfolio.AddToPortfolio(project1);
        System.out.println(portfolio.getPortfolio());
        portfolio.showPortfolio();

    }
}