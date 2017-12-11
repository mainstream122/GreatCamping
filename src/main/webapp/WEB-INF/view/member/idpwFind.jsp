<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 아이디/비밀번호 찾기</title>
<link rel="stylesheet" href="<c:url value="/css/member/idpwFind.css" />" >
</head>
	<div>
		<div class="idpwWrapper">
			<p class="idpwInfo">
				아이디/비밀번호 찾기는 이메일로 회원 가입 하신 분만 이용 가능합니다.
			</p>
			<div class="idpwWrapper2">
				<div class="formWrapper">
					<form id="idpwForm" name="idpwForm" method="post">
						<input type="hidden" name="idFind" title="idFind" value="idFind">
						<input type="hidden" name="pwFind" title="pwFind" value="pwFind">
						<section class="idSection">
							<h3 class="idSearchH3">아이디 찾기</h3>
								<p>회원정보에 등록된 정보를 입력해 주세요.</p>
								<div class="name">
									<label for="id_name">이름</label>
									<input type="text" value="id_name"  placeholder="이름을 입력해주세요" >
								</div>
								<div class="nickname">
									<label for="id_nickname">닉네임</label>
									<input type="text" value="nick_name" placeholder="닉네임을 입력해주세요">
								</div>
								<p>
									
								</p>
								<p class="idSearchBtn">
									<input type="submit" value="확인">
								</p>
						</section>
					</form>
					
					<form id="passwordReissueForm" name="passwordReissueForm" method="post">
						<input type="hidden" name="idFind" title="idFind" value="idFind">
						<input type="hidden" name="pwFind" title="pwFind" value="pwFind">
						<section class="passwordReissue">
							<h3 class="passwordReissueH3">비밀번호 재발급</h3>
								<p>회원정보에 등록된 정보를 입력해 주세요.</p>
								<div>
									<label for="id_name">이름</label>
									<input type="text" value="id_name" name="id_name" >
								</div>
								<div>
									<label for="id_nickname">닉네임</label>
									<input type="text" value="nick_name" name="nick_name">
								</div>
								<div>
									<label for="emailAddress">이메일</label>
									<input type="text" value="email_address" name="email_address">
								</div>
								<p>
								
								</p>
								<p class="passwordReissueBtn">
									<input type="submit" value="확인">
								</p>
						</section>
					</form>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>