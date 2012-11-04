package com.litl.testpager;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private final static int COUNT = 20;
	ViewPager mViewPager;
	Adapter mAdapter;
	
	private class Page {
		View view;
	}
	
	private class Adapter extends PagerAdapter {
		@Override
		public int getCount() {
			return COUNT;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return ((Page) object).view == view;
		}
		
		@Override
		public Object instantiateItem(View container, int position) {
			Page page = new Page();
			
			TextView view = new TextView(MainActivity.this);
			view.setText("Page " + position);
			view.setTextSize(30);
			view.setBackgroundColor((255 * position) / COUNT);
			
			mViewPager.addView(view, 0);
			page.view = view;
			
			return page;
		}
		
		@Override
		public void destroyItem(View container, int position, Object object) {
			Page page = (Page) object;
			mViewPager.removeView(page.view);
		}
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setPageMargin(10);
		
		mAdapter = new Adapter();
		mViewPager.setAdapter(mAdapter);
	}

}
