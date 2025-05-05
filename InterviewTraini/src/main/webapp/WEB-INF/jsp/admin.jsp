<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
	</head>
	<body>
		<div class="admin_body">
			<div class="admin_h">
				<h2 id="admin_h1"><b>Add Content</b></h2>
			</div>
			<div class="adding">
				<textarea name="question" id="question" placeholder="Question" rows="3" cols="100"></textarea><br>
				<textarea name="answer" id="answer" placeholder="Answer" rows="5" cols="100"></textarea><br>
				<select name="title" id="title">
					<option value="" disabled selected>Select Title</option>
					<option value="Java Basic Questions">Java Basic Questions</option>
					<option value="OOPs">OOPs</option>
					<option value="DSA">DSA</option>
					<option value="Coding">Coding</option>
					<option value="DBMS">DBMS</option>
					<option value="SQL Queries">SQL Queries</option>
					<option value="HR Questions">HR Questions</option>
				</select>
				<input type="file" name="image" id="image" value="Add Picture">
				<button type="submit" id="admin_submit_button" >ADD</button>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
		$(document).ready(function() {
	         function add() {
	        	 let question=$("#question").val();
	        	 let answer=$("#answer").val();
	        	 let title=$("#title").val();
	        	 let image=$("#image")[0].files[0];

	    		 if (question === "" || answer === "" || title == "") {
	                 alert("Question, Answer & Title must be filled out.");
	                 return;
	             }
	    		 
	    	     // Create a FormData object
	    	     let formData = new FormData();
	    	     formData.append("question", question);
	    	     formData.append("answer", answer);
	    	     formData.append("title", title);
	    	     formData.append("file", image);
	    		 
	             $.ajax({
	                 url: 'http://localhost:8082/InterviewTraini/add-new',
	                 type: 'post',
	                 data: formData,
	                 processData: false, // Prevent jQuery from processing the data
	                 contentType: false, // Prevent jQuery from setting the content type
	                 success: function(response) {
	                     alert("Question posted successfully.");
	                     $("#question").val('');
	                     $("#answer").val('');
	                     $("#title").val('');
	                     $("#image").val('');
	                 },
	                 error: function() {
	                	 alert("Please try again something went wrong.");
	                 }
	             });
	         }

	         // Attach the admin function to the onclick event of the user_icon image
	         $('#admin_submit_button').on('click', add);
	     });
		</script>
	</body>
</html>