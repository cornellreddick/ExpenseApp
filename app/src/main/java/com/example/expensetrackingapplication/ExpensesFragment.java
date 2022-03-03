package com.example.expensetrackingapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.expensetrackingapplication.databinding.FragmentExpensesBinding;

import java.util.ArrayList;


public class ExpensesFragment extends Fragment {
    FragmentExpensesBinding binding;
    ExpenseAdapter expenseAdapter;
    ArrayList<Expense> expenses;
    LinearLayoutManager layoutManager;
    RecyclerView recycleView;
    TextView numRecordTextViewResults, totalExpenseTextView;
    protected RecyclerView.LayoutManager mLayoutManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "expense";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ExpensesFragment() {
        // Required empty public constructor
    }


    public static ExpensesFragment newInstance(ArrayList<Expense> expenses) {
        ExpensesFragment fragment = new ExpensesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, expenses);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentExpensesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expenses = (ArrayList<Expense>) getArguments().getSerializable(ARG_PARAM1);



        numRecordTextViewResults = binding.numRecordTextViewResults;
        numRecordTextViewResults.setText(String.valueOf(expenses.size()));

        totalExpenseTextView = binding.totalExpenseTextView;

        //Get Totol Expense Amount
        double sum = 0;
        for (Expense expenses: expenses) {
           sum += expenses.expenseAmount;
        }

        totalExpenseTextView.setText(String.valueOf("$" + sum));

        recycleView = binding.recycleView;
        layoutManager = new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(layoutManager);
        expenseAdapter = new ExpenseAdapter(expenses);
        recycleView.setAdapter(expenseAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Expenses");
    }

//    ExpenseLister expenseLister;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        expenseLister = (ExpenseLister) context;
//    }
//
//    interface ExpenseLister{
//        ArrayList<Expense> getData(ArrayList<Expense> data);
//    }

}