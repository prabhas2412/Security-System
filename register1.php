<?php
require"init.php";
$user_name=$_POST["user_name"];
$user_pass=$_POST["user_pass"];
$system_pass=$_POST["system_pass"];

if($system_pass=="it_lab@124"){

$sql_query="insert into user_info values('$user_name','$user_pass','$system_pass');";

}
if($system_pass=="it_lab@124"){
echo"Registration Success...";
}
else{
echo"Data insertion error...";
}
if(mysqli_query($con,$sql_query))
{
//echo"<h3>Data Insertion Success...</h3>";
}
else
{
//echo"Data insertion error...".mysqli_error($con);
}



?>