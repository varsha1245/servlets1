import java.sql.*;
import javax.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class reportservlet extends HttpServlet
{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
try
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/cbit?useTimezone=true&serverTimezone=UTC";
	String username = "root";
	String password = "";
Connection con = DriverManager.getConnection(url, username, password);
Statement st=con.createStatement();
String z=req.getParameter("dept");
String sql="select * from emp1 where dept='"+z+"'";
out.print("<a href='../jdbcDemo1/form.html'>Regitration</a>");
out.print("</br>");
out.print("<a href='../jdbcDemo1/report.html'>Report</a>");
out.println("<h1>Employee details</h1>");
ResultSet rs=st.executeQuery(sql);
out.println("<table border='2'>");
out.println("<tr>");
out.println("<th>NAME</th>");
out.println("<th>DEPT</th>");
out.println("</tr>");
while(rs.next())
{
String ename=rs.getString("ename");
String dept=rs.getString("dept");
out.println("<tr>");
out.println("<td>"+ename+"</td>");
out.println("<td>"+dept+"</td>");
out.println("</tr>");
}
out.println("</table>");
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
