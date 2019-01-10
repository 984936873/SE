package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getData {
	
    public static Connection con;

    public static String driver = "com.mysql.jdbc.Driver";

    public static String url = "jdbc:mysql://ofofnts.cn:3306/se";

    public static String user = "root";

    public static String password = "pin314";

public static String canLogin(String userId,String userPw){
	 String rs="false";
	 ResultSet x=null;
    try {

        Class.forName(driver);

        con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())return rs;
        Statement statement = con.createStatement();

        ResultSet res = statement.executeQuery("select password from user where userId='"+userId+"'");
        String pw = null;
        if(res.next()){
            pw = res.getString("password");
        }
        if(pw.equals(userPw))return "true";
        res.close();
        con.close();
    } catch(Exception e) {   
        //数据库驱动类异常处理
    	return rs;
    }
    return rs;
}

public static String getUserInfo(String userId){
	 String rs=null;
   try {

       Class.forName(driver);

       con = DriverManager.getConnection(url,user,password);
       if(con.isClosed())return rs;
       Statement statement = con.createStatement();

       ResultSet res = statement.executeQuery("select name,teleNum,major,money from user_info where userId='"+userId+"'");
       if(res.next()){
           rs=res.getString("name")+"//"+res.getString("teleNum")+"//"+res.getString("major")+"//"+res.getString("money");
       }
       res.close();
       con.close();
       return rs;
   } catch(Exception e) {   
       //数据库驱动类异常处理
   	return "false";
   }
}
public static String getQuestion(String questionId){
	 String rs=null;
  try {

      Class.forName(driver);

      con = DriverManager.getConnection(url,user,password);
      if(con.isClosed())return rs;
      Statement statement = con.createStatement();

      ResultSet res = statement.executeQuery("select title,userId,content,rewardNum,bestAnswer,datetime from question where questionId='"+questionId+"'");
      if(res.next()){
          rs=res.getString("title")+"//"+res.getString("userId")
          +"//"+res.getString("content")+"//"+res.getString("rewardNum")
          +"//"+res.getString("bestAnswer")+"//"+res.getString("datetime");
      }
      res.close();
      con.close();
      return rs;
  } catch(Exception e) {   
      //数据库驱动类异常处理
  	return "false";
  }
}

public static String getAnswer(String answerId){
	 String rs=null;
 try {

     Class.forName(driver);

     con = DriverManager.getConnection(url,user,password);
     if(con.isClosed())return rs;
     Statement statement = con.createStatement();

     ResultSet res = statement.executeQuery("select userId,likesTimes,datetime,content from answer where answerId='"+answerId+"'");
     if(res.next()){
         rs=res.getString("userId")+"//"+res.getString("likesTimes")
         +"//"+res.getString("datetime")+"//"+res.getString("content");
     }
     res.close();
     con.close();
     return rs;
 } catch(Exception e) {   
     //数据库驱动类异常处理
 	return "false";
 }
}

public static String getComment(String commentId){
	 String rs=null;
try {

    Class.forName(driver);

    con = DriverManager.getConnection(url,user,password);
    if(con.isClosed())return rs;
    Statement statement = con.createStatement();

    ResultSet res = statement.executeQuery("select userId,datetime,commentContent from comment where commentId='"+commentId+"'");
    if(res.next()){
        rs=res.getString("userId")+"//"+res.getString("commentContent")
        +"//"+res.getString("datetime");
    }
    res.close();
    con.close();
    return rs;
} catch(Exception e) {   
    //数据库驱动类异常处理
	return "false";
}
}

public static String isLikesAnswer(String userId,String answerId){
	 String rs=null;
try {

   Class.forName(driver);

   con = DriverManager.getConnection(url,user,password);
   if(con.isClosed())return "false";
   Statement statement = con.createStatement();

   ResultSet res = statement.executeQuery("select answerId from likesAnswer where userId='"+userId+"'");
   while(res.next()){
       rs=res.getString("answerId");
       if(rs.equals(answerId)) {return "true";}
   }
   res.close();
   con.close();
   return "false";
} catch(Exception e) {   
   //数据库驱动类异常处理
	return "false";
}
}

