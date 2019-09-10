package com.example.practicaandreudecabo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicaandreudecabo.model.Nota;

import java.util.ArrayList;


public class NotaAdapter extends ArrayAdapter<Nota> {

    int layoutResourceId;
    Context context;
    ArrayList<Nota> data;
    public NotaAdapter(Context context, int layoutResourceId, ArrayList<Nota> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        TextView tv_message = (TextView)row.findViewById(R.id.tv_message);
        tv_message.setText(data.get(position).getMessage());

        return row;
    }


}