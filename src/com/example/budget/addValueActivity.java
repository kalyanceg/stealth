package com.example.budget;
import com.example.budget.R;

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

 public class addValueActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addvalue);
		 final ListView listview = (ListView) findViewById(R.id.listView2);
		 String[] op=new String[2];
		 op[0]="Increment Amount";
		 op[1]="Decrement Amount";
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, op);
	    
	    
	            // Assign adapter to ListView
	            listview.setAdapter(adapter); 
	            listview.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view,
	                        int position, long id) {

	              
                  int itemPosition     = position;
                  
                  if(itemPosition==0){
               	   Intent intent = new Intent(addValueActivity.this, incrementActivity.class);
                      startActivity(intent);      
                      finish();  	   
                  }
                  else{
                	  Intent intent = new Intent(addValueActivity.this, decrementActivity.class);
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