$(document).ready(function() {
	
	if($("#highlightmenu").val() != ""){
		$(".sub-group-menu").removeClass("sub-group-active");
		$(".nav-link").removeClass("menu-active");
		$("#"+$("#highlightmenu").val()).closest('ul').addClass('sub-group-active');
		$("#"+$("#highlightmenu").val()).addClass("menu-active");
	}
	
	$(".select2").css("width", "100%");
	
	/*reload page script start*/
	if(localStorage.getItem('url') != window.location.href){
		localStorage.clear();
	}
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		var currId = $(e.target).attr("href");
		
		localStorage.setItem('activeTabs', currId);
		if(currId == "#viewall"){
			localStorage.setItem('updateid',"");
			$("#reset").trigger('click');
			$(".dynamicxyz").empty();
		}
	});
	
	$("a[data-toggle='tab']").click(function(){
		$(this).tab('show');
	});
	
	reloadPage();
	/*reload page script end*/
	
	$("#add").click(function(){
		$(".custom-select").trigger('change');
	});
});

function reloadPage(){
	var activeTabs = localStorage.getItem('activeTabs');
	var updateid = localStorage.getItem('updateid');
	if(activeTabs == "#addnew" && updateid != ""){
		editRecord(updateid);
	}
	$('.nav-tabs a[href="'+activeTabs+'"]').tab('show')
}
