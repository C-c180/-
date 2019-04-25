
$(function () {
    var form = layui.form
        ,laydate = layui.laydate;
    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });
    tabelData(null,null);
    $(".findBtn").click(function () {
            var startDate=$(".startDate").val();
            var endDate=$(".endDate").val();
            tabelData(startDate,endDate);
    });
    $(".add").click(function () {
        window.location.href="addOutbound.html";
    })
    $(".look").click(function () {
        window.location.href="showReport.html";
    })
    function tabelData(startDate, endDate) {
        layui.use('table', function(){
            var table = layui.table;
            var laypage = layui.laypage;
            table.render({
                elem: '#demo'
                ,height: 350
                ,url: '../../servlet/showOutbound' //数据接口
                ,method:'post'
                ,limit:100
                ,limits:[10,20,30]
                ,request:{
                    pageName:'currentPage'
                    ,limitName:'pageSize'
                }
                ,where:{
                    startDate:startDate,
                    endDate:endDate,
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
                    ,{field: 'outboundDate', title: '出库时间',  sort: true}
                    ,{field: 'itemName', title: '物品名称' }
                    ,{field: 'mainUse', title: '主要用途',  sort: true}
                    ,{field: 'recipientsNum', title: '领用数量' }
                    ,{field: 'className', title: '领用小班' }
                ]]
                ,page: true //开启分页
            });
        });
    }
});