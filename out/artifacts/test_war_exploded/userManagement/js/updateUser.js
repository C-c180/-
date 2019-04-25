$(function () {
    var url=location.search;
    var id=null;
    if (url.indexOf('?') !== -1) {
        id = url.substr(1);
    }
    $.ajax({
        url:"../../servlet/findUser",
        type:'post',
        async:true,
        data:{
            id:id
        },
        dataType:'json',
        success:function (data) {
            console.log(data);
            $(".userName").val(data.userName);
            $(".pwd").val(data.pwd);
            $(".realName").val(data.realName);
            $("#userScaleId").val(data.userScaleId);
        }
    });
    // $(".pwds").blur(function () {
    //     if ($(".pwd").val() != $(".pwds").val()) {
    //         $(pwds).css("display","block");
    //     }else{
    //         $(pwds).css("display","none");
    //     }
    // });
    $(".update").click(function () {
        var isRun=true;
        // if ($(".pwd").val() != $(".pwds").val()) {
        //     isRun=false;
        // }
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
            url:"../../servlet/updateUser",
            type:"post",
            async:true,
            data:{
                id:id,
                pwds:$(".pwds").val(),
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
    })
});