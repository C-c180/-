$(function () {
    //Demo
    layui.use('form', function(){
        var form = layui.form;
    });
    //返回主界面
    $(".back").click(function () {
        window.location.href="area.html";
    })
    //添加区域请求初始化数据参数
    $(".add").click(function () {
        var confirm = true;
        var str = "";
        if(!checkText("#areaName","#area")){
            str+="区域名称输入不符合规范</br>";
            confirm=false;
        }
        if(!checkText("#forestType","#forest")){
            str+="林种类型输入不符合规范</br>";
            confirm=false;
        }
        if(!checkText("#dominantTree","#tree")){
            str+="优势树种输入不符合规范</br>";
            confirm=false;
        }
        if($("#landType").val()==0){
            str+="请选择一个地类</br>";
            confirm=false;
        }
        if(confirm){
            $.ajax({
                type :"post",
                url :"../../servlet/addArea",
                data:{"areaName":$(".areaName").val()
                    ,"forestType":$(".forestType").val()
                    ,"landType":$(".landType").val()
                    ,"dominantTree":$(".dominantTree").val()}
                ,dataType:"json",
                success:function (data) {
                    if(data=="1"){
                        window.location.href="area.html";
                    }
                }
            })
        }else{
            layer.open({
                title: '提示'
                ,content: str
            });
        }
    })

    $("#areaName").blur(function () {
        checkText("#areaName","#area");
    })
    $("#forestType").blur(function () {
        checkText("#forestType","#forest");
    })
    $("#dominantTree").blur(function () {
        checkText("#dominantTree","#tree");
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