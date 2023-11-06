package com.rudy.java_android_selected_and_selectall;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rudy.java_android_selected_and_selectall.model.QuantityModel;

import java.util.ArrayList;

public class QuantityRVAdapter extends RecyclerView.Adapter<QuantityRVAdapter.ViewHolder> {
    Context context;
    ArrayList<QuantityModel> arrayList;
    ArrayList<QuantityModel> arrayList_for_check = new ArrayList<>();
    IQuantityRVAdapter listener;

    boolean isCheckAll = false;


    public QuantityRVAdapter(Context _context, ArrayList<QuantityModel> _arrayList, IQuantityRVAdapter _listener) {
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
            holder.check_box.setText(arrayList.get(position).getData());
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

            //mark color
            QuantityModel dataCheck = arrayList.get(position);
            if(arrayList_for_check.contains(dataCheck)){
                holder.check_box.setChecked(true);
            }else{
                holder.check_box.setChecked(false);
            }

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setSelectedAll(){
        Log.d("ART_TTT",arrayList.toString());
        this.arrayList_for_check.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void removeAll(){
        this.arrayList_for_check.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox check_box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            check_box = itemView.findViewById(R.id.check_box);
        }
    }

    public interface  IQuantityRVAdapter{
        void onQuantityChange(ArrayList<QuantityModel> arrayList);
    }
}
