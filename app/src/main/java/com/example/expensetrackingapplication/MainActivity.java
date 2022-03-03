package com.example.expensetrackingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.expensetrackingapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Expense> expenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> catogory = DataServices.getCategories();

        expenses = new ArrayList<>();
        expenses.add(new Expense("McDonalds", 11.25, "02/03/2022", catogory.get(0)));
        expenses.add(new Expense("McDonalds", 11.25, "02/03/2022", catogory.get(1)));
        expenses.add(new Expense("McDonalds", 11.25, "02/03/2022", catogory.get(2)));


        getSupportFragmentManager().beginTransaction()
                .add(R.id.cv, ExpensesFragment.newInstance(expenses))
                .addToBackStack(null)
                .commit();

    }



}