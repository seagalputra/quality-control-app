package com.student.seagalputra.qualitycontrol;

public class Server {
    // Script PHP to get MySQL Data
    public static final String URL_LOGIN = "http://172.20.10.5/android_login_api/include/login.php";
    public static final String URL_ADD_PRODUCT = "http://10.20.33.46/android_login_api/include/tambahProduct.php";
    public static final String URL_GET_PRODUCT = "http://10.20.33.46/android_login_api/include/tampilProduct.php";
    public static final String URL_GET_PRODUCT_ALL = "http://10.20.33.46/android_login_api/include/tampilSemuaProduct.php";

    // Key to send request PHP script
    public static final String KEY_PRODUCT_ID = "id_produk";
    public static final String KEY_PRODUCT_NAME = "nama_produk";
    public static final String KEY_PRODUCT_KIND = "jenis_produk";
    public static final String KEY_PRODUCT_BRAND = "merk_produk";
    public static final String KEY_PRODUCT_BUY_PRICE = "harga_beli";
    public static final String KEY_PRODUCT_SELL_PRICE = "harga_jual";
    public static final String KEY_PRODUCT_STATUS = "status_produk";
    public static final String KEY_PRODUCT_TOTAL = "jml_produk";

    // JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_JSON_PRODUCT_ID = "id_produk";
    public static final String TAG_JSON_PRODUCT_NAME = "nama_produk";
    public static final String TAG_JSON_PRODUCT_KIND = "jenis_produk";
    public static final String TAG_JSON_PRODUCT_BRAND = "merk_produk";
    public static final String TAG_JSON_PRODUCT_BUY_PRICE = "harga_beli";
    public static final String TAG_JSON_PRODUCT_SELL_PRICE = "harga_jual";
    public static final String TAG_JSON_PRODUCT_STATUS = "status_produk";
    public static final String TAG_JSON_PRODUCT_TOTAL = "jml_produk";

    // QualityControl ID
    public static final String PRODUCT_ID = "id";
}
