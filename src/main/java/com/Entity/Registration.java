	package com.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name = "registration")
	public class Registration {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

	    @ManyToOne
	    @JoinColumn(name = "course_id")
	    private Course course;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public int hashCode() {
			return Objects.hash(course, id, student);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Registration other = (Registration) obj;
			return Objects.equals(course, other.course) && Objects.equals(id, other.id)
					&& Objects.equals(student, other.student);
		}

		@Override
		public String toString() {
			return "Registration [id=" + id + ", student=" + student + ", course=" + course + "]";
		}

		public Registration(Long id, Student student, Course course) {
			super();
			this.id = id;
			this.student = student;
			this.course = course;
		}

		public Registration() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	    // getters and setters
	}

