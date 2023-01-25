package com.example.finals_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addBtn, updateBtn, viewBtn, deleteBtn;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        //button casting
        addBtn = (Button) findViewById(R.id.button_add);
        updateBtn = (Button) findViewById(R.id.button_update);
        viewBtn = (Button) findViewById(R.id.button_view);
        deleteBtn = (Button) findViewById(R.id.button_delete);

        //set button listener
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openAddPage();}
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openUpdatePage(); }
        });

        //view all data
        ViewAll();

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openDeletePage(); }
        });

    }

    //create class that views all the data
    public void ViewAll(){
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getALlData();
                if (res.getCount() == 0){
                    showMessage("Error", "Nothing Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("Name : "+res.getString(1)+"\n");
                    buffer.append("Course : "+res.getString(2)+"\n");
                    buffer.append("Year : "+res.getString(3)+"\n");
                    buffer.append("Age : "+res.getString(4)+"\n______\n");
                }

                showMessage("data", buffer.toString());

            }
        });
    }

    //create class that intents to another activity
    public void openAddPage(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

    public void openUpdatePage(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void openDeletePage(){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}