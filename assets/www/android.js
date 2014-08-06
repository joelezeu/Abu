function findit() {
	val=$('#searchbox').val();
	searcharea=$('#searcharea').find('li');
	found='block';
	$(searcharea).each(function() {
		txt=$(this).text();
		disp=txt.indexOf(val)>0 ? 'block' : 'none';
			if(disp=='block') {found='none';}
			$(this).css({display:disp});
	});
	$('#nomatch').css({display:found});
}


function searchfor(val,zone) {
//for empty textbox, just return everything back to normal
	if(val=='') {
	$(zone).find('li').css({'display':'block'});
	return;
	}
	$(zone).find('li').each(function() {
	txt=$(this).text();
	if(txt.indexOf(val) >= 0) {
	$(this).css({display:'none'});
	} else {
	$(this).css({display:'block'});
	}
});
}