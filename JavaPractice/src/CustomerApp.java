import java.util.Scanner;

/**
 * Created by SUNIL PC on 20-07-2017.
 */
public class CustomerApp {

    public static void main(String[] args) throws Exception  {




        Customer cs=new Customer();
        Scanner sc= new Scanner(System.in);
        try{
            cs.setCustId(sc.nextInt());
            cs.setEmailId(sc.next());
        }
        catch (CustomerException e){
            System.out.println(e.getMessage());

        }
        catch(CustomerEmailException e){
            System.out.println(e.getMessage());
        }

    }
}
