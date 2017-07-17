

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by SUNIL PC on 14-07-2017.
 */
public class HelloWorld {
    public static void main(String[] args) {

        while(true) {
            System.out.println("enter your name");
            Scanner console = new Scanner(System.in);
            String name = console.nextLine();

            if(StringUtils.isAlphanumeric(name)&&!StringUtils.isNumeric(name))
                System.out.println(name.toUpperCase());//print caps


        }

    }
}
