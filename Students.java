//Dylan Aron
//Creates a student that holds all their assignments and calculates their grade
import java.util.*;
public class Students
{
	private String fName;
	private String lName;
	private ArrayList<Assignments> grades;
	private double grade;

	//construct a student with first and last name and initializes a list of their assignments
	public Students(String f, String l)
	{
		fName=f;
		lName=l;
		grade=0;
		grades = new ArrayList<Assignments>();
	}
	//return first name
	public String getfName()
	{
		return fName;
	}
	//return last name
	public String getlName()
	{
		return lName;
	}

	//return list of assignments
	public ArrayList<Assignments> getAssigns()
	{
		return grades;
	}
	//returns grade
	public double getTotalGrade()
	{
		return this.calcGrade();
	}
	//fills grades in their assignments
	public void fillGradesList(ArrayList<Assignments> g)
	{
		for(int i=0; i<g.size(); i++)
		{
			grades.add(g.get(i));
		}
	}
	//calculates the total grade
	public double calcGrade()
	{
		int grade=0;
		for(int i=0; i<grades.size(); i++)
		{
			Assignments g = grades.get(i);
			grade += g.getGrade() * g.getWeight();
		}
		return grade;
	}


}