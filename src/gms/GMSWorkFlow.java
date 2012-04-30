package gms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GMSWorkFlow{

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String version;
	//private List<GMSTestCase> workflow;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

//	public List<GMSTestCase> getWorkflow() {
//		return workflow;
//	}
//
//	public void setWorkflow(List<GMSTestCase> workflow) {
//		this.workflow = workflow;
//	}

}
