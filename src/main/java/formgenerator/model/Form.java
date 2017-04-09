/*
 * This Form java class shall contain all the information the form has after converting it
 * 
 * id: a unique identifier
 * title: the title of the form
 * description: a brief description of what the form is
 * createdDate: a date object that tells us the creation date of the form
 * modifiedDate: a date object that tells us the last date in which the form was modified
 * submitDate: a date object that tells us the date that this form has to be submitted by
 * ownedBy: a member object that signifies who the owner is
 * roles: a role object
 * pages: a list of page objects that contains the actual form
 */
package formgenerator.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="forms")
public class Form implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name="form_id_seq",sequenceName="form_id_seq",initialValue = 100,allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="form_id_seq")	
	@Column(name="Id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="Title", length=40)
	private String title;
	
	@Column(name="Description", length=100)
	private String description;
	
	@Column(name="Created_Date")
	private Date createdDate;
	
	@Column(name="Modified_Date")
	private Date modifiedDate;
	
	@Column(name="Submission_Date")
	private Date submitDate;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="form")
	@Column(name="Pages")	
	private List<Page> pages;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ownerId")
	private Member ownedBy;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Role currentMemberRole;
	
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Member getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Member ownedBy) {
		this.ownedBy = ownedBy;
	}	
}
