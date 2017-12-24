package bean;

public class Subject {
	private int subjectId;
	private String subjectname;
	private String subejctRate;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int subjectId, String subjectname, String subejctRate) {
		super();
		this.subjectId = subjectId;
		this.subjectname = subjectname;
		this.subejctRate = subejctRate;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectname="
				+ subjectname + ", subejctRate=" + subejctRate + "]";
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getSubejctRate() {
		return subejctRate;
	}
	public void setSubejctRate(String subejctRate) {
		this.subejctRate = subejctRate;
	}
	
	
}
