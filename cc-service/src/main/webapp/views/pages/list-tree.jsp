<%--
  Created by IntelliJ IDEA.
  User: shanglei
  Date: 2017/8/7
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li>
                <a href="#"><i class="fa fa-edit fa-fw"></i> 项目管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/toprojectmanage">项目管理列表</a>
                    </li>
                    <li>
                        <a href="/toserverlist">服务器列表</a>
                    </li>
                    <li>
                        <a href="/toonlineorder">上线顺序</a>
                    </li>
                    <li>
                        <a href="/tostartorder">启动顺序</a>
                    </li>
                    <li>
                        <a href="/toxshellmanage">脚本管理</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
