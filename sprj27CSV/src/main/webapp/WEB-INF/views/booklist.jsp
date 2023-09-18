<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=request.getContextPath();

%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
function simfunc(btitle) {
	//alert("sign!!!"+btitle.value);
	console.log(btitle.checked)
	$("#viewtitle").html(btitle.value);
	if (btitle.checked) {
		var htmltxt="";
		$.ajax({
			type:"post",
			url:"<%=path%>/book/simbook?bt="+btitle.value,
			success:function(result){
				htmltxt="<table>";
				
				for ( var ele in result) {
					console.log(result[ele].simtitle);
					htmltxt=htmltxt+"<tr><td>"+result[ele].simtitle+
					"</td></tr>";
				}
				/* for(let i=0;i<result.length-1;i++){
					console.log(result[i].simtitle);
					htmltxt=htmltxt+"<tr><td>"+result[i].simtitle+
					"</td></tr>";
				}
				htm */ltxt=htmltxt+"</table>";
				$("#display").html(htmltxt);

			}
		});	
	}
}

function noticefunc() { 
	$('#myModal').show();
}


</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<style>
.fa-solid{
	color: #333;
}
.fa-solid:hover{
	color: orange;
}
</style>
</head>
<body>
<h3>booklist.jsp</h3>


<table width="500" border="1">
	<tr>
		<td>no</td>
		<td>check</td>
		<td>btitle</td>
		<td>recomnd</td>
		<td>cart</td>
	</tr>
	
	<tr>
		<td>1</td>
		<td>
			<input type="checkbox"  onclick="simfunc(this);" value="스탠포드 호텔 서울 101호" /> 
		</td>
		<td>스탠포드 호텔 서울 101호 </td>
		<td>
			<button>recomnd</button>
		</td>
		<td>
			<button>cart</button>
		</td>	
	</tr>
	<tr>
		<td>2</td>
		<td>
			<input type="checkbox"  onclick="simfunc(this);"  value="센텀 프리미어 호텔 101호" /> 
		</td>
		<td>센텀 프리미어 호텔 101호</td>
		<td>
			<button>recomnd</button>
		</td>
		<td>
			<button>cart</button>
		</td>	
	</tr>	
</table>
<button onclick="noticefunc();">py유사도분석</button>
<br />[<span id="viewtitle">title</span>] 유사 상품 <br />
<div id="display">aaa</div>

<!-- ---------------- -->
<style>
        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */                          
        }
 
</style>

    <!-- The Modal -->
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
                <p style="text-align: center;"><span style="font-size: 14pt;"><b><span style="font-size: 14pt;">코사인유사도이해</span></b></span></p>
                <p style="text-align: center;"><span style="font-size: 10pt;"><b><span style="font-size: 10pt;">[파이선연동 활용 유사도 분석]</span></b></span></p>
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p style="text-align: center; line-height: 1.5;"><span style="font-size: 10pt;">두개의 문장은 사실 단어가 동일하고 단어의 
                빈도수만 다르기 때문에 각도로 표현하게 될 경우
                동일한 결과인 1이 나오게 된다. <br />
	         코사인 유사도는 -1 ~ 1사이의 값을 가진다. 
	         벡터들의 방향이 완전히 다를 경우 
	         즉 각도가 180º일 경우에는 -1이고 방향이 완전히 동일하면 1이며, 
	         값이 90º의 각일 경우 0값을 가지게 된다.</span></p>
                <p style="text-align: center; line-height: 1.5;">
                	<img src="resources/img/simimg.png" width="100%" alt="" />           
                </p>
                
                <p style="text-align: center; line-height: 1.5;"><br /></p>
                <p><br /></p>
            <div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="close_pop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                     닫기
                </span>
            </div>
      </div>
 
    </div>
        <!--End Modal-->

    <script type="text/javascript">
      
        jQuery(document).ready(function() {
                //$('#myModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };       
      </script>
<!-- 출처 : https://tyson.tistory.com/90 -->
<!-- ---------------- -->


</body>
</html>