package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet(name = "XuLyDangXuat", urlPatterns = {"/XuLyDangXuat"})
public class XuLyDangXuat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession session = request.getSession();
    	String username=request.getParameter("username");
    	String password=request.getParameter("userP");
    	String retype = request.getParameter("retype");
    	try {
    		if(UserDAO.getUserName(username)) {
    			if(password.equals(retype) && UserDAO.ResetPassword(username,password)) {
    				request.setAttribute("reset", "Đã Reset Password Thành Công!");
	                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	                rd.forward(request, response);
    				
    			}
    			
    		}else {
                request.setAttribute("error", "Tài Khoản Không Tồn Tại!");
                RequestDispatcher rd = request.getRequestDispatcher("fogot-password.jsp");
                rd.forward(request, response);
            }
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
    }

}
