package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import connection.DBConnect;
import model.Day_off;
import model.Employement;
import model.Job_History;
import model.NhanVienChinhThuc;
import model.Personal2;
import model.Personal_Employment;
import model.Salary_Employee;
import model.User;
import model.employee;

public class PersonalDAO {

	public static ArrayList<Personal_Employment> getAllPersonal() throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Personal inner join Employment on Personal.Employee_ID=Employment.Employee_ID");
		ResultSet rs = ps.executeQuery();
		ArrayList<Personal_Employment> list = new ArrayList<Personal_Employment>();
		while (rs.next()) {
			Personal_Employment p = new Personal_Employment();
			p.setEmployee_ID(rs.getInt("Employee_ID"));
			p.setFirst_Name(rs.getString("First_Name"));
			p.setLast_Name(rs.getString("Last_Name"));
			p.setEmployment_Status(rs.getString("Employment_Status"));
			p.setAddress1(rs.getString("Address1"));
			p.setCity(rs.getString("City"));
			p.setState(rs.getString("State"));
			p.setZip(rs.getInt("Zip"));
			p.setEmail(rs.getString("Email"));
			p.setPhone(rs.getString("Phone_Number"));
			p.setSsn(rs.getString("ssn"));
			p.setDrivers_license(rs.getString("Drivers_License"));
			p.setMarital_Status(rs.getString("Marital_Status"));
			p.setGender(rs.getInt("Gender"));
			p.setShareholderStatus(rs.getInt("Shareholder_Status"));
			p.setEthnicity(rs.getString("Ethnicity"));
			p.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("birthday")));

			list.add(p);
		}
		return list;
	}

	public static ArrayList<NhanVienChinhThuc> getNhanVienChinhThuc() throws SQLException {
		Connection con = DBConnect.getConnection();

		PreparedStatement ps;

//		String sql="select * from employee,Pay_Rates where Pay_Rates_idPay_Rates=idPay_Rates";
//		String sql1="select * from employee inner join Job_History on Job_History.Employee_ID = employee.idEmployee";
//		String sql2="select * from employee inner join Personal on Personal.Employee_ID = employee.idEmployee";
//		String sql3="select * from employee inner join Employment on Employment.Employee_ID = employee.idEmployee";
//		String sql4="select * from employee inner join NhanVienChinhThuc on NhanVienChinhThuc.Employee_ID = employee.idEmployee";
//		String sql5="select * from employee inner join Personal_Employment on Personal_Employment.Employee_ID = employee.idEmployee";
		String sql6 = "select * from NhanVienChinhThuc inner join Pay_Rates on NhanVienChinhThuc.Employee_ID= Pay_Rates.idPay_Rates";
//		String sql7="select * from Personal";
//		String sql8="select Pay_Rate_Name from Pay_Rates";
//		String sql9="select * from Personal_Employment";
//		ps=con.prepareStatement(sql);
//		ps=con.prepareStatement(sql1);
//		ps=con.prepareStatement(sql2);
//		ps=con.prepareStatement(sql3);
//		ps=con.prepareStatement(sql4);
//		ps=con.prepareStatement(sql5);
		ps = con.prepareStatement(sql6);
//		ps=con.prepareStatement(sql7);
//		ps=con.prepareStatement(sql8);
//		ps=con.prepareStatement(sql9);
		ResultSet rs = ps.executeQuery();
		ArrayList<NhanVienChinhThuc> list = new ArrayList<NhanVienChinhThuc>();
		while (rs.next()) {
			NhanVienChinhThuc nv = new NhanVienChinhThuc();
			nv.setEmployee_ID(rs.getInt("Employee_ID"));
			nv.setLast_Name(rs.getString("Last_Name"));
			nv.setFirst_Name(rs.getString("First_Name"));
			nv.setDepartment(rs.getString("Department"));
			nv.setSalary_Type(rs.getInt("Salary_Type"));
			nv.setEmployment_Status(rs.getString("Employment_Status"));
			nv.setHire_Date(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Hire_Date")));
			nv.setTerminate_Date(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Termination_Date")));
			nv.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("birthday")));
			nv.setPhone(rs.getString("Phone"));
			nv.setEmail(rs.getString("Email"));
			nv.setAddress1(rs.getString("Address1"));
			nv.setGender(rs.getInt("Gender"));
			nv.setPay_Rate(rs.getString("Pay_Rate"));
			nv.setPay_Rate_Name(rs.getString("Pay_Rate_Name"));
			nv.setJob_Title(rs.getString("Job_Title"));
			nv.setSupervisor(rs.getString("Supervisor"));
			nv.setValue(rs.getInt("Value"));
			nv.setVacation_Days(rs.getInt("Vacation_Days"));
			nv.setTax_Percentage(rs.getInt("Tax_Percentage"));
			nv.setPay_Amount(rs.getInt("Pay_Amount"));
			nv.setPT_Level_C(rs.getInt("PT_Level_C"));

			list.add(nv);
		}
		return list;
	}

	public static Personal2 getInfoToEmployee(int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Personal where Employee_ID = '" + id + "' ");
		ResultSet rs = ps.executeQuery();
		Personal2 p = new Personal2();
		while (rs.next()) {
			p.setEmployee_ID(rs.getInt("Employee_ID"));
			p.setLast_Name(rs.getString("Last_Name"));
			p.setFirst_Name(rs.getString("First_Name"));
			p.setSsn(rs.getString("ssn"));
		}
		return p;
	}

	public static boolean Them_Personal(Personal2 p) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into Personal(First_Name,Last_Name,Address1,City,State,Zip,Email,Phone_Number,\n"
						+ "ssn,Drivers_License,Marital_Status,Gender,Shareholder_Status,Benefit_Plans,Ethnicity,birthday) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, p.getFirst_Name());
		ps.setString(2, p.getLast_Name());
		ps.setString(3, p.getAddress1());
		ps.setString(4, p.getCity());
		ps.setString(5, p.getState());
		ps.setInt(6, p.getZip());
		ps.setString(7, p.getEmail());
		ps.setString(8, p.getPhone());
		ps.setString(9, p.getSsn());
		ps.setString(10, p.getDrivers_license());
		ps.setString(11, p.getMarital_Status());
		ps.setInt(12, p.getGender());
		ps.setInt(13, p.getShareholderStatus());
		ps.setInt(14, p.getBenefitplans());
		ps.setString(15, p.getEthnicity());
		ps.setString(16, p.getBirthday());
		return ps.executeUpdate() == 1;
	}

	public static boolean Them_JobHistory_2_SQLSERVER(Job_History j) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into Job_History(Employee_ID,Department,Division,Start_Date,End_Date,Job_Title,Supervisor,Job_Category,Location,Departmen_Code,Salary_Type,Pay_Period,Hours_per_Week,Hazardous_Training) \n"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, j.getEmployee_ID());
		ps.setString(2, j.getDepartment());
		ps.setString(3, j.getDivision());
		ps.setString(4, j.getStart_Date());
		ps.setString(5, j.getEnd_Date());
		ps.setString(6, j.getJob_Title());
		ps.setString(7, j.getSupervisor());
		ps.setString(8, j.getJob_Category());
		ps.setString(9, j.getLocation());
		ps.setInt(10, j.getDepartmen_Code());
		ps.setInt(11, j.getSalary_Type());
		ps.setString(12, j.getPay_Period());
		ps.setInt(13, j.getHours_per_Week());
		ps.setInt(14, j.getHazardous_Training());
		return ps.executeUpdate() == 1;
	}

	public static int getID() throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select*from Personal ");
		ResultSet rs = ps.executeQuery();
		int k = 0;
		while (rs.next()) {
			k = rs.getInt("Employee_ID");
		}
		return k;
	}
	public static boolean Them_Employee_2_MySQL(employee e) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into employee(idEmployee,Last_Name,First_Name,SSN,Pay_Rates_idPay_Rates) values(?,?,?,?,?) ");
		ps.setInt(1, e.getEmployee_id());
		ps.setString(2, e.getLast_Name());
		ps.setString(3, e.getFrist_Name());
		ps.setInt(4, e.getSSN());
		ps.setInt(5, e.getPay_Rate_idPay_Rates());
		return ps.executeUpdate() == 1;
		
	}
	public static boolean ThemNgayNghi(Day_off day) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into Day_off(idEmployee,Last_Name,First_Name,SSN,Birthday,Gender,Address,Phone_number,date_back,reason,Vacation_Days) values(null,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, day.getLast_Name());
		ps.setString(2, day.getFirst_Name());
		ps.setInt(3, day.getSSN());
		ps.setString(4, day.getBirthday());
		ps.setInt(5, day.getGender());
		ps.setString(6, day.getAddress());
		ps.setString(7, day.getPhone_Number());
		ps.setString(8, day.getDate_Back());
		ps.setString(9, day.getReason());
		ps.setInt(10, day.getVacation_Days());
		return ps.executeUpdate() == 1;
	}

	public static boolean Them_Employment(Employement e) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into Employment(Employee_ID,Employment_Status,Hire_Date,Termination_Date) values(?,?,?,?)");
		ps.setInt(1, e.getEmployee_ID());
		ps.setString(2, e.getEmployment_Status());
		ps.setString(3, e.getHire_Date());
		ps.setString(4, e.getTermination_Date());
		return ps.executeUpdate() == 1;
	}

	public static boolean upDate_Employment_2_SQLSERVER(int Employee_ID, String Employment_Status, String Hire_Date,
			String Termination_Date, String Rehire_Date, String Last_Review_Date) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con
				.prepareStatement("update Employment set Employment_Status = '" + Employment_Status + "' , Hire_Date='"
						+ Hire_Date + "',Termination_Date='" + Termination_Date + "',Rehire_Date='" + Rehire_Date
						+ "',Last_Review_Date='" + Last_Review_Date + "' where Employee_ID='" + Employee_ID + "' ");

		return ps.executeUpdate() == 1;
	}

	public static boolean upDate_Personal_2_SQLSERVER(String Marital_Status, String Last_Name, String Ethnicity,
			String First_Name, String Drivers_License, int Gender, String ssn, String Email,
			int Shareholder_Status, String birthday, String State, String City, int Zip, String Address1,
			String Phone_Number, int Employee_ID) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("update Personal \n" + "set Marital_Status='" + Marital_Status
				+ "',Last_Name='" + Last_Name + "',Ethnicity='" + Ethnicity + "',First_Name='" + First_Name
				+ "',Drivers_License='" + Drivers_License + "',Gender='" + Gender + "',ssn='"
				+ ssn + "',\n" + "Email='" + Email + "',Shareholder_Status='" + Shareholder_Status
				+ "',birthday='" + birthday + "',State='" + State + "',City='" + City + "',Zip='" + Zip + "',Address1='"
				+ Address1 + "',Phone_Number='" + Phone_Number + "'\n" + "where Employee_ID='" + Employee_ID + "' ");

		return ps.executeUpdate() == 1;
	}

	public static boolean upDate_Employment_2_SQLSERVER(String Hire_Date, String Termination_Date, int Employee_ID)
			throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("update Employment set Hire_Date='" + Hire_Date + "', \n "
				+ "  Termination_Date='" + Termination_Date + "' where Employee_ID ='" + Employee_ID + "' ");

		return ps.executeUpdate() == 1;
	}

	public static boolean xoaPersonal(int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from Personal where Employee_ID = '" + id + "' ");
		return ps.executeUpdate() == 1;
	}

	public static boolean xoaEmployment(int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from Employment where Employee_ID = '" + id + "' ");
		return ps.executeUpdate() == 1;
	}

	public static void xoaNhanVienChinhThuc() throws SQLException {
		Connection con = DBConnect.getConnection();
		NhanVienChinhThuc nv = new NhanVienChinhThuc();
		PreparedStatement ps = con.prepareStatement("delete from nhanvienchinhthuc where Employee_ID =?");
		ps.setInt(1, nv.getEmployee_ID());
		ResultSet rs = ps.executeQuery();

	}

	public static ArrayList<employee> getAllEmployee() throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		ArrayList<employee> list = new ArrayList<employee>();
		while (rs.next()) {
			employee e = new employee();
			e.setEmployee_id(rs.getInt("idEmployee"));
			e.setEmployee_number(rs.getInt("Employee_number"));
			e.setPay_Rate(rs.getString("Pay_Rate"));
			e.setLast_Name(rs.getString("Last_Name"));
			e.setFrist_Name(rs.getString("First_Name"));
			e.setSSN(rs.getInt("SSN"));
			e.setPay_Rate_idPay_Rates(rs.getInt("Pay_Rates_idPay_Rates"));
			e.setVacation_Days(rs.getInt("Vacation_Days"));
			e.setPaid_To_Date(rs.getInt("Paid_To_Date"));
			e.setPaid_Last_Year(rs.getInt("Paid_Last_Year"));
			list.add(e);
		}

		return list;
	}
	public static ArrayList<User> getAlluser() throws SQLException{
		Connection con=DBConnect.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from user");
		ResultSet rs=ps.executeQuery();
		ArrayList<User> list=new ArrayList<User>();
		while (rs.next()) {
			User u=new User();
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			list.add(u);
		}
		return list;
	}
	
	public static ArrayList<Day_off> getAllDay_off() throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Day_off");
		ResultSet rs = ps.executeQuery();
		ArrayList<Day_off> list = new ArrayList<Day_off>();
		while (rs.next()) {
			Day_off day=new Day_off();
			day.setEmployee_id(rs.getInt("idEmployee"));
			day.setLast_Name(rs.getString("Last_Name"));
			day.setFirst_Name(rs.getString("First_Name"));
			day.setSSN(rs.getInt("SSN"));
			day.setVacation_Days(rs.getInt("Vacation_Days"));
			day.setBirthday(rs.getString("Birthday"));
			day.setGender(rs.getInt("Gender"));
			day.setPhone_Number(rs.getString("Phone_number"));
			day.setReason(rs.getString("Reason"));
			day.setSSN(rs.getInt("SSN"));
			day.setDate_Back(rs.getString("Date_Back"));
			list.add(day);
		}

		return list;
	}
	public static ArrayList<Salary_Employee> getAllSalary() throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from salary_employee");
		ResultSet rs = ps.executeQuery();
		ArrayList<Salary_Employee> list = new ArrayList<Salary_Employee>();
		while (rs.next()) {
			Salary_Employee sa=new Salary_Employee();
			sa.setEmployee_id(rs.getInt("Employee_id"));
			sa.setLast_Name(rs.getString("Last_Name"));
			sa.setFirst_Name(rs.getString("First_Name"));
			sa.setSSN(rs.getInt("SSN"));
			sa.setVacation_Days(rs.getInt("Vacation_Days"));
			sa.setBirthday(rs.getString("Birthday"));
			sa.setGender(rs.getString("Gender"));
			sa.setPhone_Number(rs.getString("Phone_number"));
			sa.setSalary_Basic(rs.getInt("Salary_Basic"));
			sa.setOvertime(rs.getInt("Overtime"));
			sa.setSubsidize(rs.getInt("Subsidize"));
			sa.setWorking_days(rs.getInt("Working_days"));
			list.add(sa);
		}

		return list;
	}
	public static boolean Add_Salary(int Salary_Basic, int id,int Overtime,int Subsidize ) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update salary_employee set Salary_Basic='" + Salary_Basic + "',Overtime='" + Overtime + "',Subsidize='" + Subsidize + "'  where employee_id='" + id + "' ");
		return ps.executeUpdate() == 1;
	}
	public static boolean ngaynghi(String Vacation_Day, int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update day_off set Vacation_Days='" + Vacation_Day + "' where idEmployee='" + id + "' ");
		return ps.executeUpdate() == 1;
	}
	public static boolean ngaylamNV(int Working_days) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update salary_employee set Working_days='" + Working_days + "' ");
		return ps.executeUpdate() == 1;
	}

	public static ArrayList<Personal2> getListP(int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from personal where Employee_ID= '" + id + "' ");
		ResultSet rs = ps.executeQuery();
		ArrayList<Personal2> list = new ArrayList<Personal2>();
		Personal2 p = new Personal2();
		while (rs.next()) {
			p.setEmployee_ID(rs.getInt("Employee_ID"));
			p.setFirst_Name(rs.getString("First_Name"));
			p.setLast_Name(rs.getString("Last_Name"));
			p.setAddress1(rs.getString("Address1"));
			p.setCity(rs.getString("City"));
			p.setState(rs.getString("State"));
			p.setZip(rs.getInt("Zip"));
			p.setEmail(rs.getString("Email"));
			p.setPhone(rs.getString("Phone_Number"));
			p.setSsn(rs.getString("ssn"));
			p.setDrivers_license(rs.getString("Drivers_License"));
			p.setMarital_Status(rs.getString("Marital_Status"));
			p.setGender(rs.getInt("Gender"));
			p.setShareholderStatus(rs.getInt("Shareholder_Status"));
			p.setEthnicity(rs.getString("Ethnicity"));
			p.setBirthday(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("birthday")));
			list.add(p);
		}
		return list;
	}

	public static ArrayList<Employement> getListE(int id) throws SQLException {
		Connection con = DBConnect.getConnection();
		PreparedStatement ps = con.prepareStatement("select*from personal where Employee_ID = '" + id + "' ");
		ResultSet rs = ps.executeQuery();
		ArrayList<Employement> list = new ArrayList<Employement>();
		while (rs.next()) {
			Employement e = new Employement();
			ps.setInt(1, e.getEmployee_ID());
			ps.setString(2, e.getEmployment_Status());
			ps.setString(3, e.getHire_Date());
			ps.setString(4, e.getTermination_Date());
			e.setEmployee_ID(rs.getInt("Employee_ID"));
			e.setEmployment_Status(rs.getString("Employment_Status"));
			e.setHire_Date(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Hire_Date")));
			e.setTermination_Date(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Termination_Date")));
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
	

		for (NhanVienChinhThuc nv : PersonalDAO.getNhanVienChinhThuc()) {

			DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
			Date currentDate = new Date();

			String startDate = nv.getBirthday();
			String endDate = simpleDateFormat.format(currentDate);

			Date date1 = simpleDateFormat.parse(startDate);
			Date date2 = simpleDateFormat.parse(endDate);

			Long getDiff =Math.abs((date2.getTime() - date1.getTime()))  / (24 * 60 * 60 * 1000);
			System.out.printf("Còn %d ngày nữa đến SN \n",getDiff);
	}
		
//			for(Salary_Employee sa : PersonalDAO.getAllSalary()) {
//				
//
//				int luongcb = sa.getSalary_Basic();
//				int phucap = sa.getSubsidize();
//				int tangca = sa.getOvertime();
//				int luongTC = (luongcb / sa.getWorking_days()) * tangca ;
//				int Working_days=sa.getWorking_days() - sa.getVacation_Days();
//				int LuongCT = (((luongcb + phucap + luongTC) / 26) * Working_days);
//				Locale localeVN = new Locale("vi", "VN");
//				NumberFormat vn = NumberFormat.getInstance(localeVN);
//				String getLuongct = vn.format(LuongCT);
//				System.out.println("Lương chính thức: "+getLuongct);
////				System.out.println("Lương tăng ca: "+luongTC);
//			}
}
}