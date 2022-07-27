package com.example.android_dbsqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase myDB;
    SimpleAdapter myADT;
    ArrayList<String> aryMBRList;
    ArrayAdapter<String> adtMembers;
    ListView lstView;
    String strRecord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = this.openOrCreateDatabase("PhoneBook",MODE_PRIVATE,null);
        myDB.execSQL("Drop table if exists members");

        myDB.execSQL("Create table members("+
                "_id integer primary key autoincrement, "+
                "Name text not null,"+ "Phone_No text not null);");

        myDB.execSQL("Insert into members "+
                "(Name, Phone_No) values ('kdhong','011-8701-2320');");

        ContentValues insertValue = new ContentValues();
        insertValue.put("Name","Juliet");
        insertValue.put("Phone_No","010-123-1234");
        myDB.insert("members",null,insertValue);

        Cursor allRCD = myDB.query("members",null,
                null,null,null,null,null,null);

        aryMBRList = new ArrayList<String>();
        if(allRCD != null){
            if(allRCD.moveToFirst()){
                do{
                    strRecord = allRCD.getString(1)+"\t\t"+allRCD.getString(2);
                    aryMBRList.add(strRecord);
                }while(allRCD.moveToNext());
            }
        }
        adtMembers = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,aryMBRList);

        lstView = (ListView)findViewById(R.id.lstMember);
        lstView.setAdapter(adtMembers);
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        if(myDB != null) myDB.close();
    }
}