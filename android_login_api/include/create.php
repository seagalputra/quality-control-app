<?php
	include "connect.php";
	
	$id_cek 	= $_POST['id_cek'];
    $id_produk = $_POST['id_produk'];
    $id_pemesanan = $_POST['id_pemesanan'];
    $tanggal_qc = $_POST['tanggal_qc'];
    $status_qc = $_POST['status_qc'];
    $jml_barang = $_POST['jml_barang'];
    $kondisi_warna = $_POST['kondisi_warna'];
    $kondisi_sole = $_POST['kondisi_sole'];

	
	class emp{}
	
	if (empty($id_cek) || empty($id_produk) || empty($id_pemesanan) || empty($tanggal_qc)||empty($status_qc) || empty($jml_barang)||empty($kondisi_warna) || empty($kondisi_sole)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Field Tidak Boleh Kosong"; 
		die(json_encode($response));
	} else {
		$query = mysqli_query($connect, "INSERT INTO quality_control (id_cek,id_produk,id_pemesanan,tanggal_qc,status_qc,jml_barang,kondisi_warna,kondisi_sole) VALUES ('$id_cek','$id_produk','$id_pemesanan','$tanggal_qc','$status_qc','$jml_barang','$kondisi_warna','$kondisi_sole')");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di simpan";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Data tidak berhasil di simpan";
			die(json_encode($response)); 
		}	
	}
?>