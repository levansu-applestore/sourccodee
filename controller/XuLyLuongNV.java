package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonalDAO;
import model.Salary_Employee;

@WebServlet(name = "XuLyLuongNV", urlPatterns = { "/XuLyLuongNV" })
public class XuLyLuongNV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XuLyLuongNV() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String Working_days = request.getParameter("Working_days");

			if (PersonalDAO.ngaylamNV(Integer.parseInt(Working_days))) {
				request.setAttribute("them", "Đã Cập Nhật");
				RequestDispatcher rd = request.getRequestDispatcher("thanh-toan-luong.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("thanh-toan-luong.jsp");
			}

		} catch (Exception e) {
			System.out.println("Loi " + e.getMessage());
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String Employee_ID = request.getParameter("Employee_ID");
			String Salary_Basic = request.getParameter("Salary_Basic");
			String Overtime = request.getParameter("Overtime");
			String Subsidize = request.getParameter("Subsidize");

			if (PersonalDAO.Add_Salary(Integer.parseInt(Salary_Basic), Integer.parseInt(Employee_ID),
					Integer.parseInt(Overtime), Integer.parseInt(Subsidize))) {
				request.setAttribute("add", "Đã Thanh Toán Lương Tháng");
				RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("thanh-toan-luong.jsp");
			}

		} catch (Exception e) {
			System.out.println("Loi " + e.getMessage());
		}
	}

}
