//Dylan Aron
//Creates a gradebook which holds a list of students and assignments and gets their letter grade
import java.util.*;
public class Gradebook
{
	private ArrayList<Students> studs;
	private ArrayList<Assignments> assigns;
	private int num;

	//Constructs the gradebook with a list of students and assignments, holding the number of students too
	public Gradebook(int numstuds)
	{
		num = numstuds;
		studs = new ArrayList<Students>();
		assigns = new ArrayList<Assignments>();
	}

	//returns number of students
	public int getNumstud()
	{
		return num;
	}

	//returns arraylist of students
	public ArrayList<Students> getStuds()
	{
		return studs;
	}

	//returns arraylist of assignments
	public ArrayList<Assignments> getAs()
	{
		return assigns;
	}

	//adds students to gradebook
	public void addStudents(String f, String l)
	{
		Students s = new Students(f, l);
		studs.add(s);
	}

	//adds assignments
	public void addAssignment(String n, double w)
	{	
		Assignments a = new Assignments(n, w);
		assigns.add(a);
	}

	//returns the letter grade of the student
	public String getLetter(Students s)
	{
		if (s.getTotalGrade()<65)
			return "F";
		else if (s.getTotalGrade()<70)
			return "D";
		else if (s.getTotalGrade()<74)
			return "C-";
		else if (s.getTotalGrade()<77)
			return "C";
		else if (s.getTotalGrade()<80)
			return "C+";
		else if (s.getTotalGrade()<84)
			return "B-";
		else if (s.getTotalGrade()<87)
			return "B";
		else if (s.getTotalGrade()<90)
			return "B+";
		else if (s.getTotalGrade()<94)
			return "A-";
		else 
			return "A";
	}

}