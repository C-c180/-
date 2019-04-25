$(function () {
    $("#potionName").blur(function () {
        var text=$("#potionName").val();
        var pattern=/^[\u4e00-\u9fa5A-Za-z0-9].{1,20}$/ig;
        if (pattern.test(text)) {
            $("#potionNameOne").css("display","none");
        }else{
            $("#potionNameOne").css("display","block");
        }
    });
    $("#diseasesAndPestsName").blur(function () {
        var text=$("#diseasesAndPestsName").val();
        var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{1,20}$/ig;
        if (pattern.test(text)) {
            $("#diseasesAndPestsNameOne").css("display","none");
        }else{
            $("#diseasesAndPestsNameOne").css("display","block");
        }
    });
    $("#treeSpecies").blur(function () {
        var text=$("#treeSpecies").val();
        var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{1,50}$/ig;
        if (pattern.test(text)) {
            $("#treeSpeciesOne").css("display","none");
        }else{
            $("#treeSpeciesOne").css("display","block");
        }
    });

   $(".add").click(function () {
       var regBox =  /^[\u4E00-\u9FA5A-Za-z0-9].{0,70}$/;
       var r;
       var e;
       var w;
       if ($("#potionName").val().length>20) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       r = regBox.test($("#potionName").val());
       if(!r){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       if ($("#diseasesAndPestsName").val().length>20) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       e = regBox.test($("#diseasesAndPestsName").val());
       if(!e){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       if ($("#treeSpecies").val().length>50) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       w = regBox.test($("#treeSpecies").val());
       if(!w){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       $.ajax({
           type :"post",
           url :"../../servlet/addPotion",
           data:{potionName:$("#potionName").val(),
               preventCureTypeId:$("#preventCureTypeId").val(),
               diseasesAndPestsName:$("#diseasesAndPestsName").val(),
               treeSpecies:$("#treeSpecies").val()},
           success:function(data) {
               if(data==1){
                   window.location.href="potionManagement.html"
               }
           }
       });
   });
   $(".back").click(function () {
       window.location.href="potionManagement.html";
   });
});