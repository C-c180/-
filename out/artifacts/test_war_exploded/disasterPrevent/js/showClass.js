$(function () {
    $(".back").click(function () {
        window.location.href="class.html";
    })
    var url = location.search;
    var classId = "";
    if(url.indexOf('?')!=-1){
        classId = url.substr(1);
    }
    $.ajax({
        type:"post",
        url:"../../servlet/showClassInfo",
        data:{"classId":classId},
        dataType:"json",
        success:function (dates) {
            $("#clazzName").val(dates.clazzName);
            $("#principal").val(dates.principal);
            $("#personNum").val(dates.personNum);
            $("#principalTel").val(dates.principalTel);
            $("#areaName").val(dates.chargeOfArea.areaName);
            $("#forestType").val(dates.chargeOfArea.forestType);
            $("#landType").val(dates.chargeOfArea.landType);
            $("#dominantTree").val(dates.chargeOfArea.dominantTree);
            $("#creatDate").val(dates.creatDate);
        }
    })
})