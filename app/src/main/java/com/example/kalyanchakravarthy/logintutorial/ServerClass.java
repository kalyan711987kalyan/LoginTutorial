package com.example.kalyanchakravarthy.logintutorial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by kalyanchakravarthy on 20/05/15.
 */
public class ServerClass {

    public static final String SERVER_URL = "http://www.hassanpur.com/AndroidListServer/server.php";


    private static String executeHttpRequest(String data){

        String result="";

        try {

            URL url= new URL (SERVER_URL);

            URLConnection connection = url.openConnection();

            //setting properties
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Send the POST data
            DataOutputStream dataOut = new DataOutputStream(connection.getOutputStream());
            dataOut.writeBytes(data);
            dataOut.flush();
            dataOut.close();

            // get the response from the server and store it in result
            DataInputStream dataIn = new DataInputStream(connection.getInputStream());
            String inputLine;
            while ((inputLine = dataIn.readLine()) != null) {
                result += inputLine;
            }
            dataIn.close();


        }catch (IOException e){

            e.printStackTrace();
            result=null;
        }
        return result;

    }

    public static String getAnimalList(){

        String data="command=" + URLEncoder.encode("getAnimalList");

        return executeHttpRequest(data);

    }
}
