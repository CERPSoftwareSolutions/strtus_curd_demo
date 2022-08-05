(function () {
	'use strict'

	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.querySelectorAll('.new-added-form')

	// Loop over them and prevent submission
	Array.prototype.slice.call(forms).forEach(function (form) {
		form.addEventListener('submit', function (event) {
			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
			}else{
				var formdata = $('#formId')[0];
				var data = new FormData(formdata);

				$.ajax({
					type : "POST",
					enctype: 'multipart/form-data',
					url : "savestudent.do",
					data : data,
					async: false,
					cache: false,
					contentType: false,
					processData: false,
					success : function(data) {
						var result = $.parseJSON(data);
						$('body,html').animate({scrollTop:0},800);
						if(result.status == "save"){
							$(".notification,.alert-danger").hide();
							$(".notification,.alert-success").show();
							$(".alert-success .message").text("Adding Record Processing...");
							setTimeout(function() {
								$(".notification").fadeOut();
							},3000);
						}else if(result.status == "update"){
							$(".notification,.alert-danger").hide();
							$(".notification,.alert-success").show();
							$(".alert-success .message").text("Updating Record Processing...");
							setTimeout(function() {
								$(".notification").fadeOut();
							},3000);
						}else{
							$(".notification,.alert-success").hide();
							$(".notification,.alert-danger").show();
							$(".alert-danger .message").text("Failed, Please try again later.");
							setTimeout(function() {
								$(".notification").fadeOut();
							},3000);
						}
						setTimeout(function() {
							$('.nav-tabs a[href="#viewall"]').tab('show');
							$(".new-added-form").removeClass("was-validated");
							$(".form-control").css({'border':'1px solid #cccccc'});
							studentRegistrationList();
						}, 2000);
					}
				});
				event.preventDefault()
			}

			form.classList.add('was-validated')
		}, false)
	})
	
	var inactiveform = document.querySelectorAll('#inactiveform')

	// Loop over them and prevent submission
	Array.prototype.slice.call(inactiveform)
	.forEach(function (form) {
		form.addEventListener('submit', function (event) {
			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
			}else{
				$.ajax({
					type : "POST",
					url : "deletestudent.do",
					data : {"remarks":$("#remarks").val(),"primaryId":$(".activeId").val()},
					async : false,
					success : function(data) {
						var result = $.parseJSON(data);
						$('#inactivemodal').modal('toggle');
						$('body,html').animate({scrollTop:0},800);
						if(result.status == "success"){
							$(".notification,.alert-danger").hide();
							$(".notification,.alert-success").show();
							$(".alert-success .message").text("Deleting Record Processing...");
							setTimeout(function() {
								$(".notification").fadeOut();
							},3000);
						}else{
							$(".notification,.alert-success").hide();
							$(".notification,.alert-danger").show();
							$(".alert-danger .message").text("Failed, Please try again later.");
							setTimeout(function() {
								$(".notification").fadeOut();
							},3000);
						}
						
						setTimeout(function() {
							$('.nav-tabs a[href="#viewall"]').tab('show');
							$(".new-added-form").removeClass("was-validated");
							$(".form-control").css({'border':'1px solid #cccccc'});
							studentRegistrationList();
						}, 3000);
					}
				});
				event.preventDefault()
			}

			form.classList.add('was-validated')
		}, false)
	})

})()

