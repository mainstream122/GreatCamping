<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${path }/css/qna/qnaWrite.css">
	<title>Insert title here</title>
	<script type="text/javascript"	src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
	<script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
	<script>
		tinymce.init({
			selector : 'textarea'
		});
		
		$().ready(function() {
			$("#qnaSecretYn").click(function() {
				var pwCheck = $(this).closest(".pwTd").find("input[name='qnaPassword']");
				
				if(pwCheck.prop("disabled") == true){
					pwCheck.prop("maxlength", "4");
					pwCheck.prop("required", true);
					pwCheck.prop("disabled", false);
					
					pwCheck.animate({display: "inline-block", width: "toggle"}, 1000);
				}
				else{
					pwCheck.prop("required", false);
					pwCheck.val("");
					pwCheck.prop("disabled", true);
					
					pwCheck.animate({display: "none", width: "toggle"}, 1000);
				}
			});
		});
	</script>
</head>

<body>
	<!-- 닉네임, 비밀글설정여부, 제목, 컨텐츠 -->
	<div class="area">
		<form action="${path }/qnaWrite" method="post">
			<table>
				<colgroup>
					<col width="110px" />
					<col width="*" />
				</colgroup>
			
				<tr style="background: #feb500;">
					<th colspan="2" align="left" style="height: 16px; padding-left: 15px;">Q&A 등록</th>
				</tr>
				
				<tr>
					<td class="row">작성자</td>
					<td>
						<input type="text" value="이선우" name="qnaWriter"/>
					</td>
				</tr>
				
				<tr>
					<td class="row">제목</td>
					<td>
						<input type="text" name="qnaTitle" size="90" />
					</td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td class="pwTd">
						<input type="password" name="qnaPassword" disabled style="display: none;" />
						<input type="checkbox" id="qnaSecretYn" name="qnaSecretYn" value="Y"/>
						<label for="qnaSecretYn">비밀글 설정</label>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<textarea name="qnaContent"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
					</td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>