<?php
	//header('content-type:application/json;charset=utf-8');
	session_start();
	$FN="";
	$Name="";
	$Pname="";
	$Icon="";
	$result="";
	$w="";
	$s="";
	
	//取得輸入的值
	
	if(isset($_POST["name"])){
		$Name=$_POST["name"];
	}
	if(isset($_POST["packname"])){
		$Pname=$_POST["packname"];
	}
	if(isset($_POST["icon"])){
		$Icon=$_POST["icon"];
	}
	
	$json_string = file_get_contents('456.json');
	$data = json_decode($json_string, true);
	
	if ($data == NULL) {
		$data = array(
			
			"apkstore"=>array(
			array("id"=>"0","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"1","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"2","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"3","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"4","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"5","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"6","name"=>"","packname"=>"","icon"=>""),
			array("id"=>"7","name"=>"","packname"=>"","icon"=>""),
			)
		
		);
	}
	//var_dump($data);
	//

	//
	
	if(isset($_POST["Numbering2"])){
		$s=((int) $_POST["Numbering2"])-1;
	
			$result[0]=$data["apkstore"][$s]['name'];
			$result[1]=$data["apkstore"][$s]['packname'];
			$result[2]=$data["apkstore"][$s]['icon'];
					
	}

		
	
	
	
	//$aq="sss";
	//$ad=fopen("456.json","a+");
	
	//fclose($ad);
	
	
	//$json_string = file_get_contents('456.json');
	// 把JSON字符串转成PHP数组
	//$data = json_decode($json_string, true);


	if(isset($_POST["Numbering"])){
		$w=((int) $_POST["Numbering"]) -1;
			
		$data["apkstore"][$w]["name"]= $Name;
		$data["apkstore"][$w]["packname"]= $Pname;
		$data["apkstore"][$w]["icon"]= $Icon;	
		//轉成json格式
		$json_string = json_encode($data);
		//導入json格式
		file_put_contents('456.json', $json_string);
	
			
	}
	

	
	//$data["apkstore"][0]["name"]=$_SESSION["NAME"];
	//$data["apkstore"][0]["icon"]="456789";
	//还原成.json文件
	//$newda = json_encode($data);
	//保存到原来的文件中
	//file_put_contents('456.json', $newda);
	
	// 显示出来看看
	var_dump($data);
	//echo $result;
	
	
?>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>測試</title>
		<script src="https://ajax.googleapis.com/ajax/libs/ext-core/3.1.0/ext-core.js"></script>
		<style type="text/css">
		.ip{
			margin-top:100px;
			margin-left:100px;
			float:left;
			color:#0000FF; 
		}
		#left{
			margin-left:200px;
			float:left;
		}
		.wd{
			width:100px;
			height:30px;
		}
		.as{
			width:300px;
			height:50px;
		}
		</style>
		<script>
				$(document).ready(function() {	
					$("input").submit(function () { // Ajax送出表單
				
						var message = $("#chat").val(); // 取得訊息
					// 使用HTTP POST方法送出Ajax請求至PHP程式
						$.post("write.php", {text: message},function(result){
							$("#ss").text(result);
						});
						
						
					});
				}
		</script>
	</head>
	<body>
		
			<form action="index.php" method="post" id="ch">
				<table class="ip">
					<tr>
						<td>
							<select class="wd"  name="Numbering">
				　				<option value=1>0</option>
				　				<option value=2>1</option>
				　				<option value=3>2</option>
				　				<option value=4>3</option>
								<option value=5>4</option>
								<option value=6>5</option>
								<option value=7>6</option>
								<option value=8>7</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>name修改: </td> <td><input type="text" id="chat" name="name" value=""/></td>
					</tr>
					<tr>
						<td>packname 修改: </td><td><input type="text" name="packname" value=""/> </td>
					</tr>
					<tr>
						<td>icon 修改: </td> <td><input type="text" name="icon" value=""></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="確定"/></td>
					</tr>	
				</table>
			</form>
		<span id="ss">www</span>
		<div id="left">
			<form action="index.php" method="post">
				<h1>顯示</h1>
				<br>
				<br>
				<select class="wd"  name="Numbering2">
					　<option value=1>0</option>
					　<option value=2>1</option>
					　<option value=3>2</option>
					　<option value=4>3</option>
					  <option value=5>4</option>
					  <option value=6>5</option>
					  <option value=7>6</option>
					  <option value=8>7</option>
				</select>
				<input type="submit" value="送出"/> <br>
				neme:     <input type="text"  value="<?php echo $result[0]; ?>"/> <br>
				packname:<input type="text"  value="<?php echo $result[1]; ?> "/><br>
				icon:      <input type="text"  value="<?php echo $result[2]; ?>"/><br>
				<!--<input type="submit" value="送出"/>-->
			</form>
		</div>
		
	</body>
</html>