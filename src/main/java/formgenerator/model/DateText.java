/*
 * DateText is a java class that extends form element and is specialized to handle date input.
 * 
 * defaultDate: a date object created from the input
 * dateFormat: the format of the date ex: mm/dd/yyyy
 * form: a reference to the form where this date text belongs to
 */
package formgenerator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DateText")
public class DateText extends FormElement{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "default_date")
	private Date defaultDate;
	
	@Column(name = "date_format")
	private String dateFormat;
	
	public Date getDefaultDate() {
		return defaultDate;
	}
	public void setDefaultDate(Date defaultDate) {
		this.defaultDate = defaultDate;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
}
