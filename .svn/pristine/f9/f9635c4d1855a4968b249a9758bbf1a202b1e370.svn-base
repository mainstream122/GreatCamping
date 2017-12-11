<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" href="${path }/css/notice/noticeLeftMenu.css" />
<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>

<div style="width: 1200px; margin: 0 auto; margin-top: 85px;">
		<div class="li-option width40 margin70">
			<div class="padding-left20 topDiv recieve">
				<p>공지사항</p>
			</div>
			<ul class="ul-option">
				<li class="lili border-bottom border-top"><a href="#" style="font-weight: bold;">공지사항</a></li>
				<li class="lili border-bottom border-top"><a href="#">FAQ</a></li>
				<li class="lili border-bottom border-top"><a href="#">Q&A</a></li>
			</ul>
		</div>
		<div class=" inline">
			<form id="pageForm">
			  <div class="">
				BoardList가 들어가야함<br/><br/>

				<c:forEach items="${noticeList.list}" var="ntVO">
					${ntVO.noticeSubject} <br/>
					 ${ntVO.noticeDate} <br/>
					  ${ntVO.noticeAttachmentVO.naName} <br/><br/>
				</c:forEach>
			  </div>
			  ${pageNavi }
		   	</form>
		</div>
	</div>
</body>
</html>