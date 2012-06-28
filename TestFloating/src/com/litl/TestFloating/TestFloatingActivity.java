package com.litl.TestFloating;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestFloatingActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onClickButton(View button) {
    	Intent intent = new Intent(this, FloatingActivity.class);
    	startActivity(intent);
    }
}