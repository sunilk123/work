package Models;

import javax.persistence.*;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
@Entity
@Table(name = "Parking_Lot", schema = "dbo", catalog = "ParkingService")
public class ParkingLotEntity {
    private int parkinglotid;
    private String name;
    private int size;

    @Id
    @Column(name = "Parkinglotid")
    public int getParkinglotid() {
        return parkinglotid;
    }

    public void setParkinglotid(int parkinglotid) {
        this.parkinglotid = parkinglotid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingLotEntity that = (ParkingLotEntity) o;

        if (parkinglotid != that.parkinglotid) return false;
        if (size != that.size) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parkinglotid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }
}
