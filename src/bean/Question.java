package bean;

public class Question {
	private int questionid;
	private String question;
	private String answer;
	private int subjectid;
	private String optiona;
	private String optionb;
	private String optionc;
	private String optiond;
	
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int questionid, String question, String answer,
			int subjectid, String optiona, String optionb, String optionc,
			String optiond) {
		super();
		this.questionid = questionid;
		this.question = question;
		this.answer = answer;
		this.subjectid = subjectid;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
	}
	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", question=" + question
				+ ", answer=" + answer + ", subjectid=" + subjectid
				+ ", optiona=" + optiona + ", optionb=" + optionb
				+ ", optionc=" + optionc + ", optiond=" + optiond + "]";
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public String getOptiona() {
		return optiona;
	}
	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}
	public String getOptionb() {
		return optionb;
	}
	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}
	public String getOptionc() {
		return optionc;
	}
	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}
	public String getOptiond() {
		return optiond;
	}
	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}
	
	
	
}
