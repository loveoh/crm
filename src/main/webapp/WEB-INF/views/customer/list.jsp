<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛CRM | 客户列表</title>
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
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="customer"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-header with-border">
                    <div class="box-title">客户列表</div>
                    <div class="box-tools">
                        <button class="btn btn-xs btn-success" id="newBtn"><i class="fa fa-plus"></i> 新增客户</button>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table" id="customerTable">
                        <thead>
                        <tr>
                            <th style="width:20px;"></th>
                            <th>客户名称</th>
                            <th>联系电话</th>
                            <th>电子邮件</th>
                            <th>等级</th>
                            <th style="width: 80px">#</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
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
                <h4 class="modal-title">新增客户</h4>
            </div>
            <div class="modal-body">
                <form id="newForm">
                    <div class="form-group">
                        <label>类型</label>
                        <div>
                            <label class="radio-inline">
                                <input type="radio" name="type" value="customer" checked id="radioPerson"> 个人
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="type" value="company" id="radioCompany"> 公司
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label id="_name">客户名称</label>
                        <input type="text" class="form-control" name="name" id="custOrCompany">
                    </div>
                    <div class="form-group">
                        <label>联系电话</label>
                        <input type="text" class="form-control" name="tel" >
                    </div>
                    <div class="form-group">
                        <label>客户等级</label>
                        <select name="level" class="form-control">
                            <option value=""></option>
                            <option value="1">★</option>
                            <option value="2">★★</option>
                            <option value="3">★★★</option>
                            <option value="4">★★★★</option>
                            <option value="5">★★★★★</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin">
                    </div>
                    <div class="form-group">
                        <label>电子邮件</label>
                        <input type="text" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input type="text" class="form-control" name="address">
                    </div>
                    <div class="form-group" id="companyList">
                        <label>所属公司</label>
                        <select name="companyid" class="form-control" >
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
                <h4 class="modal-title">编辑客户</h4>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <input type="hidden" name="userid" id="edit_userid">
                    <input type="hidden" name="id" id="edit_id">
                    <input type="hidden" name="type" id="edit_type">
                    <div class="form-group">
                        <label id="nameOrCompany">客户名称</label>
                        <input type="text" class="form-control" name="name" id="edit_name">
                    </div>
                    <div class="form-group">
                        <label>联系电话</label>
                        <input type="text" class="form-control" name="tel" id="edit_tel">
                    </div>
                    <div class="form-group">
                        <label>客户等级</label>
                        <select name="level" class="form-control" id="edit_level">
                            <option value=""></option>
                            <option value="1">★</option>
                            <option value="2">★★</option>
                            <option value="3">★★★</option>
                            <option value="4">★★★★</option>
                            <option value="5">★★★★★</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>微信号</label>
                        <input type="text" class="form-control" name="weixin" id="edit_weixin">
                    </div>
                    <div class="form-group">
                        <label>电子邮件</label>
                        <input type="text" class="form-control" name="email" id="edit_email">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input type="text" class="form-control" name="address" id="edit_address">
                    </div>
                    <div class="form-group" id="editCompanyList">
                        <label>所属公司</label>
                        <select name="companyid" class="form-control"></select>
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
<script src="/static/plugins/layer/layer.js"></script>

<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>

