package com.neeraj.helloandroid;

import android.content.Context;

import androidx.room.Room;

public class DatabaseProvider {

    private static ExpenseDatabase database;

    public static ExpenseDatabase getDatabase(Context context) {

        if (database == null) {
            //Database builder (Room)
            database = Room.databaseBuilder(context.getApplicationContext(), ExpenseDatabase.class, "expense_database").build();
        }

        return database;
    }
}