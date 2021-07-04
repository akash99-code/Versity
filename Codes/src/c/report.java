package c;
import java.util.ArrayList;


public class report {
	private String Name;
	private String Sem;
	private String Year;
	private ArrayList<String[]> students;
	private ArrayList<String[]> classes;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<String[]> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<String[]> students) {
		this.students = students;
	}
	public ArrayList<String[]> getClasses() {
		return classes;
	}
	public void setClasses(ArrayList<String[]> classes) {
		this.classes = classes;
	}
	public String getSem() {
		return Sem;
	}
	public void setSem(String sem) {
		Sem = sem;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	
}
