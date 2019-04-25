$(function () {
    $(".information").click(function () {
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
            var id=checkStatus.data[0].id;
            console.log(checkStatus.data[0].id)
            window.location.href="meeting.html?"+id;        }

    })

})