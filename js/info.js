function sedinfo2(){
     //var ss='3';
	//$("#sd").text(ss);//test jqurey
	//alert(2);
	//document.write(line+"<br>");
	$.post("kkboxinfo.php", {}, function(data)
			{  
			var zxc=data.split("!");//資料分割放到陣列	
			var xc2 = zxc[20];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#one").text(xcend);     //第一名
				

			var xc2=zxc[27];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#two").text(xcend);      //第二名
			
			var xc2=zxc[30];
			var xc3=xc2.split("-");	
			var xcend=xc3[0];
			$("#three").text(xcend);    //第三名
			
			var xc2=zxc[35];
			var xc3=xc2.split("-");	
			var xcend=xc3[0];
			$("#four").text(xcend);     //第四名
			
			var xc2=zxc[40];
			var xc3=xc2.split("-");	
			var xcend=xc3[0];
			$("#five").text(xcend);      //第五名 
			
			var xc2=zxc[46];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#six").text(xcend);      //第六名 
			
			var xc2=zxc[51];
			var xc3=xc2.split("-");	
			var xcend=xc3[0];
			$("#seven").text(xcend);      //第七名 
			
			var xc2=zxc[57];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#eight").text(xcend);      //第八名 
			
			var xc2=zxc[62];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#nine").text(xc2);      //第九名 
			
			var xc2=zxc[69];
			var xc3=xc2.split("(");	
			var xcend=xc3[0];
			$("#ten").text(xcend);      //第十名 
			
		  }
		);

	
	//setTimeout('sedinfo()',3000);  

}
