var req = function(){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#demo'
            ,id: 'idTest'
            ,height: 350
            ,method : 'post'
            ,url: '../../servlet/showEvent' //数据接口
            ,where :{"type":$('#type').val(),"value":$('#value').val()
                ,"startDate":$('#test1').val(),"endDate":$('#test2').val()}
            ,request: {
                pageName: 'currentPage' //页码的参数名称，默认：page
                , limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }
            ,parseData: function(res){ //res 即为原始返回的数据
                return {
                    "status": true, //解析接口状态
                    "count": res.total, //解析数据长度
                    "list": res.list //解析数据列表
                };
            }
            ,response: {
                statusName: 'status' //规定数据状态的字段名称，默认：code
                ,statusCode: true //规定成功的状态码，默认：0
                ,msgName: 'msg' //规定状态信息的字段名称，默认：msg
                ,countName: 'count' //规定数据总数的字段名称，默认：count
                ,dataName: 'list' //规定数据列表的字段名称，默认：data
            }
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'eventName', title: '事件名称',  sort: true}
                ,{field: 'dateTimes', title: '日期',  sort: true}
                ,{field: 'happenPlace', title: '发生位置',templet:function(data){
                        return  data.happenPlace.areaName;
                    }}
                ,{field: 'PreventPlan', title: '防治方案',  sort: true}
                ,{field: 'disasterStage', title: '灾情状态',  sort: true}
            ]]
            ,page: true //开启分页
        });
    });
    var form = layui.form
        ,laydate = layui.laydate;
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test2'
    });
}



req();
$(".show").click(function () {
    req();
})
$(".btns:eq(0)").click(function () {
    window.location.href="addEvent.html";
})
$(".btns:eq(1)").click(function () {
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    if(checkStatus.data.length == 1){
        var eventId = checkStatus.data[0].id;
        window.location.href="showEvent.html?"+eventId;
    }else{
        layer.open({
            title: '提示'
            ,content: '请选择单行'
        });
    }

})
$(".btns:eq(2)").click(function () {
    //申请专家会审
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    if(checkStatus.data.length == 1){
        var eventId = checkStatus.data[0].id;
        $.ajax({
            type:"post",
            url:"../../servlet/updateEvent",
            data:{"eventId":eventId,"disasterStage":"无法解决，申请专家会商"},
            dataType:"json",
            success : function (msg) {
                if(msg==1){
                    window.location.href="eventLog.html";
                }
            }
        })
    }else{
        layer.open({
            title: '提示'
            ,content: '请选择单行'
        });
    }
})
$(".btns:eq(3)").click(function () {
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    if(checkStatus.data.length == 1){
        var eventId = checkStatus.data[0].id;
        window.location.href="updateEvent.html?"+eventId;
    }else{
        layer.open({
            title: '提示'
            ,content: '请选择单行'
        });
    }
})
$(".btns:eq(4)").click(function () {
    //删除（批量删除）
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    var data = checkStatus.data;
    for (var i = 0; i < data.length; i++) {
        var eventId = data[i].id;
        $.ajax({
            type:"post",
            url:"../../servlet/deleteEvent",
            data:{"eventId":eventId},
            dataType:"json",
            success : function (msg) {
                if(msg=="1"){
                    window.location.href="eventLog.html";
                }
            }
        })
    }
})
