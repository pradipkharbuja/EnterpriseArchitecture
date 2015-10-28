package org.ea.lab3.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@Column(name = "course_id")
	private int id;

	@Column(name = "course_number")
	private String courseNumber;

	@Column(name = "course_name")
	private String name;

	@ManyToMany
	@JoinTable(name = "course_student", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })

	List<Student> students;

}
