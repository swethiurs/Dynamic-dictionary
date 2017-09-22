import java.util.Hashtable;
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.io.DataOutputStream;
public class datamining extends Applet implements ActionListener 
{
        Label heading,labl1,labl2,labl3;
        Button go,refresh;
	TextField text1;
        TextField text;
        TextArea txt=new TextArea(10,50);
	public void init()
	{
        heading = new Label("Dictionary",Label.CENTER);
       heading.setAlignment(Label.CENTER);
	labl1= new Label("Enter the word : ");
        labl2=new Label("Result:");
        labl3=new Label("Enter word and its meaning with a colon inbetween them :");
	text1= new TextField( 30 );
        text=new TextField(30);
        go=new Button("Search");
        refresh=new Button("Refresh");                      
                                 add( heading );



          add( labl1 );      add( text1);
          
          add(go);

          System.out.println("*");

          go.addActionListener(this);
          
          add( labl2 );

          add(txt);
          
          add(labl3);   add(text);
          
          add(refresh);
             
          refresh.addActionListener(this);
       System.out.println("**");
	}

       public void actionPerformed( ActionEvent e )
	{
          try
           {
          if(e.getSource()==go)
           {
         Hashtable<String,Integer> h=new Hashtable<String,Integer>();
         int k=1;
         char ch='a';
         h.put("a",1);
         BufferedReader reader1=new BufferedReader(new FileReader("dict.txt"));
         String data1="";
         int c3=(int)ch+1;
         ch=(char)c3;
         System.out.println("***");
         while(data1!=null)
           {
                data1=reader1.readLine();
                if(data1!=null)
                {
                char s2=data1.charAt(0);
                k++;
                if(s2==ch)
                 {
                     h.put(Character.toString(ch),k);
                     c3=(int)ch+1;
                     ch=(char)c3;

                  }
            }
           }
          System.out.println("****");
               int i,found=0,index2;
               String word= text1.getText();
               char s1=word.charAt(0);
               System.out.println(s1);
               StringBuffer strContent = new StringBuffer("");
               int index1=(int)h.get(Character.toString(s1));
               if(s1=='z')
                {
                  System.out.println("if");
                 String dat="";
                 BufferedReader reader=new BufferedReader(new FileReader("dict.txt"));
               for(i=1;dat!=null;i++)
               {
                 dat=reader.readLine();
               }

                 index2= i ;
                   index2++;
                }
               else
                {
              System.out.println("else");
               int s2=(int)s1+1;
               index2=(int)h.get(Character.toString((char)s2));
                }
               System.out.println("*****");
               BufferedReader reader=new BufferedReader(new FileReader("dict.txt"));
               for(i=1;i<index1;i++)
               {
                 reader.readLine();
               }
                i--;
               String data="";
               for(int j=i;j<(index2-1)&&data!=null;j++)
                 {
                    data=reader.readLine();
                    strContent.append(data + "\n");  
                 }
               String a[] = strContent.toString().split("\n");
               int len=a.length;
               for(int j=0;j<len;j++)
                 {
                     String b[]=a[j].split(":");
                      if(b[0].equals(word))
                        {
                            txt.setText("\n The word was found!! \n");
                            txt.setText(a[j]);
                           System.out.println("\n The word was found!! ");
                           System.out.println(a[j]);
                           found=-1;
                         }
                  }
                 if(found==0)
                 {
                   reader.close();
                   txt.setText("\n The word is not found in dict,it will be added,please provide us with the word and  meaning in the textbox below :");
               
               reader.close();
              }
            }
            if(e.getSource()==refresh)
                {
                 
                      String word1=text.getText();
                   if(text.getText()==null)
                    {
                        System.out.println("lllll");
                    }
                         

                      BufferedReader reader3=new BufferedReader(new FileReader("dict.txt"));
                      ArrayList<String> lines = new ArrayList<String>();
                      String da=" ";
                      while (da!=null) 
                               {
                              da=reader3.readLine();
                              if(da!=null)
                                {
                            lines.add(da);
                              // replace above line with array
                              }
                                   }
                      lines.add(word1);
                      String[] lineArray = new String[lines.size()];
                      lines.toArray(lineArray);
                        System.out.println("%%%");
                       System.out.println("before sorting");
                        Arrays.sort(lineArray);
                       File file=new File("dict.txt");
                       PrintWriter out=new PrintWriter(new FileWriter(file));
                        for(String s:lineArray)
                         {
                             out.println(s);
                         }
                       out.close();
                  }
                      
          } catch(FileNotFoundException e1)
             {
                  System.out.println("The File doesnt exist!! Sorry !");
             }
           catch(IOException e2)
             {
                  System.out.println(" Input/output Error occured ");
             }
           catch(NullPointerException e3)
            {
                System.out.println(" Null pointer exception is generated ");
            }
      }
  }

 // <applet code=datamining height=700 width=700> </applet>
