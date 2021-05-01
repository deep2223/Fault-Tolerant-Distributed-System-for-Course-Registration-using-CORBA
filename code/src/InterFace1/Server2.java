package InterFace1;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



class server2methods{
	 
	 public static HashMap<String, Integer> soenfallsubject1 = new HashMap<String, Integer>();   // comp1111 5
	 public static  HashMap<String, Integer> soenwintersubject1 = new HashMap<String, Integer>();  //  
	 public static HashMap<String, Integer> soensummersubject1 = new HashMap<String, Integer>();
		
	public static HashMap<String, Integer> soenfallsubject = new HashMap<String, Integer>();   // comp1111 5
	public  static HashMap<String, Integer> soenwintersubject = new HashMap<String, Integer>();  //  
	public  static HashMap<String, Integer> soensummersubject = new HashMap<String, Integer>();
		
	public  static HashMap<String, String> soenfallstudent = new HashMap<String, String>();   //  comps1111  comp1111
	public  static HashMap<String, String> soenwinterstudent = new HashMap<String, String>();
	public  static HashMap<String, String> soensummerstudent = new HashMap<String, String>();
		
	public static final ArrayList<String> soenfall = new ArrayList<String>();
	public static final ArrayList<String> soenwinter = new ArrayList<String>();
	public  static final ArrayList<String> soensummer = new ArrayList<String>();
	static boolean flag2= false;
	public static int count2[]=new int[] {0,0,0};
	public static int count22[]=new int[] {0,0,0};
		public  void default_values2()
		{
		
			soenfall.add( "soen1111");
			soenfall.add( "soen2222");
			soenfall.add( "soen3333");
			soenwinter.add( "soen1111");
			soenwinter.add( "soen2222");
			soensummer.add( "soen3333");
			
			soenfallsubject1.put("soen1111", 5);
			soenfallsubject1.put("soen2222", 6);
			soenfallsubject1.put("soen3333", 6);
			soenwintersubject1.put("soen1111", 7);
			soenwintersubject1.put("soen2222", 9);
			soensummersubject1.put("soen3333", 2);
					
			soenfallsubject.put("soen1111", 3);    // 5-2   
			soenfallsubject.put("soen2222", 5);   // 6-1
			soenfallsubject.put("soen3333", 6);
			soenwintersubject.put("soen1111", 7);
			soenwintersubject.put("soen2222", 9);
			soensummersubject.put("soen3333", 2);

			soenfallstudent.put("soens11111", "soen1111");
			soenwinterstudent.put("inses11111", "soen2222");
				
		}
		 
		
		
			public server2methods()  {
			
			// TODO Auto-generated constructor stub
				if(flag2==false)
				{
					default_values2();
					flag2=true;
				}
			
			}
		
			
		/*	public static synchronized String getHash1(String studentID ,String courseID)
			{
				String hs=null;
				if(soenfallstudent.get(studentID+"1").equals(courseID) || soenfallstudent.get(studentID+"2").equals(courseID)||soenfallstudent.get(studentID+"3").equals(courseID) )
				{
					hs="fall";
				}else if(soenwinterstudent.get(studentID+"1").equals(courseID) || soenwinterstudent.get(studentID+"2").equals(courseID)||soenwinterstudent.get(studentID+"3").equals(courseID) )
				{
					hs="winter";
				}else if(soensummerstudent.get(studentID+"1").equals(courseID) || soensummerstudent.get(studentID+"2").equals(courseID)||soensummerstudent.get(studentID+"3").equals(courseID) )
				{
					hs="summer";
				}
				return hs;
			}
			*/
			
			
			public static synchronized String getHash1(String studentID ,String courseID)
			{
				String hs=null;
				studentID=studentID.trim();
				courseID=courseID.trim();
				System.out.println(studentID + " -- "+courseID );
				//System.out.println("-->><<-- " +soensummerstudent.get(studentID+"1").equals(courseID));
				
				if((soenfallstudent.get(studentID+"1"))!=null)
				{
					if((soenfallstudent.get(studentID+"1")).equals(courseID))
					{
					hs="fall";
					}
				}
				if((soenfallstudent.get(studentID+"2"))!=null)
				{
					if((soenfallstudent.get(studentID+"2")).equals(courseID))
					{
					hs="fall";
					}
				}
				 if((soenfallstudent.get(studentID+"3"))!=null)
				{
					if((soenfallstudent.get(studentID+"3")).equals(courseID))
					{
					hs="fall";
					}
				}
				 if((soenwinterstudent.get(studentID+"1"))!=null)
				{					{
					hs="winter";
					}
				}
				 if((soenwinterstudent.get(studentID+"2"))!=null)
				{
					if((soenwinterstudent.get(studentID+"2")).equals(courseID))
					{
					hs="winter";
					}
				}
				 if((soenwinterstudent.get(studentID+"3"))!=null)
				{
					if((soenwinterstudent.get(studentID+"3")).equals(courseID))
					{
					hs="winter";
					}
				}       
				 if((soensummerstudent.get(studentID+"1"))!=null)
				{
					System.out.println("++++++++++");
					if((soensummerstudent.get(studentID+"1")).equals(courseID))
					{
					hs="summer";
					}
				}
				 if((soensummerstudent.get(studentID+"2"))!=null)
				{
					if((soensummerstudent.get(studentID+"2")).equals(courseID))
					{
					hs="summer";
					}
				}
				 if((soensummerstudent.get(studentID+"3"))!=null)
				{
					if((soensummerstudent.get(studentID+"3")).equals(courseID))
					{
					hs="summer";
					}
				}
				
				
				
				System.out.println("hs   == "+hs);
				return hs;
			}	
			
		
	
