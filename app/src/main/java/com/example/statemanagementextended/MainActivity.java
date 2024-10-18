package com.example.statemanagementextended;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.widget.CompoundButton;
import android.widget.CheckBox;
public class MainActivity extends AppCompatActivity {
    private CountViewModel countViewModel; // Deklaracja ViewModel
    private TextView textViewCount; // Element widoku do wyświetlania liczby

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount); // Inicjalizacja TextView
        Button buttonIncrement = findViewById(R.id.buttonIncrement); // Inicjalizacja Button

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
    }
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }

    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getCount()); // Ustaw tekst TextView na aktualną wartość licznika
    }
}
