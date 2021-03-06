<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	
 
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="rdFacebook"><i class="fa fa-facebook"></i></a></li>
								<li><a href="rdTwitter"><i class="fa fa-twitter"></i></a></li>
								<li><a href="rdLinkedin"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="rdDribbble"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="rdGooglePlus"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						
						
						<iframe scrolling="no" frameborder="no" clocktype="html5" style="overflow:hidden;border:0;margin:0;padding:0;width:180px;height:60px;"src="http://www.clocklink.com/html5embed.php?clock=004&timezone=Bulgaria_Sofia&color=orange&size=180&Title=&Message=&Target=&From=2016,1,1,0,0,0&Color=orange"></iframe>
							
						
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								
								<li><a href="cart"><i class="fa fa-shopping-cart cart1"></i><span class="cart1"> Количка</span></a></li>
								<li><a href="login" class="active"><i class="fa fa-lock cart1"></i><span class="cart1"> Вход</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<a class="btn btn-default update" href="mainpage" style="position:absolute; left: 75px; top:-30px;">ПАЗАРУВАЙ</a>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	

		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Влезте в профила си</h2>
						<form:form commandName="user" name="loginForm" action="login"  onsubmit="return validateLoginForm()">
							<form:input path="email" type="email" name="email" placeholder="E-mail адрес" />
							<form:input path="password" type="password" name="password" placeholder="Парола" />
							
							<button type="submit" value="Log user" class="btn btn-default">Вход</button>
							<c:if test="${not empty invalidLogin}"><h3><span style="color:red"><c:out value="${invalidLogin}"/></span></h3> </c:if>
						</form:form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">ИЛИ</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>създайте нов профил</h2>
						
						<form:form commandName="user" name="registerForm" action="RegistrationController" onsubmit="return validateForm()">

							<form:input path="name" name="name" type="text" placeholder="Въведете име" title="Въведете име състоящо се от 3 до 20 букви!"  pattern=".{3,20}" id="name" oninput="validateInput();" />
							<form:input path="email" name="email" type="email" class="mailRegistration" oninput="checkEmailAvailability()" placeholder="Въведете e-mail адрес" title="Въведете валиден Email адрес!" pattern="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+(?:[A-Z]{2}|com|org|net|gov|mil|biz|info|mobi|name|aero|jobs|museum|bg)\b"/>							
							<form:input path="password"  name="password" type="password" id= "userPsw" title="Паролата ви трябва да съдържа минимъм 6 символа, ГЛАВНА и малка буква, и число." placeholder="Въведете парола"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"/>
							<input  type="password" placeholder="Потвърдете паролата"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" oninput="check(this)" >
	
							<button type="submit" value="Add new user" id="registerBtn" class="btn btn-default regButton">Създаване</button>
						</form:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	<i class="fa fa-angle-up"></i>
	
	<script src="js/validateInput.js"></script>
	<script src="js/fieldsRequired.js"></script>
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
    <script src="lib/jquery-2.2.4.min.js"></script>
	<script src="js/PasswordsMatcher.js"></script>
</body>
</html>