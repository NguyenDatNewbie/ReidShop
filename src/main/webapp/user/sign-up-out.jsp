<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Đăng nhập/Đăng ký</title>

<link rel="stylesheet" href="./assets/css/authentication.css">
<!-- Plugins CSS -->
<link rel="stylesheet" href="assets/css/plugins.css">

<!-- Main Style CSS -->
<link rel="stylesheet" href="assets/css/style.css">


</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="wrapper">
	<div class="container">
		<div class="cont" style=" padding: 10px;  border:orange solid 1px;">
			<form class="form sign-in" method="post" action="./login">
				<h2 style="margin-bottom:15px">Welcome To Reid Shop</h2>
				<div class="input-control">
					<input name="username" id="name" type="email" placeholder="Email" required style="width:100%;"
						value="${username}" />
				</div>
				<div class="input-control">
					<input name="password" id="pass" type="password" required
						placeholder="Password" value="${password}"/>
				</div>
				<div class="form-group text-center">
					<input type="checkbox" tabindex="3" class="" name="remember"
						id="remember"> <label for="remember"> Remember Me</label>
				</div>
				<p class="message-text">${message}</p>
				<p class="forgot-pass">Quên mật khẩu?</p>
				<button type="submit" class="submit">Đăng nhập</button>
			</form>
			<div class="sub-cont">
				<div class="img">
					<div class="img__text m--up">
						<h2>Bạn chưa có tài khoản?</h2>
						<p>Đăng ký ngay nào!</p>
					</div>
					<div class="img__text m--in">
						<h2>One of us?</h2>
						<p>Nếu bạn đã có tài khoản,vui lòng đăng nhập tại đây!</p>
					</div>
					<div class="img__btn">
						<span class="m--up">Đăng ký</span> <span class="m--in">Đăng
							nhập</span>
					</div>
				</div>
				<form class="form sign-up" method="post" action="./register">
					<h2>ĐĂNG KÝ TÀI KHOẢN</h2>
					<div class="input-control">
						<input name="fullName" id="nameRe" type="text" required
							placeholder="Họ và tên" value="${fullName}" />
					</div>
					<div class="input-control">
						<input name="usernameNew" id="usernameR" type="email" required
							placeholder="Email" value="${usernameNew}"/>
					</div>
					<div class="input-control">
						<input name="phone" id="phone" type="text" required
							placeholder="Số điện thoại" value="${phone}"/>
					</div>
					<div class="input-control">
						<input name="address" id="address" type="text" required
							placeholder="Địa chỉ" value="${address}" />
					</div>
					<div class="input-control">
						<input name="passwordNew" id="passwd" type="password" required
							placeholder="Mật khẩu" value="${passwordNew}"/>
					</div>
					<div class="input-control">
						<input name="repasswordNew" id="repasswd" type="password" required
							placeholder="Nhập lại mật khẩu" value="${repasswordNew}"/>
					</div>
					<p class="message-text-fail">${messageRegisterFail}</p>
					<p class="message-text-success">${messageRegisterSuccess}</p>
					<button type="submit" class="submit" style="margin: -30px auto; margin-bottom: 3px;">Đăng ký</button>
				</form>
			</div>
		</div>
		</div>
	</div>
	<!--footer area start-->
	<jsp:include page="footer.jsp" />
	<!--footer area start-->
	<script>
    window.addEventListener('load', () => {
        document.querySelector('.img__btn').addEventListener('click', function() {
            document.querySelector('.cont').classList.toggle('s--signup');
        });
    })
</script>
</body>
</html>
