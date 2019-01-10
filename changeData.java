package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class changeData {
    public static Connection con;

    public static String driver = "com.mysql.jdbc.Driver";

    public static String url = "jdbc:mysql://ofofnts.cn:3306/se";

    public static String user = "root";

    public static String password = "pin314";
    public static String changePw(String userId,String userPw,String newPw){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int res = statement.executeUpdate("update user  set password="+newPw+" where userId='"+userId+"'");
           if(res!=0){
           
               con.close();
               return "true";
           }
         
           con.close();
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }

    public static String changeUserInfo(String userId,String userPw,String name,String teleNum,String major,String money){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int res = statement.executeUpdate("update user_info  set name='"+name+"'"
           		+ ",teleNum="+teleNum+",major='" +major+"',money="+money+" where userId='"+userId+"'");
           if(res!=0){
           
               con.close();
               return "true";
           }
         
           con.close();
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }
    
    public static String addQuestion(String userId,String userPw,String title,String content,String rewardNum){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int flag=statement.executeUpdate("insert into question"
           		+ "  (title,userId,content,rewardNum)value(+'"+title+"',"+userId+",'"+content+"',"+rewardNum+")"
           		);
         
           con.close();
           if(flag!=0)return "true";
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }

    public static String addAnswer(String userId,String userPw,String content,String questionId){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int flag=statement.executeUpdate("insert into answer"
           		+ "  (userId,content,questionId)value("+userId+",'"+content+"',"+questionId+")"
           		);
         
           con.close();
           if(flag!=0)return "true";
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }

    public static String addComment(String userId,String userPw,String content,String answerId){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int flag=statement.executeUpdate("insert into comment"
           		+ "  (userId,commentContent,answerId)value("+userId+",'"+content+"',"+answerId+")"
           		);
         
           con.close();
           if(flag!=0)return "true";
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }
    
    public static String addLikesUserId(String userId,String userPw,String likesId){
    	if(!getData.canLogin(userId,userPw).equals("true")) {return "false?";}
   	 String rs="false";
   	 ResultSet x=null;
       try {

           Class.forName(driver);

           con = DriverManager.getConnection(url,user,password);
           if(con.isClosed())return rs;
           Statement statement = con.createStatement();

           int flag=statement.executeUpdate("insert into likesUserId"
           		+ "  (userId,likesId)value("+userId+","+likesId+")"
           		);
         
           con.close();
           if(flag!=0)return "true";
           return "false";
       } catch(Exception e) {   
           //数据库驱动类异常处理
       	return rs;
       }
   }
}
