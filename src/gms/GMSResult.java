package gms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GMSResult {
	
	@Id
	private int id;
	@Column
	private GMSTestCase testCase;
	@Column
	private String result;
	@Column
	private String comment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GMSTestCase getTestCase() {
		return testCase;
	}
	public void setTestCase(GMSTestCase testCase) {
		this.testCase = testCase;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
