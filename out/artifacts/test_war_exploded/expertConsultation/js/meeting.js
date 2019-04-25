$(function () {
    var url = location.search;
    var id = "";
    if(url.indexOf('?')!=-1) {
        id = url.substr(1);
        console.log(id+"=====")
    }
    $.ajax({
        type:"post",
        url:"../../servlet/searchExpertInfo",
        data:{"id":id},
        dataType:"json",
        success:function (datas) {
            console.log(datas)
            $("#eventName").val(datas.eventName);
            $("#dateTimes").val(datas.dateTimes);
            $("#disasterDesc").val(datas.disasterDesc);
            $("#areaName").val(datas.happenPlace.areaName);
            $("#AreaOfInfluence").val(datas.AreaOfInfluence);

        }
    })
    var showTable = function(){
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#demo'
                ,height: 200
                ,id:'idTest'
                ,method:'post'
                ,url: '../../servlet/addExpertInformation' //数据接口
                ,where:{"result":$("#result").val(),"staff":$("#staff").val(),"eventId":id}
                ,request: {
                    pageName: 'currentPage' //页码的参数名称，默认：page
                    ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
                }
                ,parseData: function(res){ //res 即为原始返回的数据
                    console.log(res.list)
                    $("#demo2").attr("src","../../down.jpg/"+res.imagePath)
                    return {
                        "status": true, //解析接口状态
                        "count": res.total, //解析数据长度
                        "list": res.list //解析数据列表

                    };
                }
                ,response: {
                    statusName: 'status' //规定数据状态的字段名称，默认：code
                    ,statusCode: true //规定成功的状态码，默认：0
                    ,msgName: 'hint' //规定状态信息的字段名称，默认：msg
                    ,countName: 'count' //规定数据总数的字段名称，默认：count
                    ,dataName: 'list' //规定数据列表的字段名称，默认：data
                }
                ,cols: [[ //表头
                    ,{field: 'dataTime', title: '日期',width:120, sort: true}
                    ,{field: 'staff', title: '会商人员'}
                    ,{field: 'result', title: '会商结果',  sort: true}
                ]]
                ,page: true //开启分页
            });
        });
    }

    showTable();

    $(".add").click(function () {
        var confirm = true;
        var str = "";
        if(!checkText("#result","#meetResult")){
            str+="会商结果输入不符合规范</br>";
            confirm=false;
        }
        if(!checkText("#staff","#people")){
            str+="会商人员不符合规范</br>";
            confirm=false;
        }
        if(confirm){
            showTable();
        }else{
            layer.open({
                title: '提示'
                ,content: str
            });
        }

    });
    $(".back").click(function () {
        window.location.href="talk.html";
    });

    $("#result").blur(function () {
        checkText("#result","#meetResult");
    })
    $("#staff").blur(function () {
        checkText("#staff","#people");
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