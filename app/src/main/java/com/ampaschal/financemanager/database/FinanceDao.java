package com.ampaschal.financemanager.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Amusuo Paschal on 26/08/2019.
 */
@Dao
public interface FinanceDao {

    @Insert
    void addFinance(FinanceEntity financeEntity);

    @Query("SELECT * FROM FinanceEntity")
    List<FinanceEntity> getAll();

    @Update
    void updateFinance(FinanceEntity financeEntity);

    @Delete
    void deleteFinance(FinanceEntity financeEntity);

}
