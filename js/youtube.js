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
		  function onPlayerReady(event) {
			document.getElementById('next').style.borderColor = '#FF6D00';
		  }
		  function changeBorderColor(playerStatus) {
			var color;
			if (playerStatus == -1) {
			  color = "#37474F"; // unstarted = gray
			} else if (playerStatus == 0) {
				color = "#FFFF00";
				if(playerStatus==false){
					$("#end").text(222);// ended = yellow
				}
			} else if (playerStatus == 1) {
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
			}
		  }
		  function onPlayerStateChange(event) {
			changeBorderColor(event.data);
		  }
		  