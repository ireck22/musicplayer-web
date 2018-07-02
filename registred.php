<?php
	include("login_open.inc");
	$name="";
	$password="";
	$email="";
	$mobilephone="";
	$msg="";
	//取得表單欄位  存欄位的變數
	if(isset($_POST["Name"]))
		$name=$_POST["Name"];
	if(isset($_POST["m_passwd"]))
		$password=$_POST["m_passwd"];
	//if(isset($_POST["m_email"]))
		//$email=$_POST["m_email"];
	//if(isset($_POST["Mobilephone"]))
		//$mobilephone=$_POST["Mobilephone"];
	#echo $name."h".$password."h".$email."h".$mobilephone;
	//檢查是否輸入所有資訊
	if($name !="" && $password !=""){
		
		$sql="SELECT * FROM login"; //從資料庫選取
		$sql.= " WHERE username='".$name."'";
		$row= mysqli_query($link,$sql);
		//使用者是否存在
		if(mysqli_fetch_row($row)== false){   //假如不等於false回傳使用者已經存在
		$sql="INSERT INTO login(username,password)".     //變數插入資料庫
		"VALUES('".$name."','".$password."')";
		mysqli_query($link,$sql) or die("sql字串執行錯誤");
		
		$sql2="CREATE TABLE `".$name."` (
				`排序` int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
				`歌名` char(20) COLLATE 'utf8_general_ci' NOT NULL,
				`時間` timestamp NOT NULL
			) COLLATE 'utf8_general_ci'";
		mysqli_query($link,$sql2) or die("sql字串執行錯誤");	
		
		header("location:login.php");
		}
		else{
			echo "使用者已經存在";
		}
		mysqli_close($link); //資料庫關閉
		
		
	}
