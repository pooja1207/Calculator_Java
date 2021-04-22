import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class EvalFrame extends JFrame implements ActionListener
{
 JTextField tLft,tRyt;
 JButton  bAdd,bSub,bMul;
 
 EvalFrame()
 {
  super("JIET Assignment 3 - Evaluate  (pooja bhather)");
  setSize(500,270);
  setLocation(300,200);   
  setResizable(false);

  EvalPanel mp=new EvalPanel(25,10,10,10);
  add(mp);

  JLabel l1=new JLabel("Left Hand Operand");
  l1.setFont(new Font("lucida console",Font.PLAIN,18));
  l1.setForeground(Color.white);

  JLabel l2=new JLabel("Right Hand Operand");
  l2.setFont(new Font("lucida console",Font.PLAIN,18));
  l2.setForeground(Color.white);
  
  tLft=new JTextField();
  tLft.setFont(new Font("lucida console",Font.PLAIN,18));

  tRyt=new JTextField();
  tRyt.setFont(new Font("lucida console",Font.PLAIN,18));
  
  bAdd=new JButton("+");
  bAdd.setFont(new Font("lucida console",Font.PLAIN,22));
  bAdd.setForeground(Color.white);
  bAdd.setBackground(new Color(100,50,50));

  bSub=new JButton("-");
  bSub.setFont(new Font("lucida console",Font.PLAIN,22));
  bSub.setForeground(Color.white);
  bSub.setBackground(new Color(50,100,50));

  bMul=new JButton("x");
  bMul.setFont(new Font("lucida console",Font.PLAIN,22));
  bMul.setForeground(Color.white);
  bMul.setBackground(new Color(50,50,100));

  mp.setLayout(new GridLayout(4,1,5,5));  

  EvalPanel p1=new EvalPanel(4,1,4,1);
  p1.setLayout(new BorderLayout(21,10));
  p1.add(l1,BorderLayout.WEST);
  p1.add(tLft,BorderLayout.CENTER);

  EvalPanel p2=new EvalPanel(4,1,4,1);
  p2.setLayout(new BorderLayout(10,10));
  p2.add(l2,BorderLayout.WEST);
  p2.add(tRyt,BorderLayout.CENTER);

  EvalPanel p3=new EvalPanel(1,1,1,1);
  p3.setLayout(new GridLayout(1,3,10,5));
  p3.add(bAdd);
  p3.add(bSub);
  p3.add(bMul);

  mp.add(p1);
  mp.add(p2);
  mp.add(new JLabel());
  mp.add(p3);  

  bAdd.addActionListener(this);
  bSub.addActionListener(this);
  bMul.addActionListener(this);
 } 

 public void actionPerformed(ActionEvent ae)
 {
  int lft,ryt;

  try
  {
   lft=Integer.parseInt(tLft.getText());
  }
  catch(NumberFormatException e)
  {
   Toolkit.getDefaultToolkit().beep();
   tLft.select(0,tLft.getText().length());
   tLft.requestFocus();
   return;  
  }

  try
  {
   ryt=Integer.parseInt(tRyt.getText());      
  }
  catch(NumberFormatException e)
  {
   Toolkit.getDefaultToolkit().beep();
   tRyt.select(0,tRyt.getText().length());
   tRyt.requestFocus();
   return;  
  }

  if(ae.getSource()==bAdd)
  {
   lft=lft+ryt;
  }
  else
  if(ae.getSource()==bSub)
  {
   lft=lft-ryt;
  }
  else
  if(ae.getSource()==bMul)
  {
   lft=lft*ryt;
  }

  JOptionPane.showMessageDialog(this,"Result : "+lft);
 }
}

class EvalPanel extends JPanel
{
 private int top,left,bottom,right;

 EvalPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(new Color(70,70,70));  
 }

 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }
}


public class Evaluate
{
 public static void main(String arg[])
 {
  EvalFrame ef=new EvalFrame();
  ef.setVisible(true);
  ef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}