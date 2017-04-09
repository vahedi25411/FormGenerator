/*
 * Text area class handles the text area aspect of forms.
 */
package formgenerator.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TextArea")
public class Textarea extends FormElement{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "default_value")
	private String defaultValue;
	
	@Column(name = "column_value")
	private Integer column;
	
	@Column(name = "row_value")
	private Integer row;
	
	@Column(name = "min_length")
	private Integer minLength;
	
	@Column(name = "max_length")
	private Integer maxLength;
	
	
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	
}
