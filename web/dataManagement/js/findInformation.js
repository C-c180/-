$(function () {
    var url=location.search;
    var id=null;
    if (url.indexOf('?') !== -1) {
        id = url.substr(1);
    }
    console.log(id);
    // alert("111");
    $.ajax({
        url:"../../servlet/insect/information",
        type:"post",
        async:true,
        data:{"id":id},
        dataType:'json',
        success:function (data) {
            $(".insectName").val(data.name);
            $(".hostName").val(data.hostName);
            $(".controlling").val(data.controlling);
            $(".breed").val(data.breed);
            $(".enemy").val(data.enemy);
            $(".danger").val(data.danger);
            $("#childPicture").attr("src","../../down.jpg/"+data.childPicture);
            $("#insectPicture").attr("src","../../down.jpg/"+data.insectPicture);
        }
    });
    $(".back").click(function () {
        window.location.href="insectInformation.html";
    });
});