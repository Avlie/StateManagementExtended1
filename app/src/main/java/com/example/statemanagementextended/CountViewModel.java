package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {

    private int count = 0; // Zmienna do przechowywania wartości licznika
    private boolean switchChecked;
    private boolean checkBoxChecked;

    public int getCount() {

        return count; // Zwróć aktualną wartość licznika

    }

    public void incrementCount() {

        count++; // Zwiększ wartość licznika

    }

    public void setSwitchChecked(boolean isChecked) {
        this.switchChecked = isChecked;
    }

    public void setCheckBoxChecked(boolean isChecked) {
        this.checkBoxChecked = isChecked;
    }
}