$(document).ready(function(){

		$("#shipModeError").hide();
		$("#shipCodeError").hide();
		$("#enbShipError").hide();
		$("#shipGradeError").hide();
		$("#descError").hide();

		var shipModeError =false;
		var shipCodeError =false;
		var enbShipError =false;
		var shipGradeError =false;
		var descError =false;

		$("#shipment_Mode").change(function(){
			validate_shipMode();
		});
		$("#shipment_Code").keyup(function(){
			validate_shipCode();
		});
		$("#enb_Shipment").change(function(){
			validate_enbShip();
		});
		$('input[type="radio"][name="shipment_Grade"]').change(function(){
			validate_shipGrade();
		});
		$("#discription").keyup(function(){
			validate_desc();
		});

		
		function validate_shipMode(){
			var val=$("#shipment_Mode").val();
			if( val == ''){
				$("#shipModeError").show();
				$("#shipModeError").html("Select <b>Shipment Mode</b>");
				$("#shipModeError").css("color","red");
				shipModeError= false;
			}
			else{
				$("#shipModeError").hide();
				shipModeError =true;
		}
			return shipModeError;
		}

		function validate_shipCode(){
			var val=$("#shipment_Code").val();
			if(val==''){
				$("#shipCodeError").show();
				$("#shipCodeError").html("Enter <b>Shipment Code</b>");
				$("#shipCodeError").css("color","red");
				shipCodeError= false;
			}
			else{
				$("#shipCodeError").hide();
				shipCodeError =true;
		}
			return shipCodeError;
		}

		function validate_enbShip(){
			var val=$("#enb_Shipment").val();
			if(val == ''){
				$("#enbShipError").show();
				$("#enbShipError").html("Select <b>Enable Shipment</b>");
				$("#enbShipError").css("color","red");
				enbShipError= false;
			}
			else{
				$("#enbShipError").hide();
				enbShipError =true;
		    }
			return enbShipError;
		}

		function validate_shipGrade(){
			var val=$('input[type="radio"][name="shipment_Grade"]:checked').length;
			if(val==0){
				$("#shipGradeError").show();
				$("#shipGradeError").html("Select <b>Shipment Grade</b>");
				$("#shipGradeError").css("color","red");
				shipGradeError= false;
			}
			else{
				$("#shipGradeError").hide();
				shipGradeError =true;
		}
			return shipGradeError;
		}

		function validate_desc(){
			var val=$("#discription").val();
			if(val==''){
				$("#descError").show();
				$("#descError").html("Enter <b>Description</b>");
				$("#descError").css("color","red");
				descError= false;
			}
			else{
				$("#descError").hide();
				descError =true;
		}
			return descError;
		}


		$("#shipment").submit(function(){
			shipModeError =false;
			shipCodeError= false;
			enbShipError= false;
			shipGradeError= false;
			descError= false;

			validate_shipMode();
			validate_shipCode()
			validate_enbShip();
			validate_shipGrade();
			validate_desc();

			if(shipModeError && shipCodeError && enbShipError && shipGradeError && descError)
				return true;
			else
				return false;
		});

	});