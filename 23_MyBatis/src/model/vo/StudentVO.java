package model.vo;

public class StudentVO {
	
	private String studentNo;
	private String studentName;
	private String studentAddress;
	
	private DepartmentVO department;

	public StudentVO() {}

	public StudentVO(String studentNo, String studentName, String studentAddress, DepartmentVO department) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.department = department;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "StudentVO [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", department=" + department + "]";
	}
	
	
	
	
	
	

}
