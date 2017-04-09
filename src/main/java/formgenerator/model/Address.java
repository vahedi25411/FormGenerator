/*
 * This java class, Address.java, is the Address java object holds all necessary information for addresses
 * 
 * id: A unique id number for the SQL database
 * house: A four digit number for the address (house number)
 * street: The name street of the address
 * area: 
 * city: The city of the address as a string
 * pin: The zip code of the address as an Integer object
 * state: The state of the address as a string
 * country: The country of the address as a string
 */

package formgenerator.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Addresses")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="House", length=40)
	private String house;
	
	@Column(name="Street", length=40)
	private String street;
	
	@Column(name="Area", length=50)
	private String area;
	
	@Column(name="City", length=50)
	private String city;
	
	@Column(name="Zip_Code", length=10)
	private Integer zip;
	
	@Column(name="State", length=40)
	private String state;
	
	@Column(name="Country", length=30)
	private String country;
	
	/*
	@ManyToOne
	@JoinColumn(name = "Member_Id")
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}
