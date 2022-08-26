<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@include file="../../include/header.jsp"%>

<div class="main">
		<h2 style="
		font-family: 'Lato', sans-serif;">
		Exercise Record</h2>
		<br><br>

	<%@include file="../../include/myPageNav.jsp"%>

	<hr style="width: 1300px; margin: auto;">

	<div class="myPageNav2">
		<div class="leftContainer">
			<h3>프로필 사진</h3>
			<div class="profillePhoto">
				<img src="/project/resources/image/arnold.jpeg">
			</div>
		</div>

		<div class="heightLine"></div>

		<div class="rightContainer">
			<div class="rcText">
			<p style="text-align: right;">※ 날짜를 누르면 수정가능합니다.</p>
				<table id='record_tb' border="1" style="float:left;">
					<tr>
						<td><h4>운동 날짜</h4></td>
						<td><h4>운동 시간</h4></td>
						<td><h4>시작 시간</h4></td>
						<td><h4>끝난 시간</h4></td>
					</tr>
					<c:forEach items="${list}" var="RecordDTO">
						<tr>	
							<td><a href="/project/user/record/update?userNum=${RecordDTO.userNum}&recordNum=${RecordDTO.recordNum}" style="text-decoration:none;">
								<fmt:formatDate pattern="yyyy-MM-dd" value="${RecordDTO.useDate}" /></a></td>
							<td>${RecordDTO.playTime}</td>
							<td>${RecordDTO.startHour}시 ${RecordDTO.startMinute}분</td>
							<td>${RecordDTO.endHour}시 ${RecordDTO.endMinute}분</td>
						</tr>
					</c:forEach>
				</table>
				<table id='record_tb' border="1" style="width:40%;">	
					<tr>
						<td ><h4>운동 이름</h4></td>
						<td colspan="1"><h4>운동 횟수</h4></td>					
					</tr>
					<c:forEach items="${exlist}" var="el">
						<tr>
							<td colspan="1">${el.exName}</td>
							<td colspan="1">${el.setCount}</td>
						</tr>
					</c:forEach>
				</table>
				<div class="container" style="width: 400px; height: 400px;">
					<!--차트가 그려질 부분-->
					<canvas id="myChart"></canvas>
				</div>
			</div>
		</div>
	</div>

	<hr style="width: 1300px; margin: auto;">
	<br>

	<div class="bt_box">
		<button id="myBtn1" type="submit" class="inbody_insert">입력</button>
		<button id="myBtn1" onclick="location.href='/project/user/record/record?userNum=${userNum}'">뒤로</button>
	</div>
<%-- data 가져오는지 확인용  	
	${arm}
	${upper}
	${back}
	${lower}
	${core} --%>
</div>

<%@include file="../../include/footer.jsp"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script type="text/javascript">
	var context = document.getElementById("myChart")
	var labelNames = [ "삼두,이두,전완", "가슴,어깨", "등", "허벅지,엉덩이,종아리", "복근,코어" ];

	var userArm = '${arm}';
	var userUpper = '${upper}';
	var userBack = '${back}';
	var userLower = '${lower}';
	var userCore = '${core}';

	//var ability = [${userExDAO.userArm},${userExDAO.userUpper}, ${userExDAO.userBack}, ${userExDAO.userLower}, ${userExDAO.userCore}];
	var getData = '${chartData}';
	console.log(getData);

	var arr = getData.split("],");

	/*    
	
	for (var i=0; i<arr.length; i++){
		if(arr.expartCode == "userArm"){
			userArm = arr.setCount;
		}
		if(arr.expartCode == "userUpper"){
			userUpper = arr.setCount;    		
		}
		if(arr.expartCode == "userBack"){
			userBack == arr.setCount;
		}
		if(arr.expartCode == "userLower"){
			userLower == arr.setCount;
		}
		if(arr.expartCode == "userCore"){
			userCore == arr.setCount;
		}    		
	}
	
	 */

	var ability = [ userArm, userUpper, userBack, userLower, userCore ];
	var myChart = new Chart(context, {
		type : 'radar', // 차트의 형태
		data : {
			labels : labelNames,
			datasets : [ {
				fill : true,
				backgroundColor : "rgba(32,140,236,0.7)",
				borderColor : "rgba(32,140,236,1)",
				pointBorderColor : "#fff",
				pointBackgroundColor : "rgba(179,181,198,1)",
				data : ability
			} ]
		},
		options : {
			responsive : true,
			legend : {
				display : false
			}, // 차트 데이터 이름 숨기기
			scale : { //// <= radar 타입 차트 처럼 축이 한개인 차트는 scales 를 쓰면 안됩니다.
				ticks : {
					beginAtZero : true,
					min : 0, // 축 최소 값
					max : 100, // 축 최대 값
					stepSize : 20, // 그리드 간격 값
					display : false, // 그리드 숫자 숨기기
				},

				pointLabels : {
					fontSize : 18,
					fontColor : "rgba(128,128,128,1)"
				}
			},

			title : {
				display : false
			}
		}
	});
</script>
