<?php
	header("Content-Type:text/html; charset=utf-8");
	
	//$anser="";
	$anser2 = $_REQUEST["keyword"];
	//echo $anser;
	//$anser="https://www.youtube.com/watch?v=yNwGRaLm_NI";
	$command2 = escapeshellcmd("sudo youtube-dl -o music/%(title)s.%(ext)s  $anser2");
	$cmd=shell_exec($command2);
	$cmd2=mb_convert_encoding($cmd, "UTF-8", "BIG5");
		//echo $cmd2;
		//echo '<hr>'; 	
	$cmd3=explode(' ',$cmd2);
		//for($i=0;$i<35;$i++){
		//	echo $cmd3[$i];  //看每個陣列的值
		//	echo '<br>';	
		//}
        	//echo '<hr>'; 
		//echo $cmd3[17];
		//echo '<br>';
		//echo $cmd3[18];
	$text="has";
	if($cmd3[14]==$text){
		echo $cmd3[13];
	}else{
		$cmd4=explode('[',$cmd3[14]);
		echo $cmd4[0];  //最後的本機路徑
	}
	//$as2=split('[\.-]',$as); //分割符號 \ 或是.或是橫線
	
?>
