package formgenerator.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TextDateA")
public class DateTextAnswer extends Answer {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "date_value")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
}
