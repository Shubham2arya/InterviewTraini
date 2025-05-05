<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="icon" type="image/x-icon" href="../images/logo1_rounded.png">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
	</head>
	<body class="body">
 <div class="main_body">
		<div class="head1">
			<div class="icon">
				<img src="../images/logo1.png" name="icon">
			</div>
			<div class="web_name">
				<img src="../images/InterviewTraini.png" name="it">
			</div>
			<div class="admin">
				<img src="../images/user_icon.png" name="user_icon" Onclick="admin">
			</div>
		</div>
		<div class="header">
			<button id="header_button" Onclick=""><b> Java Basics Questions </b></button>
			<button id="header_button" Onclick=""><b> OOPs </b></button>
			<button id="header_button" Onclick=""><b> DSA </b></button>
			<button id="header_button" Onclick=""><b> Coding </b></button>
			<button id="header_button" Onclick=""><b> DBMS </b></button>
			<button id="header_button" Onclick=""><b> SQL Queries </b></button>
			<button id="header_button" Onclick=""><b> HR Questions </b></button>
		</div>
		<div class="lower_body">
			<div class="left_part">
				
			</div>
			<div class="right_body" id="right_body">
				
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	 $(document).ready(function() {
         function admin() {
             $.ajax({
                 url: 'http://localhost:8808/InterviewTraini/login',
                 type: 'get',
                 data: {},
                 success: function(response) {
                     var responseData=response;
                     $('#right_body').html(responseData);
                 },
                 error: function() {
                     alert("Oops! Something Went Wrong, Try again.");
                 }
             });
         }

         // Attach the admin function to the onclick event of the user_icon image
         $('img[name="user_icon"]').on('click', admin);
     });
	</script>
</body>

</html>