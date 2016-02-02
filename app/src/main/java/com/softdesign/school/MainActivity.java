package com.softdesign.school;


import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";
    public static final String TOOLBAR_COLOR = "toolbar";
    public static final String STATUSBAR_COLOR = "statusbar";

    int mStatusBarColor;
    int mToolBarColor;

    CheckBox mCheckBox;
    EditText mEditText2;
    Toolbar mToolbar;
    Button mBlueButton;
    Button mGreenButton;
    Button mRedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.e(this.getLocalClassName(), "on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("School lesson 1");

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText2 = (EditText) findViewById(R.id.editText2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mBlueButton = (Button) findViewById(R.id.btn_blue);
        mBlueButton.setOnClickListener(this);
        mGreenButton = (Button) findViewById(R.id.btn_green);
        mGreenButton.setOnClickListener(this);
        mRedButton = (Button) findViewById(R.id.btn_red);
        mRedButton.setOnClickListener(this);

        setupToolbar();

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Menu click", Toast.LENGTH_SHORT).show();
        }
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.checkBox:
                Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()){
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                    mEditText2.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.btn_blue:
                mStatusBarColor = getResources().getColor(R.color.color_blue_dark);
                mToolBarColor = getResources().getColor(R.color.color_blue);
                setColor(mStatusBarColor, mToolBarColor);
                break;

            case R.id.btn_green:
                mStatusBarColor = getResources().getColor(R.color.color_green_dark);
                mToolBarColor = getResources().getColor(R.color.color_green);
                setColor(mStatusBarColor, mToolBarColor);
                break;

            case R.id.btn_red:
                mStatusBarColor = getResources().getColor(R.color.color_red_dark);
                mToolBarColor = getResources().getColor(R.color.color_red);
                setColor(mStatusBarColor, mToolBarColor);
                break;
        }
    }

    private void setColor(int colorStatusBar, int colorToolBar){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(colorStatusBar);
        }
        mToolbar.setBackgroundColor(colorToolBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "on save instance state");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
        outState.putInt(TOOLBAR_COLOR, mToolBarColor);
        outState.putInt(STATUSBAR_COLOR, mStatusBarColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on restore instance state");
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mToolBarColor = savedInstanceState.getInt(TOOLBAR_COLOR);
        mStatusBarColor = savedInstanceState.getInt(STATUSBAR_COLOR);
        setColor(mToolBarColor, mStatusBarColor);

        mEditText2.setVisibility(visibleState);
    }
}

