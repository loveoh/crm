/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-19 08:09:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/include/mainHeader.jsp", Long.valueOf(1468898576752L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
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
      out.write("    <title>凯盛CRM</title>\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("    <!-- Theme style -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/AdminLTE.min.css\">\r\n");
      out.write("    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter\r\n");
      out.write("          page. However, you can choose any other skin. Make sure you\r\n");
      out.write("          apply the skin class to the body tag so the changes take effect.\r\n");
      out.write("    -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/skins/skin-blue.min.css\">\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/leftSide.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("menu", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("home", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("        <!-- Content Header (Page header) -->\r\n");
      out.write("        <section class=\"content-header\">\r\n");
      out.write("            <h1>\r\n");
      out.write("                首页\r\n");
      out.write("                <small>客户关系管理系统</small>\r\n");
      out.write("            </h1>\r\n");
      out.write("            <ol class=\"breadcrumb\">\r\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Level</a></li>\r\n");
      out.write("                <li class=\"active\">Here</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <!-- Main content -->\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Your Page Content Here -->\r\n");
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
      out.write("\r\n");
      out.write("<!-- Optionally, you can add Slimscroll and FastClick plugins.\r\n");
      out.write("     Both of these plugins are recommended to enhance the\r\n");
      out.write("     user experience. Slimscroll is required when using the\r\n");
      out.write("     fixed layout. -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
    // /WEB-INF/views/include/mainHeader.jsp(27,48) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("realname");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }
}
