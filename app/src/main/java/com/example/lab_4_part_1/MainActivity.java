package com.example.lab_4_part_1;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    // Инициализация объекта класса Cat
    Cat murzik = new Cat("Мурзик", 9, Color.BLACK);

    // Инициализация объектов
//    GsonBuilder builder = new GsonBuilder();
//    Gson gson = builder.create();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String jsonText = "{'name':'Мурзик','color':-16777216,'age':8}";

        // Из объекта в строку json
        String jsonMurzik = gson.toJson(murzik);
        // Из json в объект класса Cat
        Cat objectMurzik = gson.fromJson(jsonMurzik, Cat.class);

        // Вывод json как строки
        Log.i("GSON", jsonMurzik);
        //Вывод объекта, полученного из json
        Log.i("FROM_GSON", String.format("Имя - %s, возраст - %d.",
                objectMurzik.name,
                objectMurzik.age
                ));
    }
}