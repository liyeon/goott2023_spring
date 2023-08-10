<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부우우우우트스트랩</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
   function lengthdiv() {
      //alert("hi")
      var d1width=document.getElementById("d1").clientWidth;
      //alert(d1width);
      var y=document.getElementById("window");
      y.innerHTML="스크린폭: "+screen.width+" 창폭: "+window.innerWidth+" div폭: "+d1width;
   }
</script>

<style>
@font-face {
    font-family: 'LOTTERIADDAG';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/LOTTERIADDAG.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
*{
    font-family: 'LOTTERIADDAG';
}
#window{
	font-size:2em;
}
</style>
</head>
<body onresize="lengthdiv();">
	<div class="jumbotron text-center">
		<h1>
			나의 첫번째 부트스트랩 페이지
		</h1>
	</div>
	<div class="container">
		<div class="row">
			<div id="d1" class="col-sm-4">
				칼럼
			</div>
			<div id="d2" class="col-sm-4">
				칼럼
			</div>
			<div id="d3" class="col-sm-4">
				칼럼
			</div>
			
		</div>
		<p id="window"></p>
	</div>
</body>
</html>