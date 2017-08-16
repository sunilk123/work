
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by SUNIL PC on 15-07-2017.
 */
public class CarParkLot {

    public static void main(String[] args) {


        Resource res= new Resource();
        Scanner console = new Scanner(System.in);
        System.out.println("Enter number of slots");
        try{
            res.setSlotsCount(console.nextInt());
        }
        catch (ResourceException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            exit(0);
        }
        catch (Exception e){
            System.out.println(e);
            exit(0);
        }
        while (true) {
                System.out.println("park--------> P");
                System.out.println("leave-------> L");
                System.out.println("Free SLots--> C");
                System.out.println("Enter selection");
                String selection = console.next();
                if (selection.equals("P")) {
                    if (!res.alotLot())
                        System.out.println("no empty space");
                }
                else if (selection.equals("L")) {
                    if(!res.emptyLot())
                        System.out.println("car lot empty");
                }
                else if (selection.equals("C"))
                    System.out.println("space left :" + res.getSlotsCount());
                else
                    System.out.println("wrong selection");
            }


    }
}
