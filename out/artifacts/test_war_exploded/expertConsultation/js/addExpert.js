$(function () {

       layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#birthday' //指定元素
        });
    });
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        var uploadInsect = layui.upload;
        var files;
        var uploadInsectPicture = uploadInsect.render({
            elem: '#test1'
            , auto: false
            , choose: function (obj) {
                files = obj.pushFile();
                obj.preview(function (index, file, result) {
                        $('#demo2').attr('src', result);
                        obj.resetFile(index, file, 'specialistImage.jpg');
                });
            }
        });
        $(".add").click(function () {
            var form=new FormData();
            console.log($("input[type='radio']:checked").val())


            var confirm = true;
            var str = "";
            if(!checkText("#specialistName","#name")){
                str+="名称输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#speciality","#zc")){
                str+="职务输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#address","#location")){
                str+="地址输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#workunit","#work")){
                str+="工作单位输入不符合规范</br>";
                confirm=false;
            }

            if(confirm){
                for (var i in files) {
                    form.append("file[]",files[i])
                }
                form.append("specialistName",$("#specialistName").val());
                form.append("speciality",$("#speciality").val());
                form.append("telphone",$("#telphone").val());
                form.append("address",$("#address").val());
                form.append("duty",$("#duty").val());
                form.append("workunit",$("#workunit").val());
                form.append("email",$("#email").val());
                form.append("birthday",$("#birthday").val());
                form.append("sex",$("input[type='radio']:checked").val());
                console.log(form);
                $.ajax({
                    type :"post"
                    ,url :"../../servlet/addSpecialistInformation"
                    ,contentType:false
                    ,processData:false
                    ,async:true
                    ,data:form
                    ,dataType:"json",
                    success:function (data) {
                        if(data=="1"){
                            window.location.href="expert.html";
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
    })

    $(".back").click(function () {
        window.location.href="expert.html";
    });

    // 数据验证
    $("#specialistName").blur(function () {
        checkText("#specialistName","#name");
    })
    $("#speciality").blur(function () {
        checkText("#speciality","#zc");
    })
    $("#address").blur(function () {
        checkText("#address","#location");
    })
    $("#duty").blur(function () {
        checkText("#duty","#zw");
    })
    $("#workunit").blur(function () {
        checkText("#workunit","#work");
    })

    // 验证文字输入,domId为需要验证的节点id,tagId为提示标签的id
    function checkText (domId,tagId) {
        var reg = /^[A-z\u4e00-\u9fa5]([A-z0-9\u4e00-\u9fa5]+,?){1,15}$/ig;
        var value = $(domId).val();
        if(!reg.test(value)){
            $(tagId).css("display","block")
            return false;
        }else{
            $(tagId).css("display","none")
            return true;
        }
    }
});