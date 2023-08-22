package model.vo;

public class DepartmentVO {
	
	private String departmentNo;
	private String departmentName;
	private String category;
	public DepartmentVO() {}
	public DepartmentVO(String departmentNo, String departmentName, String category) {
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.category = category;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "DepartmentVO [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
				+ category + "]";
	}
	
	

	
}
