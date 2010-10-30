package org.wwald.service;

import java.sql.Connection;
import java.util.List;

import org.wwald.model.Competency;
import org.wwald.model.Course;
import org.wwald.model.CourseEnrollmentStatus;
import org.wwald.model.Mentor;
import org.wwald.model.StatusUpdate;
import org.wwald.model.User;

public interface IDataFacade {
	
	//Course
	public List<Course> retreiveCourses(Connection c);
	public List<Course> retreiveCouresesListedInCourseWiki(Connection c);
	public Course retreiveCourse(Connection c, String courseId);
	public String retreiveCourseWiki(Connection c);
	public void updateCourse(Connection c, Course course);
	public void insertCourse(Connection c, Course course);
	public void upsertCourse(Connection c, Course course);
	public void updateCourseWiki(Connection c, String wikiContents);
	public CourseEnrollmentStatus getCourseEnrollmentStatus(Connection c, User user, Course course) throws DataException;
	public void addCourseEnrollmentAction(Connection c, CourseEnrollmentStatus courseEnrollmentStatus);
	
	//Competencies
	public void updateCompetenciesWikiContents(Connection c, String courseId, String contents);	
	public List<Competency> retreiveAllCompetencies(Connection c);
	public List<Competency> retreiveCompetenciesForCourse(Connection c, Course course);
	public Competency retreiveCompetency(Connection c, String courseId, String competencyId);
	public String retreiveCompetenciesWiki(Connection c, String courseId);
	public void updateCompetency(Connection c, String courseId, Competency competency);
	public Competency insertCompetency(Connection c, Course course, String title) throws DataException;
	public void upsertCompetency(Connection c, Competency competency);
	public void deleteCompetency(Connection c, Competency competency);
	
	//Mentors
	public List<Mentor> retreiveAllMentors(Connection c);
	public List<Mentor> retreiveMentorsForCourse(Connection c);
	public List<Mentor> retreiveMentorsForCompetency(Connection c);
	public void updateMentor(Connection c, Mentor mentor);
	public void insertMentor(Connection c, Mentor mentor);
	public void upsertMentor(Connection c, Mentor mentor);
	public void deleteMentor(Connection c, Mentor mentor);
	
	//Status updates
	public List<StatusUpdate> getStatusUpdates(Connection c);
	
	//User
	public User retreiveUser(Connection c, String userName, String password) throws DataException ;
	
}
