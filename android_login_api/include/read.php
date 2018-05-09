<?php
	include("connect.php");
	
	$query = "SELECT * FROM quality_control";
	$result = mysqli_query($connect,$query);
	$json = array();	
	while($row = mysqli_fetch_assoc($result)){
		$json[] = $row;
	}	
	echo(json_encode($json));
?>