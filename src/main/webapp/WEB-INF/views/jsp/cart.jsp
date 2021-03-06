<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
  
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
    																						
								<li><a href="cart"><i class="fa fa-shopping-cart cart1"></i><span class="cart1"> Количка</span></a></li>
								<li><a href="login"><i class="fa fa-lock cart1"></i><span class="cart1">Вход</span></a></li>
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
							
								<a class="btn btn-default update" href="mainpage" style="position:absolute; left:-25px; top:-30px;">ПАЗАРУВАЙ</a>
							
						</div>
					</div>
					<div class="col-sm-3">
						
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	
<c:if test="${sessionScope.username != null}">
	<section id="cart_items">
		<div class="container">
			
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Продукти</td>
							<td class="description"></td>
							<td class="price">Цена</td>
							
							<td class="total">Премахни</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
					
					<c:forEach items="${sessionScope.cart}" var="article">
						<tr>
							<td class="cart_product">
								<img src="<c:out value="${article.image}"></c:out>" style="width:220px;height:180px;">
							</td>
							<td class="cart_description">
								<h4 class="labelmodel"><c:out value="${article.model}  ${article.label}"></c:out></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price cena">
								<p><c:out value="${article.price} лв"></c:out></p>
							</td>
							
							
							<td class="cart_delete">
								<button id="${article.id}" name="${article.type}" onclick="getIdAndRemove(this)" class="cart_quantity_delete" ><i class="fa fa-times"></i></button>
							</td>
						</tr>
						</c:forEach>
					
						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
</c:if>
	<section id="do_action">
	<c:if test="${sessionScope.username != null}">
		<div class="container">
			<div class="heading">
				<h3>За да осъществите поръчката, моля въведете лична информация и адрес за доставка!</h3>
				<!-- <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p> -->
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
						<ul class="user_info ul">
							<li class="single_field">
								<label>Име:</label>
								<input type="text">
								
							</li>
							<li class="single_field">
								<label>Фамилия:</label>
								<input type="text">
							
							</li>
							<li class="single_field">
								<label>Телефонен номер</label>
								<input type="text">
							</li>
						</ul>
						<ul class="user_info ul">
							<li class="single_field">
								<label>Страна:</label>
								<select>
									<option>България</option>
									
								</select>
								
							</li>
							<li class="single_field">
								<label>Град:</label>
								<select>
									<option>Избери</option>
									<option>София</option>
									<option>Пловдив</option>
									<option>Бургас</option>
									<option>Варна</option>
									<option>Габрово</option>
									<option>Видин</option>
									<option>Враца</option>
								</select>
							
							</li>
							<li class="single_field ">
								<label>Пощенски код:</label>
								<input type="text">
							</li>
						</ul>
						<!-- <a class="btn btn-default update" href="">Get Quotes</a>
						<a class="btn btn-default check_out" href="">Continue</a> -->
					</div>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul class="ul">
							<li>Количка:<span><c:out value="${sessionScope.carttotalprice} лв"></c:out></span></li>
							
							<li>Доставка:<span>Безплатна</span></li>
							<li>Общо:<span><c:out value="${sessionScope.carttotalprice} лв"></c:out></span></li>
						</ul>
							
							<form action="./checkout" method="post">
								<button type="submit" class="btn btn-default check_out"  class="pull-right" >Поръчай</button>
							</form>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		
		<c:if test="${sessionScope.username == null}">
		<div class="container">
		<div class="heading">
				<h3>За да ползвате количката и да осъществите поръчка, моля влезте в профила си или се регистрирайте.</h3>
				<!-- <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p> -->
			</div>
		</div>
		</c:if>
		
	</section><!--/#do_action-->
	<i class="fa fa-angle-up"></i>

	
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>