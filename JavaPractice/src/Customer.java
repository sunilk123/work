/**
 * Created by SUNIL PC on 20-07-2017.
 */
public class Customer {

    private int custId;
    private String custName;
    private String emailId;


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) throws CustomerException  {

        if(custId<0) {
            throw new CustomerException("it can not be negative");

        }
        else
            this.custId=custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) throws CustomerEmailException {
       if(emailId.contains("@"))
           this.emailId=emailId;
       else
           throw new CustomerEmailException("not valid email");
    }
}
