<?php
	header("Content-Type:text/html; charset=utf-8");
	require_once('searchsong_open.inc');
	session_start();
	
	$name3=$_SESSION["NAME"];
	$sql="SELECT 歌名,時間 FROM `".$name3."` ORDER BY 排序 DESC";
	$result = mysqli_query($link, $sql);
	// 一筆一筆的以表格顯示記錄
	echo '<div style="width:400px; height:100px; overflow:auto; border:2;">';
	echo "<table  border=1><tr>";
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
	echo '</div>';
	mysqli_free_result($result); // 釋放佔用記憶體  
	
	mysqli_close($link); //資料庫關閉
	
?>