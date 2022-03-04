package com.example.expensetrackingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.expensetrackingapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExpensesFragment.ExpenseListener, PickCategoryFragment.PickCatogoryListener, AddExpenseFragment.AddExpenseFragmentListener {
    ActivityMainBinding binding;
    ArrayList<Expense> expenses;
    ExpenseAdapter expenseAdapter;
    public static int deletePos;
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

    @Override
    public void goToExpenseFragment(String name, double amount, String date, String category) {
        expenses.add(new Expense(name, amount, date, category));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cv, ExpensesFragment.newInstance(expenses), "expense-fragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToAddExpense() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cv, new AddExpenseFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToPickCat() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cv, new PickCategoryFragment())
                .addToBackStack(null)
                .commit();
    }



    @Override
    public void goToAddExp(String selectCat) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cv, AddExpenseFragment.newInstance(selectCat))
                .addToBackStack(null)
                .commit();
    }
}