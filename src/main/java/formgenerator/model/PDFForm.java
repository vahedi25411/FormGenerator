/*
 * PDFForm is the java class that has all the PDFElements.
 * 
 * id: a unique identifier to differentiate between other PDFForms.
 * form: a reference to the form object that is related to this PDFForm.
 * path: a string of the path of the location of the pdf in the hard drive
 * owner: the owner of the PDFForm as a Member object
 * pdfElements: a list of pdf elements that belong to the pdf form.
 */

package formgenerator.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class PDFForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="pdfForm_id_seq",sequenceName="pdfForm_id_seq",initialValue = 100,allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pdfForm_id_seq")	
	@Column(name="pdfForm_Id")
	private Integer id;
	
	@OneToOne
 	private Form form;
	
	@Column(name="path")
	private String path;
	
	@OneToOne
	private Member owner;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Member getOwner() {
		return owner;
	}
	public void setOwner(Member owner) {
		this.owner = owner;
	}

}
