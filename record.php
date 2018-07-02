<?php
	header("Content-Type:text/html; charset=utf-8");
	require_once('searchsong_open.inc');
	session_start();
	$out3="";
	$out4="";
	$name2="";
	
	$name2=$_SESSION["NAME"];
	
	//echo $name2;
	$out3=$_SESSION["out2"];
	$out4=$_SESSION["res"];
	if($out3==true){
	$sql2="INSERT INTO `".$name2."` (歌名)VALUES('".$out3."')";  //聲控紀錄
	}else{

	$sql2="INSERT INTO `".$name2."` (歌名)VALUES('".$out4."')";  //修正紀錄
	}
	
	mysqli_query($link,$sql2) or die("sql字串執行錯誤");
 
 
	$sql="SELECT 歌名,時間 FROM `".$name2."` ORDER BY 排序 DESC";
	$result = mysqli_query($link, $sql);
	// 一筆一筆的以表格顯示記錄
	//echo '<div style="width:400px; height:200px; overflow:auto;">';
	echo "<table  border=1 ><tr>";
	// 顯示欄位名稱
	while ( $meta = mysqli_fetch_field($result) )
		echo "<td>".$meta->name."</td>";
		echo "</tr>"; // 取得欄位數
	$total_fields = mysqli_num_fields($result);
	// 顯示每一筆記錄
	while ($row = mysqli_fetch_row($result)) {
		echo "<tr>"; // 顯示每一筆記錄的欄位值
		for ( $i = 0; $i <= $total_fields-1; $i++ )
			echo "<td>" . $row[$i] . " </td>";
			echo "</tr>";
			//$aw=$row[$i];
			//$as=$aw.'^'.$aw;
			//echo $as;
		}
	
	echo "</table>";
	//echo '</div>';
	mysqli_free_result($result); // 釋放佔用記憶體  
	
	mysqli_close($link); //資料庫關閉
?>
