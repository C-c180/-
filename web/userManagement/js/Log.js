$(function () {
    tableDat(null, null);
    $(".findBtn").click(function () {
        var startDate = $("#date").val();
        var endDate = $("#date1").val();
        tableDat(startDate,endDate);

    });
    function tableDat(startDate,endDate) {
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#demo'
                , height: 500
                , url: '../../servlet/ShowLog'
                , method: 'post'
                ,where:{startDate:startDate,
                    endDate:endDate
                }
                , request: {
                    pageName: 'currentPage' //页码的参数名称，默认：page
                    , limitName: 'pageSize' //每页数据量的参数名，默认：limit
                }
                , parseData: function (data) { //data 即为原始返回的数据

                    return {
                        "status": true, //解析接口状态
                        "count": data.total, //解析数据长度
                        "list": data.list //解析数据列表
                    };
                }
                , response: {
                    statusName: 'status' //规定数据状态的字段名称，默认：code
                    , statusCode: true //规定成功的状态码，默认：0
                    , msgName: 'msg' //规定状态信息的字段名称，默认：msg
                    , countName: 'count' //规定数据总数的字段名称，默认：count
                    , dataName: 'list' //规定数据列表的字段名称，默认：data
                }

                , cols: [[ //表头
                    {field: 'logContent', title: '日志内容', width: 580}
                    , {field: 'logDate', title: '日期', width: 500, sort: true}
                ]]
                , page: true //开启分页
            });

        })
    }
});

var form = layui.form
    ,laydate = layui.laydate;
laydate.render({
    elem: '#date'
});
laydate.render({
    elem: '#date1'
});




