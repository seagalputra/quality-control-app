package com.student.seagalputra.qualitycontrol;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.student.seagalputra.qualitycontrol.adapter.Adapter;
import com.student.seagalputra.qualitycontrol.getset.QualityControl;
import com.student.seagalputra.qualitycontrol.url.Server;
import com.student.seagalputra.qualitycontrol.volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by seagalputra on 5/8/18.
 */

public class QualityControlActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    Toolbar toolbar;
    FloatingActionButton fab;
    ListView list;
    SwipeRefreshLayout swipe;
    List<QualityControl> itemList = new ArrayList<QualityControl>();
    Adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txIdCek, txIdProduk, txIdPemesanan, txTglQc, txStatusQc, txJumBarang, txKondisiWarna, txKondisiSole;
    String idCek, idProduk, idPemesanan, tglQc, statusQc, jumBarang, kondisiWarna, kondisiSole;

    private static final String TAG = QualityControlActivity.class.getSimpleName();

    private static String url_read = Server.URL + "read.php";
    private static String url_create = Server.URL + "create.php";
    private static String url_edit = Server.URL + "edit.php";
    private static String url_update = Server.URL + "update.php";
    private static String url_delete = Server.URL + "delete.php";

    public static final String TAG_ID = "id_cek";
    public static final String TAG_ID_PRODUK = "id_produk";
    public static final String TAG_ID_PEMESANAN = "id_pemesanan";
    public static final String TAG_TANGGAL_QC = "tanggal_qc";
    public static final String TAG_STATUS_QC = "status_qc";
    public static final String TAG_JML_BARANG = "jml_barang";
    public static final String TAG_KONDISI_WARNA = "kondisi_warna";
    public static final String TAG_KONDISI_SOLE = "kondisi_sole";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab_add);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = (ListView) findViewById(R.id.list);

        adapter = new Adapter(QualityControlActivity.this, itemList);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener(this);
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
                itemList.clear();
                adapter.notifyDataSetChanged();
                koneksi();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogForm("", "", "", "", "", "", "", "", "SIMPAN");
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getIdCek();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(QualityControlActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                edit(idx);
                                break;
                            case 1:
                                delete(idx);
                                break;
                        }
                    }
                }).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        koneksi();
    }

    private void kosong() {
        txIdCek.setText(null);
        txIdProduk.setText(null);
        txTglQc.setText(null);
    }

    private void DialogForm(String idx, String idProduks, String idPemesanans, String tglQcs, String statusQcs, String jumlahBarangs, String kondisiWarnas, String kondisiSoles, String button) {
        dialog = new AlertDialog.Builder(QualityControlActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.quality_control, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Quality Control");

        txIdCek = (EditText) dialogView.findViewById(R.id.id_cek);
        txIdProduk = (EditText) dialogView.findViewById(R.id.id_produk);
        txIdPemesanan = (EditText) dialogView.findViewById(R.id.id_pemesanan);
        txTglQc = (EditText) dialogView.findViewById(R.id.tgl_qc);
        txStatusQc = (EditText) dialogView.findViewById(R.id.status_qc);
        txJumBarang = (EditText) dialogView.findViewById(R.id.jumlah_barang);
        txKondisiWarna = (EditText) dialogView.findViewById(R.id.kondisi_warna);
        txKondisiSole = (EditText) dialogView.findViewById(R.id.kondisi_sol);

        if (!idx.isEmpty()) {
            txIdCek.setText(idx);
            txIdProduk.setText(idProduks);
            txIdPemesanan.setText(idPemesanans);
            txTglQc.setText(tglQcs);
            txStatusQc.setText(statusQcs);
            txJumBarang.setText(jumlahBarangs);
            txKondisiWarna.setText(kondisiWarnas);
            txKondisiSole.setText(kondisiSoles);
        } else {
            kosong();
        }

        dialog.setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                idCek = txIdCek.getText().toString();
                idProduk = txIdProduk.getText().toString();
                idPemesanan = txIdPemesanan.getText().toString();
                tglQc = txTglQc.getText().toString();
                statusQc = txStatusQc.getText().toString();
                jumBarang = txJumBarang.getText().toString();
                kondisiWarna = txKondisiWarna.getText().toString();
                kondisiSole = txKondisiSole.getText().toString();

                simpan_update();
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                kosong();
            }
        });

        dialog.show();
    }

    private void koneksi() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        JsonArrayRequest jArr = new JsonArrayRequest(url_read, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        QualityControl item = new QualityControl();

                        item.setIdCek(obj.getString(TAG_ID));
                        item.setIdProduk(obj.getString(TAG_ID_PRODUK));

                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        AppController.getInstance().addToRequestQueue(jArr);
    }

    private void simpan_update() {
        String url;

        if (idCek.isEmpty()) {
            url = url_create;
        } else {
            url = url_update;
        }

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        Log.d("Add/update", jObj.toString());

                        koneksi();
                        kosong();

                        Toast.makeText(QualityControlActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                        adapter.notifyDataSetChanged();

                    } else {
                        Toast.makeText(QualityControlActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(QualityControlActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                if (idCek.isEmpty()) {
                    params.put("id_produk", idProduk);
                    params.put("id_pemesanan", idPemesanan);
                    params.put("tanggal_qc", tglQc);
                    params.put("status_qc", statusQc);
                    params.put("jml_barang", jumBarang);
                    params.put("kondisi_warna", kondisiWarna);
                    params.put("kondisi_sole", kondisiSole);
                } else {
                    params.put("id_cek", idCek);
                    params.put("id_produk", idProduk);
                    params.put("id_pemesanan", idPemesanan);
                    params.put("tanggal_qc", tglQc);
                    params.put("status_qc", statusQc);
                    params.put("jml_barang", jumBarang);
                    params.put("kondisi_warna", kondisiWarna);
                    params.put("kondisi_sole", kondisiSole);
                }

                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void edit(final String idx) {
        StringRequest strReq = new StringRequest(Request.Method.POST, url_edit, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        Log.d("get edit data", jObj.toString());
                        String idx = jObj.getString(TAG_ID);
                        String idProdukx = jObj.getString(TAG_ID_PRODUK);
                        String idPemesananx = jObj.getString(TAG_ID_PEMESANAN);
                        String tglQcx = jObj.getString(TAG_TANGGAL_QC);
                        String statusQcx = jObj.getString(TAG_STATUS_QC);
                        String jmlBarangx = jObj.getString(TAG_JML_BARANG);
                        String kondisiWarnax = jObj.getString(TAG_KONDISI_WARNA);
                        String kondisiSolex = jObj.getString(TAG_KONDISI_SOLE);

                        DialogForm(idx, idProdukx, idPemesananx, tglQcx, statusQcx, jmlBarangx, kondisiWarnax, kondisiSolex, "UBAH");

                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(QualityControlActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(QualityControlActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_cek", idx);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void delete(final String idx) {
        StringRequest strReq = new StringRequest(Request.Method.POST, url_delete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        Log.d("delete", jObj.toString());

                        koneksi();

                        Toast.makeText(QualityControlActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(QualityControlActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(QualityControlActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_cek", idx);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
}
