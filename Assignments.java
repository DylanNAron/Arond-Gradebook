//Dylan Aron
//Creates an assigment
public class Assignments
{
	private String name;
	private double weight;
	private double grade;

	//construct assignment with name and weight grade is initialized to 0
	public Assignments(String n, double w)
	{
		name=n;
		weight=w;
		grade=0;
	}
	//return name
	public String getName()
	{
		return name;
	}
	//return weight
	public double getWeight()
	{
		return weight;
	}
	//return grade
	public double getGrade()
	{
		return grade;
	}
	//update the grade
	public void changeGrade(int num)
	{
		grade = num;
	}
}
