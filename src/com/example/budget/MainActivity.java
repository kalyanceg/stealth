package com.example.budget;



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


public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final ListView listview = (ListView) findViewById(R.id.listView1);
		 String[] op=new String[3];
		 op[0]="Add values";
		 op[1]="Visualize";
		 op[2]="Hotels Beta";
		
		   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		              android.R.layout.simple_list_item_1, android.R.id.text1, op);
		    
		    
		            // Assign adapter to ListView
		            listview.setAdapter(adapter); 
		            listview.setOnItemClickListener(new OnItemClickListener() {
		                public void onItemClick(AdapterView<?> parent, View view,
		                        int position, long id) {

		              
	                   int itemPosition     = position;
	                   
	                   
	                   String  itemValue    = (String) listview.getItemAtPosition(position);
	                   if(itemPosition==0){
	                	   Intent intent = new Intent(MainActivity.this, addValueActivity.class);
	                       startActivity(intent);      
	                       finish();  	   
	                   }
	                   else if(itemPosition==1){
	                	   Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
	                       startActivity(intent);      
	                       finish();  
	                   }
	                   else if(itemPosition==2){
	                	   Intent intent = new Intent(MainActivity.this, hotelList.class);
	                       startActivity(intent);      
	                       finish();  
	                   }
		               
		             }
		          });
		         
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		
		return true;
	}  

}



