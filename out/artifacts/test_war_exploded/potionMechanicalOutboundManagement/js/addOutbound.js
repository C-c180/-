$(function () {
        $.ajax({
            url:"../../servlet/deliveryMan",
            type:"post",
            dataType:"json",
            success: function(msg){
                $("#deliveryMan").val(msg.realName);
            }
        })
        $("#itemName").blur(function () {
            var text=$("#itemName").val();
            var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{1,20}$/ig;
            if (pattern.test(text)) {
                $("#itemNameOne").css("display","none");
            }else{
                $("#itemNameOne").css("display","block");
            }
        });
        $("#recipientsNum").blur(function () {
            var text=$("#recipientsNum").val();
            var pattern=/^[0-9].{0,3}$/ig;
            if (pattern.test(text)&&text!="0") {
                $("#recipientsNumOne").css("display","none");
            }else{
                $("#recipientsNumOne").css("display","block");
            }
        });
        $("#mainUse").blur(function () {
            var text=$("#mainUse").val();
            var pattern=/^[\u4E00-\u9FA5A-Za-z0-9].{1,50}$/ig;
            if (pattern.test(text)) {
                $("#mainUseOne").css("display","none");
            }else{
                $("#mainUseOne").css("display","block");
            }
        });
        $.ajax({
            type :"post",
            url :"../../servlet/loadAddOutbound",
            dataType:"json",
            success: function(msg){
                var str = "";
                $.each(msg,function (i,n) {
                    str+="<option value="+n.id+">"+n.clazzName+"</option>";
                });
                $("#classId").html(str);
                var form = layui.form;
                form.render('select',"test2");
            }
        })

   $(".add").click(function () {
       var regBox =  /^[\u4E00-\u9FA5A-Za-z0-9].{0,70}$/;
       var r;
       if ($("#itemName").val().length>20) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       r = regBox.test($("#itemName").val());
       if(!r){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }



       if ($("#recipientsNum").val().length==0||$("#recipientsNum").val().length>=4) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法3'
           });
           return false;
       }
       var regBox1 =  /^[1-9]|[1-9][0-9]|[1-9][0-9][0-9]$/;
       var e;
       e = regBox1.test($("#recipientsNum").val());
       if(!e){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }



       if ($("#mainUse").val().length>50) {
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       var w;
       w = regBox.test($("#mainUse").val());
       if(!w){
           layer.open({
               title: '提示'
               ,content: '请输入内容或你输入的内容不合法'
           });
           return false;
       }
       $.ajax({
           type :"post",
           url :"../../servlet/addOutbound",
           data:{outboundTypeId:$("#outboundTypeId").val(),
               preventCureTypeId:$("#preventCureTypeId").val(),
               itemName:$("#itemName").val(),
               recipientsNum:$("#recipientsNum").val(),
               classId:$("#classId").val(),
               mainUse:$("#mainUse").val()},
           success:function(data) {
               if(data==1){
                   window.location.href="outboundManagement.html"
               }
           }
       });
   });
   $(".back").click(function () {
       window.location.href="outboundManagement.html";
   });
});