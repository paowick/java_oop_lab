import java.util.ArrayList;
import java.util.Scanner;

public class Atm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("keter", "01", "1234", 1000));
        accounts.add(new Account("binah", "02", "1234", 1230));
        accounts.add(new Account("da'at", "03", "1234", 5550));
        accounts.add(new Account("chokmah", "04", "1234", 230));
        accounts.add(new Account("gevurah", "05", "1234", 880));
        accounts.add(new Account("tiferet", "06", "1234", 1110));

        while (true) {
        System.out.print("Step 1. Enter amount of all account = ");
        int accAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Step 2. Enter Detail of each account.");
        for (int i = 0; i < accAmount; i++) {
            System.out.print("No.");
            System.out.println(i + 1);
            System.out.print("Account ID = ");
            String createID = scanner.nextLine().toString();
            System.out.print("Account Name = ");
            String createName = scanner.nextLine().toString();
            System.out.print("Passowrd =");
            String createPassWord = scanner.nextLine().toString();
            System.out.print("Balance =");
            int createBalance = Integer.parseInt(scanner.nextLine());
            accounts.add(new Account(createName, createID, createPassWord, createBalance));
        }

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

                    }else{
                    
                    }
                }

            } catch (Exception e) {
                System.out.println("something worng1");
            }

            
        }
        
    
        
    }


}
