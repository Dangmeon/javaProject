package exam.collection.arraylistex;

public class Board {
	
	private String subject;
	private String content;
	private String wirter;
	
	public Board(String subject, String content, String wirter) {
		this.subject = subject;
		this.content = content;
		this.wirter = wirter;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWirter() {
		return wirter;
	}
	public void setWirter(String wirter) {
		this.wirter = wirter;
	}
	
	

}
