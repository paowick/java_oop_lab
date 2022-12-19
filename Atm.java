import java.util.ArrayList;
import java.util.Scanner;


public class Atm {
    private static Account adMin = null;  
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        accounts.add(new Account("keter", "01", "1234", 1000  ,"123"));
        accounts.add(new Account("binah", "02", "1234", 1230  ,"234"));
        accounts.add(new Account("da'at", "03", "1234", 5550  ,"345"));
        accounts.add(new Account("chokmah", "04", "1234", 230 ,"456"));
        accounts.add(new Account("gevurah", "05", "1234", 880 ,"567"));
        accounts.add(new Account("tiferet", "06", "1234", 1110,"678"));

        if(adMin == null){
            System.out.println("insert admin account");
            insertAcc(String.valueOf("admin"));
        }

        System.out.println("=====================================================");
        System.out.println("Login Manager id");
        System.out.print("Account ID :");
        String adminID = scanner.nextLine().toString();
        System.out.print("Account Password : ");
        String adminPASS = scanner.nextLine().toString();
        
        if (adMin.getId().equals(adminID) && adMin.getPassWord().equals(adminPASS)) {
            userInterface();
        }

    }

    public static void insertAcc(String i){ 
            System.out.print("No.");
            System.out.println(i);
            System.out.print("Account ID = ");
            String createAccountID = scanner.nextLine().toString();
            System.out.print("Person ID = ");
            String createPersonID = scanner.nextLine().toString();
            System.out.print("Account Name = ");
            String createName = scanner.nextLine().toString();
            System.out.print("Passowrd =");
            String createPassWord = scanner.nextLine().toString();
            System.out.print("Balance =");
            int createBalance = Integer.parseInt(scanner.nextLine());
            if(i == "admin"){
                adMin = new Account(createName, createAccountID, createPassWord, createBalance, createPersonID);
            }else{
                accounts.add(new Account(createName, createAccountID, createPassWord, createBalance,createPersonID));
            }

    }

    public static void userInterface(){

        System.out.print("Step 1. Enter amount of all account = ");
        int accAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Step 2. Enter Detail of each account.");
        for (int i = 0; i < accAmount; i++) {
            insertAcc(String.valueOf(i+1));
        }
        while (true) {
            try {
                System.out.println("=====================================================");
                System.out.println("ATM ComputerThanyaburiBank");
                System.out.print("Account ID :");
                String ID = scanner.nextLine().toString();
                System.out.print("Account Password : ");
                String PASS = scanner.nextLine().toString();

                
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId().equals(ID) && accounts.get(i).getPassWord().equals(PASS)) {
                        System.out.println("ATM ComputerThanyaburiBank");
                        System.out.print("Account ID : ");
                        System.out.println(ID);
                        while (true) {
                            try {
                                System.out.println("Menu Service");
                                System.out.println("1.Account Balance");
                                System.out.println("2.Withdrawal");
                                System.out.println("3.Exit");
                                System.out.print("choose : ");
            
                                String choose = scanner.nextLine().toString();
            
                                if (choose.equals("1")) {
                                    System.out.println("========================================= ");
                                    System.out.print("account name : ");
                                    System.out.println(accounts.get(i).getName());
                                    System.out.print("you have money in account : ");
                                    System.out.println(accounts.get(i).getMoney());
                                    System.out.println("========================================= ");
                                } else if (choose.equals("2")) {
                                    System.out.print("Enter amount : ");
                                    int moneyWithDraw = Integer.parseInt(scanner.nextLine());
            
                                    if (moneyWithDraw > accounts.get(i).getMoney()) {
                                        System.out.println("========================================= ");
                                        System.out.println("you dont have enough money");
                                        System.out.println("========================================= ");
                                        continue;
                                    }
                                    accounts.get(i).setMoney(accounts.get(i).getMoney() - moneyWithDraw);
                                    System.out.println("========================================= ");
                                    System.out.print("you have money in account : ");
                                    System.out.println(accounts.get(i).getMoney());
                                    System.out.println("========================================= ");
            
                                } else if (choose.equals("3")) {
                                    break;
                                }
            
                            } catch (Exception e) {
                                System.out.println("something worng2");
                                break;
                            }
            
                        }
            
                    }
                }
            } catch (Exception e) {
                System.out.println("something worng1");
            }
            
            
        }
        
        
        
    }
}
