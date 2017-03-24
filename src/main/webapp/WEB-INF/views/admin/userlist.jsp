<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>凯盛CRM-员工管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/datatables/css/dataTables.bootstrap.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <%@include file="../include/leftSide.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                员工管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">员工列表</h3>
                    <div class="box-tools pull-right">
                        <a href="javascript:;" id="newBtn" class="btn btn-xs btn-success"><i class="fa fa-plus"></i> 新增</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table" id="userTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>账号</th>
                            <th>员工姓名</th>
                            <th>微信号</th>
                            <th>角色</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody> </tbody>
                    </table>
                </div>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->


<div class="modal fade" id="newModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增用户</h4>
            </div>
            <div class="modal-body">
                <form id="newForm" method="post" action="/admin/save">
                    <div class="form-group">
                        <label>账号(用于系统登录)</label>
                        <input type="text" class="form-control" name="usename">
                    </div>
                    <div class="form-group">
                        <label>员工姓名(真实姓名)</label>
                        <input type="text" class="form-control" name="realname">
                    </div>
                    <div class="form-group">
                        <label>密码(默认 000000)</label>
                        <input type="text" class="form-control" name="password" value="000000">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin">
                    </div>
                    <div class="form-group">
                        <label>角色</label>
                        <select class="form-control" name="roleid">
                            <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}">${role.viewName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" id="editModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑用户</h4>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <input type="hidden" name="id" id="edit_user_id">
                    <div class="form-group">
                        <label>账号(用于系统登录)</label>
                        <input type="text" class="form-control" readonly name="usename" id="edit_user_username">
                    </div>
                    <div class="form-group">
                        <label>员工姓名(真实姓名)</label>
                        <input type="text" class="form-control" name="realname" id="edit_user_realname">
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin" id="edit_user_weixin">
                    </div>
                    <div class="form-group">
                        <label>角色</label>
                        <select class="form-control" name="roleid" id="edit_user_roleid">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${role.id}">${role.viewName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <select class="form-control" name="enable" id="edit_user_enable">
                            <option value="true">正常</option>
                            <option value="false">禁用</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="editBtn">保存</button>
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
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>

    $(function () {

        var dataTable = $("#userTable").DataTable({

            "lengthMenu":[5,10,15,20],
            "serverSide":true,//所有请求在客户端处理
            "ajax":{
                url:"/admin/users/data.json",
                type:"post"
            },
            "ordering":false,//不排序
            "columns":[//客户端接受值
                {"data":"id"},
                {"data":"usename"},
                {"data":"realname"},
                {"data":"weixin"},
                {"data":"role.viewName"},
                {"data":function (row) {
                    if(row.enable){
                        return "<span class='label label-success'>正常</span>";
                    } else {
                        return "<span class='label label-danger'>禁用</span>";
                    }
                }},
                {"data":"createtime"},
                {"data":function (row) {
                    if(row.role.viewName == '管理员'){
                        return '';
                    } else {
                        return "<a href='javascript:;' class='reset' rel='" + row.id + "'>重置密码</a> <a href='javascript:;' class='update' rel='" + row.id + "'>编辑</a>";
                    }
                }}

            ],
            "language" : {
                "sProcessing" : "处理中...",
                "sLengthMenu" : "显示 _MENU_ 项结果",
                "sZeroRecords" : "没有匹配结果",
                "sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix" : "",
                "sSearch" : "请输入员工姓名或者登录帐号:",
                "sUrl" : "",
                "sEmptyTable" : "表中数据为空",
                "sLoadingRecords" : "载入中...",
                "sInfoThousands" : ",",
                "oPaginate" : {
                    "sFirst" : "首页",
                    "sPrevious" : "上页",
                    "sNext" : "下页",
                    "sLast" : "末页"
                },
                "oAria" : {
                    "sSortAscending" : ": 以升序排列此列",
                    "sSortDescending" : ": 以降序排列此列"
                }
            }
        });


        /*新增用户*/
        $("#newBtn").click(function () {




            $("#newModal").modal({
                show:true,
                backdrop:'static'
            });
        });

        $("#newForm").validate({

            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                usename:{
                    required:true
                },
                realname:{
                    required:true
                },
                password:{
                    required:true,
                    rangelength:[6,18]
                },
                weixin:{
                    required:true
                }
            },
            messages:{
                usename:{
                    required:"必填字段"
                },
                realname:{
                    required:"必填字段"
                },
                password:{
                    required:"必填字段",
                    rangelength:"密码必须为6-18位"
                },
                weixin:{
                    required:"必填字段"
                }
            }

        });


        /*编辑用户*/
        $("#editForm").validate({

            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                usename:{
                    required:true
                },
                realname:{
                    required:true
                },
                password:{
                    required:true,
                    rangelength:[6,18]
                },
                weixin:{
                    required:true
                }
            },
            messages:{
                usename:{
                    required:"必填字段"
                },
                realname:{
                    required:"必填字段"
                },
                password:{
                    required:"必填字段",
                    rangelength:"密码必须为6-18位"
                },
                weixin:{
                    required:"必填字段"
                }
            },
            submitHandler:function () {
                //重写submit提交
                $.post("/admin/edit",$("#editForm").serialize()).done(function (result) {

                    if(result.status == "success"){
                        layer.msg("员工信息修改成功！");
                        window.history.go(0);
                    } else {
                        layer.msg(result.message);
                    }

                }).error(function () {
                    layer.msg("服务器繁忙，请稍候再试！");
                });
            }
        });

        $("#editBtn").click(function () {
            $("#editForm").submit();
        });

        /*新增提交*/
        $("#saveBtn").click(function () {
            $("#newForm").submit();

        });

        /*重置密码000000--管理员，对员工操作*/
        $(document).delegate(".reset","click",function () {

            var id = $(this).attr("rel");

            layer.confirm('您确定要将密码重置为：000000 ?', function(index){
                //do something

                $.get("/admin/"+id+"/resetPassWord").done(function (result) {

                    if(result.status == "success"){
                        layer.msg("用户"+ result.data + "密码重置成功！");
                    } else {
                        layer.msg(result.message);
                    }

                }).error(function () {
                    layer.msg("服务器繁忙，请稍候再试！");
                });


                layer.close(index);
            });

        });

        $(document).delegate(".update","click",function (){

            var id = $(this).attr("rel");

            $.get("/user/"+id).done(function (result) {

                if(result.status == "success"){

                    $("#edit_user_id").val(result.data.id);
                    $("#edit_user_username").val(result.data.usename);
                    $("#edit_user_realname").val(result.data.realname);
                    $("#edit_user_weixin").val(result.data.weixin);
                    $("#edit_user_roleid").val(result.data.roleid);
                    $("#edit_user_enable").val(result.data.enable+"");

                } else {
                    layer.msg(result.message);
                }

            }).error(function () {
                layer.msg("服务器繁忙，请稍候再试！");
            });


            $("#editModal").modal({
                show:true,
                backdrop:'static'
            });
        });


    });


</script>
</body>
</html>
