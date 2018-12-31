$(function(){
	setInterval("interval()", 100);
});

function interval(){
	var startTime = "2018-02-28 12:00:00";
    var s1 = new Date(startTime.replace(/-/g, "/")),
    s2 = new Date(),
    runTime = parseInt((s2.getTime() - s1.getTime()) / 1000);
    var year = Math.floor(runTime / 86400 / 365);
    runTime = runTime % (86400 * 365);
    var month = Math.floor(runTime / 86400 / 30);
    runTime = runTime % (86400 * 30);
    var day = Math.floor(runTime / 86400);
    runTime = runTime % 86400;
    var hour = Math.floor(runTime / 3600);
    runTime = runTime % 3600;
    var minute = Math.floor(runTime / 60);
    runTime = runTime % 60;
    var second = runTime;
    $("#year").text(format(year));
    $("#mouth").text(month);
	$("#day").text(day);
	$("#hour").text(hour);
	$("#minute").text(minute);
	$("#second").text(second);
}
function format(param){
	if(param == 0){
		$(".year").hide();
		return "";
	}
	return param;
}
