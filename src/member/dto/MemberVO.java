package member.dto;

public class MemberVO {
	private int num;
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private String phone;
	private int age;
	private String gender;
	private String email;
	private int points;
	private int admin;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public MemberVO(int num, String id, String pwd, String name, String nick, String phone, int age, String gender,
			String email, int points, int admin) {
		super();
		this.num = num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nick = nick;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.points = points;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nick=" + nick + ", phone="
				+ phone + ", age=" + age + ", gender=" + gender + ", email=" + email + ", points=" + points + ", admin="
				+ admin + "]";
	}

}