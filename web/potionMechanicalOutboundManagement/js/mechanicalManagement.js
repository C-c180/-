
$(function () {
    tabelData(null,null);
    $(".findBtn").click(function () {
        // var regBox =  /^[\u4E00-\u9FA5A-Za-z0-9].{2,60}$/;
        // var r;
        // if ($(".mechanicalName").val().length>16) {
        //     alert("名称最多输入16位");
        //     return false;
        // }
        // r = regBox.test($(".mechanicalName").val());
        // if(!r){
        //     alert('只能书写数字、字母或汉字');
        //     return false;
        // }
        var mechanicalName=$(".mechanicalName").val();
        var preventCureName=$(".preventCureName").val();
        tabelData(mechanicalName,preventCureName);
    });
    $(function () {
        $(".add").click(function () {
            window.location.href="addMechanical.html";
        })
    });
    function tabelData(mechanicalName, preventCureName) {
        layui.use('table', function(){
            var table = layui.table;
            var laypage = layui.laypage;
            table.render({
                elem: '#demo'
                ,height: 350
                ,url: '../../servlet/showMechanical' //数据接口
                ,method:'post'
                ,limit:100
                ,limits:[10,20,30]
                ,request:{
                    pageName:'currentPage'
                    ,limitName:'pageSize'
                }
                ,where:{
                    mechanicalName:mechanicalName,
                    preventCureName:preventCureName
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
                    ,{field: 'mechanicalName', title: '器械名称',  sort: true}
                    ,{field: 'preventCureName', title: '防治类型' }
                    ,{field: 'mainUse', title: '主要用途',  sort: true}
                ]]
                ,page: true //开启分页
            });
        });
    }
});
