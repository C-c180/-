$(".back").click(function () {
    window.location.href="eventLog.html"
})
var url = location.search;
var eventId = "";
if(url.indexOf('?')!=-1){
    eventId = url.substr(1);
}
console.log(eventId);
$.ajax({
    type:"post",
    url:"../../servlet/showEventInfo",
    data:{"eventId":eventId},
    dataType:"json",
    success:function (dates) {
        $("#eventName").val(dates.eventName);
        $("#dateTimes").val(dates.dateTimes);
        $("#disasterStage").val(dates.disasterStage);
        $("#disasterDesc").val(dates.disasterDesc);
        $("#disastersType").val(dates.disastersType);
        $("#loss").val(dates.loss);
        $("#demo1").attr("src","../../down.jpg/"+dates.imagePath);
        $("#advice").val(dates.advice);
        $("#FoundWay").val(dates.FoundWay);
        $("#happenPlace").val(dates.happenPlace.areaName);
        $("#chargeOfClass").val(dates.happenPlace.chargeOfClass.clazzName);
        $("#AreaOfInfluence").val(dates.AreaOfInfluence);
        $("#PreventPlan").val(dates.PreventPlan);
    }
})