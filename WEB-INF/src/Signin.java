/*import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
   public class Signin extends HttpServlet
    {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		String email,password;
        email=req.getParameter("Email");
        password=req.getParameter("password");
        res.setContentType("text/html");
        try{
            MyConnection obb = new MyConnection();
            Connection con = obb.connectme();
            Statement stm= con.createStatement();
			System.out.println("Before if");
           ResultSet rs= stm.executeQuery("select * from sid where EMAIL='"+email+"' and PASSWORD='"+password+"'");
		   
		  // ResultSet rs= stm.executeQuery("select * from login where username='"+email+"' and password='"+password+"'");
            if(rs.next())
            {
				System.out.println("in if");
                res.sendRedirect("project3.html");
            }
            else
            {
				System.out.println("in elsef");
				res.sendRedirect("error.html");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		PrintWriter pw=res.getWriter();
		pw.close();
	}
}*/
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
   public class Signin extends HttpServlet
    {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		String email,password;
        email=req.getParameter("Email");
        password=req.getParameter("password");
        res.setContentType("text/html");
        try{
            MyConnection obb = new MyConnection();
            Connection con = obb.connectme();
            Statement stm= con.createStatement();
            ResultSet rs= stm.executeQuery("select * from sid where email='"+email+"' and password='"+password+"'");
            //ResultSet rs= stm.executeQuery("select * from login where username='"+email+"' and password='"+password+"'");
            if(rs.next())
            {
                res.sendRedirect("project3.html");
            }
            else
            {
                res.sendRedirect("error.html");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		PrintWriter pw=res.getWriter();
		pw.close();
	}
}