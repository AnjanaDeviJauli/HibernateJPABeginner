package com.test.project.HibernateJPABeginner.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {
	
      @Column(name = "USER_ID")
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;
	  @NonNull
	    private String fullname;
	  @NonNull
	    private String email;
	  @NonNull
	    private String password;
	  @NonNull
	    private int age;
	  @NonNull
	    private double salary;
	  @NonNull
	    private String city;

}
