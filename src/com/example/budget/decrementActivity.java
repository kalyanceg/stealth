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

public class decrementActivity extends Activity{
	static float decramnt=0;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.decrement);
		Button button= (Button) findViewById(R.id.button2);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        EditText tf=(EditText)findViewById(R.id.editText2);
		        String st=tf.getText().toString();
		        if(st==null || st.length()<=0)
		        	Toast.makeText(decrementActivity.this, "Please Enter a value to Decrement", Toast.LENGTH_SHORT).show();
		        else{
		           	  decramnt=Float.parseFloat(st);
		           	 Intent intent = new Intent(decrementActivity.this, categoryActivity.class);
                     startActivity(intent);      
                     finish();
		        }
		        
		    }
		});
	}
	
}
