package formgenerator.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "choices")
public class Choice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="choice_id_seq",sequenceName="choice_id_seq",initialValue = 100,allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="choice_id_seq")
	private Integer id;	
	
	private String text;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
