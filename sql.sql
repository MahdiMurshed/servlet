-- course schema
CREATE TABLE `courses` (
  `course_name` varchar(50) NOT NULL,
  `course_code` varchar(80) NOT NULL,
  PRIMARY KEY (`course_code`)
);

-- users-courses relation
CREATE TABLE user_courses (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL,
  course_code VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (email) REFERENCES users(email),
  FOREIGN KEY (course_code) REFERENCES courses(course_code)
);

-- student-course
CREATE TABLE student_courses (
  email VARCHAR(255),
  course_code VARCHAR(255),
  PRIMARY KEY (email, course_code),
  FOREIGN KEY (email) REFERENCES users(email),
  FOREIGN KEY (course_code) REFERENCES courses(course_code)
);