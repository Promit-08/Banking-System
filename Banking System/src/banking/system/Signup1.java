package banking.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class Signup1 extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, MnameTextField, emailTextField, addressTextField, cityTextField, nationalTextField,pinTextField;
    JButton next;
    JDateChooser datechooser ;
    JRadioButton male,female,married,unmarried,other;
    Signup1(){
    
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      
      setSize(850, 800);
      setLocation(350, 10);
      setVisible(true);
      setTitle("BANK ACCOUNT REGISTRATION FORM - PAGE 1");
      
      Random ran = new Random();
      random = Math.abs((ran.nextLong() % 9000L) + 1000L);
      
      JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
      formno.setFont(new Font("Raleway",Font.BOLD, 38));
      formno.setBounds(140, 20, 600, 40);
      add(formno);
      
      JLabel personsDetails = new JLabel("Page 1: Personal Details");
      personsDetails.setFont(new Font("Raleway",Font.BOLD, 22));
      personsDetails.setBounds(290, 80, 400, 30);
      add(personsDetails);
      
      JLabel name = new JLabel("Name:");
      name.setFont(new Font("Raleway",Font.BOLD, 18));
      name.setBounds(100, 140, 100, 30);
      add(name);
      
      nameTextField = new JTextField();
      nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
      nameTextField.setBounds(300, 140, 400, 22);
      add(nameTextField);
      
      
      JLabel fname = new JLabel("Father's Name:");
      fname.setFont(new Font("Raleway",Font.BOLD, 18));
      fname.setBounds(100, 190, 200, 30);
      add(fname);
      
      fnameTextField = new JTextField();
      fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
      fnameTextField.setBounds(300, 190, 400, 22);
      add(fnameTextField);
      
      JLabel Mname = new JLabel("Mother's Name:");
      Mname.setFont(new Font("Raleway",Font.BOLD, 18));
      Mname.setBounds(100, 240, 200, 30);
      add(Mname);
      
      MnameTextField = new JTextField();
      MnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
      MnameTextField.setBounds(300, 240, 400, 22);
      add(MnameTextField);
      
      JLabel dob = new JLabel("Date of Birth:");
      dob.setFont(new Font("Raleway",Font.BOLD, 18));
      dob.setBounds(100, 290, 200, 30);
      add(dob);
      
      datechooser = new JDateChooser();
      datechooser.setBounds(300, 290, 400, 22);
      add(datechooser);
      
      JLabel gender = new JLabel("Gender:");
      gender.setFont(new Font("Raleway",Font.BOLD, 18));
      gender.setBounds(100, 340, 200, 30);
      add(gender);
      
      male = new JRadioButton("Male");
      male.setFont(new Font("Raleway",Font.PLAIN, 16));
      male.setBounds(300, 340, 120, 30);
      male.setBackground(Color.WHITE);
      add(male);
      
      female = new JRadioButton("Female");
      female.setFont(new Font("Raleway",Font.PLAIN, 16));
      female.setBounds(450, 340, 120, 30);
      female.setBackground(Color.WHITE);
      add(female);
      
      ButtonGroup gendergroup = new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);
      
      
      JLabel email = new JLabel("E-mail:");
      email.setFont(new Font("Raleway",Font.BOLD, 18));
      email.setBounds(100, 390, 200, 30);
      add(email);
      
      emailTextField = new JTextField();
      emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
      emailTextField.setBounds(300, 390, 400, 22);
      add(emailTextField);
      
      JLabel marital = new JLabel("Marital Status:");
      marital.setFont(new Font("Raleway",Font.BOLD, 18));
      marital.setBounds(100, 440, 200, 30);
      add(marital);
      
      married = new JRadioButton("Married");
      married.setFont(new Font("Raleway",Font.PLAIN, 16));
      married.setBounds(300, 440, 100, 30);
      married.setBackground(Color.WHITE);
      add(married);
      
      unmarried = new JRadioButton("Unmarried");
      unmarried.setFont(new Font("Raleway",Font.PLAIN, 16));
      unmarried.setBounds(450, 440, 100, 30);
      unmarried.setBackground(Color.WHITE);
      add(unmarried);
      
      other = new JRadioButton("Other");
      other.setFont(new Font("Raleway",Font.PLAIN, 16));
      other.setBounds(630, 440, 100, 30);
      other.setBackground(Color.WHITE);
      add(other);
      
      ButtonGroup marritalgroup = new ButtonGroup();
      marritalgroup.add(married);
      marritalgroup.add(unmarried);
      marritalgroup.add(other);
      
      JLabel address = new JLabel("Address:");
      address.setFont(new Font("Raleway",Font.BOLD, 18));
      address.setBounds(100, 490, 200, 30);
      add(address);
      
      addressTextField = new JTextField();
      addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
      addressTextField.setBounds(300, 490, 400, 22);
      add(addressTextField);
     
      JLabel city = new JLabel("City:");
      city.setFont(new Font("Raleway",Font.BOLD, 18));
      city.setBounds(100, 540, 200, 30);
      add(city);
      
      cityTextField = new JTextField();
      cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
      cityTextField.setBounds(300, 540, 400, 22);
      add(cityTextField);
     
      JLabel national = new JLabel("Nationality:");
      national.setFont(new Font("Raleway",Font.BOLD, 18));
      national.setBounds(100, 590, 200, 30);
      add(national);
      
      nationalTextField = new JTextField();
      nationalTextField.setFont(new Font("Raleway",Font.BOLD,14));
      nationalTextField.setBounds(300, 590, 400, 22);
      add(nationalTextField);
     
     
      
      JLabel pincode = new JLabel("Postal Code:");
      pincode.setFont(new Font("Raleway",Font.BOLD, 18));
      pincode.setBounds(100, 640, 200, 30);
      add(pincode);
      
      pinTextField = new JTextField();
      pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
      pinTextField.setBounds(300, 640, 400, 22);
      add(pinTextField);
      
      next =  new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway",Font.BOLD, 14));
      next.setBounds(620, 670, 70, 30);
      next.addActionListener(this);
      add(next);
    }
        
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String Mname = MnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String nation = nationalTextField.getText();
        String pin = pinTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        } else if(other.isSelected()){
            marital = "Other";
        } 
        
        try{
            if(name.equals("") || fname.equals("") || Mname.equals("") || dob.equals("") ||
       gender == null || email.equals("") || marital == null || address.equals("") ||
       city.equals("") || nation.equals("") || pin.equals("")) {
        JOptionPane.showMessageDialog(null, "Information Required: All fields must be filled out.");
            }

          else {
              conn c = new conn();
              String query = "Insert into Signup1 values('"+formno+"','"+name+"','"+fname+"','"+Mname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+nation+"','"+pin+"')";
              c.s.executeUpdate(query);
              
              setVisible(false);
              new Signup2(formno).setVisible(true);
          }
       }  catch(Exception e){
           System.out.println(e);
        }   
    }
     
    public static void main(String args[]){
    
        new Signup1();
    
    }
}
