package com.example.conexaobluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnItemClickListener {
	
	public static final String UUID = "00001101-0000-1000-8000-00805F9B34FB";

	public TextView textLabel;
	public Button buttonResult;
	BluetoothAdapter mBluetoothAdapter;
	ListView listView;
	private List<BluetoothDevice> deviceList = new ArrayList<BluetoothDevice>();
	DeviceRow deviceRowAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonResult = (Button) findViewById(R.id.buttonResult);
        textLabel = (TextView) findViewById(R.id.textLabel);
        listView  = (ListView) findViewById(R.id.listViewBluetooth);
        
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        
        
    }

	protected void onResume() {
    	super.onResume();
    	
    	//listando quem são os dispositivos pareados.
    	Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
    	// If there are paired devices
    	if (pairedDevices.size() > 0) {
    	    // Loop through paired devices
    	    for (BluetoothDevice device : pairedDevices) {
    	        // Add the name and address to an array adapter to show in a ListView
    	    	deviceList.add(device); // crash
    	    	Log.i("FOUND", String.format("Resume Device founded: %s MacAddress %s", device.getName(), device.getAddress()));
    	    }
    	}   
    	
    	
    	List<Device> deviceVector = new ArrayList<Device>();
    	
    	for (int i = 0; i < deviceList.size(); i++)
    		deviceVector.add(new Device(deviceList.get(i).getName(), deviceList.get(i).getAddress()));
    	
    	deviceRowAdapter = new DeviceRow(deviceVector, getApplicationContext());
    	
    	listView.setAdapter(deviceRowAdapter);
    	listView.setOnItemClickListener(this);
    }

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		Toast.makeText(getApplicationContext(), ((Device)listView.getAdapter().getItem(position)).getName(), Toast.LENGTH_SHORT).show(); 
		
	}
    
}














