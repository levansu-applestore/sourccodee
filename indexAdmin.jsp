<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Trang Chủ</title>
<script type="text/javascript" src="js/prevent.js"></script>

</head>
<body
	style="background: url(images/bann.jpg) fixed; font-size: 12px !important;">
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("404.jsp");
		}
	%>
	<section id="container" class="">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="menu.jsp"></jsp:include>
		<jsp:include page="conten.jsp"></jsp:include>
	</section>
</body>
</html>
