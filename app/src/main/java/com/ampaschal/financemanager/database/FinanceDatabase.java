package com.ampaschal.financemanager.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Amusuo Paschal on 26/08/2019.
 */

@Database(entities = {FinanceEntity.class}, version = 1)
public abstract class FinanceDatabase extends RoomDatabase {

    public abstract FinanceDao getFinanceDao();

    private static FinanceDatabase financeDb;

    public static FinanceDatabase getInstance(Context context) {
        if (null == financeDb) {
            financeDb = buildDatabaseInstance(context);
        }
        return financeDb;
    }

    private static FinanceDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                FinanceDatabase.class,
                "Finance Database")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        financeDb = null;
    }
}
