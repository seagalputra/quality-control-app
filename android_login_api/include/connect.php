<?php
	define('HOSTNAME', 'sidelearning.net');
	define('USERNAME', 'sidelear_sisfo2018');
	define('PASSWORD', 'sidelear_sisfo2018');
	define('DATABASE', 'sidelear_sisfo3901');
	
	$connect = new mysqli(HOSTNAME,USERNAME,PASSWORD,DATABASE) or die (mysqli_errno());
?>