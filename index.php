<?php
	session_start();
	$Name="";
	if (isset($_POST["name"])) {
		$Name=$_POST["name"];
	}
	$_SESSION["res"]=$Name;
	//if($_SESSION["login_session"] == false) {
		//header("Location:login.php"); //轉址進入登入頁
	//}
	if(isset($_GET["logout"]) && ($_GET["logout"]=="true")){
		//unset($_SESSION["res"]);
		session_destroy();  //清除所有session
		header("Location:index.php");
		
	}
	
	

?>
<!DOCTYPE html>
<html>
	<head>
		<title>musicplatform</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
		<link rel="stylesheet" type="text/css" href="css/webstyle.css" media="only screen and (min-width: 400px)">
		<link rel="stylesheet" type="text/css" href="css/mobilestyle.css" media="only screen and (max-width: 400px)">-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js" integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous"></script>
		<!--<script src="js/jquery.min.js"></script>-->
		<script src="js/youtube.js" type="text/javascript"></script>
		<script src="js/videoid.js" type="text/javascript"></script>
		<script src="js/info.js" type="text/javascript"></script>
		<script src="js/amsearch.js" type="text/javascript"></script>
		<script src="js/recordsong.js" type="text/javascript"></script>
		
		
		
	</head>
	<body onLoad="songli(); sod(); sedinfo2(); amend();">
		
		
		<div class="top">
			<span id="sur"></span>
		</div>
		<div id="bottom">
			<div id="bottom-1">
				<div class="left_right">
					<!--<span id="sd2"></span>-->
					<h1>排行榜</h1>
					<select name="Ranking" class="imagetable">
						<option value="1" id="one">傳送中</option>
						<option value="2" id="two">傳送中</option>
						<option value="3" id="three">傳送中</option>
						<option value="4" id="four">傳送中</option>
						<option value="5" id="five">傳送中</option>
						<option value="6" id="six">傳送中</option>
						<option value="7" id="seven">傳送中</option>
						<option value="8" id="eight">傳送中</option>
						<option value="9" id="nine">傳送中</option>
						<option value="10" id="ten">傳送中</option>
					</select>
				</div>
				<div class="middle">
					<tr><td><span id="sd"></span></td><td></tr><br>
					<tr><td>語音辨識：</td><td><span id="songname"></span></td></tr>
					<br><span id="end"></span>
					<div id="son">
						<span id="song"></span>
					</div>
				
				</div>
				<div class="left_right">
					<form id="good" action="index.php" method="post">
						修正查詢:<input class="inno" type="text" name="name">
						<input type="submit" value="確定">
					</form>
					<!--php echo $_SESSION["res"]; ?>-->
					<a style="font-size:25px;" href="login.php">登入</a><br>
					<a style="font-size:25px;" href="registred.php">申請</a><br>
					<a style="font-size:25px;" onClick="location.href='?logout=true'">登出</a>
				</div>
				
			</div>
		</div>
		
	</body>
</html>
