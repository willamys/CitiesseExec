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
	private int idTestCase;
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
	public int getTestCase() {
		return idTestCase;
	}
	public void setTestCase(int idTestCase) {
		this.idTestCase = idTestCase;
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
