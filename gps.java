package com.unpam.gps; 
 
import android.app.Activity; 
import android.content.Context; 
import android.location.Location; 
import android.location.LocationListener; 
import android.location.LocationManager; 
import android.os.Bundle; 
import android.view.Menu; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.EditText; 
import android.widget.Toast; 
 
public class MainActivity extends Activity implements 
OnClickListener{ 
  LocationManager locationManager; 
  EditText longitudeEditText, latitudeEditText; 
 
  @Override
  protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_main); 
     
    longitudeEditText = (EditText) 
findViewById(R.id.longitudeEditText); 
    latitudeEditText = (EditText) 
findViewById(R.id.latitudeEditText); 
 
 
  findViewById(R.id.startButton).setOnClickListener(this); 
    findViewById(R.id.stopButton).setOnClickListener(this); 
    locationManager = (LocationManager) 
getSystemService(Context.LOCATION_SERVICE); 
  } 
 
  @Override 
  public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.activity_main, menu); 
    return true; 
  } 
   
  LocationListener locationListener = new LocationListener() { 
    @Override 
    public void onStatusChanged(String provider, int 
status, Bundle extras) {} 
    @Override 
    public void onProviderEnabled(String provider) {} 
    @Override 
    public void onProviderDisabled(String provider) {} 
    @Override 
    public void onLocationChanged(Location location) { 
      // Menampilkan koordinat berdasarkan location 
   
  latitudeEditText.setText(Double.toString(location.getLatitude
())); 
   
  longitudeEditText.setText(Double.toString(location.getLongitu
de())); 
      Toast.makeText(MainActivity.this, "Dapat lokasi", 
Toast.LENGTH_SHORT).show(); 
    } 
  }; 
   
  protected void onPause() { 
    locationManager.removeUpdates(locationListener); 
    super.onPause(); 
  }; 
 
  @Override 
  public void onClick(View v) { 
    // TODO Auto-generated method stub 
    switch (v.getId()) { 
    case R.id.startButton:
	locationManager.requestLocationUpdates(LocationManager.NETWOR
K_PROVIDER, 60000, 0, locationListener); 
      break; 
    case R.id.stopButton: 
      locationManager.removeUpdates(locationListener); 
      break; 
    } 
  } 
 }
 
 Di dalam AndroidManifest.xml, di bawah tag uses-sdk tambahkan script: 
 
	<uses-permission android:name="android.permission.INTERNET" /> 
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" /> 
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
	
dalam application

 <uses-library android:name="com.google.android.maps" /> 