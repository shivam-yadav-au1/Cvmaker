<%@ include file="/resource-bundles/directives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/resource-bundles/styles.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<div id="message">

 	 <ul>
	 	<c:forEach items="${messages}" var="message">
	 		<li>${message}</li>
		</c:forEach>
	</ul> 
</div>

<jsp:include page="/views/header.jsp"></jsp:include>



			
 			<div class="main-container">
 			
 			
 				<!-- Form container Start-->
					<form action="${pageContext.request.contextPath}/formServlet" method="get">
							
							<jsp:include page="/views/introduction_form.jsp"></jsp:include>
							
							<jsp:include page="/views/contact_form.jsp"></jsp:include>
							
							<jsp:include page="/views/experience_form.jsp"></jsp:include>
							
							<jsp:include page="/views/skill_form.jsp"></jsp:include>
							
							<!--  Button Container -->
							
							<div class="button-container">
							
								<!-- <input type="submit" class="btn btn-primary" name="action" value="Add More"> -->
								<input  class="btn btn-primary" type="submit" name="action" value="Submit">
								
							</div> 
							
							<!-- Button container End-->
						
					</form>
				<!-- Form container End-->
			</div>
</body>
</html>