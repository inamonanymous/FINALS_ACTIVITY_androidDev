package com.example.finals_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button update_dataBtn, backBtn;
    EditText editID, editName, editCourse, editYear, editAge;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myDb = new DatabaseHelper(this);


        //casting Edit Text
        editID = (EditText) findViewById(R.id.textID);
        editName = (EditText) findViewById(R.id.fNameU);
        editCourse = (EditText) findViewById(R.id.courseU);
        editYear = (EditText) findViewById(R.id.yearU);
        editAge = (EditText) findViewById(R.id.ageU);

        //casting buttons
        backBtn = (Button) findViewById(R.id.back_Button_update);
        update_dataBtn = (Button) findViewById(R.id.update_data_Button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { getBack(); }
        });
        UpdateData();
    }

    public void UpdateData(){
        update_dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData(editID.getText().toString(),
                        editName.getText().toString(),
                        editCourse.getText().toString(),
                        editYear.getText().toString(),
                        editAge.getText().toString());
                if(isUpdated == true)  Toast.makeText(MainActivity3.this, "Data Updated", Toast.LENGTH_LONG).show();
                else  Toast.makeText(MainActivity3.this, "Data not Updated", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void getBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}