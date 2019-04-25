$(function () {
    tabelData(null, null);
    $(".findBtn").click(function () {
        console.log("111");
        var diseaseName=$(".diseaseName").val();
        var rule=$(".rule").val();
        console.log(diseaseName);
        console.log(rule);
        tabelData(diseaseName,rule);
    });
    $(".add").click(function () {
        window.location.href="addiInsectDisease.html";
    });
    $(".information").click(function () {
        var table = layui.table;
        var checkStatus = table.checkStatus('idTest');
        if (checkStatus.data.length == 0) {
            layer.open({
                title: '提示'
                ,content: '请选中行'
            });
            return false;
        }
        var id=checkStatus.data[0].id;
        console.log(id);
        window.location.href="findInsectDisease.html?"+id;
    });
    function tabelData(diseaeName, symptom) {
        layui.use('table', function(){
            var table = layui.table;
            var laypage = layui.laypage;
            table.render({
                elem: '#demo'
                ,id:'idTest'
                ,height: 350
                ,url: '../../servlet/disease/show' //数据接口
                ,method:'post'
                ,limit:100
                ,limits:[10,20,30]
                ,request:{
                    pageName:'pageNum'
                    ,limitName:'pageSize'
                }
                ,where:{
                    diseaseName:diseaeName,
                    symptom:symptom
                }
                ,parseData: function(res){ //res 即为原始返回的数据
                    console.log(res)
                    console.log(res.hasNextPage)
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
                    ,{field: 'id', title: 'id', sort: true,hide:true}
                    ,{field: 'name', title: '名称', sort: true}
                    ,{field: 'mainDanger', title: '主要危害',sort: true}
                    ,{field: 'rule', title: '发病规律', sort: true}
                ]]
                ,page: true //开启分页
            });

        });
    }
});
