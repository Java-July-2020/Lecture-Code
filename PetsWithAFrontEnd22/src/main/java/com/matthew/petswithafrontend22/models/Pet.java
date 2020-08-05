package com.matthew.petswithafrontend22.models;

	import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name="pets")
	public class Pet {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Size(min=2, max=15)
		private String name;
		@NotNull
		private String species;
		private int age;
		@OneToOne(mappedBy="pet", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private Tag tag;
		@Column(updatable=false)
		@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
		private Date createdAt;
		@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
		private Date updatedAt;

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

		public Pet() {
			
		}

		
		public Pet(@Size(min = 2, max = 15) String name, @NotNull String species, int age) {
			super();
			this.name = name;
			this.species = species;
			this.age = age;
		}

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

		public String getSpecies() {
			return species;
		}

		public void setSpecies(String species) {
			this.species = species;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		public Tag getTag() {
			return tag;
		}

		public void setTag(Tag tag) {
			this.tag = tag;
		}

		
	}


