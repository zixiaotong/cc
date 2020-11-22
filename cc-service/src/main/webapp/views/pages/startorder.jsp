<%--
  Created by IntelliJ IDEA.
  User: shanglei
  Date: 2017/8/7
  Time: 17:29
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

    <title>启动顺序</title>
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
                <h1 class="page-header">启动顺序</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        启动顺序
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>服务器IP</th>
                                    <th>部署项目</th>
                                    <th>启动顺序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                    <td>@fat</td>
                                    <td class="center">
                                        <a href="" type="button" class="btn btn-default">上移</a>
                                        <a href="" type="button" class="btn btn-default">下移</a>
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




</script>
</body>
</html>

