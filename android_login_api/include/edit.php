<?php
	include "connect.php";
	
	$id_cek 	= $_POST['id_cek'];
	
	class emp{}
	
	if (empty($id_cek)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Error Mengambil Data"; 
		die(json_encode($response));
	} else {
		$query 	= mysqli_query($connect, "SELECT * FROM quality_control WHERE id_cek='".$id_cek."'");
		$row 	= mysqli_fetch_array($query);
		
		if (!empty($row)) {
			$response = new emp();
			$response->success = 1;
			$response->id_cek = $row["id_cek"];
			$response->id_produk = $row["id_produk"];
            $response->id_pemesanan = $row["id_pemesanan"];
            $response->tanggal_qc = $row["tanggal_qc"];
			$response->status_qc = $row["status_qc"];
            $response->jml_barang = $row["jml_barang"];
            $response->kondisi_warna = $row["kondisi_warna"];
			$response->kondisi_sole = $row["kondisi_sole"];
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error Mengambil Data";
			die(json_encode($response)); 
		}	
	}
?>