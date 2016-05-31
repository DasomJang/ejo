<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 가입</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
	var checked = false;
	$(function() {
		var f = document.mForm;
		var id = f.id;
		var pass2 = f.pass2;
		$("#pass2").blur(function() {
			var msg = "";
			if (pass2.value != pass.value) {
				// 	msg= alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요!");
				msg = "비밀번호가 일치하지 않습니다. 다시 확인해주세요!";
				pass.focus();
				pass.select();

			} else {
				msg = "비밀번호가 일치 합니다.";
			}
			$("#passchk").html(msg);
		});

		$("#cancel").on("click",function(){
			location.href = "${pageContext.request.contextPath}/main/main.do";
		});
		$("#dupChk").click(function() {
			$.ajax({
				url : "/Fashion-PRJ/join/chkId.json",
				data : {
					id : id.value
				}
			}).done(function(data) {
				var msg = "";
				if (data == 0) {
					msg = alert("사용 가능한 아이디 입니다.");
					checked = true;
				} else {
					msg = alert("이미 사용중인 아이디 입니다.");
					checked = false;
				}
				$("#result").html(msg);
			});
		});
	})
	function ckForm() {

		if (!checked) {
			alert("아이디 중복검사를 해주세요!");
			id.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1>회원가입</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form" name="mForm" method="POST"
				onsubmit="return ckForm()"
				action="${pageContext.request.contextPath}/join/join.do">
				<div class="form-group">
					<label for="userId">아이디</label>
					<table>
						<tr>
							<th><input type="text" class="form-control" id="id"
								name="id" placeholder="아이디를 입력해 주세요" style="width: 450px;"
								required></th>
							<td><button type="button" class="btn btn-info" name="check"
									id="dupChk">중복체크</button>
								<br /> <span id="result"></span></td>

						</tr>
					</table>
				</div>
				<div class="form-group">
					<label for="InputPassword1">비밀번호</label> <input type="password"
						class="form-control" id="pass" name="pass" placeholder="비밀번호"
						required>
				</div>
				<div class="form-group">
					<label for="InputPassword2">비밀번호 확인</label> <input type="password"
						class="form-control" id="pass2" name="pass2" placeholder="비밀번호 확인"
						required>
					<p class="help-block">
						<span id="passchk"></span>
					</p>

				</div>
				<div class="form-group">
					<label for="username">이름</label> <input type="text"
						class="form-control" id="username" name="name"
						placeholder="이름을 입력해 주세요" required>
				</div>
				<div class="form-group">
					<label for="InputGender">성별</label> <input type="radio"
						name="gender" value="F" checked="checked">여자 <input
						type="radio" name="gender" value="M">남자
				</div>
				<div class="form-group">
					<label for="InputEmail">이메일 주소</label> <input type="email"
						class="form-control" id="InputEmail" name="email"
						placeholder="이메일 주소" required>
				</div>

				<div class="form-group text-center">
					<button type="submit" class="btn btn-info" id=join name="join">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="button" class="btn btn-warning" id=cancel
						name="cancel">
						가입취소<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
		</div>
	</article>
	<script src="../js/bootstrap.min.js"></script>

</body>
</html>