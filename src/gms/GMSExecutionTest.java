package gms;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GMSExecutionTest {
	@Id
	private int id;
	@Column
	private GMSUser user;
	@Column
	private Timestamp startDate;
	@Column
	private Timestamp finishDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GMSUser getUser() {
		return user;
	}
	public void setUser(GMSUser user) {
		this.user = user;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}

}
