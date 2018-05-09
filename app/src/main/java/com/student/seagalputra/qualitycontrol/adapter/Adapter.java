package com.student.seagalputra.qualitycontrol.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.student.seagalputra.qualitycontrol.R;
import com.student.seagalputra.qualitycontrol.getset.QualityControl;

import java.util.List;

/**
 * Created by seagalputra on 5/8/18.
 */

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<QualityControl> items;

    public Adapter(Activity activity, List<QualityControl> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
        }

        TextView id = (TextView) convertView.findViewById(R.id.idCek);
        TextView idProduk = (TextView) convertView.findViewById(R.id.idProduk);
        TextView tglQc = (TextView) convertView.findViewById(R.id.tglQc);

        QualityControl data = items.get(position);

        id.setText(data.getIdCek());
        idProduk.setText(data.getIdProduk());
        tglQc.setText(data.getTglQc());

        return convertView;
    }
}
