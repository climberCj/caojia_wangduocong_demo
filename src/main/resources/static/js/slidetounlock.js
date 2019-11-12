jQuery(function($) {

	$("#submit").attr("disabled", "disabled");
	$("#slider").draggable({
		axis: 'x',
		containment: 'parent',
		drag: function(event, ui) {
			if (ui.position.left > 210) {
				//$("#well #unlock").fadeOut();
				$("#submit").removeAttr("disabled");
				$(this).parent().parent().css('background','#2c9317');
			} else {
				$("#submit").attr("disabled", "disabled");
			}
		},
		stop: function(event, ui) {
			if (ui.position.left < 211) {
				$(this).animate({
					left: 0
				})
			} else {
				$(".inputwrapper button").css("background-color","#2c9317");
				$("#slider").draggable({
					disabled: 'true',
				});
			}
		}
	});

	//	$('#slider')[0].addEventListener('touchmove', function(event) {
	//		event.preventDefault();
	//		var el = event.target;
	//		var touch = event.touches[0];
	//		curX = touch.pageX - this.offsetLeft - 73;
	//		if (curX <= 0) return;
	//		if (curX > 205) {
	//			$('#well').fadeOut();
	//		}
	//		el.style.webkitTransform = 'translateX(' + curX + 'px)';
	//	}, false);
	//
	//	$('#slider')[0].addEventListener('touchend', function(event) {
	//		this.style.webkitTransition = '-webkit-transform 0.3s ease-in';
	//		this.addEventListener('webkitTransitionEnd', function(event) {
	//			this.style.webkitTransition = 'none';
	//		}, false);
	//		this.style.webkitTransform = 'translateX(0px)';
	//	}, false);

});