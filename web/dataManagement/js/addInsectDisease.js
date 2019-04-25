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
        $(".diseaseName").blur(function () {
            pattern(".diseaseName","#diseaseName");
        });
        $(".symptom").blur(function () {
            pattern(".symptom","#symptom");
        });
        $(".pathogeny").blur(function () {
            pattern(".pathogeny","#pathogeny");
        });
        $(".rule").blur(function () {
            pattern(".rule","#rule");
        });
        $(".mainDanger").blur(function () {
            textArea(".mainDanger","#mainDanger");
        });
        $(".measure").blur(function () {
            textArea(".measure","#measure");
        });
        $(".add").click(function () {
            var isRun=true;
            if (!pattern(".diseaseName","#diseaseName")) {
                isRun=false;
            }
            if (! pattern(".symptom","#symptom")) {
                isRun=false;
            }
            if (!pattern(".pathogeny","#pathogeny")) {
                isRun=false;
            }
            if (!pattern(".enemy","#enemy")) {
                isRun=false;
            }
            if (! textArea(".mainDanger","#mainDanger")) {
                isRun=false;
            }
            if (! textArea(".measure","#measure")) {
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
                form.append("file[]",files[i])
            }
            form.append("diseaseName",$(".diseaseName").val());
            form.append("symptom",$(".symptom").val());
            form.append("mainDanger",$(".mainDanger").val());
            form.append("pathogeny",$(".pathogeny").val());
            form.append("rule",$(".rule").val());
            form.append("measure",$(".measure").val());
            $.ajax({
                url:"../../servlet/disease/add",
                type:"post",
                contentType:false,
                processData:false,
                async:true,
                data:form,
                success:function (data) {
                    if (data == "1") {
                        window.location.href="insectDiseaseInformation.html";
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
        window.location.href="insectDiseaseInformation.html";
    });
});