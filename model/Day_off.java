package model;

public class Day_off {
	private int Employee_id;
	private String Last_Name;
	private String First_Name;
	private int SSN;
	private String Birthday;
	private int Gender;
	private String Address;
	private String Phone_Number;
	private String Date_Back;
	private String Reason;
	private int Vacation_Days;

	public Day_off() {

	}
	public Day_off(String Last_Name, String First_Name, int SSN, String Birthday, int Gender,
			String Address, String Phone_Number, String Date_Back, String Reason, int Vacation_Days) {
		this.Last_Name=Last_Name;
		this.First_Name = First_Name;
		this.SSN = SSN;
		this.Birthday = Birthday;
		this.Gender = Gender;
		this.Address = Address;
		this.Phone_Number = Phone_Number;
		this.Date_Back = Date_Back;
		this.Reason = Reason;
		this.Vacation_Days = Vacation_Days;
	}

	public Day_off(int Employee_id, String Last_Name, String First_Name, int SSN, String Birthday, int Gender,
			String Address, String Phone_Number, String Date_Back, String Reason, int Vacation_Days) {
		this.Employee_id = Employee_id;
		this.Last_Name=Last_Name;
		this.First_Name = First_Name;
		this.SSN = SSN;
		this.Birthday = Birthday;
		this.Gender = Gender;
		this.Address = Address;
		this.Phone_Number = Phone_Number;
		this.Date_Back = Date_Back;
		this.Reason = Reason;
		this.Vacation_Days = Vacation_Days;
	}


	public String getAddress() {
		return Address;
	}

	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getDate_Back() {
		return Date_Back;
	}

	public void setDate_Back(String date_Back) {
		Date_Back = date_Back;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
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

	public int getVacation_Days() {
		return Vacation_Days;
	}

	public void setVacation_Days(int vacation_Days) {
		Vacation_Days = vacation_Days;
	}

}
