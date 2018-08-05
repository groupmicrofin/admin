package com.groupmicrofin.admin.groupmicrofinadmin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminDBSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MicroFinAdminDB";
    private static final int DB_VERSION = 1;


    public AdminDBSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table group_master (\n" +
                "\t_id\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tgroup_id\t\t\tTEXT,\n" +
                "\tgroup_name\t\t\tTEXT,\t\n" +
                "\tgroup_start_date\tTEXT,\n" +
                "\tmeeting_frequency\tINTEGER,\n" +
                "\tmeeting_schedule\tTEXT,\n" +
                "\tshare_install_value\tREAL,\n" +
                "\tloan_int_rate\t\tREAL,\n" +
                "\tmax_loan_disb_ratio\tREAL,\n" +
                "\tloan_gauranters_count INTEGER,\n" +
                "\taudit_created_dttm\tTEXT,\n" +
                "\taudit_updated_dttm\tTEXT,\n" +
                "\tlogin_email\t\t\tTEXT,\n" +
                "\tlogin_password\t\tTEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
