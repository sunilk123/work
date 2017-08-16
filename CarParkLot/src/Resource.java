/**
 * Created by SUNIL PC on 23-07-2017.
 */
public class Resource {

    private int slots;
    private int limit;

    public int getSlotsCount() {
        return slots;
    }

    public void setSlotsCount(int slots) throws ResourceException {
            if (slots < 0)
                throw new ResourceException("can not be negative");
            else {
                this.slots = slots;
                limit = slots;
            }
    }

    public boolean alotLot(){

        if(slots==0)
            return false;
        else {

            slots--;
            return true;
        }
    }
    public boolean emptyLot(){

        if(slots==limit){
            return false;
        }
        else{
            slots++;
            return true;

        }
    }
}
