<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
 <style type="text/css">
	.main-wrapper {
		position:relative;
		width:1200px;
		margin:0px auto 0px;
	}
	.selectPage {
		font-weight:bold;
		background-color:black;
		color:white;
	}
	.campingPlaceArea {
		width:1200px;
		margin:10px auto;
	}
	#campingPlaceList {
		list-style: none;
		width:1200px;
		padding:0px;
		margin:0px;
		display: inline-block;
	}
	#campingPlaceList li {
		float:left;
		width: 300px;
		height: 100px;
		display:block;
	}
	#campingPlaceList li a {
		text-decoration: none;
		font-weight: bold;
		color: #ff2c02;
	}
	#campingPlaceList li address {
		font-weight: bold;
		display: inline;
		font-style: normal;
		color: #555555;
	}
	.campingPlaceBox {
		margin: 5px;
		border: 1px solid #ccc;
		width:268px;
		padding:10px;
		height:68px;
		overflow: hidden;
	}
</style>
<c:import url="/region/map"/>
	<div class="campingPlaceArea">
		<form id="pageForm">
			<ul id="campingPlaceList">
			<c:forEach items="${campingPlaceList}" var="cmpPlc">
				<li>
					<div class="campingPlaceBox">
						<div><a href="/GreatCamping/campDetailMain?campingPlaceId=${cmpPlc.campingPlaceId}">${cmpPlc.cmpPlcNm}</a></div>
						<div>주소 : <address>${empty cmpPlc.newFullAddress ? cmpPlc.oldFullAddress : cmpPlc.newFullAddress}</address></div>
					</div>
				</li>
			</c:forEach>
			</ul>
			<div style="clear: left;"></div>
			<div style="width:100%;text-align: center;padding:30px 0px 20px 0px;">
			${pageNavi}
			</div>
		</form>
	</div>
<jsp:include page="/WEB-INF/view/common/footer/footer.jsp"></jsp:include>
</body>
</html>