$(document).ready(function() {

			$("#uomTypeError").hide();
			$("#uomModelError").hide();
			$("#descriptionError").hide();

			var uomTypeError = false;
			var uomModelError = false;
			var descriptionError = false;

			$("#uom_Type").change(function() {
				validate_uomtype();
			});

			$("#uom_Model").keyup(function() {
				validate_uommodel();
			});

			$("#description").keyup(function() {
				validate_description();
			});

			
			function validate_uomtype() {
				var val = $("#uom_Type").val();
				if (val == '') {
					$("#uomTypeError").show();
					$("#uomTypeError").html("Choose <b>Uom Type</b>");
					$("#uomTypeError").css("color", "red");
					uomTypeError = false;
				} else {
					$("#uomTypeError").hide();
					uomTypeError = true;
				}
				return uomTypeError;
			}

			
			function validate_uommodel() {
				var val = $("#uom_Model").val();

				if (val == '') {
					$("#uomModelError").show();
					$("#uomModelError").html("Enter <b>Uom Model</b>");
					$("#uomModelError").css("color", "red");
					uomModelError = false;
				} else {
					$("#uomModelError").hide();
					uomModelError = true;
				}
				return uomModelError;
			}

			
			function validate_description() {
				var val = $("#description").val();

				if (val == '') {
					$("#descriptionError").show();
					$("#descriptionError").html("Enter <b>Description</b>");
					$("#descriptionError").css("color", "red");
					descriptionError = false;
				} else {
					$("#descriptionError").hide();
					descriptionError = true;
				}
				return descriptionError;
			}

			
			$("#uom").submit(function() {
				validate_uomtype();
				validate_uommodel();
				validate_description();
				if (uomTypeError && uomModelError && descriptionError)
					return true;
				else
					return false;
			});
		});