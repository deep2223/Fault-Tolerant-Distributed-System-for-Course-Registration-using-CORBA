package InterFace1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class server3methods{
	 
	 public static HashMap<String, Integer> insefallsubject1 = new HashMap<String, Integer>();   // comp1111 5
	 public static  HashMap<String, Integer> insewintersubject1 = new HashMap<String, Integer>();  //  
	 public static HashMap<String, Integer> insesummersubject1 = new HashMap<String, Integer>();
		
	public static HashMap<String, Integer> insefallsubject = new HashMap<String, Integer>();   // comp1111 5
	public  static HashMap<String, Integer> insewintersubject = new HashMap<String, Integer>();  //  
	public  static HashMap<String, Integer> insesummersubject = new HashMap<String, Integer>();
		
	public  static HashMap<String, String> insefallstudent = new HashMap<String, String>();   //  comps1111  comp1111
	public  static HashMap<String, String> insewinterstudent = new HashMap<String, String>();
	public  static HashMap<String, String> insesummerstudent = new HashMap<String, String>();
		
	public static final ArrayList<String> insefall = new ArrayList<String>();
	public static final ArrayList<String> insewinter = new ArrayList<String>();
	public  static final ArrayList<String> insesummer = new ArrayList<String>();
	static boolean flag3= false;
	public static int count3[]=new int[] {0,0,0};
	public static int count33[]=new int[] {0,0,0};
		public  void default_values3()
		{ 
			insefall.add( "inse1111");
			insefall.add( "inse2222");
			insefall.add( "inse3333");
			insewinter.add( "inse1111");
			insewinter.add( "inse2222");
			insesummer.add( "inse3333");
			
			insefallsubject1.put("inse1111", 5);
			insefallsubject1.put("inse2222", 6);
			insefallsubject1.put("inse3333", 6);
			insewintersubject1.put("inse1111", 7);
			insewintersubject1.put("inse2222", 9);
			insesummersubject1.put("inse3333", 2);
					
			insefallsubject.put("inse1111", 3);
			insefallsubject.put("inse2222", 5);
			insefallsubject.put("inse3333", 6);
			insewintersubject.put("inse1111", 7);
			insewintersubject.put("inse2222", 9);
			insesummersubject.put("inse3333", 2);

			insefallstudent.put("inses11111", "inse1111");
			insefallstudent.put("comps11113", "inse2222");
		//	insewinterstudent.put("inses11111", "inse2222");
				
		}
		
		
			public server3methods()  {
			
			// TODO Auto-generated constructor stub
				if(flag3==false)
				{
					default_values3();
					flag3=true;
				}
			
		}
			
			
			public static synchronized String getHash2(String studentID ,String courseID)
			{
				String hs=null;
				studentID=studentID.trim();
				courseID=courseID.trim();
				System.out.println(studentID + " -- "+courseID );
				
				
				if((insefallstudent.get(studentID+"1"))!=null)
				{
					if((insefallstudent.get(studentID+"1")).equals(courseID))
					{
					hs="fall";
					}
				}
				if((insefallstudent.get(studentID+"2"))!=null)
				{
					if((insefallstudent.get(studentID+"2")).equals(courseID))
					{
					hs="fall";
					}
				}
				 if((insefallstudent.get(studentID+"3"))!=null)
				{
					if((insefallstudent.get(studentID+"3")).equals(courseID))
					{
					hs="fall";
					}
				}
				 if((insewinterstudent.get(studentID+"1"))!=null)
				{
					if((insewinterstudent.get(studentID+"1")).equals(courseID))
					{
					hs="winter";
					}
				}
				 if((insewinterstudent.get(studentID+"2"))!=null)
				{
					if((insewinterstudent.get(studentID+"2")).equals(courseID))
					{
					hs="winter";
					}
				}
				 if((insewinterstudent.get(studentID+"3"))!=null)
				{
					if((insewinterstudent.get(studentID+"3")).equals(courseID))
					{
					hs="winter";
					}
				}
				 if((insesummerstudent.get(studentID+"1"))!=null)
				{
					if((insesummerstudent.get(studentID+"1")).equals(courseID))
					{
					hs="summer";
					}
				}
				 if((insesummerstudent.get(studentID+"2"))!=null)
				{
					if((insesummerstudent.get(studentID+"2")).equals(courseID))
					{
					hs="summer";
					}
				}
				 if((insesummerstudent.get(studentID+"3"))!=null)
				{
					if((insesummerstudent.get(studentID+"3")).equals(courseID))
					{
					hs="summer";
					}
				}
				
				
				
				System.out.println("hs   == "+hs);
				return hs;
			}	
			
			
			
			
	
		public static synchronized String addCourse3(String courseID, String semester,int capa ,String userid )
		{
			// comp1111 fall
			// only his dept course can be add
			// if it already add in that sem
			// put course in compfalladvisor
			// add capacity to compfallsubject1
		 
		
			
			int o=2;
		
				 if(semester.trim().equals("fall"))
				 {
					 if(insefall.contains(courseID))
					 {
						 //return "course "+courseID+" is already added in fall term";
						 o=0;
					 }
					 else
					 {
						 insefall.add(courseID);
						insefallsubject1.put(courseID, capa);
						 insefallsubject.put(courseID, capa);
						 //return "course "+courseID+" added in fall term";
						 o=1;
					 }
				 }else  if(semester.trim().equals("winter"))
				 {
					 if(insewinter.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in winter term";
					 }
					 else
					 {
						 insewinter.add(courseID);
						 insewintersubject1.put(courseID, capa);
						 insewintersubject.put(courseID, capa);
						 o=1;
						 //return "course "+courseID+" added in winter term";
					 }
				 }else  if(semester.trim().equals("summer"))
				 {
					 if(insesummer.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in summer term";
					 }
					 else
					 {
						 insesummer.add(courseID);
						 insesummersubject1.put(courseID, capa);
						insesummersubject.put(courseID, capa);
						 o=1;
						// return "course "+courseID+" added in summer term";
					 }
				 }
				 
			String path = null;	
			if(userid.substring(0, 4).equals("comp"))
			{
				path="comp";
			}
			else if(userid.substring(0, 4).equals("soen"))
			{
				path="soen";
			}else if(userid.substring(0, 4).equals("inse"))
			{
				path="inse";
			}	
		
			File f3 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/"+path+"/"+userid+".txt");
			if( o==0)
			{
	 
				BufferedWriter output2;
				try {
					output2 = new BufferedWriter(new FileWriter(f3,true));
					output2.write(" Request failed , ");
					output2.write("course "+courseID+" is already added in "+semester+" term \n\n");
					output2.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "course "+courseID+" is already added in "+semester+" term";
				
			}
			else if(o==1)
			{
				
				BufferedWriter output2;
				try {
					output2 = new BufferedWriter(new FileWriter(f3,true));
					output2.write(" Request successfully completed , ");
					output2.write("course "+courseID+" added in "+semester+" term\n\n");
					output2.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "course "+courseID+" added in "+semester+" term";
			}
			
			
			return "operation failed";
		}


		
		
		
		//  ------------------------------------------------------------------------------------------------------------------------
		
		
		
		public static Object getKeyFromValue(Map hm, Object value) {
		    for (Object o : hm.keySet()) {
		      if (hm.get(o).equals(value)) {
		        return o;
		      }
		    }
		    return null;
		  }
		
		public static synchronized int removeCourse3(String courseID, String semester )
		{// TODO Auto-generated method stub
				int o = 2;
				// only his dept course can be add
				// if it already add in that sem
				// put course in compfalladvisor
				// add capacity to compfallsubject1
				if((courseID.substring(0, 4)).equals("inse"))
				{
					 if(semester.equals("fall"))
					 {
						 if(!insefall.contains(courseID))
						 {
							 o=0;
							 //return "no such course like "+courseID+" is available in fall term";
						 }
						 else
						 {
							 
							 insefall.remove(courseID);
							 insefallsubject1.remove(courseID);
							 insefallsubject.remove(courseID);
							 while(insefallstudent.containsValue(courseID))
							 {
								
								 String ii = (String) getKeyFromValue(insefallstudent,courseID);
								 insefallstudent.remove(ii);
								
							 }
							
							 o=1;
							 //return "course "+courseID+" is removed in fall term";
						 }
					 }else  if(semester.equals("winter"))
					 {
						 if(!insewinter.contains(courseID))
						 {
							 o=0;
							 // return "no such course like "+courseID+" is available in winter term";
						 }
						 else
						 {
							 insewinter.remove(courseID);
							 insewintersubject1.remove(courseID);
							 insewintersubject.remove(courseID);
							 while(insewinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(insewinterstudent,courseID);
								 insewinterstudent.remove(ii);
							 }
							
							o=1;
							 //return "course "+courseID+" is removed in winter term";
						 }
					 }else  if(semester.equals("summer"))
					 {
						 if(!insesummer.contains(courseID))
						 {
							o=0;
							 // return "no such course like "+courseID+" is available in summer term";
						 }
						 else
						 {
							 insesummer.remove(courseID);
							 insesummersubject1.remove(courseID);
							 insesummersubject.remove(courseID);
							 while(insesummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(insesummerstudent,courseID);
								 insesummerstudent.remove(ii);
							 }
							o=1;
							 // return "course "+courseID+" is removed in summer term";
						 }
					 }
				}
				
				
				else if((courseID.substring(0, 4)).equals("comp") || (courseID.substring(0, 4)).equals("inse"))
				{
					
					if(semester.equals("fall"))
					 {
						
							 while(insefallstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(insefallstudent,courseID);
								 insefallstudent.remove(ii);
							 }
							o=1;
							 // return "course "+courseID+" is removed in fall term";
						 
					 }else  if(semester.equals("winter"))
					 {
							 while(insewinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(insewinterstudent,courseID);
								 insewinterstudent.remove(ii);
							 }
							
							o=1;
							 // return "course "+courseID+" is removed in winter term";
						
					 }else  if(semester.equals("summer"))
					 {
							 while(insesummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(insesummerstudent,courseID);
								 insesummerstudent.remove(ii);
							 }
							
						o=1;
							 //	 return "course "+courseID+" is removed in summer term";
						 }
					 }


				
				
			/*	
				if( o==0)
				{
		          
					
				//	return "no such course like "+courseID+" is available in "+semester+" term";
					
				}
				else if(o==1)
				{
					
					
					return "course "+courseID+" removed in "+semester+" term";
				}
				*/
				
				return o;
  }
		
		
	//  ------------------------------------------------------------------------------------------------------------------------
		
		
		
		
public static synchronized String  listCourseAvailabilityserver3(String semester1){
			
			
			
			if(semester1.trim().equals("fall"))
			{
				String aaa=" "; 
				for(Map.Entry entry:insefallsubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
				//System.out.println(aaa);
				return aaa;
			}
			else if(semester1.trim().equals("winter"))
			{
				String aaa=" "; 

				for(Map.Entry entry:insewintersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}

				return aaa;
			}
			else if(semester1.trim().equals("summer"))
			{
				String aaa=" "; 

				for(Map.Entry entry:insesummersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
	
				return aaa;
			}

		return "operation failed";
		// TODO Auto-generated method stub	
	}
		


//--------- - - - - - - - - ---------------------- ----------------------------- - - - - - - - - -------------------------------------







	public static synchronized String getClassSchedules3(String studentID)
		{
				// TODO Auto-generated method stub
				String tmp,tmpp,tmppp;
				String tmp1="";

					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
							tmp=insefallstudent.get(studentID.trim()+its);
							System.out.print(" "+tmp+" ");
							if(tmp!=null )
							{
								tmp1=tmp1+tmp+" ";
							}
					}
					tmp1=tmp1+"*";
					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
						tmp=insewinterstudent.get(studentID.trim()+its);
				
						if(tmp!=null )
						{
							tmp1=tmp1+tmp+" ";
						}
						
					}
					tmp1=tmp1+"#";
					
					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
						tmp=insesummerstudent.get(studentID.trim()+its);
						if(tmp!=null )
						{
							tmp1=tmp1+tmp+" ";
						}
					}
					tmp1=tmp1+"$";
				return tmp1;	
					
			}
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	public static synchronized int  checkenroll3(String studentID, String courseID)
	{
		int f = 0;
			if(insefallsubject.containsKey(courseID) || insewintersubject.containsKey(courseID)  || insesummersubject.containsKey(courseID) )
			{
				
				
				
				ArrayList<String> arrli = new ArrayList<String>();
								
				String h = studentID;

				for(int i=1;i<=3;i++)
				{
					Integer intInstance = new Integer(i);      
					
					arrli.add( (insefallstudent.get(h+intInstance.toString())));
					arrli.add(insewinterstudent.get(h+intInstance.toString()));
					arrli.add(insesummerstudent.get(h+intInstance.toString()));
				}
				
				for (String str : arrli) {
					
					//System.out.println(str);
					if(courseID.equals(str))
					{
						f=1;
					}	
				}
				arrli.clear();
				
				
			}
			else
			{
				System.out.println("Course is not available in this term");
				//return 1;
				f=0;
				
			}
			return f;
	}
	
	
	
	
	
	
	
	
	
	public static synchronized String dropCourses3(String studentID, String courseID) {
		
		System.out.println(studentID+courseID);
		int flag2 = checkenroll3(studentID, courseID);
		System.out.println(flag2);
		int ck=0;
		
		
		
		if(flag2==1) 
		{
				for(int i=1;i<=3;i++)
				{
					String its = Integer.toString(i);
					if(insefallstudent.get(studentID+its)!=null && (insefallstudent.get(studentID+its)).equals(courseID) )
					{
						insefallstudent.remove(studentID+its);
						//ck=1;
						if(courseID.trim().substring(0, 4).equals("inse"))
						{
						int tt=insefallsubject.get(courseID)+1;
						insefallsubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(insewinterstudent.get(studentID+its)!=null && (insewinterstudent.get(studentID+its)).equals(courseID))
					{
						insewinterstudent.remove(studentID+its);
						if(courseID.trim().substring(0, 4).equals("inse"))
						{
						int tt=insewintersubject.get(courseID)+1;
						insewintersubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(insesummerstudent.get(studentID+its)!=null && (insesummerstudent.get(studentID+its)).equals(courseID))
					{
						insesummerstudent.remove(studentID+its);
						//ck=1;
						if(courseID.trim().substring(0, 4).equals("inse"))
						{
						int tt=insesummersubject.get(courseID)+1;
						insesummersubject.replace(courseID, tt);
						ck=1;
						}
						
					}
				}
				
				if(ck==1)
				{
					return studentID+" is successfully drop in "+courseID;
				}else {
					return studentID+" is not successfully drop in "+courseID;
				}
		}
		else
		{
			return "you are cant not drop  "+courseID;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public static synchronized int checkmaxdep2(String studentID, String  semester,String courseID)
	{
		ArrayList<String> arrli = new ArrayList<String>();
		
		
		count3[0]=count3[1]=count3[2]=0;
		String h = studentID;

		for(int i=1;i<=3;i++)
		{
			Integer intInstance = new Integer(i);      
			
			arrli.add(insefallstudent.get(h+intInstance.toString()));
			arrli.add(insewinterstudent.get(h+intInstance.toString()));
			arrli.add(insesummerstudent.get(h+intInstance.toString()));
	
		}
 
		for (String str : arrli) {
			//System.out.println(str);
			if(str!=null)
			{
				if(str.substring(0,4).equals("comp"))
				{
					++count3[0];
				}
				else if(str.substring(0,4).equals("soen"))
				{
					++count3[1];
				}
				else if(str.substring(0,4).equals("inse"))
				{
					++count3[2];
				}
			}
		}

		System.out.println(count3[0]+" "+count3[1]+" "+count3[2]+"dep");
		arrli.clear();
		String tmp1 = courseID.substring(0, 4);
		System.out.println(tmp1);
	if(studentID.substring(0, 4).equals("inse"))
	{
		if(tmp1.equals("comp"))
		{
			return count3[0];
		}else if(tmp1.equals("soen"))
		{
			return count3[1];
		}else if(tmp1.equals("inse"))
		{
			return count3[2];
		}
	}
	else if(studentID.substring(0, 4).equals("comp") || studentID.substring(0, 4).equals("soen"))
	{
		return count3[2];
	}
		return 9;
		
	}
	
	
	
	public static synchronized int checkmaxterm2(String studentID, String  semester)
	{
		ArrayList<String> arrli = new ArrayList<String>();
		count33[0]=count33[1]=count33[2]=0;
		//int count1[]=new int[] {0,0,0};
		String h = studentID;
		for(int i=1;i<=3;i++)
		{
			 //Integer intInstance = new Integer(i);      
			
			
			arrli.add(insefallstudent.get(h+ Integer.toString(i)));
			
			for (String str : arrli) 
			{
				
				if(str!=null)
				{
					++count33[0];
				}
			}
			 arrli.clear();
			 
			arrli.add(insewinterstudent.get(h+Integer.toString(i)));
			
			for (String str : arrli) 
			{
				if(str!=null)
				{
					++count33[1];
				}
			}
			 arrli.clear();
			
			arrli.add(insesummerstudent.get(h+Integer.toString(i)));
			
		    for (String str : arrli) 
			{
				if(str!=null)
				{
					++count33[2];
				}
			}
			 arrli.clear();
			
		}
		arrli.clear();
		System.out.println(count33[0]+" "+count33[1]+" "+count33[2]+"term");

		System.out.println(semester);
		
		if(semester.trim().equals("fall"))
		{
			return count33[0];
		}
		else if(semester.trim().equals("winter"))
		{
			return count33[1];
		}else if(semester.trim().equals("summer"))
		{
			return count33[2];
		}
		
		return count33[0]+count33[1]+count33[2];
	}
	
	
	
	
	
	
	public static synchronized int checkavailibility2(String courseID, String semester)
	{
		String tmp = courseID.substring(0, 4);	
		
		
			 if(semester.trim().equals("fall"))
			 {
				 int tmp1 = insefallsubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("winter"))
			 {
				 int tmp1 = insewintersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("summer"))
			 {
				 int tmp1 = insesummersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
	
		
	
		
		return 0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static synchronized String enrolCourse3(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
		
		int chk=9;
		int z,vv;
		String v;
		
		boolean v1;
		
		studentID.trim();
		courseID.trim();
		semester.trim();
	//	System.out.println(studentID+courseID+courseID);
		
			int flag1 = checkenroll3(studentID, courseID/*,  semester*/);
			if(flag1==1)
			{
				chk=1;
			}
			else if(flag1==0)
			{
				
			
					int flag2 = checkavailibility2(courseID,  semester);
					System.out.print(flag2);
					
					if(flag2==1)
					{
						if(semester.trim().equals("fall"))
						{
							
							for(int i=1;i<=3;i++)
							{
								String its = Integer.toString(i);
								
									v=insefallstudent.get(studentID+its);
									v1=insefallstudent.containsValue(studentID+its);
									if((v == null) && v1==false )
									{
										 
										insefallstudent.put(studentID+its,courseID);
										
										int hh=insefallsubject.get(courseID);
										hh=hh-1;
										insefallsubject.put(courseID, hh);

										
									
										break ;
									}
							}
							
					}else if(semester.trim().equals("winter"))
					{
						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
							
							
							
								v=insewinterstudent.get(studentID+its);
								v1=insewinterstudent.containsValue(studentID+its);
								if((v == null) && v1==false )
								{
									insewinterstudent.put(studentID+its,courseID);
									
									int hh=insewintersubject.get(courseID);
									hh=hh-1;
									insewintersubject.put(courseID, hh);
									break ;
								}
							
		
						}
					
					}else if(semester.trim().equals("summer"))
					{
						
						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
							
								v=insesummerstudent.get(studentID+its);
								v1=insesummerstudent.containsValue(studentID+its);
								if((v == null) && v1==false )
								{
									insesummerstudent.put(studentID+its,courseID);
									
									int hh=insesummersubject.get(courseID);
									hh=hh-1;
									insesummersubject.put(courseID, hh);
									
									break ;
								}
		
						}
					}
						chk=2;
					}
					else
					{
					//	System.out.print("no space available in this subject in fall term");
						chk=3;
					}	
				
			}
		
		
		
		
	
		
			
		if(chk==1)
		{
			
			return "You already enroll this subject in fall term";
			
		}
		else if(chk==2)
		{
			
			
				return studentID+"is successfully enrolled in "+ courseID;
		}
		else if(chk==3)
		{
			
		return "no space available in this subject in this term";
				}
		else if(chk==4)
		{
		//return studentID+" cant enroll "+courseID+" in" + semester+" term";
			
		return "Max course capacity exceed for "+studentID;
		
		}
		else if(chk==6)
		{
			
			return "error ";
		}
		
		return "sorry ";
	}
	
	
	
	
	
	
	
	
	
	
}







   class sendMessage2 implements Runnable {
	
	   
	   public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/inse/Server3.txt");
		    BufferedWriter output0;
	   
	   Thread t1;
	    int serverPort;
	    String ss1,ss2;
	    String msg,l;
	    String sid,sem,method,courseid;
	    
	   
	   
	    sendMessage2(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	msg=null;
	    	 msg=ss2+":"+ss1+"^";
	    	t1=new Thread(this);
	    	
	    }
	    
 public sendMessage2(int p, String studentID,String courseID, String sem, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	    	this.sem=sem;
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid+"#"+sem+"^";
	    	t1=new Thread(this);
			// TODO Auto-generated constructor stub 
		}
 
 public sendMessage2(int p, String studentID,String courseID, String methd) {
 	
 	serverPort=p;
 	sid=studentID;
 
 	method=methd;
 	courseid=courseID;
 	
 	msg=null;
 	msg=method+":"+sid+"*"+courseid+"^";
 	t1=new Thread(this);
		// TODO Auto-generated constructor stub 
	}
	   
	    public synchronized void run() 
	    {
	    	 DatagramSocket aSocket = null;
			  try {
				  aSocket = new DatagramSocket();
			
				  byte[] message = msg.getBytes();
				  InetAddress aHost = InetAddress.getByName("localhost");
				  DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
				  aSocket.send(request);
				  
				  
				  System.out.println("Request message sent from the client to server with port number " + serverPort + " is: "
					+ new String(request.getData()));
				  
				  
				  try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(", Request message sent from the client to server with port number " + serverPort+" , ");
						output0.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
				  
				  byte[] buffer = new byte[1000];
				  DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				  aSocket.receive(reply);
				  
				  
				  try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(" , Reply received from the server with port number " + serverPort+" , \n\n");
						output0.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				  String tmp = new String(reply.getData());
				  tmp=tmp.trim();
				  System.out.println("INSE : Reply received from the server with port number " + serverPort + " is: "
					+ tmp);
				  
				 
				 String kept = tmp.substring(tmp.indexOf(":")+1,tmp.indexOf("@"));
			  
			   	Server3.getsem3=tmp.substring(0,tmp.indexOf(":"));
			   	
			   	if(kept.trim().equals("methodlist"))
					 {
					//	String output4=null;
						 
						 Server3.output2 += tmp.substring(0,tmp.indexOf(":"));
						 System.out.println( Server3.output2);
					//	 Server1 s1=new Server1();
					//	 s1.listCourseAvailabilitys1get1(output4); 
						 
						 
					 } if(kept.trim().equals("methodenroll"))
					 {
						 Server3.enrol2 = tmp.substring(0,tmp.indexOf(":"));
						 //System.out.println("fff"+Server3.enrol2);
						 
					 } if(kept.trim().equals("methoddrop"))
					 {
						 Server3.drop2 = tmp.substring(0,tmp.indexOf(":"));
					 } if(kept.trim().equals("methodschedule"))
					 {
						 Server3.schedule2 += tmp.substring(0,tmp.length());
					 } if(kept.trim().equals("methoddep"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server3.dep3 +=  Integer.parseInt(ha);
						 
					 }
					  if(kept.trim().equals("methodterm"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server3.term3 +=  Integer.parseInt(ha);
						 
					 }
					  if(kept.trim().equals("methodavail"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server3.avai2 =  Integer.parseInt(ha);
						 
					 }
			   	
			   	  if(kept.trim().equals("methodgetsem"))
					 {
						 Server3.getsem3=tmp.substring(0,tmp.indexOf(":"));
						 System.out.println(Server3.getsem3);
						 System.out.println( "0000000000000000 "+Server3.getsem3);
					 }
					 
				  
				  
			  } catch (Exception e) {
				  System.out.println("Socket: " + e.getMessage());
			  }finally {
				  if (aSocket != null)
					  aSocket.close();
			  }
	     }

		public void start() {
			// TODO Auto-generated method stub
			t1.start ();
			
		}
	     
	     

	    
	 

	
}

 class receive2 implements Runnable {
	 
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/inse/Server3.txt");
	    BufferedWriter output0;
	 
	 
	 Thread t2;
	    int serverPort;
	    receive2()
	    {
	    	//serverPort=p;
	    	t2=new Thread(this);
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
			 try {
				 aSocket = new DatagramSocket(8002);
			
				 String kept2 = null;
				 System.out.println("Server 8002 Started............");
				 while (true) {
					 byte[] buffer = new byte[1000];
					 byte[] message = new byte[1000];
					 DatagramPacket request = new DatagramPacket(buffer, buffer.length);
					 aSocket.receive(request);
					 
					 
					 
					 try {
							output0 = new BufferedWriter(new FileWriter(f0,true));
							Date date1 = new Date();
							output0.write("\n"+sdfs1.format(date1)+" ,request comming from "+request.getAddress()+" port : "+request.getPort());
							output0.close();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					 
					 
					 String msg1= new String(request.getData());
					 msg1=msg1.trim();
					 String kept = msg1.substring( 0, msg1.indexOf(":"));
					 if(kept.equals("methodlist"))
					 {
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
						
						 ImpInterFace imobj = new ImpInterFace(1);
						  kept2=server3methods.listCourseAvailabilityserver3(kept1);
						  kept2=kept2+":methodlist@";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.indexOf("^"));
						 System.out.println("###"+stuid+corid+seme+"###");
						
						 kept2=server3methods.enrolCourse3(stuid,corid,seme);
						// System.out.println("output2----"+kept2);
						 kept2=kept2+":methodenroll@";
						 System.out.println("output2----"+kept2);
						 message  = kept2.getBytes();
						 System.out.println(new String(message));
						 System.out.println(message.length + "=="+kept2.length());
						 
					 }else if(kept.equals("methoddrop"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
				
						 kept2=server3methods.dropCourses3(stuid,corid);
						 
						 kept2=kept2+":methoddrop@";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodschedule"))  
					 {
						 
						 kept2=null;
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
						  kept2=server3methods.getClassSchedules3(kept1);
						  kept2=kept2+":methodschedule@";
						  System.out.println(kept2);
						  message  = kept2.getBytes(); 
					 }else if(kept.equals("methoddep"))
					 {
						 int k;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.indexOf("^"));
						 stuid.trim();  corid.trim(); seme.trim();
						 k=server3methods.checkmaxdep2(stuid, seme,corid);
						 kept2=k+":methoddep@";
						  message  = kept2.getBytes();
					 }
					 else if(kept.equals("methodterm"))
					 {
						 int k;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 stuid.trim();  seme.trim();
						 k=server3methods.checkmaxterm2(stuid, seme);
						 kept2=k+":methodterm@";
						  message  = kept2.getBytes();
					 }else if(kept.equals("methodavail"))
					 {
						 kept2=null;
						 String corid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
					
						 int ava=server3methods.checkavailibility2(corid,seme); 
						 
						 kept2=ava+":methodavail@";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodgetsem"))
					 {
						 System.out.println("gggo");
						 kept2=null;
						 String sid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String cid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 System.out.println(sid + "  "+cid);
						 sid=sid.trim();
						 cid=cid.trim();
						 kept2=server3methods.getHash2(sid, cid);
						 System.out.println("ggg = "+kept2);
						 kept2=kept2+":methodgetsem@";
						 message  = kept2.getBytes();
					 }
					  
					 
					 DatagramPacket reply = new DatagramPacket(message, kept2.length(), request.getAddress(),
						request.getPort());
					 
					 
					 
					 try {
							output0 = new BufferedWriter(new FileWriter(f0,true));
							Date date1 = new Date();
							output0.write(" ,reply sent to "+request.getAddress()+" port : "+request.getPort()+"\n\n");
							output0.close();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					 
					 
					 aSocket.send(reply);
				 }
			 } catch (Exception e) {
				 System.out.println("Socket: " + e.getMessage());
			 } finally {
				 if (aSocket != null)
					 aSocket.close();
			 }
		 
	    }
		public void start() {
			// TODO Auto-generated method stub
			t2.start ();
		}
	
}



//-----------------______________________________------------------------------_________________________


public class Server3 {

	  static String output2,enrol2,drop2,schedule2,getsem3;
	 public static int dep3,term3,avai2;
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/inse/Server3.txt");
	    BufferedWriter output0;
	 
	 
	 public Server3()
	 {
		 output2=" ";
		 enrol2=" ";
		 drop2=" ";
		 schedule2=" ";
		 dep3=0;
		 term3=0;
		 avai2=0;
		 getsem3="";
	 }
	
	 
	 
	 
	 public synchronized String getClassSchedules3(String studentID)
	 {
		 
String list="";
schedule2.trim();
		 String s2=server3methods.getClassSchedules3(studentID);
		 sendMessage2 R2 = new sendMessage2(8000,studentID,"methodschedule"); // methodenroll , methoddrop , methodschedule1 
	      R2.start();
	      sendMessage2 R3 = new sendMessage2(8001,studentID,"methodschedule");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		 
	    
		 list="fall - "+s2.substring(0,s2.indexOf("*"))+" "+schedule2.substring(0, schedule2.indexOf("*"))+" ";   // schedule1
		 int tmp=schedule2.indexOf("*");
		 list=list+schedule2.substring(schedule2.indexOf("@")+1, schedule2.indexOf("*",tmp+1));
		 
		 list=list+"\nwinter - "+s2.substring(s2.indexOf("*")+1,s2.indexOf("#"))+" "+schedule2.substring(schedule2.indexOf("*")+1,schedule2.indexOf("#"))+" ";   // schedule1
		 int one=schedule2.indexOf("*");
		int two=schedule2.indexOf("#");
		 list=list+schedule2.substring(schedule2.indexOf("*",one+1)+1,schedule2.indexOf("#",two+1));
	     
		 list=list+"\nsummer - "+s2.substring(s2.indexOf("#")+1,s2.length()-1)+" "+schedule2.substring(schedule2.indexOf("#")+1,schedule2.indexOf("$"))+" ";   // schedule1
		    int one1=schedule2.indexOf("#");
			int two1=schedule2.indexOf("$");
		 list=list+schedule2.substring(schedule2.indexOf("#",one1+1)+1,schedule2.indexOf("$",two1+1));
		 list.trim();
	     
		 return list;
	 }
	 
	 
	 
	 
	 

	public synchronized String  listCourseAvailabilitys3send(String semester)
	{
		String list="";
		
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server2 (SOEN) & server 1(COMP), ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String s2=server3methods.listCourseAvailabilityserver3(semester);
		
		  sendMessage2 R2 = new sendMessage2(8001,semester,"methodlist"); // methodenroll , methoddrop , methodschedule
	      R2.start();
	      sendMessage2 R3 = new sendMessage2(8000,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
      
	     list=s2+output2;
	      return list;
	} 
	
	
	
	public String enrolCourseserver2(String studentID, String courseID, String semester) {
		

		sendMessage2 R2 = new sendMessage2(8000,studentID,courseID,semester,"methoddep");

		 R2.start();
		sendMessage2 R3 = new sendMessage2(8001,studentID,courseID,semester,"methoddep");

		 R3.start();
		
	      
	      try {
				R2.t1.join();
				R3.t1.join();
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
	      
	      
	      sendMessage2 R4 = new sendMessage2(8000,studentID,semester,"methodterm");
			 R4.start();
			sendMessage2 R5 = new sendMessage2(8001,studentID,semester,"methodterm");
			 R5.start();
			
		      
		      try {
					R4.t1.join();
					R5.t1.join();
				} catch (Exception e) {}
		
		System.out.println(" -> "+dep3+" "+term3);
		int dept=server3methods.checkmaxdep2(studentID, semester, courseID);
		int termt=server3methods.checkmaxterm2(studentID, semester);
		dep3=dep3+dept;
		term3=term3+termt;
		System.out.println("<- "+dept+" "+termt);
		System.out.println("<-> "+dep3+" "+term3);
		
		
		
		if((courseID.substring(0, 4)).equals("inse"))
		{
			if(term3<3)
			{
			int flag2 = server3methods.checkavailibility2(courseID,  semester);
			if(flag2==1)
			{
			String f=server3methods.enrolCourse3(studentID, courseID,semester);
			System.out.println(f);
			   return f;
			}
			else
			{
				 return "no space available in this subject in this term";
			}
			
		}
	  }
		else if((courseID.substring(0, 4)).trim().equals("soen"))
		{
			System.out.println("ggggggggiieieieie");
			if(dep3<2 && term3<3)
			{
			sendMessage2 R0 = new sendMessage2(8001,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
			
		      R0.start();
		      
		      try {
					R0.t1.join(); 
				} catch (Exception e) {		}

			
		      if(Server3.avai2==1)
				 {	
		sendMessage2 R6 = new sendMessage2(8001,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
	   
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server2 (SOEN) , ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		R6.start();
	      
	      try {
				R6.t1.join();
				 return enrol2;
			
			} catch (Exception e) {}
				 }
				 else
					{
						 return "no space available in this subject in this term";
					} 
			}
			else
			{
				return "Max course capacity exceed for "+studentID;
			}
	     
		}else if((courseID.substring(0, 4)).equals("comp"))
		{
			
			if(dep3<2 && term3<3)
			{
			sendMessage2 R0 = new sendMessage2(8000,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
			
		      R0.start();
		      
		      try {
					R0.t1.join(); 
				} catch (Exception e) {		}

			
		      if(Server3.avai2==1)
			     {
	      sendMessage2 R7 = new sendMessage2(8000,studentID,courseID,semester,"methodenroll");
	    
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) , ");
				output0.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      R7.start();
	      
	      try {
				R7.t1.join();
				 return enrol2;
			} catch (Exception e) {}
			     }
				else
				{
					 return "no space available in this subject in this term";
				}
		      }
			else
			{
				return "Max course capacity exceed for "+studentID;
			}
	      
		}
		
		else
		{
			return "Max course capacity exceed for "+studentID;
		}
		return enrol2;
	     
		
	}
	
	
	
	public String dropCourseserver2(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("inse"))
		{
			String drop1=server3methods.dropCourses3(studentID, courseID);
			System.out.println(drop1);
			   return drop1;
		}
		else if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage2 R2 = new sendMessage2(8001,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	    
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server2 (SOEN) , ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		R2.start();
	      
	      try {
	    	
	    	 
				R2.t1.join(); 
			
			      return drop2;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("comp"))
		{
	      sendMessage2 R2 = new sendMessage2(8000,studentID,courseID,"methoddrop");
	      
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server1 (COMP) , ");
				output0.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      R2.start();
	      
	      try {
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop2;
	      
		}
		return drop2;
	     
		
	}
	
//	public synchronized String  listCourseAvailabilitys1get()
//	{ 
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	}
	
	
        public String addCourseserver(String courseID, String semester,int capa ,String userid ) {
		
		String h;
	
		h=server3methods.addCourse3( courseID,  semester, capa , userid );
		System.out.println("gdgdgdgdgdgdgdgdgdgdgdg  "+server3methods.insesummer);
		return h;
}
	
	
        public String removeCourseserver(String courseID, String semester  ) {

        	String h=null;
        	int h1;
        	h1=server3methods.removeCourse3( courseID,  semester );
        	//System.out.println("gdgdgdgdgdgdgdgdgdgdgdg  "+server1methods.compsummer);
        	if(h1==0)
        	{
        		return "no such course like "+courseID+" is available in "+semester+" term";
        	}else if(h1==1)
        	{
        		return "course "+courseID+" is removed in "+semester+" term";
        	}
        	return h;
        	}
	
	
        public String swapCourse3(String studentID,String newCourseID,String oldCourseID)
        {
        	
        	String sem1,drop1,drop2,en3=null;
        	if((newCourseID.substring(0, 4)).equals("inse") && (oldCourseID.substring(0, 4)).equals("inse"))
        	{
        		 sem1= server3methods.getHash2(studentID, oldCourseID);
        		 drop1=server3methods.dropCourses3(studentID, oldCourseID);
        		 en3= server3methods.enrolCourse3(studentID, newCourseID, sem1);
        		if(!(en3.equals(studentID+"is successfully enrolled in "+ newCourseID)))
        		{
        			 en3= server1methods.enrolCourse1(studentID, oldCourseID, sem1);
        		}
        		System.out.println(drop1);
        		   return en3;
        	}else if((newCourseID.substring(0, 4))!="inse" && (oldCourseID.substring(0, 4)).equals("inse"))
        	{
        		 
        		 sem1= server3methods.getHash2(studentID, oldCourseID);
        		 drop1=server3methods.dropCourses3(studentID, oldCourseID);
        		 en3= enrolCourseserver2(studentID, newCourseID, sem1);
        		 en3=en3.trim();
        		 if(!(en3.equals(studentID+"is successfully enrolled in "+ newCourseID)))
        			{
        				 en3= server2methods.enrolCourse2(studentID, oldCourseID, sem1);
        			}
        			System.out.println(drop1);
        			   return en3;
        	}else if((oldCourseID.substring(0, 4))!="inse" && (newCourseID.substring(0, 4)).equals("inse"))
        	{
        		drop2=oldCourseID;
        		if((oldCourseID.substring(0, 4)).equals("comp"))
        		{
        		sendMessage2 R22 = new sendMessage2(8000,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
        		R22.start();
        	      try {
        				R22.t1.join(); 
        			} catch (Exception e) {	}
        		}else if((oldCourseID.substring(0, 4)).equals("soen"))
        		{
        			sendMessage2 R22 = new sendMessage2(8001,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
        			R22.start();
        		      try {
        					R22.t1.join(); 
        			
        		      } catch (Exception e) {	}
        		}
        		sem1=getsem3;
        		 System.out.println("ssss333 "+Server3.getsem3);
        		System.out.println("sem 1 : "+sem1);
        		drop1=dropCourseserver2(studentID,oldCourseID);
        		if((drop1.equals(studentID+" is successfully drop in "+oldCourseID)))
        		{
        			System.out.println("7777777");
        			 en3= server3methods.enrolCourse3(studentID, newCourseID, sem1);
        		}
        		System.out.println(en3);
        		en3=en3.trim();
        		if(!(en3.equals(studentID+"is successfully enrolled in "+ newCourseID)))
        		{
        			 en3= enrolCourseserver2(studentID, oldCourseID, sem1);
        		}
        		return en3;
        	}else if((oldCourseID.substring(0, 4))!="inse" && (newCourseID.substring(0, 4))!="inse")
        	{
        		
        		if((oldCourseID.substring(0, 4)).equals("comp"))
        		{
        			sendMessage2 R42 = new sendMessage2(8000,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
        			R42.start();
        		      try {
        					R42.t1.join(); 
        				} catch (Exception e) {	}
        		}else if((oldCourseID.substring(0, 4)).equals("soen"))
        		{
        			sendMessage2 R42 = new sendMessage2(8001,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
        			R42.start();
        		      try {
        					R42.t1.join(); 
        				} catch (Exception e) {	}
        			
        		}
        			System.out.println("gettt sem = "+getsem3);
        		        sem1=getsem3.trim();
        		        
        				drop1=dropCourseserver2(studentID,oldCourseID);
        				
        				 en3= enrolCourseserver2(studentID, newCourseID, sem1);
        				
        				en3=en3.trim();
        				if(!(en3.equals(studentID+"is successfully enrolled in "+ newCourseID)))
        				{
        					 en3= enrolCourseserver2(studentID, oldCourseID, sem1);
        				}
        				return en3;	
        	}
        	return en3;
        	
        }
	
	
	public static void main(String args[]) throws Exception{
	
		
		
		server3methods s3 = new server3methods();
		 receive2 R1 = new receive2();
	      R1.start();
	      
		ORB orb = ORB.init(args, null);
		 try{
		      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
		           
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();
		 
		      // create servant and register it with the ORB
		      ImpInterFace obj3 = new ImpInterFace();
		     // obj1.setORB(orb); 
		 
		      // get object reference from the servant
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj3);
		      InterFace2 href = InterFace2Helper.narrow(ref);
		 
		      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		 
		      NameComponent path[] = ncRef.to_name( "INSE" );
		      ncRef.rebind(path, href);
		 
		      System.out.println("INSE Server ready and waiting ...");
		 
		      // wait for invocations from clients
		    
			  orb.run();
			 
		    } 
		 
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		      }
		 
		      System.out.println("INSE Server Exiting ...");
			  
		         
		
	}

		
			  
		     
		
	}

 



