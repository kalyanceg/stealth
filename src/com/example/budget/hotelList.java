package com.example.budget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class hotelList extends Activity {
	private LocationManager mgr;
	  private String provider;
      double lat,lon;
      	public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.hotelview);
	 final ListView listview = (ListView) findViewById(R.id.listView1);
	 
	 
	 mgr=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

	 ArrayList<String> hotels=new ArrayList<String>(); 
	 try{
		 System.out.println("potato");
		 List<String> providerarr=mgr.getAllProviders();
		 long max=0;
		 int position=0;
		 for(int i=0;i<providerarr.size();i++){
		 Location location=mgr.getLastKnownLocation(providerarr.get(i));
		 if(location!=null){
		     if(max<location.getTime())
		     {
		    	 max=location.getTime();
			 lat=location.getLatitude();
			 lon=location.getLongitude();
		     }
		 }
		 }
		 System.out.println(lat+" "+lon+" "+max);
	 potato pot=new potato("http://www.zomato.com/",2,lat,lon);
	
	 pot.t.join();
	 
	 hotels=pot.hotels;
	 System.out.println(hotels.get(0));
	}
	 catch(Exception e){
		 System.out.println(e);
	 }
	 ArrayAdapter<String> adapter=new ArrayAdapter<String>(hotelList.this, android.R.layout.simple_list_item_1, android.R.id.text1, hotels);
	    
	    
     // Assign adapter to ListView
listview.setAdapter(adapter); 
	 
	}
	

	}
