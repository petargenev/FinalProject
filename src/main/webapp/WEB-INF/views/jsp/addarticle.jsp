<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<style>
.error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
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
						<!-- <div class="logo pull-left">
							
						</div> -->
						<div class="btn-group pull-left">
							<iframe scrolling="no" frameborder="no" clocktype="html5" style="overflow:hidden;border:0;margin:0;padding:0;width:180px;height:60px;"src="http://www.clocklink.com/html5embed.php?clock=004&timezone=Bulgaria_Sofia&color=orange&size=180&Title=&Message=&Target=&From=2016,1,1,0,0,0&Color=orange"></iframe>
							
							
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								<c:if test="${sessionScope.username == null}">
    																						
								
								<li><a href="login"><i class="fa fa-lock"></i> Вход</a></li>
							</c:if>
							
							<c:if test="${sessionScope.username != null}">
								
    						<!--	<li><a href=""><i class="fa fa-user"></i>Добре дошъл ${sessionScope.username} !</a></li>		-->			
    						<li><a ><i class="fa fa-user cart1"></i><span class="cart1">Добре дошъл ${sessionScope.username} !</span></a></li>										
								
								<li><a href="LogoutCartController"><i class="fa fa-lock cart1"></i> <span class="cart1">Изход</span></a></li>
							</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div  style="position:absolute; left: 70px; top:120px;">
		<button class="btn btn-default update" value="showCompDiv" onclick="showComputer()">ДОБАВИ КОМПЮТЪР</button>
		<button class="btn btn-default update" value="showTabletDiv" onclick="showTablet()">ДОБАВИ ТАБЛЕТ</button>
		<button class="btn btn-default update" value="showLaptopDiv" onclick="showLaptop()" >ДОБАВИ ЛАПТОП</button>
				<a class="btn btn-default update" href="mainpage" >НАЧАЛНА СТРАНИЦА</a>
		</div>
		<div>
		<button style="display:none"> asdasd</button>.
		</div>
		<div id="computerDiv"  style="display:none;" class="container">
		
			<div class="heading">
				<h3 style="text-indent: 43px;">Добавяне на компютър</h3>
				<!-- <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p> -->
			</div>
			
			<form:form commandName="computer" action="./addcomputer" method="post" id="computerForm" name="computerForm" enctype="multipart/form-data" onsubmit="return validateComputerForm()" >
			 <%-- <form:errors path="*" cssClass="error" /> --%>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul">
						
						
							<li class="single_field">
							
								<label>Марка:</label>
								
								<form:input path="label" id="label" name="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" name="model" type="text"/>
								
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" name="price" type="text"/>
							</li>
							<li class="single_field">
								<label>Оперативна памет (ГБ):</label>
								<form:input path="ram" name="ram" type="text"/>
							</li>
							<li class="single_field">
								<label>Скорост на процесора:</label>
								<form:input path="processorSpeed" name="processorSpeed" type="text"/>
							</li>
							<li class="single_field">
								<label>Вид операционна система:</label>
								<form:input path="operationSystem" name="operationSystem" type="text"/>
							</li>
							<li class="single_field">
								<label>HDD:</label>
								<form:input path="hdd" name="hdd" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="processorType" name="processorType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип видео карта</label>
								<form:input path="videoCardType" name="videoCardType" type="text"/>
							</li>
							<li >
								<label>Снимка</label>
						
									<input type="file" name="file" id="computerImage"  onchange="ValidateFileUploadComputer()" />
							       	<img class="snimka" id="imageC" src="#" alt="Вашата снимка" />
											
							</li>
							
							
							
					</ul>
						<button type="submit" value="Add new computer" id="computerBtn" class="btn btn-default update" >Добави</button>
						<h2 id="computerWarning" style="display:none"><span>Моля качете валидна снимка, за да добавите артикул.</span></h2>
						<c:if test="${ not empty warning}"><h2>asdasd</h2></c:if>
					</div>
				</div>
				
			</div>
			
			</form:form >
			
		</div>
		
		<div id="tabletDiv"  style="display:none;" class="container">
		
			<div class="heading">
				<h3 style="text-indent: 43px;">Добавяне на таблет</h3>
				
			</div>
			
			<form:form commandName="tablet" action="./addtablet" method="post" enctype="multipart/form-data" id="tabletForm" name="tabletForm" onsubmit="return validateTabletForm()">
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul" >
						
						
							<li class="single_field">
								<label>Марка:</label>
								<form:input path="label" name="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" name="model" type="text"/>
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" name="price" type="text"/>
							</li>
							
							
							<li class="single_field">
								<label>Тип дисплей:</label>
								<form:input path="displayType" name="displayType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="cpu" name="cpu" type="text"/>
							</li>
							
							<li class="single_field">
								<label>Големина на екрана</label>
								<form:input path="displaySize" name="displaySize" type="text"/>
							</li>
							<li class="single_field">
								<label>Резолюция</label>
								<form:input path="resolution" name="resolution" type="text"/>
							</li>
							
							<li >
								<label>Снимка</label>
						
									<input  type="file"  name="file" id="tabletImage"  onchange="ValidateFileUploadTablet()" />
							       	<img class="snimka" id="imageT" src="#" alt="Вашата снимка" />
											
							</li>
							
							
							
					</ul>
						<button type="submit" value="Add new computer" id="tabletBtn" class="btn btn-default update" >Добави</button>
						<h2 id="tabletWarning" style="display:none"><span>Моля качете валидна снимка, за да добавите артикул.</span></h2>
					
					</div>
				</div>
				
			</div>
			
			</form:form >
			
		</div>
		
		<div id="laptopDiv"  style="display:none;" class="container">
		
			<div class="heading">
				<h3 style="text-indent: 43px;">Добавяне на лаптоп</h3>
				<!-- <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p> -->
			</div>
			
			<form:form commandName="laptop" action="./addlaptop" method="post" id="laptopForm" name="laptopForm" enctype="multipart/form-data" onsubmit="return validateLaptopForm()">
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul">
						
						
							<li class="single_field">
								<label>Марка:</label>
								<form:input path="label" name="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" name="model" type="text"/>
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" name="price" type="text"/>
							</li>
							<li class="single_field">
								<label>Оперативна памет (ГБ):</label>
								<form:input path="ram" name="ram" type="text"/>
							</li>
							<li class="single_field">
								<label>Скорост на процесора:</label>
								<form:input path="processorSpeed" name="processorSpeed" type="text"/>
							</li>
							<li class="single_field">
								<label>Вид операционна система:</label>
								<form:input path="operationSystem" name="operationSystem" type="text"/>
							</li>
							<li class="single_field">
								<label>HDD:</label>
								<form:input path="hdd" name="hdd" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="processorType" name="processorType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип видео карта</label>
								<form:input path="videoCardType" name="videoCardType" type="text"/>
							</li>
						
							<li class="single_field">
								<label>Големина на екрана</label>
								<form:input path="displaySize" name="	" type="text"/>
							</li>
							<li class="single_field">
								<label>Резолюция</label>
								<form:input path="resolution" name="resolution" type="text"/>
							</li>
							
							<li >
								<label>Снимка</label>
						
									<input name="file" type="file"  id="laptopImage"  onchange="ValidateFileUploadLaptop()" />
							       	<img class="snimka" id="imageL" src="#" alt="Вашата снимка"  />
											
							</li>
				
							
							
							
							
					</ul>
						<button type="submit" value="Add new laptop" id="laptopBtn" class="btn btn-default update" >Добави</button>
						<h2 id="laptopWarning" style="display:none"><span>Моля качете валидна снимка, за да добавите артикул.</span></h2>
					
					</div>
				</div>
				
			</div>
			
			</form:form >
			
		</div>
		
		
	
	

	<script src="js/fieldsRequired.js"></script>

	<script src="js/photoupload.js"></script>
	<script src="js/hideOrShow.js"></script>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>