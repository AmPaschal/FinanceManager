package com.ampaschal.financemanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.ampaschal.financemanager.database.FinanceDatabase;
import com.ampaschal.financemanager.database.FinanceEntity;

import java.util.Calendar;

public class FinanceActivity extends AppCompatActivity {

    private EditText etDate, etPurpose, etAmount;
    private Spinner spCategory;
    private Button btSave;
    private Calendar calendar;
    private int year, month, day;
    private long dateInMillis;

    private FinanceDatabase financeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        etDate = findViewById(R.id.et_date);
        etPurpose = findViewById(R.id.et_purpose);
        etAmount = findViewById(R.id.et_amount);
        spCategory = findViewById(R.id.sp_category);
        btSave =findViewById(R.id.bt_save);

        financeDatabase = FinanceDatabase.getInstance(FinanceActivity.this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(100);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = etDate.getText().toString().trim();
                String purpose = etPurpose.getText().toString().trim();
                String amount = etAmount.getText().toString().trim();
                double amountDouble = Double.parseDouble(amount);
                String category = spCategory.getSelectedItem().toString();

                FinanceEntity financeEntity = new FinanceEntity(
                        dateInMillis, date, category, purpose, amountDouble);

                financeDatabase.getFinanceDao().addFinance(financeEntity);

                finish();




            }
        });
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 100){
            return new DatePickerDialog(this, dateSetListener, year, month, day);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            Calendar newCalendar = Calendar.getInstance();
            newCalendar.set(Calendar.YEAR, year);
            newCalendar.set(Calendar.MONTH, month);
            newCalendar.set(Calendar.DAY_OF_MONTH, day);
            dateInMillis = newCalendar.getTimeInMillis();
            month++;
            String date = day +"/" + month + "/" + year;
            etDate.setText(date);



        }
    };




}
