import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalcFrame extends JFrame implements ActionListener,KeyListener
{
 JTextField scr;
 JButton bClr,bAdd,bSub,bMul,bDiv,bEql;
 JButton bDig[];


 String op="";
 int cur,prv;
 
 CalcFrame()
 {
  super("Calculator");
  setSize(300,350);
  setLocation(200,200);
  setResizable(false);
  
  CalcPanel cp=new CalcPanel(10,10,10,10);
  add(cp);

  scr=new JTextField("0");
  scr.setFont(new Font("comic sans ms",Font.ITALIC|Font.BOLD,30));
  scr.setBackground(Color.black);
  scr.setForeground(Color.white);
  scr.setHorizontalAlignment(JTextField.RIGHT);
  scr.setEditable(false);
    
  bClr =new JButton("C");
  bClr.setFont(new Font("lucida console",Font.PLAIN,18));
  bClr.setBackground(new Color(120,60,60));
  bClr.setForeground(Color.white);

  bDig=new JButton[11];
    
  for(int i=0;i<10;i++)
  {
   bDig[i]=new JButton(i+"");
   bDig[i].setFont(new Font("lucida console",Font.PLAIN,18));
   bDig[i].setBackground(new Color(50,100,50));
   bDig[i].setForeground(Color.white);    
  }
  
  bDig[10]=new JButton("00");
  bDig[10].setFont(new Font("lucida console",Font.PLAIN,18));
  bDig[10].setBackground(new Color(50,100,50));
  bDig[10].setForeground(Color.white);    

  bAdd=new JButton("+");
  bAdd.setFont(new Font("lucida console",Font.PLAIN,18));
  bAdd.setBackground(new Color(50,50,100));
  bAdd.setForeground(Color.white);

  bSub=new JButton("-");
  bSub.setFont(new Font("lucida console",Font.PLAIN,18));
  bSub.setBackground(new Color(50,50,100));
  bSub.setForeground(Color.white);

  bMul=new JButton("*");
  bMul.setFont(new Font("lucida console",Font.PLAIN,18));
  bMul.setBackground(new Color(50,50,100));
  bMul.setForeground(Color.white);

  bDiv=new JButton("/");
  bDiv.setFont(new Font("lucida console",Font.PLAIN,18));
  bDiv.setBackground(new Color(50,50,100));
  bDiv.setForeground(Color.white);
  
  bEql=new JButton("=");
  bEql.setFont(new Font("lucida console",Font.PLAIN,18));
  bEql.setBackground(new Color(150,150,50));
  bEql.setForeground(Color.white);

  CalcPanel p1=new CalcPanel(1,1,1,1);
  p1.setLayout(new BorderLayout(10,10));
  p1.add(scr,BorderLayout.CENTER);

  CalcPanel p2=new CalcPanel(1,1,1,1);
  p2.setLayout(new GridLayout(1,4,10,10));
  p2.add(new JLabel());
  p2.add(new JLabel());
  p2.add(new JLabel());
  p2.add(bClr);
  
  CalcPanel p3=new CalcPanel(1,1,1,1);
  p3.setLayout(new GridLayout(1,4,10,10));
  p3.add(bDig[7]);
  p3.add(bDig[8]);
  p3.add(bDig[9]);
  p3.add(bAdd);
    
  CalcPanel p4=new CalcPanel(1,1,1,1);
  p4.setLayout(new GridLayout(1,4,10,10));
  p4.add(bDig[4]);
  p4.add(bDig[5]);
  p4.add(bDig[6]);
  p4.add(bSub);

  CalcPanel p5=new CalcPanel(1,1,1,1);
  p5.setLayout(new GridLayout(1,4,10,10));
  p5.add(bDig[1]);
  p5.add(bDig[2]);
  p5.add(bDig[3]);
  p5.add(bMul);

  CalcPanel p6=new CalcPanel(1,1,1,1);
  p6.setLayout(new GridLayout(1,4,10,10));
  p6.add(bDig[0]);
  p6.add(bDig[10]);
  p6.add(bEql);
  p6.add(bDiv);
 
  cp.setLayout(new GridLayout(6,1,5,10));
  cp.add(p1);
  cp.add(p2);
  cp.add(p3);
  cp.add(p4);
  cp.add(p5);
  cp.add(p6);

  bClr.addActionListener(this);
  bAdd.addActionListener(this);
  bSub.addActionListener(this);
  bMul.addActionListener(this);
  bDiv.addActionListener(this);
  bEql.addActionListener(this); 

  for(JButton b : bDig)
   b.addActionListener(this);

  addKeyListener(this);
  setFocusable(true);

  getRootPane().setDefaultButton(bEql);
 }

 public void keyTyped   (KeyEvent ke){}
 public void keyReleased(KeyEvent ke){}

 public void keyPressed(KeyEvent ke)
 {
  char kc=ke.getKeyChar();

  if(kc>='0'&&kc<='9')
   actionPerformed(new ActionEvent(bDig[kc-48],kc-48,(kc-48)+""));
  else
  if(kc=='+')
   actionPerformed(new ActionEvent(bAdd,10,"+"));
  else  
  if(kc=='-')
   actionPerformed(new ActionEvent(bSub,11,"-"));
  else  
  if(kc=='*')
   actionPerformed(new ActionEvent(bMul,12,"*"));
  else  
  if(kc=='/')
   actionPerformed(new ActionEvent(bDiv,13,"/"));
  else
  if(kc=='=')
   actionPerformed(new ActionEvent(bEql,14,"="));
 }  
 
 public void actionPerformed(ActionEvent ae)
 { 
  if(ae.getSource()==bClr)
  {
   prv=cur=0;
   scr.setText(cur+""); 
  }
  else
  if(ae.getSource()==bAdd)
  {
   evaluate();
   op="+";
  }
  else
  if(ae.getSource()==bSub)
  {
   evaluate();
   op="-";
  }
  else
  if(ae.getSource()==bMul)
  {
   evaluate();
   op="*";
  }
  else
  if(ae.getSource()==bDiv)
  {
   evaluate();
   op="/";
  }
  else
  if(ae.getSource()==bEql)
  {
   evaluate();
   op="=";
  }
  else
  {
   if(op=="=")
   {
    prv=0;
    op="";
   }
   
   if(ae.getSource()==bDig[10])
    cur=cur*100;
   else
    cur=cur*10+Integer.parseInt(((JButton)ae.getSource()).getLabel());   
   scr.setText(cur+"");
  }
 }

 public void evaluate()
 { 
  switch(op)
  {
   case "+": cur=prv+cur;
             break;
   case "-": cur=prv-cur;
             break;
   case "*": cur=prv*cur;
             break;
   case "/": cur=prv/cur;      
             break;
   case "=": cur=prv;
  }
  scr.setText(cur+"");
  prv=cur;
  cur=0;
 }

}


class CalcPanel extends JPanel
{
 int top,left,bottom,right;

 CalcPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }
 
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(new Color(100,100,100));
 }
 
 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }
}

public class Calculator
{
 public static void main(String arg[])
 {
  CalcFrame cf=new CalcFrame();
  cf.setVisible(true);
  cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}