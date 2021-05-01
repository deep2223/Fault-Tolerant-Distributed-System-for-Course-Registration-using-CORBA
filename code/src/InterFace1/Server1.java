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

//import asmt1_11.ImpInterFace;
//import asmt1_11.Server2;
//import asmt1_11.Server3;

  class server1methods{
	 
	 public static HashMap<String, Integer> compfallsubject1 = new HashMap<String, Integer>();   // comp1111 5
	 public static  HashMap<String, Integer> compwintersubject1 = new HashMap<String, Integer>();  //  
	 public static HashMap<String, Integer> compsummersubject1 = new HashMap<String, Integer>();
		
	public static HashMap<String, Integer> compfallsubject = new HashMap<String, Integer>();   // comp1111 5
	public  static HashMap<String, Integer> compwintersubject = new HashMap<String, Integer>();  //  
	public  static HashMap<String, Integer> compsummersubject = new HashMap<String, Integer>();
		
	public  static HashMap<String, String> compfallstudent = new HashMap<String, String>();   //  comps1111  comp1111
	public  static HashMap<String, String> compwinterstudent = new HashMap<String, String>();
	public  static HashMap<String, String> compsummerstudent = new HashMap<String, String>();
		
	public static  ArrayList<String> compfall = new ArrayList<String>();
	public static  ArrayList<String> compwinter = new ArrayList<String>();
	public  static  ArrayList<String> compsummer = new ArrayList<String>();
	static boolean flag1= false;
	public static int count1[]=new int[] {0,0,0};
	public static int count[]=new int[] {0,0,0};
		public  void default_values1()
		{
		
			compfall.add( "comp1111");
			compfall.add( "comp2222");
			compfall.add( "comp3333");
			 
			compwinter.add( "comp2222");
			compsummer.add( "comp3333");
			
			compfallsubject1.put("comp1111", 5);
			compfallsubject1.put("comp2222", 6);
			compfallsubject1.put("comp3333", 6);
			compwintersubject1.put("comp1111", 7);
			compwintersubject1.put("comp2222", 9);
			compsummersubject1.put("comp3333", 2);
					
			compfallsubject.put("comp1111", 3); // 5-2
			compfallsubject.put("comp2222", 4); // 6-2
			compfallsubject.put("comp3333", 6);
			compwintersubject.put("comp1111", 7);
			compwintersubject.put("comp2222", 9);
			compsummersubject.put("comp3333", 2);

			compfallstudent.put("comps11111", "comp1111");
			compsummerstudent.put("comps11111", "comp3333");
		//	compsummerstudent.put("soens11111", "comp3333");
			flag1=true;
				
		}
		public server1methods()  {
			
			// TODO Auto-generated constructor stub
				if(flag1==false)
				{
					default_values1();
					flag1=true;
				}
			
		}
	
		/*public static synchronized String getHash(String studentID ,String courseID)
		{
			String hs=null;
			if(compfallstudent.get(studentID+"1").equals(courseID) || compfallstudent.get(studentID+"2").equals(courseID)||compfallstudent.get(studentID+"3").equals(courseID) )
			{
				hs="fall";
			}else if(compwinterstudent.get(studentID+"1").equals(courseID) || compwinterstudent.get(studentID+"2").equals(courseID)||compwinterstudent.get(studentID+"3").equals(courseID) )
			{
				hs="winter";
			}else if(compsummerstudent.get(studentID+"1").equals(courseID) || compsummerstudent.get(studentID+"2").equals(courseID)||compsummerstudent.get(studentID+"3").equals(courseID) )
			{
				hs="summer";
			}
			return hs;
		}
		*/
		public static synchronized String getHash(String studentID ,String courseID)
		{
			String hs=null;
			studentID=studentID.trim();
			courseID=courseID.trim();
			System.out.println(studentID + " -- "+courseID );
			
			
			if((compfallstudent.get(studentID+"1"))!=null)
			{
				if((compfallstudent.get(studentID+"1")).equals(courseID))
				{
				hs="fall";
				}
			}
			if((compfallstudent.get(studentID+"2"))!=null)
			{
				if((compfallstudent.get(studentID+"2")).equals(courseID))
				{
				hs="fall";
				}
			}
			 if((compfallstudent.get(studentID+"3"))!=null)
			{
				if((compfallstudent.get(studentID+"3")).equals(courseID))
				{
				hs="fall";
				}
			}
			 if((compwinterstudent.get(studentID+"1"))!=null)
			{
				if((compwinterstudent.get(studentID+"1")).equals(courseID))
				{
				hs="winter";
				}
			}
			 if((compwinterstudent.get(studentID+"2"))!=null)
			{
				if((compwinterstudent.get(studentID+"2")).equals(courseID))
				{
				hs="winter";
				}
			}
			 if((compwinterstudent.get(studentID+"3"))!=null)
			{
				if((compwinterstudent.get(studentID+"3")).equals(courseID))
				{
				hs="winter";
				}
			}
			 if((compsummerstudent.get(studentID+"1"))!=null)
			{
				if((compsummerstudent.get(studentID+"1")).equals(courseID))
				{
				hs="summer";
				}
			}
			 if((compsummerstudent.get(studentID+"2"))!=null)
			{
				if((compsummerstudent.get(studentID+"2")).equals(courseID))
				{
				hs="summer";
				}
			}
			 if((compsummerstudent.get(studentID+"3"))!=null)
			{
				if((compsummerstudent.get(studentID+"3")).equals(courseID))
				{
				hs="summer";
				}
			}
			
			
			
			System.out.println("hs   == "+hs);
			return hs;
		}	
		
		public static Object getKeyFromValue(Map hm, Object value) {
		    for (Object o : hm.keySet()) {
		      if (hm.get(o).equals(value)) {
		        return o;
		      }
		    }
		    return null;
		  }
		
		public static synchronized int removeCourse1(String courseID, String semester )
		{// TODO Auto-generated method stub
				int o = 2;
				// only his dept course can be add
				// if it already add in that sem
				// put course in compfalladvisor
				// add capacity to compfallsubject1
				if((courseID.substring(0, 4)).equals("comp"))
				{
					 if(semester.equals("fall"))
					 {
						 if(!compfall.contains(courseID))
						 {
							 o=0;
							 //return "no such course like "+courseID+" is available in fall term";
						 }
						 else
						 {
							 
							 compfall.remove(courseID);
							 compfallsubject1.remove(courseID);
							 compfallsubject.remove(courseID);
							 while(compfallstudent.containsValue(courseID))
							 {
								
								 String ii = (String) getKeyFromValue(compfallstudent,courseID);
								 compfallstudent.remove(ii);
								
							 }
							
							 o=1;
							 //return "course "+courseID+" is removed in fall term";
						 }
					 }else  if(semester.equals("winter"))
					 {
						 if(!compwinter.contains(courseID))
						 {
							 o=0;
							 // return "no such course like "+courseID+" is available in winter term";
						 }
						 else
						 {
							 compwinter.remove(courseID);
							 compwintersubject1.remove(courseID);
							 compwintersubject.remove(courseID);
							 while(compwinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(compwinterstudent,courseID);
								 compwinterstudent.remove(ii);
							 }
							
							o=1;
							 //return "course "+courseID+" is removed in winter term";
						 }
					 }else  if(semester.equals("summer"))
					 {
						 if(!compsummer.contains(courseID))
						 {
							o=0;
							 // return "no such course like "+courseID+" is available in summer term";
						 }
						 else
						 {
							 compsummer.remove(courseID);
							 compsummersubject1.remove(courseID);
							 compsummersubject.remove(courseID);
							 while(compsummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(compsummerstudent,courseID);
								 compsummerstudent.remove(ii);
							 }
							o=1;
							 // return "course "+courseID+" is removed in summer term";
						 }
					 }
				}
				
				
				else if((courseID.substring(0, 4)).equals("soen") || (courseID.substring(0, 4)).equals("inse"))
				{
					
					if(semester.equals("fall"))
					 {
						
							 while(compfallstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(compfallstudent,courseID);
								 compfallstudent.remove(ii);
							 }
							o=1;
							 // return "course "+courseID+" is removed in fall term";
						 
					 }else  if(semester.equals("winter"))
					 {
							 while(compwinterstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(compwinterstudent,courseID);
								 compwinterstudent.remove(ii);
							 }
							
							o=1;
							 // return "course "+courseID+" is removed in winter term";
						
					 }else  if(semester.equals("summer"))
					 {
							 while(compsummerstudent.containsValue(courseID))
							 {
								 String ii = (String) getKeyFromValue(compsummerstudent,courseID);
								 compsummerstudent.remove(ii);
							 }
							
						o=1;
							 //	 return "course "+courseID+" is removed in summer term";
						 }
					 }


				
				
				
				
				
				return o;
  }
		
		
	//------------------ - - - - - - - - - - - - - - - - - - - - - ------------------------------------------	
		
		public static synchronized String addCourse1(String courseID, String semester,int capa ,String userid )
		{
			// comp1111 fall
			// only his dept course can be add
			// if it already add in that sem
			// put course in compfalladvisor
			// add capacity to compfallsubject1
		 
		 
			
			int o=2;
		
				 if(semester.trim().equals("fall"))
				 {
					 if(compfall.contains(courseID))
					 {
						 //return "course "+courseID+" is already added in fall term";
						 o=0;
					 }
					 else
					 {
						 compfall.add(courseID);
						 compfallsubject1.put(courseID, capa);
						 compfallsubject.put(courseID, capa);
						 //return "course "+courseID+" added in fall term";
						 o=1;
					 }
				 }else  if(semester.trim().equals("winter"))
				 {
					 if(compwinter.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in winter term";
					 }
					 else
					 {
						 compwinter.add(courseID);
						 compwintersubject1.put(courseID, capa);
						 compwintersubject.put(courseID, capa);
						 o=1;
						 //return "course "+courseID+" added in winter term";
					 }
				 }else  if(semester.trim().equals("summer"))
				 {
					 if(compsummer.contains(courseID))
					 {
						 o=0;
						// return "course "+courseID+" is already added in summer term";
					 }
					 else
					 {
						 compsummer.add(courseID);
						 compsummersubject1.put(courseID, capa);
						 compsummersubject.put(courseID, capa);
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
		
		
	//--------- - - - - - - - - ----------------------------- - - - - - - - - -------------------------------------
		
		
		
		public static synchronized String  listCourseAvailabilityserver1(String semester1){
			
			
			
				if(semester1.trim().equals("fall"))
				{
					String aaa=" "; 
					for(Map.Entry entry:compfallsubject.entrySet()){
					    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
					}
					//System.out.println(aaa);
					return aaa;
				}
				else if(semester1.trim().equals("winter"))
				{
					String aaa=" "; 

					for(Map.Entry entry:compwintersubject.entrySet()){
					    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
					}

					return aaa;
				}
				else if(semester1.trim().equals("summer"))
				{
					String aaa=" "; 

					for(Map.Entry entry:compsummersubject.entrySet()){
					    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
					}
		
					return aaa;
				}

			return "";
			// TODO Auto-generated method stub	
		}
		
		
		
		
		
		
//--------- - - - - - - - - ---------------------- ----------------------------- - - - - - - - - -------------------------------------
		
				
		
		
		
		
		
	public static synchronized String getClassSchedules1(String studentID)    //soens1111
		{
				// TODO Auto-generated method stub
				String tmp,tmpp,tmppp;
				String tmp1="";

					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
							tmp=compfallstudent.get(studentID.trim()+its);
							if(tmp!=null )
							{
								tmp1=tmp1+tmp+" ";
							}
					}
					tmp1=tmp1+"*";
					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
						tmp=compwinterstudent.get(studentID.trim()+its);
				
						if(tmp!=null )
						{
							tmp1=tmp1+tmp+" ";
						}
						
					}
					tmp1=tmp1+"#";
					
					for(int i=1;i<=3;i++)
					{
						String its = Integer.toString(i);
						tmp=compsummerstudent.get(studentID.trim()+its);
						if(tmp!=null )
						{
							tmp1=tmp1+tmp+" ";
						}
					}
					tmp1=tmp1+"$";
				return tmp1;	
					
			}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------
	

	public static synchronized int  checkenroll(String studentID, String courseID)
	{
		int f = 0;
			if(compfallsubject.containsKey(courseID) || compwintersubject.containsKey(courseID)  || compsummersubject.containsKey(courseID) )
			{
				
				
				
				ArrayList<String> arrli = new ArrayList<String>();
								
				String h = studentID;

				for(int i=1;i<=3;i++)
				{
					Integer intInstance = new Integer(i);      
					
					arrli.add( (compfallstudent.get(h+intInstance.toString())));
					arrli.add(compwinterstudent.get(h+intInstance.toString()));
					arrli.add(compsummerstudent.get(h+intInstance.toString()));
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
	
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------	
	
	
	
	public static synchronized String dropCourses1(String studentID, String courseID) {
		
		System.out.println(studentID+courseID);
		int flag2 = checkenroll(studentID, courseID);
		System.out.println(flag2);
		int ck=0;
		
		
		
		if(flag2==1) 
		{
				for(int i=1;i<=3;i++)
				{
					String its = Integer.toString(i);
					if(compfallstudent.get(studentID+its)!=null && (compfallstudent.get(studentID+its)).equals(courseID) )
					{
						compfallstudent.remove(studentID+its);
						
						if(courseID.trim().substring(0, 4).equals("comp"))
						{
						int tt=compfallsubject.get(courseID)+1;
						compfallsubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(compwinterstudent.get(studentID+its)!=null && (compwinterstudent.get(studentID+its)).equals(courseID))
					{
						compwinterstudent.remove(studentID+its);
						
						if(courseID.trim().substring(0, 4).equals("comp"))
						{
						int tt=compwintersubject.get(courseID)+1;
						compwintersubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(compsummerstudent.get(studentID+its)!=null && (compsummerstudent.get(studentID+its)).equals(courseID))
					{
						compsummerstudent.remove(studentID+its);
						
						if(courseID.trim().substring(0, 4).equals("comp"))
						{
						int tt=compsummersubject.get(courseID)+1;
						compsummersubject.replace(courseID, tt);
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
	
	
	/*----------------------------------------------------------------------------------------------------------------------------------------------*----------------------------------------------------------------------------------------------------------------------------------------------
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	--------------------------------------------------------------------------------------------------------------------------------------------*----------------------------------------------------------------------------------------------------------------------------------------------
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	---------------------------------------
	--------------------------------------------------------------------------------------------------------------------------------------------*----------------------------------------------------------------------------------------------------------------------------------------------
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	---------------------------------------
	--------------------------------------------------------------------------------------------------------------------------------------------*----------------------------------------------------------------------------------------------------------------------------------------------
	------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  ----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------------
	---------------------------------------
	*/
		
	public static synchronized int checkmaxdep(String studentID, String  semester,String courseID)
	{
		ArrayList<String> arrli = new ArrayList<String>();
		count[0]=count[1]=count[2]=0;
		String h = studentID;

		for(int i=1;i<=3;i++)
		{
			Integer intInstance = new Integer(i);      
			
			arrli.add(compfallstudent.get(h+intInstance.toString()));
			arrli.add(compwinterstudent.get(h+intInstance.toString()));
			arrli.add(compsummerstudent.get(h+intInstance.toString()));
	
		}
 
		for (String str : arrli) {
			//System.out.println(str);
			if(str!=null)
			{
				if(str.substring(0,4).equals("comp"))
				{
					++count[0];
				}
				else if(str.substring(0,4).equals("soen"))
				{
					++count[1];
				}
				else if(str.substring(0,4).equals("inse"))
				{
					++count[2];
				}
			}
		}

		System.out.println(count[0]+" "+count[1]+" "+count[2]+"dep");
		arrli.clear();
		String tmp1 = courseID.substring(0, 4);
		System.out.println(tmp1);
		if(studentID.substring(0, 4).equals("comp"))
		{
		if(tmp1.equals("comp"))
		{
			return count[0];
		}else if(tmp1.equals("soen"))
		{
			return count[1];
		}else if(tmp1.equals("inse"))
		{
			return count[2];
		}
		}
		else if(studentID.substring(0, 4).equals("soen") || studentID.substring(0, 4).equals("inse"))
		{
			return count[0];
		}
		
		return 9;
	}
	
	
	
	public static synchronized int checkmaxterm(String studentID, String  semester)
	{
		ArrayList<String> arrli = new ArrayList<String>();
		count1[0]=count1[1]=count1[2]=0;
		String h = studentID;
		for(int i=1;i<=3;i++)
		{
			 
			
			arrli.add(compfallstudent.get(h+ Integer.toString(i)));
			
			for (String str : arrli) 
			{
				
				if(str!=null)
				{
					++count1[0];
				}
			}
			 arrli.clear();
			
			arrli.add(compwinterstudent.get(h+Integer.toString(i)));
			
			for (String str : arrli) 
			{
				if(str!=null)
				{
					++count1[1];
				}
			}
			 arrli.clear();
		
			arrli.add(compsummerstudent.get(h+Integer.toString(i)));
			
		    for (String str : arrli) 
			{
				if(str!=null)
				{
					++count1[2];
				}
			}
			 arrli.clear();
			
		}
		arrli.clear();
		System.out.println(count1[0]+" "+count1[1]+" "+count1[2]+"term");
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
			return count1[0];
		}
		else if(semester.trim().equals("winter"))
		{
			return count1[1];
		}else if(semester.trim().equals("summer"))
		{
			return count1[2];
		}
		
		return count1[0]+count1[1]+count1[2];
	}
	
	
	
	
	
	
	public static synchronized int checkavailibility(String courseID, String semester)
	{
		String tmp = courseID.substring(0, 4);	
		
		
			 if(semester.trim().equals("fall"))
			 {
				 int tmp1 = compfallsubject.get(courseID);
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
				 int tmp1 = compwintersubject.get(courseID);
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
				 int tmp1 = compsummersubject.get(courseID);
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
	
	
	public static synchronized String enrolCourse1(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
		
		int chk=9;
		int z,vv;
		String v;
		
		boolean v1;
		
		studentID.trim();
		courseID.trim();
		semester.trim();
	//	System.out.println(studentID+courseID+courseID);
		
			int flag1 = checkenroll(studentID, courseID/*,  semester*/);
			if(flag1==1)
			{
				chk=1;
			}
			else if(flag1==0)
			{
			
					
						if(semester.trim().equals("fall"))
						{
							
							for(int i=1;i<=3;i++)
							{
								String its = Integer.toString(i);
								
									v=compfallstudent.get(studentID+its);
									v1=compfallstudent.containsValue(studentID+its);
									if((v == null) && v1==false )
									{
										 
										compfallstudent.put(studentID+its,courseID);
										
										int hh=compfallsubject.get(courseID);
										hh=hh-1;
										compfallsubject.put(courseID, hh);

										
										System.out.println(compfallstudent.get(studentID+its));
										System.out.println((studentID+its)+"keyyyy "+getKeyFromValue(compfallstudent,courseID));
										System.out.println(compfallstudent);
										break ;
									}
							}
							
					}else if(semester.trim().equals("winter"))
					{
						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
							
							
							
								v=compwinterstudent.get(studentID+its);
								v1=compwinterstudent.containsValue(studentID+its);
								if((v == null) && v1==false )
								{
									compwinterstudent.put(studentID+its,courseID);
									
									int hh=compwintersubject.get(courseID);
									hh=hh-1;
									compwintersubject.put(courseID, hh);
									break ;
								}
							
		
						}
					
					}else if(semester.trim().equals("summer"))
					{
						
						for(int i=1;i<=3;i++)
						{
							String its = Integer.toString(i);
							
								v=compsummerstudent.get(studentID+its);
								v1=compsummerstudent.containsValue(studentID+its);
								if((v == null) && v1==false )
								{
									compsummerstudent.put(studentID+its,courseID);
									
									int hh=compsummersubject.get(courseID);
									hh=hh-1;
									compsummersubject.put(courseID, hh);
									
									break ;
								}
		
						}
					}
						chk=2;
					
				
			}
		
		
			 
			String path = null;	
			if(studentID.substring(0, 4).equals("comp"))
			{
				path="comp";
			}
			else if(studentID.substring(0, 4).equals("soen"))
			{
				path="soen";
			}else if(studentID.substring(0, 4).equals("inse"))
			{
				path="inse";
			}	
		
	
		
			
		if(chk==1)
		{
			
			return "You already enroll this subject in this term";
			
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


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 class sendMessage implements Runnable {
	
	    Thread t1;
	    public static DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    int serverPort;
	    String ss1,ss2;
	    String msg;
	    String sid,sem,method,courseid;
	    File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
	    BufferedWriter output0;
	   
	    
	  public  sendMessage(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	
	    	msg=null;
	    	 msg=ss2+":"+ss1+"^";
	    	 t1=new Thread(this);
	    }
	    
	    
	   
	    public sendMessage(int p, String studentID,String courseID, String sem, String methd) {
	    	
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
	    
public sendMessage(int p, String studentID,String courseID, String methd) {
	    	
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
				
				  System.out.println(msg);
				  
				  byte[] message = msg.getBytes();
				  InetAddress aHost = InetAddress.getByName("localhost");
				  DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
				  aSocket.send(request);
				  
				 
					
					try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(", Request message sent from the client to server with port number " + serverPort+" , ");
						output0.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				  System.out.println("Request message sent from the client to server with port number " + serverPort + " is: "
					+ new String(request.getData()));
				  
				  
				  
				  
				  
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
				  
				  
				  System.out.println("Reply received from the server with port number " + serverPort + " is: "
					+  new String(reply.getData()));
				 
				  String tmp = new String(reply.getData());
		
				  tmp=tmp.trim();
				
			   	String kept = tmp.substring(tmp.indexOf(":")+1,tmp.indexOf("@"));
			   	System.out.println("sub : "+tmp.substring(0,tmp.indexOf(":")));

			   	System.out.println(tmp+"---"+kept);
					 if(kept.trim().equals("methodlist"))
					 {
		
						 	
						 Server1.output += tmp.substring(0,tmp.indexOf(":"));
			
						 
					 }else if(kept.trim().equals("methodenroll"))
					 {
						 Server1.enrol = tmp.substring(0,tmp.indexOf(":"));
					
						 
					 }else if(kept.trim().equals("methoddrop"))
					 {
						 Server1.drop = tmp.substring(0,tmp.indexOf(":"));
					 }else if(kept.trim().equals("methodschedule"))
					 {
						 Server1.schedule.trim();
						 Server1.schedule += tmp.substring(0,tmp.length());
						 Server1.schedule.trim();
						 System.out.println("0000"+Server1.schedule);
						 
					 }else if(kept.trim().equals("methoddep"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server1.dep +=  Integer.parseInt(ha);
						 
					 }
					 else if(kept.trim().equals("methodterm"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server1.term +=  Integer.parseInt(ha);
						 
					 }
					 else if(kept.trim().equals("methodavail"))
					 {
						 
						String ha=tmp.substring(0,tmp.indexOf(":"));
						 Server1.avai =  Integer.parseInt(ha);
						 
					 }else if(kept.trim().equals("methodgetsem"))
					 {
						 Server1.getsem1=tmp.substring(0,tmp.indexOf(":"));
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

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 class receive implements Runnable {
	 
	 public static DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
	    BufferedWriter output0;
	 Thread t2;
	    int serverPort;
	    
	    receive()
	    {
	    	//serverPort=p;
	    	t2=new Thread(this);
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
			 try {
				 aSocket = new DatagramSocket(8000);
				 
				 String kept2 = null; 
				 System.out.println("Server 8000 Started............");
				 while (true) {
					 byte[] buffer = new byte[1000];
					 byte[] message = new byte[1000];
				
					 message=null;
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
					
					
					 System.out.println(msg1);
					msg1.trim();	
					 
					 
					 
					 String kept = msg1.substring( 0, msg1.indexOf(":"));
					 if(kept.equals("methodlist"))
					 {
						 kept2=null;
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
						
						 
						  kept2=server1methods.listCourseAvailabilityserver1(kept1);
					
						  kept2=kept2+":methodlist@";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 kept2=null;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
						
						 kept2=server1methods.enrolCourse1(stuid,corid,seme);
						  System.out.println(kept2.length()+"00");
						 kept2=kept2+":methodenroll@";
						  System.out.println(kept2.length()+"11");
						 kept2.trim();
						 message  = kept2.getBytes(); 
						 System.out.println(message.length);
					 }else if(kept.equals("methoddrop"))
					 {
						 kept2=null;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
					
						 kept2=server1methods.dropCourses1(stuid,corid); 
						 
						 kept2=kept2+":methoddrop@";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodschedule"))  
					 {
						 kept2=null;
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("^"));
							
						 
						  kept2=server1methods.getClassSchedules1(kept1);
					
						  kept2=kept2+":methodschedule@";
						  message  = kept2.getBytes(); 
					 }else if(kept.equals("methoddep"))
					 {
						 int k;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.indexOf("^"));
						 stuid.trim();  corid.trim(); seme.trim();
						 k=server1methods.checkmaxdep(stuid, seme,corid);
						 kept2=k+":methoddep@";
						  message  = kept2.getBytes();
					 }
					 else if(kept.equals("methodterm"))
					 {
						 int k;
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 stuid.trim();  seme.trim();
						 k=server1methods.checkmaxterm(stuid, seme);
						 kept2=k+":methodterm@";
						  message  = kept2.getBytes();
					 }else if(kept.equals("methodavail"))
					 {
						 kept2=null;
						 String corid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String seme = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						// System.out.println("###"+stuid+corid+seme+"###");
					
						 int ava=server1methods.checkavailibility(corid,seme); 
						 
						 kept2=ava+":methodavail@";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }else if(kept.equals("methodgetsem"))
					 {
						 kept2=null;
						 String sid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String cid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("^"));
						 kept2=server1methods.getHash(sid, cid);
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
			t2.start ();
		}
	
}



  	//-----------------______________________________------------------------------_________________________


public class Server1 {

	 public static String output,enrol,drop,schedule,getsem1;
	 public static int dep,term,avai;
	 public static DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
	 public Server1()
	 {
		 output=" ";
		 enrol=" ";
		 drop=" ";
		 schedule=" ";
		 dep=0;
		 term=0;
		 avai=0;
		 getsem1=null;
	 }
	
	 
	 
	 
	 
	 public synchronized String getClassSchedules1(String studentID)
	 {
		 
		 String list="";
		 schedule.trim();
		 String s2=server1methods.getClassSchedules1(studentID);
		
		 sendMessage R2 = new sendMessage(8001,studentID,"methodschedule"); // methodenroll , methoddrop , methodschedule 
	      R2.start();
	      sendMessage R3 = new sendMessage(8002,studentID,"methodschedule");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
	     
	     
	     System.out.println("--"+schedule);
	   
		 list="fall - "+s2.substring(0,s2.indexOf("*"))+" "+schedule.substring(0, schedule.indexOf("*"))+" ";   // schedule
		 int tmp=schedule.indexOf("*");
		 list=list+schedule.substring(schedule.indexOf("@")+1, schedule.indexOf("*",tmp+1));
		 
		 list=list+"\nwinter - "+s2.substring(s2.indexOf("*")+1,s2.indexOf("#"))+" "+schedule.substring(schedule.indexOf("*")+1,schedule.indexOf("#"))+" ";   // schedule
		 int one=schedule.indexOf("*");
		int two=schedule.indexOf("#");
		 list=list+schedule.substring(schedule.indexOf("*",one+1)+1,schedule.indexOf("#",two+1));
	     
		 list=list+"\nsummer - "+s2.substring(s2.indexOf("#")+1,s2.length()-1)+" "+schedule.substring(schedule.indexOf("#")+1,schedule.indexOf("$"))+" ";   // schedule
		    int one1=schedule.indexOf("#");
			int two1=schedule.indexOf("$");
		 list=list+schedule.substring(schedule.indexOf("#",one1+1)+1,schedule.indexOf("$",two1+1));
	     list.trim();
	     
		 
		 return list;
	 }
	 
	 
	 
	 
	 
	
	public synchronized String  listCourseAvailabilitys1send(String semester)
	{
		String list="";
		File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
		BufferedWriter output0;
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,listCourseAvailability request to server2 (SOEN) & server 3(INSE), ");
			output0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String s2=server1methods.listCourseAvailabilityserver1(semester);
		
		  sendMessage R2 = new sendMessage(8001,semester,"methodlist"); // methodenroll , methoddrop , methodschedule 
	      R2.start();
	      sendMessage R3 = new sendMessage(8002,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     list=s2+output;
	      return list;
	} 
	
	
	
	
	
	
	
	
	
	public String enrolCourseserver(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub

		
		
		sendMessage R2 = new sendMessage(8001,studentID,courseID,semester,"methoddep");

		 R2.start();
		sendMessage R3 = new sendMessage(8002,studentID,courseID,semester,"methoddep");

		 R3.start();
		
	      
	      try {
				R2.t1.join();
				R3.t1.join();
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
	      
	      
	      sendMessage R4 = new sendMessage(8001,studentID,semester,"methodterm");
			 R4.start();
			sendMessage R5 = new sendMessage(8002,studentID,semester,"methodterm");
			 R5.start();
			
		      
		      try {
					R4.t1.join();
					R5.t1.join();
				} catch (Exception e) {}
		
		        System.out.println(" -> "+dep+" "+term);
				int dept=server1methods.checkmaxdep(studentID, semester, courseID);
				int termt=server1methods.checkmaxterm(studentID, semester);
				
				term=term+termt;
				System.out.println("<- "+dept+" "+termt);
				System.out.println("<-> "+dep+" "+term);
				
	//	if(dep<2 && term<3)
	//	{
		if((courseID.substring(0, 4)).equals("comp"))
		{
			if(term<3)
			{
			int flag2 = server1methods.checkavailibility(courseID,  semester);
			if(flag2==1)
			{
			String drop1=server1methods.enrolCourse1(studentID, courseID,semester);
			   return drop1;
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
		else if((courseID.substring(0, 4)).equals("soen"))
		{
			
		if(dep<2 && term<3)
		{
	    sendMessage R0 = new sendMessage(8001,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
			
		      R0.start();
		      
		      try {
					R0.t1.join(); 
				} catch (Exception e) {		}

		      System.out.println("[[[[[[[[ "+ Server1.avai);	
		
		 if(Server1.avai==1)
		 {
		sendMessage R6 = new sendMessage(8001,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
		
		File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
		BufferedWriter output0;
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
			      return enrol;
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
		}else if((courseID.substring(0, 4)).equals("inse"))
		{
			if(dep<2 && term<3)
			{
			 sendMessage R0 = new sendMessage(8002,courseID,semester,"methodavail"); // methodenroll , methoddrop , methodschedule
				
		      R0.start();
		      
		      try {
					R0.t1.join(); 
				     
				} catch (Exception e) {		}
			
			
		      System.out.println("[[[[[[[[ "+ Server1.avai);
		
		     if(Server1.avai==1)
		     {
	      sendMessage R7 = new sendMessage(8002,studentID,courseID,semester,"methodenroll");
	      
	      
	      File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
			BufferedWriter output0;
			try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server3 (INSE) , ");
				output0.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      
	      R7.start();
	      
	      try {
				R7.t1.join();
				  return enrol;
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
		
		
		return enrol;
	     
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String dropCourseserver(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("comp"))
		{
			
			String drop1=server1methods.dropCourses1(studentID, courseID);
			System.out.println(drop1);
			   return drop1;
		}
		else if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage R2 = new sendMessage(8001,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	      
		
		File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
		BufferedWriter output0;
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
			
			      return drop;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage R2 = new sendMessage(8002,studentID,courseID,"methoddrop");
	      
	      File f0 = new File("C:/Users/hp-pc/eclipse-workspace/Ass2/src/comp/Server1.txt");
			BufferedWriter output0;
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
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop;
	      
		}
		return drop;
	     
		
	}


//	public synchronized String  listCourseAvailabilitys1get()
//	{
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	} 
	
	
	
	
	
public String addCourseserver(String courseID, String semester,int capa ,String userid ) {
		
		String h;
	
		h=server1methods.addCourse1( courseID,  semester, capa , userid );
		//System.out.println("   "+server1methods.compsummer);
		return h;
}
	
public String removeCourseserver(String courseID, String semester ) {
	
	String h=null;
	int h1;
	h1=server1methods.removeCourse1( courseID,  semester );
	System.out.println(server1methods.compfall);
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
	
	











public String swapCourse1(String studentID,String newCourseID,String oldCourseID)
{
	String sem1,drop1,drop2,en1=null;
	if((newCourseID.substring(0, 4)).equals("comp") && (oldCourseID.substring(0, 4)).equals("comp"))
	{
		 sem1= server1methods.getHash(studentID, oldCourseID);
		 drop1=server1methods.dropCourses1(studentID, oldCourseID);
		 en1= server1methods.enrolCourse1(studentID, newCourseID, sem1);
		if(!(en1.equals(studentID+"is successfully enrolled in "+ newCourseID)))
		{
			 en1= server1methods.enrolCourse1(studentID, oldCourseID, sem1);
			 en1="you cant swap with "+newCourseID;
		}
		System.out.println(drop1);
		   return en1;
	}else if((newCourseID.substring(0, 4))!="comp" && (oldCourseID.substring(0, 4)).equals("comp"))
	{
		 
		 sem1= server1methods.getHash(studentID, oldCourseID);
		 drop1=server1methods.dropCourses1(studentID, oldCourseID);
		 en1= enrolCourseserver(studentID, newCourseID, sem1);
		 en1=en1.trim();
		 if(!(en1.equals(studentID+"is successfully enrolled in "+ newCourseID)))
			{
				 en1= server1methods.enrolCourse1(studentID, oldCourseID, sem1);
				 en1="you cant swap with "+newCourseID;
			}
			System.out.println(drop1);
			   return en1;
	}else if((oldCourseID.substring(0, 4))!="comp" && (newCourseID.substring(0, 4)).equals("comp"))
	{
		drop2=oldCourseID;
		if((oldCourseID.substring(0, 4)).equals("soen"))
		{
		sendMessage R2 = new sendMessage(8001,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
		R2.start();
	      try {
				R2.t1.join(); 
			} catch (Exception e) {	}
		}else if((oldCourseID.substring(0, 4)).equals("inse"))
		{
			sendMessage R2 = new sendMessage(8002,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R2.start();
		      try {
					R2.t1.join(); 
			
		      } catch (Exception e) {	}
		}
		sem1=getsem1;
		drop1=dropCourseserver(studentID,oldCourseID);
		if((drop1.equals(studentID+" is successfully drop in "+oldCourseID)))
		{
			System.out.println("7777777");
			 en1= server1methods.enrolCourse1(studentID, newCourseID, sem1);
		}
		System.out.println(en1);
		en1=en1.trim();
		if(!(en1.equals(studentID+"is successfully enrolled in "+ newCourseID)))
		{
			 en1= enrolCourseserver(studentID, oldCourseID, sem1);
			 en1="you cant swap with "+newCourseID;
		}
		return en1;
	}else if((oldCourseID.substring(0, 4))!="comp" && (newCourseID.substring(0, 4))!="comp")
	{
		
		if((oldCourseID.substring(0, 4)).equals("soen"))
		{
			sendMessage R2 = new sendMessage(8001,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R2.start();
		      try {
					R2.t1.join(); 
				} catch (Exception e) {	}
		}else if((oldCourseID.substring(0, 4)).equals("inse"))
		{
			sendMessage R2 = new sendMessage(8002,studentID,oldCourseID,"methodgetsem"); // methodenroll , methoddrop , methodschedule
			R2.start();
		      try {
					R2.t1.join(); 
				} catch (Exception e) {	}
			
		}
			System.out.println("gettt sem = "+getsem1);
		        sem1=getsem1.trim();
		        
				drop1=dropCourseserver(studentID,oldCourseID);
				
				 en1= enrolCourseserver(studentID, newCourseID, sem1);
				
				en1=en1.trim();
				if(!(en1.equals(studentID+"is successfully enrolled in "+ newCourseID)))
				{
					 en1= enrolCourseserver(studentID, oldCourseID, sem1);
					 en1="you cant swap with "+newCourseID;
					 
				}
				return en1;	
	}
	return en1;
	
}
	
	
	
	
	
	public static void main(String args[]) {
	
		server1methods s1 = new server1methods();
		receive R1 = new receive();
	      R1.start();
	      
		//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
		
		//ImpInterFace stub = new ImpInterFace();
//		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
//		BufferedWriter output0 =new BufferedWriter(new FileWriter(f0,true));
//		Date date1 = new Date();
//		output0.write(sdfs1.format(date1)+"  ,"+"COMP Server is running now...");
//		output0.close();
		ORB orb = ORB.init(args, null);
		 try{
		      // create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager
		           
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();
		 
		      // create servant and register it with the ORB
		      ImpInterFace obj1 = new ImpInterFace();
		     // obj1.setORB(orb); 
		 
		      // get object reference from the servant
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj1);
		      InterFace2 href = InterFace2Helper.narrow(ref);
		 
		      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		 
		      NameComponent path[] = ncRef.to_name( "COMP" );
		      ncRef.rebind(path, href);
		 
		      System.out.println("COMP Server ready and waiting ...");
		 
		      // wait for invocations from clients
		   
			  orb.run();
		     
		      
		      
		    } 
		 
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		      }
		
		      System.out.println("COMP Server Exiting ...");
			  
		     
		
	}


	
} 



