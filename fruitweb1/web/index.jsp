<%--
  Created by IntelliJ IDEA.
  User: DLC
  Date: 2023/6/26
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>水果超市欢迎您!</title>
  <link rel="stylesheet" href="css/pintuer.css">
  <link rel="stylesheet" href="css/admin.css">
  <script src="js/jquery.js"></script>
  <script src="js/pintuer.js"></script>
</head>

<body>
<div class="bg"></div>
<div class="container">
  <div class="line bouncein">
    <div class="xs6 xm4 xs3-move xm4-move">
      <div style="height:150px;"></div>
      <div class="media media-y margin-big-bottom">
      </div>
      <form action="LoginServlet" method="post">
        <div class="panel loginbox">
          <div class="text-center margin-big padding-big-top"><h1>用户登录</h1></div>
          <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
            <div class="form-group">
              <div class="field field-icon-right">
                <input type="text" class="input input-big" name="name" placeholder="登录账号" data-validate="required:请填写账号" />
              </div>
            </div>
            <div class="form-group">
              <div class="field field-icon-right">
                <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
              </div>
            </div>
            <div class="form-group">
              <div class="field">
                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                <img src="CheckServlet"  onclick="reloadimg()" id="code" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;">
              </div>
            </div>
          </div>
          <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
<script>
  function reloadimg() {
    var time=new Date().getTime();
    document.getElementById("code").src="CheckServlet?d="+time;
  }

</script>
