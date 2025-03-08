import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<CoworkingSpaces> coworkingSpaces = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();

    static {
        coworkingSpaces.add(new CoworkingSpaces(1, "Open", 22.5, true));
        coworkingSpaces.add(new CoworkingSpaces(2, "Private", 30.2, true));
        coworkingSpaces.add(new CoworkingSpaces(3, "Open", 22.5, true));

    }

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Coworking Space Reservation");
        System.out.println("Option");
        System.out.println("1-Admin login:");
        System.out.println("2-Customer login:");
        System.out.println("0-Exit:");
        System.out.print("Choise:");
        int choise = sc.nextInt();

        switch (choise){
            case   1:
                clear();
                adminMenu();

                break;
            case  2:
                userMenu();
                break;
            case  0:
                Exit();
                break;
            default:
                System.out.println("Make the right choice");
                Menu();
        }
    }

    public static void adminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin menu");
        System.out.println("1-Add a new coworking spaces:");
        System.out.println("2-Remove a coworking spaces:");
        System.out.println("3-View all reservations:");
        System.out.println("0-Exit");
        System.out.print("Choise:");
        int choise = sc.nextInt();

        switch (choise){
            case   1:
                addCoworkingSpaces();
                break;
            case  2:
                removeSpaces();
                break;
            case  3:
                viewAllSpaces();
                break;
            case 0:
                Menu();
                break;
            default:
                System.out.println("Make the right choice");
        }


    }

     public static void userMenu(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Admin menu");
         System.out.println("1-Browse available spaces make a reservation:");
         System.out.println("2-View my reservations:");
         System.out.println("3-Cancel a reservation:");
         System.out.println("0-Exit");
         System.out.print("Choise:");
         int choise = sc.nextInt();

         switch (choise){
             case   1:
                 makeReservation();
                 break;
             case  2:
                viewMyReservation();
                 break;
             case  3:
                cancelReservation();
                 break;
             case 0:
                 Menu();
                 break;
             default:
                 System.out.println("Make the right choice");
         }

     }

     public static void addCoworkingSpaces(){
        Scanner sc = new Scanner(System.in);
         System.out.print("Record id:");
         int spacesId = sc.nextInt();
         sc.nextLine();

         for (CoworkingSpaces it : coworkingSpaces) {
             if(it.getId()==spacesId){
                 System.out.println("The id you entered is full, please retype it.");
                 addCoworkingSpaces();
             }
         }

         System.out.print("Writing type (open/private):");
         String spacesType = sc.nextLine();
         System.out.print("Specify the price:");
         double spacesPrice = sc.nextDouble();
         System.out.print("isAvailable? - true/false:");
         boolean isAvailable = sc.nextBoolean();

         CoworkingSpaces addSpace = new CoworkingSpaces(spacesId, spacesType, spacesPrice, isAvailable);
         coworkingSpaces.add(addSpace);

         System.out.println();
         System.out.println("New add coworking space? (add/back)!\n");
         System.out.print("Enter your choice: ");
         String newAdd = sc.next();

         if (newAdd.equalsIgnoreCase("Add")) {
             addCoworkingSpaces();
         } else {
             adminMenu();
         }
     }
     public static void removeSpaces(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Select the index you want to delete:");
        int choise = sc.nextInt();

        int a = choise-1;

        coworkingSpaces.remove(a);
        for (CoworkingSpaces it : coworkingSpaces) {
            System.out.println("Id:"+it.getId() +" "+ "Type:"+it.getType() +" "+ "Price:"+it.getPrice() +" "+ "IsAvailable:"+it.getIsAvailable());
        }
         System.out.println();
         System.out.println("Do you want to remove it again? (Yes/No)\n");
         System.out.print("Enter your choice: ");
         String newAdd = sc.next();

         if (newAdd.equalsIgnoreCase("Yes")) {
             removeSpaces();
         } else {
             adminMenu();
         }

    }

    public static void viewAllSpaces(){
        Scanner sc = new Scanner(System.in);

//        if(reservations.isEmpty()) System.out.println("The empty!");

        for (CoworkingSpaces it : coworkingSpaces) {
            System.out.println("Id:"+it.getId() +" "+ "Type:"+it.getType() +" "+ "Price:"+it.getPrice() +" "+ "IsAvailable:"+it.getIsAvailable());

//            System.out.print("If you want to go back -> 'back': ");
//            String goBack = sc.next();
//            if (goBack.equalsIgnoreCase("back")){
//                adminMenu();
//            }else{
//                Menu();
//            }
        }
    }

    public static void makeReservation(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Make a Reservation id:");
        int rsvId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name:");
        String name = sc.nextLine();
        System.out.print("Enter reservation date:");
        String date = sc.nextLine();
        System.out.print("Enter start time:");
        String start = sc.nextLine();
        System.out.print("Enter end time:");
        String end = sc.nextLine();

        Reservation addReservation = new Reservation(rsvId, name, date, start, end);
        reservations.add(addReservation);


        System.out.println();
        System.out.println("New add reservation space? (add/back)!\n");
        System.out.print("Enter your choice: ");
        String newAdd = sc.next();

        if (newAdd.equalsIgnoreCase("Add")) {
            makeReservation();
        } else {
            userMenu();
        }


    }
    public static void viewMyReservation(){
        Scanner sc = new Scanner(System.in);
        for (Reservation it : reservations) {
            System.out.println("Id:"+it.getReservId() +" "+"Name:"+it.getName()+" "+"Date:"+it.getDate() +" "+ "Start Time:"+it.getStartTime() +" "+ "IsAvailable:"+it.getEndTime());
        }
        if(reservations.isEmpty()) System.out.println("No reservations!");

        System.out.print("If you want to go back -> 'back': ");
        String goBack = sc.next();
        if (goBack.equalsIgnoreCase("back")){
            userMenu();
        }else{
            Menu();
        }

    }

    public static void cancelReservation(){
        Scanner sc = new Scanner(System.in);
        for (Reservation it : reservations) {
            System.out.println("Id:"+it.getReservId() +" "+"Name:"+it.getName()+" "+"Date:"+it.getDate() +" "+ "Start Time:"+it.getStartTime() +" "+ "IsAvailable:"+it.getEndTime());
        }

        System.out.print("Enter the reservation ID you want to cancel:");
        int b = sc.nextInt();

        reservations.remove(b);

        for (Reservation it : reservations) {
            System.out.println("Id:"+it.getReservId() +" "+"Name:"+it.getName()+" "+"Date:"+it.getDate() +" "+ "Start Time:"+it.getStartTime() +" "+ "IsAvailable:"+it.getEndTime());
        }
        System.out.println();
        System.out.println("Do you want to cancel it again? (Yes/No)\n");
        System.out.print("Enter your choice: ");
        String newAdd = sc.next();

        if (newAdd.equalsIgnoreCase("Yes")) {
            cancelReservation();
        } else {
            userMenu();
        }

    }

    public static void Exit() {
        System.out.println("Logging out!");
        System.exit(0);
        Menu();
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }




}

