<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="Header.jsp" %>
<script src="./js/slide.js"></script>
<!-- <script>	 
	window.onload = runSlideShow();
	
	var slideShowSpeed = 3000;
	var crossFadeDuration = 2;
	var pic = new Array();
	
	pic[0]='./image/main/[1].jpg';
	pic[1]='./image/main/[2].jpg';
	pic[2]='./image/main/[3].jpg';
	pic[3]='./image/main/[4].jpg';
	pic[4]='./image/main/[5].jpg';
	pic[5]='./image/main/[6].jpg';
	pic[6]='./image/main/[7].jpg';
	pic[7]='./image/main/[8].jpg';
	pic[8]='./image/main/[9].jpg';
	pic[9]='./image/main/[10].jpg';
	pic[10]='./image/main/[11].jpg';
	pic[11]='./image/main/[12].jpg';

	var preLoad = new Array();
	for(i=0;i<pic.length;i++){
		preLoad[i] = new image();
		preLoad[i].src = pic[i];
	}
	var t;
	var j = 0;
	function runSlideShow() {
		if(document.all){
		document.images.SlideShow.style.filter="blendTrans(duration=2)";
		document.images.SlideShow.style.filter="blendTrans(duration=crossFadeDuration)";
		document.images.SlideShow.filte.blendTrans.Apply();
		}
		document.images.SlideShow.src = preLoad[j].src;
		if(document.all){
			document.images.SlideShow.filters.blendTrans.Play();
		}
		j++;
		if(j>pic.length-1){
			j = 0;
			t = setTimeout('runSlideShow()', slideShowSpeed);
		}
	}
</script>-->
	

<div class="mainDiv">
	<div class="mainDiv-child">
		<img id="mainImg" src="./image/main/1.jpg" height="800px" name="SlideShow">
	</div>
</div>

<%@include file ="Footer.jsp" %>