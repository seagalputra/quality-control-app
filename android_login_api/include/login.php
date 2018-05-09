<?php
	include_once "connect.php";

	class usr{}
	
	if (isset($_POST['username']) && isset($_POST['password'])) {
		$id_pegawai = $_POST['username'];
		$password = $_POST['password'];
	
		if ((empty($id_pegawai)) || (empty($password))) { 
			$response = new usr();
			$response->success = 0;
			$response->message = "Kolom tidak boleh kosong"; 
			die(json_encode($response));
		}
	
		$query = mysqli_query($connect, "SELECT * FROM pegawai WHERE id_pegawai='$id_pegawai' AND password='$password'");

		$row = mysqli_fetch_array($query);
	
		if (!empty($row)){
			$response = new usr();
			$response->success = 1;
			$response->message = "Selamat datang ".$row['id_pegawai'];
			$response->id_pegawai = $row['id_pegawai'];
			die(json_encode($response));
		
		} else { 
			$response = new usr();
			$response->success = 0;
			$response->message = "Username atau password salah";
			die(json_encode($response));
		}
	
		mysqli_close($con);
	} else {
		$response = new usr();
		$response->success = 0;
		$response->message = "Required parameter username or password is missing!";
		die(json_encode($response));
	}
	
?>