<%--
  Created by IntelliJ IDEA.
  User: DLC
  Date: 2023/6/26
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>add</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="">
            <div class="form-group">
                <div class="label">
                    <label>水果编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="number" data-validate="required:请输入水果编号" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>水果名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入水果名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>水果单价：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="price" value="0"  data-validate="currency:单价必须为数字" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>计价单位：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="unit" data-validate="required:请输入计价单位" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

