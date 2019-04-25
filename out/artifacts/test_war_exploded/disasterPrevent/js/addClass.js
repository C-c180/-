$(function () {
    layui.use('form', function(){
        $.ajax({
            type :"post",
            url :"../../servlet/loadArea",
            dataType:"json",
            success: function(msg){
                console.log(msg[0].areaName)
                var str = "<option value='0'>请选择一个负责区域</option>";
                for (var i = 0; i < msg.length; i++) {
                    var areaName = msg[i].areaName;
                    var areaId = msg[i].id;
                    str+="<option value='"+areaId+"'>"+areaName+"</option>"
                }
                $("#chargeOfArea").html(str);

                var form = layui.form;
                form.render('select',"test2");
            }
        })
    });
    $(".add").click(function () {
        $("form").submit(function () {
            var confirm = true;
            var str = "";
            if(!checkText("#clazzName","#cls")){
                str+="小班名称输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#principal","#pri")){
                str+="负责人输入不符合规范</br>";
                confirm=false;
            }
            var regTel = /^[1-9][0-9]{6,10}/ig;
            if(!regTel.test($("#principalTel").val())){
                str+="负责人电话输入不符合规范</br>";
                confirm=false;
            }
            var regNum = /^[1-9][0-9]{0,2}/ig;
            if(!regNum.test($("#personNum").val())){
                str+="小班人数输入不符合规范</br>";
                confirm=false;
            }
            if($("#chargeOfArea").val()==0){
                str+="请选择负责区域</br>";
                confirm=false;
            }
            if(confirm==false){
                layer.open({
                    title: '提示'
                    ,content: str
                });
                return false;
            }else{
                return true;
            }
        })
    })
    $(".back").click(function () {
        window.location.href="class.html";
    })


    $("#clazzName").blur(function () {
        checkText("#clazzName","#cls");
    })
    $("#principal").blur(function () {
        checkText("#principal","#pri");
    })
    $("#principalTel").blur(function () {
        var reg = /^[1-9][0-9]{6,10}$/ig;
        var value = $("#principalTel").val();
        if(!reg.test(value)){
            $("#prit").css("display","block")
        }else{
            $("#prit").css("display","none")
        }
    })
    $("#personNum").blur(function () {
        var reg = /^[1-9][0-9]{0,2}$/ig;
        var value =  $("#personNum").val();
        if(!reg.test(value)){
            $("#num").css("display","block")
        }else{
            $("#num").css("display","none")
        }
    })

    // 验证文字输入,domId为需要验证的节点id,tagId为提示标签的id
    function checkText (domId,tagId) {
        var reg = /^[A-z\u4e00-\u9fa5][A-z0-9\u4e00-\u9fa5]{1,19}/ig;
        var value = $(domId).val();
        if(!reg.test(value)){
            $(tagId).css("display","block")
            return false;
        }else{
            $(tagId).css("display","none")
            return true;
        }
    }
})