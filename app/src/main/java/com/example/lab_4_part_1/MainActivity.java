package com.example.lab_4_part_1;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    // Инициализация объекта класса Cat
    Cat murzik = new Cat("Мурзик", 9, Color.YELLOW);

    // Инициализация объектов
//    GsonBuilder builder = new GsonBuilder();
//    Gson gson = builder.create();
    Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    Получение элемента по id
        TextView text_from_json = (TextView) findViewById(R.id.text_from_json);
        TextView tv_color = (TextView) findViewById(R.id.tv_color);

        // Из объекта в строку json
        String jsonMurzik = gson.toJson(murzik);
        // Из json в объект класса Cat
        Cat objectMurzik = gson.fromJson(jsonMurzik, Cat.class);

        String textMurzik = String.format("Имя - %s, возраст - %d.",
                objectMurzik.name,
                objectMurzik.age
        );

        text_from_json.setText(textMurzik);
        // Цвет блока
        tv_color.setBackgroundColor(objectMurzik.color);

    }
}