/*validation start*/
document.querySelector('#admissionno').addEventListener('blur',validateAdmissionNo);
document.querySelector('#admissiondate').addEventListener('blur',validateAdmissionDate);
document.querySelector('#firstname').addEventListener('blur',validateFirstName);
document.querySelector('#lastname').addEventListener('blur',validateLastName);
document.querySelector('#dob').addEventListener('blur',validateDateOfBirth);
document.querySelector('#studentmobileno').addEventListener('blur',validateStudentMobileNo);
document.querySelector('#studentemailid').addEventListener('blur',validateStudentEmailId);
document.querySelector('#fathername').addEventListener('blur',validateFatherName);
document.querySelector('#fathermobileno').addEventListener('blur',validateFatherMobileNo);
document.querySelector('#mothername').addEventListener('blur',validateMotherName);
document.querySelector('#mothermobileno').addEventListener('blur',validateMotherMobileNo);
document.querySelector('#guardianname').addEventListener('blur',validateGuardianName);
document.querySelector('#guardianmobileno').addEventListener('blur',validateGuardianMobileNo);
/*validation end*/

$(document).ready(function() {
	//View All 
	studentRegistrationList();
	
	//Add New
	$('#admissiondate,#dob').datepicker({
		dateFormat : "dd-mm-yy",
	});
	
	$(".reset").click(function(){
		$(".save").text("Save");
		$(".reset").text("Reset");
		$("#add").text("Add New");
		$(".form-control").removeClass("is-invalid");
	});
	
	$("#sameaddress").click(function(){
		if($(this).prop("checked") == true){
			var postadd=$('#address').val();

			if(postadd != ""){
				$('#presentaddress').val(postadd);
			}else{
				$('#sameaddress').prop("checked",false) ;
			}
		}else{
			$('#presentaddress').val('');
		}
	});
});

