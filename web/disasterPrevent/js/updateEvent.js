
$(".back").click(function () {
    window.location.href="eventLog.html"
})
var url = location.search;
var eventId = "";
if(url.indexOf('?')!=-1){
    eventId = url.substr(1);
}
$.ajax({
    type:"post",
    url:"../../servlet/showEventInfo",
    data:{"eventId":eventId},
    dataType:"json",
    success:function (dates) {
        $("#eventName").val(dates.eventName);
        $("#dateTimes").val(dates.dateTimes);
        for (var i = 0; i < $("#disasterStage").options; i++) {
            if($("#disasterStage").val(dates.disasterStage)==options[i].val()){
                options[i].attr("selected,selected")
            }
        };
        $("#disasterStage").val(dates.disasterStage);
        $("#disasterDesc").val(dates.disasterDesc);
        $("#disastersType").val(dates.disastersType);
        $("#demo1").attr("src","../../down.jpg/"+dates.imagePath);
        $("#loss").val(dates.loss);
        $("#advice").val(dates.advice);
        $("#FoundWay").val(dates.FoundWay);
        $("#happenPlace").val(dates.happenPlace.areaName);
        $("#chargeOfClass").val(dates.happenPlace.chargeOfClass.clazzName);
        $("#AreaOfInfluence").val(dates.AreaOfInfluence);
        $("#PreventPlan").val(dates.PreventPlan);
    }
})
$(".amend").click(function () {
    $.ajax({
        type:"post",
        url:"../../servlet/updateEvent",
        data:{"eventId":eventId,"disasterStage":$("#disasterStage").val(),"PreventPlan":$("#PreventPlan").val()},
        dataType:"text",
        success:function (msg) {
            if(msg==1){
                window.location.href="eventLog.html"
            }
        }
    })
})