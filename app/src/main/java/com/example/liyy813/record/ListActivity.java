package com.example.liyy813.record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    Button save, delete,tkPicture;
    ArrayList<String>addArray = new ArrayList<String>();
    ArrayList<String>deleteArray = new ArrayList<String>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        txt = (EditText)findViewById(R.id.txtInput);
        show = (ListView)findViewById(R.id.listView);
        save = (Button)findViewById(R.id.btnSave);
        delete = (Button)findViewById(R.id.btnDelete);
        tkPicture = (Button)findViewById(R.id.btnPicture);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if(addArray.contains(getInput)){
                    Toast.makeText(getBaseContext(),"Item Already Add To The Array", Toast.LENGTH_LONG).show();
                }
                else if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Input Field Is Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, addArray);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.txtInput)).setText(" ");

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String deleteInput = txt.getText().toString();

                if(addArray.contains(deleteInput)){
                    addArray.remove(deleteInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, addArray);
                    show.setAdapter(adapter);
                   // save.setBackgroundColor(Color.BLACK);
                   ((EditText)findViewById(R.id.txtInput)).setText(" ");
                } else {
                    Toast.makeText(getBaseContext(),"Item Doesn't in The Array", Toast.LENGTH_LONG).show();
                }

            }
        });

        tkPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, PhotoActivity.class);
                intent.getClass();
                startActivity(intent);
            }
        });

    }

}
