<%@page contentType="text/html;charset=UTF-8"%>
<%@page session="false"%>

<html>
<head>
<title>Home</title>
</head>

<script src = "/resources/js/jquery-3.4.1.min.js"></script>

<script type = "text/javascript">
$(document).ready(function() {
	
	$('#uploadBtn').click( function() {
		
		$.get('/stg' ,function(data) {
			console.log(data); 
			
			
			//alert("a");
			alert(JSON.stringify(data));
		});
		
		 

    });
	
	
	
	
});	
</script>

<body>
	<h1>UPLOAD</h1>
	<form>
	FILE UPLOAD:   <input type="file" name="inputFile" value ="" id="inputFile"><br>
	<!--   지역: 	   <input type="text" name="region" value ="" id="region"><br>
	프로그램이름 : <input type="text" name = "programNm" value= "" id="programNm"><br>
	프로그램테마 : <input type="text" name ="programTm" value ="" id="programTm"><br>
	프로그램소개 : <input type="text" name ="programCtt" value = "" id="programCtt"><br>
	-->
	
	
	<div>
	<button id ="uploadBtn">REGISTER</button>
	<button id ="backBtn">BACK</button>
	<!-- <button id ="listBtn">LIST</button>
	<button id ="readBtn">READ</button>
	-->
	
	</div>
	
	</form>

</body>



</html>