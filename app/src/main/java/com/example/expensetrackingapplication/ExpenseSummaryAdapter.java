package com.example.expensetrackingapplication;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseSummaryAdapter extends ArrayAdapter<Expense> {
    TextView monthTV, yearTV, amountTV;


    public ExpenseSummaryAdapter(@NonNull Context context, int resource, @NonNull List<Expense> objects) {
        super(context, resource, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.expense_summary_list, parent, false);

            monthTV = convertView.findViewById(R.id.monthTextView);
            yearTV = convertView.findViewById(R.id.yearTextView);
            amountTV = convertView.findViewById(R.id.amountTextView);

        }
        Expense expense = getItem(position);
        String monthNumber = expense.expenseDate.substring(0,2);
        String monthName;
        switch(monthNumber) {
            case "01":
                monthName = "January";
                break;
            case "02":
                monthName = "February";
                break;
            case "03":
                monthName = "March";
                break;
            case "04":
                monthName = "April";
                break;
            case "05":
                monthName = "May";
                break;
            case "06":
                monthName = "June";
                break;
            case "07":
                monthName = "July";
                break;
            case "08":
                monthName = "August";
                break;
            case "09":
                monthName = "September";
                break;
            case "10":
                monthName = "October";
                break;
            case "11":
                monthName = "November";
                break;
            case "12":
                monthName = "December";
                break;
            default:
                monthName = "Invalid month";
                break;
        }


        monthTV.setText(monthName);
        yearTV.setText(expense.expenseDate.substring(6,10));
        amountTV.setText(String.valueOf(expense.expenseAmount));


        return convertView;
    }
}