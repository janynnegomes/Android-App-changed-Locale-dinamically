package com.example.shiftlocale;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	SharedPreferences prefs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		prefs = PreferenceManager
	            .getDefaultSharedPreferences(getApplicationContext());	
		
		
		String[] localeString = prefs.getString("pref_locale", "pt_br").split("_");
	     
	    Locale locale = new Locale(localeString[0].toLowerCase(),localeString[1].toUpperCase());
        Locale.setDefault(locale);
        
        Configuration config = new Configuration();
        config.locale = locale;
        
        getBaseContext().getResources().updateConfiguration(config,getResources().getDisplayMetrics());
		
        setContentView(R.layout.activity_main);
	
		Button btnCallSecondActivity = (Button) this.findViewById(R.id.btnCallSecondActivity);
		 
		btnCallSecondActivity.setOnClickListener(  new OnClickListener(){

			@Override
		    public void onClick(View v) {
		    		         
	        // Restart
				Intent intent = new Intent(getBaseContext() ,SecondActivity.class);
			    finish();
			    startActivity(intent);
		         
	         
		    }});
		
	
	}
	
	
}
