var myChart = echarts.init(document.getElementById('main'));
// 显示标题，图例和空的坐标轴
myChart.setOption({
    title: {
        text: '出库信息一览'
    },
    tooltip: {},
    legend: {
        data:['出库数量']
    },
    xAxis: {
        data: []
    },
    yAxis: {},
    series: [{
        name: '出库数量',
        type: 'bar',
        data: []
    }]
});

// 异步加载数据
$.get('../../servlet/OutboundReport').done(function (data) {
    var xData=[];
    var yData=[];
    var dataJson=JSON.parse(data);
    $.each(dataJson,function (i,n) {
        xData[i]=n.outboundType;
        yData[i]=n.outboundNum;
    })
    // 填入数据
    myChart.setOption({
        xAxis: {
            data: xData
        },
        series: [{
            // 根据名字对应到相应的系列
            name: '出库数量',
            data: yData
        }]
    });
});