		public static synchronized String addCourse2(String courseID, String semester,int capa ,String userid )
		{
			// comp1111 fall
			// only his dept course can be add
			// if it already add in that sem
			// put course in compfalladvisor
			// add capacity to compfallsubject1
		 
		
			
			int o=2;
		
				 if(semester.trim().equals("fall"))
				 {
					 if(soenfall.contains(courseID))
					 {
						 //return "course "+courseID+" is already added in fall term";
						 o=0;
					 }
					 else
					 {
						 soenfall.add(courseID);
						soenfallsubject1.put(courseID, capa);
						 soenfallsubject.put(courseID, capa);
						 //return "course "+courseID+" added in fall term";
						 o=1;
					 }
				 }else  if(semester.trim().equals("winter"))
				 {
					 if(soenwinter.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in winter term";
					 }
					 else
					 {
						 soenwinter.add(courseID);
						 soenwintersubject1.put(courseID, capa);
						 soenwintersubject.put(courseID, capa);
						 o=1;
						 //return "course "+courseID+" added in winter term";
					 }
				 }else  if(semester.trim().equals("summer"))
				 {
					 if(soensummer.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in summer term";
					 }
					 else
					 {
						 soensummer.add(courseID);
						 soensummersubject1.put(courseID, capa);
						soensummersubject.put(courseID, capa);
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

		
		
		
   //-----------------------------------------------------------------------------------------------------

		
		
		public static Object getKeyFromValue(Map hm, Object value) {
		    for (Object o : hm.keySet()) {
		      if (hm.get(o).equals(value)) {
		        return o;
		      }
		    }
		    return null;
		  }
		
		public static synchronized int removeCourse2(String courseID, String semester )
		{// TODO Auto-generated method stub
				int o = 2;
				// only his dept course can be add
				// if it already add in that sem
				// put course in compfalladvisor
				// add capacity to compfallsubject1
				if((courseID.substring(0, 4)).equals("soen"))
				{
					 if(semester.equals("fall"))
					 {
						 if(!soenfall.contains(courseID))
						 {
							 o=0;
							 //return "no such course like "+courseID+" is available in fall term";
						 }
						 else
						 {
							 
							 soenfall.remove(courseID);
							 soenfallsubject1.remove(courseID);
							 soenfallsubject.remove(courseID);
							 while(soenfallstudent.containsValue(courseID))
							 {
								
								 String ii = (String) getKeyFromValue(soenfallstudent,courseID);
								 soenfallstudent.remove(ii);
								
							 }
							
							 o=1;
							 //return "course "+courseID+" is removed in fall term";
						 }
					 }else  if(semester.equals("winter"))
					 {
						 if(!soenwinter.contains(courseID))
						 {
							 o=0;
							 // return "no such course like "+courseID+" is available in winter term";
						 }
						 else
						 {
							 soenwinter.remove(courseID);
							 soenwintersubject1.remove(courseID);
							 soenwintersubject.remove(courseID);
							 while(soenwinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(soenwinterstudent,courseID);
								 soenwinterstudent.remove(ii);
							 }
							
							o=1;
							 //return "course "+courseID+" is removed in winter term";
						 }
					 }else  if(semester.equals("summer"))
					 {
						 if(!soensummer.contains(courseID))
						 {
							o=0;
							 // return "no such course like "+courseID+" is available in summer term";
						 }
						 else
						 {
							 soensummer.remove(courseID);
							 soensummersubject1.remove(courseID);
							 soensummersubject.remove(courseID);
							 while(soensummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(soensummerstudent,courseID);
								 soensummerstudent.remove(ii);
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
						
							 while(soenfallstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(soenfallstudent,courseID);
								 soenfallstudent.remove(ii);
							 }
							o=1;
							 // return "course "+courseID+" is removed in fall term";
						 
					 }else  if(semester.equals("winter"))
					 {
							 while(soenwinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(soenwinterstudent,courseID);
								 soenwinterstudent.remove(ii);
							 }
							
							o=1;
							 // return "course "+courseID+" is removed in winter term";
						
					 }else  if(semester.equals("summer"))
					 {
							 while(soensummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(soensummerstudent,courseID);
								 soensummerstudent.remove(ii);
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
		
	
		
		
		
		
		 //-----------------------------------------------------------------------------------------------------
		
		
		
		
		
		public static synchronized String  listCourseAvailabilityserver2(String semester1){
			
			
			
			if(semester1.trim().equals("fall"))
			{
				String aaa=" "; 
				for(Map.Entry entry:soenfallsubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
				//System.out.println(aaa);
				return aaa;
			}
			else if(semester1.trim().equals("winter"))
			{
				String aaa=" "; 

				for(Map.Entry entry:soenwintersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}

				return aaa;
			}
			else if(semester1.trim().equals("summer"))
			{
				String aaa=" "; 

				for(Map.Entry entry:soensummersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
	
				return aaa;
			}

		return "";
		// TODO Auto-generated method stub	
	}
		
		
		//--------- - - - - - - - - ---------------------- ----------------------------- - - - - - - - - -------------------------------------
		
		
		
		
		
		
		
		public synchronized static String getClassSchedules2(String studentID)
			{
					// TODO Auto-generated method stub
					String tmp,tmpp,tmppp;
					String tmp1="";

						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
								tmp=soenfallstudent.get(studentID.trim()+its);
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
							tmp=soenwinterstudent.get(studentID.trim()+its);
					
							if(tmp!=null )
							{
								tmp1=tmp1+tmp+" ";
							}
							
						}
						tmp1=tmp1+"#";
						
						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
							tmp=soensummerstudent.get(studentID.trim()+its);
							if(tmp!=null )
							{
								tmp1=tmp1+tmp+" ";
							}
						}
						tmp1=tmp1+"$";
					return tmp1;	
						
				}
		
		
		
		
		
		
		//----------------------------------------------------------------------------------------------------
		

		public static synchronized int  checkenroll2(String studentID, String courseID)
		{
			int f = 0;
				if(soenfallsubject.containsKey(courseID) || soenwintersubject.containsKey(courseID)  || soensummersubject.containsKey(courseID) )
				{
					
					
					
					ArrayList<String> arrli = new ArrayList<String>();
									
					String h = studentID;

					for(int i=1;i<=3;i++)
					{
						Integer intInstance = new Integer(i);      
						
						arrli.add( (soenfallstudent.get(h+intInstance.toString())));
						arrli.add(soenwinterstudent.get(h+intInstance.toString()));
						arrli.add(soensummerstudent.get(h+intInstance.toString()));
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
		
		
		
		
		
		
		 
		
		
		public static synchronized String dropCourses2(String studentID, String courseID) {
			
			System.out.println(studentID+courseID);
			int flag2 = checkenroll2(studentID, courseID);
			System.out.println(flag2);
			int ck=0;
			
			
			
			if(flag2==1) 
			{
					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
						if(soenfallstudent.get(studentID+its)!=null && (soenfallstudent.get(studentID+its)).equals(courseID) )
						{
							soenfallstudent.remove(studentID+its);
							//ck=1;
							if(courseID.trim().substring(0, 4).equals("soen"))
							{
							int tt=soenfallsubject.get(courseID)+1;
							soenfallsubject.replace(courseID, tt);
							ck=1;
							}
							
						}else if(soenwinterstudent.get(studentID+its)!=null && (soenwinterstudent.get(studentID+its)).equals(courseID))
						{
							soenwinterstudent.remove(studentID+its);
							//ck=1;
							if(courseID.trim().substring(0, 4).equals("soen"))
							{
							int tt=soenwintersubject.get(courseID)+1;
							soenwintersubject.replace(courseID, tt);
							ck=1;
							}
							
						}else if(soensummerstudent.get(studentID+its)!=null && (soensummerstudent.get(studentID+its)).equals(courseID))
						{
							soensummerstudent.remove(studentID+its);
							//ck=1;
							if(courseID.trim().substring(0, 4).equals("soen"))
							{
							int tt=soensummersubject.get(courseID)+1;
							soensummersubject.replace(courseID, tt);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static synchronized int checkmaxdep1(String studentID, String  semester,String courseID)
		{
			studentID.trim();
			semester.trim();
			courseID.trim();
			ArrayList<String> arrli = new ArrayList<String>();
			count2[0]=count2[1]=count2[2]=0;
			String h = studentID;

			for(int i=1;i<=3;i++)
			{
				Integer intInstance = new Integer(i);      
				
				arrli.add(soenfallstudent.get(h+intInstance.toString()));
				arrli.add(soenwinterstudent.get(h+intInstance.toString()));
				arrli.add(soensummerstudent.get(h+intInstance.toString()));
		
			}
	 
			for (String str : arrli) {
				//System.out.println(str);
				if(str!=null)
				{
					if(str.substring(0,4).equals("comp"))
					{
						++count2[0];
					}
					else if(str.substring(0,4).equals("soen"))
					{
						++count2[1];
					}
					else if(str.substring(0,4).equals("inse"))
					{
						++count2[2];
					}
				}
			}

			System.out.println(count2[0]+" "+count2[1]+" "+count2[2]+"dep");
			arrli.clear();
			String tmp1 = courseID.substring(0, 4);
			System.out.println(tmp1);
			 if(studentID.substring(0, 4).equals("soen"))
			 {
			if(tmp1.equals("comp"))
			{
				return count2[0];
			}else if(tmp1.equals("soen"))
			{
				return count2[1];
			}else if(tmp1.equals("inse"))
			{
				return count2[2];
			}
			 }
			else if(studentID.substring(0, 4).equals("comp") || studentID.substring(0, 4).equals("inse"))
			{
				return count2[1];
			}
			return 9;
		}
		
		
		
		public static synchronized int checkmaxterm1(String studentID, String  semester)
		{
			ArrayList<String> arrli = new ArrayList<String>();
			count22[0]=count22[1]=count22[2]=0;
			String h = studentID;
			for(int i=1;i<=3;i++)
			{
				 
				
				arrli.add(soenfallstudent.get(h+ Integer.toString(i)));
				
				for (String str : arrli) 
				{
					
					if(str!=null)
					{
						++count22[0];
					}
				}
				 arrli.clear();
				 
				arrli.add(soenwinterstudent.get(h+Integer.toString(i)));
				
				for (String str : arrli) 
				{
					if(str!=null)
					{
						++count22[1];
					}
				}
				 arrli.clear();
				
				arrli.add(soensummerstudent.get(h+Integer.toString(i)));
				
			    for (String str : arrli) 
				{
					if(str!=null)
					{
						++count22[2];
					}
				}
				 arrli.clear();
				
			}
			arrli.clear();
			System.out.println(count22[0]+" "+count22[1]+" "+count22[2]+"term");
		/*	if(semester.equals("fall"))
			{
				return count1[0];
			}
			else if(semester.equals("winter"))
			{
				return count1[1];
			}
			else if(semester.equals("summer"))
			{
				return count1[2];
			}*/
			
			
			
			if(semester.trim().equals("fall"))
			{
				return count22[0];
			}
			else if(semester.trim().equals("winter"))
			{
				return count22[1];
			}else if(semester.trim().equals("summer"))
			{
				return count22[2];
			}
			
			
			return count22[0]+count22[1]+count22[2];
		}
		
		
		
		
		
		
		public static synchronized int checkavailibility1(String courseID, String semester)
		{
			String tmp = courseID.substring(0, 4);	
			
			
				 if(semester.trim().equals("fall"))
				 {
					 int tmp1 = soenfallsubject.get(courseID);
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
					 int tmp1 = soenwintersubject.get(courseID);
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
					 int tmp1 = soensummersubject.get(courseID);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static synchronized String enrolCourse2(String studentID, String courseID, String semester) {
			// TODO Auto-generated method stub
			
			int chk=9;
			int z,vv;
			String v;
			
			boolean v1;
			
			studentID.trim();
			courseID.trim();
			semester.trim();
		//	System.out.println(studentID+courseID+courseID);
			
				int flag1 = checkenroll2(studentID, courseID/*,  semester*/);
				if(flag1==1)
				{
					chk=1;
				}
				else if(flag1==0)
				{
					
				
						int flag2 = checkavailibility1(courseID,  semester);
						System.out.print(flag2);
						
						if(flag2==1)
						{
							if(semester.trim().equals("fall"))
							{
								
								for(int i=1;i<=3;i++)
								{
									String its = Integer.toString(i);
									
										v=soenfallstudent.get(studentID+its);
										v1=soenfallstudent.containsValue(studentID+its);
										if((v == null) && v1==false )
										{
											 
											soenfallstudent.put(studentID+its,courseID);
											
											int hh=soenfallsubject.get(courseID);
											hh=hh-1;
											soenfallsubject.put(courseID, hh);

											
											System.out.println(soenfallstudent.get(studentID+its));
											System.out.println((studentID+its)+"keyyyy "+getKeyFromValue(soenfallstudent,courseID));
											System.out.println(soenfallstudent);
											break ;
										}
								}
								
						}else if(semester.trim().equals("winter"))
						{
							for(int i=1;i<=3;i++)
							{
								String its = Integer.toString(i);
								
								
								
									v=soenwinterstudent.get(studentID+its);
									v1=soenwinterstudent.containsValue(studentID+its);
									if((v == null) && v1==false )
									{
										soenwinterstudent.put(studentID+its,courseID);
										
										int hh=soenwintersubject.get(courseID);
										hh=hh-1;
										soenwintersubject.put(courseID, hh);
										break ;
									}
								
			
							}
						
						}else if(semester.trim().equals("summer"))
						{
							
							for(int i=1;i<=3;i++)
							{
								String its = Integer.toString(i);
								
									v=soensummerstudent.get(studentID+its);
									v1=soensummerstudent.containsValue(studentID+its);
									if((v == null) && v1==false )
									{
										soensummerstudent.put(studentID+its,courseID);
										
										int hh=soensummersubject.get(courseID);
										hh=hh-1;
										soensummersubject.put(courseID, hh);
										
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

























   class sendMessage1 implements Runnable {
	
	   Thread t2;
	    int serverPort;
	    String ss1,ss2;
	    String msg;
	    String sid,sem,method,courseid;
	    public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/soen/Server2.txt");
		    BufferedWriter output0;
	   
	   
	    sendMessage1(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	msg=null;
	    	 msg=ss2+":"+ss1+"^";
	    	t2=new Thread(this);
	    	
	    }
	   
	    public sendMessage1(int p, String studentID,String courseID, String sem, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	    	this.sem=sem;
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid+"#"+sem+"^";
	    	t2=new Thread(this);
			// TODO Auto-generated constructor stub
		}
	    
	    	public sendMessage1(int p, String studentID,String courseID, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	 
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid+"^";
	    	t2=new Thread(this);
			// TODO Auto-generated constructor stub
		}
	    
	    
	    public synchronized void run()  
	    {
	    	 DatagramSocket aSocket = null;
			  try {
				  aSocket = new DatagramSocket();
				  byte[] message = new byte[1000];
				
				  message=msg.getBytes();
				  
				  InetAddress aHost = InetAddress.getByName("localhost");
				  DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
				  aSocket.send(request);
				  System.out.println("SOEN:Request message sent from the client to server with port number " + serverPort + " is: "
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
				  String tmp = new String(reply.getData());
				  
				  tmp=tmp.trim();
				  try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(" , Reply received from the server with port number " + serverPort+" , \n\n");
						output0.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
				  tmp=tmp.trim();
				  System.out.println("SOEN : Reply received from the server with port number " + serverPort + " is: "
					+ tmp);
				 
			   	String kept = tmp.substring(tmp.indexOf(":")+1,tmp.indexOf("@"));
			 
			  System.out.println(tmp+"---"+kept);
			   	
					 if(kept.trim().equals("methodlist"))
					 {
					//	String output4=null;
						 
						 Server2.output1 =Server2.output1+ tmp.substring(0,tmp.indexOf(":"));
						 //System.out.println( Server2.output1);
					//	 Server1 s1=new Server1();
					//	 s1.listCourseAvailabilitys1get1(output4);
						 
					 }else if(kept.trim().equals("methodenroll"))
					 {
						 Server2.enrol1=null;
						 Server2.enrol1 = tmp.substring(0,tmp.indexOf(":"));
						 
						 
						// String h=tmp.substring(0,tmp.indexOf(":"));
						 //Server2 d=new Server2();
						 //d.ff(h);
						 System.out.println(Server2.enrol1);
						 
					 }else if(kept.trim().equals("methoddrop"))
					 {
						 Server2.drop1 = tmp.substring(0,tmp.indexOf(":"));
					 }
					 else if(kept.trim().equals("methodschedule"))
					 {
						 Server2.schedule1 += tmp.substring(0,tmp.length());
					 }else if(kept.trim().equals("methoddep"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server2.dep2 +=  Integer.parseInt(ha);
						 
					 }
					 else if(kept.trim().equals("methodterm"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server2.term2 +=  Integer.parseInt(ha);
						 
					 }else if(kept.trim().equals("methodavail"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server2.avai1 =  Integer.parseInt(ha);
						 
					 }else if(kept.trim().equals("methodgetsem"))
					 {
						 Server2.getsem2=tmp.substring(0,tmp.indexOf(":"));
						 System.out.println( "0000000000000000 "+Server2.getsem2);
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

 class receive1 implements Runnable {
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/soen/Server2.txt");
	    BufferedWriter output0;
	 Thread t1;
	    int serverPort;
	    receive1()
	    {
	    	//serverPort=p;
	    	t1=new Thread(this);
	    		
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
	   	
			 try {
				 aSocket = new DatagramSocket(8001);
			
				 String kept2 = null;
				 System.out.println("Server 8001 Started............");
				 ImpInterFace imobj2 = new ImpInterFace();
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
						
					 System.out.println(msg1.length()+"**");
					 System.out.println(msg1);
					msg1.trim();	
					 System.out.println(msg1.length()+"cc");
					 
					 System.out.println("\n"+request.getData().toString()+" ,request comming from "+request.getAddress()+" port : "+request.getPort());
					 
					 
					 String kept = msg1.substring( 0, msg1.indexOf(":"));
					 if(kept.equals("methodlist"))
					 {
						 
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
						
					
						  kept2=server2methods.listCourseAvailabilityserver2(kept1);
						  kept2=kept2+":methodlist@";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.indexOf("^"));
						// ImpInterFace imobj = new ImpInterFace(2);
						 
						 kept2=server2methods.enrolCourse2(stuid,corid,seme); 
						 System.out.println("cheking : "+server2methods.soenfallstudent.get(stuid+"2"));
						  
						 kept2=kept2+":methodenroll@";
						 System.out.println("output----"+kept2);
						 message  = kept2.getBytes();
						 
					 }else if(kept.equals("methoddrop"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
						
						kept2=server2methods.dropCourses2(stuid,corid);  
						 kept2=kept2+":methoddrop@";
						  System.out.println(kept2.length());
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodschedule"))  
					 { 
						 kept2=null;
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
						  kept2=server2methods.getClassSchedules2(kept1);
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
						 k=server2methods.checkmaxdep1(stuid, seme,corid);
						 kept2=k+":methoddep@";
						  message  = kept2.getBytes();
					 }
					 else if(kept.equals("methodterm"))
					 {
						 int k;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 stuid.trim();  seme.trim();
						 k=server2methods.checkmaxterm1(stuid, seme);
						 kept2=k+":methodterm@";
						  message  = kept2.getBytes();
					 }else if(kept.equals("methodavail"))
					 {
						 kept2=null;
						 String corid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
					
						 int ava=server2methods.checkavailibility1(corid,seme); 
						 
						 kept2=ava+":methodavail@";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodgetsem"))
					 {
						 kept2=null;
						 String sid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String cid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 kept2=server2methods.getHash1(sid, cid);
						 kept2=kept2+":methodgetsem@";
						 kept2.trim();
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
			t1.start ();
		}
	
}


//-----------------______________________________------------------------------_________________________



public class Server2 {

	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/soen/Server2.txt");
	    BufferedWriter output0;
	
	 public static String output1,getsem2;
	 public static String enrol1,drop1,schedule1; 
	 public static int dep2,term2,avai1;
	 public static String val; 
	 public Server2()
	 {
		 output1=" ";
		 enrol1=" ";
		 val=" ";
		 drop1=" ";
		 schedule1=" ";
		 dep2=0;
		 term2=0;
		 avai1=0;
		 getsem2=null;
	 }
	
	
	
	 public synchronized String getClassSchedules2(String studentID)
	 {
		 
String list="";
		 
		 String s2=server2methods.getClassSchedules2(studentID);
		 System.out.println("ggg"+s2);
		 sendMessage1 R2 = new sendMessage1(8000,studentID,"methodschedule"); // methodenroll , methoddrop , methodschedule1 
	      R2.start();
	      sendMessage1 R3 = new sendMessage1(8002,studentID,"methodschedule");
	      R3.start();	
	     try {
			R2.t2.join();
			R3.t2.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		 System.out.println(schedule1);
	     schedule1.trim();
		 list="fall - "+s2.substring(0,s2.indexOf("*"))+" "+schedule1.substring(0, schedule1.indexOf("*"))+" ";   // schedule1
		 int tmp=schedule1.indexOf("*");
		 list=list+schedule1.substring(schedule1.indexOf("@")+1, schedule1.indexOf("*",tmp+1));
		 
		 list=list+"\nwinter - "+s2.substring(s2.indexOf("*")+1,s2.indexOf("#"))+" "+schedule1.substring(schedule1.indexOf("*")+1,schedule1.indexOf("#"))+" ";   // schedule1
		 int one=schedule1.indexOf("*");
		int two=schedule1.indexOf("#");
		 list=list+schedule1.substring(schedule1.indexOf("*",one+1)+1,schedule1.indexOf("#",two+1));
	     
		 list=list+"\nsummer - "+s2.substring(s2.indexOf("#")+1,s2.length()-1)+" "+schedule1.substring(schedule1.indexOf("#")+1,schedule1.indexOf("$"))+" ";   // schedule1
		    int one1=schedule1.indexOf("#");
			int two1=schedule1.indexOf("$");
		 list=list+schedule1.substring(schedule1.indexOf("#",one1+1)+1,schedule1.indexOf("$",two1+1));
		 list.trim();
	     
		 
		 return list;

	 }
	 
	 
	 
	 
	 
	 
	public synchronized String  listCourseAvailabilitys2send(String semester)
	{
		
		String list="";
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) & server 3(INSE), ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String s2=server2methods.listCourseAvailabilityserver2(semester);
		
		
		
		  sendMessage1 R2 = new sendMessage1(8000,semester,"methodlist"); // methodenroll , methoddrop , methodschedule
	      R2.start();
	      sendMessage1 R3 = new sendMessage1(8002,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t2.join();
			R3.t2.join(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	  
	      
	     list=s2+output1;
	      return list;
	} 
	
	
	
	
	
	
	
	public String enrolCourseserver1(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
	
		
		sendMessage1 R2 = new sendMessage1(8000,studentID,courseID,semester,"methoddep");

		 R2.start();
		sendMessage1 R3 = new sendMessage1(8002,studentID,courseID,semester,"methoddep");

		 R3.start();
		
	      
	      try {
				R2.t2.join();
				R3.t2.join();
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
	      
	      
	      sendMessage1 R4 = new sendMessage1(8000,studentID,semester,"methodterm");
			 R4.start();
			sendMessage1 R5 = new sendMessage1(8002,studentID,semester,"methodterm");
			 R5.start();
			
		      
		      try {
					R4.t2.join();
					R5.t2.join();
				} catch (Exception e) {}
		
		System.out.println(" -> "+dep2+" "+term2);
		int dept=server2methods.checkmaxdep1(studentID, semester, courseID);
		int termt=server2methods.checkmaxterm1(studentID, semester);
		dep2=dep2+dept;
		term2=term2+termt;
		System.out.println("<- "+dept+" "+termt);
		System.out.println("<-> "+dep2+" "+term2);
		
		if((courseID.substring(0, 4)).equals("soen"))
		{
			if( term2<3)
			{
			int flag2 = server2methods.checkavailibility1(courseID,  semester);
			if(flag2==1)
			{
			String d=server2methods.enrolCourse2(studentID, courseID,semester);
			System.out.println(d);
			 return d;
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
	else if((courseID.substring(0, 4)).equals("comp"))
		{
		
		if(dep2<2 && term2<3)
		{
		 sendMessage1 R0 = new sendMessage1(8000,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
			
	      R0.start();
	      
	      try {
				R0.t2.join(); 
			} catch (Exception e) {		}
		
	      if(Server2.avai1==1)
			{
		sendMessage1 R8 = new sendMessage1(8000,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
		
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) , ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	      R8.start();
	      
	      try {
				R8.t2.join(); 
			
			      return enrol1;
			} catch (Exception e) {}
			}else
			{
				 return "no space available in this subject in this term";
			}
		}
		else
		{
			return "Max course capacity exceed for "+studentID;
		}
		}else if((courseID.substring(0, 4)).equals("inse"))
		{
			if(dep2<2 && term2<3)
			{
			sendMessage1 R0 = new sendMessage1(8002,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
			
		      R0.start();
		      
		      try {
					R0.t2.join(); 
				} catch (Exception e) {		}

		      if(Server2.avai1==1)
			     {
	      sendMessage1 R9 = new sendMessage1(8002,studentID,courseID,semester,"methodenroll");
	      
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server3 (INSE) , ");
				output0.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      
	      R9.start();
	      try {
				R9.t2.join(); 
				  
			      return enrol1;
			} catch (Exception e) {
				// TODO: handle exception
			}
	  
			     }else
					{
					 return "no space available in this subject in this term";
				}
		}
		else
		{
			return "Max course capacity exceed for "+studentID;
		}	      
		}
		
	     return "ggg";
		
	}
	
	
	
	public String dropCourseserver1(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("soen"))
		{
			String drop1=server2methods.dropCourses2(studentID, courseID);
			System.out.println(drop1);
			   return drop1;
		}
		else if((courseID.substring(0, 4)).equals("comp"))
		{
		sendMessage1 R2 = new sendMessage1(8000,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	    
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
	    	
	    	 
				R2.t2.join(); 
			
			      return drop1;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage1 R2 = new sendMessage1(8002,studentID,courseID,"methoddrop");
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server3 (INSE) , ");
				output0.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      
	      R2.start();
	      
	      try {
				R2.t2.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop1;
	      
		}
		return drop1;
	     
		
	}
	
	
//	public synchronized String  listCourseAvailabilitys1get()
//	{
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	}
	
	
	
	
public String addCourseserver(String courseID, String semester,int capa ,String userid ) {
		
		String h;
	
		h=server2methods.addCourse2( courseID,  semester, capa , userid );
		System.out.println("gdgdgdgdgdgdgdgdgdgdgdg  "+server2methods.soensummer);
		return h;
}
	
	
	

public String removeCourseserver(String courseID, String semester ) {

String h=null;
int h1;
h1=server2methods.removeCourse2( courseID,  semester);
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






public String swapCourse2(String studentID,String newCourseID,String oldCourseID)
{
	
	String sem1,drop1,drop2,en2=null;
	if((newCourseID.substring(0, 4)).equals("soen") && (oldCourseID.substring(0, 4)).equals("soen"))
	{
		 sem1= server2methods.getHash1(studentID, oldCourseID);
		 drop1=server2methods.dropCourses2(studentID, oldCourseID);
		 en2= server2methods.enrolCourse2(studentID, newCourseID, sem1);
		if(!(en2.equals(studentID+"is successfully enrolled in "+ newCourseID)))
		{
			 en2= server1methods.enrolCourse1(studentID, oldCourseID, sem1);
		}
		System.out.println(drop1);
		   return en2;
	}else if((newCourseID.substring(0, 4))!="soen" && (oldCourseID.substring(0, 4)).equals("soen"))
	{
		 
		 sem1= server2methods.getHash1(studentID, oldCourseID);
		 System.out.println(sem1);
		 drop1=server2methods.dropCourses2(studentID, oldCourseID);
		 en2= enrolCourseserver1(studentID, newCourseID, sem1);
		 en2=en2.trim();
		 if(!(en2.equals(studentID+"is successfully enrolled in "+ newCourseID)))
			{
				 en2= server2methods.enrolCourse2(studentID, oldCourseID, sem1);
			}
			System.out.println(drop1);
			   return en2;
	}else if((oldCourseID.substring(0, 4))!="soen" && (newCourseID.substring(0, 4)).equals("soen"))
	{
		drop2=oldCourseID;
		if((oldCourseID.substring(0, 4)).equals("comp"))
		{
		sendMessage1 R22 = new sendMessage1(8000,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
		R22.start();
	      try {
				R22.t2.join(); 
			} catch (Exception e) {	}
		}else if((oldCourseID.substring(0, 4)).equals("inse"))
		{
			sendMessage1 R22 = new sendMessage1(8002,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R22.start();
		      try {
					R22.t2.join(); 
			
		      } catch (Exception e) {	}
		}
		sem1=getsem2;
		drop1=dropCourseserver1(studentID,oldCourseID);
		if((drop1.equals(studentID+" is successfully drop in "+oldCourseID)))
		{
			System.out.println("7777777");
			 en2= server2methods.enrolCourse2(studentID, newCourseID, sem1);
		}
		System.out.println(en2);
		en2=en2.trim();
		if(!(en2.equals(studentID+"is successfully enrolled in "+ newCourseID)))
		{
			 en2= enrolCourseserver1(studentID, oldCourseID, sem1);
		}
		return en2;
	}else if((oldCourseID.substring(0, 4))!="soen" && (newCourseID.substring(0, 4))!="soen")
	{
		
		if((oldCourseID.substring(0, 4)).equals("comp"))
		{
			sendMessage1 R21 = new sendMessage1(8000,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R21.start();
		      try {
					R21.t2.join(); 
				} catch (Exception e) {	}
		}else if((oldCourseID.substring(0, 4)).equals("inse"))
		{
			sendMessage1 R23 = new sendMessage1(8002,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R23.start();
		      try {
					R23.t2.join(); 
				} catch (Exception e) {	}
			
		}
			System.out.println("gettt sem = "+getsem2);
		        sem1=getsem2.trim();
		        
				drop1=dropCourseserver1(studentID,oldCourseID);
				
				 en2= enrolCourseserver1(studentID, newCourseID, sem1);
				
				en2=en2.trim();
				if(!(en2.equals(studentID+"is successfully enrolled in "+ newCourseID)))
				{
					 en2= enrolCourseserver1(studentID, oldCourseID, sem1);
				}
				return en2;	
	}
	
	
	
	return en2;
	
}	
	
	
	
	
	public static void main(String args[]) throws Exception{
	
		
		//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);

		
		server2methods s2 = new server2methods();
		 receive1 R1 = new receive1();
	      R1.start();
		ORB orb = ORB.init(args, null);
		 try{
		      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
		           
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();
		 
		      // create servant and register it with the ORB
		      ImpInterFace obj2 = new ImpInterFace();
		     // obj1.setORB(orb); 
		 
		      // get object reference from the servant
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj2);
		      InterFace2 href = InterFace2Helper.narrow(ref);
		 
		      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		 
		      NameComponent path[] = ncRef.to_name( "SOEN" );
		      ncRef.rebind(path, href);
		 
		      System.out.println("SOEN Server ready and waiting ...");
		 
		      // wait for invocations from clients
		      
			  orb.run();
		     
			 
		    } 
		 
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		      }
		 
		      System.out.println("SOEN Server Exiting ...");
			  
		         
		
	}

} 



