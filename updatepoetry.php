<?php


$servername = "localhost";
$username = "root";
$password = "";
$db = "poetrydb";

$conn = new mysqli($servername,$username,$password,$db);

if($conn->connect_error){
	die("connection failed: ".$connect_error);
}

$POETRY = $_POST['poetry_data'];
$POET = $_POST['poet_name'];
$ID = $_POST['id'];

$query = "UPDATE poetry SET poetry_data = '$POETRY' , poet_name = '$POET' WHERE id = '$ID'";

$result = $conn->query($query);

if($result){
	$response = array("status"=>"1","message"=>"Poetry succesfully updated");
}
else{
	$response = array("status"=>"0","message"=>"Poetry not updated");
}

echo json_encode($response);


?>