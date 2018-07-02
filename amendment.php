<?php
	session_start();
	require_once('simple_html_dom.php');
	//$html = file_get_html('https://www.kkbox.com/tw/tc/charts/index.html');
	$res2=array();
	$res3="";
	$url="";
	$result=array();
	//echo $_SESSION["res"];
	if($url=$_SESSION["res"]){
		$result=$url;
		$res2=explode(" ",$result);
		$res2[1]="+";
		if($res2[1]!=""){
			$res3=$res2[0]."+".$res2[1];
			//echo $res3;
			$html = file_get_html("https://www.youtube.com/results?search_query=$res3");
		}else{
			$html = file_get_html("https://www.youtube.com/results?search_query=$url");
		}
	}
	// Find all images 
	$myfile = fopen("f1.txt", "w") or die("Unable to open file!");
	
	echo $url;
	foreach($html->find('a') as $element) {
       //echo $element->title . '<br>';
		 echo $result="!".$element->href;
		fwrite($myfile, $result);
		
		//$wer=explode("!",$result);
		//echo $wer;
	}
	
	fclose($myfile);
	
	//上面是抓文字
	
	//echo $wer[197];
	//echo '<hr>';
	//$string="a!s!d!f!ff!fdd!sdfd!kkkh";
	//$output=end(explode("!",'file.txt'));
	//echo $output[20];
	
	
	



?>
