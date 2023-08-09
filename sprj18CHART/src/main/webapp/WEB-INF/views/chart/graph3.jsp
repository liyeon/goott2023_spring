<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.tech.db.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차트</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	media="all" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<%
	String sql = "select decode(colc,1,'청바지1',2,'청바지2',3,'청바지3',4,'청바지4',5,'청바지5') goods, round(sum(cold)*sum(cole)/1000000) TotalPrice from sale2  group by colc  order by colc";
	// 디비 접속
	Connection conn = DBCon.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	/* while(rs.next()){
		System.out.println(rs.getString("goods")+" : "+rs.getInt(2));
	} */
	// JSON 배열
	JSONArray arr = new JSONArray();
	while(rs.next()){
		JSONObject obj = new JSONObject();
		String goods = rs.getString("goods");
		String sum = rs.getString("TotalPrice");
		obj.put("goods",goods);
		obj.put("sum",sum);
		if(obj!=null){
			arr.add(obj);
		}
	}
	rs.close();
	pstmt.close();
	conn.close();
%>
<body>
	<div class="container">
		<h1>graph3</h1>
		<div class="row">
			<div class="col-md-6">
				<canvas id="myChart1"></canvas>
			</div>
			<div class="col-md-6">
				<canvas id="myChart2"></canvas>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-8">
				<canvas id="myChart3"></canvas>
			</div>
		</div>
	</div>

	<script>
	let jArray = new Array();
	jArray = '<%=arr%>';
	
	/* 파싱 처리하기 */
	jArray = JSON.parse(jArray);
	console.log(jArray[0].sum);
		const ctx1 = document.getElementById('myChart1').getContext('2d');
		const ctx2 = document.getElementById('myChart2').getContext('2d');
		const ctx3 = document.getElementById('myChart3').getContext('2d');
		const myChart1 = new Chart(ctx1, {
			type : 'bar',
			data : {
				labels : [ 
					jArray[0].goods, 
					jArray[1].goods, 
					jArray[2].goods, 
					jArray[3].goods, 
					jArray[4].goods ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' ],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
		const myChart2 = new Chart(ctx2, {
			type : 'polarArea',
			data : {
				labels : [ 
					jArray[0].goods, 
					jArray[1].goods, 
					jArray[2].goods, 
					jArray[3].goods, 
					jArray[4].goods ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 
						'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' 
							],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
		const myChart3 = new Chart(ctx3, {
			type : 'doughnut',
			data : {
				labels : [ 
					jArray[0].goods, 
					jArray[1].goods, 
					jArray[2].goods, 
					jArray[3].goods, 
					jArray[4].goods ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' ],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
	</script>
</body>
</html>