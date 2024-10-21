package com.example.statemanagementextended;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatDelegate;
import android.widget.Switch;


@SuppressLint("UseSwitchCompatOrMaterialCode")
public class MainActivity extends AppCompatActivity {
    private CountViewModel countViewModel;
    private TextView textViewCount;
    private TextView textViewOptionChecked;
    private CheckBox checkBox;
    private Switch switchTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount);
        checkBox = findViewById(R.id.checkBox);
        switchTheme = findViewById(R.id.switch1);// Inicjalizacja TextView
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        textViewOptionChecked = findViewById(R.id.textViewOptionChecked);// Inicjalizacja Button

        // Utworzenie lub pobranie instancji CountViewModel
        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText(); // Aktualizuj widok TextView

        // Ustawienie akcji kliknięcia przycisku
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countViewModel.incrementCount(); // Zwiększ wartość licznika w ViewModel
                updateCountText(); // Aktualizuj widok TextView
            }
        });
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textViewOptionChecked.setVisibility(View.VISIBLE);
            } else {
                textViewOptionChecked.setVisibility(View.GONE);
            }
        });
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textViewOptionChecked.setVisibility(View.VISIBLE);
            } else {
                textViewOptionChecked.setVisibility(View.GONE);
            }
            countViewModel.setCheckBoxChecked(isChecked);
        });


        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }



    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getCount()); // Ustaw tekst TextView na aktualną wartość licznika
    }

    public void setTextViewOptionChecked(TextView textViewOptionChecked) {
        this.textViewOptionChecked = textViewOptionChecked;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public void setSwitchTheme(Switch switchTheme) {
        this.switchTheme = switchTheme;
    }
}
