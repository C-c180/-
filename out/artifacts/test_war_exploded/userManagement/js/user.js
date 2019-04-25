$(function () {
    tableDat(null);
    $(".findBtn").click(function () {
        var userScaleId=$("#userScaleId").val();
        tableDat(userScaleId);
    });
    $(".add").click(function () {
        window.location.href="addUser.html";
    });
    $(".updateInfo").click(function () {
        var table = layui.table;
        var checkStatus = table.checkStatus('idTest');
        console.log(checkStatus.data.length);
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        var id=checkStatus.data[0].id;
        // console.log(id);
        window.location.href="updateUser.html?"+id;
    });
    $(".delete").click(function () {

        var table = layui.table;
        var checkStatus = table.checkStatus('idTest');
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        var UserId=checkStatus.data[0].id;
        // console.log(UserId);
        $.ajax({
            url:'../../servlet/deleteUser',
            type:'post',
            async:true,
            data:{UserId:UserId},
            dataType:'json',
            success:function (data) {
                if (data == "1") {
                    window.location.href="user.html";
                }
            }
        })
    });

    function tableDat(userScaleId) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#demo'
                ,id:'idTest'
                ,height: 400
                ,url: '../../servlet/showUser' //数据接口
                ,method : 'post'
                ,request: {
                    pageName: 'currentPage' //页码的参数名称，默认：page
                    , limitName: 'pageSize' //每页数据量的参数名，默认：limit
                }
                ,where:{
                    userScaleId:userScaleId
                }
                ,parseData: function(data){ //data 即为原始返回的数据
                    return {
                        "status": true, //解析接口状态
                        "count": data.total, //解析数据长度
                        "list": data.list //解析数据列表
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
                    {type:'radio'}
                    ,{field: 'userName', title: '用户名'}
                    ,{field: 'pwd', title: '密码',sort: true}
                    ,{field: 'userScale', title: '等级',}
                    ,{field: 'realName', title: '真实姓名',}
                ]]
                ,page: true //开启分页
            })
        });
    }
});

$("#back").click(function () {
    window.location.href="user.html";
})

