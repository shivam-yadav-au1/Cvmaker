<%@ include file="/resource-bundles/directives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/resource-bundles/styles.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>


		<jsp:include page="/views/header.jsp"></jsp:include>
		
		<%-- <c:out value="Fragment Name:${fragmentName}"></c:out> --%>
		
		<c:if test="${fragmentName eq 'introduction'}">	
			<jsp:include page="/views/introduction_form.jsp"></jsp:include>
		</c:if>
		<c:if test="${fragmentName eq 'contact'}">
			<jsp:include page="/views/contact_form.jsp"></jsp:include>	
		</c:if>
		
		<c:if test="${fragmentName eq 'experience'}">
				<jsp:include page="/views/experience_form.jsp"></jsp:include>		
		</c:if>
	
		<c:if test="${fragmentName eq 'skill'}">
		
			<jsp:include page="/views/skill_form.jsp"></jsp:include>	
		</c:if>
	
	
	
	
	
</body>
</html>