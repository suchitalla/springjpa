package com.springjpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Publisher {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	
	  @ManyToMany	  
	  @JoinTable(name="publisher_magazine",joinColumns=@JoinColumn(name=
	  "publisher_id"), inverseJoinColumns=@JoinColumn(name="magazine_id"))	  
	  Set<Magazines> magazines = new HashSet<>();
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	  public Set<Magazines> getMagazines() { return magazines; }
	  
	  public void setMagazines(Set<Magazines> magazines) { this.magazines =
	  magazines; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Publisher other = (Publisher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", magazines=" + magazines + "]";
	}
	 
}
