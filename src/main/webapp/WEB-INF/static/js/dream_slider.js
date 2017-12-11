
	function initSlideListTransition(ulObj) {
		ulObj.closest("div").css({"overflow":"hidden", "position":"relative"});
		ulObj.css({"padding":"0px", "margin" : "0px", "list-style" : "none", "position":"absolute", "top": "0px", "left" : "0px", "width" : 3 * ulObj.children("li").length * parseInt(ulObj.children("li").eq(0).css("width").replace("px",""))});
		ulObj.children("li").css({"float":"left"});
		ulObj.data("li-width", parseInt(ulObj.children("li").eq(0).css("width").replace("px","")));
		ulObj.data("ul-width", ulObj.children("li").length * parseInt(ulObj.children("li").eq(0).css("width").replace("px","")));
		ulObj.append(ulObj.children("li").clone());
		ulObj.data("under-animation", 0);
		ulObj.data("curr-idx", 0);
	}
	
	function slideListTransition(ulObj, dir, transitionTime, beforeAnime, afterAnime){
		var underAnime = parseInt(ulObj.data("under-animation"));
		var liWidth = parseInt(ulObj.data("li-width")); 
		var lisWidth = parseInt(ulObj.data("ul-width"));
		
		if(underAnime == 0) {
			ulObj.data("under-animation", "1");
			
			var ulPosLeft = parseInt(ulObj.css("left").replace("px",""));
			
			if(dir < 0 && ulPosLeft <= -2 * lisWidth + liWidth) {
				ulObj.css("left", -1 * lisWidth + liWidth);	
			} else if (dir > 0 && ulPosLeft >= 0) {
				ulObj.css("left", -1 * lisWidth + "px");
			}
			
			ulPosLeft = parseInt(ulObj.css("left").replace("px",""));
	
			ulObj.data("curr-idx", (2*lisWidth - ulPosLeft - liWidth * dir) / liWidth % (lisWidth/liWidth));
			if(beforeAnime) beforeAnime();
			ulObj.animate({
				"left":ulPosLeft + liWidth * dir + "px"
			}, transitionTime, function(){
				ulObj.data("under-animation", "0");
				if(afterAnime) afterAnime();
			});
		}
	}
	
	function slideListMoveTo(ulObj, clickIdx, onAnime) {
		var underAnime = parseInt(ulObj.data("under-animation"));
		if(underAnime==0) {
			var currIdx = parseInt(ulObj.data("curr-idx"));
			if(clickIdx != currIdx) { 
				ulObj.data("under-animation", "1");

				var liWidth = parseInt(ulObj.children("li").eq(0).css("width").replace("px", ""));
				var ulPosLeft = parseInt(ulObj.css("left").replace("px", ""));
				
				ulObj.data("curr-idx", clickIdx);
				ulObj.animate({"left":ulPosLeft + (currIdx - clickIdx) * liWidth + "px"}, 500, function(){
					ulObj.data("under-animation", "0");
				});
				if(onAnime) onAnime();
			}
		}
	}