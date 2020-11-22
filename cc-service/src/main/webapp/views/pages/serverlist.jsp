<%--
  Created by IntelliJ IDEA.
  User: shanglei
  Date: 2017/8/7
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>服务器列表</title>
    <link href="../views/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../views/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="../views/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="../views/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <link href="../views/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="../views/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="wrapper">

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">上线工具</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <c:import url="head.jsp" charEncoding="UTF-8"/>
        </ul>
        <c:import url="list-tree.jsp" charEncoding="UTF-8"/>
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">服务器列表</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        服务器列表
                    </div>
                    <div class="panel-body">
                        <div class="form-group col-lg-6">
                            <button class="btn btn-primary" style="margin-top: 20px" type="submit">一键启动</button>
                            <button class="btn btn-primary" style="margin-top: 20px" type="submit">一键停机</button>
                            <a href="" type="button" class="btn btn-primary"
                               style="margin-left:5px;margin-top: 20px">编辑启动顺序
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        项目列表
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>全选</th>
                                    <th>服务器IP</th>
                                    <th>上次部署时间</th>
                                    <th>启动顺序</th>
                                    <th>运行状态</th>
                                    <th>操作人</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                    <td>@fat</td>
                                    <td>@fat</td>
                                    <td class="center">
                                        <a href="" type="button" class="btn btn-default">查看运行日志</a>
                                        <a onclick="btn_del()" type="button" class="btn btn-default">停机</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- 是否停机启动弹出层 start-->
<div class="modal fade" id="delOper" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="delOperLabel"></h4>
            </div>
            <input type="hidden" id="delid">
            <div class="modal-body" style="padding-top: 0px;">
                <div style="margin-top: 20px;text-align: center;font-size: 20px;">
                    <strong>当前服务是启动/停机状态，是否需要启动/停机?</strong>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- 是否停机启动弹出层 end-->

<script src="../views/vendor/jquery/jquery.min.js"></script>
<script src="../views/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../views/vendor/metisMenu/metisMenu.min.js"></script>
<script src="../views/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../views/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../views/vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="../views/dist/js/sb-admin-2.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    function btn_del(){
        $("#delOperLabel").text("是否启动/停机");
        $('#delOper').modal();
        $("#delid").val();
    }

</script>
</body>
</html>

