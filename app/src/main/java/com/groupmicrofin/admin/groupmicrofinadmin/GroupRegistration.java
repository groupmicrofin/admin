package com.groupmicrofin.admin.groupmicrofinadmin;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class GroupRegistration extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_registration);
    }


    public void createGroup(View view) {

        EditText grpName = (EditText) findViewById(R.id.grpName);
        EditText frequency = (EditText) findViewById(R.id.frequency);
        EditText startDate = (EditText) findViewById(R.id.startDate);
        EditText meetingDay = (EditText) findViewById(R.id.meetingDay);
        EditText shareInstallValue = (EditText) findViewById(R.id.shareInstallValue);
        EditText interestRate = (EditText) findViewById(R.id.interestRate);
        EditText maxLoanEligibility = (EditText) findViewById(R.id.maxLoanEligibility);
        EditText guarantorsCount = (EditText) findViewById(R.id.guarantorsCount);
        EditText grpEmail = (EditText) findViewById(R.id.grpEmail);
        EditText grpAcctPassword = (EditText) findViewById(R.id.grpAcctPassword);

        ContentValues contentValues = new ContentValues();
        contentValues.put("group_id", "123456789");
        contentValues.put("group_name", grpName.getText().toString());
        contentValues.put("group_start_date", startDate.getText().toString());
        contentValues.put("meeting_frequency", frequency.getText().toString());
        contentValues.put("meeting_schedule", meetingDay.getText().toString());
        contentValues.put("share_install_value", shareInstallValue.getText().toString());
        contentValues.put("loan_int_rate", interestRate.getText().toString());
        contentValues.put("max_loan_disb_ratio", maxLoanEligibility.getText().toString());
        contentValues.put("loan_gauranters_count", guarantorsCount.getText().toString());
        contentValues.put("audit_created_dttm", String.valueOf(new Date()));
        contentValues.put("audit_updated_dttm", String.valueOf(new Date()));
        contentValues.put("login_email", grpEmail.getText().toString());
        contentValues.put("login_password", grpAcctPassword.getText().toString());

        try {


            SQLiteOpenHelper dbHelper = new AdminDBSQLiteHelper(this);
            SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();

            writableDatabase.insert("group_master", null, contentValues);

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Exception while inserting in DB : " + e.getStackTrace(), Toast.LENGTH_LONG);
            toast.show();

        }

        Toast toast = Toast.makeText(this, "Group Registration Successfull", Toast.LENGTH_LONG);
        toast.show();

        Intent naviationIntent = new Intent(this, Navigation.class);
        startActivity(naviationIntent);


    }
}
