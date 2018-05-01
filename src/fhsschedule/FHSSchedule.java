package fhsschedule;

import java.util.*;
import java.io.*;

//Jan Bobda
public class FHSSchedule {
    //Database object to store the school schedule
    private static Database schedule = new Database();
    static ArrayList<Student> students = new ArrayList();
    static ArrayList<Teacher> teachers = new ArrayList();
    
    //File Setup
    private static Scanner reader;
    private static File scheduleFile;
    private static FileWriter baseWriter;
    private static BufferedWriter writer;
    
    public static void main(String[] args){
        start();
    }
    
    public static void loadFile(){
        String operatingSystem = System.getProperty("os.name");
        //This creates the file where the schedule will be stored
        switch(operatingSystem){
            case "Windows 7": scheduleFile = new File("C:\\Users\\J.Bobda\\Desktop\\schedule_file.txt");
                break;
            case "Windows 10": scheduleFile = new File("C:\\Users\\J.Bobda\\Desktop\\schedule_file.txt");
                break;
            case "macOs": System.out.println("macOS is not supported yet.");
                return;
            case "Linux": scheduleFile = new File("/home/jan/schedule_file.txt");
                break;
            default: scheduleFile = new File("C:\\Users\\J.Bobda\\Desktop\\schedule_file.txt");
                break;
        }
        
        try{
            if(scheduleFile.createNewFile()){
                //Write base template for the file
                writeFile("Name","ID" ,"Period 1" ,"Period 2", "Period 3" ,"Period 4","Period 5" ,"Period 6" ,"Period 7", "Period 8");
            }
        }catch(Exception error){
            System.out.println(error.getMessage());
            return;
        }
    }
    
    public static void createReader(){
        //This creates a scanner that is able to read through the file 
        try{
            reader = new Scanner(scheduleFile);
        }catch(Exception error){
            System.out.println(error.getMessage());
            return;
        }
    }
    
