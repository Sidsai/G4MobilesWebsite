import java.sql.*;
import java.io.*;
public class SidConn2 
{
    public static void main(String[] args) throws IOException
    {
        Connection conn =null;
        PreparedStatement pstmt =null,pstmt1=null,pstmt2=null;
        BufferedReader br = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            
        }
        try {
            br= new BufferedReader(new InputStreamReader(System.in));
            conn=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-E01S90C:1521:XE","siddharth","siddharth");
            pstmt = conn.prepareStatement("insert into sid(SNO,EMAIL,PASSWORD) values(?,?,?)");
            pstmt1= null;
            pstmt2= conn.prepareStatement("delete from sid where SNO=?");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        while (true) {
            try {
            System.out.println("You have a Following :-\n1.)Insert amount.\n2.)delete.\n3.)Update\n4.)EXIT.....");
             int sno=Integer.parseInt(br.readLine().trim());
             if (sno==4) {
                 break;
             }
            if (sno==1) {
                System.out.println("Enter The Email:== ");
                String email= br.readLine();
                System.out.println("Enter the Password == ");
                String pass=br.readLine();
                System.out.println("Enter the SNO :--");
                int sno1=Integer.parseInt(br.readLine());
                pstmt.setInt(1,sno1);
                pstmt.setString(2, email);
                pstmt.setString(3, pass);
                int count= pstmt.executeUpdate();
                if(count==1)
                System.out.println("RECORD INSERTED ");
                else 
                System.out.println("UNABLE TO INSERT");
           }
            else if (sno==2) {
                System.out.println("Enter the SNO :--");
                int sno1=Integer.parseInt(br.readLine());
                pstmt2.setInt(1,sno1);
                int count =pstmt2.executeUpdate();
                if(count==1)
                System.out.println("RECORD DELETED ");
                else 
                System.out.println("UNABLE TO DELETE");
            }
            else
            {
                int count=0;
                System.out.println("Enter the what you want to update:-\n1.)Update Email\n2.)Update Password\n3.)Exit....\n");
                int s=Integer.parseInt(br.readLine());
                if(s==0)
                break;
                System.out.println("Enter the SNO :--");
                int sno1=Integer.parseInt(br.readLine());
                switch (s) {
                    case 1:
                    pstmt1= conn.prepareStatement("update sid set EMAIL=? where SNO=?");
                    System.out.println("Enter The Email:== ");
                    String email= br.readLine();
                    pstmt1.setString(1,email);
                    pstmt1.setInt(2,sno1);
                    count =pstmt1.executeUpdate();
                    if(count==1)
                    System.out.println("RECORD UPDATED ");
                    else 
                    System.out.println("UNABLE TO UPDATE");
                    break;
                    case 2:
                    pstmt1= conn.prepareStatement("update sid set EMAIL=? where SNO=?");
                    System.out.println("Enter The Email:== ");
                    String pass= br.readLine();
                    pstmt1.setString(1,pass);
                    pstmt1.setInt(2,sno1);
                    count =pstmt1.executeUpdate();
                    if(count==1)
                    System.out.println("RECORD UPDATED ");
                    else 
                    System.out.println("UNABLE TO UPDATE");
                    break;
                    

                }
            }
            }
            catch (Exception e) {
             System.out.println(e.toString());
            }
        }
        
         try {
             conn.close();
             br.close();
         } catch (SQLException e)
         {
             System.out.println(e.toString());
         }
    
}
}
