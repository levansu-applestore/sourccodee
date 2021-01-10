package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonalDAO;
import model.Day_off;

@WebServlet(name = "XuLyTaoNVNghiPhep", urlPatterns = { "/XuLyTaoNVNghiPhep" })
public class XuLyTaoNVNghiPhep extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XuLyTaoNVNghiPhep() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String Last_Name = request.getParameter("Last_Name");
			String First_Name = request.getParameter("First_Name");
			String SSN = request.getParameter("SSN");
			String Birthday = request.getParameter("birthday");
			String Address = request.getParameter("Address");
			String Phone_Number = request.getParameter("Phone_number");
			String Date_Back = request.getParameter("date_back");
			String Reason = request.getParameter("Reason");
			String Vacation_Days = request.getParameter("Vacation_Days");
			String Gender = request.getParameter("Gender");
			int g = 0;
			if (Gender.equals("1")) {
				g = 1;
			} else {
				g = 0;
			}
			Day_off d=new Day_off(Last_Name, First_Name, Integer.parseInt(SSN), Birthday,g, Address, Phone_Number, Date_Back,Reason,Integer.parseInt(Vacation_Days) );
			if (PersonalDAO.ThemNgayNghi(d)) {
				request.setAttribute("add", "Đã Thêm Nhân Viên Nghỉ Phép");
				RequestDispatcher rd = request.getRequestDispatcher("indexAdmin.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("them-nhan-vien-nghi-phep.jsp");
			}

		} catch (Exception ex) {
			System.out.println("Loi " + ex.getMessage());
		}

	}

}
