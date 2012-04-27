package gms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GMSTestCaseSetup{

	@Id
	private int id;
	
	@Column
	private String descriptionSetup;
	
	@Column
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionSetup() {
		return descriptionSetup;
	}

	public void setDescriptionSetup(String descriptionSetup) {
		this.descriptionSetup = descriptionSetup;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
