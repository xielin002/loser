function initPage(){
	$("#firstPage").on("click", function(){
		  init(1);
		  selPage = 1;
	  });
	  $("#previous").on("click", function(){
		  if(selPage > 1){
			  selPage = selPage - 1;
			  init(selPage);
		  }
	  });
	  $("#nextPage").on("click", function(){
		  if(selPage < totalPage){
			  selPage = selPage + 1;
			  init(selPage);
		  }
	  });
	  $("#endPage").on("click", function(){
		  init(totalPage);
	  });
	  $("#jumpPageBtn").on("click", function(){
		  var jumpPageNumber = $("#jumpPageNumber").val();
		  if(jumpPageNumber){
			  if(jumpPageNumber > totalPage || jumpPageNumber < 1){
				  layui.msg("页码超出范围");
				  return;
			  }
			  init(jumpPageNumber);
		  }
	  });
	  $("#pageHandle").find("li").each(function(){
		  $(this).on('click', function(){
			  if($(this).attr("page")){
				  var curPage = $(this).attr("page");
				  init(curPage);
				  selPage = curPage;
			  }
		  });
	  });
}
function isEmpty(param){
	if(param == null) return true;
	if(param == '') return true;
	if(param == undefined) return true;
	if(param == {}) return true;
	if(param == []) return true;
	return false;
}
function asyncGet(url, param){
	var result;
	$.ajax({
		url:url,
		data:param,
		type:"get",
		async:false,
		dataType:"json",
		success:function(data){
			result = data;
		},
		error:function(data){
			result = data.responseJSON;
		}
	});
	return result;
}
function asyncPost(url, param){
	var result;
	$.ajax({
		url:url,
		data:param,
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			result = data;
		},
		error:function(data){
			result = data;
		}
	});
	return result;
}