<script>
    $(function () {

        $("#saveBtn").click(function () {
            $("#newForm").submit();
        });

        //显示所有用户
        var dataTables = $('#customerTable').DataTable({
            "lengthMenu": [5, 10, 15, 20],
            "serverSide": true,
            "ajax": {
                url:"/customerManagement/data.json",
                type:"post",

            },
            "ordering":false,

            "columns":[
                {"data":function (row) {
                    if(row.type =="company"){
                        return "<i class='fa fa-bank'></i>";
                    } else {
                        return "<i class='fa fa-user'></i>";
                    }

                }},
                {"data":function (row) {
                    if(row.name != null && row.companyname == null){
                        return "<a href=''>" + row.name + "</a>";
                    } else if(row.name == null && row.companyname != null){
                        return "<a href=''>" + row.companyname + "</a>";
                    } else if(row.name != null && row.companyname != null){
                        return "<a href=''>" + row.name + "</a> - <a href=''>" + row.companyname + "</a>";
                    }
                }},
                {"data":"tel"},
                {"data":"email"},
                {"data":function (row) {
                    if (row.level == 1) {
                        return "<span style='color:#ff7400'>★</span>";
                    } else if (row.level == 2) {
                        return "<span style='color:#ff7400'>★★</span>";
                    }else if (row.level == 3) {
                        return "<span style='color:#ff7400'>★★★</span>";
                    }else if (row.level == 4) {
                        return "<span style='color:#ff7400'>★★★★</span>";
                    }else if (row.level == 5) {
                        return "<span style='color:#ff7400'>★★★★★</span>";
                    }
                }},

                {"data":function (row) {

                        return "<a href='javascript:;' rel='" + row.id + "' class='editLink'>编辑</a> " <shiro:hasRole name="经理"> +"  <a href='javascript:;' class='delLink' rel='"+ row.id +"'>删除</a>"</shiro:hasRole>;

                        /*return "<a href='#'>删除</a>";  这一步分需要shiro权限的支持，只有经理才能删除用户*/

                }},
            ],

            "language" : {
                "sProcessing" : "处理中...",
                "sLengthMenu" : "显示 _MENU_ 项结果",
                "sZeroRecords" : "没有匹配结果",
                "sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix" : "",
                "sSearch" : "客户名称或电话:",
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


        //新增用户
        $("#newForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                "name":{
                    required:true
                },
                "tel":{
                    required:true,

                    digits:true
                }
            },
            messages:{
                "name":{
                    required:"必填字段"
                },
                "tel":{
                    required:"必填字段",

                    digits:"必须是数字"
                }
            },
            submitHandler:function () {//表单验证必须subimit提交。添加用户ajax之后，只需要刷新页面
                $.post("/customerManagement/newCustmoer",$("#newForm").serialize()).done(function (json) {
                    if(json.status == "success"){
                        layer.msg("添加成功！");
                        window.history.go(0);
                    } else {
                        layer.msg(json.message);
                    }


                }).error(function () {
                    layer.msg("服务器繁忙");
                });
            }
        });

        //新增用户
        $("#newBtn").click(function () {
            //重置表单
            $("#newForm")[0].reset();

            //获取所有公司
            $.get("/customerManagement/company").done(function (json) {
                if(json.status == "success"){
                    var data = json.data;
                    $("#companyList .form-control").html("");
                    var html = "<option></option>";
                    $("#companyList .form-control").append(html);
                    if(data && data.length) {
                        for (var i = 0;i<data.length;i++) {
                            var option = "<option value='"+ data[i].id +"'>"+ data[i].companyname +"</option>";
                            $("#companyList .form-control").append(option);

                        }
                    }
                } else {
                    layer.msg(json.message);
                }

            }).error(function () {
                layer.msg("服务器繁忙！");
            });



            $("#companyList").show();

            $("#newModal").modal({
                show:true,
                dropback:'static',
                keyboard:false
            });

            $("#radioCompany").click(function () {
                if($(this)[0].checked){
                    $("#companyList").hide();
                    $("#custOrCompany").attr("name","companyname");
                    $("#_name").html("公司名称");
                }

            });

            $("#radioPerson").click(function () {
                if($(this)[0].checked){
                    $("#companyList").show();
                    $("#custOrCompany").attr("name","name");
                    $("#_name").html("客户名称");
                }

            });
        });

        //编辑用户,衍生出的超链，不能绑定事件，需要事件委托
        $(document).delegate(".editLink","click",function () {

            //根据id获取对应信息
            var id = $(this).attr("rel");

            //获取所有公司
            $.get("/customerManagement/company").done(function (json) {
                if(json.status == "success"){
                    var customerList = json.data;
                    $("#editCompanyList select").html("");
                    $("#editCompanyList select").append("<option></option>");
                    for(var i = 0;i<customerList.length;i++){
                        var option = "<option value='" + customerList[i].id + "'>" + customerList[i].companyname + "</option>";
                        $("#editCompanyList select").append(option);
                    }

                } else {
                    layer.msg();
                }
            }).error(function () {
                layer.msg("服务器繁忙，请稍候再试！");
            });


            $.get("/customerManagement/"+ id +"/customer").done(function (json) {
                if(json.status == "success"){
                    var customer = json.data;
                    $("#edit_userid").val(customer.userid);
                    $("#edit_id").val(customer.id);
                    $("#edit_type").val(customer.type);
                    /*前三个不改变，作为隐藏域，这样又提交过去，update的sql可以写为通用的，但是不能改createtime*/

                    //是公司的话就是companyname
                    if(customer.type == "company"){
                        $("#edit_name").val(customer.companyname);
                    } else {
                        $("#edit_name").val(customer.name);
                    }
                    $("#edit_tel").val(customer.tel);
                    $("#edit_level").val(customer.level);
                    $("#edit_weixin").val(customer.weixin);
                    $("#edit_email").val(customer.email);
                    $("#edit_address").val(customer.address);
                    //提交过去的是companyid。并且是用户不去隐藏editCompanyList，是公司才去隐藏editCompanyList
                    $("#editCompanyList select").val(customer.companyid);

                    //判断公司隐藏editCompanyList
                    if(customer.type == "company"){
                        $("#editCompanyList").hide();
                        //并且name值属性变为companyname
                        $("#edit_name").attr("name","companyname");
                        $("#nameOrCompany").html("公司名称");
                    } else if (customer.type == "customer"){
                        $("#editCompanyList").show();
                        $("#edit_name").attr("name","name");
                        $("#nameOrCompany").html("客户名称");
                    }
                } else {
                    layer.msg();
                }
            }).error(function () {
                layer.msg("服务器繁忙，请稍候再试！");
            });




            $("#editModal").modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });

            //判断 公司不显示 companyList

        });
        

        //编辑用户
        $("#editForm").validate({
            errorClass:"span",
            errorElement:"text-danger",
            rules:{
                "name":{
                    required:true
                },
                "tel":{
                    required:true,

                    digits:true
                }

            },
            messages:{
                "name":{
                    required:"必填字段"
                },
                "tel":{
                    required:"必填字段",

                    digits:"必须是数字"
                }
            },
            submitHandler:function () {
                
                $.post("/customerManagement/eidt",$("#editForm").serialize()).done(function (json) {
                    if(json.status == "success"){
                        layer.msg("修改成功！");
                        window.history.go(0);
                    } else {
                        layer.msg(json.message);
                    }
                }).error(function () {
                    layer.msg("服务器繁忙，请稍候再试！");
                });
            }
            
        });

        $("#editBtn").click(function () {
            $("#editForm").submit();
        });


        //删除客户，经理权限
        <shiro:hasRole name="经理">

            $(document).delegate(".delLink","click",function () {
                var id = $(this).attr("rel");

                layer.confirm('如果是公司会自动删除关联数据，您确定要删除吗?', function(index){
                    //do something
                    $.get("/customerManagement/"+ id +"/del").done(function (json) {
                        
                    }).error(function () {
                        layer.msg("服务器繁忙，请稍后再试！");
                    });
                    
                    layer.close(index);
                });
                

            });

        </shiro:hasRole>


    });

</script>
</body>
</html>

