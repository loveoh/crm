/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-18 09:05:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.setting;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loglist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/setting/../include/mainHeader.jsp", Long.valueOf(1468898576752L));
    _jspx_dependants.put("/WEB-INF/views/setting/../include/leftSide.jsp", Long.valueOf(1468895327326L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname.release();
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("This is a starter template page. Use this page to start your new project from\r\n");
      out.write("scratch. This page gets rid of all links and provides the needed markup only.\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>凯盛CRM-用户登录日志</title>\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/datatables/css/dataTables.bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Theme style -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/AdminLTE.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/skins/skin-blue.min.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Main Header -->\r\n");
      out.write("<header class=\"main-header\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Logo -->\r\n");
      out.write("    <a href=\"index2.html\" class=\"logo\">\r\n");
      out.write("        <!-- mini logo for sidebar mini 50x50 pixels -->\r\n");
      out.write("        <span class=\"logo-mini\">CRM</span>\r\n");
      out.write("        <!-- logo for regular state and mobile devices -->\r\n");
      out.write("        <span class=\"logo-lg\"><b>Kaisheng</b>CRM</span>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Navbar -->\r\n");
      out.write("    <nav class=\"navbar navbar-static-top\" role=\"navigation\">\r\n");
      out.write("        <!-- Sidebar toggle button-->\r\n");
      out.write("        <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <!-- Navbar Right Menu -->\r\n");
      out.write("        <div class=\"navbar-custom-menu\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <!-- User Account Menu -->\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <!-- Menu Toggle Button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <span class=\"hidden-xs\">");
      if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"/user/password\">修改密码</a></li>\r\n");
      out.write("                        <li><a href=\"/user/log\">登录日志</a></li>\r\n");
      out.write("                        <li class=\"divider\"></li>\r\n");
      out.write("                        <li><a href=\"/logout\">安全退出</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Left side column. contains the logo and sidebar -->\r\n");
      out.write("<aside class=\"main-sidebar\">\r\n");
      out.write("\r\n");
      out.write("    <!-- sidebar: style can be found in sidebar.less -->\r\n");
      out.write("    <section class=\"sidebar\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Sidebar Menu -->\r\n");
      out.write("        <ul class=\"sidebar-menu\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <!-- Optionally, you can add icons to the links -->\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_005fhasAnyRoles_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_005fhasRole_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        <!-- /.sidebar-menu -->\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- /.sidebar -->\r\n");
      out.write("</aside>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Main content -->\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-12\">\r\n");
      out.write("                    <div class=\"box box-primary\">\r\n");
      out.write("                        <div class=\"box-header with-border\">\r\n");
      out.write("                            <h3 class=\"box-title\">登录日志列表</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"box-body\">\r\n");
      out.write("                            <table class=\"table table-bordered table-hover\" id=\"logTable\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>登录时间</th>\r\n");
      out.write("                                    <th>登录IP</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody></tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- /.content -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.content-wrapper -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("<!-- REQUIRED JS SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.2.0 -->\r\n");
      out.write("<script src=\"/static/plugins/jQuery/jQuery-2.2.0.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<script src=\"/static/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"/static/dist/js/app.min.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/datatables/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script src=\"/static/plugins/datatables/js/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function () {\r\n");
      out.write("        var dataTable = $(\"#logTable\").DataTable({\r\n");
      out.write("            \"searching\":false,//不使用自带的搜索功能\r\n");
      out.write("            \"serverSide\":true,//表示向服务端发送请求\r\n");
      out.write("\r\n");
      out.write("            \"ajax\":{\r\n");
      out.write("                \"url\":\"/user/ip/list/load\",\r\n");
      out.write("                \"type\": \"get\",\r\n");
      out.write("\r\n");
      out.write("            },\r\n");
      out.write("\r\n");
      out.write("            columns:[\r\n");
      out.write("                {\"data\":\"createTime\"},\r\n");
      out.write("                {\"data\":\"ip\"}\r\n");
      out.write("            ],\r\n");
      out.write("            \"language\":{ //定义中文\r\n");
      out.write("                \"search\": \"搜索:\",\r\n");
      out.write("                \"zeroRecords\":    \"没有匹配的数据\",\r\n");
      out.write("                \"lengthMenu\":     \"显示 _MENU_ 条数据\",\r\n");
      out.write("                \"info\":           \"显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据\",\r\n");
      out.write("                \"infoFiltered\":   \"(从 _MAX_ 条数据中过滤得来)\",\r\n");
      out.write("                \"loadingRecords\": \"加载中...\",\r\n");
      out.write("                \"processing\":     \"处理中...\",\r\n");
      out.write("                \"paginate\": {\r\n");
      out.write("                    \"first\":      \"首页\",\r\n");
      out.write("                    \"last\":       \"末页\",\r\n");
      out.write("                    \"next\":       \"下一页\",\r\n");
      out.write("                    \"previous\":   \"上一页\"\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    })\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shiro_005fprincipal_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent(null);
    // /WEB-INF/views/setting/../include/mainHeader.jsp(27,48) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("realname");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasAnyRoles_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasAnyRoles
    org.apache.shiro.web.tags.HasAnyRolesTag _jspx_th_shiro_005fhasAnyRoles_005f0 = (org.apache.shiro.web.tags.HasAnyRolesTag) _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname.get(org.apache.shiro.web.tags.HasAnyRolesTag.class);
    _jspx_th_shiro_005fhasAnyRoles_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasAnyRoles_005f0.setParent(null);
    // /WEB-INF/views/setting/../include/leftSide.jsp(14,12) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasAnyRoles_005f0.setName("经理,员工");
    int _jspx_eval_shiro_005fhasAnyRoles_005f0 = _jspx_th_shiro_005fhasAnyRoles_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasAnyRoles_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'home' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/home\"><i class=\"fa fa-home\"></i> <span>首页</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'notice' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/notice\"><i class=\"fa fa-bullhorn\"></i> <span>公告</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'sales' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/sales\"><i class=\"fa fa-building-o\"></i> <span>销售机会</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'customer' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/customer\"><i class=\"fa fa-users\"></i> <span>客户管理</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'chart' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/chart\"><i class=\"fa fa-bar-chart\"></i> <span>统计</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'task' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/task\"><i class=\"fa fa-calendar-check-o\"></i> <span>待办事项</span></a></li>\r\n");
        out.write("            <li class=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.menu == 'document' ? 'active' : ''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\"><a href=\"/doc\"><i class=\"fa fa-file-text\"></i> <span>文档管理</span></a></li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_005fhasAnyRoles_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasAnyRoles_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname.reuse(_jspx_th_shiro_005fhasAnyRoles_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasAnyRoles_0026_005fname.reuse(_jspx_th_shiro_005fhasAnyRoles_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f0 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f0.setParent(null);
    // /WEB-INF/views/setting/../include/leftSide.jsp(23,12) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f0.setName("管理员");
    int _jspx_eval_shiro_005fhasRole_005f0 = _jspx_th_shiro_005fhasRole_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"treeview\">\r\n");
        out.write("                <a href=\"javascript:;\"><i class=\"fa fa-cogs\"></i> <span>系统管理</span> <i class=\"fa fa-angle-left pull-right\"></i></a>\r\n");
        out.write("                <ul class=\"treeview-menu\">\r\n");
        out.write("                    <li><a href=\"/admin/users\">员工管理</a></li>\r\n");
        out.write("                    <li><a href=\"#\">系统设置</a></li>\r\n");
        out.write("                </ul>\r\n");
        out.write("            </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
    return false;
  }
}
