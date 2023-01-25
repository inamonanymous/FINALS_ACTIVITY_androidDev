package com.example.finals_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    DatabaseHelper myDb;
    Button del_dataBtn, backBtn;
    EditText editID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myDb = new DatabaseHelper(this);

        //casting buttons
        backBtn = (Button) findViewById(R.id.back_Button_delete);
        del_dataBtn = (Button) findViewById(R.id.delete_data_Button);

        //casting edit text
        editID = (EditText) findViewById(R.id.textIDD);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { getBack(); }
        });
        DeleteData();
    }

    public void DeleteData(){
        del_dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editID.getText().toString());
                if(deletedRows != 0) Toast.makeText(MainActivity4.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else Toast.makeText(MainActivity4.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}