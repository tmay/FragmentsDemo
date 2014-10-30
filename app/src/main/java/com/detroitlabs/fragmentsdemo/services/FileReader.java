package com.detroitlabs.fragmentsdemo.services;

import android.content.Context;
import android.content.res.AssetManager;

import com.detroitlabs.fragmentsdemo.models.Queue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Terry on 10/27/14.
 */
public class FileReader {

    public static Queue getLocalQueueData(Context context) {
        Gson gson = new Gson();
        String json = FileReader.readFileFromAssets(context, "bside_data.json");
        return (Queue) gson.fromJson(json, new TypeToken<Queue>() {}.getType());
    }

    public static String readFileFromAssets(Context context, String filename) {
        String str = "";
        try {
            AssetManager am = context.getAssets();
            InputStream inputStream = am.open(filename);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

                //if there is something in the buffer add it to the builder
                while ((tempString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(tempString);
                }

                inputStream.close();
                str = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
