import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;



public class main1 {
    public static ArrayList<Integer> Alpass = new ArrayList<>();
    static ArrayList <String> Alname= new ArrayList<>();
    public static void main(String[] args){
        Database data = new Database();
        Scanner sc= new Scanner(System.in);
        int choice;

        data.addMovie("Master",2019,"Action","Tamil");

        data.addMovie("Ayan",2009,"Action","Tamil");

        data.addMovie("LoveToday",2022,"Love","Tamil");

        data.addMovie("Singam",2011,"Action","Tamil");

        data.addMovie("PonniyinSelvan" ,2022,"Historical","Tamil");

        data.addMovie("Vikram",2022,"Thriller","Tamil");

        data.addMovie("VikramVedha",2017,"Crime","Tamil");

        data.addMovie("Comali",2019,"Comedy","Tamil");




        do{
            System.out.println("\n----------WELCOME TO MOVIE REVIEW APPLICATION----------");
            System.out.println("\nEnter your Choice");
            System.out.println("1) User \n2) Admin");
            int fchoice=sc.nextInt();
            switch(fchoice){
                case 1: {

                   do {
                       System.out.println("Enter Your Choice:");
                       System.out.println("1) Login \n2) Register");
                       int schoice=sc.nextInt();
                       switch (schoice){
                           case 1:{
                               System.out.println("Enter Name: ");
                               String name = sc.next();
                               System.out.println("Enter Password: ");
                               int pass = sc.nextInt();

                               if(Alname.contains(name) && Alpass.contains(pass)) {
                                   int lchoice1;
                                   String username = name;
                                   data.addUser(username);
                                   do {


                                       System.out.println("Hello " + name);
                                       System.out.println("Enter Your Choice:");
                                       System.out.println("1)Add New Movie \n2)Add New Review \n3)Print Movies \n4)Print reviews " +
                                               "\n5)Print average review score by MovieName");
                                       int lchoice = sc.nextInt();
                                       switch (lchoice) {
                                           case 1: {
                                               System.out.println("Enter Movie Name : ");
                                               String moviename = sc.next();
                                               System.out.println("Enter Year of Release : ");
                                               int yearOfRelease = sc.nextInt();
                                               System.out.println("Enter Genre : ");
                                               String genre = sc.next();
                                               System.out.println("Enter the Language of movie");
                                               String language=sc.next();
                                               data.adduserMovie(moviename, yearOfRelease, genre,language);


                                           }
                                           break;
                                           case 2: {
                                               System.out.println("Enter User Name : ");
                                               String username1 = sc.next();
                                               System.out.println("Enter Movie Name : ");
                                               String moviename1 = sc.next();
                                               System.out.println("Enter Rating : ");
                                               int rating = sc.nextInt();
                                               if(data.checkUser(username1)==true) {
                                                   if (data.findMovie(moviename1) == true) {
                                                       if (data.reviewsLength() == 0) {
                                                           data.updateUser(username1);
                                                           data.addReviews(username1, moviename1, rating);
                                                       } else {
                                                           if (data.findSameReview(username1, moviename1) == false) {
                                                               data.updateUser(username1);
                                                               data.addReviews(username1, moviename1, rating);
                                                           } else {
                                                               System.out.println("Multiple reviews not allowed");
                                                           }
                                                       }
                                                   } else {
                                                       System.out.println("Movie yet to be released");
                                                   }
                                               }else{
                                                   System.out.println("User Name Not Found");
                                               }

                                           }
                                           break;

                                           case 3: {
                                               data.printMovies();
                                               break;
                                           }

                                           case 4: {
                                               data.printreviw();
                                           }
                                           break;

                                           case 5: {
                                               System.out.println("Enter movie name : ");
                                               String moviename = sc.next();
                                               System.out.println(data.ReviewMovie(moviename));

                                           }
                                       }
                                       System.out.println("Press 1 to continue the login menu otherwise press 0");
                                       lchoice1 = sc.nextInt();
                                   } while (lchoice1 == 1);
                               }else{
                                   System.out.println("Username and Password doesn't Match");
                               }

                           }
                           break;
                           case 2:{
                               System.out.println("Enter Name: ");
                               String name = sc.next();
                               System.out.println("Enter Email: ");
                               String email=sc.next();
                               System.out.println("Enter new Password: ");
                               int pass = sc.nextInt();
                               System.out.println("Confirm Password: ");
                               int Cpass=sc.nextInt();

                               if(pass!=Cpass){
                                   System.out.println("Password And Confirm Password doesn't Match");
                                   break;
                               }
                               Alname.add(name);
                               Alpass.add(pass);
                               System.out.println("Your Successfully Register!!!!\n try to login");
                           }
                       }
                       System.out.println("Press 1 to continue the Login and Register menu otherwise press 0");
                       choice = sc.nextInt();
                   }while(choice==1);
                   }

                   break;

                case 2: {
                    System.out.println("Enter AdminUserName: ");
                    String name = sc.next();
                    System.out.println("Enter Password: ");
                    int pass = sc.nextInt();

                    if(name.equals(Admin.Adminname) && Objects.equals(pass, Admin.AdminPassword)){
                        int lchoice1;
                        do {
                            System.out.println("Hello " + name);
                            System.out.println("Enter Your Choice:");
                            System.out.println("\n1) Print Movies \n2) Print reviews " +
                                    "\n3) Print Users\n4) Print Movies Suggested by User\n5) Add Movies Suggested by User");
                            lchoice1 = sc.nextInt();
                            switch(lchoice1){
                                case 1:{
                                    data.printMovies();
                                    break;

                                }

                                case 2:{
                                    data.printreviw();
                                    break;
                                }

                                case 3:{
                                    data.printusers();
                                    break;
                                }

                                case 4:{
                                    data.printuserMovies();
                                    break;
                                }
                                case 5:{
                                    System.out.println("Enter Movie Name:");
                                    String moviename=sc.next();
                                    if(data.finduserMovie(moviename)==true){
                                        data.Movieadd(moviename);
                                        System.out.println("Movie Added Successfully");
                                    }else{
                                        System.out.println("Movie Not Found");
                                    }


                                }

                            }
                            System.out.println("Press 1 to continue the Admin menu otherwise press 0");
                            choice = sc.nextInt();
                            }while(choice==1);


                    }

                }
                break;

            }
            System.out.println("Press 1 to continue the User and Admin menu otherwise press 0");
            choice = sc.nextInt();
        }while(choice==1);
    }



}
