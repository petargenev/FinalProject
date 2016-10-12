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
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
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
    						<li><a ><i class="fa fa-user"></i>Добре дошъл ${sessionScope.username} !</a></li>										
								
								<li><a href="LogoutCartController"><i class="fa fa-lock"></i> Изход</a></li>
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
							<ul class="nav navbar-nav collapse navbar-collapse">
								<a class="btn btn-default update" href="index.html">ПАЗАРУВАЙ</a>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Продукти</td>
							<td class="description"></td>
							<td class="price">Цена</td>
							<td class="quantity">Брой</td>
							<td class="total">Премахни</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cart_product">
								<a href=""><img src="images/cart/one.png" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">Colorblock Scuba</a></h4>
								<p>Web ID: 1089772</p>
							</td>
							<td class="cart_price">
								<p>$59</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>

						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

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
						<ul class="user_info">
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
						<ul class="user_info">
							<li class="single_field">
								<label>Страна:</label>
								<select>
									<option>България</option>
									
									<option>Великобритания</option>
									
								</select>
								
							</li>
							<li class="single_field">
								<label>Град:</label>
								<select>
									<option>Select</option>
									<option>Dhaka</option>
									<option>London</option>
									<option>Dillih</option>
									<option>Lahore</option>
									<option>Alaska</option>
									<option>Canada</option>
									<option>Dubai</option>
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
						<ul>
							<li>Количка:<span>200 лв.</span></li>
							
							<li>Доставка:<span>Безплатна</span></li>
							<li>Общо: <span>200 лв.</span></li>
						</ul>
							
							<a class="btn btn-default check_out" href="" class="pull-right" >Поръчай</a>
							
					</div>
				</div>
			</div>
		</div>
		</c:if>
		
		<c:if test="${sessionScope.username == null}">
		<div class="container">
		<div class="heading">
				<h3>За да осъществите поръчката, моля впишете се в системата!</h3>
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