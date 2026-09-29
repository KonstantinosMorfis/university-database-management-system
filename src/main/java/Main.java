
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main{
public static void main(String[] args) throws SQLException {
	Connection conn = null;
	String host = System.getenv().getOrDefault("DB_HOST", "localhost");
	String dbName = System.getenv().getOrDefault("DB_NAME", "ergasia_1");
	String userName = System.getenv().getOrDefault("DB_USER", "app");
	String password = System.getenv().getOrDefault("DB_PASSWORD", "");
	String url = "jdbc:mysql://" + host + ":3306/" + dbName
		+ "?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, userName, password);
	} catch (Exception e) {
		System.err.println("Cannot connect to MySQL: " + e.getMessage());
		return;
	}

	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	
	Statement st = conn.createStatement();
	
	System.out.println("Welcome To Univeristy XYZ DataBase!!!");
	
	int input = -1;
	
	String i1 = "";
	String i2 = "";
	String i3 = "";
	String i4 = "";
	String i5 = "";
	String i6 = "";
	String i7 = "";
	
	while(input != 0) {
		System.out.println("0) Exit\n1) Insert\n2) Update\n3) Delete\n4) View\n5) Project Answers");
		System.out.println("Enter number:");
	
		try {
            input = sc.nextInt();
        }
        catch(Exception e) {
          break;
        }
			if (input == 0){
				conn.close();
				System.out.println("Disconnected from database");
			}
			//INSERT
			else if (input == 1){
				System.out.println("**************************");
				System.out.println("What Do You Want To Insert:");
				System.out.println("1) Association\n2) Campus\n3) Department\n4) University School\n"
						+ "5) Commission\n6) Instructor\n7) Supervisor\n8) Course Of Study\n9) Course\n10) University Student \n11) Required Course \n12) Student Information for a Specific Course \n13) Back");
				System.out.println("**************************");
				System.out.println("Enter number:");
				input = sc.nextInt();
				
				if(input == 1) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Association Name: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Building: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Phone Number: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Sports Count: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Sports Name: ");
					i5 = sc1.nextLine();
					
					System.out.println("Enter Campus Name: ");
					i6 = sc1.nextLine();
					
					
					
					String query = "INSERT INTO `association`(`association_name`, `building`, `phone_number`, `sports_count`, `sports_name`, `campus_campus_name`) VALUES (?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.setString (6, i6);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
										
				}
				else if(input == 2) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Campus Name: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Address: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Distance From Center: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Bus Number: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Association Name: ");
					i5 = sc1.nextLine();
					
				
					
					String query = "INSERT INTO `campus`(`campus_name`, `address`, `distance_from_center`, `bus_number`, `association_association_name`) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				
				else if(input == 3) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Department Name: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Department Building: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Campus Name: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter University School: ");
					i4 = sc1.nextLine();
					
				
					
					String query = "INSERT INTO `department`(`department_name`, `building`, `campus_campus_name`, `university_school_university_school_name`) VALUES (?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				else if(input == 4) {				
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter University School Name: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Provost: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter University School Building: ");
					i3 = sc1.nextLine();
					
									
					
					String query = "INSERT INTO `university_school`(`university_school_name`, `provost`, `building`) VALUES (?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3); 
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				
				else if(input == 5) {				
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Commission Title: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter University School: ");
					i2 = sc1.nextLine();
					
									
					
					String query = "INSERT INTO `commission`(`commission_title`, `university_school_university_school_name`) VALUES (?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				
				else if(input == 6) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Instructor Identifier: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Instructor Fullname: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Instructor Title: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Instructor Office Number: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Department Name: ");
					i5 = sc1.nextLine();
					
					System.out.println("Enter Supervisor Identifier: ");
					i6 = sc1.nextLine();
					
					
					
					String query = "INSERT INTO `instructor`(`instructor_identifier`, `instructor_fullname`, `title`, `office_number`, `department_department_name`, `supervisor_supervisor_identifier`) VALUES (?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.setString (6, i6);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
										
				}
				else if(input == 7) {				
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Supervisor Identifier: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Supervisor Fullname: ");
					i2 = sc1.nextLine();
					
									
					
					String query = "INSERT INTO `supervisor`(`supervisor_identifier`, `supervisor_fullname`) VALUES (?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				else if(input == 8) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Unique Course Of Study Code: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Course Of Study Title: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Tier: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Duration Of Studies: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Undergraduate Schedule: ");
					i5 = sc1.nextLine();
					
					System.out.println("Enter Post Graduate Schedule: ");
					i6 = sc1.nextLine();
					
					System.out.println("Enter Department Name: ");
					i7 = sc1.nextLine();
					
					
					
					String query = "INSERT INTO `course_of_study`(`unique_course_of_study_code`, `course_of_study_title`, `tier`, `duration_of_studies`, `undergraduate_schedule`, `post_graduate_schedule`, `department_department_name`) VALUES (?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.setString (6, i6);
					preparedStmt.setString (7, i7);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
										
				}
				else if(input == 9) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Unique Course Code: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Course Title: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Core Course: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Elective Course: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Unique Course Of Study Code: ");
					i5 = sc1.nextLine();
					
				
					
					String query = "INSERT INTO `course`(`unique_course_code`, `course_title`, `core_course`, `elective_course`, `course_of_study_unique_course_of_study_code`) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				else if(input == 10) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Registration Number: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter University Student Fullname: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Father's Name: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Date Of Birth: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Year Of Registration: ");
					i5 = sc1.nextLine();
					
					System.out.println("Enter Unique Course Of Study Code: ");
					i6 = sc1.nextLine();
					
					
					
					String query = "INSERT INTO `university_student`(`registration_number`, `university_student_fullname`, `fathers_name`, `date_of_birth`, `year_of_registration`, `course_of_study_unique_course_of_study_code`) VALUES (?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.setString (6, i6);
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
										
				}
				else if(input == 11) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter Unique Required Course Code: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Unique Course Code: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Required Course Title: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Required Core Course: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Required Elective Course: ");
					i5 = sc1.nextLine();
					
				
					
					String query = "INSERT INTO `required_course`(`unique_required_course_code`, `course_unique_course_code`, `required_course_title`, `required_core_course`, `required_elective_course`) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				else if(input == 12) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");
					System.out.println("Enter University Student Registration Number: ");
					i1 = sc1.nextLine();
					
					System.out.println("Enter Unique Course Code: ");
					i2 = sc1.nextLine();
					
					System.out.println("Enter Course Grade: ");
					i3 = sc1.nextLine();
					
					System.out.println("Enter Course Year Of Attendance: ");
					i4 = sc1.nextLine();
					
					System.out.println("Enter Course Year Of Declaration: ");
					i5 = sc1.nextLine();
					
				
					
					String query = "INSERT INTO `university_student_course`(`university_student_registration_number`, `course_unique_course_code`, `grade`, `year_of_attendance`, `year_of_declaration`) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
					preparedStmt.setString (1, i1);
					preparedStmt.setString (2, i2);
					preparedStmt.setString (3, i3);
					preparedStmt.setString (4, i4);
					preparedStmt.setString (5, i5); 
					preparedStmt.executeUpdate();
															
					System.out.println("1 row affected");
				}
				
								
			}
			
			//UPDATE
			else if (input == 2){
				String answer = ""; 
				System.out.println("**************************");
				System.out.println("What Do You Want To Update:");
				System.out.println("1) Association\n2) Campus\n3) Department\n4) University School\n"
						+ "5) Commission\n6) Instructor\n7) Supervisor\n8) Course Of Study\n9) Course\n10) University Student \n11) Required Course \n12) Student Information for a Specific Course \n13) Back");
				System.out.println("**************************");
				System.out.println("Enter number:");
				input = sc.nextInt();
				
				if(input == 1) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT association_name FROM association");
                    System.out.println("**************************");
                    System.out.println("Association Name: ");
                    while (res.next()) {
                          String i = res.getString("association_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Association Do You Want to Update? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT association_name FROM association");
                    while (res.next()) {     
                        String i = res.getString("association_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    if(flag == 1) {
                        System.out.println("Enter Association Name: ");
                        i1 = sc1.nextLine();

                        System.out.println("Enter Building: ");
                        i2 = sc1.nextLine();

                        System.out.println("Enter Phone Number: ");
                        i3 = sc1.nextLine();

                        System.out.println("Enter Sports Count: ");                              
                        i4 = sc1.nextLine();

                        System.out.println("Enter Sports Name: ");
                        i5 = sc1.nextLine();

                        System.out.println("Enter Campus Name: ");
                        i6 = sc1.nextLine();
                        
                        String query = "UPDATE association SET association_name=?,building=?,phone_number=?,sports_count=?,sports_name=?,campus_campus_name=? WHERE association_name = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, i3);
                        preparedStmt.setString (4, i4);
                        preparedStmt.setString (5, i5); 
                        preparedStmt.setString (6, i6);
                        preparedStmt.setString (7, answer);
                        preparedStmt.executeUpdate();
                        System.out.println("1 row affected"); 
                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
										
				}
				else if(input == 2) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT campus_name FROM campus");                    
                    System.out.println("**************************");
                    System.out.println("Campus Name: ");                  
                    while (res.next()) {
                          String i = res.getString("campus_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Campus Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT campus_name FROM campus");
                    while (res.next()) {     
                        String i = res.getString("campus_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	 System.out.println("Enter Campus Name: ");
                         i1 = sc1.nextLine();

                         System.out.println("Enter Address: ");
                         i2 = sc1.nextLine();

                         System.out.println("Enter Distance From Center: ");
                         i3 = sc1.nextLine();

                         System.out.println("Enter Bus Number: ");
                         i4 = sc1.nextLine();

                         System.out.println("Enter Association Name: ");
                         i5 = sc1.nextLine();

                         String query = "UPDATE `campus` SET `campus_name`=?,`address`=?,`distance_from_center`=?,`bus_number`=?,`association_association_name`=?  WHERE `campus_name`= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, i4);
                         preparedStmt.setString (5, i5); 
                         preparedStmt.setString (6, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 3) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT department_name FROM department");                    
                    System.out.println("**************************");
                    System.out.println("Department Name: ");                  
                    while (res.next()) {
                          String i = res.getString("department_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Department Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT department_name FROM department");
                    while (res.next()) {     
                        String i = res.getString("department_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	System.out.println("Enter Department Name: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter Department Building: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter Campus Name: ");
    					i3 = sc1.nextLine();
    					
    					System.out.println("Enter University School: ");
    					i4 = sc1.nextLine();
    					
                         String query = "UPDATE `department` SET `department_name`=?,`building`=?,`campus_campus_name`=?,`university_school_university_school_name`=?  WHERE `department_name`= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, i4);
                         preparedStmt.setString (5, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 4) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT university_school_name FROM university_school");                    
                    System.out.println("**************************");
                    System.out.println("University School Name: ");                  
                    while (res.next()) {
                          String i = res.getString("university_school_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which University School Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT university_school_name FROM university_school");
                    while (res.next()) {     
                        String i = res.getString("university_school_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	System.out.println("Enter University School Name: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter Provost: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter University School Building: ");
    					i3 = sc1.nextLine();
    					
                         String query = "UPDATE `university_school` SET `university_school_name`=?,`provost`=?,`building`=? WHERE `university_school_name`= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 5) {            
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT commission_title FROM commission");
                    System.out.println("***************************");
                    System.out.println("Commission Title : ");
                    while (res.next()) {
                          String i = res.getString("commission_title");
                          System.out.println(i);
                    }
                    System.out.println("***************************");

                    System.out.println("Which Commission Do You Want To Update? ");
                    answer = sc1.nextLine();
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT commission_title FROM commission");
                    while (res.next()) {     
                        String i = res.getString("commission_title");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    
                    if (flag ==1) {
                        st.execute("SET FOREIGN_KEY_CHECKS=0");
                        System.out.println("Enter Commission Title: ");
                        i1 = sc1.nextLine();
                        
                        System.out.println("Enter University School: ");
                        i2 = sc1.nextLine();
                                        
                        
                        String query = "UPDATE `commission` SET `commission_title`= ?,`university_school_university_school_name`= ? WHERE commission_title= ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, answer);
                        preparedStmt.executeUpdate();
                                                                
                        System.out.println("1 row affected");
                    }
                    else {
                        System.out.println("Wrong Input!!"); 

                    }
                }
				
				else if(input == 6) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT instructor_identifier FROM instructor");                    
                    System.out.println("**************************");
                    System.out.println("Instructor Identifier: ");                  
                    while (res.next()) {
                          String i = res.getString("instructor_identifier");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Instructor Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT instructor_identifier FROM instructor");
                    while (res.next()) {     
                        String i = res.getString("instructor_identifier");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	System.out.println("Enter Instructor Identifier: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter Instructor Fullname: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter Instructor Title: ");
    					i3 = sc1.nextLine();
    					
    					System.out.println("Enter Instructor Office Number: ");
    					i4 = sc1.nextLine();
    					
    					System.out.println("Enter Department Name: ");
    					i5 = sc1.nextLine();
    					
    					System.out.println("Enter Supervisor Identifier: ");
    					i6 = sc1.nextLine();
    					
                         String query = "UPDATE `instructor` SET `instructor_identifier`=?,`instructor_fullname`=?,`title`=?,`office_number`=?,`department_department_name`=?,`supervisor_supervisor_identifier`=? WHERE instructor_identifier= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, i4);
                         preparedStmt.setString (5, i5);
                         preparedStmt.setString (6, i6);
                         preparedStmt.setString (7, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 7) {    
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT supervisor_identifier FROM supervisor");
                    System.out.println("***************************");
                    System.out.println("Supervisor Name: ");
                    while (res.next()) {
                          String i = res.getString("supervisor_identifier");
                          System.out.println(i);
                    }
                    System.out.println("***************************");

                    System.out.println("Which Supervisor Do You Want To Update? ");
                    answer = sc1.nextLine();
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT supervisor_identifier FROM supervisor");
                    while (res.next()) {     
                        String i = res.getString("supervisor_identifier");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    if(flag==1) {
                        st.execute("SET FOREIGN_KEY_CHECKS=0");
                        System.out.println("Enter Supervisor Identifier: ");
                        i1 = sc1.nextLine();
                        
                        System.out.println("Enter Supervisor Fullname: ");
                        i2 = sc1.nextLine();
                        
                                        
                        
                        String query = "UPDATE `supervisor` SET `supervisor_identifier`=?,`supervisor_fullname`=? WHERE supervisor_identifier = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, answer);
                        preparedStmt.executeUpdate();
                                                                
                        System.out.println("1 row affected");
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    }
                    
                }
				
				else if(input == 8) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_course_of_study_code FROM course_of_study");                    
                    System.out.println("**************************");
                    System.out.println("Unique Course Of Study Code: ");                  
                    while (res.next()) {
                          String i = res.getString("unique_course_of_study_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Course Of Study Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT unique_course_of_study_code FROM course_of_study");
                    while (res.next()) {     
                        String i = res.getString("unique_course_of_study_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	System.out.println("Enter Unique Course Of Study Code: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter Course Of Study Title: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter Tier: ");
    					i3 = sc1.nextLine();
    					
    					System.out.println("Enter Duration Of Studies: ");
    					i4 = sc1.nextLine();
    					
    					System.out.println("Enter Undergraduate Schedule: ");
    					i5 = sc1.nextLine();
    					
    					System.out.println("Enter Post Graduate Schedule: ");
    					i6 = sc1.nextLine();
    					
    					System.out.println("Enter Department Name: ");
    					i7 = sc1.nextLine();
                    	
                         String query = "UPDATE `course_of_study` SET `unique_course_of_study_code`=?,`course_of_study_title`=?,`tier`=?,`duration_of_studies`=?,`undergraduate_schedule`=?,`post_graduate_schedule`=?,`department_department_name`=? WHERE unique_course_of_study_code= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, i4);
                         preparedStmt.setString (5, i5);
                         preparedStmt.setString (6, i6);
                         preparedStmt.setString (7, i7);
                         preparedStmt.setString (8, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 9) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_course_code FROM course");                    
                    System.out.println("**************************");
                    System.out.println("Course: ");                  
                    while (res.next()) {
                          String i = res.getString("unique_course_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Course Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT unique_course_code FROM course");
                    while (res.next()) {     
                        String i = res.getString("unique_course_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    
                    if(flag ==1) {
                        st.execute("SET FOREIGN_KEY_CHECKS=0");
                        System.out.println("Enter Unique Course Code: ");
                        i1 = sc1.nextLine();
                        
                        System.out.println("Enter Course Title: ");
                        i2 = sc1.nextLine();
                        
                        System.out.println("Enter Core Course: ");
                        i3 = sc1.nextLine();
                        
                        System.out.println("Enter Elective Course: ");
                        i4 = sc1.nextLine();
                        
                        System.out.println("Enter Unique Course Of Study Code: ");
                        i5 = sc1.nextLine();
                        
                    
                        
                        String query = "UPDATE `course` SET `unique_course_code`=?,`course_title`=?,`core_course`=?,`elective_course`=?,`course_of_study_unique_course_of_study_code`=? WHERE unique_course_code = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, i3);
                        preparedStmt.setString (4, i4);
                        preparedStmt.setString (5, i5); 
                        preparedStmt.setString (6, answer);
                        preparedStmt.executeUpdate();
                                                                
                        System.out.println("1 row affected");
                        
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                   } 
                    
                }
				
				else if(input == 10) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT registration_number FROM university_student");                    
                    System.out.println("**************************");
                    System.out.println("Registration Number: ");                  
                    while (res.next()) {
                          String i = res.getString("registration_number");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which University Student Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT registration_number FROM university_student");
                    while (res.next()) {     
                        String i = res.getString("registration_number");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	System.out.println("Enter Registration Number: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter University Student Fullname: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter Father's Name: ");
    					i3 = sc1.nextLine();
    					
    					System.out.println("Enter Date Of Birth: ");
    					i4 = sc1.nextLine();
    					
    					System.out.println("Enter Year Of Registration: ");
    					i5 = sc1.nextLine();
    					
    					System.out.println("Enter Unique Course Of Study Code: ");
    					i6 = sc1.nextLine();
                    	
                         String query = "UPDATE `university_student` SET `registration_number`=?,`university_student_fullname`=?,`fathers_name`=?,`date_of_birth`=?,`year_of_registration`=?,`course_of_study_unique_course_of_study_code`=? WHERE registration_number= ?";
                         PreparedStatement preparedStmt = conn.prepareStatement(query);
                         preparedStmt.setString (1, i1);
                         preparedStmt.setString (2, i2);
                         preparedStmt.setString (3, i3);
                         preparedStmt.setString (4, i4);
                         preparedStmt.setString (5, i5);
                         preparedStmt.setString (6, i6);
                         preparedStmt.setString (7, answer);
                         preparedStmt.executeUpdate();

                         System.out.println("1 row affected");    
                    
										
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				else if(input == 11) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_required_course_code FROM required_course");                    
                    System.out.println("**************************");
                    System.out.println("Required Course: ");                  
                    while (res.next()) {
                          String i = res.getString("unique_required_course_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Required Course Do You Want To Update? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT unique_required_course_code FROM required_course");
                    while (res.next()) {     
                        String i = res.getString("unique_required_course_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag==1) {
                        st.execute("SET FOREIGN_KEY_CHECKS=0");
                        System.out.println("Enter Unique Required Course Code: ");
                        i1 = sc1.nextLine();
                        
                        System.out.println("Enter Unique Course Code: ");
                        i2 = sc1.nextLine();
                        
                        System.out.println("Enter Required Course Title: ");
                        i3 = sc1.nextLine();
                        
                        System.out.println("Enter Required Core Course: ");
                        i4 = sc1.nextLine();
                        
                        System.out.println("Enter Required Elective Course: ");
                        i5 = sc1.nextLine();
                        
                    
                        
                        String query = "UPDATE `required_course` SET `unique_required_course_code`=?,`course_unique_course_code`=?,`required_course_title`=?,`required_core_course`=?,`required_elective_course`=? WHERE unique_required_course_code = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, i3);
                        preparedStmt.setString (4, i4);
                        preparedStmt.setString (5, i5); 
                        preparedStmt.setString (6, answer);
                        preparedStmt.executeUpdate();
                                                                
                        System.out.println("1 row affected");
                    }
                    else {
                            System.out.println("Wrong Input!!"); 
                       } 
                    
                }
				
				else if(input == 12) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT university_student_registration_number, course_unique_course_code FROM university_student_course");                    
                    System.out.println("**************************");
                    System.out.println("Student Registration Number: " + "\t" + "Unique Course Code: ");                  
                    while (res.next()) {
                    	String i = res.getString("university_student_registration_number");
            			String s = res.getString("course_unique_course_code");
            			System.out.println(i + "\t\t" +"		" + s);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("What's the University Student Registration Number? ");
                    answer = sc1.nextLine();
                    
                    System.out.println("What's the Unique Course Code? ");
                    String answer1 = sc1.nextLine();

                    int flag=0;
                    res = st.executeQuery("SELECT university_student_registration_number FROM university_student_course");
                    while (res.next()) {
                        String i = res.getString("university_student_registration_number");
                        if (i.equals(answer)) {
                            flag +=1;
                        }
                    }

                    res = st.executeQuery("SELECT course_unique_course_code FROM university_student_course");
                    while (res.next()) {
                        String i = res.getString("course_unique_course_code");
                        if (i.equals(answer1)) {
                            flag +=1;
                        }
                    }
                    
                    //elegxo kai ta 2 an einai swsta kai an uparxoun
                    if(flag ==2) {
                        st.execute("SET FOREIGN_KEY_CHECKS=0");
                        System.out.println("Enter University Student Registration Number: ");
    					i1 = sc1.nextLine();
    					
    					System.out.println("Enter Unique Course Code: ");
    					i2 = sc1.nextLine();
    					
    					System.out.println("Enter Course Grade: ");
    					i3 = sc1.nextLine();
    					
    					System.out.println("Enter Course Year Of Attendance: ");
    					i4 = sc1.nextLine();
    					
    					System.out.println("Enter Course Year Of Declaration: ");
    					i5 = sc1.nextLine();
                        
                    
                        
                        String query = "UPDATE `university_student_course` SET `university_student_registration_number`=?,`course_unique_course_code`=?,`grade`=?,`year_of_attendance`=?,`year_of_declaration`=? WHERE university_student_registration_number = ? AND course_unique_course_code=?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, i1);
                        preparedStmt.setString (2, i2);
                        preparedStmt.setString (3, i3);
                        preparedStmt.setString (4, i4);
                        preparedStmt.setString (5, i5); 
                        preparedStmt.setString (6, answer);
                        preparedStmt.setString (7, answer1);
                        preparedStmt.executeUpdate();
                                                                
                        System.out.println("1 row affected");
                        
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                   } 
                    
                }
				
			}
			
			//DELETE
			else if (input == 3){
				String answer = "";
				System.out.println("**************************");
				System.out.println("What Do You Want To Delete:");
				System.out.println("1) Association\n2) Campus\n3) Department\n4) University School\n"
						+ "5) Commission\n6) Instructor\n7) Supervisor\n8) Course Of Study\n9) Course\n10) University Student \n11) Required Course \n12) Student Information for a Specific Course \n13) Back");
				System.out.println("**************************");
				System.out.println("Enter number:");
				input = sc.nextInt();
				
				if(input == 1) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT association_name FROM association");
                    System.out.println("**************************");
                    System.out.println("Association Name: ");
                    while (res.next()) {
                          String i = res.getString("association_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Association Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT association_name FROM association");
                    while (res.next()) {     
                        String i = res.getString("association_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM association WHERE association_name = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				}  
				
				else if(input == 2) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT campus_name FROM campus");
                    System.out.println("***************************");
                    System.out.println("Campus Name: ");
                    while (res.next()) {
                          String i = res.getString("campus_name");
                          System.out.println(i);
                    }
                    System.out.println("***************************");

                    System.out.println("Which Campus Do You Want To Delete? ");
                    answer = sc1.nextLine();
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT campus_name FROM campus");
                    while (res.next()) {     
                        String i = res.getString("campus_name");
                        if (i.equals(answer)) {
                        	flag = 1;
                        }
                    }

                    if(flag == 1) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM campus WHERE campus_name = ?");
                        st1.setString(1,answer);
                        st1.executeUpdate();
                        System.out.println("1 row affected");
                    	
                    }
                    else {
                    	System.out.println("Wrong Input!!"); 

                    }
                      
				}
                 
				if(input == 3) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT department_name FROM department");
                    System.out.println("**************************");
                    System.out.println("Department Name: ");
                    while (res.next()) {
                          String i = res.getString("department_name");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Department Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT department_name FROM department");
                    while (res.next()) {     
                        String i = res.getString("department_name");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM department WHERE department_name = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				} 
				
                 else if(input == 4) {	
					
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT university_school_name FROM university_school");
                    System.out.println("***************************");
                    System.out.println("University School Name : ");
                    
                    while (res.next()) {
                          String i = res.getString("university_school_name");
                          System.out.println(i);
                    }
                    System.out.println("***************************");

                    System.out.println("Which University School Do You Want To Delete? ");
                    answer = sc1.nextLine();
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT university_school_name FROM university_school");
                    while (res.next()) {     
                        String i = res.getString("university_school_name");
                        if (i.equals(answer)) {
                        	flag = 1;
                        }
                    }
                    
                    if(flag==1) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM university_school WHERE university_school_name = ?");
                        st1.setString(1,answer);
                        st1.executeUpdate();
                        System.out.println("1 row affected");
                    	
                    }
                    else {
                    	System.out.println("Wrong Input!!"); 

                    }
					
				}
				
                    
				if(input == 5) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT commission_title FROM commission");
                    System.out.println("**************************");
                    System.out.println("Commission Title: ");
                    while (res.next()) {
                          String i = res.getString("commission_title");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Commission Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT commission_title FROM commission");
                    while (res.next()) {     
                        String i = res.getString("commission_title");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM commission WHERE commission_title = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				}
				
				else if(input == 6) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT instructor_identifier FROM instructor");                    
                    System.out.println("**************************");
                    System.out.println("Instructor Identifier: ");                  
                    while (res.next()) {
                          String i = res.getString("instructor_identifier");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Instructor Do You Want To Delete? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT instructor_identifier FROM instructor");
                    while (res.next()) {     
                        String i = res.getString("instructor_identifier");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM instructor WHERE instructor_identifier = ?");
                        st1.setString(1,answer);
                        st1.executeUpdate();
                        System.out.println("1 row affected");
                    	
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				if(input == 7) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT supervisor_identifier FROM supervisor");
                    System.out.println("**************************");
                    System.out.println("Supervisor: ");
                    while (res.next()) {
                          String i = res.getString("supervisor_identifier");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Supervisor Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT supervisor_identifier FROM supervisor");
                    while (res.next()) {     
                        String i = res.getString("supervisor_identifier");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM supervisor WHERE supervisor_identifier = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				}
				
				else if(input == 8) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_course_of_study_code FROM course_of_study");                    
                    System.out.println("**************************");
                    System.out.println("Unique Course Of Study Code: ");                  
                    while (res.next()) {
                          String i = res.getString("unique_course_of_study_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which Course Of Study Do You Want To Delete? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT unique_course_of_study_code FROM course_of_study");
                    while (res.next()) {     
                        String i = res.getString("unique_course_of_study_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM course_of_study WHERE unique_course_of_study_code = ?");
                        st1.setString(1,answer);
                        st1.executeUpdate();
                        System.out.println("1 row affected");
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				if(input == 9) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_course_code FROM course");
                    System.out.println("**************************");
                    System.out.println("Course: ");
                    while (res.next()) {
                          String i = res.getString("unique_course_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Course Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT unique_course_code FROM course");
                    while (res.next()) {     
                        String i = res.getString("unique_course_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM course WHERE unique_course_code = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				}
				
				else if(input == 10) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT registration_number FROM university_student");                    
                    System.out.println("**************************");
                    System.out.println("Registration Number: ");                  
                    while (res.next()) {
                          String i = res.getString("registration_number");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Which University Student Do You Want To Delete? ");
                    answer = sc1.nextLine();

                    int flag=0;        
                    res = st.executeQuery("SELECT registration_number FROM university_student");
                    while (res.next()) {     
                        String i = res.getString("registration_number");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM university_student WHERE registration_number = ?");
                        st1.setString(1,answer);
                        st1.executeUpdate();
                        System.out.println("1 row affected");             	
				    } 
                    else {
                         System.out.println("Wrong Input!!"); 
                    } 
				
				}
				
				if(input == 11) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT unique_required_course_code FROM required_course");
                    System.out.println("**************************");
                    System.out.println("Required Course: ");
                    while (res.next()) {
                          String i = res.getString("unique_required_course_code");
                          System.out.println(i);
                    }
                    System.out.println("**************************");
                    System.out.println("Which Required Course Do You Want to Delete? ");
                    answer = sc1.nextLine();
                    
                    
                    int flag=0;        
                    res = st.executeQuery("SELECT unique_required_course_code FROM required_course");
                    while (res.next()) {     
                        String i = res.getString("unique_required_course_code");
                        if (i.equals(answer)) {
                            flag = 1;
                        }
                    }
                    
                    if(flag == 1) {                                       	
						PreparedStatement st1 = conn.prepareStatement("DELETE FROM required_course WHERE unique_required_course_code = ?");
                    	st1.setString(1,answer);
                    	st1.executeUpdate();
                    	System.out.println("1 row affected");
                    	                    
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                    } 
                    
				}
				
				else if(input == 12) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT university_student_registration_number, course_unique_course_code FROM university_student_course");                    
                    System.out.println("**************************");
                    System.out.println("Student Registration Number: " + "\t" + "Unique Course Code: ");                  
                    while (res.next()) {
                        String i = res.getString("university_student_registration_number");
                        String s = res.getString("course_unique_course_code");
                        System.out.println(i + "\t\t" +"		" + s);
                    }
                    System.out.println("**************************");
                    
                    System.out.println("What's the University Student Registration Number? ");
                    answer = sc1.nextLine();
                    
                    System.out.println("What's the Unique Course Code? ");
                    String answer1 = sc1.nextLine();

                    int flag=0;
                    res = st.executeQuery("SELECT university_student_registration_number FROM university_student_course");
                    while (res.next()) {
                        String i = res.getString("university_student_registration_number");
                        if (i.equals(answer)) {
                            flag +=1;
                        }
                    }

                    res = st.executeQuery("SELECT course_unique_course_code FROM university_student_course");
                    while (res.next()) {
                        String i = res.getString("course_unique_course_code");
                        if (i.equals(answer1)) {
                            flag +=1;
                        }
                    }
                    
                    //elegxo kai ta 2 an einai swsta kai an uparxoun
                    if(flag ==2) {
                    	PreparedStatement st1 = conn.prepareStatement("DELETE FROM university_student_course WHERE university_student_registration_number = ? AND course_unique_course_code=?");
                    	st1.setString(1,answer);
                    	st1.setString(2,answer1);
                    	st1.executeUpdate();                                                         
                        System.out.println("1 row affected");
                        
                    }
                    else {
                        System.out.println("Wrong Input!!"); 
                   } 
                    
                }
				
				
				
			}
			//VIEW
			else if (input == 4){
				String answer = "";
				System.out.println("**************************");
				System.out.println("What Do You Want To View:");
				System.out.println("1) Association\n2) Campus\n3) Department\n4) University School\n"
						+ "5) Commission\n6) Instructor\n7) Supervisor\n8) Course Of Study\n9) Course\n10) University Student \n11) Required Course \n12) Student Information for a Specific Course \n13) Back");
				System.out.println("**************************");
				System.out.println("Enter number:");
				input = sc.nextInt();
				
				
				if(input == 1) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM association");
                    System.out.println("**************************");
                    System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s  \n","Association Name(P)","Building","Phone Number","Sports Count","Sports Name","Campus Name(F)");
                    while (res.next()) {
                          i1 = res.getString("association_name");
                          i2 = res.getString("building");
                          i3 = res.getString("phone_number");
                          i4 = res.getString("sports_count");
                          i5 = res.getString("sports_name");
                          i6 = res.getString("campus_campus_name");
                          System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s \n",i1,i2,i3,i4,i5,i6);
                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();
                                                           
				}
				
				else if(input == 2) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM campus");
                    System.out.println("**************************");
                   
                    System.out.printf("%-22s%-22s%-32s%-22s%-22s\n","Campus Name","Address","Distance From Center","Bus Number","Association Name");
                    while (res.next()) {
                          i1 = res.getString("campus_name");
                          i2 = res.getString("address");
                          i3 = res.getString("distance_from_center");
                          i4 = res.getString("bus_number");
                          i5 = res.getString("association_association_name");
                          System.out.printf("%-22s%-22s%-32s%-22s%-22s\n",i1,i2,i3,i4,i5);
                      
                    }
                    System.out.println("**************************");   
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();    
                    
                }
                 
				else if(input == 3) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM department");
                    System.out.println("**************************");
                   
                    System.out.printf("%-22s%-22s%-22s%-22s\n","Department Name(P)","Building","Campus Name(F)","University School Name(F)");
                    while (res.next()) {
                          i1 = res.getString("department_name");
                          i2 = res.getString("building");
                          i3 = res.getString("campus_campus_name");
                          i4 = res.getString("university_school_university_school_name");
                          System.out.printf("%-22s%-22s%-22s%-22s\n",i1,i2,i3,i4);
                      
                    }
                    System.out.println("**************************"); 
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();  
                    
                    }
				
				else if(input == 4) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM university_school");
                    System.out.println("**************************");
                    System.out.printf("%-32s%-22s%-22s  \n","University School Name(P)","Provost","Building");
                    while (res.next()) {
                          i1 = res.getString("university_school_name");
                          i2 = res.getString("provost");
                          i3 = res.getString("building");
                          System.out.printf("%-32s%-22s%-22s \n",i1,i2,i3);
                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();
                                                           
				}
				
				else if(input == 5) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM commission");
                    System.out.println("**************************");
                    System.out.printf("%-22s%-22s  \n","Commission Title(P)","University School Name(F)");
                    while (res.next()) {
                          i1 = res.getString("commission_title");
                          i2 = res.getString("university_school_university_school_name");
                          System.out.printf("%-22s%-22s \n",i1,i2);
                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();
                                                           
				}
				
                 else if(input == 6) {
                    
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM instructor");
                    System.out.println("**************************");
                    System.out.printf("%-32s%-32s%-16s%-22s%-26s%-22s  \n","Instructor Identifier(P)","Instructor FullName","Title","Office Number","Department Name(F)","Supervisor Identifier(F)");
                    while (res.next()) {
                          i1 = res.getString("instructor_identifier");
                          i2 = res.getString("instructor_fullname");
                          i3 = res.getString("title");
                          i4 = res.getString("office_number");
                          i5 = res.getString("department_department_name");
                          i6 = res.getString("supervisor_supervisor_identifier");
                          System.out.printf("%-32s%-32s%-16s%-22s%-26s%-22s \n",i1,i2,i3,i4,i5,i6);
                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();
                    
                }
				
                 else if(input == 7) {
                     st.execute("SET FOREIGN_KEY_CHECKS=0");

                     ResultSet res = st.executeQuery("SELECT * FROM supervisor");
                     System.out.println("**************************");
                     System.out.printf("%-32s%-22s  \n","Supervisor Identifier(P)","Supervisor Name");
                     while (res.next()) {
                           i1 = res.getString("supervisor_identifier");
                           i2 = res.getString("supervisor_fullname");
                           System.out.printf("%-32s%-22s \n",i1,i2);
                     }
                     System.out.println("**************************");
                     System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                     System.out.println("Press Any Button To Go Back"); 
                     answer = sc1.nextLine();
                     
                     
                 }
				
				
				
				else if(input == 8) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM course_of_study");
                    System.out.println("**************************");
                   
                    System.out.printf("%-32s%-27s%-18s%-22s%-30s%-22s\n","Unique Course Of Study Code(P)","Course Of Study Title","Tier","Duration Of Studies","Undergraduate Schedule","Postgraduate Schedule");
                    while (res.next()) {
                          i1 = res.getString("unique_course_of_study_code");
                          i2 = res.getString("course_of_study_title");
                          i3 = res.getString("tier");
                          i4 = res.getString("duration_of_studies");
                          i5 = res.getString("undergraduate_schedule");
                          i6 = res.getString("post_graduate_schedule");
                          System.out.printf("%-32s%-27s%-18s%-22s%-30s%-22s\n",i1,i2,i3,i4,i5,i6);
                      
                    }
                    System.out.println("**************************");   
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();    
                    
                }
				
				else if(input == 9) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM course");
                    System.out.println("**************************");
                   
                    System.out.printf("%-25s%-22s%-22s%-22s%-22s\n","Unique Course Code(P)","Course Title","Core Course","Elective Course","Unique Course Of Study Code(F)");
                    while (res.next()) {
                          i1 = res.getString("unique_course_code");
                          i2 = res.getString("course_title");
                          i3 = res.getString("core_course");
                          i4 = res.getString("elective_course");
                          i5 = res.getString("course_of_study_unique_course_of_study_code");
                          System.out.printf("%-25s%-22s%-22s%-22s%-22s\n",i1,i2,i3,i4,i5);
                      
                    }
                    System.out.println("**************************");   
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();    
                    
                }
				
				else if(input == 10) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM university_student");
                    System.out.println("**************************");

                    System.out.printf("%-32s%-22s%-22s%-22s%-32s%-22s\n","Registration Number(P)","Student FullName","Fathers Name","Date Of Birth","Year Of Registration","Unique Course Of Study Code(F)");
                    while (res.next()) {
                          i1 = res.getString("registration_number");
                          i2 = res.getString("university_student_fullname");
                          i3 = res.getString("fathers_name");
                          i4 = res.getString("date_of_birth");
                          i5 = res.getString("year_of_registration");
                          i6 = res.getString("course_of_study_unique_course_of_study_code");
                          System.out.printf("%-32s%-22s%-22s%-22s%-32s%-22s\n",i1,i2,i3,i4,i5,i6);

                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();

                }
				
				else if(input == 11) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM required_course");
                    System.out.println("**************************");
                   
                    System.out.printf("%-34s%-25s%-25s%-25s%-25s\n","Unique Required Course Code(P)","Unique Course Code(F)","Required Course Title","Required Core Course","Required Elective Course");
                    while (res.next()) {
                          i1 = res.getString("unique_required_course_code");
                          i2 = res.getString("course_unique_course_code");
                          i3 = res.getString("required_course_title");
                          i4 = res.getString("required_core_course");
                          i5 = res.getString("required_elective_course");
                          System.out.printf("%-34s%-25s%-25s%-25s%-25s\n",i1,i2,i3,i4,i5);
                      
                    }
                    System.out.println("**************************");   
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();    
                    
                }
				
				else if(input == 12) {
                    st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT * FROM university_student_course");
                    System.out.println("**************************");

                    System.out.printf("%-40s%-32s%-12s%-22s%-22s\n","Student Registration Number(PF)","Unique Course Code(PF)","Grade","Year Of Attendance","Year Of Declaration");
                    while (res.next()) {
                          i1 = res.getString("university_student_registration_number");
                          i2 = res.getString("course_unique_course_code");
                          i3 = res.getString("grade");
                          i4 = res.getString("year_of_attendance");
                          i5 = res.getString("year_of_declaration");
                          System.out.printf("%-40s%-32s%-12s%-22s%-22s\n",i1,i2,i3,i4,i5);

                    }
                    System.out.println("**************************");
                    System.out.println("P Stands For Primary Key & F Stands For Foreign Key");
                    System.out.println("Press Any Button To Go Back"); 
                    answer = sc1.nextLine();

                }
				
				
								
			}
			
			else if(input == 5) {
				String answer = "";
				System.out.println("**************************");	
				System.out.println("What Answer Do You Want To View:");
				System.out.println("ii)\niii)\niv)\nv)\nvi)\nvii)");
				System.out.println("**************************");
				System.out.println("Enter choice:");
				answer = sc1.nextLine();
				
				if(answer.equals("ii")) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT course_title , required_course_title FROM course,course_of_study,required_course WHERE course_of_study.unique_course_of_study_code = course.course_of_study_unique_course_of_study_code AND course.unique_course_code = required_course.course_unique_course_code ORDER BY course_of_study.unique_course_of_study_code");
                    System.out.println("**************************");
                   
                    System.out.printf("%-30s%-30s\n","Course Title","Required Course Title");
                    while (res.next()) {
                          i1 = res.getString("course_title");
                          i2 = res.getString("required_course_title");
                          System.out.printf("%-30s%-30s\n",i1,i2);
                      
                    }
                    System.out.println("**************************");
                    System.out.println("Press Any Button To Go Back");
                    answer = sc1.nextLine();
				}
				
				else if(answer.equals("iii")) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT instructor_fullname, department_name FROM instructor,university_school,department WHERE university_school.university_school_name = department.university_school_university_school_name AND department.department_name = instructor.department_department_name ORDER BY university_school.university_school_name");
                    System.out.println("**************************");
                   
                    System.out.printf("%-30s%-30s\n","Instructor Fullname","Department Name");
                    while (res.next()) {
                          i1 = res.getString("instructor_fullname");
                          i2 = res.getString("department_name");
                          System.out.printf("%-30s%-30s\n",i1,i2);
                      
                    }
                    System.out.println("**************************");
                    System.out.println("Press Any Button To Go Back");
                    answer = sc1.nextLine();
				}
				
				else if(answer.equals("iv")) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

                    ResultSet res = st.executeQuery("SELECT supervisor_fullname, instructor_fullname FROM supervisor,instructor WHERE supervisor.supervisor_identifier = instructor.supervisor_supervisor_identifier ORDER BY supervisor.supervisor_fullname,instructor.instructor_fullname");
                    System.out.println("**************************");
                   
                    System.out.printf("%-30s%-30s\n","Supervisor Fullname","Instructor Fullname");
                    while (res.next()) {
                          i1 = res.getString("supervisor_fullname");
                          i2 = res.getString("instructor_fullname");
                          System.out.printf("%-30s%-30s\n",i1,i2);
                      
                    }
                    System.out.println("**************************");
                    System.out.println("Press Any Button To Go Back");
                    answer = sc1.nextLine();
				}
				
				else if(answer.equals("vi")) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

					String answer1="";
					String answer2="";
					System.out.println("Enter Unique Course Code");
					answer1 = sc1.nextLine();
					System.out.println("Enter Student Registration Number");
					answer2 = sc1.nextLine();
					
					
					PreparedStatement report = conn.prepareStatement("SELECT course_title FROM course,university_student,university_student_course WHERE course.unique_course_code = ? AND university_student.registration_number = ? AND course.unique_course_code = university_student_course.course_unique_course_code AND university_student.registration_number = university_student_course.university_student_registration_number AND university_student_course.grade >=5");
					report.setString(1, answer1);
					report.setString(2, answer2);
					ResultSet res = report.executeQuery();
                       
					
                    System.out.println("**************************");
                   
                    System.out.printf("%-30s%-30s\n","Course Title"," ");
                    while (res.next()) {
                          i1 = res.getString("course_title");
                          System.out.printf("%-30s%-30s\n",i1,"-Passed");
                      
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Press Any Button To Go Back");
                    answer = sc1.nextLine();
				}
				
				
				
				else if(answer.equals("vii")) {
					st.execute("SET FOREIGN_KEY_CHECKS=0");

					String answer1="";
					System.out.println("Enter Unique Course Of Study Code");
					answer1 = sc1.nextLine();
					
					
					PreparedStatement report = conn.prepareStatement("SELECT registration_number, university_student_fullname FROM university_student, course_of_study, university_student_course, course WHERE course_of_study.unique_course_of_study_code = course.course_of_study_unique_course_of_study_code AND university_student.registration_number = university_student_course.university_student_registration_number AND course_of_study.unique_course_of_study_code = university_student.course_of_study_unique_course_of_study_code AND course.unique_course_code = university_student_course.course_unique_course_code AND course_of_study.duration_of_studies + university_student.year_of_registration + 2 < 2021 AND university_student_course.grade < 5 AND course_of_study.unique_course_of_study_code = ?");
					report.setString(1, answer1);
					ResultSet res = report.executeQuery();
                       
					
                    System.out.println("**************************");
                   
                    System.out.printf("%-30s%-30s%-30s\n","Registration Number","University Student Fullname", " ");
                    while (res.next()) {
                          i1 = res.getString("registration_number");
                          i2 = res.getString("university_student_fullname");
                          System.out.printf("%-30s%-30s%-30s\n",i1,i2,"-Deleted");
                      
                    }
                    System.out.println("**************************");
                    
                    System.out.println("Press Any Button To Go Back");
                    answer = sc1.nextLine();
				}
				
				
				
			}
			
			
			
	}

	
  
	



}

}
