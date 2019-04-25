var req=function(){ layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#demo'
        ,height: 350
        ,id:'idTest'
        ,method:'post'
        ,url: '../../servlet/findSpecialistByCondition' //数据接口
        ,where:{"specialistName":$("#specialistName").val(),"speciality":$("#speciality").val()}
        ,request: {
            pageName: 'currentPage' //页码的参数名称，默认：page
            ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        ,parseData: function(res){ //res 即为原始返回的数据
            console.log(res)
            return {
                "status": true, //解析接口状态
                "count": res.total, //解析数据长度
                "list": res.list //解析数据列表
            };
        }
        ,response: {
            statusName: 'status' //规定数据状态的字段名称，默认：code
            ,statusCode: true //规定成功的状态码，默认：04a
            ,msgName: 'hint' //规定状态信息的字段名称，默认：msg
            ,countName: 'count' //规定数据总数的字段名称，默认：count
            ,dataName: 'list' //规定数据列表的字段名称，默认：data
        }
        ,cols: [[ //表头
            {type:'radio'}
            ,{field: 'specialistName', title: '姓名', sort: true}
            ,{field: 'workunit', title: '工作单位'}
            ,{field: 'speciality', title: '专长',  sort: true}
            ,{field: 'duty', title: '职务'}
            ,{field: 'telphone', title: '电话'}
        ]]
        ,page: true //开启分页
    });
});
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test2' //指定元素
        });
    });
}

   req();
     $(".findBtn").click(function () {
         req();
     })

    $(".btns:eq(0)").click(function () {
        window.location.href="addExpert.html";
    })
    $(".btns:eq(1)").click(function () {
        var table=layui.table;
        var checkStatus=table.checkStatus('idTest');
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        if(checkStatus.data.length == 1) {
            var specialistId = checkStatus.data[0].specialistId;
            console.log(specialistId + "=====")
            window.location.href = "findExpertInformation.html?" + specialistId;
        }
    })
    $(".btns:eq(2)").click(function () {
        var table=layui.table;
        var checkStatus=table.checkStatus('idTest');
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        if(checkStatus.data.length == 1) {
            var specialistId=checkStatus.data[0].specialistId;
            window.location.href="updateExpertInformation.html?"+specialistId;
        }
    })
    $(".btns:eq(3)").click(function () {
        var table=layui.table;
        var checkStatus=table.checkStatus('idTest');
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        if(checkStatus.data.length == 1) {
            var specialistId=checkStatus.data[0].specialistId;
            $.ajax({
                type:"post",
                url:"../../servlet/deleteSpecialistInformation",
                data:{"specialistId":specialistId},
                dataType:"json",
                success:function (datas) {
                    console.log(datas)
                    if(datas==1){
                        // alert("修改成功");
                        window.location.href="expert.html"
                    }
                }
            })
        }


    })



