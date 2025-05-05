<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
	</head>
	<body>
		<div class="login_mainbody">
			<div class="admin_login">
				<h2 id="admin_login_h1">Admin Login</h2>
			</div>
			<div class="login">
				<input type="text" placeholder="email" id="admin_email" name="admin_email" required><br>
				<input type="password" placeholder="password" id="admin_pass" name="admin_pass" required><br>
				<button type="submit" id="submit_button" >Login</button>
			</div>
		</div>
		
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	 $(document).ready(function() {
         function submit() {
        	 let email=$("#admin_email").val();
    		 let password=$("#admin_pass").val();
    		 console.log(email);
    		 console.log(password);
    		 if (email === "" || password === "") {
                 alert("Both email and password must be filled out.");
                 return;
             }
             $.ajax({
                 url: 'http://localhost:8082/InterviewTraini/admin',
                 type: 'get',
                 data: {email:email, password:password},
                 success: function(response) {
                     var responseData=response;
                     if(responseData==false){
                    	 alert("Both email and password must be filled out.");
                         return;
                     }
                     if(responseData=="NoData"){
                    	 alert("No Admin found...");
                         return;
                     }
                     $('#right_body').html(responseData);
                 },
                 error: function() {
                	 alert("Wrong email and password.");
                 }
             });
         }

         // Attach the admin function to the onclick event of the user_icon image
         $('#submit_button').on('click', submit);
     });
	</script>
	</body>
</html>