$(function () {
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        var uploadInsect = layui.upload;
        var files;
        var uploadInsectPicture = uploadInsect.render({
            elem: '#imagePath'
            , auto: false
            , choose: function (obj) {
                files = obj.pushFile();
                obj.preview(function (index, file, result) {
                    if ($('#demo1').attr('src') == null) {
                        $('#demo1').attr('src', result);
                        obj.resetFile(index, file, 'eventImage.jpg');
                    }
                });
            }
        });
        $(".add").click(function () {
            var form=new FormData();

            var confirm = true;
            var str = "";
            if(!checkText("#eventName","#em")){
                str+="事件名称输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#disasterDesc","#desc")){
                str+="描述输入不符合规范</br>";
                confirm=false;
            }
            if(!checkNum("#loss","#losses")){
                str+="初步损失输入不符合规范</br>";
                confirm=false;
            }
            if(!checkText("#PreventPlan","#plan")){
                str+="防治方案输入不符合规范</br>";
                confirm=false;
            }
            if(!checkNum("#AreaOfInfluence","#ae")){
                str+="影响面积输入不符合规范</br>";
                confirm=false;
            }
            if($("#dateTimes").val()==null||$("#dateTimes").val()==undefined){
                str+="请选择时间</br>";
                confirm=false;
            }
            if($("#disasterStage").val()==0){
                str+="请选择灾情阶段</br>";
                confirm=false;
            }
            if($("#happenPlace").val()==0){
                str+="请选择发生位置</br>";
                confirm=false;
            }
            if($("#disastersType").val()==0){
                str+="请选择灾害类型</br>";
                confirm=false;
            }
            if($("#FoundWay").val()==0){
                str+="请选择发现途径</br>";
                confirm=false;
            }

            if(confirm){
                for (var i in files) {
                    form.append("file[]",files[i])
                }
                form.append("eventName",$("#eventName").val());
                form.append("dateTimes",$("#dateTimes").val());
                form.append("disasterStage",$("#disasterStage").val());
                form.append("disasterDesc",$("#disasterDesc").val());
                form.append("areaId",$("#happenPlace").val());
                form.append("loss",$("#loss").val());
                form.append("PreventPlan",$("#PreventPlan").val());
                form.append("disastersType",$("#disastersType").val());
                form.append("FoundWay",$("#FoundWay").val());
                form.append("AreaOfInfluence",$("#AreaOfInfluence").val());
                $.ajax({
                    type :"post"
                    ,url :"../../servlet/addEvent"
                    ,contentType:false
                    ,processData:false
                    ,async:true
                    ,data:form
                    ,dataType:"json",
                    success:function (data) {
                        if(data=="1"){
                            window.location.href="eventLog.html";
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
        window.location.href="eventLog.html"
    })
    //请求初始化下拉框
    $.ajax({
        type:'post',
        dataType:'json',
        url:'../../servlet/loadArea',
        success : function (msg) {
            var str = "<option value=''>请选择区域</option>";
            for (var i = 0; i < msg.length; i++) {
                var areaName = msg[i].areaName;
                var areaId = msg[i].id;
                str+="<option value='"+areaId+"'>"+areaName+"</option>"
            }
            $("#happenPlace").html(str);
            var form = layui.form;
            form.render('select',"test2");
        }
    })

    var form = layui.form
        ,laydate = layui.laydate;
    laydate.render({
        elem: '#dateTimes'
    });

    // 监听下拉框事件，根据下拉框选中的值获得对应的负责小班
    layui.use('form', function(){
        var form = layui.form;
        form.on('select(test)', function(data){
            $.ajax({
                type:'post',
                dataType:'json',
                data:{"areaId":$("#happenPlace").val()},
                url:'../../servlet/LoadEventEvent',
                success : function (msg) {
                    console.log($("#happenPlace").val());
                    $("#chargeOfClass").val(msg.chargeOfClass.clazzName);
                    var form = layui.form;
                    form.render('select',"test2");
                }
            })
        });
    });

    // 数据验证
    $("#eventName").blur(function () {
        checkText("#eventName","#em");
    })
    $("#disasterDesc").blur(function () {
        checkText("#disasterDesc","#desc");
    })
    $("#loss").blur(function () {
        checkNum("#loss","#losses");
    })
    $("#PreventPlan").blur(function () {
        checkText("#PreventPlan","#plan");
    })
    $("#AreaOfInfluence").blur(function () {
        checkNum("#AreaOfInfluence","#ae");
    })

    // 验证文字输入,domId为需要验证的节点id,tagId为提示标签的id
    function checkText (domId,tagId) {
        var reg = /^[A-z\u4e00-\u9fa5][A-z0-9\u4e00-\u9fa5,，]{1,15}$/ig;
        var value = $(domId).val();
        if(!reg.test(value)){
            $(tagId).css("display","block")
            return false;
        }else{
            $(tagId).css("display","none")
            return true;
        }
    }
    function checkNum (domId,tagId) {
        var reg = /^[1-9][0-9]{1,5}/ig;
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