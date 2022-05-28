import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
   public class Signup extends HttpServlet
    {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		String email,password,name,rpassword,num;
        email=req.getParameter("Email");
        password=req.getParameter("password");
        rpassword=req.getParameter("rpassword");
        name=req.getParameter("name");
        num=req.getParameter("Phonenumber");
        res.setContentType("text/html");
        System.out.println(email+" "+password+" "+rpassword+" "+name+" "+num+" ");

        StringBuffer sb=new StringBuffer();
        sb.append("('"+email+"','"+password+"','"+name+"','"+num+"')");
        String condition=sb.toString();
        
        System.out.println(condition);

        try{
            MyConnection obb = new MyConnection();
            Connection con = obb.connectme();
            Statement stm= con.createStatement();
            if(password.equals(rpassword))
            {
            ResultSet rs= stm.executeQuery("INSERT INTO sid (EMAIL,PASSWORD,NAME,NO) VALUES"+condition);
            if(rs.next())
            {
                res.sendRedirect("project3.html");
            }
            else
            {
                res.sendRedirect("error.html");
            }
        }
        else
        {
            res.sendRedirect("error.html");
        }
              //ResultSet rs= stm.executeQuery("select * from login where username='"+email+"' and password='"+password+"'");
         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		PrintWriter pw=res.getWriter();
		pw.close();
	}
}