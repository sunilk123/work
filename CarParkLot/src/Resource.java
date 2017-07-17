import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUNIL PC on 15-07-2017.
 */
public class Resource {

    private int slots =0;
    private int limit=0;

    public int getLots() {
        return slots;
    }

    public void setLots(int slots) {
        this.slots = slots;
        limit=slots;
    }

    public boolean alotLot() {

        if (slots > 0) {
            slots--;
            return true;
        } else
            return false;
    }

    public boolean emptyLot() {

        if(slots==limit)
            return false;
        else{
            slots++;
            return true;
        }
    }
}
