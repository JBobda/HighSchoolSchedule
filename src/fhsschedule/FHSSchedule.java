package fhsschedule;

import java.util.*;
import java.io.*;

//Jan Bobda
public class FHSSchedule {
    //Database object to store the school schedule
    static Database schedule = new Database();
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    
    //File Setup
    private static Scanner reader;
    private static File scheduleFile;
    private static FileWriter baseWriter;
    private static BufferedWriter writer;
    
    //New array to work with files
    private static ArrayList<ArrayList<String>> fileList = new ArrayList<ArrayList<String>>();
    
    public static void main(String[] args){
        //Immediately goes to the start funtion of the program
        start();
    }
    
    public static void loadFile(){
        String operatingSystem = System.getProperty("os.name");
        //Switch case for the various operating systems that could be used. Creates the file where the schedule will be stored
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
            //If this file doesn't exist it will create a new one with these entries and force user to restart the program.
            if(!scheduleFile.exists()){
                System.out.println("Files missing, installing necessary files for the program...");
                Thread.sleep(1500);
                scheduleFile.createNewFile();
                instantiateWriter();
                writeFile("Name","ID" ,"Period1" ,"Period2", "Period3" ,"Period4","Period5" ,"Period6" ,"Period7", "Period8");
                writeFile("Jan", "1" , null, null, "ComputerScience", null, null, null, null, null);
                writeFile("Eli", "2" , null, null, "ComputerScience", null, null, null, null, null);
                writeFile("Garrett", "3" , null, null, "ComputerScience", null, null, null, null, null);
                writeFile("Mason", "4" , null, null, "ComputerScience", null, null, null, null, null);
                writeFile("Albert", "1" , null, null, "ComputerScience", null, null, null, null, null);
                System.out.println("Necessary files have been installed, please restart the program.");
                closeWithExit();
                System.exit(0);
            }
            //Otherwise it will continue with the existing schedule file
        }catch(Exception error){
            //If there is an error with the saved information, the program will not continue.
            System.out.println("There was an error writing.");
            System.exit(0);
        }
    }
    
    private static void instantiateWriter(){
        //Instantiate File reader
        try{
            baseWriter = new FileWriter(scheduleFile);
            writer = new BufferedWriter(baseWriter);
        }catch(Exception e){
            //If there is an error with the writer, the program will not continue because information could be lost.
            System.out.println("There was an error.");
            System.exit(0);
        }
    }
    
    private static void createReader(){
        //This creates a scanner that is able to read through the file 
        try{
            reader = new Scanner(scheduleFile);
        }catch(Exception error){
            System.out.println(error.getMessage());
            return;
        }
    }
    
    private static void fileToArray(){
        //Takes the contents of the file and places them into an ArrayList matrix
        int count = 0;
        int index = 0;
        fileList.add(new ArrayList<String>());
        while(reader.hasNext()){
                fileList.get(index).add(reader.next());
                count++;
                if(count % 10 == 0){
                    fileList.add(new ArrayList<String>());
                    index++;
                }
        }
        fileList.remove(0);
    }
    
    private static void writeFile(String name, String ID, String one, String two, String three, String four,
            String five, String six ,String seven ,String eight){
        //This creates a filewriter to be able to store information in the schedule
        try{
            writer.write(name + " " + ID + " " + one + " " + two + " " + three + " " + four + " " + 
                    five + " " + six + " " + seven + " " + eight);
            writer.newLine();
        }catch(Exception error){
            System.out.println("Student was not saved to the database.");
            return;
        }
    }
    
    private static void start(){ 
        loadFile();
        createReader();
        fileToArray();
        schedule.fillSchedule();
        String studentInfo = "";
        //Loop that goes through the arraylist of string arraylists to move information into a string
        for (int i = 0; i < fileList.size(); i++) {
            //Loop that goes through the arraylist of strings and adds it to the studentInfo 
            for (int j = 0; j < fileList.get(i).size(); j++) {
                studentInfo += fileList.get(i).get(j) + " ";
            }
            //System.out.println(studentInfo);
            Student currentStudent = new Student(studentInfo);
            students.add(currentStudent);
            //Finds all of the classes that a student has and adds them to it
            for (int j = 0; j < currentStudent.getPersonalSchedule().length; j++) {
                for(int k = 0; k < schedule.getSchedule().size(); k++){
                    if ((currentStudent.getPersonalSchedule()[j] != null ) && (currentStudent.getPersonalSchedule()[j].equals(schedule.getSchedule().get(k).getRoomName()))) {
                        schedule.enterStudent(schedule.getSchedule().get(k), currentStudent, j+1);
                    }
                }
            }
            studentInfo = "";
        }
        
        
        for (int i = 0; i < students.get(2).getPersonalSchedule().length; i++) {
            System.out.println(students.get(2).getPersonalSchedule()[i]);
        }
        
        
        
        //Prints the ArrayList Matrix which contains the name, id, and classes for all of the students.(For testing)
        /*
        for (int i = 0; i < fileList.size(); i++) {
            System.out.println(fileList.get(i));
        }*/
        
        /*
        //Student objects to store in various classes (Name, ID)
        Student Jan = new Student("Jan");
        Student Eli = new Student("Eli");
        Student Garrett = new Student("Garrett");
        Student Mason = new Student("Mason");
        Student Albert = new Student("Albert");
        
        //Teacher objects to store in various classes
        Teacher mReif = new Teacher("Mr.Reif", 1);
        Teacher eFaulkner = new Teacher("Mr.Faulkner", 2);
        
        //Fills the school schedule with teachers
        schedule.enterTeacher(schedule.getScience(), mReif, 1);
        schedule.enterTeacher(schedule.getComputerScience(), eFaulkner, 3);
        */
        //Fills the school schedule with students
        /*
        schedule.enterStudent(schedule.getComputerScience(), Jan, 3);
        schedule.enterStudent(schedule.getComputerScience(), Eli, 3);
        schedule.enterStudent(schedule.getComputerScience(), Garrett, 3);
        schedule.enterStudent(schedule.getComputerScience(), Mason, 3);
        schedule.enterStudent(schedule.getComputerScience(), Albert, 3);
        */
        
        //Goes to the menu of the program to offer ways to change the schedule
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
                    //NEEDS WORK NOT COMPLETE
                    //Enters Student
                    System.out.println("What Student would you like to add?");
                    String name = reader.next();
                    System.out.println("What is the student ID of your student");
                    long id = reader.nextLong();
                    Student toBeEntered = new Student(name);
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).equals(name, id)) {
                            toBeEntered = students.get(i);
                            break;
                        }
                        toBeEntered = new Student(name);
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
                    //Views student's personal schedule
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
                    //Views teacher's personal schedule
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
                    closeWithExit();
                    break ultraLoop;
            }
        }
    }
    
    private static void closeWithExit(){
        //When the program ends, the writer is closed
        try {
            if (writer != null) {
                writer.close();
                baseWriter.close(); 
            }
            
        } catch (IOException ex) {
            //System.out.println("The file was closed properly.");
            ex.printStackTrace();
        }
    }
    
}
