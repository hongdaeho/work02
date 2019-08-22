<%@page contentType="text/html;charset=UTF-8"%>
<%@page session="false"%>

<html>
<head>
<title>Home</title>
</head>

<script src = "/resources/js/jquery-3.4.1.min.js"></script>
<script type = "text/javascript">

$(document).ready(function() {
	
	$('#listBtn').click( function() {

		$.get("/stg/list", function(data) {
			console.log(data);
			
			alert(JSON.stringify(data));
		});
		
		alert("list");	
    });
	
	$('#sumBtn').click( function() {
		
		$.get("/stg/sum", function(data) {
			
			console.log(data);
			alert(JSON.stringify(data));
		});
		 
		alert("sum");	
    });
	
	$('#maxBtn').click( function() {
		$.ajax({
	        type : 'get',
	        url : '/stg/max/',
	        data : {
	            input : $('#inputJson').val(),
	        },
	        success : function (data) {
	        	alert(JSON.stringify(data)); 
	        }
	    })
	    
	    alert("max");	
    
	})
	
	$('#minBtn').click( function() {
		$.get("/stg/min", function(data) {
			console.log(data);
			
			alert(JSON.stringify(data));
		});
		alert("min/max");	
    });
	
	$('#uploadBtn').click( function() {
		
		$.ajax({
    		url: '/stg/upload',
            type: 'POST', 
            success: function(result){
                
            } 
    	}); 
		alert("upload");
    }); 

});	
</script>

<body>
	<h1>Ajax Home</h1>

	<form>
	입력JSON:   <input type="text" name="inputJson" value ="" id="inputJson"><br><br>  

	<div>
	<button id ="uploadBtn" >파일업로드</button><br><br>  
	<button id ="listBtn">   리스트</button><br><br> 
	<button id ="sumBtn">    년도별 금액 합계</button><br><br> 
	<button id ="maxBtn">    가장 큰 금액 출력</button><br><br> 
	<button id ="minBtn">    외환은행 평균금액중 가장 작은값 큰값 출력</button>

	</div>
	</form>

 </form>
	

</body>



</html>