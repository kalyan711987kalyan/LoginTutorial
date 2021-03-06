package com.example.kalyanchakravarthy.logintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button loginbtn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn=(Button)findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(ButtonAction);

    }

    View.OnClickListener ButtonAction= new View.OnClickListener() {
@Override
        public void onClick(View v) {

            Button btn=(Button)v;
            ((Button) v).setText("My Button");


    Intent intent=new Intent(LoginActivity.this, DetailClassActivity.class);
    startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