?>
<html>
	<head>
		<meta content='text/html; charset=utf-8' http-equiv='Content-Type'/>
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
		<title>註冊會員</title>
		<link href="css/.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		@media screen and (min-width:420px){
			body{
				background-image:  url(./picture/xx.jpg);
				background-repeat: no-repeat;
				background-size:100% 100%;
			}
			.dataDiv{
				width:500px;
				height:400px;
				margin-left:auto;
				margin-right:auto;
				margin-top:200px;
				
			}
			#data2{
				width:250px;
				height:50px;
				margin-left:auto;
				margin-right:auto;
				
			}
		}	
		@media screen and (max-width:420px){
			body{
					background-image:url(./picture/x3.jpg);
					background-repeat:repeat;
					background-size:;
					font-family:Microsoft JhengHei;	
				}
			.smalltext{
				font-size:15px;
			}
			.fcc{
				color:#0072E3;
			
			}
			#data2{
				width:250px;
				height:50px;
				margin-left:auto;
				margin-right:auto;
				
			}
		}
		</style>
		<script language="javascript">

		function checkForm(){
		//檢查欄位是否有按照規定格式
			if(document.formJoin.Name.value==""){	
		//假如填入空值 則顯示出請填寫帳號
			alert("請填寫名子!");
			document.formJoin.Name.focus();
			return false;
			}else{
				uid=document.formJoin.Name.value;
				if(uid.length<5 || uid.length>12){
			//字串長度小於5 大於12 顯示您的帳號長度只能5至12字元
					alert( "您的帳號長度只能5至12個字元!" );
					document.formJoin.Name.focus();
					return false;
				}
				if(!(uid.charAt(0)>='a' && uid.charAt(0)<='z')){
					alert("您的名子第一字元只能為小寫字母!" );
					document.formJoin.Name.focus();
					return false;
				}
				for(idx=0;idx<uid.length;idx++){
					if(uid.charAt(idx)>='A'&&uid.charAt(idx)<='Z'){
						alert("名子不可以含有大寫字元!" );
						document.formJoin.Name.focus();
						return false;
					}
					if(!(( uid.charAt(idx)>='a'&&uid.charAt(idx)<='z')||(uid.charAt(idx)>='0'&& uid.charAt(idx)<='9')||( uid.charAt(idx)=='_'))){
						alert( "您的名子只能是數字,英文字母及「_」等符號,其他的符號都不能使用!" );
						document.formJoin.Name.focus();
						return false;
					}
					if(uid.charAt(idx)=='_'&&uid.charAt(idx-1)=='_'){
						alert( "「_」符號不可相連 !\n" );
						document.formJoin.Name.focus();
						return false;				
						
					}
				}
				if(!check_passwd(document.formJoin.m_passwd.value,document.formJoin.m_passwdrecheck.value)){
					document.formJoin.m_passwd.focus();
					return false;
				}	
				/*if(document.formJoin.m_email.value==""){
					alert("請填寫電子郵件!");
					document.formJoin.m_email.focus();
					return false;
				}*/
				/*if(document.formJoin.m_email.value!=""){
					var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
					if(filter.test(m_email.value)){
					return true;
					}
					alert("電子郵件格式不正確");
					return false;
	
				}*/

				/*if(document.formJoin.Mobilephone.value==""){
					alert("請填寫手機號碼!");
					document.formJoin.Mobilephone.focus();
					return false;
				}
				if(!checkmail(document.formJoin.m_email)){
					document.formJoin.m_email.focus();
					return false;
				}
				if(!validateTWPhone(document.formJoin.Mobilephone)){
					document.formJoin.Mobilephone.focus();
					return false;
				}
				return confirm('確定送出嗎？');*/
			}			
			function check_passwd(pw1,pw2){
				if(pw1==''){
					alert("密碼不可以空白!");
					return false;
				}
				for(var idx=0;idx<pw1.length;idx++){
					if(pw1.charAt(idx) == ' ' || pw1.charAt(idx) == '\"'){
					alert("密碼不可以含有空白或雙引號 !\n");
					return false;
					}
					if(pw1.length<5 || pw1.length>10){
						alert( "密碼長度只能5到10個字母 !\n" );
						return false;
					}
					if(pw1!= pw2){
						alert("密碼二次輸入不一樣,請重新輸入 !\n");
						return false;
					}
				}
				return true;
			}
			/*function checkemail(myEmail) {
				var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				if(filter.test(myEmail.value)){
					return true;
				}
				alert("電子郵件格式不正確");
				return false;
			}
			function validateTWPhone(myphone) {
				var reg = /^09[0-9]{8}$/;
			//09開頭 [0-9]需要八個數字 {8}
				if (reg.test(myphone.value)) {
					return true;
	//執行表單檢查，假如沒有錯誤才會送出表單
				}
			}			
			alert("手機號碼格式不正確");
			return false;*/
		}
	
	
		</script>
		</head>
		<body onload="checkForm()">
	
		<h2>
		<form action="registred.php" method="post"  name="formJoin" id="formJoin" onSubmit="return checkForm();" >
		<!--執行表單檢查，假如沒有錯誤才會送出表單-->
		
			<div class="dataDiv" align="center">
				<h1><font face="標楷體" size="20" color="#00DDDD">註冊會員</font></h1>
				<p><strong><font color="#00DDDD">帳號</font></strong>：
					<input name="Name" type="text" class="normalinput" id="username">
					<font color="#FF0000">*</font><br>
					<span class="smalltext" style="color:red;">請填入5~12個字元以內的小寫英文字母、數字、以及_ 符號</span></p>
				<p><strong><font color="#00DDDD">密碼</font></strong>：
					<input name="m_passwd" type="password" class="normalinput" id="m_passwd">
					<font color="#FF0000">*</font><br>
					<span class="smalltext" style="color:red;">請填入5~10個字元以內的英文字母、數字、以及各種符號組合</span></p>
				<p><strong><font color="#00DDDD">確認密碼</font></strong>：
					<input name="m_passwdrecheck" type="password" class="normalinput" id="m_passwdrecheck">
					<font color="#FF0000">*</font> <br>
					<span class="smalltext" style="color:red;">再輸入一次密碼</span></p>
					
          
			
			</div>
          <p id="data2">
			<input name="action" type="hidden" id="action" value="join">
			<input type="submit"  name= "Submit2" value="註冊會員" class="button">
			<input type="reset" name="Submit3" value="重設資料" class="button">
            <input type="button" name="Submit" value="回上一頁" onClick="window.history.back();" class="button">
			</p>
		</h2>
		</form>
	</body>
</html>	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	







		
		
		
		
	
			
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
