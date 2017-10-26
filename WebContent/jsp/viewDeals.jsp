<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<title>bloomberg</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon" href="images/favicon.png">

<!-- CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/flexslider.css" rel="stylesheet" type="text/css" />
<link href="css/prettyPhoto.css" rel="stylesheet" type="text/css" />
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!-- FONTS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

<!-- SCRIPTS -->
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if IE]><html class="ie" lang="en"> <![endif]-->

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
<script src="js/jquery.nicescroll.min.js" type="text/javascript"></script>
<script src="js/superfish.min.js" type="text/javascript"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
<script src="js/owl.carousel.js" type="text/javascript"></script>
<script src="js/animate.js" type="text/javascript"></script>
<script src="js/jquery.BlackAndWhite.js"></script>
<script src="js/myscript.js" type="text/javascript"></script>
<script>
	//PrettyPhoto
	jQuery(document).ready(function() {
		$("a[rel^='prettyPhoto']").prettyPhoto();
	});

	//BlackAndWhite
	$(window).load(function() {
		$('.client_img').BlackAndWhite({
			hoverEffect : true, // default true
			// set the path to BnWWorker.js for a superfast implementation
			webworkerPath : false,
			// for the images with a fluid width and height 
			responsive : true,
			// to invert the hover effect
			invertHoverEffect : false,
			// this option works only on the modern browsers ( on IE lower than 9 it remains always 1)
			intensity : 1,
			speed : { //this property could also be just speed: value for both fadeIn and fadeOut
				fadeIn : 300, // 200ms for fadeIn animations
				fadeOut : 300
			// 800ms for fadeOut animations
			},
			onImageReady : function(img) {
				// this callback gets executed anytime an image is converted
			}
		});
	});
</script>

</head>
<body>

	<!-- PRELOADER -->
	<img id="preloader" src="images/preloader.gif" alt="" />
	<!-- //PRELOADER -->
	<div class="preloader_hide">
		<!-- PAGE -->
		<div id="page">
			<!-- HEADER -->
			<header>
				<!-- MENU BLOCK -->
				<div class="menu_block">

					<!-- CONTAINER -->
					<div class="container clearfix">

						<!-- LOGO -->
						<div class="logo pull-left">
							<a href="#home"><span class="b1">b</span><span class="b1">l</span><span
								class="b1">o</span><span class="b1">o</span><span class="b1">m</span><span
								class="b1">b</span><span class="b1">e</span><span class="b1">r</span><span
								class="b1">g</span></a>
						</div>
						<!-- MENU -->
						<div class="pull-right">
							<nav class="navmenu center">
								<ul>
									<li class="first active scroll_btn"><a href="#home">Home</a></li>
									<!-- li class="scroll_btn"><a href="#about">About Us</a></li>
									<li class="scroll_btn"><a href="#about2">About Us 2</a></li-->
									<li class="sub-menu"><a href="javascript:void(0);">Deals</a>
										<ul>
											<li><a href="#uploadDeal">Upload Deal</a></li>
											<li><a href="#viewDeals">View Deals</a></li>
										</ul></li>
									<li class="first active scroll_btn"><a href="index.html">Logout</a></li>
								</ul>
							</nav>
						</div>
						<!-- //MENU -->
					</div>
					<!-- //MENU BLOCK -->
				</div>
				<!-- //CONTAINER -->
			</header>
			<!-- //HEADER -->
			<!-- HOME -->
			<section id="home" class="padbot0">
				<!-- TOP SLIDER -->
				<div class="flexslider top_slider">
					<ul class="slides">
						<li class="slide1">
							<div class="flex_caption1">
								<p class="title1 captionDelay2 FromTop">Upload Deal</p>
							</div> <!--a class="slide_btn FromRight" href="javascript:void(0);" >Read More</a-->
						<li class="slide2">
							<div class="flex_caption1">
								<p class="title1 captionDelay6 FromLeft">View Deals</p>
							</div>
						</li>
					</ul>
				</div>
				<!-- //TOP SLIDER -->
			</section>
			<!-- //HOME -->
			<br /><br />
			<!-- PROJECTS -->
			<section id="uploadDeal" class="padbot20">
				<div class="container">
					<h2>
						<b>Upload</b> Deal
					</h2>
					<br /> <br /> <br /> <br />
					<form action="addDeal.do" method="post"
						enctype="multipart/form-data">
						<input type="file" name="file" size="50" /> <br /> <input
							type="submit" value="Upload" />
					</form>
					<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
					<br /> <br /> <br /> <br /> <br />
				</div>
			</section>
		</div>
	</div>
</body>
</html>