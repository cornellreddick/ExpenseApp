package com.example.expensetrackingapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.expensetrackingapplication.databinding.FragmentAddExpenseBinding;
import com.example.expensetrackingapplication.databinding.FragmentExpensesSummaryBinding;

import java.util.ArrayList;
import java.util.HashSet;

public class ExpensesSummaryFragment extends Fragment {
    FragmentExpensesSummaryBinding binding;
    ExpenseSummaryAdapter expenseSummaryAdapter;
    ArrayList<Expense> expenses = new ArrayList<>();
    ArrayList<String> catogory = DataServices.getCategories();

    private static final String ARG_PARAM1 = "expense";

    public static ExpensesSummaryFragment newInstance(ArrayList<Expense> expenses) {
        ExpensesSummaryFragment fragment = new ExpensesSummaryFragment();
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
        binding = FragmentExpensesSummaryBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expenses = (ArrayList<Expense>) getArguments().getSerializable(ARG_PARAM1);
        expenseSummaryAdapter = new ExpenseSummaryAdapter(getActivity(), R.layout.expense_summary_list, expenses);
        binding.expSumListView.setAdapter(expenseSummaryAdapter);

    }
    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Expenses Summary");
    }
}