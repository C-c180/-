$(function () {
    var url=location.search;
    var id=null;
    if (url.indexOf('?') !== -1) {
        id = url.substr(1);
    }
    console.log(id);
    // alert("111");
    $.ajax({
        url:"../../servlet/disease/information",
        type:"post",
        async:true,
        data:{"id":id},
        dataType:'json',
        success:function (data) {
            $(".diseaseName").val(data.name);
            $(".symptom").val(data.symptom);
            $(".mainDanger").val(data.mainDanger);
            $(".pathogeny").val(data.pathogeny);
            $(".rule").val(data.rule);
            $(".measure").val(data.measure);
            $("#picture").attr("src","../../down.jpg/"+data.picture);
        }
    });
    $(".back").click(function () {
        window.location.href="insectDiseaseInformation.html";
    });
});