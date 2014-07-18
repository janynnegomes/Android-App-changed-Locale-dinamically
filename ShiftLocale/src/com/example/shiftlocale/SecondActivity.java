package com.example.shiftlocale;

import java.util.Locale;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_second);

		
		Button btnSetLocale = (Button) this.findViewById(R.id.btnCallSecondActivity);
	 
	
	 btnSetLocale.setOnClickListener( btnLocaleClickListener);
	
	
	 TextView txtGreetings = ((TextView)findViewById(R.id.textView1));
	
		
	}
	
	OnClickListener btnLocaleClickListener =
			   new OnClickListener(){

				@TargetApi(Build.VERSION_CODES.GINGERBREAD)
				@Override
			    public void onClick(View v) {
			    
			     
			     // Set language
			     RadioGroup rgLocale = (RadioGroup) findViewById(R.id.radioGroup1);
			     
				 if(rgLocale.getCheckedRadioButtonId()!=-1){
				    
					View radioButton = rgLocale.findViewById(rgLocale.getCheckedRadioButtonId());
				    
					int radioId = rgLocale.indexOfChild(radioButton);
				    RadioButton btn = (RadioButton) rgLocale.getChildAt(radioId);
				    String localeSelected = (String) btn.getText();			     
			     
		         SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
		         editor.putString("pref_locale", localeSelected);
		         editor.apply();
		         
		         Toast.makeText(getApplicationContext(), 
		        		 Locale.getDefault().getDisplayLanguage().toString(), 
					       Toast.LENGTH_LONG).show();
		         
		         
		         // Restart application
		         
		         Intent i = getBaseContext().getPackageManager()
		                 .getLaunchIntentForPackage( getBaseContext().getPackageName() );
		         i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		         startActivity(i);
		         System.exit(0);
		        	 
				 }
			    }};


}
