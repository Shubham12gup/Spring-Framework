<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WebApp</title>
	</head>
	<body>
		Welcome to Aliens World..........
		<form action="addAlien">
			Id:
			<input type="text" name="aid"><br>
			Name:		
			<input type="text" name="aname"><br>
			Tech:
			<input type="text" name="tech"><br>
			<input type="submit">			
		</form>
		
		<form action="getAlien">
			ID: 
			<input type="text" name="aid"><br>			
			<input type="submit">			
		</form>
		
		<form action="updateAlien">
			<input type="text" name="aid"><br>			
			<input type="text" name="aname"><br>
			<input type="submit" value="Update">			
		</form>
				
						
	</body>
</html>

	