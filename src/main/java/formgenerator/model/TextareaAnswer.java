package formgenerator.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TextArea")
public class TextareaAnswer extends Answer{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="textarea_value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}