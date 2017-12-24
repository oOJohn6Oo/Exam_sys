package service;
import java.util.ArrayList;

import bean.*;
import dao.*;

public class QuestionService {
	QuestionDao qd = new QuestionDao();
	
	public ArrayList<Question> loadquestion(Subject subject) throws Exception {
		return qd.loadquestion(subject);
	}

}
