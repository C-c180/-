$(function () {
    // $(function () {
        var Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            var links = this.el.find('.link');
            links.on('click', {
                el: this.el,
                multiple: this.multiple
            }, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            var $el = e.data.el;
            $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                // $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            };
        };
        var accordion = new Accordion($('#accordion'), false);
    // });
    $(".exit").click(function () {
        $.ajax({
            url:"servlet/exit",
            type:"post",
            success:function (data) {
                if (data == 1) {
                    window.location.href="login.html";

                }
            }
        })
    });
});