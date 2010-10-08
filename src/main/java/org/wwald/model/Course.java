/**
 * 
 */
package org.wwald.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * @author pshah
 *
 */
public class Course implements Serializable {
	
	private String id;
	private String title;
	private String description;
	private List<Competency> competencies;
	private Mentor mentor;
	
	private static Logger cLogger = Logger.getLogger(Course.class);
	
	public Course(String id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.competencies = new ArrayList<Competency>();
	}
		
	public String getId() {
		return this.id;
	}
	
	public void setId() {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
	}
	
	public List<Competency> getCompetencies() {
		return this.competencies;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	
	public Mentor getMentor() {
		return this.mentor;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.title;
	}

	public Competency getCompetency(int id) {
		Competency competency = null;
		
		for(Competency aCompetency : competencies) {
			if(id == aCompetency.getId()) {
				competency = aCompetency;
				break;
			}
		}
		
		return competency;
	}
	
	public Competency getCompetency(String id) {
		Competency competency = null;
		try {
			int intid = Integer.parseInt(id);
			competency = getCompetency(intid);
		} catch(NumberFormatException nfe) {
			cLogger.error("Could not convert String " + id + " to int ", nfe);
		}
		
		return competency;
	}
}