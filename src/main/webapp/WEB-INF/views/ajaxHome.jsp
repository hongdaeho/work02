<%@page contentType="text/html;charset=UTF-8"%>
<%@page session="false"%>

<html>
<head>
<title>Home</title>
</head>

<script src = "/resources/js/jquery-3.4.1.min.js"></script>
java.io.FileNotFoundException
<script type = "text/javascript">





function uploadFile(){
    var form = $('#FILE_FORM')[0];
    var formData = new FormData(form);
    formData.append("fileObj", $("#FILE_TAG")[0].files[0]);
    //formData.append("fileObj2", $("#FILE_TAG2")[0].files[0]);
    
     alert( $("#FILE_TAG").val() ); 
    

    $.ajax({
        		url: '/stg/upload',
                processData: false,
                contentType: false, 
                data: formData,
                type: 'POST', 
                success: function(result){
                    alert("업로드 성공!!");
                }
        }); 
    
    alert("upload");
}



$(document).ready(function() {
	
	$('#sendBtn').click( function() {
		
		$.get('/stg' ,function(data) {
			console.log(data); 
			
			
			//alert("a");
			alert(JSON.stringify(data));
		});
		
		 

    });
	
	$('#uploadBtn').click( function() {
		
		location.href = '/fileUpload'; 

    });
	
	 
	

	
	
	$('#listBtn').click( function() {
		$.get('/boards' ,function(data) {
			console.log(data); 
			
			
			//alert("a");
			alert(JSON.stringify(data));
		});

    });
	
	$('#readBtn').on('click', function() {
		var boardNo = $("#boardNo");
		var boardNoVal = boardNo.val();
		 
		console.log(boardNoVal);
		
		$.get('/boards/' +boardNoVal , function(data)  {
			console.log(data);
			
			alert(JSON.stringify(data));
		});
		
	});
	
	
});	
</script>

<body>
	<h1>Ajax Home</h1>
	<form>
	입력JSON:   <input type="text" name="inputJson" value ="" id="inputJson"><br>
	
	


	
	<!--   지역: 	   <input type="text" name="region" value ="" id="region"><br>
	프로그램이름 : <input type="text" name = "programNm" value= "" id="programNm"><br>
	프로그램테마 : <input type="text" name ="programTm" value ="" id="programTm"><br>
	프로그램소개 : <input type="text" name ="programCtt" value = "" id="programCtt"><br>
	-->

	<div>
	<button id ="sendBtn">SEND</button>
	<button id ="uploadBtn">UPLOAD</button>
	<!-- <button id ="listBtn">LIST</button>
	<button id ="readBtn">READ</button>
	-->
	</div>
	</form>

 <form id="FILE_FORM" method="POST" enctype="multipart/form-data" action="">
            <input type="file" id="FILE_TAG" name="FILE_TAG">
            <!-- <input type="file" id="FILE_TAG2" name="FILE_TAG2">  -->
            <a class="ui-shadow ui-btn ui-corner-all" href="javascript:uploadFile();">전송</a>
 </form>
	

</body>



</html>