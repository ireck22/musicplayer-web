<!DOCTYPE html>
<html>
	<head>
		<title>musicplatform</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
		<style type="text/css">
			@media screen and (min-width:420px){
				body{
					background-image:url(./picture/mu3.jpg);
					background-repeat:no-repeat;
					background-size:100% 1000px;	
				}
				
				#min{
					margin-left:auto;
					margin-right:auto;
					text-align:center;
					font-size:70px;
					width:600px;
					height:200px;
					color:#00FFFF;
				}
				#top-left{
					margin-left:auto;
					margin-right:auto;
					margin-top:30%;
					width:500px;
					height:200px;
					
				}
				#right{
					margin-left:auto;
					margin-right:auto;
					width:500px;
					height:300px;
					color:#FF7744;
				}
				#top2{
					margin-left:auto;
					margin-right:auto;
					margin-top:;
					width:300px;
					height:50px;
					text-align:center;
					font-size:30px;
					
				}
				.rco{
					color:#00DDDD;
					
				}
				
				.butten{
					font-size:30px;
					color:#003C9D;
				}
			}
			@media screen and (max-width:420px){
				body{
					background-image:url(./picture/x3.jpg);
					background-repeat:repeat;
					background-size:;	
				}
				#min{
					margin-left:auto;
					margin-right:auto;
					text-align:center;
					font-size:50px;
					width:300px;
					height:200px;
					color:#0044BB;
				}
				#top-left{
					margin-left:auto;
					margin-right:auto;
					margin-top:50%;
					width:300px;
					height:200px;
					
				}
				#right{
					margin-left:auto;
					margin-right:auto;
					width:300px;
					height:300px;
					color:#FF7744;
				}
				#top2{
					margin-left:auto;
					margin-right:auto;
					width:300px;
					height:50px;
					text-align:center;
					font-size:30px;
					
				}
				.rco{
					color:#0044BB;
					
				}
				
				.butten{
					font-size:30px;
					color:#003C9D;
				}
			}
		</style>
	</head>
	<body>		
		<div id="min">
			<div id="top-left">
				音為有你
			</div>	
		</div>
		<div id="right">	
			<form id="top2" action="login2.php" method="post">
				帳號:   <input type="text" name="name"><br>
				密碼:   <input type="password" name="password"><br>
				<br>
				<input class="butten" type="submit" value="確定"><br>
				<!--<a class="rco" href="registred.php">申請</a>-->
			</form>
		</div>
	</body>
</html>	
