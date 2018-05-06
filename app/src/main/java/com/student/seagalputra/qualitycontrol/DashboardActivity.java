package com.student.seagalputra.qualitycontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class DashboardActivity extends AppCompatActivity {

    //int[] IMAGES = {R.drawable. }
    String JenisProdukList[] = {"Sepatu", "Tas", "Dompet", "Sandal", "Ikat Pinggang"};
    String MerkProdukList[] = {"Ardio","Firas","Seagal","Anjani","Gerra"};
    String NamaProdukList[] = {"A1","F2","S3","A4","G5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ListView  listView=(ListView)findViewById(R.id.simpleListView)
    }
    //class CustomAdapter extends BaseAdapter{
       // @Override
        //public int getCount(){
        //    return IMAGES.length;
        //}
        //@Override
        //public Object getItem(int i){
        //    return null;
        //}
        //@Override
        //public int getItemId(int i){
        //    return 0;
        //}
        //@Override
        //public View getView(int i, View view, ViewGroup viewGroup){
        //    return null;
        //}
    //}

    private DashboardActivity() {
    }
}
