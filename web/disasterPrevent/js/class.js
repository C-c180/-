var req = function(){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#demo'
            ,id: 'idTest'
            ,height: 350
            ,method : 'post'
            ,url: '../../servlet/showClass' //数据接口
            ,where :{"type":$('#type').val(),"value":$('#value').val()}
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
                {type:'radio'}
                ,{field: 'clazzName', title: '小班名称',  sort: true}
                ,{field: 'principal', title: '负责人' }
                ,{field: 'principalTel', title: '负责人电话',  sort: true}
                ,{field: 'chargeOfArea', title: '负责区域',templet:function(data){
                        return  data.chargeOfArea.areaName;
                    }}
            ]]
            ,page: true //开启分页
        });

    });
}

req();

$(".show").click(function () {
    req();
})

$(".add").click(function () {
    window.location.href="addClass.html";
})
$(".classInfo").click(function () {
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    var classId = checkStatus.data[0].id;
    window.location.href="showClass.html?"+classId;

})
$(".updateInfo").click(function () {
    var table = layui.table;
    var checkStatus = table.checkStatus('idTest');
    if (checkStatus.data.length == 0) {
        layer.open({
            title: '提示'
            ,content: '请选中行'
        });
        return false;
    }
    var classId = checkStatus.data[0].id;
    window.location.href="updateClass.html?"+classId;
})
