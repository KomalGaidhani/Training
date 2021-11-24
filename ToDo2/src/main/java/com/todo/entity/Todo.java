package com.todo.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Todo")
@Getter@Setter
public class Todo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(nullable = false)
	private long id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
    TodoStatus todoStatus;

	@CreationTimestamp
    @Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
	private Timestamp  dateCreated;
	
	@UpdateTimestamp
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
	private Timestamp lastModified;
	
}
