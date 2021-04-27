package org.techtown.graph;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddEntryAdapter extends RecyclerView.Adapter<AddEntryAdapter.ViewHolder> {

    ArrayList<AddEntry> items = new ArrayList<AddEntry>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText productNameEditText;
        EditText priceEditText;
        Spinner categorySpinner;

        public ViewHolder(View itemView) {
            super(itemView);

            productNameEditText = itemView.findViewById(R.id.productNameEditText);
            priceEditText = itemView.findViewById(R.id.priceEditText);
            categorySpinner = itemView.findViewById(R.id.categorySpinner);
        }

        public void setItem(AddEntry item) {
            productNameEditText.setText(item.getProductName());
            priceEditText.setText(item.getPrice());


            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(,android.R.layout.simple_spinner_item, item.getCategories());
            //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            Resources res = Resources.getSystem();
            String[] temp = res.getStringArray(R.array.switch_cc);
            //String[] array = getResources().getStringArray(R.array.switch_cc);



            //categorySpinner.setAdapter(adapter);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.hand_add_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        AddEntry item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void addItem(AddEntry item) {
        items.add(item);
    }

    public void setItems(ArrayList<AddEntry> items){
        this.items = items;
    }

    public AddEntry getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, AddEntry item) {
        items.set(position,item);
    }
}


































