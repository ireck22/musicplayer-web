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


function amend(){
     //var ss='3';
	//$("#sd").text(ss);//test jqurey
	//alert(2);
	//document.write(line+"<br>");
	$.post("amendment.php", {}, function(data)
			{  
			var xcv=data.split("!");//把資料庫的資料分割放到陣列
			var name = xcv[0];
			var xc2=xcv[43];
			var xc3=xc2.split("v=");
			var xc4="https://www.youtube.com/embed/" + xc3[1]+ "?enablejsapi=1&autoplay=1";
			$("#sd").text(xc4);
			$("#songname").text(name);
			$("#sur").html('<iframe id="next" src="'+ xc4 +'" frameborder="0" width="700" height="400" ></iframe>');
			onYouTubeIframeAPIReady();
			}
		);

	
	//setTimeout('sod()',3000);  

}

function dl(){
        var On = getCookie('songna');
        var re2=On;
        $.post('ccd1.php',{keyword:re2 },function(data){

                var result=data;
                $("#sur").html('<iframe id="next"  src="'+ result +'" width="700" height="400"></iframe>');
                setTimeout(window.location.reload.bind( window.location ),300000);
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
		 /* function onPlayerReady(event) {
			document.getElementById('next').style.borderColor = '#FF6D00';
			event.target.setVolume(20);
	        event.target.playVideo();
		  }*/
		  function changeBorderColor(playerStatus) {
			var color;
			if (playerStatus == -1) {
			  $.post('songmu.php',{},function(data){
                             });
                          dl();
			} else if (playerStatus == 0) {
				color = "#FFFF00";    // ended = yellow
				if(playerStatus==false){
					
			         	window.speechSynthesis.speak(u);
                                        setTimeout(window.location.reload.bind( window.location ),1000);
				}
			} 
		  }
