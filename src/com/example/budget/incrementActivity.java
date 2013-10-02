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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class incrementActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.increment);
		Button button= (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        EditText tf=(EditText)findViewById(R.id.editText1);
		        String st=tf.getText().toString();
		        if(st==null || st.length()<=0)
		        	Toast.makeText(incrementActivity.this, "Please Enter a value to Increment", Toast.LENGTH_SHORT).show();
		        else{
		            dbUtil dbObj=new dbUtil(incrementActivity.this);
		            dbObj.increment(dbObj.getWritableDatabase(), st);
		            Toast.makeText(incrementActivity.this, "Amount Added to DB successfully", Toast.LENGTH_SHORT).show();
		            Intent intent = new Intent(incrementActivity.this, MainActivity.class);
                    startActivity(intent);      
                    finish();  	  
		        }
		        
		    }
		});
	}
	
}
