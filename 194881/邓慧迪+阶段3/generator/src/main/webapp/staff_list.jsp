<%@ page import="java.util.List" %>
<%@ page import="com.seu.generator.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>员工列表</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //自适应屏幕宽度
            window.onresize=function(){ location=location };

            var main_h = $(window).height();
            $('.hy_list').css('height',main_h-45+'px');

            var search_w = $(window).width()-40;
            $('.search').css('width',search_w+'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<%
    List<User> stfList= (List<User>) request.getAttribute("LIST");
%>
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">员工列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">邮箱</th>
                    <th scope="col">上级ID</th>
                    <th scope="col">创建时间</th>
                    <th scope="col">操作</th>
                </tr>
                <%for (int i=0;i<stfList.size();i++){%>
                    <tr>
                        <td><%=stfList.get(i).getId()%></td>
                        <td><%=stfList.get(i).getName()%></td>
                        <td><%=stfList.get(i).getAge()%></td>
                        <td><%=stfList.get(i).getEmail()%></td>
                        <td><%=stfList.get(i).getManagerId()%></td>
                        <td><%=stfList.get(i).getCreateTime()%></td>
                        <td>
                            <a href="toEdit/<%=stfList.get(i).getId()%>" class="btn">编辑</a>
                            <a href="del/<%=stfList.get(i).getId()%>" class="btn">删除</a>
                        </td>
                    </tr>
                <%
                    }
                %>
            </table>
            <!--列表-->
            <!--右边底部-->
            <div class="r_foot">
                <div class="r_foot_m">
                    <a href="toAdd" class="btn">添加</a>
                </div>
            </div>
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>

