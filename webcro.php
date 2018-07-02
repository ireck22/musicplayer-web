<?php
	header("Content-Type:text/html; charset=utf-8");
	session_start();
	require_once('simple_html_dom.php');
	$command2 = escapeshellcmd('sudo python test2.py');
	$output = "";
	$_SESSION["out2"]="";
	for(;;){
	   $output = shell_exec($command2); //在windows下執行 python程式
	   if($output != "") break;
	}
	$_SESSION["out2"]=$output;
	$html = file_get_html("https://www.youtube.com/results?search_query=$output");

	$myfile = fopen("f3.txt", "w+") or die("Unable to open file!"); //開文字檔  
	
	
	//echo "<table border=5>";
	echo $output;
	foreach($html->find('a') as $element) {
       #$a="$element->href . '<br>'";     //這個迴圈是把過濾出來的a元素丟到$element裡
	   #echo  "http://www.youtube.com/embed".$element->href ."'<br>'";
	   #echo $a[]; 
	  
	   $res="!".$element->href; //$element在過濾出href裡的內容
	   //echo "<tr>";
	   //echo "<td>".$res."</td>";
	   //echo "</tr>";
	   echo $res;
	   fwrite($myfile,$res);
	}
	//echo "</table>";
	
	fclose($myfile);  
	
	
	
	
	



?>
