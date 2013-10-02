package com.example.budget;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class categoryActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category);
		 final ListView listview = (ListView) findViewById(R.id.listView2);
		 dbUtil dbObj=new dbUtil(categoryActivity.this);
         ArrayList<String> catList=dbObj.selectCat(dbObj.getWritableDatabase());
         catList.add("Other");
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_2, android.R.id.text2, catList);
         listview.setAdapter(adapter);
         listview.setOnItemClickListener(new OnItemClickListener() {
             public void onItemClick(AdapterView<?> parent, View view,
                     int position, long id) {

           
            int itemPosition     = position;
            
            
            String  itemValue    = (String) listview.getItemAtPosition(position);
            if(itemValue.equals("Other")){
            	Intent intent = new Intent(categoryActivity.this, addClassActivity.class);
                startActivity(intent);      
                finish();
            }
            else{
            	dbUtil dbObj=new dbUtil(categoryActivity.this);
            	dbObj.decrement(dbObj.getWritableDatabase(),itemValue,decrementActivity.decramnt);
	            decrementActivity.decramnt=0;
	            Toast.makeText(categoryActivity.this, "Amount Reduced from DB successfully", Toast.LENGTH_SHORT).show();
	            Intent intent = new Intent(categoryActivity.this, MainActivity.class);
                startActivity(intent);      
                finish();  	 
            }
          }

			
       });
	}

}
