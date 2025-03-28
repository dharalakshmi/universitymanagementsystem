package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
      Project(){
         setSize(1540,850);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/university.jpeg"));
           Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
            add(image);
            
        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
       
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New student Information");
        studentInfo.setBackground(Color.WHITE);
         studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        JMenu details = new JMenu("view detalis");
        details.setBackground(Color.RED);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
         facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View student details");
        studentdetails.setBackground(Color.WHITE);
         studentdetails.addActionListener(this);
        details.add(studentdetails);
        
         JMenu leave = new JMenu("Apply Leave");
        leave.setBackground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
         facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave .addActionListener(this);
        leave.add(studentleave);
        
        JMenu leaveDetails = new JMenu(" Leave Details");
        leaveDetails.setBackground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);
        
  JMenuItem studentleaveDetails = new JMenuItem("student Leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);
        
        JMenu exam = new JMenu("Examination");
        exam.setBackground(Color.BLUE);
        mb.add( exam );
        
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        JMenu UpdateInfo = new JMenu("Update Details");
         UpdateInfo.setBackground(Color.RED);
        mb.add( UpdateInfo );
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
         updatefacultyinfo.addActionListener(this);
         UpdateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
           updatestudentinfo.addActionListener(this);
          UpdateInfo.add(updatestudentinfo);
          
          JMenu fee = new JMenu("Fee Details");
         fee.setBackground(Color.BLUE);
        mb.add( fee );
 JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
         fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
          fee .add(feeform);
          
           JMenu utility = new JMenu("Utility");
         utility.setBackground(Color.RED);
        mb.add( utility );
        
        JMenuItem notepad = new JMenuItem("Notepad");
          notepad.setBackground(Color.WHITE);
          notepad.addActionListener(this);
           utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
         calc.addActionListener(this);
            utility .add(calc);
            
            
         
             JMenu exit = new JMenu("Exit");
         exit.setBackground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
          ex.setBackground(Color.WHITE);
          ex.addActionListener(this);
           exit.add(ex);
        
setJMenuBar(mb);       
          setVisible(true);
}
     @Override
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
              Runtime.getRuntime().exec("calc.exe");
                
            
            }catch(Exception e){
                
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
                
            }
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }else if(msg.equals("View student details")){
            new StudentDetails();
        }else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
            
    }
    
    public static void main(String args[]){
        // TODO code application logic here
        new Project();
}
}