/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.business.model.EntityLiveOne;
import br.com.infoeski.liveone.services.component.DateToJsonSerializer;
import br.com.infoeski.liveone.services.component.JsonToDateDeserializer;

/**
 * Class that support basic informations of the Member.
 * 
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
@Document(collection = "members")
@XmlRootElement
public class Member extends EntityLiveOne {

	/**
	 * Constructor.
	 */
	public Member() {
		super();

		// Load create field.
		if (!hasId()) {
			this.create = new Date();
		}
	}

	/**
	 * Field that receive electronic mail of the member.
	 */
	@Field
	private String email;

	/**
	 * Field that receive the simple name of the member.
	 */
	@Field
	private String nickName;

	/**
	 * Field that receive the Last Name of the member.
	 */
	@Field
	private String lastName;

	/**
	 * Field that receive the First Name of the member.
	 */
	@Field
	private String firstName;

	/**
	 * Field that receive the Birthday date of the member.
	 */
	@Field
	@JsonSerialize(using = DateToJsonSerializer.class)
	@JsonDeserialize(using = JsonToDateDeserializer.class)
	private Date birthday;

	/**
	 * Field that check register completed of the member.
	 */
	@Field
	private boolean register;

	/**
	 * Field that receive the create date of the member's register.
	 */
	@Field
	@JsonSerialize(using = DateToJsonSerializer.class)
	@JsonDeserialize(using = JsonToDateDeserializer.class)
	private Date create;

	/**
	 * Field that receive the member's gender.
	 */
	@Field
	private Gender gender;

	/**
	 * Field that receive collection member's addresses.
	 */
	@Field
	private List<Address> addresses;

	/**
	 * Field that receive collection member's phones.
	 */
	@Field
	private List<Phone> phones;

	/**
	 * Field that receive collection member's preferences.
	 */
	@Field
	private List<Preference> preferences;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the register
	 */
	public boolean isRegister() {
		return register;
	}

	/**
	 * @param register
	 *            the register to set
	 */
	public void setRegister(boolean register) {
		this.register = register;
	}

	/**
	 * @return the create
	 */
	public Date getCreate() {
		return create;
	}

	/**
	 * @param create
	 *            the create to set
	 */
	public void setCreate(Date create) {
		this.create = create;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		if (this.addresses == null) {
			this.addresses = new ArrayList<Address>();
		}
		return addresses;
	}

	/**
	 * Add new Address in the Collection.
	 * 
	 * @param address
	 *            reference of Address to add
	 * @return this
	 */
	public Member addAddress(Address address) {
		for (Address idx : getAddresses()) {
			if (idx.getId().equalsIgnoreCase(address.getId())) {
				getAddresses().remove(idx);
				getAddresses().add(address);
				return this;
			}
		}
		address.generatedId();
		getAddresses().add(address);
		return this;
	}

	/**
	 * Delete Address in the Collection.
	 * 
	 * @param idAddress
	 *            ID of Address to add
	 * @return this
	 */
	public Member deleteAddress(String id) {
		for (Address idx : getAddresses()) {
			if (idx.getId().equalsIgnoreCase(id)) {
				getAddresses().remove(idx);
				break;
			}
		}
		return this;
	}

	/**
	 * Delete Address in the Collection.
	 * 
	 * @param idAddress
	 *            ID of Address to add
	 * @return this
	 */
	public Address getAddress(String id) {
		for (Address address : getAddresses()) {
			if (address.getId().equalsIgnoreCase(id)) {
				return address;
			}
		}
		return null;
	}

	/**
	 * Clear the Collection.
	 * 
	 * @return this
	 */
	public Member clearAddresses() {
		getAddresses().clear();
		return this;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the phones
	 */
	public List<Phone> getPhones() {
		if (this.phones == null) {
			this.phones = new ArrayList<Phone>();
		}
		return phones;
	}

	/**
	 * Add new Address in the Collection.
	 * 
	 * @param address
	 *            reference of Address to add
	 * @return this
	 */
	public Member addPhone(Phone phone) {
		for (Phone idx : getPhones()) {
			if (idx.getId().equalsIgnoreCase(phone.getId())) {
				getPhones().remove(idx);
				getPhones().add(phone);
				return this;
			}
		}
		phone.generatedId();
		getPhones().add(phone);
		return this;
	}

	/**
	 * Delete Phone in the Collection.
	 * 
	 * @param idPhone
	 *            ID of Phone to add
	 * @return this
	 */
	public Member deletePhone(String id) {
		for (Phone idx : getPhones()) {
			if (idx.getId().equalsIgnoreCase(id)) {
				getPhones().remove(idx);
				break;
			}
		}
		return this;
	}

	/**
	 * Delete Phone in the Collection.
	 * 
	 * @param idPhone
	 *            ID of Phone to add
	 * @return this
	 */
	public Phone getPhone(String id) {
		for (Phone phone : getPhones()) {
			if (phone.getId().equalsIgnoreCase(id)) {
				return phone;
			}
		}
		return null;
	}

	/**
	 * Clear the Collection.
	 * 
	 * @return this
	 */
	public Member clearPhones() {
		getPhones().clear();
		return this;
	}

	/**
	 * @param phones
	 *            the phones to set
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * @return the preferences
	 */
	public List<Preference> getPreferences() {
		if (this.preferences == null) {
			this.preferences = new ArrayList<Preference>();
		}
		return preferences;
	}

	/**
	 * Add new Address in the Collection.
	 * 
	 * @param address
	 *            reference of Address to add
	 * @return this
	 */
	public Member addPreference(Preference preference) {
		if (!getPreferences().contains(preference)) {
			getPreferences().add(preference);
		}
		return this;
	}

	/**
	 * Clear the Collection.
	 * 
	 * @return this
	 */
	public Member clearPreferences() {
		getPreferences().clear();
		return this;
	}

	/**
	 * @param preferences
	 *            the preferences to set
	 */
	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
}
