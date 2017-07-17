import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;

/**
 * Created by SUNIL PC on 15-07-2017.
 */
public class CarParkLotUI {

    public static void main(String[] args) {

        int slots,limit;
        Scanner console = new Scanner(System.in);
        System.out.println("enter slots");
        slots=console.nextInt();
        limit=slots;
        while(true) {
            System.out.println("park--------> P");
            System.out.println("leave-------> L");
            System.out.println("Free Lots---> C");
            System.out.println("Enter selection");
            String selection = console.next();
            if (selection.equals("P")||selection.equals("p")) {
                if(slots==0)
                    System.out.println("parking is full");
                else
                    slots--;

            }
            else if (selection.equals("L"))
                if(slots==limit)
                    System.out.println("incorrect selection");
                else
                    slots++;
            else if (selection.equals("C"))
                System.out.println("spaces lefts" + slots);
            else
                System.out.println("wrong selection");
        }

    }
}
