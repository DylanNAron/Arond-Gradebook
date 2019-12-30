//Dylan Aron

//Creates seperate frames for each task

import java.text.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GradebookGUI
{
	//frame 1=number of students
	//frame 2=names of each student (hit submit for the amount of numstudents)
	//frame 3=add assignment names and their weighting
	//frame 4=add grade for each student in each assignment (does every assignment individiually)
	//frame 5=display total grade for each student

	public static JFrame frame = new JFrame("Veracross");
	public static JFrame frame2 = new JFrame("Students: ");
	public static JFrame frame3 = new JFrame("Assignments: ");
	public static JFrame frame4 = new JFrame("Grades For Assignment: ");
	public static JFrame frame5 = new JFrame("Total Grade");
	public static JButton submit  = new JButton("Submit");
	public static JButton submit2  = new JButton("Submit");
	public static JButton submit3  = new JButton("Submit");
	public static JButton submit4  = new JButton("Submit");
	public static JButton done  = new JButton("Done");
	public static JTextField numstud = new JTextField(10);
	public static Gradebook book;
	public static JTextField fName = new JTextField(10);
	public static JTextField lName = new JTextField(10);
	public static JTextField assi = new JTextField(10);
	public static JTextField wei = new JTextField(5);
	public static ArrayList<JTextField> tf = new ArrayList<JTextField>();
	public static JPanel panel4 = new JPanel();
	public static int count=0;
	public static JLabel asignname;


	public static void main(String[] args){


		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null);

		
		JPanel panel = new JPanel();
		JLabel students = new JLabel("How many students?");
		submit.addActionListener(new Action());
		submit.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 24));
		submit2.addActionListener(new Action());
		submit2.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 24));
		submit3.addActionListener(new Action());
		submit3.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 24));
		submit4.addActionListener(new Action());
		submit4.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 24));
		done.addActionListener(new Action());

		frame.add(panel);
		panel.add(students);
		panel.add(numstud);
		panel.add(submit);

		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(600,600);
		frame2.setLocationRelativeTo(null);

		JLabel fLabel = new JLabel("First Name");
		JLabel lLabel = new JLabel("Last Name");
		JPanel panel2 = new JPanel();
		
		
		frame2.add(panel2);
		panel2.add(fLabel);
		panel2.add(fName);
		panel2.add(lLabel);
		panel2.add(lName);
		panel2.add(submit2);


		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setSize(600,600);
		frame3.setLocationRelativeTo(null);


		JLabel ass = new JLabel("Assignment Name");
		JLabel w = new JLabel("Weighting (decimal)");
		JPanel panel3 = new JPanel();
		frame3.add(panel3);
		panel3.add(ass);
		panel3.add(assi);
		panel3.add(w);
		panel3.add(wei);
		panel3.add(submit3);
		panel3.add(done);

		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setSize(600,600);
		frame4.setLocationRelativeTo(null);
		frame4.add(panel4);

		panel.setBackground(Color.YELLOW);
		panel2.setBackground(Color.GREEN);
		panel3.setBackground(Color.RED);
	
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setSize(600,600);
		frame5.setLocationRelativeTo(null);

		frame.setVisible(true);


	}

	private static class Action implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{

				if(e.getSource() == submit){
					String n = numstud.getText();
					int numstuds = Integer.parseInt(n);
					frame.setVisible(false);
					frame2.setVisible(true);
					book = new Gradebook(numstuds);
				}

				else if(e.getSource() == submit2){
					//System.out.println((book.getStuds()).size());
					book.addStudents(fName.getText(), lName.getText());
					if((book.getStuds()).size() == book.getNumstud())
					{
						frame2.setVisible(false);
						frame3.setVisible(true);
					}
				}

				else if(e.getSource() == submit3){
					book.addAssignment(assi.getText(), Double.parseDouble(wei.getText()));
					//System.out.println(book.getAs().size());
				}
				else if(e.getSource() == done){
					for (int i=0; i<(book.getStuds().size()); i++)
					{
						book.getStuds().get(i).fillGradesList(book.getAs());
					}
					frame3.setVisible(false);
					if (count==book.getAs().size())
					{
						System.out.println("No Assignments, Try again");
						return;
						
					}
					JPanel panel4 = new JPanel();
					panel4.setBackground(Color.YELLOW);
					asignname = new JLabel("    *" +book.getAs().get(count).getName()+"*   ");
					panel4.add(asignname);
					for (int i=0; i<((book.getStuds()).size()); i++)
					{
						JLabel a = new JLabel(((book.getStuds()).get(i)).getfName()+((book.getStuds()).get(i)).getlName());
						JTextField b = new JTextField(5);

						panel4.add(a);
						panel4.add(b);
						panel4.add(submit4);
						tf.add(b);
						frame4.add(panel4);
					}
					frame4.setVisible(true);
				}

				else if(e.getSource() == submit4)
				{
					if (count + 1 >= book.getAs().size())
					{
						
						for(int i=0; i<tf.size(); i++)
						{
							book.getStuds().get(i).getAssigns().get(count).changeGrade(Integer.parseInt(tf.get(i).getText()));

						}
						frame4.setVisible(false);
						JPanel panel5 = new JPanel();
						panel5.setBackground(Color.GREEN);
						for (int i=0; i<((book.getStuds()).size()); i++)
						{
							JLabel c = new JLabel(((book.getStuds()).get(i)).getfName()+((book.getStuds()).get(i)).getlName());
							JLabel d = new JLabel(book.getLetter((book.getStuds().get(i))));

							panel5.add(c);
							panel5.add(d);
							frame5.add(panel5);
						}
						frame5.setVisible(true);
					}
					else {
						for(int i=0; i<tf.size(); i++)
						{
							book.getStuds().get(i).getAssigns().get(count).changeGrade(Integer.parseInt(tf.get(i).getText()));

						}
						frame4.setVisible(false);
						frame4.getContentPane().removeAll();

						JPanel panel4 = new JPanel();
						panel4.setBackground(Color.YELLOW);
						count++;
						asignname = new JLabel("    *" +book.getAs().get(count).getName()+"*   ");
						panel4.add(asignname);
						tf = new ArrayList<JTextField>();
						for (int i=0; i<((book.getStuds()).size()); i++)
						{
							JLabel a = new JLabel(((book.getStuds()).get(i)).getfName()+((book.getStuds()).get(i)).getlName());
							JTextField b = new JTextField(5);

							panel4.add(a);
							panel4.add(b);
							panel4.add(submit4);
							tf.add(b);
							frame4.add(panel4);
						}
						frame4.setVisible(true);
					}

					


				}
				

			}
		}	
}