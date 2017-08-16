/**
 * Created by SUNIL PC on 18-07-2017.
 */
public class InnerClassApp {

    public static void main(String[] args) {

        Ecosystem eco= new Ecosystem();
        eco.content();

        Ecosystem.Community com = eco.new Community();
        com.content();

        Ecosystem.Community.Population pop = com.new Population();
        pop.content();

        Ecosystem.Community.Population.Organism org = pop.new Organism();
        org.content();

        Ecosystem.Community.Population.Organism.OrganSystem os = org.new OrganSystem();
        os.content();

        Ecosystem.Community.Population.Organism.OrganSystem.Organ organ= os.new Organ();
        organ.content();

        Ecosystem.Community.Population.Organism.OrganSystem.Organ.Tissue tissue= organ.new Tissue();
        tissue.content();

        Ecosystem.Community.Population.Organism.OrganSystem.Organ.Tissue.Cell cell= tissue.new Cell();
        cell.content();


    }
}
