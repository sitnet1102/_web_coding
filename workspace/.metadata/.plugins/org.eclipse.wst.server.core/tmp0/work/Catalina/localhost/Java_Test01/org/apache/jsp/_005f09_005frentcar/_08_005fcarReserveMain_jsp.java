/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2020-01-21 04:37:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp._005f09_005frentcar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import _09_rentcar.Rentcar;
import java.util.ArrayList;
import _09_rentcar.RentcarDao;
import java.util.Vector;

public final class _08_005fcarReserveMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("_09_rentcar.RentcarDao");
    _jspx_imports_classes.add("_09_rentcar.Rentcar");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	
	// 데이터베이스에 연결하여, 최신순 자동차 3대만뿌려주는 데이터를 가져옴
	
	// ArrayList를 이용하여 데이터(자동차)를 저장
	ArrayList<Rentcar> list = RentcarDao.instance.getSelectCar3();
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr height=\"60\">\r\n");
      out.write("\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t<font size=\"6\" color=\"gray\">최신형 자동차</font>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"240\">\r\n");
      out.write("\t\t");
 for(int i=0; i<list.size(); i++){ 
			Rentcar bean = list.get(i);
		
      out.write("\r\n");
      out.write("\t\t\t<td width=\"333\" align=\"center\">\r\n");
      out.write("\t\t\t<a href=\"01_main.jsp?center=10_carReserveInfo.jsp?no=");
      out.print( bean.getNo() );
      out.write("\">\r\n");
      out.write("\t\t\t\t<img alt=\"\" src=\"_09_imgCar/");
      out.print(bean.getImg() );
      out.write("\" width=\"300\" height=\"220\">\r\n");
      out.write("\t\t\t</a><p>\r\n");
      out.write("\t\t\t차량명 : ");
      out.print( bean.getName() );
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t");
} 
      out.write("\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- ================================================== -->\r\n");
      out.write("\t\r\n");
      out.write("\t<hr size=\"3\" color=\"red\">\r\n");
      out.write("\t<p>\r\n");
      out.write("\t<font size=\"4\" color=\"gray\"><b>차량 검색 하기</b></font>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"01_main.jsp?center=13_carCategoryList.jsp\" method=\"post\">\r\n");
      out.write("\t\t<font size=\"3\" color=\"gray\"><b>차량 검색 하기</b></font>&nbsp;&nbsp;\r\n");
      out.write("\t\t<select name=\"category\">\r\n");
      out.write("\t\t\t<option value=\"1\">소형</option>\r\n");
      out.write("\t\t\t<option value=\"2\">중형</option>\r\n");
      out.write("\t\t\t<option value=\"3\">대형</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"검색\" />&nbsp;&nbsp;\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<button onclick=\"location.href='01_main.jsp?center=09_carAllList.jsp'\">전체 검색</button>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
