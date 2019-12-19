package lk.ac.mrt.cse.dbs.simpleexpensemanager.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.ExpenseManager;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.exception.ExpenseManagerException;

public class PersistantExpenseManager extends ExpenseManager {

    public static final String DATABASE_NAME = "170610K.db";
    public static final String TABLE_NAME1 = "AccountDetails";
    public static final String TABLE_NAME2 = "Transactions";

    public static final String COL1 = "AccountNo";
    public static final String COL2 = "Bank";
    public static final String COL3 = "AccountHolder";
    public static final String COL4 = "InitialBalance";
    public static final String COL5 = "ID";
    public static final String COL6 = "ExpenseType";
    public static final String COL7 = "Date";
    public static final String COL8 = "amount";

    public static PersistantExpenseManager instance;

    public static PersistantExpenseManager getInstance(Context context) {
        if (instance == null) {
            instance = new PersistantExpenseManager(context);
        }
        return instance;
    };


    public PersistantExpenseManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void setup() throws ExpenseManagerException {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1+ "(AccountNo int primary key, Bank varchar(10), AccoubtHolder text, InitialBalance int )");
        db.execSQL ("create table " + TABLE_NAME2 + "(ID int primary key autoincrement, ExpenseType text, Date date, amount int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" drop table if exists "+TABLE_NAME1);
        db.execSQL(" drop table if exists "+TABLE_NAME2);
        onCreate(db);

    }
}
