'use strict';

$(function() {

	// author badge :)
	var author = '<div style="position: fixed;bottom: 0;right: 20px;background-color: #fff;box-shadow: 0 4px 8px rgba(0,0,0,.05);border-radius: 3px 3px 0 0;font-size: 12px;padding: 5px 10px;">By <a href="https://github.com/io24m">@io24m</a> &nbsp;&bull;&nbsp; </div>';
	$("body").append(author);

	$("input[type='password'][data-eye]").each(function(i) {
		var $this = $(this),
			id = 'eye-password-' + i,
			el = $('#' + id);

		$this.wrap($("<div/>", {
			style: 'position:relative',
			id: id
		}));

		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-'+i,
		}).css({
				position: 'absolute',
				right: 10,
				top: ($this.outerHeight() / 2) - 12,
				padding: '2px 7px',
				fontSize: 12,
				cursor: 'pointer',
		}));

		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));

		var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

		if(invalid_feedback.length) {
			$this.after(invalid_feedback.clone());
		}

		$this.on("keyup paste", function() {
			$("#passeye-"+i).val($(this).val());
		});
		$("#passeye-toggle-"+i).on("click", function() {
			if($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			}else{
				$this.attr('type', 'text');
				$this.val($("#passeye-"+i).val());				
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});

	// $(".my-login-validation").submit(function() {
	// 	var form = $(this);
    //     if (form[0].checkValidity() === false) {
    //       event.preventDefault();
    //       event.stopPropagation();
    //     }
	// 	form.addClass('was-validated');
	// });
	var submit = function () {
		var btn = $("#login_btn");
		var account = $("#username").val().trim();
		var pwd = $("#password").val().trim();
		var errMessage=$("#error_message");
		if (!account) {
			$("#username").focus();
			errMessage.html("用户名不能为空");
			return;
		}
		if (!pwd) {
			$("#password").focus();
			errMessage.html("密码不能为空");
			return;
		}
		btn.html("Login...");
		$.ajax({
			type: "POST",
			url: "/login",
			data: $('#loginForm').serialize(),
			success: function (msg) {
				btn.html("Login");
				if (!msg) {
					window.location = "/";
					return
				}
				errMessage.html(msg);
			}
		});
	};
	$("#login_btn").on("click", submit);
	$(document).keyup(function () {
		if (event.keyCode === 13) {
			submit();
		}
	});



});
