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
    <title>凯盛CRM | 客户信息 | ${customer.name}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.css">
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="customer"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <h1>　</h1>
            <ol class="breadcrumb">
                <li><a href="/customerManagement"><i class="fa fa-dashboard"></i> 客户列表</a></li>
                <li class="active">
                <c:choose>
                    <c:when test="${customer.type == 'company'}">
                        ${customer.companyname}
                    </c:when>
                    <c:otherwise>
                        ${customer.name}
                    </c:otherwise>
                </c:choose>
                </li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box box-primary">
                <div class="box-header">
                    <h3 class="box-title">
                        <c:choose>
                            <c:when test="${customer.type == 'customer'}">
                                <i class="fa fa-user"></i>
                                ${customer.name}
                            </c:when>
                            <c:otherwise>
                                <i class="fa fa-bank"></i>
                                ${customer.companyname}
                            </c:otherwise>
                        </c:choose>

                    </h3>
                    <div class="box-tools">
                        <c:if test="${not empty customer.userid}">
                            <button class="btn btn-danger btn-xs" id="openCust">公开客户</button>
                            <button class="btn btn-info btn-xs" id="moveCust">转移客户</button>
                        </c:if>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tr>
                            <td style="width: 100px">联系电话</td>
                            <td style="width: 200px">${customer.tel}</td>
                            <td style="width: 100px">微信</td>
                            <td style="width: 200px">${customer.weixin}</td>
                            <td style="width: 100px">电子邮件</td>
                            <td>${customer.email}</td>
                        </tr>
                        <tr>
                            <td>等级</td>
                            <td style="color: #ff7400">
                                <c:if test="${customer.level == 1}">
                                    ★
                                </c:if>
                                <c:if test="${customer.level == 2}">
                                    ★★
                                </c:if>
                                <c:if test="${customer.level == 3}">
                                    ★★★
                                </c:if>
                                <c:if test="${customer.level == 4}">
                                    ★★★★
                                </c:if>
                                <c:if test="${customer.level == 5}">
                                    ★★★★★
                                </c:if>
                            </td>
                            <td>地址</td>
                            <td colspan="3">${customer.address}</td>
                        </tr>
                        <c:if test="${not empty customer.companyid}">
                            <tr>
                                <td>所属公司</td>
                                <td colspan="5"><a href="/customerManagement/${customer.companyid}">${customer.companyname}</a></td>
                            </tr>
                        </c:if>
                        <c:if test="${not empty customerList}">
                            <tr>
                                <td>关联客户</td>
                                <td colspan="5">
                                    <c:forEach items="${customerList}" var="cust">
                                        <a href="/customerManagement/${cust.id}"> ${cust.name} </a>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                </div>
            </div>
            <%--customer box end--%>
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title"><i class="fa fa-list"></i> 销售机会</h3>
                        </div>
                        <div class="box-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>机会名称</th>
                                    <th>价值</th>
                                    <th>当前进度</th>
                                    <th>最后跟进时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--<c:forEach items="${salesList}" var="sales">
                                    <tr>
                                        <td><a href="/sales/${sales.id}" target="_blank">${sales.name}</a></td>
                                        <td>￥<fmt:formatNumber value="${sales.price}"/> </td>
                                        <td>${sales.progress}</td>
                                        <td>${sales.lasttime}</td>
                                    </tr>
                                </c:forEach>--%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <%--col-md-8 end--%>
                <div class="col-md-4">
                    <div class="box box-default collapsed-box">
                        <div class="box-header with-border">
                            <h3 class="box-title"><i class="fa fa-qrcode"></i> 电子名片</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"><i class="fa fa-plus"></i></button>
                            </div>
                        </div>
                        <div class="box-body" style="text-align: center">
                            <img src="/customerManagement/qrcode/${customer.id}.png" alt="">
                        </div>
                    </div>

                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title"><i class="fa fa-calendar-check-o"></i> 代办事项</h3>
                            <div class="box-tools">
                                <button class="btn btn-default btn-xs" id="newTask"><i class="fa fa-plus"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <c:choose>
                                <c:when test="${ empty customer.itemsList}">
                                <h5>暂无代办事项</h5>
                                </c:when>
                                <c:otherwise>
                                    <table class="table">
                                        <tbody>
                                        <c:forEach items="${customer.itemsList}" var="items">
                                            <tr>
                                                <td>${items.title}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <%--col-md-4 end--%>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
