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
    																						
								<li><a href="cart"><i class="fa fa-shopping-cart cart1"></i><span class="cart1">Количка</span></a></li>
								<li><a href="login"><i class="fa fa-lock cart1"></i> <span class="cart1">Вход</span></a></li>
							</c:if>
							
							<c:if test="${sessionScope.username != null}">
								
    							
    						<li><a ><i class="fa fa-user cart1"></i><span class="cart1">Добре дошъл ${sessionScope.username} !</span></a></li>	
    						<c:if test="${sessionScope.isAdmin == true}">	
    						<li><a href="addarticle"><i class="fa fa-shopping-cart car1"></i> <span class="cart1">Добави артикул</span></a></li>	
    						</c:if>							
								<li><a href="cart"><i class="fa fa-shopping-cart car1"></i> <span class="cart1">Количка</span></a></li>
								<li><a href="LogoutController"><i class="fa fa-lock car1"></i><span class="cart1"> Изход</span></a></li>
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
											<b class="categories">Компютри</b>
										</a>
									</h4>
								</div>
								<div id="computers" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="ul">
											<li ><a href="computers"> <span class="subcategories">Компютри </span></a></li>
											<li > <a href="laptops"><span class="subcategories">Лаптопи</span> </a></li>
											
											
											
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#perifery">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<b class="categories">Таблети</b>
										</a>
									</h4>
								</div>
								<div id="perifery" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="ul">
											
											<li ><a href="tablets"><span class="subcategories">Таблети</span></a></li>
											
											
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
						<c:choose>
						<c:when test="${ not empty computers}">
							<c:forEach items="${computers}" var="computer">
						<table>
						
							<tr><td class="labelmodel"><c:out value="Компютър ${computer.model}  ${computer.label}"></c:out></td></tr>
							
							<tr>
							<td><img src="<c:out value="${computer.image}"></c:out>" style="width:220px;height:180px;"></td> 
							<td class="tdharakteristiki"><p class="harakteristiki">ХАРАКТЕРИСТИКИ:</p>
								
								<ul >
									<li class="lisize"><span>RAM ПАМЕТ:</span> <span class="stoinosti"><c:out value="${computer.ram} GB"></c:out></span></li>
									<li class="lisize"><span>ТИП ПРОЦЕСОР:</span> <span class="stoinosti"><c:out value="${computer.processorType}"></c:out></span></li>
									<li class="lisize"><span>ЧЕСТОТА НА ПРОЦЕСОРА:</span> <span class="stoinosti"><c:out value="${computer.processorSpeed} GHz"></c:out></span></li>
									<li class="lisize"><span>ВИДЕО КАРТА:</span> <span class="stoinosti"><c:out value="${computer.videoCardType}"></c:out></span></li>
									<li class="lisize"><span>HDD:</span> <span class="stoinosti"><c:out value="${computer.hdd} GB"></c:out></span></li>
									<li class="lisize"><span>ОПЕРАЦИОННА СИСТЕМА:</span> <span class="stoinosti"><c:out value="${computer.operationSystem}"></c:out></span></li>
								
								</ul>
							</td>
							<td class="tdcena"><span class="cqlacena"> ЦЕНА:  <span class="cena"><c:out value="${computer.price} лв."></c:out></span></span>
							<br>
							<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Добави в количката</a>
							</td>
							
							
							</tr>
							
						</table>
						<hr>
					</c:forEach>
					</c:when>
					</c:choose>			
					
					<c:choose>
						<c:when test="${ not empty laptops}">
							<c:forEach items="${laptops}" var="laptop">
						<table>
						
							<tr><td class="labelmodel"><c:out value="Лаптоп ${laptop.model}  ${laptop.label}"></c:out></td></tr>
							
							<tr>
							<td><img src="<c:out value="${laptop.image}"></c:out>" style="width:220px;height:180px;"></td> 
							<td class="tdharakteristiki"><p class="harakteristiki">ХАРАКТЕРИСТИКИ:</p>
								
								<ul >
									<li class="lisize"><span>RAM ПАМЕТ:</span> <span class="stoinosti"><c:out value="${laptop.ram} GB"></c:out></span></li>
									<li class="lisize"><span>ТИП ПРОЦЕСОР:</span> <span class="stoinosti"><c:out value="${laptop.processorType}"></c:out></span></li>
									<li class="lisize"><span>ЧЕСТОТА НА ПРОЦЕСОРА:</span> <span class="stoinosti"><c:out value="${laptop.processorSpeed} GHz"></c:out></span></li>
									<li class="lisize"><span>ВИДЕО КАРТА:</span> <span class="stoinosti"><c:out value="${laptop.videoCardType}"></c:out></span></li>
									<li class="lisize"><span>HDD:</span> <span class="stoinosti"><c:out value="${laptop.hdd} GB"></c:out></span></li>
									<li class="lisize"><span>ОПЕРАЦИОННА СИСТЕМА:</span> <span class="stoinosti"><c:out value="${laptop.operationSystem}"></c:out></span></li>
									<li class="lisize"><span>ГОЛЕМИНА НА ЕКРАНА:</span> <span class="stoinosti"><c:out value='${laptop.displaySize} " '></c:out></span></li>
									<li class="lisize"><span>РЕЗОЛЮЦИЯ:</span> <span class="stoinosti"><c:out value="${laptop.resolution}"></c:out></span></li>
								
								</ul>
							</td>
							<td class="tdcena"><span class="cqlacena"> ЦЕНА:  <span class="cena"><c:out value="${laptop.price} лв."></c:out></span></span>
							<br>
							<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Добави в количката</a>
							</td>
							
							
							</tr>
							
						</table>
						<hr>
					</c:forEach>
					</c:when>
					</c:choose>		
					
					<c:choose>
						<c:when test="${ not empty tablets}">
							<c:forEach items="${tablets}" var="tablet">
						<table>
						
							<tr><td class="labelmodel"><c:out value="Таблет ${tablet.label} ${tablet.model}  "></c:out></td></tr>
							
							<tr>
							<td><img src="<c:out value="${tablet.image}"></c:out>" style="width:220px;height:180px;"></td> 
							<td class="tdharakteristiki"><p class="harakteristiki">ХАРАКТЕРИСТИКИ:</p>
								
								<ul >
									<li class="lisize"><span>ТИП ПРОЦЕСОР:</span> <span class="stoinosti"><c:out value="${tablet.cpu}"></c:out></span></li>
									<li class="lisize"><span>ТЕХНОЛОГИЯ НА ДИСПЛЕЯ:</span> <span class="stoinosti"><c:out value="${tablet.displayType}"></c:out></span></li>
									<li class="lisize"><span>РАЗМЕР НА ЕКРАНА:</span> <span class="stoinosti"><c:out value='${tablet.displaySize} "'></c:out></span></li>
									<li class="lisize"><span>РЕЗОЛЮЦИЯ НА ДИСПЛЕЯ:</span> <span class="stoinosti"><c:out value="${tablet.resolution}"></c:out></span></li>
									
								
								</ul>
							</td>
							<td class="tdcena"><span class="cqlacena"> ЦЕНА:  <span class="cena"><c:out value="${tablet.price} лв."></c:out></span></span>
							<br>
							<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Добави в количката</a>
							</td>
							
							
							</tr>
							
						</table>
						<hr>
					</c:forEach>
					</c:when>
					</c:choose>		
						
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