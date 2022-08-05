function noBack() { window.history.forward(); }
$(document).ready(function(){
	var working = false;
	$('.login').on('submit', function(e) {
	  e.preventDefault();
	  
	  working=checkuser();
	  
	  if (working) return;
	  working = true;
	  var $this = $(this),
		$state = $this.find('button > .state');
	  	$this.addClass('loading');
	  	$state.html('Authenticating');
	  	setTimeout(function() {
			$this.addClass('ok');
			$state.html('Welcome back!');
			setTimeout(function() {
			  $state.html('Log in');
			  $this.removeClass('ok loading');
			  window.location.href="login.do";
			  working = false;
			}, 4000);
	  	}, 3000);
	});
});

function InvalidMsg(textbox) {
	  
    if (textbox.value === '') {
        textbox.setCustomValidity('Please enter the username');
    } else {
        textbox.setCustomValidity('');
    }

    return true;
}

function InvalidMsg1(textbox) {
	
	if (textbox.value === '') {
		textbox.setCustomValidity('Please enter the password');
	} else {
		textbox.setCustomValidity('');
	}
	
	return true;
}

function checkuser(){
	var flag=false;

	var UserDetails={
		"username" : $("#username").val(),
		"password" : $("#password").val(),
	};

	$.ajax({
		type : "POST",
		url : "validateLogin.do",
		data : UserDetails,
		async : false,
		success : function(data) {
			var response = $.parseJSON(data);
			if(response.status !="success"){
				$("#isvalid").text("Invalid Login Credentials");
				flag=true;
			}
		}

	});
	return flag;
}