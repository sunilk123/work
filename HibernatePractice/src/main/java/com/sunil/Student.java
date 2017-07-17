package com.sunil;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by SUNIL PC on 12-07-2017.
 */
@Entity
public class Student {

    @Id
    private int SId;
    private String SName;
    private int SMarks;

    public int getSId() {
        return SId;
    }

    public void setSId(int SId) {
        this.SId = SId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public int getSMarks() {
        return SMarks;
    }

    public void setSMarks(int SMarks) {
        this.SMarks = SMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SId=" + SId +
                ", SName='" + SName + '\'' +
                ", SMarks=" + SMarks +
                '}';
    }
}
