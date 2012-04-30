package gms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GMSTestCase{

	@Id
	private int id;
	
	@Column
	private String testCaseName;
	
	@Column
	private String descriptionSteps;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	public String getDescriptionSteps() {
		return descriptionSteps;
	}

	public void setDescriptionSteps(String descriptionSteps) {
		this.descriptionSteps = descriptionSteps;
	}

}
