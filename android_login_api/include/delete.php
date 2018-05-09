<?php
	include "connect.php";
	
	$id_cek 	= $_POST['id_cek'];
	
	class emp{}
	
	if (empty($id_cek)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "data tidak terhapus"; 
		die(json_encode($response));
	} else {
		$query = mysqli_query($connect, "DELETE FROM quality_control WHERE id_cek='".$id_cek."'");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data terhapus";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Data tidak terhapus";
			die(json_encode($response)); 
		}	
	}
?>