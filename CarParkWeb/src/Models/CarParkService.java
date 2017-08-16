package Models;

/**
 * Created by SUNIL PC on 20-07-2017.
 */
public class CarParkService {

    private int slots;
    private int limit;

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) throws CarParkException {
        if(slots<0)
            throw new CarParkException(null);
        else
            this.slots = slots;
        limit=slots;
    }

    public int getLimit() {
        return limit;
    }

    public void Park(){
        if(slots>0)
            slots--;
    }

    public void Leave(){

        if(slots<limit)
            slots++;
    }
}
