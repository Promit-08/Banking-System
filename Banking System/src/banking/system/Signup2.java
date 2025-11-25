
package banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener  {
    
    JTextField nidtextfield;
    JComboBox occupation, income,education, category, religion;
    JRadioButton exisY, exisN;
    JButton next;
    String formno;
    
    Signup2(String formno){
      
      this.formno = formno;
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      
      setSize(850, 800);
      setLocation(350, 10);
      setVisible(true);
      
      setTitle("BANK ACCOUNT REGISTRATION FORM - PAGE 2");
      
          
      JLabel additionalDetails = new JLabel("Page 2: Additional Details");
      additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
      additionalDetails.setBounds(290, 80, 400, 30);
      add(additionalDetails);
      
      JLabel religionname = new JLabel("Religion:");
      religionname.setFont(new Font("Raleway",Font.BOLD, 22));
      religionname.setBounds(100, 140, 100, 30);
      add(religionname);
      
      String valuereligion[] = {"Muslim","Hindu","Christian","Other"};
      religion = new JComboBox(valuereligion);
      religion.setBounds(300, 140, 400, 30);
      religion.setBackground(Color.WHITE);
      add(religion);
      
      JLabel catagory = new JLabel("Category:");
      catagory.setFont(new Font("Raleway",Font.BOLD, 22));
      catagory.setBounds(100, 190, 200, 30);
      add(catagory);
      
      String valuecategory[] = {"General","OBC","ST","Other"};
      category = new JComboBox(valuecategory);
      category.setBounds(300, 190, 400, 30);
      category.setBackground(Color.WHITE);
      add(category);
      
      JLabel Income = new JLabel("Income:");
      Income.setFont(new Font("Raleway",Font.BOLD, 22));
      Income.setBounds(100, 240, 200, 30);
      add(Income);
      
      String valueincome[] = {"None","<1,50,000","<2,50,000","5,00,000","Up to 10,00,000"};
      income = new JComboBox(valueincome);
      income.setBounds(300, 240, 400, 30);
      income.setBackground(Color.WHITE);
      add(income);
      
      JLabel edu = new JLabel("Educational");
      edu.setFont(new Font("Raleway",Font.BOLD, 22));
      edu.setBounds(100, 290, 200, 30);
      add(edu);
      JLabel quali = new JLabel("Qualification:");
      quali.setFont(new Font("Raleway",Font.BOLD, 22));
      quali.setBounds(100, 315, 200, 30);
      add(quali);
      
      String educationvalue[] = {"None","SSC","HSC","Bachelor Degree (Honours)","Master Degree","Diploma","Doctoral Degree (PhD)"};
      education = new JComboBox(educationvalue);
      education.setBounds(300, 315, 400, 30);
      education.setBackground(Color.WHITE);
      add(education);
      
      JTextField eduquali = new JTextField();
      eduquali.setBounds(300, 315, 400, 30);
      add(eduquali);
      
      JLabel occup = new JLabel("Occupation:");
      occup.setFont(new Font("Raleway",Font.BOLD, 22));
      occup.setBounds(100, 390, 200, 30);
      add(occup);
      
      String occupationvalue[] = {"None","Non-government Job","Government Job","Business","Student","Retried","Others"};
      occupation = new JComboBox(occupationvalue);
      occupation.setBounds(300, 390, 400, 30);
      occupation.setBackground(Color.WHITE);
      add(occupation);
      
      JLabel nidnum = new JLabel("NID number:");
      nidnum.setFont(new Font("Raleway",Font.BOLD, 22));
      nidnum.setBounds(100, 440, 200, 30);
      add(nidnum);
      
      nidtextfield = new JTextField();
      nidtextfield.setFont(new Font("Raleway",Font.BOLD,14));
      nidtextfield.setBounds(300, 440, 400, 30);
      add(nidtextfield);
          
      JLabel exacc = new JLabel("Existing Account:");
      exacc.setFont(new Font("Raleway",Font.BOLD, 22));
      exacc.setBounds(100, 490, 200, 30);
      add(exacc);
      
      exisY = new JRadioButton("YES");
      exisY.setFont(new Font("Raleway",Font.PLAIN, 14));
      exisY.setBounds(300, 490, 120, 30);
      exisY.setBackground(Color.WHITE);
      add(exisY);
      
      exisN = new JRadioButton("NO");
      exisN.setFont(new Font("Raleway",Font.PLAIN, 14));
      exisN.setBounds(450, 490, 120, 30);
      exisN.setBackground(Color.WHITE);
      add(exisN);
      
      ButtonGroup exisgroup = new ButtonGroup();
      exisgroup.add(exisY);
      exisgroup.add(exisN);
      
      next =  new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway",Font.BOLD, 14));
      next.setBounds(620, 550, 80, 30);
      next.addActionListener(this);
      add(next);
    }
        
    public void actionPerformed(ActionEvent ae){
        
        
        String relig = (String) religion.getSelectedItem();
        String categ = (String) category.getSelectedItem();
        String inc = (String) income.getSelectedItem();
        String edu = (String) education.getSelectedItem();
        String occu = (String) occupation.getSelectedItem();
        String nid = nidtextfield.getText();
        String exacc = null;
        if(exisY.isSelected()){
            exacc = "YES";
        } else if(exisN.isSelected()){
            exacc = "NO";
        } 
   
        try{
              conn c = new conn();
              String query = "Insert into Signup2 values('"+formno+"','"+relig+"','"+categ+"','"+inc+"','"+edu+"','"+occu+"','"+nid+"','"+exacc+"')";
              c.s.executeUpdate(query);
              
              setVisible(false);
              new Signup3(formno).setVisible(true);
          
       }  catch(Exception e){
           System.out.println(e);
        }   
    }

    public static void main(String args[]){
    
        new Signup2("");
    
    }
}