    public static void writeFile(String name, String ID, String one, String two, String three, String four,
            String five, String six ,String seven ,String eight){
        //This creates a filewriter to be able to store information in the schedule
        try{
            baseWriter = new FileWriter(scheduleFile);
            writer = new BufferedWriter(baseWriter);
            writer.write(name + " " + ID + " " + one + " " + two + " " + three + " " + four + " " + 
                    five + " " + six + " " + seven + " " + eight);
            writer.newLine();
        }catch(Exception error){
            System.out.println(error.getMessage());
            return;
        }finally{
            try {
                writer.close();
                baseWriter.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    private static void start(){ 
        loadFile();
        createReader();
        writeFile("Jan", "1" , null, null, "ComputerScience", null, null, null, null, null);
        while(reader.hasNext()){
            System.out.println(reader.nextLine());
        }
        schedule.fillSchedule();
        //Student objects to store in various classes (Name, ID)
        Student Jan = new Student("Jan", 1);
        Student Eli = new Student("Eli", 2);
        Student Garrett = new Student("Garrett", 3);
        Student Mason = new Student("Mason" , 4);
        Student Albert = new Student("Albert", 5);
        
        //Teacher objects to store in various classes
        Teacher mReif = new Teacher("Mr.Reif", 1);
        Teacher eFaulkner = new Teacher("Mr.Faulkner", 2);
        
        //Fills the school schedule with teachers
        schedule.enterTeacher(schedule.getScience(), mReif, 1);
        schedule.enterTeacher(schedule.getComputerScience(), eFaulkner, 3);
        
        //Fills the school schedule with students
        schedule.enterStudent(schedule.getComputerScience(), Jan, 3);
        //System.out.println(Jan.getPersonalSchedule()[2]);
        schedule.enterStudent(schedule.getComputerScience(), Eli, 3);
        schedule.enterStudent(schedule.getComputerScience(), Garrett, 3);
        schedule.enterStudent(schedule.getComputerScience(), Mason, 3);
        schedule.enterStudent(schedule.getComputerScience(), Albert, 3);
        
        menu();
        
    }
    
    private static void menu(){
        //Scanner object to take in user input
        Scanner reader = new Scanner(System.in);
        
        ultraLoop: while(true){
            System.out.println("What would you like to do?\n\n1)Full Schedule 2)Enter Student 3)Enter Teacher 4)Remove Student\n5)Remove Teacher 6)Display Student 7)Display Teacher 8)Exit Program");
            int choice = reader.nextInt();
            switch(choice){
                case 1:
                    //Dumps array (School Schedule)
                    schedule.dumpArray(schedule.getSchedule());
                    System.out.println("");
                    break;
                case 2:
                    //Enters Student
                    System.out.println("What Student would you like to add?");
                    String name = reader.next();
                    System.out.println("What is the student ID of your student");
                    long id = reader.nextLong();
                    Student toBeEntered = new Student(name, id);
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).equals(name, id)) {
                            toBeEntered = students.get(i);
                            break;
                        }
                        toBeEntered = new Student(name, id);
                    }
                    System.out.println("What class period would you like to add the student to?\n1st. 2nd. 3rd. 4th. 5th. 6th. 7th. 8th.");
                    int periodChoice = reader.nextInt();
                    System.out.println("What class would you like to add " + name + " to?\n1)Science 2)Math 3)History 4)English 5)Computer Science"
                                        + "\n 6)Spanish 7)German 8)Soccer 9)Basketball 10)Band");
                    int selection = reader.nextInt();
                    switch(selection){
                        case 1: schedule.enterStudent(schedule.getScience(), toBeEntered, periodChoice);
                            break;
                        case 2: schedule.enterStudent(schedule.getMath(), toBeEntered, periodChoice);
                            break;
                        case 3: schedule.enterStudent(schedule.getHistory(), toBeEntered, periodChoice);
                            break;
                        case 4: schedule.enterStudent(schedule.getEnglish(), toBeEntered, periodChoice);
                            break;
                        case 5: schedule.enterStudent(schedule.getComputerScience(), toBeEntered, periodChoice);
                            break;
                        case 6: schedule.enterStudent(schedule.getSpanish(), toBeEntered, periodChoice);
                            break;
                        case 7: schedule.enterStudent(schedule.getGerman(), toBeEntered, periodChoice);
                            break;
                        case 8: schedule.enterStudent(schedule.getSoccer(), toBeEntered, periodChoice);
                            break;
                        case 9: schedule.enterStudent(schedule.getBasketball(), toBeEntered, periodChoice);
                            break;
                        case 10: schedule.enterStudent(schedule.getBand(), toBeEntered, periodChoice);
                            break;
                    }
                    break;
                case 3:
                    //Enters Teacher
                    System.out.println("What Teacher would you like to add?");
                    String nameTeach = reader.next();
                    System.out.println("What is that teacher's ID?");
                    long teachID = reader.nextLong();
                    Teacher teachToBeEntered = new Teacher(nameTeach, teachID);
                    for (int i = 0; i < teachers.size(); i++) {
                        if(teachers.get(i).equals(nameTeach, teachID)){
                            teachToBeEntered = teachers.get(i);
                            break;
                        }
                    }
                    System.out.println("What class period would you like to add the teacher to?\n1st. 2nd. 3rd. 4th. 5th. 6th. 7th. 8th.");
                    int periodChoiceTeach = reader.nextInt();
                    System.out.println("What class would you like to add " + nameTeach + " to?\n1)Science 2)Math 3)History 4)English 5)Computer Science\n 6)Spanish 7)German 8)Soccer 9)Basketball 10)Band");
                    int selectionTeach = reader.nextInt();
                    switch(selectionTeach){
                        case 1: schedule.enterTeacher(schedule.getScience(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 2: schedule.enterTeacher(schedule.getMath(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 3: schedule.enterTeacher(schedule.getHistory(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 4: schedule.enterTeacher(schedule.getEnglish(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 5: schedule.enterTeacher(schedule.getComputerScience(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 6: schedule.enterTeacher(schedule.getSpanish(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 7: schedule.enterTeacher(schedule.getGerman(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 8: schedule.enterTeacher(schedule.getSoccer(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 9: schedule.enterTeacher(schedule.getBasketball(), teachToBeEntered, periodChoiceTeach);
                            break;
                        case 10: schedule.enterTeacher(schedule.getBand(), teachToBeEntered, periodChoiceTeach);
                            break;
                    }
                    break;
                case 4:
                    //Deletes Student
                    System.out.println("What Student would you like to remove?");
                    String nameStudentDel = reader.next();
                    System.out.println("What is the Student's ID?");
                    long idChoice = reader.nextLong();
                    int counter = 0;
                    for(int i = 0; i < students.size(); i++){
                        if(students.get(i).equals(nameStudentDel, idChoice)){
                            counter = i;
                            break;
                        }
                    }
                    System.out.println("What class period would you like to remove the student from?\n1st. 2nd. 3rd. 4th. 5th. 6th. 7th. 8th.");
                    int periodChoiceStudentDel = reader.nextInt();
                    System.out.println("What class would you like to remove " + nameStudentDel + " from?\n1)Science 2)Math 3)History 4)English 5)Computer Science\n 6)Spanish 7)German 8)Soccer 9)Basketball 10)Band");
                    int selectionStudentDel = reader.nextInt();
                    switch(selectionStudentDel){
                        case 1: schedule.deleteStudent(schedule.getScience(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 2: schedule.deleteStudent(schedule.getMath(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 3: schedule.deleteStudent(schedule.getHistory(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 4: schedule.deleteStudent(schedule.getEnglish(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 5: schedule.deleteStudent(schedule.getComputerScience(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 6: schedule.deleteStudent(schedule.getSpanish(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 7: schedule.deleteStudent(schedule.getGerman(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 8: schedule.deleteStudent(schedule.getSoccer(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 9: schedule.deleteStudent(schedule.getBasketball(), students.get(counter), periodChoiceStudentDel);
                            break;
                        case 10: schedule.deleteStudent(schedule.getBand(), students.get(counter), periodChoiceStudentDel);
                            break;
                    }
                    break;
                case 5:
                    //Deletes Teacher
                    System.out.println("What Teacher would you like to remove?");
                    String nameTeachDel = reader.next();
                    System.out.println("What is that Teacher's ID?");
                    long teachRemoveID = reader.nextLong();
                    int counterT = 0;
                    for (int i = 0; i < teachers.size(); i++) {
                        if (teachers.get(i).equals(nameTeachDel, teachRemoveID)) {
                            counterT = i;
                            break;
                        }
                    }
                    System.out.println("What class period would you like to remove the teacher from?\n1st. 2nd. 3rd. 4th. 5th. 6th. 7th. 8th.");
                    int periodChoiceTeachDel = reader.nextInt();
                    System.out.println("What class would you like to remove " + nameTeachDel + " from?\n1)Science 2)Math 3)History 4)English 5)Computer Science\n 6)Spanish 7)German 8)Soccer 9)Basketball 10)Band");
                    int selectionTeachDel = reader.nextInt();
                    switch(selectionTeachDel){
                        case 1: schedule.deleteTeacher(schedule.getScience(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 2: schedule.deleteTeacher(schedule.getMath(),teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 3: schedule.deleteTeacher(schedule.getHistory(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 4: schedule.deleteTeacher(schedule.getEnglish(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 5: schedule.deleteTeacher(schedule.getComputerScience(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 6: schedule.deleteTeacher(schedule.getSpanish(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 7: schedule.deleteTeacher(schedule.getGerman(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 8: schedule.deleteTeacher(schedule.getSoccer(), teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 9: schedule.deleteTeacher(schedule.getBasketball(),teachers.get(counterT), periodChoiceTeachDel);
                            break;
                        case 10: schedule.deleteTeacher(schedule.getBand(),teachers.get(counterT), periodChoiceTeachDel);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Which Student's schedule would you like to see?");
                    String studentChoice = reader.next();
                    System.out.println("What is that Student's ID?");
                    long idChoiceDisplay = reader.nextLong();
                    for(int i = 0; i < students.size(); i++){
                        
                        if(students.get(i).equals(studentChoice, idChoiceDisplay)){
                            schedule.displayStudent(students.get(i));
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Which Teacher's schedule would you like to see?");
                    String teacherChoice = reader.next();
                    System.out.println("What is that Teacher's ID?");
                    long idChoiceDisplayTeach = reader.nextLong();
                    for(int i = 0; i < teachers.size(); i++){
                        
                        if(teachers.get(i).equals(teacherChoice, idChoiceDisplayTeach)){
                            schedule.displayTeacher(teachers.get(i));
                            break;
                        }
                    }
                    break;
                case 8:
                    break ultraLoop;
            }
        }
    }
    
}