function validateAdmissionNo(){
	const admissionno=document.querySelector('#admissionno');
	var expression =  /^[ A-Za-z0-9_/-_@./#&/+-]*$/;
	var flag=false;
	if(admissionno.value != ""){
		if(expression.test(admissionno.value)){
			admissionno.style.borderColor="#28a745";
			admissionno.classList.remove('is-invalid');
			flag=true;
		}else{
			admissionno.classList.add('is-invalid');
			admissionno.style.borderColor="#dc3545";
			$("#aadmissionno").text("Please provide a valid admissionno");
			flag=false;
		}
		
		if(flag){
			if($("#hadmissionno").val() == $("#admissionno").val()){
				admissionno.classList.remove('is-invalid');
				admissionno.style.borderColor="#28a745";
				flag=true;
			}else{
				$.ajax({
					type: 'post', 
					url: 'student.do?method=validateAdmissionNo', 
					data: {"admissionno":$("#admissionno").val(),"locationId":$("#locationId").val(),}, 
					async : false,
					success: function (data) {
						var result = $.parseJSON(data);
						if (result.status == "success") {
							admissionno.classList.add('is-invalid');
							admissionno.style.borderColor="#dc3545";
							$("#aadmissionno").text("Admissionno already exist");
							flag=false;
						}else{
							admissionno.style.borderColor="#28a745";
							admissionno.classList.remove('is-invalid');
							flag=true;
						}
					}
				});
			}
		}
	}else{
		admissionno.classList.remove('is-invalid');
		$("#admissionno").removeAttr("style");
	}
	return flag;
}

function validateAdmissionDate(){
    const admissiondate=document.querySelector('#admissiondate');
	
	var date_regex = /^(0[1-9]|1\d|2\d|3[01])\-(0[1-9]|1[0-2])\-(19|20)\d{2}$/;
	
	var flag=false;
	if(admissiondate.value != ""){
		if(date_regex.test(admissiondate.value)){
			admissiondate.style.borderColor="#28a745";
			admissiondate.classList.remove('is-invalid');
			flag=true;
		}else{
			admissiondate.classList.add('is-invalid');
			admissiondate.style.borderColor="#dc3545";
			$("#aadmissiondate").text("Please provide a valid admissiondate");
			flag=false;
		}
	}else{
		admissiondate.classList.remove('is-invalid');
		$("#admissiondate").removeAttr("style");
	}
	
	return flag;
}

function validateFirstName(){
	const firstname=document.querySelector('#firstname');

	var letters = /^[A-Za-z ]+$/;
	var flag=false;
	if(firstname.value != ""){
		if(letters.test(firstname.value)){
			firstname.style.borderColor="#28a745";
			firstname.classList.remove('is-invalid');
			flag=true;
		}else{
			firstname.classList.add('is-invalid');
			firstname.style.borderColor="#dc3545";
			$("#afirstname").text("Please provide a valid firstname");
			flag=false;
		}
	}else{
		firstname.classList.remove('is-invalid');
		$("#firstname").removeAttr("style");
	}
	
	return flag;
}

function validateLastName(){
	const lastname=document.querySelector('#lastname');
	
	var letters = /^[A-Za-z ]+$/;
	var flag=false;
	if(lastname.value != ""){
		if(letters.test(lastname.value)){
			lastname.style.borderColor="#28a745";
			lastname.classList.remove('is-invalid');
			flag=true;
		}else{
			lastname.classList.add('is-invalid');
			lastname.style.borderColor="#dc3545";
			$("#alastname").text("Please provide a valid lastname");
			flag=false;
		}
	}else{
		lastname.classList.remove('is-invalid');
		$("#lastname").removeAttr("style");
		flag=true;
	}
	
	return flag;
}

function validateDateOfBirth(){
    const dob=document.querySelector('#dob');
	
	var date_regex = /^(0[1-9]|1\d|2\d|3[01])\-(0[1-9]|1[0-2])\-(19|20)\d{2}$/;
	
	var flag=false;
	if(dob.value != ""){
		if(date_regex.test(dob.value)){
			dob.style.borderColor="#28a745";
			dob.classList.remove('is-invalid');
			flag=true;
		}else{
			dob.classList.add('is-invalid');
			dob.style.borderColor="#dc3545";
			$("#adob").text("Please provide a valid dob");
			flag=false;
		}
	}else{
		dob.classList.remove('is-invalid');
		$("#dob").removeAttr("style");
	}
	
	return flag;
}

function validateStudentMobileNo(){
	const studentmobileno=document.querySelector('#studentmobileno');
	var expression = /^[0-9]+$/;
	var flag=false;
	
	if(studentmobileno.value != ""){
		if(expression.test(studentmobileno.value)){
			studentmobileno.style.borderColor="#28a745";
			studentmobileno.classList.remove('is-invalid');
			flag=true;
		}else{
			studentmobileno.classList.add('is-invalid');
			studentmobileno.style.borderColor="#dc3545";
			$("#astudentmobileno").text("Please provide a valid student mobileno");
			flag=false;
		}
	}else{
		studentmobileno.classList.remove('is-invalid');
		$("#studentmobileno").removeAttr("style");
		flag=true;
	}
	return flag;
}


function validateStudentEmailId(){
	const studentemailid=document.querySelector('#studentemailid');
	var expression = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
	var flag=false;
	
	if(studentemailid.value != ""){
		if(expression.test(studentemailid.value)){
			studentemailid.style.borderColor="#28a745";
			studentemailid.classList.remove('is-invalid');
			flag=true;
		}else{
			studentemailid.classList.add('is-invalid');
			studentemailid.style.borderColor="#dc3545";
			$("#astudentemailid").text("Please provide a valid student emailid");
			flag=false;
		}
	}else{
		studentemailid.classList.remove('is-invalid');
		$("#studentemailid").removeAttr("style");
		flag=true;
	}
	
	return flag;
}

function validateFatherName(){
	const fathername=document.querySelector('#fathername');
	
	var letters = /^[A-Za-z ]+$/;
	var flag=false;
	if(fathername.value != ""){
		if(letters.test(fathername.value)){
			fathername.style.borderColor="#28a745";
			fathername.classList.remove('is-invalid');
			flag=true;
		}else{
			fathername.classList.add('is-invalid');
			fathername.style.borderColor="#dc3545";
			$("#afathername").text("Please provide a valid fathername");
			flag=false;
		}
	}else{
		fathername.classList.remove('is-invalid');
		$("#fathername").removeAttr("style");
	}
	
	return flag;
}

function validateFatherMobileNo(){
	const fathermobileno=document.querySelector('#fathermobileno');
	var expression = /^[0-9]+$/;
	var flag=false;
	
	if(fathermobileno.value != ""){
		if(expression.test(fathermobileno.value)){
			fathermobileno.style.borderColor="#28a745";
			fathermobileno.classList.remove('is-invalid');
			flag=true;
		}else{
			fathermobileno.classList.add('is-invalid');
			fathermobileno.style.borderColor="#dc3545";
			$("#afathermobileno").text("Please provide a valid father mobileno");
			flag=false;
		}
	}else{
		fathermobileno.classList.remove('is-invalid');
		$("#fathermobileno").removeAttr("style");
	}
	return flag;
}

function validateMotherName(){
	const mothername=document.querySelector('#mothername');
	
	var letters = /^[A-Za-z ]+$/;
	var flag=false;
	if(mothername.value != ""){
		if(letters.test(mothername.value)){
			mothername.style.borderColor="#28a745";
			mothername.classList.remove('is-invalid');
			flag=true;
		}else{
			mothername.classList.add('is-invalid');
			mothername.style.borderColor="#dc3545";
			$("#amothername").text("Please provide a valid mothername");
			flag=false;
		}
	}else{
		mothername.classList.remove('is-invalid');
		$("#mothername").removeAttr("style");
	}
	
	return flag;
}

function validateMotherMobileNo(){
	const mothermobileno=document.querySelector('#mothermobileno');
	var expression = /^[0-9]+$/;
	var flag=false;
	
	if(mothermobileno.value != ""){
		if(expression.test(mothermobileno.value)){
			mothermobileno.style.borderColor="#28a745";
			mothermobileno.classList.remove('is-invalid');
			flag=true;
		}else{
			mothermobileno.classList.add('is-invalid');
			mothermobileno.style.borderColor="#dc3545";
			$("#amothermobileno").text("Please provide a valid mother mobileno");
			flag=false;
		}
	}else{
		mothermobileno.classList.remove('is-invalid');
		$("#mothermobileno").removeAttr("style");
	}
	return flag;
}

function validateGuardianName(){
	const guardianname=document.querySelector('#guardianname');
	
	var letters = /^[A-Za-z ]+$/;
	var flag=false;
	if(guardianname.value != ""){
		if(letters.test(guardianname.value)){
			guardianname.style.borderColor="#28a745";
			guardianname.classList.remove('is-invalid');
			flag=true;
		}else{
			guardianname.classList.add('is-invalid');
			guardianname.style.borderColor="#dc3545";
			$("#aguardianname").text("Please provide a valid guardianname");
			flag=false;
		}
	}else{
		guardianname.classList.remove('is-invalid');
		$("#guardianname").removeAttr("style");
	}
	
	return flag;
}

function validateGuardianMobileNo(){
	const guardianmobileno=document.querySelector('#guardianmobileno');
	var expression = /^[0-9]+$/;
	var flag=false;
	
	if(guardianmobileno.value != ""){
		if(expression.test(guardianmobileno.value)){
			guardianmobileno.style.borderColor="#28a745";
			guardianmobileno.classList.remove('is-invalid');
			flag=true;
		}else{
			guardianmobileno.classList.add('is-invalid');
			guardianmobileno.style.borderColor="#dc3545";
			$("#aguardianmobileno").text("Please provide a valid guardian mobileno");
			flag=false;
		}
	}else{
		guardianmobileno.classList.remove('is-invalid');
		$("#guardianmobileno").removeAttr("style");
	}
	return flag;
}

function studentRegistrationList(){
	$.ajax({
		type: 'post', 
		url: 'studentregistrationlist.do', 
		success: function (data) {
			var result = $.parseJSON(data);
			 	
		 	var table = $('#tableid').DataTable();
		 	table.destroy();
		 	
			$("#tableid tbody").empty();
			
			if(result.list.length>0){
				for(var i=0;i<result.list.length;i++){
					$("#tableid tbody").append("<tr>" +
							"<td>"+(i+1)+"</td>" +
							"<td><a href='javascript:;' id='"+result.list[i].studentid+"' class='btn btn-info btn-xs edit'><i class='fa fa-edit'></i>Edit</a> <a href='javascript:;' id='"+result.list[i].studentid+"' class='btn btn-info btn-xs inactivestatus' data-toggle='modal' data-target='#inactivemodal'><i class='far fa-trash-alt'></i> Delete</a> </td>"+
							"<td>"+result.list[i].firstname+"</td>" +
							"<td>"+result.list[i].admissionno+"</td>" +
							"<td>"+result.list[i].admissiondate+"</td>" +
							"<td>"+result.list[i].gender+"</td>" +
							"<td>"+result.list[i].dob+"</td>" +
							"<td>"+result.list[i].bloodgroup+"</td>" +
							"<td>"+result.list[i].primaryperson+"</td>" +
							"<td>"+result.list[i].studentmobileno+"</td>" +
							"<td>"+result.list[i].studentemailid+"</td>" +
							"<td>"+result.list[i].fathername+"</td>" +
							"<td>"+result.list[i].fathermobileno+"</td>" +
							"<td>"+result.list[i].mothername+"</td>" +
							"<td>"+result.list[i].mothermobileno+"</td>" +
							"<td>"+result.list[i].guardianname+"</td>" +
							"<td>"+result.list[i].guardianmobileno+"</td>" +
							"<td>"+result.list[i].permanentaddress+"</td>" +
							"<td>"+result.list[i].presentaddress+"</td>" +
					"</tr>");
				}
			}
			
			$('#tableid tbody tr').on('click', '.edit', function () {
				localStorage.setItem('url', window.location.href);
				$("a[data-toggle='tab']").trigger('click');
				var id=$(this).attr('id');
				editRecord(id);
			});
			
			$('#tableid tbody tr').on('click', '.inactivestatus', function () {
				$(".activeId").val($(this).attr("id"));
			});
			
			$('#tableid').DataTable({
				"sScrollX": '100%',
			});
		}
	});
}

function editRecord(id){
	localStorage.setItem('activeTabs', '#addnew');
	localStorage.setItem('updateid', id);
	
	$("#add").text("Edit Details");
	$(".save").text("Update");
	$(".reset").text("Cancel");
	
	$.ajax({
		type: 'post', 
		url: 'editstudent.do', 
		data: {'studentid':id}, 
		success: function (data) {
			var result = $.parseJSON(data);
			var obj = jQuery.parseJSON(result.student);
			$("#updateid").val(id);
			$("#admissionno").val(obj.admissionno);
			$("#admissiondate").val(obj.admissiondate);
			$("#firstname").val(obj.firstname);
			$("#lastname").val(obj.lastname);
			$("#gender").val(obj.gender);
			$("#gender").trigger("change");
			$("#dob").val(obj.dob);
			$("#bloodgroup").val(obj.bloodgroup);
			$("#bloodgroup").trigger("change");
			$("#studentmobileno").val(obj.studentmobileno);
			$("#studentemailid").val(obj.studentemailid);
			$("#fathername").val(obj.fathername);
			$("#fathermobileno").val(obj.fathermobileno);
			$("#mothername").val(obj.mothername);
			$("#mothermobileno").val(obj.mothermobileno);
			$("#guardianname").val(obj.guardianname);
			$("#guardianmobileno").val(obj.guardianmobileno);
			$("#primaryperson").val(obj.primaryperson);
			$("#primaryperson").trigger("change");
			$("#address").val(obj.permanentaddress);
			$("#presentaddress").val(obj.presentaddress);
		}
	});
}