import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class formservlet extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
try
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cbit?useTimezone=true&serverTimezone=UTC";
	String username = "root";
	String password = "";
Connection con = DriverManager.getConnection(url, username, password);
Statement st=con.createStatement();
String x=req.getParameter("ename");
String y=req.getParameter("dept");
String sql="insert into emp1 values('"+x+"','"+y+"')";
st.executeUpdate(sql);
out.print("<a href='../jdbcDemo1/form.html'>Regitration</a>");
out.print("</br>");
out.print("<a href='../jdbcDemo1/report.html'>Report</a>");
out.println("<h1> Record inserted successfully</h1>");
RequestDispatcher rd=req.getRequestDispatcher("/form.html");
rd.include(req,res);
}//try
catch(ClassNotFoundException cnfe)
{
 out.println("class not found");
}
}//try
catch(SQLException se)
{
throw new RuntimeException("not connected",se);
}//catch
}//doPost
}//main class
