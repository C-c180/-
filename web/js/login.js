$(function () {
    verify();
    var isRun=false;
    $("#login").click(function () {
        if (!isRun) {
            layer.open({
                title: '提示'
                ,content: '请滑动验证码'
            });
            return false;
        }
        $.ajax({
            url:"login",
            type:"post",
            async:true,
            data:{
                "userName":$("#userName").val(),
                "pwd":$("#pwd").val()},
            success:function(data){
                console.log(data);
                if (data =="1"){
                    window.location.href="main.html";
                }else{
                    layer.open({
                        title: '提示'
                        ,content: '用户名或密码错误'
                    });
                }
            }
        });
    });
    function verify(){
        $('#mpanel1').slideVerify({
            type : 1,		//类型
            vOffset : 5,	//误差量，根据需求自行调整
            barSize : {
                width : '300px',
                height : '40px',
            },
            ready : function() {
            },
            success : function() {
                isRun=true;
            },
            error : function() {
//		        	alert('验证失败！');
            }
        });
    }
});
