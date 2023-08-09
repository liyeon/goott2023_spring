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
<title>emp!</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	media="all" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<%
	String sql = "select job, sum(sal) sum from emp group by job";
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
		String job = rs.getString("job");
		String sum = rs.getString("sum");
		obj.put("job",job);
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
		<h1>emp</h1>
		<div class="row">
			<div class="col-md-6">
				<canvas id="myChart1"></canvas>
			</div>
			<div class="col-md-6">
				<canvas id="myChart2"></canvas>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-6">
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
		const myChart1 = new Chart(ctx1, {
			type : 'bar',
			data : {
				labels : [ 
					jArray[0].job, 
					jArray[1].job, 
					jArray[2].job, 
					jArray[3].job, 
					jArray[4].job ],
				datasets : [ {
					label : '# 직업별 급여 합계',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 
						  'rgba(255, 99, 132, 0.2)',
					      'rgba(255, 159, 64, 0.2)',
					      'rgba(255, 205, 86, 0.2)',
					      'rgba(75, 192, 192, 0.2)',
					      'rgba(54, 162, 235, 0.2)'],
					borderColor : [ 
						'rgb(255, 99, 132)',
					      'rgb(255, 159, 64)',
					      'rgb(255, 205, 86)',
					      'rgb(75, 192, 192)',
					      'rgb(54, 162, 235)'
					],
					borderWidth : 2
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
		const ctx2 = document.getElementById('myChart2').getContext('2d');
		const myChart2 = new Chart(ctx2, {
			type : 'polarArea',
			data : {
				labels : [ 
					jArray[0].job, 
					jArray[1].job, 
					jArray[2].job, 
					jArray[3].job, 
					jArray[4].job ],
				datasets : [ {
					label : '# 직업별 급여 합계',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 
						  'rgba(255, 99, 132, 0.2)',
					      'rgba(255, 159, 64, 0.2)',
					      'rgba(255, 205, 86, 0.2)',
					      'rgba(75, 192, 192, 0.2)',
					      'rgba(54, 162, 235, 0.2)'],
					borderColor : [ 
						'rgb(255, 99, 132)',
					      'rgb(255, 159, 64)',
					      'rgb(255, 205, 86)',
					      'rgb(75, 192, 192)',
					      'rgb(54, 162, 235)'
					],
					borderWidth : 2
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
		const ctx3 = document.getElementById('myChart3').getContext('2d');
		const myChart3 = new Chart(ctx3, {
			type : 'line',
			data : {
				labels : [ 
					jArray[0].job, 
					jArray[1].job, 
					jArray[2].job, 
					jArray[3].job, 
					jArray[4].job ],
				datasets : [ {
					label : '# 직업별 급여 합계',
					data : [ 
						jArray[0].sum, 
						jArray[1].sum, 
						jArray[2].sum, 
						jArray[3].sum, 
						jArray[4].sum ],
					backgroundColor : [ 
						  'rgba(255, 99, 132, 0.2)',
					      'rgba(255, 159, 64, 0.2)',
					      'rgba(255, 205, 86, 0.2)',
					      'rgba(75, 192, 192, 0.2)',
					      'rgba(54, 162, 235, 0.2)'],
					borderColor : [ 
						'rgb(255, 99, 132)',
					      'rgb(255, 159, 64)',
					      'rgb(255, 205, 86)',
					      'rgb(75, 192, 192)',
					      'rgb(54, 162, 235)'
					],
					borderWidth : 2
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