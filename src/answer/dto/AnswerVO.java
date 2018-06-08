package answer.dto;

import java.sql.Timestamp;

public class AnswerVO {
	private int num;
	private int fr_num;
	private String content;
	private Timestamp writedate;
	private String nick;
	
	public AnswerVO() {

	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "AnswerVO [num=" + num + ", fr_num=" + fr_num + ", content=" + content + ", writedate=" + writedate
				+ ", nick=" + nick + "]";
	}

	
	
}
