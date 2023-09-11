/***********************************
Due Date:		March 12th, 2020
***********************************/

public class UACourse {
	
	public int courseId;
	public String courseName;
	public String courseDescription;
	public UACourse next;
	public UACourse prev;
	public int accessCount;
	
    public UACourse() {
    	this.courseId = 0;
		this.courseName = "";
		this.courseDescription = "";
    }
	
	public UACourse(int id, String name, String desc) {
		this.courseId = id;
		this.courseName = name;
		this.courseDescription = desc;
	}
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public UACourse getNext() {
		return next;
	}
	
	public void setNext(UACourse next) {
		this.next = next;
	}
	
	public UACourse getPrev() {
		return prev;
	}
	
	public void setPrev(UACourse prev) {
		this.prev = prev;
	}
	
	public int getAccessCount() {
		return accessCount;
	}
	
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	
	public String toString() {
		return String.format("|%8s| %15.15s: %-30.30s %5d \n", this.courseId, this.courseName, this.courseDescription, this.accessCount);
	}
}
