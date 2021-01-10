<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Đăng Nhập</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="js/prevent.js"></script>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Meta tag Keywords -->
        <!-- css files -->
        <link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
        <!-- //css files -->
        <!-- web-fonts -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700" rel="stylesheet">
        <!-- //web-fonts -->
        <style>
            input[type=button]
            {
                opacity: 0.7;
                margin-left: 107px;
                margin-bottom: 20px;
                background-color: rgba(0, 0, 0, 0.34);
                color: white;
                font-size: 30px;
                cursor: pointer;
                margin-top: 31px;
                transition: 0.5s ease;
            }
            .header-w3l
            {
                color: #fff;
                letter-spacing: 9px;
                text-shadow: 4px 4px 3px #000;
                word-spacing: 4px;
                font-weight: 500;
                font-family: 'Josefin Slab', serif;
                margin: 1.7em 0 1em;
                font-size: 20px;
                margin-left: 336px;
            }
            input[type=button]:hover
            {
                animation: swing 1s ease;
                border-color: #00c6d7;
                box-shadow: 0 10px 6px -6px #777;
                color: #00c6d7;
            }
            
        </style>
        <script type='text/javascript' src='js/jquery-3.3.1.js'></script>
        <script type='text/javascript'>

            $(document).ready(function ()
            {
                $("#class_login_hide").hide();
                $("#login").click(function ()
                {
                    $("#class_register_hide").hide();
                    $("#class_login_hide").fadeToggle(1999);
                });
                $("#class_register_hide").hide();
                $("#register").click(function ()
                {
                    $("#class_login_hide").hide();
                    $("#class_register_hide").fadeToggle(1999);
                });

            });
            
        </script>
    </head>
    <body>
        <!--header-->
        <div class="header-w3l">
            <h1 style="margin-right: 300px">Web Site Nội Bộ</h1>
            <div style="margin-left: 200px">
            	 <h3>Nơi Quản Lý Nhân Sự Và Tiền Lương</h3>
            	<input id="register"  type="button" style="margin-left: 210px" value="Quên Mật Khẩu" />
            	
            </div>
           
            <% String err = (String) request.getAttribute("error");
                if (err != null) {%>
            <div>
                <p style="color:red;"><span style="margin-left:285px;"><%out.print(err); %></span></p>
            </div> 
            <% }%>
        </div>
        <div id="class_register_hide" style="position: absolute;margin-left: 552px;display:none;" name="register" class="main-w3layouts-agileinfo">
            <div class="wthree-form">
                <h2>Điền Thông Tin Tài Khoản</h2>
                <form name="hide_form" action="XuLyDangXuat" method="post">
                    <div class="form-sub-w3">
                        <input type="text" name="username" placeholder="Tên Đăng Nhập " required />
                        <div class="icon-w3">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="form-sub-w3">
                        <input type="password" name="userP" placeholder="Mật Khẩu Mới" required />
                        <input type="password" name="retype" placeholder="Nhập Lại Mật Khẩu" required/>
                        <div class="icon-w3">
                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="submit-agileits">
                        <input type="submit" value="Reset">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--//main-->
</body>
</html>