package com.sunil;

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
    @Column(name = "Parkinglotid", nullable = false)
    public int getParkinglotid() {
        return parkinglotid;
    }

    public void setParkinglotid(int parkinglotid) {
        this.parkinglotid = parkinglotid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "size", nullable = false)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
