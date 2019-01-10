package serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getData
 */
@WebServlet("/getInfo")
public class getInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String res=null;
		if(request.getQueryString()==null)response.getWriter().append("wtf");
		else {
        String[] sourceStrArray = request.getQueryString().split("//");
        if(sourceStrArray[0].equals("login")) {
        	res=data.getData.canLogin(sourceStrArray[1], sourceStrArray[2]);
        	if(res.equals("true"))response.getWriter().append("Ok");
        	}
        else if(sourceStrArray[0].equals("getUserInfo")) {
        	res=data.getData.getUserInfo(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getQuestion")) {
        	res=data.getData.getQuestion(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getAnswer")) {
        	res=data.getData.getAnswer(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getComment")) {
        	res=data.getData.getComment(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("isLikesAnswer")) {
        	res=data.getData.isLikesAnswer(sourceStrArray[1],sourceStrArray[2]);
        }
        else if(sourceStrArray[0].equals("getLikesUserId")) {
        	res=data.getData.getLikesUserId(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getQuestionByData")) {
        	res=data.getData.getQuestionByData(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getQuestionByMoney")) {
        	res=data.getData.getQuestionByMoney(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getQuestionByLikes")) {
        	res=data.getData.getQuestionByLikes(sourceStrArray[1],sourceStrArray[2]);
        }
        else if(sourceStrArray[0].equals("getBestAnswerId")) {
        	res=data.getData.getBestAnswerId(sourceStrArray[1]);
        }
        else if(sourceStrArray[0].equals("getAnswerByData")) {
        	res=data.getData.getAnswerByData(sourceStrArray[1],sourceStrArray[2]);
        }
        else if(sourceStrArray[0].equals("getCommentByData")) {
        	res=data.getData.getCommentByData(sourceStrArray[1],sourceStrArray[2]);
        }
		
		
		}
		response.getWriter().append(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
