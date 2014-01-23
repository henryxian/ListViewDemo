package com.henryxian.listviewdemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] data = new String[0];
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1, data);
		final ListView listview = (ListView)findViewById(R.id.myList);
		listview.setAdapter(adapter);
		listview.setFastScrollEnabled(true);
		listview.setOverScrollMode(AbsListView.OVER_SCROLL_IF_CONTENT_SCROLLS);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						((TextView)view).getText(), 
						Toast.LENGTH_LONG).show();
			}
			
		});
		listview.setTextFilterEnabled(true);
		Drawable d = new GradientDrawable(
				GradientDrawable.Orientation.BOTTOM_TOP,
				new int[]{0xff00, 0x008888, 0x0000ff}
				);
		listview.setOverscrollHeader(d);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
