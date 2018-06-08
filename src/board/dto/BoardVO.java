package board.dto;
import java.sql.Timestamp;

public class BoardVO {
	private int num;
	private int fr_num;
	private String nick;			// 작성자(닉네임)
	private int age;				// 나이
	private String category;		// 게시판 분류
	private String f_category;		// FAQ 게시글 분류
	private String title;
	private String content;
	private String image;
	private Timestamp writedate;
	private int good;
	private int readcount;
	private String titlecolor;
	private String link;
	
	public BoardVO() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getFr_num() {
		return fr_num;
	}

	public void setFr_num(int fr_num) {
		this.fr_num = fr_num;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getF_category() {
		return f_category;
	}

	public void setF_category(String f_category) {
		this.f_category = f_category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getTitlecolor() {
		return titlecolor;
	}

	public void setTitlecolor(String titlecolor) {
		this.titlecolor = titlecolor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", fr_num=" + fr_num + ", nick=" + nick + ", age=" + age + ", category="
				+ category + ", f_category=" + f_category + ", title=" + title + ", content=" + content + ", image="
				+ image + ", writedate=" + writedate + ", good=" + good + ", readcount=" + readcount + ", titlecolor="
				+ titlecolor + ", link=" + link + "]";
	}

	
	
}
