package com.example.expensetrackingapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensetrackingapplication.databinding.FragmentAddExpenseBinding;
import com.example.expensetrackingapplication.databinding.FragmentPickCategoryBinding;

import java.util.ArrayList;

public class PickCategoryFragment extends Fragment {
    FragmentPickCategoryBinding binding;
    ArrayList<String> catogories = DataServices.getCategories();
    ArrayAdapter arrayAdapter;
    ListView listView;
    TextView textView;

    public PickCategoryFragment() {
        // Required empty public constructor
    }

    public static PickCategoryFragment newInstance(String param1, String param2) {
        PickCategoryFragment fragment = new PickCategoryFragment();
        Bundle args = new Bundle();
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
        binding = FragmentPickCategoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, catogories);
        binding.pickCatListView.setAdapter(arrayAdapter);
        binding.pickCatListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = arrayAdapter.getItem(position).toString();
                pickCatogoryListener.goToAddExp(item);

            }
        });
    }

    PickCatogoryListener pickCatogoryListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pickCatogoryListener = (PickCatogoryListener) context;
    }

    interface PickCatogoryListener{
        void goToAddExp(String selectCat);
    }

}