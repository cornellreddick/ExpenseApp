package com.example.expensetrackingapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    ArrayList<Expense> expenses;
    int pos;
    public ExpenseAdapter(ArrayList<Expense> data){
        this.expenses = data;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_lists_layout, parent, false);
        ExpenseViewHolder viewHolder = new ExpenseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.textViewExpenName.setText(expense.expenseName);
        holder.textViewExpenseAmount.setText(String.valueOf("$" + expense.expenseAmount));
        holder.textViewExpenseDate.setText(expense.expenseDate);
        holder.textViewExpenseCat.setText(expense.expenseCatogory);
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expenses.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), expenses.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.expenses.size();
    }

   public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView textViewExpenName, textViewExpenseAmount, textViewExpenseDate, textViewExpenseCat, numRecordTextViewResults;
        ImageView deleteImageView;
        int pos;
       public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            deleteImageView = itemView.findViewById(R.id.imageViewDelete);
            textViewExpenName = itemView.findViewById(R.id.textViewExpenName);
            textViewExpenseAmount = itemView.findViewById(R.id.textViewExpenseAmount);
            textViewExpenseDate = itemView.findViewById(R.id.textViewExpenseDate);
            textViewExpenseCat = itemView.findViewById(R.id.textViewExpenseCat);

            deleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}