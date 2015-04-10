package com.example.conexaobluetooth;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DeviceRow extends BaseAdapter {
	
	Context context;
	List<Device> deviceList;
	
	public DeviceRow(List<Device> deviceList, Context context) {
		this.context = context;
		this.deviceList = deviceList;
	}

	public int getCount() {
		return deviceList.size();
	}
	
	// importante
	public Object getItem(int position) {
		return deviceList.get(position);
	}

	public long getItemId(int position) {
		return deviceList.size();
	}

	// importante
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Device item = deviceList.get(position);
		
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.device_row, parent, false);
        
        TextView deviceTextView = (TextView) view.findViewById(R.id.deviceTextView);
        TextView macAddressTextView = (TextView) view.findViewById(R.id.macAddressTextView);
        
        deviceTextView.setText(item.getName());
        macAddressTextView.setText(item.getMacAddress());
		
		
		return view;
	}

}
