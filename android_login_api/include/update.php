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
		$query = mysqli_query($connect, "UPDATE `quality_control` SET `id_cek` = '$id_cek', `id_pemesanan` = '$id_pemesanan', `tanggal_qc` = '$tanggal_qc', `status_qc` = '$status_qc', `jml_barang` = '$jml_barang', `kondisi_warna` = '$kondisi_warna', `kondisi_sole` = '$kondisi_sole' WHERE `quality_control`.`id_cek` = '$id_cek'");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di update";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error update Data";
			die(json_encode($response)); 
		}	
	}
?>