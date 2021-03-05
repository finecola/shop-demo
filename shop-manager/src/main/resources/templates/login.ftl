<#assign ctx=request.contextPath/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>shop管理后台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
          name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 禁止浏览器发起 favicon.ico 请求 -->
    <link rel="icon" href="data:image/ico;base64,aWNv">
    <!-- Bootstrap 3.3.4 -->
    <link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- FontAwesome 4.3.0 -->
    <link href="${ctx}/static/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons 2.0.0 -->
    <#--<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
    rel="stylesheet" type="text/css"/>-->
    <!-- Theme style -->
    <link href="${ctx}/static/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/static/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css"/>
    <!-- iCheck -->
    <link href="${ctx}/static/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.1.4 -->
    <script src="${ctx}/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="${ctx}/static/js/global.js"></script>
    <script src="${ctx}/static/js/upgrade.js"></script>
    <script src="${ctx}/static/js/myFormValidate.js"></script>
    <script src="${ctx}/static/js/layer/layer-min.js"></script>
    <!--弹窗js 参考文档 http://layer.layui.com/-->
    <script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/js/myAjax.js"></script>
    <style>#imgVerify {
            width: 120px;
            margin: 0 auto;
            text-align: center;
            display: block;
        }    </style>
    <script>
        function detectBrowser() {
            var browser = navigator.appName
            if (navigator.userAgent.indexOf("MSIE") > 0) {
                var b_version = navigator.appVersion
                var version = b_version.split(";");
                var trim_Version = version[1].replace(/[ ]/g, "");
                if ((browser == "Netscape" || browser == "Microsoft Internet Explorer")) {
                    if (trim_Version == 'MSIE8.0' || trim_Version == 'MSIE7.0' || trim_Version == 'MSIE6.0') {
                        alert('请使用IE9.0版本以上进行访问');
                        return;
                    }
                }
            }
        }

        detectBrowser();
    </script>
    <meta name="__hash__" content="35a35d71936253d091570f5dcdf3efda_36195b7c33bcc5ab73f67451e5438f65"/>
</head>
<body class="login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>ego</b></a>
    </div>
    <div class="login-box-body">
        <p class="login-box-msg">管理后台</p>
        <div class="form-group has-feedback">
            <input type="text" name="username" id="username" class="form-control" placeholder="账号"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="password" class="form-control" id="password" placeholder="密码"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <opinioncontrol realtime="true" opinion_name="vertify_code" default="true">
                <div class="row" style="padding-right: 65px;">
                    <div class="col-xs-8">
                        <input style="width: 135px" type="text" name="vertify" id="vertify" class="formcontrol"
                               placeholder="验证码"/>
                    </div>
                    <div class="col-xs-4">
                        <img id="imgVerify" style="cursor:pointer;" src="${ctx}/image/code"
                             alt="点击更换" title="点击更换"/>
                    </div>
                </div>
            </opinioncontrol>
        </div>
        <!--
        <div class="row">
          <div class="col-xs-8">
            <div class="checkbox icheck">
              <label><input type="checkbox"> 记住密码  </label>
            </div>
          </div>
          <div class="col-xs-4">
            <div class="checkbox icheck">
              <label><a href="#">找回密码</a></label>
            </div>
          </div>
        </div> -->
        <div class="form-group">
            <button type="button" class="btn btn-primary btn-block btn-flat" onclick="userLogin()">
                立即登陆
            </button>
        </div>
    </div>

    <div class="margin text-center">
        <div class="copyright">
            2014-2016 &copy; <a href="http://www.ego.cn">ego v1.3.3</a>
            <br/>
        </div>
    </div>
</div><!-- /.login-box -->
<!-- jQuery 2.1.4 -->
<script src="${ctx}/static/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- iCheck -->
<script src="${ctx}/static/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/layer/layer.js"></script><!-- 弹窗js 参考文档 http://layer.layui.com/-->
<script>
    //页面加载完成自动执行getKaptchaImage()
    $(function () {
        getKaptchaImage();
    });

    //点击更换验证码
    function getKaptchaImage() {
        $("#imgVerify").on("click", function () {
            var url = "${ctx}/image/code?time=" + new Date();
            $(this).attr("src", url);
        });
    }

    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });


    function fleshVerify() {
        //重载验证码
        $('#imgVerify').attr('src', '/index?m=Admin&c=Admin&a=vertify&r=' + Math.floor(Math.random() * 100));
    }


    jQuery.fn.center = function () {
        this.css("position", "absolute");
        this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
            $(window).scrollTop()) - 30 + "px");
        this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +
            $(window).scrollLeft()) + "px");
        return this;
    }

    function checkLogin() {
        var username = $('#username').val();
        var password = $('#password').val();
        var vertify = $('input[name="vertify"]').val();
        if (username == '' || password == '') {
            layer.alert('用户名或密码不能为空', {icon: 2}); //alert('用户名或密码不能为空');
            return;
        }
        if (vertify == '') {
            layer.alert('验证码不能为空', {icon: 2});
            return;
        }
        if (vertify.length != 4) {
            layer.alert('验证码错误', {icon: 2});
            //fleshVerify();
            return;
        }

        $.ajax({
            url: '/index?m=Admin&c=Admin&a=login&t=' + Math.random(),
            type: 'post',
            dataType: 'json',
            data: {username: username, password: password, vertify: vertify},
            success: function (res) {
                if (res.status == 1) {
                    top.location.href = res.url;
                } else {
                    layer.alert(res.msg, {icon: 2});
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert('网络失败，请刷新页面后重试', {icon: 2});
            }
        })
    }

    document.onkeydown = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode == 13) {
            checkLogin();
        }
    }

    // 用户登录
    function userLogin() {
        // 必须输入用户名、密码、验证码
        var username = $("#username").val();
        var password = $("#password").val();
        var vertify = $("#vertify").val();
        if (undefined == username || "" == username) {
            layer.alert("请输入用户名！");
            return;
        }
        if (undefined == password || "" == password) {
            layer.alert("请输入密码！");
            return;
        }
        if (undefined == vertify || "" == vertify) {
            layer.alert("请输入验证码！");
            return;
        }
        $.ajax({
            url: "${ctx}/user/login",
            type: "POST",
            data: {
                userName: username,
                password: password,
                vertify: vertify
            },
            dataType: "JSON",
            success: function (result) {
                if (200 == result.code) {
                    location.href = "${ctx}/index";
                } else {
                    // 模拟点击事件行为
                    $("#imgVerify").trigger("click");
                    layer.alert(result.message);
                }
            },
            error: function () {
                layer.alert("亲，系统正在升级中，请稍后再试！");
            }
        });
    }

</script>
</body>
</html>
