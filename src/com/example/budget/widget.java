package com.example.budget;



import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class widget extends AppWidgetProvider {

  private static final String ACTION_CLICK = "ACTION_CLICK";

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager,
      int[] appWidgetIds) {
	  ComponentName thisWidget = new ComponentName(context,
		        widget.class);
  
	  int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
	    for (int widgetId : allWidgetIds) {
	    	RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
	    	          R.layout.widget);
	      // Create some random data
	    	Intent intent = new Intent(context, widget.class);

	        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
	        appWidgetManager.updateAppWidget(widgetId, remoteViews);
	    }
    }
  }
 