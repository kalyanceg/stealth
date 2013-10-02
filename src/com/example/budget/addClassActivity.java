package com.example.budget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addClassActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.othercategory);
		Button button= (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	  EditText tf=(EditText)findViewById(R.id.autoCompleteTextView1);
			        String st=tf.getText().toString();
			        if(st==null || st.length()<=0)
			        	Toast.makeText(addClassActivity.this, "Please Enter a Category to Add", Toast.LENGTH_SHORT).show();
			        else{
			            dbUtil dbObj=new dbUtil(addClassActivity.this);
			            dbObj.insertCat(dbObj.getWritableDatabase(), st);
			            Toast.makeText(addClassActivity.this, "Category Added to DB successfully", Toast.LENGTH_SHORT).show();
			            dbObj.decrement(dbObj.getWritableDatabase(),st,decrementActivity.decramnt);
			            decrementActivity.decramnt=0;
			            Toast.makeText(addClassActivity.this, "Amount Reduced from DB successfully", Toast.LENGTH_SHORT).show();
			            Intent intent = new Intent(addClassActivity.this, MainActivity.class);
	                    startActivity(intent);      
	                    finish();  	  
			        }
		    }
		}); 
	}
}
