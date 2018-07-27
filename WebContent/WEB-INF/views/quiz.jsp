<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz online</title>
</head>
<body>

	<form action="QuizController" method="post">
		
		<c:forEach items="${list_incomplate }" var="list">
			<p>${list.number } . ${list.question }</p>
			<input type="radio" name="ans[${list.number }]" value="A"/> ${list.option1 }
			<br />
			<input type="radio" name="ans[${list.number }]" value="B"/>  ${list.option2 }
			<br />
			<input type="radio" name="ans[${list.number }]" value="C"/> ${list.option3 }
			<br />
			<input type="radio" name="ans[${list.number }]" value="D"/> ${list.option4 }
			<br />
			
		</c:forEach>
		<input type="submit" value="tabscript" />
	</form>

</body>
</html>