package servlet.model.vo;
/*
 * VO(Value Object), DTO(Data Transfer Object) : 데이터 전송 및 저장 객체
 * - getter/setter만 가지는 것을 DTO
 * - 실상은 구별없이 사용하는 편
 * */
public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
