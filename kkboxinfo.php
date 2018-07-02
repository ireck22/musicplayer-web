<?php
	$v1="";
	$v2="";
	require_once('simple_html_dom.php');
	$html = file_get_html('https://www.kkbox.com/tw/tc/playlist/-nXq5VfFRZWo_OdD-x');
	// Find all images 
	//$array = array(
    //1    => "a",
    //"1"  => "b",
    //1.5  => "c",
    //true => "d",
	//);
	//var_dump($array);
	
	$myfile = fopen("file.txt", "w") or die("Unable to open file!");
	 
	
	foreach($html->find('a') as $element) {
       
		 echo $result="!".$element->title;
		 fwrite($myfile, $result);
	}
	fclose($myfile);
	//上面是抓文字
	//echo '<hr>';
	//foreach($html->find('img') as $element){ 
       //echo $element->src . '<br>';
		//echo $result2="#".$element->src . '<br>' ;
	//}
	
	 
	 //fwrite($myfile, $element);
	 //fclose($myfile);
	//$res=$html->find("#list ul");//抓取<div id="list">底下所有的<ul>
	//foreach($res as $k=>$a){
		//$b = $a->find("li");
		 // $v1 = $b[0]->plaintext;//第一次迴圈:xx1,第二次迴圈:yy1
		  //$v2 = $b[1]->plaintext;//第一次迴圈:xx2,第二次迴圈:yy2
	//}
	//echo $v1;
	//echo $v2;



?>
