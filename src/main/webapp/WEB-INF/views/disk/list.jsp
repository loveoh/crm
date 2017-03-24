<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛CRM | 文档管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/webuploader/webuploader.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="document"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">文档列表</h3>
                    <div class="box-tools">
                        <span id="uploadBtn"><span class="text"><i class="fa fa-upload"></i> 上传文件</span></span>
                        <button class="btn btn-bitbucket btn-xs" id="newDir"><i class="fa fa-folder"></i> 新建文件夹</button>
                    </div>
                </div>
                <div class="box-body">

                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th>名称</th>
                            <th>大小</th>
                            <th>创建人</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty diskList}">
                            <tr>
                                <td colspan="5">暂时没有任何数据</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${diskList}" var="disk">
                            <tr>
                                <td>
                                    <c:choose>
                                        <c:when test="${disk.type == 'file'}">
                                            <i class="fa fa-file-o"></i>
                                        </c:when>
                                        <c:otherwise>
                                            <i class="fa fa-folder-o"></i>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${disk.type == 'file'}"><%--下载--%>
                                            <a href="/doc/${disk.id}/download">${disk.sourceName}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="/doc?fid=${disk.id}">${disk.sourceName}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${disk.size}</td>
                                <td>${disk.createUser}</td>
                                <td>${disk.createTime}</td>

                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<div class="modal fade" id="dirModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新建文件夹</h4>
            </div>
            <div class="modal-body">
                <form action="/doc/dir/new" method="post" id="saveDirForm">
                    <input type="hidden" name="fid" value="${fid}">
                    <div class="form-group">
                        <label>文件夹名称</label>
                        <input type="text" class="form-control" name="sourceName" id="dirname">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveDirBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="/static/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/webuploader/webuploader.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>

    $(function () {


        /*文件上传*/
        var uploader = WebUploader.create({
            swf : "/static/plugins/webuploader/Uploader.swf",
            server: "/doc/uploader",
            pick: '#uploadBtn',
            auto : true,
            fileVal:'file',
            formData:{
                fid:${requestScope.fid}
            }
        });
        uploader.on( 'uploadSuccess', function( file,data) {
            layer.msg("文件"+ data.sourceName +"上传成功");
            window.history.go(0);
        });

        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器繁忙，请稍候再试！");
        });


        /*创建文件夹*/
        $("#newDir").click(function () {



            $("#dirModal").modal({
                show:true,
                backdrop:'static'
            });

        });

        /*创建文件夹*/
        $("#saveDirBtn").click(function () {


            if(!$("#dirname").val()){

                $("#dirname").focus();
                return;//return表示结束，没有收入文件名称就结束，不提交
            }


            $("#saveDirForm").submit();

        });





    });

</script>
</body>
</html>
