/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-06-22 03:49:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.*;

public final class listEmployees_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
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

      out.write("\n");
      out.write("    \n");
      model.EmployeeDTO edto = null;
      edto = (model.EmployeeDTO) _jspx_page_context.getAttribute("edto", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (edto == null){
        edto = new model.EmployeeDTO();
        _jspx_page_context.setAttribute("edto", edto, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>社員一覧</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div align=\"center\">\n");
      out.write("<h1>社員一覧</h1>\n");
      out.write("</div>\n");
      out.write("<table>\n");
      out.write("\n");
      out.write("<div align=\"center\">\n");
      out.write("	<button>追加</button>\n");
      out.write("\n");
      out.write("	<button>更新</button>\n");
      out.write("\n");
      out.write("	<button>削除</button>\n");
      out.write("</div><br>\n");
      out.write("</table>\n");
      out.write("	\n");

    if (edto.size() > 0) {
    
      out.write("\n");
      out.write("<form method=\"get\" action=\"");
      out.print(request.getContextPath());
      out.write("\">\n");
      out.write("<table border=\"1\"align=\"center\">\n");
      out.write("\n");
      out.write("			<tr>\n");
      out.write("				<th></th>\n");
      out.write("				<td width=\"65\" align=\"center\"><b>社員番号</b></td>		\n");
      out.write("				<td width=\"300\" align=\"center\"><b>メールアドレス</b></td>		\n");
      out.write("				<td width=\"100\" align=\"center\"><b>名前</b></td>		\n");
      out.write("				<td width=\"80\" align=\"center\"><b>権限レベル</b></td>\n");
      out.write("			</div>\n");
      out.write("			</tr>\n");
      out.write("\n");
      out.write("			");

			for (int i = 0; i < edto.size(); i++){
				EmployeeBean eb = edto.get(i);
			
      out.write("\n");
      out.write("			<tr>\n");
      out.write("				<td><input type = \"checkbox\"></td>\n");
      out.write("				<td align=\"center\">");
      out.print(eb.getEmployeeID() );
      out.write("</td>\n");
      out.write("				<td align=\"center\">");
      out.print(eb.getMailaddress() );
      out.write("</td>				\n");
      out.write("				<td align=\"center\">");
      out.print(eb.getName() );
      out.write("</td>\n");
      out.write("				<td align=\"center\">");
      out.print(eb.getPermissionLevel() );
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			");

			}
			
      out.write("\n");
      out.write("		</table>\n");
      out.write("	");

	}else{
		
      out.write("\n");
      out.write("		<h3>ありません</h3>\n");
      out.write("	");
 
	}
	
      out.write("\n");
      out.write("</table></form>\n");
      out.write("</body>\n");
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
