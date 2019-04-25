$(function () {

    layui.use('upload', function(){
        var childfiles;
        var insectfiles;
        var $ = layui.jquery
            ,upload = layui.upload;
        var uploadInsect=layui.upload;
        var uploadInsectPicture = uploadInsect.render({
            elem: '#test1'
            ,auto:false
            ,choose:function (obj) {
                childfiles= obj.pushFile();
                obj.preview(function(index, file, result){
                        $('#demo1').attr('src', result);
                        obj.resetFile(index, file, 'childPicture.jpg');
                });
            }
        });
        upload.render({
            elem: '#test2'
            ,auto:false
            ,choose:function (obj) {
                insectfiles= obj.pushFile();
                obj.preview(function(index, file, result){
                    $('#demo2').attr('src', result);
                    obj.resetFile(index, file, 'insectPicture.jpg');
                });
            }
        });
        $(".insectName").blur(function () {
            pattern(".insectName","#insectName");
        });
        $(".hostName").blur(function () {
            pattern(".hostName","#hostName")
        });
        $(".breed").blur(function () {
            pattern(".breed","#breed")
        }); $(".enemy").blur(function () {
            pattern(".enemy","#enemy")
        });
        $(".controlling").blur(function () {
            textArea(".controlling","#controlling")
        });
        $(".danger").blur(function () {
            textArea(".danger","#danger")
        });
        $(".add").click(function () {
            var isRun=true;
            if (!pattern(".insectName", "#insectName")) {
                isRun=false;
            }
            if (!pattern(".hostName","#hostName")) {
                isRun=false;
            }
            if (!pattern(".breed","#breed")) {
                isRun=false;
            }
            if (!pattern(".enemy","#enemy")) {
                isRun=false;
            }
            if (!textArea(".controlling","#controlling")) {
                isRun=false;
            }
            if (! textArea(".danger","#danger")) {
                isRun=false;
            }
            if ($("#demo1").attr("src") == null) {
                isRun=false;
            }
            if ($("#demo2").attr("src") == null) {
                isRun=false;
            }
            if (!isRun) {
                layer.open({
                    title: '提示'
                    ,content: '请输入内容或你输入的内容不合法'
                });
                return false;
            }
            var form=new FormData();
            for (let i in childfiles) {
                form.append("file[]",childfiles[i]);
            }
            for (let i in insectfiles) {
                form.append("file[]",insectfiles[i]);
            }
            form.append("insectName",$(".insectName").val());
            form.append("hostName",$(".hostName").val());
            form.append("controlling",$(".controlling").val());
            form.append("breed",$(".breed").val());
            form.append("enemy",$(".enemy").val());
            form.append("danger",$(".danger").val());
            $.ajax({
                url:"../../sevrlet/insect/add",
                type:"post",
                contentType:false,
                processData:false,
                async:true,
                data:form,
                success:function (data) {
                    if (data == "1") {
                        window.location.href="insectInformation.html";
                    }
                }
            })
        });
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
    function textArea(id,hintId){
        var text=$(id).val();
        var pattern=/^(\w|[\u4e00-\u9fa5]){5,100}$/gi;
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
   $(".back").click(function () {
       window.location.href="insectInformation.html";
   });
});