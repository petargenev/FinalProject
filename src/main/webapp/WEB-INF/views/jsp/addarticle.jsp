<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
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
								<li><a href=""><i class="fa fa-facebook"></i></a></li>
								<li><a href=""><i class="fa fa-twitter"></i></a></li>
								<li><a href=""><i class="fa fa-linkedin"></i></a></li>
								<li><a href=""><i class="fa fa-dribbble"></i></a></li>
								<li><a href=""><i class="fa fa-google-plus"></i></a></li>
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
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									BG
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									
									<li><a href="">UK</a></li>
								</ul>
							</div>
							
							
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								
								<c:if test="${sessionScope.username == null}">
    																						
								<li><a href="cart"><i class="fa fa-shopping-cart"></i> Количка</a></li>
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

		<button class="btn btn-default update" value="showCompDiv" onclick="showComputer()">ДОБАВИ КОМПЮТЪР</button>
		<button class="btn btn-default update" value="showTabletDiv" onclick="showTablet()">ДОБАВИ ТАБЛЕТ</button>
		<button class="btn btn-default update" value="showLaptopDiv" onclick="showLaptop()" >ДОБАВИ ЛАПТОП</button>
		
		<div id="computerDiv"  style="display:none;" class="container">
		
			<div class="heading">
				<h3 style="text-indent: 43px;">Добавяне на компютър</h3>
				<!-- <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p> -->
			</div>
			
			<form:form commandName="computer" action="./addcomputer" method="post" id="computerForm" enctype="multipart/form-data" >
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul">
						
						
							<li class="single_field">
								<label>Марка:</label>
								<form:input path="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" type="text"/>
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" type="text"/>
							</li>
							<li class="single_field">
								<label>Оперативна памет (ГБ):</label>
								<form:input path="ram" type="text"/>
							</li>
							<li class="single_field">
								<label>Скорост на процесора:</label>
								<form:input path="processorSpeed" type="text"/>
							</li>
							<li class="single_field">
								<label>Вид операционна система:</label>
								<form:input path="operationSystem" type="text"/>
							</li>
							<li class="single_field">
								<label>HDD:</label>
								<form:input path="hdd" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="processorType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип видео карта</label>
								<form:input path="videoCardType" type="text"/>
							</li>
							<li >
								<label>Снимка</label>
						
									<input type="file" name="file" id="computerImage"  onchange="ValidateFileUploadComputer()" />
							       	<img class="snimka" id="imageC" src="#" alt="Вашата снимка" />
											
							</li>
							
							
							
					</ul>
						<button type="submit" value="Add new computer" id="computerBtn" class="btn btn-default update" >Добави</button>
						<h2 id="computerWarning" style="display:none"><span>Моля качете валидна снимка, за да добавите артикул.</span></h2>
					
					</div>
				</div>
				
			</div>
			
			</form:form >
			
		</div>
		
		<div id="tabletDiv"  style="display:none;" class="container">
		
			<div class="heading">
				<h3 style="text-indent: 43px;">Добавяне на таблет</h3>
				
			</div>
			
			<form:form commandName="tablet" action="./addtablet" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul" >
						
						
							<li class="single_field">
								<label>Марка:</label>
								<form:input path="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" type="text"/>
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" type="text"/>
							</li>
							
							
							<li class="single_field">
								<label>Тип дисплей:</label>
								<form:input path="displayType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="cpu" type="text"/>
							</li>
							
							<li class="single_field">
								<label>Големина на екрана</label>
								<form:input path="displaySize" type="text"/>
							</li>
							<li class="single_field">
								<label>Резолюция</label>
								<form:input path="resolution" type="text"/>
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
			
			<form:form commandName="laptop" action="./addlaptop" method="post" id="laptopForm" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul">
						
						
							<li class="single_field">
								<label>Марка:</label>
								<form:input path="label" type="text"/>
								
							</li>
							<li class="single_field">
								<label>Модел:</label>
								<form:input path="model" type="text"/>
							
							</li>
							<li class="single_field">
								<label>Цена:</label>
								<form:input path="price" type="text"/>
							</li>
							<li class="single_field">
								<label>Оперативна памет (ГБ):</label>
								<form:input path="ram" type="text"/>
							</li>
							<li class="single_field">
								<label>Скорост на процесора:</label>
								<form:input path="processorSpeed" type="text"/>
							</li>
							<li class="single_field">
								<label>Вид операционна система:</label>
								<form:input path="operationSystem" type="text"/>
							</li>
							<li class="single_field">
								<label>HDD:</label>
								<form:input path="hdd" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип процесор:</label>
								<form:input path="processorType" type="text"/>
							</li>
							<li class="single_field">
								<label>Тип видео карта</label>
								<form:input path="videoCardType" type="text"/>
							</li>
						
							<li class="single_field">
								<label>Големина на екрана</label>
								<form:input path="displaySize" type="text"/>
							</li>
							<li class="single_field">
								<label>Резолюция</label>
								<form:input path="resolution" type="text"/>
							</li>
							
							<li >
								<label>Снимка</label>
						
									<input name="file" type="file"  id="laptopImage"  onchange="ValidateFileUploadLaptop()" />
							       	<img class="snimka" id="imageL" src="#" alt="Вашата снимка" style="width:220px;height:180px;" />
											
							</li>
				
							
							
							
							
					</ul>
						<button type="submit" value="Add new laptop" id="laptopBtn" class="btn btn-default update" >Добави</button>
						<h2 id="laptopWarning" style="display:none"><span>Моля качете валидна снимка, за да добавите артикул.</span></h2>
					
					</div>
				</div>
				
			</div>
			
			</form:form >
			
		</div>
		
		
	
	

	
	
	<script src="js/photoupload.js"></script>
	<script src="js/hideOrShow.js"></script>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>