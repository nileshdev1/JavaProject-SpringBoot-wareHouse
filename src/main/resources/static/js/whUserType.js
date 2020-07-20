$(document).ready(function(){

    
	  $("#userTypeError").hide();
	  $("#userCodeError").hide();
	  $("#userEmailError").hide();
	  $("#userContectError").hide();
	  $("#idTypeError").hide();
	  $("#idNumError").hide();

	  var userTypeError = false;
	  var userCodeError = false;
	  var userMailError = false;
	  var userContectError = false;
	  var idTypeError = false;
	  var idNumError = false;

	  $('input[type="radio"][name="user_type"]').change(function(){
		     validate_userType();
			 autoFill_userFor();
		  });
		  $("#user_Code").keyup(function(){
		     validate_userCode();
		  });

		  $("#user_Email").keyup(function(){
			 validate_userEmail();
		  });

		  $("#user_Contact").keyup(function(){
			  validate_userContect();
		  });

		  $("#user_id_type").change(function(){
		    validate_userIdType();
		  });

		  $("#id_Number").keyup(function(){
		    validate_idNumber();
		  });

		  function autoFill_userFor(){
			     var val=$('input[type="radio"][name="user_type"]:checked').val();
				 if(val=='vendor'){
				   $("#user_For").val("Purchase");
				   $("#user_For").css("color","blue");
				 }else if(val=='customer'){
			  	   $("#user_For").val("Sale");
			   	   $("#user_For").css("color","green");
				 }
			  }

		  function validate_userType(){
			    var val=$('input[type="radio"][name="user_type"]:checked').length;
				//if one radio button is selected then length=1 else length is zero
				if(val==0){
				  $("#userTypeError").show();
			  	  $("#userTypeError").html("Please choose <b>User Type</b>");
			 	  $("#userTypeError").css("color","red");
				  userTypeError = false;
				}else{
				  $("#userTypeError").hide();
				  userTypeError = true;
				}
			    return userTypeError;
			  }

		  function validate_userCode(){``
			    var val=$("#user_Code").val();
				var exp=/^[A-Z]{2,8}$/;
			    if(val==''){
				  $("#userCodeError").show();
				  $("#userCodeError").html("Enter <b>User Code</b>");
			   	  $("#userCodeError").css("color","red");
				  userCodeError = false;
				}else if(!exp.test(val)) {
				  $("#userCodeError").show();
				  $("#userCodeError").html("Enter <b>Upper Case (2-8)</b> letters only");
			   	  $("#userCodeError").css("color","red");
				  userCodeError = false;
				}else{
				  $("#userCodeError").hide();
				  userCodeError = true;
				}
			    return userCodeError;
			  }

		  function validate_userEmail(){
			     var val=$("#user_Email").val();
			     var exp=/^[a-zA-Z0-9-_]+\@[a-zA-Z]{2,8}\.[a-z]{2,6}$/;
				 if(val==''){
				   $("#userEmailError").show();
			       $("#userEmailError").html("Enter <b> User Mail</b>");
				   $("#userEmailError").css("color","red");
				   userEmailError = false;
				 }else if(!exp.test(val)){
				   $("#userEmailError").show();
			       $("#userEmailError").html("Not a Valid <b> User Mail</b>");
				   $("#userEmailError").css("color","red");
				   userMailError = false;
				 
				 }else{
			  	   $("#userEmailError").hide();
				    userMailError = true;
			         
				 }
			     return userMailError;
			  }

		  function validate_userContect(){
			    var val = $("#user_Contact").val();
				if(val == ''){
				   $("#userContectError").show();
				   $("#userContectError").html("Enter <b>User Contact</b>");
				   $("#userContectError").css("color","red");
				   userContectError = false;
				
				}else{
				   $("#userContectError").hide();
				   userContectError = true;
				}
			     return userContectError;
			  }

		  function validate_userIdType(){
			    var val = $("#user_id_type").val();
				if(val==''){
				  $("#idTypeError").show();
				  $("#idTypeError").html("Choose <b>ID Type </b>");
			  	  $("#idTypeError").css("color","red");
				  idTypeError = false;
				}else{
			      $("#idTypeError").hide();
				  idTypeError = true;

				  if(val=='other') {
                    $("#other_id").attr("readonly",false);
				  }else{
				    $("#other_id").val(''); 
				    $("#other_id").attr("readonly",true);
				  }
				}
				return idTypeError;
			  }
		  function validate_idNumber(){
			     var val= $("#id_Number").val();
				 if(val == ''){
				   $("#idNumError").show();
			 	   $("#idNumError").html("Enter <b>ID Number</b>");
			  	   $("#idNumError").css("color","red");
			  	 idNumError = false;
				 
				 }else{
				   $("#idNumError").hide();
				   idNumError = true;
				 }
				 return idNumError;
			   }


		  $("#whuser1").submit(function(){
		       	userTypeError = false;
				userCodeError = false;
		        userEmailError = false;
		        userContectError = false;
		        idTypeError = false;
		        idNumError = false;

				validate_userType();
		        validate_userCode();
				validate_userEmail();
				validate_userContect();
				validate_userIdType();
				validate_idNumber();

				if(userTypeError && userCodeError && userContectError
				   && idTypeError && idNumError)
				  return true;
		        else 
				  return false;

			});
			   
});

