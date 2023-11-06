package com.rudy.java_android_selected_and_selectall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuantityRVAdapter extends RecyclerView.Adapter<QuantityRVAdapter.ViewHolder> {
    Context context;
    ArrayList<String> arrayList;
    ArrayList<String> arrayList_for_check = new ArrayList<>();
    IQuantityRVAdapter listener;

    public QuantityRVAdapter(Context _context, ArrayList<String> _arrayList, IQuantityRVAdapter _listener) {
        this.context = _context;
        this.arrayList = _arrayList;
        this.listener = _listener;
    }

    @NonNull
    @Override
    public QuantityRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuantityRVAdapter.ViewHolder holder, int position) {
        if(arrayList !=null && arrayList.size() > 0){
            holder.check_box.setText(arrayList.get(position));
            holder.check_box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(holder.check_box.isChecked()){
                        arrayList_for_check.add(arrayList.get(position));
                    }else{
                        arrayList_for_check.remove(arrayList.get(position));
                    }
                    listener.onQuantityChange(arrayList_for_check);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox check_box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            check_box = itemView.findViewById(R.id.check_box);
        }
    }

    public interface  IQuantityRVAdapter{
        void onQuantityChange(ArrayList<String> arrayList);
    }
}
