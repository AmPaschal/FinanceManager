package com.ampaschal.financemanager.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Amusuo Paschal on 26/08/2019.
 */
@Entity
public class FinanceEntity {
    @PrimaryKey
    private long date;

    private String dateString;

    private String category;

    private String purpose;

    private double amount;

    public FinanceEntity(long date, String dateString, String category, String purpose, double amount) {
        this.date = date;
        this.dateString = dateString;
        this.category = category;
        this.purpose = purpose;
        this.amount = amount;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