<div class="modal fade" id="moveModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">转移客户</h4>
            </div>
            <div class="modal-body">
                <form id="moveForm" action="/customer/move" method="post">
                    <input type="hidden" name="id" value="">
                    <div class="form-group" id="editCompanyList">
                        <label>请选择转入员工姓名</label>
                        <select name="userid" class="form-control" id="userid">
                            <option value=""></option>

                            <c:forEach items="${userList}" var="user">
                                <option value="${user.id}"  selected = ${user.id == customer.userid ? 'selected':''}>${user.realname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="moveBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="newTaskModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增待办事项</h4>
            </div>
            <div class="modal-body">
                <form id="newTaskForm" action="/task/new" method="post">
                    <input type="hidden" name="customerid" value="${customer.id}">
                    <div class="form-group">
                        <label>待办内容</label>
                        <input type="text" class="form-control" name="title" id="task_title">
                    </div>
                    <div class="form-group">
                        <label>开始日期</label>
                        <input type="text" class="form-control" name="startTime" id="start_time">
                    </div>
                    <div class="form-group">
                        <label>结束日期</label>
                        <input type="text" class="form-control" name="endTime" id="end_time">
                    </div>
                    <div class="form-group">
                        <label>提醒时间</label>
                        <div>
                            <select name="hour" style="width: 100px">
                                <option value=""></option>
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                            </select>
                            :
                            <select name="min" style="width: 100px">
                                <option value=""></option>
                                <option value="0">0</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                                <option value="25">25</option>
                                <option value="30">30</option>
                                <option value="35">35</option>
                                <option value="40">40</option>
                                <option value="45">45</option>
                                <option value="50">50</option>
                                <option value="55">55</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>显示颜色</label>
                        <input type="text" class="form-control" name="color" id="color" value="#61a5e8">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveTaskBtn">保存</button>
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
<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/moment.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>
<script>

    $(function() {

        //公开客户，userid为null
        $("#openCust").click(function () {
            layer.confirm('如果是公司会自动公开关联客户，您确定要继续吗?', function(index){

                $.post("/customerManagement/" + ${customer.id} + "/openCust").done(function (json) {
                    if(json.status =="success"){
                        layer.msg("客户已经公开");
                        window.location.href = "/customerManagement";
                    } else {
                        layer.msg(json.message);
                    }

                }).error(function () {
                    layer.msg("服务器繁忙，请稍候再试！");
                });

                layer.close(index);
            });
        });

        //添加待办事项表单验证
        $("#newTaskForm").validate({

            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                "title":{
                    required:true
                },
                "startTime":{
                    required:true
                },
                "endTime":{
                    required:true
                },
                "color":{
                    required:true
                }
            },
            messages:{
                "title":{
                    required:"必填字段"
                },
                "startTime":{
                    required:"必填字段"
                },
                "endTime":{
                    required:"必填字段"
                },
                "color":{
                    required:"必填字段"
                }
            },
            submitHandler:function () {

                $.post("/task/new",$("#newTaskForm").serialize()).done(function(result){
                    if(result.status == "success") {


                        window.history.go(0);
                    }
                }).error(function(){
                    layer.msg("服务器异常");
                });

            }


        });

        //转移客户
        $("#moveCust").click(function () {



            $("#moveModal").modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });

        });

        //转移客户
        $("#moveBtn").click(function () {

            var userid=$("#userid").val();
            layer.confirm('如果是公司会自动转移关联客户，您确定要继续吗?', function(index){
                $.get("/customerManagement/moveCust",{"id":${customer.id},"userid":userid}).done(function (json) {

                    if(json.status == "success"){
                        layer.msg("客户转移成功！");
                        window.location.href="/customerManagement";
                    } else {
                        layer.msg(json.message);
                    }
                }).error(function () {
                    layer.msg("服务器繁忙请稍候再试！");
                });

                layer.close(index);
            });
        });


        $('#start_time').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayBtn: 'linked',
            language: 'zh-CN',
            startDate:moment().format()
        }).on('changeDate', function(ev){
            if(ev.date){  //ev.date.valueOf()选择时间的毫秒数，ev.date是完全时间，包含时区
                $(endSelector).datepicker('setStartDate', new Date(ev.date.valueOf()))
            }else{
                $(endSelector).datepicker('setStartDate',null);
            }
        })

        var endSelector = $('#end_time').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayBtn: 'linked',
            language: 'zh-CN',

        });


        $("#newTask").click(function () {


            $("#newTaskModal").modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
        });

        $("#color").colorpicker({
            color:'#61a5e8'
        });

        //添加待办事项
        $("#saveTaskBtn").click(function () {

            if(!$("#task_title").val()) {
                $("#task_title").focus();
                return;
            }
            if(!$("#start_time").val()) {
                $("#start_time").focus();
                return;
            }
            if(!$("#end_time").val()) {
                $("#end_time").focus();
                return;
            }
            /*开始时间在结束时间之后*/
            if(moment($("#start_time").val()).isAfter(moment($("#end_time").val()))) {
                layer.msg("结束时间必须大于开始时间");
                return;
            }

            $("#newTaskForm").submit();
        });
    });
</script>
</body>
</html>
