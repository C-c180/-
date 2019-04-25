$(function () {
    // alert("111");
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
        var files;
        var uploadInsectPicture = upload.render({
            elem: '#test1'
            ,auto:false
            ,choose:function (obj) {
                files= obj.pushFile();
                obj.preview(function(index, file, result){
                    $('#demo2').attr('src', result);
                });
            }
        });
        $(".mouseName").blur(function () {
            pattern(".mouseName","#mouseName");
        });
        $(".breed").blur(function () {
            pattern(".breed","#breed");
        });
        $(".food").blur(function () {
            pattern(".food","#food");
        });
        $(".enemy").blur(function () {
            pattern(".enemy","#enemy");
        });
        $(".measure").blur(function () {
            textArea(".measure","#measure");
        });
        $(".mainDanger").blur(function () {
            textArea(".mainDanger","#mainDanger");
        });

        $(".add").click(function () {
            var isRun=true;
            if (!pattern(".mouseName","#mouseName")) {
                isRun=false;
            }
            if (!pattern(".breed", "#breed")) {
                isRun=false;
            }
            if (!pattern(".food","#food")) {
                isRun=false;
            }
            if (!pattern(".enemy","#enemy")) {
                isRun=false;
            }
            if (!textArea(".measure","#measure")) {
                isRun=false;
            }
            if (!textArea(".mainDanger","#mainDanger")) {
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
            for (let i in files) {
                form.append("file[]",files[i]);
            }
            form.append("mouseName",$(".mouseName").val());
            form.append("breed",$(".breed").val());
            form.append("measure",$(".measure").val());
            form.append("food",$(".food").val());
            form.append("enemy",$(".enemy").val());
            form.append("mainDanger",$(".mainDanger").val());
            $.ajax({
                url:"../../mouse/add",
                type:"post",
                contentType:false,
                processData:false,
                async:true,
                data:form,
                success:function (data) {
                    if (data == "1") {
                        window.location.href="mouseInformation.html";
                    }
                }
            })
        })
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
        var pattern=/^(\w|[\u4e00-\u9fa5]){5,100}$/ig;
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
        window.location.href="mouseInformation.html";
    });
});