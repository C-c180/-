$(function () {
    $(".userName").blur(function () {
        pattern(".userName","#userName");
    });
    $(".pwd").blur(function () {
        pwd(".pwd","#pwd");
    });
    $(".realName").blur(function () {
        pattern(".realName","#realName");
    });
    $(".pwds").blur(function () {
        if ($(".pwd").val() != $(".pwds").val()) {
            $(pwds).css("display","block");
        }else{
            $(pwds).css("display","none");
        }
    });
    $(".add").click(function () {
        var isRun=true;
        if (!pattern(".userName", "#userName")) {

            isRun=false;
        }
        if (!pwd(".pwd","#pwd")) {
            isRun=false;
        }
        if (!pattern(".realName", "#realName")) {
            isRun=false;
        }
        if ($(".pwd").val() != $(".pwds").val()) {
            isRun=false;
        }
        if ($("#userScaleId").val().length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选择管理员'
            });

            isRun=false;
            return false;
        }
        if (!isRun) {
            layer.open({
                title: '提示'
                ,content: '请输入内容或你输入的内容不合法'
            });
            return false;
        }
        $.ajax({
            url:"../../servlet/addUser",
            type:"post",
            async:true,
            data:{
                userName:$(".userName").val(),
                pwd:$(".pwd").val(),
                realName:$(".realName").val(),
                userScaleId:$("#userScaleId").val()
            },
            success:function (data) {
                if (data == '1') {
                    window.location.href="user.html";
                }
            }
        });
    });
    $(".back").click(function () {
        window.location.href="user.html";
    });
    function pattern(id,hintId){
        var text=$(id).val();
        var pattern=/^([a-zA-z]|[\u4e00-\u9fa5]){1,20}$/ig;
        console.log(pattern.test(text));
        console.log(typeof (pattern.test(text)));
        if (!pattern.test(text)) {
            $(hintId).css("display","block");
            return false;
        }else{
            $(hintId).css("display","none");
            return true;
        }
    }
    function pwd(id,hintId){
        var text=$(id).val();
        var pattern=/^(\w|[\u4e00-\u9fa5]){6,20}$/gi;
        console.log(pattern.test(text));
        console.log(typeof (pattern.test(text)));
        if (!pattern.test(text)) {
            $(hintId).css("display","block");
            return false;
        }else{
            $(hintId).css("display","none");
            return true;
        }
    }
});