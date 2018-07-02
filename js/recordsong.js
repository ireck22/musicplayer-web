function songli(){
		$.post("record.php", {}, function(data)
			{
			var xcv=data;//把資料庫的資料分割放到陣列
			//var table = document.getElementById("ss").createCaption();
			
			$("#song").html(xcv);
			}
		);
	
	//setTimeout('songli()',2000);   
				
}