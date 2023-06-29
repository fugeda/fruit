<%--
  Created by IntelliJ IDEA.
  User: DLC
  Date: 2023/6/26
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>水果超市管理中心</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
</head>
<body style="background-color:#ccffaa;">
<div class="header">
    <div class="logo margin-big-left fadein-top">
        <h1 style="color:red;"><img src="images/title.png" class="radius-circle rotate-hover" height="50" alt="" />水果超市管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-red" href="index.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title" style="color:red;"><strong><span class="icon-list" ></span>菜单列表</strong></div>
    <h2><span class="icon-pencil-square-o"></span>水果管理</h2>
    <ul style="display:block">
        <li><a href="list.html" target="right"><span class="icon-caret-right"></span>水果管理</a></li>
        <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加水果</a></li>
    </ul>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul>
        <li><a href="##" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="list.html" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文 </php></span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="list.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>