public static String getLikesUserId(String userId){
	 String rs="";
try {

  Class.forName(driver);

  con = DriverManager.getConnection(url,user,password);
  if(con.isClosed())return "false";
  Statement statement = con.createStatement();

  ResultSet res = statement.executeQuery("select likesId from likesUserId where userId='"+userId+"'");
  while(res.next()){
      rs=rs+res.getString("likesId")+"//";
  }
  res.close();
  con.close();
  return rs;
} catch(Exception e) {   
  //数据库驱动类异常处理
	return "false";
}
}

public static String getQuestionByData(String page){
	 String rs="";
try {

 Class.forName(driver);
 con = DriverManager.getConnection(url,user,password);
 if(con.isClosed())return "false";
 Statement statement = con.createStatement();
 int i=0;int pg=Integer.valueOf(page);
 ResultSet res = statement.executeQuery("select title,questionId from question order by questionId DESC");
 while(res.next()){
	 i++;
	 if(i/10<=pg&&i/10>=(pg-1)) {
     rs=rs+res.getString("title")+"//"+res.getString("questionId")+"//";
     i++;
	 }else if(i/10>=pg)break;
	 
 }
 res.close();
 con.close();
 return rs;
} catch(Exception e) {   
 //数据库驱动类异常处理
	return "false";
}
}

public static String getQuestionByMoney(String page){
	 String rs="";
try {

Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
if(con.isClosed())return "false";
Statement statement = con.createStatement();
int i=0;int pg=Integer.valueOf(page);
ResultSet res = statement.executeQuery("select title,questionId from question order by rewardNum DESC");
while(res.next()){
	 i++;
	 if(i/10<=pg&&i/10>=(pg-1)) {
    rs=rs+res.getString("title")+"//"+res.getString("questionId")+"//";
    i++;
	 }else if(i/10>=pg)break;
	 
}
res.close();
con.close();
return rs;
} catch(Exception e) {   
//数据库驱动类异常处理
	return "false";
}
}

public static String getQuestionByLikes(String page,String userId){
	 String rs="";
try {

Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
if(con.isClosed())return "false";
Statement statement = con.createStatement();
int i=0;int pg=Integer.valueOf(page);
ResultSet res = statement.executeQuery("select title,questionId from question,likesUserId "
		+ "where likesUserId.userId="+userId+" and likesUserId.likesId=question.userId "
				+ "order by rewardNum DESC");
while(res.next()){
	 i++;
	 if(i/10<=pg&&i/10>=(pg-1)) {
   rs=rs+res.getString("title")+"//"+res.getString("questionId")+"//";
   i++;
	 }else if(i/10>=pg)break;
	 
}
res.close();
con.close();
return rs;
} catch(Exception e) {   
//数据库驱动类异常处理
	return "false";
}
}
public static String getBestAnswerId(String questionId){
	 String rs="";
try {

Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
if(con.isClosed())return "false";
Statement statement = con.createStatement();
ResultSet res = statement.executeQuery("select bestAnswer from question where questionId="+questionId);
if(res.next()){
    rs=res.getString("bestAnswer"); 
    if(rs==null)return "false";
}else return "false";
res.close();
con.close();
return rs;
} catch(Exception e) {   
//数据库驱动类异常处理
	return "false";
}
}
public static String getAnswerByData(String page,String questionId){
	 String rs="";
try {

Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
if(con.isClosed())return "false";
Statement statement = con.createStatement();
int i=0;int pg=Integer.valueOf(page);
ResultSet res = statement.executeQuery("select content,answerId from answer where questionId="
+questionId+" order by answerId DESC");
while(res.next()){
	 i++;
	 if(i/10<=pg&&i/10>=(pg-1)) {
    rs=rs+res.getString("content")+"//"+res.getString("answerId")+"//";
    i++;
	 }else if(i/10>=pg)break;
	 
}
res.close();
con.close();
return rs;
} catch(Exception e) {   
//数据库驱动类异常处理
	return "false";
}
}

public static String getCommentByData(String page,String answerId){
	 String rs="";
try {

Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
if(con.isClosed())return "false";
Statement statement = con.createStatement();
int i=0;int pg=Integer.valueOf(page);
ResultSet res = statement.executeQuery("select commentContent,userId from comment"
		+ "  where answerId="+answerId);
while(res.next()){
	 i++;
	 if(i/10<=pg&&i/10>=(pg-1)) {
   rs=rs+res.getString("commentContent")+"//"+res.getString("userId")+"//";
   i++;
	 }else if(i/10>=pg)break;
	 
}
res.close();
con.close();
return rs;
} catch(Exception e) {   
//数据库驱动类异常处理
	return "false";
}
}
}
