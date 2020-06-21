$(document).ready(function(){

    $("#orderModeError").hide();
    $("#orderCodeError").hide();
    $("#orderMrthodError").hide();
    $("#orderAcceptError").hide();
    $("#descriptionError").hide();
    
    var orderModeError= false;
    var orderCodeError= false;
    var orderMrthodError= false;
    var orderAcceptError= false;
    var descriptionError= false; 

    $('input[type="radio"][name="orderMode"]').change(function(){
        validate_orderMode();
    });
    $("#order_Code").keyup(function(){
        validate_orderCode();
    });
    $("#order_Method").keyup(function(){
        validate_orderMethod();
    });
    $('input[type="checkbox"][name="order_Accept"]').change(function(){
        validate_orderAccept();
    });
    $("#description").keyup(function(){
        validate_description();
    });

    function  validate_orderMode(){
        var len = $('input[type="radio"][name="order_Mode"]:checked').length;
        if(len == 0){
            $("#orderModeError").show();
            $("#orderModeError").html("Select <b>Order Mode</b>");
            $("#orderModeError").css("color","red");
            orderModeError= false;
        }
        else{
            $("#orderModeError").hide();
            orderModeError =true;
    }
        return orderModeError;

    }

    
	function validate_orderCode(){
		var val=$("#order_Code").val();
		if(val==''){
			$("#orderCodeError").show();
			$("#orderCodeError").html("Enter <b>Order Code</b>");
			$("#orderCodeError").css("color","red");
			orderCodeError= false;
			}
		else{
			$("#orderCodeError").hide();
			orderCodeError =true;
		}
		return orderCodeError;
		}
    
    
	function validate_orderMethod(){
		var val=$("#order_Method").val();
		if(val==''){
			$("#orderMrthodError").show();
			$("#orderMrthodError").html("Select <b>Order Method</b>");
			$("#orderMrthodError").css("color","red");
			orderMrthodError= false;
		}
		else{
			$("#orderMrthodError").hide();
			orderMrthodError =true;
		}
		return orderMrthodError;
        }
        
    
    
	function validate_orderAccept(){
		var len=$('input[type="checkbox"][name="order_Accept"]').length;
		if(len ==''){
			$("#orderAcceptError").show();
			$("#orderAcceptError").html("Check <b>Order Accept</b>");
			$("#orderAcceptError").css("color","red");
			orderAcceptError= false;
		}
		else{
			$("#orderAcceptError").hide();
			orderAcceptError =true;
		}
		return orderAcceptError;
		}


    
	function validate_description(){
		var val=$("#description").val();
		if(val==''){
			$("#descriptionError").show();
			$("#descriptionError").html("Enter <b>Description</b>");
			$("#descriptionError").css("color","red");
			descriptionError= false;
			}
		else{
			$("#descriptionError").hide();
			descriptionError =true;
		}
		return descriptionError;
        }
        

    $("#orderMethod").click(function(){

        orderModeError= false;
        orderCodeError= false;
        orderMrthodError= false;
        orderAcceptError= false;
        descriptionError= false; 

        validate_orderMode();
        validate_orderCode();
        validate_orderMethod();
        validate_orderAccept();
        validate_description();
        
        if(orderModeError && orderCodeError && orderMrthodError && orderAcceptError && descriptionError)
            return true;
        else
            return false;
    })
});