package serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changeInfo
 */
@WebServlet("/changeInfo")
public class changeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeInfo() {
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
        if(sourceStrArray[0].equals("changePw")) {
        	res=data.changeData.changePw(sourceStrArray[1], sourceStrArray[2],sourceStrArray[3]);
        	if(res.equals("true"))response.getWriter().append("Ok");}
        else if(sourceStrArray[0].equals("changeUserInfo")) {
        	res=data.changeData.changeUserInfo(sourceStrArray[1], sourceStrArray[2]
        			,sourceStrArray[3], sourceStrArray[4], sourceStrArray[5], sourceStrArray[6]);
        }       
        else if(sourceStrArray[0].equals("addQuestion")) {
        	res=data.changeData.addQuestion(sourceStrArray[1], sourceStrArray[2]
        			,sourceStrArray[3], sourceStrArray[4], sourceStrArray[5]);
        }
        else if(sourceStrArray[0].equals("addAnswer")) {
        	res=data.changeData.addAnswer(sourceStrArray[1], sourceStrArray[2]
        			,sourceStrArray[3], sourceStrArray[4]);
        }
        else if(sourceStrArray[0].equals("addComment")) {
        	res=data.changeData.addComment(sourceStrArray[1], sourceStrArray[2]
        			,sourceStrArray[3], sourceStrArray[4]);
        }
        else if(sourceStrArray[0].equals("addLikesUserId")) {
        	res=data.changeData.addLikesUserId(sourceStrArray[1], sourceStrArray[2]
        			,sourceStrArray[3]);
        }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
