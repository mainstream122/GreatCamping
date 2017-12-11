<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>고객센터 Q&A | Go Camping</title>
	<link rel="stylesheet" href="${path }/css/qna/qna.css">
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/header.jsp" />

	<div id="qnaWrapper">
		<div class="qnaSide">
			
		</div>

		<div class="qnaBody">
			<table class="qnaTable">
				<colgroup>
					<col width="64px" />
					<col width="*" />
					<col width="80px" />
					<col width="96px" />
					<col width="80px" />
					<col width="80px" />
				</colgroup>
			
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>답변</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				
				<c:forEach var="qna" items="${qnaList }">
					<tr>
						<td>${qna.qnaId }</td>
						<td>
							<div class="ellipsis title">
								<a href='<c:if test="${qna.qnaSecretYn eq 'Y' }">#</c:if>'>${qna.qnaTitle }</a>
								<span class="secretImg">
									<c:if test="${qna.qnaSecretYn eq 'Y' }">
										<img alt="secretImage" src="${path }/img/qna/icoSecret.png">
									</c:if>
								</span>
							</div>
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty qna.qnaAnswer }">답변완료</c:when>
								<c:otherwise>대기중</c:otherwise>
							</c:choose>
						</td>
						<td>
							<div class="ellipsis writer">${qna.qnaWriter }</div>
						</td>
						<td>
							<fmt:formatDate value="${qna.qnaWriteDate }" pattern="yyyy.MM.dd"/>
						</td>
						<td>${qna.qnaViewCount }</td>
					</tr>
				</c:forEach>
			</table>
			<a href="<c:url value="/qnaWrite" />">질문하기</a>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/view/common/footer/footer.jsp" />
</body>
</html>