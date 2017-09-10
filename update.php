<?php
require"init.php";
$user_name=$_POST["user_name"];
$user_pass=$_POST["user_pass"];
$system_pass=$_POST["system_pass"];
$new_user_pass=$_POST["new_user_pass"];

$sql_query="UPDATE user_info SET user_pass = '$new_user_pass' where user_name like '$user_name' and system_pass like '$system_pass';";

$result=mysqli_prepare($con,$sql_query);

mysqli_stmt_bind_param($result, "sss", $new_user_pass, $user_name, $user_pass);
mysqli_stmt_execute($result);
//if(mysqli_num_rows($result)>0)
//{
//$row=mysqli_fetch_assoc($result);
//$user_pass=$row["user_pass"];
//$user_pass = $new_user_pass;
//echo"Update Success...Your New User Password is" .$user_pass;
//}
//else
//{
//echo"Update Failed.....Try Again..";
//}



?>