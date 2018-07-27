package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.AnswerUser;
import BEAN.Incomplete;
import DAO.QuizDAO;
import DB.DBConnection;


@WebServlet("/QuizController")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuizController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		Connection conn = DBConnection.createConnection();
		int countrow = QuizDAO.getCountBrow(conn);
		
		List<Incomplete> listincomplate = QuizDAO.getCorrectAnswe(conn);
		
		List<AnswerUser> listansweruser = new ArrayList<AnswerUser>();
		for (int i = 1; i <= countrow; i++) {
			String answer = request.getParameter("ans["+i+"]");
			
			if(answer!=null) {
				AnswerUser au = new AnswerUser();
				au.setNumber(i);
				au.setAnswer(answer);
				
				listansweruser.add(au);
			}else {
				request.setAttribute("msg", "Yêu cầu làm hết các câu hỏi!");
				List<Incomplete> list = QuizDAO.DisplayQuestion(conn);
				
				request.setAttribute("list_incomplate", list);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/quiz.jsp");
				rd.forward(request, response);
			}
			
			
		}
		
		request.setAttribute("listincomplate", listincomplate);
		request.setAttribute("listansweruser", listansweruser);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Result.jsp");
		rd.forward(request, response);
		
		
	}

}
