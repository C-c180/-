$(function () {
    var url=location.search;
    var id=null;
    if (url.indexOf('?') !== -1) {
        id = url.substr(1);
    }
    console.log(id);
    // alert("111");
    $.ajax({
        url:"../../servlet/mouse/information",
        type:"post",
        async:true,
        data:{"id":id},
        dataType:'json',
        success:function (data) {
            $(".mouseName").val(data.name);
            $(".food").val(data.food);
            $(".measure").val(data.measure);
            $(".breed").val(data.breed);
            $(".enemy").val(data.enemy);
            $(".mainDanger").val(data.mainDanger);
            $("#picture").attr("src","../../down.jpg/"+data.picture);
            console.log("src","../../down.jpg"/+data.picture);
        }
    });
    $(".back").click(function () {
        window.location.href="mouseInformation.html";
    });
});