<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.seu.generator.model.User" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>编辑员工</title>
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

            var main_w = $(window).width();
            $('.xjhy').css('width',main_w-40+'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<%
    User stf_toEdit= (User) request.getAttribute("stf_toEdit");
    List<User> depList= (List<User>) request.getAttribute("LIST");
%>
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">编辑员工</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="./edit" method="post" name="editForm">
                <input type="hidden" name="id" value="${stf_toEdit.id}"/>
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">
                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="account" value="<%=stf_toEdit.getName()%>">

                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">上级：</span>
                            <div class="li_r">
<%--                                <input class="chang" name="did" type="text" value="<%=stf_toEdit.getDid()%>">--%>
                                <select name="did">
                                    <%for (int i=0;i<depList.size();i++){
                                        if (depList.get(i).getId().equals(stf_toEdit.getManagerId())){%>
                                            <option value="<%=depList.get(i).getId()%>" selected="selected">
                                                <%=depList.get(i).getName()%>
                                            </option>
                                        <%}else{%>
                                            <option value="<%=depList.get(i).getId()%>">
                                                <%=depList.get(i).getName()%>
                                            </option>
                                        <%}%>
                                    <%}%>
                                </select>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">年龄：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="<%=stf_toEdit.getAge()%>">
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">邮箱：</span>
                            <div class="li_r">
                                <input class="chang" name="idNumber" type="text" value="<%=stf_toEdit.getEmail()%>">
                            </div>
                        </li>
                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:editForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
