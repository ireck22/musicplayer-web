var u = new SpeechSynthesisUtterance("finish");
var u2 = new SpeechSynthesisUtterance("傳送中");
u.lang = "zh-TW" // So system knows the right voice to use
voices = speechSynthesis.getVoices();
//u.voices=voices[44];

u2.lang = "zh-TW" // So system knows the right voice to use

//u2.voices=voices[44];

var time = 0;


function SetCookie(name,value)
{
    var exp  = new Date();    
    exp.setTime(exp.getTime() + 60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getCookie(name)//取cookies函数        
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
     if(arr != null) return unescape(arr[2]); return null;

}
function delCookie(name)//删除cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}


function sod(){
     //var ss='3';
	//$("#sd").text(ss);//test jqurey
	//alert(2);
	//document.write(line+"<br>");
	$.post("webcro.php", {}, function(data)
			{  
			var xcv=data.split("!");//把資料庫的資料分割放到陣列
			var name = xcv[0];
			var xc2=xcv[44];
			var xc3=xc2.split("v=");
			var xc4="https://www.youtube.com/embed/" + xc3[1]+ "?enablejsapi=1&autoplay=1";
			SetCookie("songna",xc4);
			$("#sd").text(xc4);
			$("#songname").text(name);
			$("#sur").html('<iframe id="next" src="'+ xc4 +'" frameborder="0" width="700" height="400" ></iframe>');
			onYouTubeIframeAPIReady();
			}
		);

	
	//setTimeout('sod()',3000);  

}

/*function sod2(){
	
	var i='0';
	$("#sd2").text(i);
	var ed=document.getElementById("next");
	var ed2=ed.ended;
	$("#sd2").text(ed2);
	
}*/

function dl(){
	var On = getCookie('songna');
	var re2=On;	
	$.post('ccd1.php',{keyword:re2 },function(data){
			 
		var result=data;
		$("#sur").html('<iframe id="next"  src="'+ result +'" width="700" height="400"></iframe>');
		setTimeout('sod()',300000);
		});	

}
var tag = document.createElement('script');
		  tag.id = 'iframe-demo';
		  tag.src = 'https://www.youtube.com/iframe_api';
		  var firstScriptTag = document.getElementsByTagName('script')[0];
		  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

		  var player;
		  function onYouTubeIframeAPIReady() {
			player = new YT.Player('next', {
				events: {
				  'onReady': onPlayerReady,
				  'onStateChange': onPlayerStateChange
				  
				}
			});
		  }
		 
		  function changeBorderColor(playerStatus) {
			var color;
			if (playerStatus == -1) {
			 //window.speechSynthesis.speak(u2);
			  //alert("不能播");
			  $.post('songmu.php',{},function(data){
			     });
			  dl(); 
			} else if (playerStatus == 0) {
				  
				if(playerStatus==false){
					window.speechSynthesis.speak(u);
					sod();
					//setTimeout(window.location.reload.bind( window.location ),1000);
					//$("#end").text(222); 	//結束重新整理
					
				}	
			} /*else if (playerStatus == 1) {
			  color = "#33691E"; // playing = green
			} else if (playerStatus == 2) {
			  color = "#DD2C00"; // paused = red
			} else if (playerStatus == 3) {
			  color = "#AA00FF"; // buffering = purple
			} else if (playerStatus == 5) {
			  color = "#FF6DOO"; // video cued = orange
			}
			if (color) {
			  document.getElementById('next').style.borderColor = color;
			}*/
		  }
		 
		  
		  
