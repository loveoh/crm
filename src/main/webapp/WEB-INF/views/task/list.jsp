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
    <title>凯盛CRM | 待办事项</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/static/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.css">
    <style>
        .todo-list>li .text {
            font-weight: normal;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@include file="../include/mainHeader.jsp"%>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="task"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-solid">
                        <div class="box-body">
                            <div id="calendar"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box box-danger">
                        <div class="box-header with-border">
                            <h3 class="box-title">已经延期的事项  <a href="javascript:;" id="delete" class="btn btn-default" style="margin-left: 100px">批量删除</a> </h3>
                        </div>

                        <div class="box-body">
                            <ul class="todo-list">
                                <c:forEach items="${putOffList}" var="task">
                                    <li>
                                        <input type="checkbox" value="${task.id}" name="putOffId" class="putOffId">
                                        <span class="text">${task.title}</span>
                                        <div class="tools" >
                                            <i class="fa fa-trash-o" rel="${task.id}"></i>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
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
                <h4 class="modal-title">新增待办事项</h4>
            </div>
            <div class="modal-body">
                <form id="newForm" action="/task/new" method="post">
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
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" id="eventModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">查看待办事项</h4>
            </div>
            <div class="modal-body">
                <form id="eventForm">
                    <input type="hidden" id="event_id">
                    <div class="form-group">
                        <label>待办内容</label>
                        <div id="event_title"></div>
                    </div>
                    <div class="form-group">
                        <label>开始日期 ~ 结束时间</label>
                        <div><span id="event_start"></span>  ~  <span id="event_end"></span></div>
                    </div>
                    <div class="form-group">
                        <label>提醒时间</label>
                        <div id="event_remindtime"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" id="delBtn"><i class="fa fa-trash"></i> 删除</button>
                <button type="button" class="btn btn-primary" id="doneBtn"><i class="fa fa-check"></i> 标记为已完成</button>
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
<%--js时间，moment().format()--%>
<script src="/static/plugins/moment/moment.min.js"></script>
<%--javascript事件日历插件--%>
<script src="/static/plugins/fullcalendar/fullcalendar.min.js"></script>

<%--颜色--%>
<script src="/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>

<script>
    $(function () {

        var _event = null;
        var $calendar = $("#calendar");

        $('#calendar').fullCalendar({

            // put your options and callbacks here
            lang:"zh-cn",

            buttonText:{
                    today:    '今天'
            },
            events:"/task/load",/*自动发送ajax请求，每一页的日期，必须返回的数据json，是按照id，titel等 日期规定的几个字段*/
            /*回调，点击某一天，然后出现操作*/
            dayClick: function(date) {

                $("#newForm")[0].reset();/*清空表单*/
                var times = moment(date).format("YYYY-MM-DD");

                $("#start_time").val(times);
                $("#end_time").val(times);


                $("#start_time").datepicker( {
                    language: "zh-CN",  //选择语言，需要导入对应的语言包js
                    autoclose: true,//选中之后自动隐藏日期选择框
                    format: "yyyy-mm-dd",
                    startDate:moment().format()
                }).on('changeDate', function(ev){
                    if(ev.date){  //ev.date.valueOf()选择时间的毫秒数，ev.date是完全时间，包含时区
                        $(endSelector).datepicker('setStartDate', new Date(ev.date.valueOf()))
                    }else {
                        $(endSelector).datepicker('setStartDate', null);
                    }

                });


                var endSelector = $("#end_time").datepicker( {
                    language: "zh-CN",  //选择语言，需要导入对应的语言包js
                    autoclose: true,//选中之后自动隐藏日期选择框
                    format: "yyyy-mm-dd",
                });

                $("#newModal").modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
            },

            eventClick:function(calEvent, jsEvent, view){
                //alert(calEvent.id + " : " + calEvent.title);
                _event = calEvent;
                $("#event_id").val(calEvent.id);
                $("#event_title").text(calEvent.title);
                $("#event_start").text(moment(calEvent.start).format("YYYY-MM-DD"));
                $("#event_end").text(moment(calEvent.end).format("YYYY-MM-DD"));
                if(calEvent.remindertime) {
                    $("#event_remindtime").text(calEvent.remindertime);
                } else {
                    $("#event_remindtime").text('无');
                }

                $("#eventModal").modal({
                    show:true,
                    backdrop:'static'
                });
            }

        });


        /*新增待办*/
        $("#saveBtn").click(function(){
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
            $.post("/task/new",$("#newForm").serialize()).done(function(result){
                if(result.status == "success") {
                    $calendar.fullCalendar( 'renderEvent', result.data );

                    $("#newModal").modal('hide');
                    window.history.go(0);
                }
            }).error(function(){
                layer.msg("服务器异常");
            });
        });


        $("#color").colorpicker({
            color:'#61a5e8'
        });


        /*删除日期中的*/
        $("#delBtn").click(function () {

            var id = $("#event_id").val();
            layer.confirm('您确定要删除吗?', function(index){
                //do something
                $.get("/task/"+id+"/del").done(function (result) {

                    if(result.status == "success"){
                        layer.msg("删除成功！");
                        window.history.go(0);
                    } else {
                        layer.msg(message);
                    }

                }).error(function () {

                    layer.msg("服务器繁忙，请稍候再试!");

                });

                layer.close(index);

            });


        });



        /*删除单个延期事项*/
        $(document).delegate(".fa-trash-o","click",function () {

            var id = $(this).attr("rel");
            layer.confirm('您确定要删除吗?', function(index){
                //do something
                $.get("/task/"+id+"/del").done(function (result) {

                    if(result.status == "success"){
                        layer.msg("删除成功！");
                        window.history.go(0);
                    } else {
                        layer.msg(message);
                    }

                }).error(function () {

                    layer.msg("服务器繁忙，请稍候再试!");

                });

                layer.close(index);

            });


        });


        /*批量删除*/
        $("#delete").click(function () {

            layer.confirm('您确定要删除吗?', function(index){

                var id = "";
                $('input:checkbox[name=putOffId]:checked').each(function(i){
                    id = id + $(this).val() + ",";
                });
                if(id == ""){
                    layer.msg("请选择要删除的事项");
                } else {
                    //do something

                    $.get("/task/delBatch", {"ids": id}).done(function (result) {

                        if (result.status == "success") {
                            layer.msg("删除成功！");
                            window.history.go(0);
                        } else {
                            layer.msg(result.message);
                        }

                    }).error(function () {

                        layer.msg("服务器繁忙，请稍候再试!");

                    });

                    layer.close(index);
                }
            });



        });


        /*标记为已完成*/
        $("#doneBtn").click(function () {
            var id = $("#event_id").val();
            $.post("/task/"+id+"/done").done(function(result){
                if(result.status == "success") {
                    _event.color = "#cccccc";
                    $calendar.fullCalendar('updateEvent',_event);
                    $("#eventModal").modal('hide');
                }
            }).error(function(){
                layer.msg("服务器异常");
            });
        });



    });


</script>
</body>
</html>

