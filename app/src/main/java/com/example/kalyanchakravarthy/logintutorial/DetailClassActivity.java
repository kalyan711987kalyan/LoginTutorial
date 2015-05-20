package com.example.kalyanchakravarthy.logintutorial;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.StringTokenizer;

/**
 * Created by kalyanchakravarthy on 13/05/15.
 */


public class DetailClassActivity extends Activity {

    ListView listView ;

    @Override
protected void onCreate(Bundle savedInstanceState){

    super.onCreate(savedInstanceState);
    setContentView(R.layout.details);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listView);

        (new GetListTask()).execute((Object)null);
        // Defined Array values to show in ListView
//     String[] values= new String[]{ "one","Two","3","4","Five"};
//
//
//
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//
//
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }



    private  class GetListTask extends AsyncTask{


        /**
         * Let's make the http request and return the result as a String.
         */
        protected String doInBackground(Object... args) {
            return ServerClass.getAnimalList();
        }



        /**
              * Parse the String result, and create a new array adapter for the list
              * view.
              */
        protected void onPostExecute(Object objResult) {
            // check to make sure we're dealing with a string
            if (objResult != null && objResult instanceof String) {

                String result = (String) objResult;
                // this is used to hold the string array, after tokenizing
                String[] responseList;

                // we'll use a string tokenizer, with "," (comma) as the delimiter
                StringTokenizer tk = new StringTokenizer(result, ",");

                // now we know how long the string array is
                responseList = new String[tk.countTokens()];

                // let's build the string array
                int i = 0;
                while (tk.hasMoreTokens()) {
                    responseList[i++] = tk.nextToken();

                }

                // now we'll supply the data structure needed by this ListActivity
               // ArrayAdapter<String> newAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, responseList);

               // ArrayAdapter<String> adapter = new ArrayAdapter<String>(DetailClassActivity.this,
                //android.R.layout.simple_list_item_1, android.R.id.text1, responseList);               // listView.setAdapter(newAdapter);
                ArrayAdapter<String> newAdapter = new ArrayAdapter<String>(DetailClassActivity.this, android.R.layout.simple_list_item_1, responseList);
                listView.setAdapter(newAdapter);
            }
        }
    }

    public void finishActivity(View v){

        finish();
    }
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
