package model;

public class Salary_Employee {
	private int Employee_id;
	private String Last_Name;
	private String First_Name;
	private int SSN;
	private String Birthday;
	private String Gender;
	private String Phone_Number;
	private int Vacation_Days;
	private int Salary_Basic;
	private int Overtime;
	private int Subsidize;
	private int Salary_official;
	private int Working_days;

	public Salary_Employee() {

	}

	public Salary_Employee(int Employee_id, String Last_Name, String First_Name, int SSN, String Birthday,
			String Gender, String Phone_Number, int Vacation_Days, int Salary_Basic, int Overtime,int Subsidize,int Salary_official,int Working_days) {
		this.Employee_id=Employee_id;
		this.Last_Name=Last_Name;
		this.First_Name=First_Name;
		this.SSN=SSN;
		this.Birthday=Birthday;
		this.Gender=Gender;
		this.Phone_Number=Phone_Number;
		this.Vacation_Days=Vacation_Days;
		this.Salary_Basic=Salary_Basic;
		this.Subsidize=Subsidize;
		this.Salary_official=Salary_official;
		this.Working_days=Working_days;

	}

	public int getWorking_days() {
		return Working_days;
	}

	public void setWorking_days(int working_days) {
		Working_days = working_days;
	}

	public int getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public int getVacation_Days() {
		return Vacation_Days;
	}
	public void setVacation_Days(int vacation_Days) {
		Vacation_Days = vacation_Days;
	}
	public int getSalary_Basic() {
		return Salary_Basic;
	}
	public void setSalary_Basic(int salary_Basic) {
		Salary_Basic = salary_Basic;
	}
	public int getOvertime() {
		return Overtime;
	}
	public void setOvertime(int overtime) {
		Overtime = overtime;
	}
	public int getSubsidize() {
		return Subsidize;
	}
	public void setSubsidize(int subsidize) {
		Subsidize = subsidize;
	}
	public int getSalary_official() {
		return Salary_official;
	}
	public void setSalary_official(int salary_official) {
		Salary_official = salary_official;
	}
	
	
}
