<?php
	require_once('login_open.inc');
	session_start();
	//$_SESSION["res"]=$Name;
	$Name="";
	$pass="";
	
	if (isset($_POST["name"])) {
		$Name=$_POST["name"];
	}
	if (isset($_POST["password"])) {
		$pass=$_POST["password"];
	}
	
	$_SESSION["login_session"]="";
	$_SESSION["NAME"]=$Name;
	if($Name !="" &&$pass !="") {
		//建立sql指令字串
		
		$sql="SELECT * FROM login WHERE password='";
		$sql.=$pass."' AND username='".$Name."'";  //sql和password字串連接
		$rows=mysqli_query($link, $sql);//執行sql字串
		if($result=mysqli_fetch_array($rows) != false){
			$_SESSION["login_session"] =true;
		}
	}
	if($_SESSION["login_session"] == true){
		header("Location:index.php"); //轉址登入首頁
	}else{
		header('Location: login.php');
	}
?>