# Distributed-Course-Registration-System-using-CORBA
There are 3 departments: Computer Science(COMP), Software Engineering(SOEN) and Information & Security(INSE), with respected servers Server1, Server2 and Server3.

**Advisor Role:** The operations that can be performed by an advisor are the following: 

• *addCourse (courseID, semester):* When an advisor invokes this method through the server associated with this advisor(determined by the unique advisorID prefix), attempts to add a course with the information passed, and inserts the record.The server returns information to the advisor whether the operation was successful or not and both the server and the client store this information in their logs. If a course already exists in a semester, the advisor can’t add it again in the same semester. If a course does not exist in the database in that semester, then added. Information is stored in the log file.

• *removeCourse (courseID, semester):* When invoked by an advisor, the server associated with that advisor (determined by the unique advisorID) searches in the hashmap to find and delete the course for the indicated semester. Upon success or failure it returns a message to the advisor and the logs are updated with this information. If a course does not exist, then obviously there is no deletion performed. Just in case that, if a course exists and a student is enrolled into that course, then, the course is deleted and take the necessary actions.

• *listCourseAvailability (semester):* When an advisor invokes this method from his/her department through the associated server, that department server concurrently finds out the number of spaces available for each course in all the servers, for only the given semester. This requires inter server communication that will be done using UDP/IP sockets and result will be returned to the student. Eg: Fall - COMP6231 5, SOEN6441 4, SOEN6497 0, INSE6132 5.

**Student Role:** The operations that can be performed by a student are the following: 

• *enrolCourse (studentID, courseID, semester):* When a student invokes this method from his/her department through the server associated with this student (determined by the unique studentID prefix) attempts to enroll the student in that course and change the capacity left in that course. Also if the enrolment was successful or not, an appropriate message is displayed to the student and both the server and the client stores this information in their logs.

• *getClassSchedule (studentID):* When a student invokes this method from his/her department through the server associated with this student, that department server gets all the courses enrolled by the student and display them on the console.

• *dropCourse (studentID, courseID):* When a student invokes this method from his/her department through the server associated with this student (determined by the unique studentID prefix) searches the hash map to find the courseID and drops the course. Upon success or failure it returns a message to the student and the logs are updated with this information.

• *swapCourse (studentID, newCourseID, oldCourseID):* A student might invoke this operation to change a course he/she is already registered in with another course in any department. In this case, the current_department_server (which receives the request from the student) first checks whether the student has registered in the old course, then checks with the new_department_server (on which the new course has to be enrolled) whether there is available space in the new course, and if both checks are successful then atomically enroll the student in the new course and drop the old course.

**Constraints:**

1. A student has access to following methods only: a) enrollCourse b) dropCourse c) getClassSchedule
2. A professor has access to following methods including the one above: a) addCourse b) removeCourse                           c) ListCourseAvailability d) swapCourse
3. The professor can't add student in other department.
4. The profeccor can't add and remove cousre of other department.
5. The student can only take upto 3 courses per semester(Fall, Winter and Summer).
6. A student can't take more than 2 courses of other department throughout completion of study.
7. The student have ID like department code+S+unique number. For instance, COMPS001 for COMP student.
8. The advisor have ID like department code+A+unique number. For instance, COMPA001 for COMP student.


**To run using eclipse:**

  1. add idlej.exe from 'run configuration->external tools configuration->new program' and set -working directory:${project_loc}/src -arguments: -fall ${resource_loc} -fall command will generate all the files for execution. First, run without -fall command until no changes are required to your code or there's no error.
  
  2. add orbd.exe same as idlej.exe and set -arguments: orbd -ORBInitialPort 1050
  
  3. run idlej first if you don't have necessary files
  
  4. run orbd
  
  5. run each server first with argument:-ORBInitialPort 1050 -ORBInitialHost localhost
  
  6. run client with same argument as server.
  
  7. Add ID to continue: 7.1 must enter following IDs to continue as a course advisor
    COMP advisor(COMPA1)
    SOEN advisor(SOENA1)
    INSE advisor(INSEA1)
