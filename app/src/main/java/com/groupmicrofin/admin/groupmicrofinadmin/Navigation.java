package com.groupmicrofin.admin.groupmicrofinadmin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Navigation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {

                switch (position) {
                    case 0:
                        Toast toast = Toast.makeText(Navigation.this, "Hello we are calling first activity", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent groupRegistrationIntent = new Intent(Navigation.this, GroupRegistration.class);
                        startActivity(groupRegistrationIntent);
                        break;

                }
            }
        };

        ListView listViewActivity = (ListView) findViewById(R.id.activityList);

        listViewActivity.setOnItemClickListener(listener);


    }
}
