package com.keskadaniel.garden.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class ActionEntity {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="plant_id")
	private PlantEntity plant;
	
	@ManyToOne
 	@JoinColumn(name="user_id")
	private UserEntity user;
	
	private int month;
	
	public int getId() {
		return id;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PlantEntity getPlant() {
		return plant;
	}
	public void setPlant(PlantEntity plant) {
		this.plant = plant;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + month;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((plant == null) ? 0 : plant.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionEntity other = (ActionEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (month != other.month)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (plant == null) {
			if (other.plant != null)
				return false;
		} else if (!plant.equals(other.plant))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ActionEntity [id=" + id + ", name=" + name + ", description=" + description + ", plant=" + plant
				+ ", user=" + user + ", month=" + month + "]";
	}
	

	
}
