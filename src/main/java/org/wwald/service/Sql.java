package org.wwald.service;

public class Sql {
	public static String INSERT_USER = "INSERT into USER (first_name, mi, last_name, username, password, join_date, role) " +
									   "VALUES (%s, %s, %s, %s, %s, %s, %s);";
	
	public static String RETREIVE_USER =
		"SELECT * FROM USER WHERE username=%s AND password=%s;";
	
	public static String INSERT_MENTOR = 
		"INSERT INTO MENTOR (first_name, middle_initial, last_name, short_bio) VALUES (%s, %s, %s, %s);";
	
	public static String INSERT_COURSES_WIKI = "INSERT INTO COURSES_WIKI (id, content) VALUES (%s,%s);";
	
	public static String INSERT_COURSE = "INSERT INTO COURSE (id, title, description) VALUES (%s, %s, %s);";
	
	public static String INSERT_COURSE_COMPETENCIES_WIKI = "INSERT INTO COURSE_COMPETENCIES_WIKI (course_id, contents) VALUES (%s, %s);";
	
	public static String INSERT_COMPETENCY = "INSERT INTO COMPETENCY (id, course_id, title, description, resources) VALUES (%s,%s,%s,%s,%s);";
}