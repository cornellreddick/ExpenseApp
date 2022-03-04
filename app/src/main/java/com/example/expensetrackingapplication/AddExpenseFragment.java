package com.example.expensetrackingapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensetrackingapplication.databinding.FragmentAddExpenseBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class AddExpenseFragment extends Fragment{
    FragmentAddExpenseBinding binding;
    EditText expName, expAmount;
    TextView expDateTV, expCatTV, tv5;
    DatePickerDialog datePickerDialog;
    ArrayList<Expense> expenses;
    Button pickCatogoryBtn, cancelBtn, submitBtn;
    String pickCat;
    String pickDate;
    ArrayAdapter  arrayAdapter;
    ExpenseAdapter expenseAdapter;

    int year;
    int month;
    int day;

   void getSelectCat(String cat){
        pickCat = cat;
    }
    private static final String ARG_PARAM1 = "param1";
    private String pickCategory;

    public static AddExpenseFragment newInstance(String pickCat ) {
        AddExpenseFragment fragment = new AddExpenseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, pickCat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pickCat = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddExpenseBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (pickCat != null) {
            expCatTV = binding.addCatTextViewResults;
            expCatTV.setText(pickCat);
        }

        expName = binding.editTextExpName;
        expAmount = binding.editTextExpAmt;
        expDateTV = binding.addDateTextViewResults;
        expCatTV = binding.addCatTextViewResults;

        binding.setExpDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                year = calendar.get(Calendar.YEAR);
                DatePickerDialog dp = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                expDateTV.setText(month +1 + "/" + day + "/" + year);
                            }
                        },
                        2022,
                        2,
                        1);
                dp.show();
            }
        });
        binding.addExpSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (expDateTV.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Please select date!!", Toast.LENGTH_SHORT).show();
                } else if (expName.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please select Task name!!", Toast.LENGTH_SHORT).show();
                }else if (expAmount.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please select Task name!!", Toast.LENGTH_SHORT).show();
                }else{
                   if (!expDateTV.getText().toString().equals("") && !expName.getText().toString().matches("") && !expAmount.getText().toString().matches("")){
                       pickCatogoryBtn.setEnabled(true);
                   }

                    String date = expDateTV.getText().toString();
                    String cat = expCatTV.getText().toString();
                    String name = expName.getText().toString();

                    String amount = expAmount.getText().toString();
                    double amt = Double.parseDouble(amount);

                    addExpenseFragmentListener.goToExpenseFragment(name, amt, date, cat);
                    //expenses.add(new Expense(name, amt, date, cat));
                }
            }
        });

        pickCatogoryBtn = binding.pickExpCatBtn;
        pickCatogoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addExpenseFragmentListener.goToPickCat();
            }
        });
    }
    AddExpenseFragmentListener addExpenseFragmentListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        addExpenseFragmentListener = (AddExpenseFragmentListener) context;
    }
    interface AddExpenseFragmentListener{
        void goToExpenseFragment(String name, double amount, String date, String category);
        void  goToPickCat();
    }

//    @Override
//    public void addToList(String name, double amount, String date, String category) {
//        expenses.add(new Expense(name, amount, date, category));
//        expenseAdapter.notifyDataSetChanged();
//    }


}