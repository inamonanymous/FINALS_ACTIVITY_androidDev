package com.example.finals_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper myDb;
    Button add_dataBtn, backBtn;
    EditText editName, editCourse, editYear, editAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);

        //casting Edit Text
        editName = (EditText) findViewById(R.id.fName);
        editCourse = (EditText) findViewById(R.id.course);
        editYear = (EditText) findViewById(R.id.year);
        editAge = (EditText) findViewById(R.id.age);

        //casting buttons
        backBtn = (Button) findViewById(R.id.back_Button_add);
        add_dataBtn = (Button) findViewById(R.id.add_data_Button);

        //add data function
        AddData();

        //back button listener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { getBack(); }
        });
    }

    public void AddData(){
        add_dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editName.getText().toString(),
                        editCourse.getText().toString(),
                        editYear.getText().toString(),
                        editAge.getText().toString());
                if (isInserted == true) Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else Toast.makeText(MainActivity2.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}