import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by SUNIL PC on 15-07-2017.
 */
public class CarParkLot {

    public static void main(String[] args) {

        System.out.println("enter the number of parking slots");
        Scanner console = new Scanner(System.in);
        int slots=0;

        try {
            slots= console.nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println(e);
            main(null);

        }

        Resource res= new Resource();
        res.setLots(slots);
        while (true) {
                System.out.println("park--------> P");
                System.out.println("leave-------> L");
                System.out.println("Free SLots---> C");
                System.out.println("Enter selection");
                String selection = console.next();
                if (selection.equals("P")) {
                    if (!res.alotLot())
                        System.out.println("no empty space");
                } else if (selection.equals("L")) {
                    res.emptyLot();
                } else if (selection.equals("C"))
                    System.out.println("space left :" + res.getLots());
                else
                    System.out.println("wrong selection");
            }


    }
}
