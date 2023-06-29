<%--
  Created by IntelliJ IDEA.
  User: DLC
  Date: 2023/6/26
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>水果详情</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="search_form">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 水果列表</strong></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li><a class="button border-main icon-plus-square-o" href="add.html"> 添加内容</a></li>
                <li>搜索：</li>
                <li>请选择搜索条件
                    <select name="cond" class="input" style="width:120px; line-height:17px; display:inline-block">
                        <option value="">请选择</option>
                        <option value="1">水果编号</option>
                        <option value="2">水果名称</option>
                        <option value="3">水果单价</option>
                        <option value="4">计价单位</option>
                    </select>
                    &nbsp;&nbsp;
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>

                    <button class="button bg-main icon-check-square-o" type="submit"> 搜索</button>

                </li>
            </ul>
        </div>
    </div>
</form>




<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">水果编号</th>
                <th width="20%">水果名称</th>
                <th width="20%">水果单价</th>
                <th width="20%">计价单位</th>
                <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">


                <tr>
                    <td style="text-align: left; padding-left: 20px;">
                        <input	type="checkbox" name="delId" value="" />
                        水果编号
                    </td>
                    <td>水果名称
                    </td>
                    <td>水果单价
                    </td>
                    <td>计价单位
                    </td>
                    <td width="310">
                        <div class="button-group">
                            <a class="button border-main"
                               href="update.html">
                                <span class="icon-edit"></span>修改</a>
                            <a class="button border-red"
                               href="javascript:void(0)"
                               onclick="return del()">
                                <span class="icon-trash-o"></span>删除</a>
                        </div>
                    </td>
                </tr>


                <tr>
                    <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox"
                                                                                          id="checkall"/>
                        全选
                    </td>
                    <td colspan="7" style="text-align:left;padding-left:20px;">
                        <a href="javascript:void(0)" class="button border-red icon-trash-o"
                           style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>
                        <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;"
                           class="button border-blue icon-edit" onclick="sorts()"> 排序</a>
                        排序依据：<select  id="sort" name="order" class="input" style="width:120px; line-height:17px; display:inline-block">
                        <option value="0">请选择</option>
                        <option value="number">水果编号</option>
                        <option value="fruitname">水果名称</option>
                        <option value="price">水果单价</option>
                        <option value="unit">计价单位</option>
                    </select>
                </tr>
            </volist>
        </table>
    </div>
</form>
<script type="text/javascript">

    //单个删除
    function del(number) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "";
        }
    }

    //全选
    $("#checkall").click(
        function () {
            $("input[name='delId']").each(function () {
                if (this.checked) {
                    this.checked = false;
                } else {
                    this.checked = true;
                }
            });
        }
    );

    //批量删除
    function DelSelect() {
        var check_val = [];
        var Checkbox = false;
        $("input[name='delId']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
                check_val.push(this.value);
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
            window.location.href = "";
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts() {
        var options=$("#sort option:selected");
        var sort=options.val();
        if (sort=="0") {
            alert("请选择要操作的内容!");
            return false;
        } else {
            window.location.href = "";
        }
    }

</script>
</body>
</html>

