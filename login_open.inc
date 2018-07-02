<?php
// 建立MySQL的資料庫連接
	$link = mysqli_connect("localhost", "root", "123") 
        or die("無法開啟MySQL資料庫連接!<br/>");
	mysqli_select_db($link, "music");  // 選擇music資料庫
// 設定SQL查詢字串
	$sql = "SELECT * FROM login";
// 送出utf8編碼的MySQL指令
	mysqli_query($link, 'SET CHARACTER SET utf8');
	mysqli_query($link, 
       "SET collation_connection = 'utf8_general_ci'");
?>