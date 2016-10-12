<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Shop | E-Shopper</title>
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
					<div class="col-sm-6 ">
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
							<a href="index.html"><img src="images/home/logo.png" alt="" /></a>
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
								
    							
    						<li><a ><i class="fa fa-user"></i>Добре дошъл ${sessionScope.username} !</a></li>	
    						<c:if test="${sessionScope.isAdmin == true}">	
    						<li><a href="addarticle"><i class="fa fa-shopping-cart"></i> Добави артикул</a></li>	
    						</c:if>							
								<li><a href="cart"><i class="fa fa-shopping-cart"></i> Количка</a></li>
								<li><a href="LogoutController"><i class="fa fa-lock"></i> Изход</a></li>
								</c:if>
								
							
							
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<!-- <!-- <div class="container">
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
						<div class="breadcrumbs">
							<ol class="breadcrumb">
								<li><a href="#">Начало</a></li>
								
							</ol>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Търсене"/>
						</div>
					</div>
				</div>
				</div>
			</div> --> 
	</header>
	
	<section id="advertisement">
		<div class="container">
			
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Категории</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#computers">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<b>Компютри и периферия</b>
										</a>
									</h4>
								</div>
								<div id="computers" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Компютри </a></li>
											<li><a href="">Лаптопи </a></li>
											<li><a href="">Монитори </a></li>
											<li><a href="">Клавиатури </a></li>
											<li><a href="">Мишки </a></li>
											<li><a href="">Уеб камери </a></li>
											
											
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#perifery">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<b>Телефони и таблети</b>
										</a>
									</h4>
								</div>
								<div id="perifery" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Телефони</a></li>
											<li><a href="">Таблети</a></li>
											
											
										</ul>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#accessories">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<b>Фотоапарати и камери</b>
										</a>
									</h4>
								</div>
								<div id="accessories" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Фотоапарати</a></li>
											<li><a href="">Камери</a></li>
											
										</ul>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#domakinski">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<b>Домакински електроуреди</b>
										</a>
									</h4>
								</div>
								<div id="domakinski" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Съдомиялни</a></li>
											<li><a href="">Перални</a></li>
											<li><a href="">Хладилници</a></li>
											
											
										</ul>
									</div>
								</div>
							</div>
							
						</div><!--/category-productsr-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Марки</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href=""> <span class="pull-right">(50)</span>Acer</a></li>
									<li><a href=""> <span class="pull-right">(56)</span>ASUS</a></li>
									<li><a href=""> <span class="pull-right">(27)</span>Lenovo</a></li>
									<li><a href=""> <span class="pull-right">(32)</span>Braun</a></li>
							
								</ul>
							</div>
						</div><!--/brands_products-->
						
						<div class="price-range"><!--price-range-->
							<h2>ЦЕНА</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="5000" data-slider-step="100" data-slider-value="[0,3000]" id="sl2" ><br />
								 <b>0 лв.</b> <b class="pull-right">5000 лв.</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Продукти</h2>
						
									
						<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Добави в количката</a>
						<ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
	<i class="fa fa-angle-up"></i>
	
	
	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
	
	
	
</body>
</html>