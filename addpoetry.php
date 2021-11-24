<?php

$servername = "localhost";
$username = "root";
$password = "";
$db = "poetrydb";

$conn = new mysqli($servername,$username,$password,$db);

if($conn->connect_error){
	die("connection failed: ".$connect_error);
}

$POETRY = $_POST['poetry'];
$POET_NAME = $_POST['poet_name'];

$query = "INSERT INTO poetry(poetry_data,poet_name)VALUES('$POETRY','$POET_NAME')";

$result = $conn->query($query);

if($result==1){
	$response = arry("status"=>"1","message"=>"Poetry succesfully inserted");
}
else{
	$response = arry("status"=>"0","message"=>"Poetry not succesfully inserted");
}

echo json_encode($response);


?>