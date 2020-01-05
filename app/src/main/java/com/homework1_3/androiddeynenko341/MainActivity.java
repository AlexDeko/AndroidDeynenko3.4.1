package com.homework1_3.androiddeynenko341;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Style.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinnerStyle = findViewById(R.id.spinnerStyle);

        final ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterLanguages);
        final ArrayAdapter<CharSequence> adapterStyle = ArrayAdapter.createFromResource(this,
                R.array.style, android.R.layout.simple_spinner_item);
        adapterStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStyle.setAdapter(adapterStyle);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int language,
                                       long languages) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerStyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int style,
                                       long styles) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                String itemStile = spinnerStyle.getSelectedItem().toString();
                Locale locale;
                Configuration config = new Configuration();
                switch (item){
                    case "Русский":
                        locale = new Locale("ru");
                        config.setLocale(locale);
                        getResources().updateConfiguration(config,
                                getBaseContext().getResources().getDisplayMetrics());
                        break;
                    case "English":
                        locale = new Locale("en");
                        config.setLocale(locale);
                        getResources().updateConfiguration(config,
                                getBaseContext().getResources().getDisplayMetrics());
                        break;
                }
                switch (itemStile){
                    case "Зелёный":
                        Style.changeToTheme(MainActivity.this, Style.THEME_GREEN);
                        break;
                    case "Чёрный":
                        Style.changeToTheme(MainActivity.this, Style.THEME_BLACK);
                        break;
                    case "Синий":
                        Style.changeToTheme(MainActivity.this, Style.THEME_BLUE);
                        break;
                }
                recreate();
            }
        });
    }
}
