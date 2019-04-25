$(function () {
    $("#mechanicalName").blur(function () {
        var text=$("#mechanicalName").val();
        var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{1,20}$/ig;
        if (pattern.test(text)) {
            $("#mechanicalNameOne").css("display","none");
        }else{
            $("#mechanicalNameOne").css("display","block");
        }
    });
    $("#mainUse").blur(function () {
        var text=$("#mainUse").val();
        var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{4,40}$/ig;
        if (pattern.test(text)) {
            $("#mainUseOne").css("display","none");
        }else{
            $("#mainUseOne").css("display","block");
        }
    });
   $(".add").click(function () {
       var regBox =  /^[\u4E00-\u9FA5A-Za-z0-9].{0,60}$/;
       var r;
       var e;
       if ($("#mechanicalName").val().length>20) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       r = regBox.test($("#mechanicalName").val());
       if(!r){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       if ($("#mainUse").val().length>40) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       e = regBox.test($("#mainUse").val());
       if(!e){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       $.ajax({
           type :"post",
           url :"../../servlet/addMechanical",
           data:{mechanicalName:$("#mechanicalName").val(),
               preventCureTypeId:$("#preventCureTypeId").val(),
               mainUse:$("#mainUse").val()},
           success:function(data) {
                if(data==1){
                    window.location.href="mechanicalManagement.html"
                }
           }
       });
   });
   $(".back").click(function () {
       window.location.href="mechanicalManagement.html";
   });
});


