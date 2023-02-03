import java.util.ArrayList;
import java.util.Scanner;

public class Atm implements Atmaction {
    private static Manager adMin = null;
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static double btcExchange = 0.0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        accounts.add(new Account("keter", "01", "1234", 1000, "123"));
        accounts.add(new Account("binah", "02", "1234", 1230, "234"));
        accounts.add(new Account("da'at", "03", "1234", 5550, "345"));
        accounts.add(new Account("chokmah", "04", "1234", 230, "456"));
        accounts.add(new Account("gevurah", "05", "1234", 880, "567"));
        accounts.add(new Account("tiferet", "06", "1234", 1110, "678"));
        while (true) {
            if (adMin == null) {
                insertAcc(String.valueOf("admin"));
            }
            System.out.println("=====================================================");
            System.out.println("Login Manager id");
            System.out.print("Account ID :");
            String adminID = scanner.next().toString();
            System.out.print("Account Password : ");
            String adminPASS = scanner.next().toString();
            if (adMin.getId().equals(adminID) && adMin.getPassWord().equals(adminPASS)) {
                btcExchangeRate();
                userInterface();
            } else {
                System.out.println("password worng");
            }
        }
    }

    public static void insertAcc(String i) {
        if (i == "admin") {
            System.out.print("insert admin Account : ");
            String adminAccount = scanner.next().toString();
            System.out.print("Enter admin password : ");
            String adminPassword = scanner.next().toString();
            adMin = new Manager(adminAccount, adminPassword);
        } else {
            System.out.println("No." + i);
            System.out.print("Account ID = ");
            String createAccountID = scanner.next().toString();
            System.out.print("Person ID = ");
            String createPersonID = scanner.next().toString();
            System.out.print("Account Name = ");
            String createName = scanner.next().toString();
            System.out.print("Passowrd =");
            String createPassWord = scanner.next().toString();
            System.out.print("Balance =");
            int createBalance = Integer.parseInt(scanner.next());
            accounts.add(new Account(createName, createAccountID, createPassWord, createBalance, createPersonID));
        }
    }

    public static void userInterface() {
        boolean shouldBreak = false;
        System.out.print("Step 1. Enter amount of all account = ");
        int accAmount = scanner.nextInt();
        System.out.println("Step 2. Enter Detail of each account.");
        for (int i = 0; i < accAmount; i++) {
            insertAcc(String.valueOf(i + 1));
        }
        while (true) {
            try {
                System.out.println("=====================================================");
                System.out.println("ATM ComputerThanyaburiBank");
                System.out.print("Account ID :");
                String ID = scanner.next().toString();
                System.out.print("Account Password : ");
                String PASS = scanner.next().toString();
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId().equals(ID) && accounts.get(i).getPassWord().equals(PASS)) {
                        System.out.println("ATM ComputerThanyaburiBank");
                        System.out.print("Account ID : ");
                        System.out.println(ID);
                        while (true) {
                            try {
                                System.out.println("Menu Service");
                                System.out.println("1.Account Checkable");
                                System.out.println("2.Withdrawable");
                                System.out.println("3.Depositeable");
                                System.out.println("4.Transferable");
                                System.out.println("5.Exit");
                                System.out.print("choose : ");
                                String choose = scanner.next().toString();
                                switch (choose) {
                                    case "1":

                                        checkAble(i);
                                        break;

                                    case "2":

                                        withdrawAble(i);
                                        break;

                                    case "3":
                                        depositAable(i);
                                        break;

                                    case "4":
                                        tranferAble(i);
                                        break;

                                    case "5":
                                        shouldBreak = true;
                                        break;
                                    default:
                                        break;
                                }
                                if (shouldBreak) {
                                    shouldBreak = false;
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("something worng2" + e);
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

    public static void checkAble(int i) {
        System.out.println("========================================= ");
        System.out.println("account name : " + accounts.get(i).getName());
        System.out.println("you have money in account : " + accounts.get(i).getMoney() + " Bath");

        System.out.println("you have money in account :" + (accounts.get(i).getMoney() / btcExchange) + " BTC");
        System.out.println("========================================= ");
    }

    public static void withdrawAble(int i) {
        String mode = "";
        System.out.println("1. bath");
        System.out.println("2. BTC");
        System.out.print("Enter withdraw Mode : ");

        String choosemode = scanner.next().toString();
        switch (choosemode) {
            case "1":
                mode = "BATH";
                break;
            case "2":
                mode = "BTC";
                break;
        }
        System.out.print("Enter amount : ");
        double moneyWithDraw = scanner.nextDouble();

        if (mode == "BTC") {
            moneyWithDraw = moneyWithDraw * btcExchange;
        }
        int moneyWithDrawa = (int)moneyWithDraw;

        if (moneyWithDraw > accounts.get(i).getMoney()) {
            System.out.println("========================================= ");
            System.out.println("you dont have enough money");
            System.out.println("========================================= ");
        } else {
            accounts.get(i).setMoney(accounts.get(i).getMoney() - moneyWithDrawa);
            System.out.println("========================================= ");
            System.out.println("you have money in account : " + accounts.get(i).getMoney() + " Bath");
            System.out.println("you have money in account :" + (accounts.get(i).getMoney() / btcExchange) + " BTC");
            System.out.println("========================================= ");
        }
    }

    public static void depositAable(int i) {

        System.out.print("Enter amount : ");
        int moneyDeposit = Integer.parseInt(scanner.next());
        accounts.get(i).addMoney(moneyDeposit);
        System.out.println("========================================= ");
        System.out.println("you have money in account : " + accounts.get(i).getMoney() + " Bath");
        System.out.println("========================================= ");
    }

    public static void tranferAble(int i) {
        System.out.print("Enter destnation Account : ");
        String AccountID = scanner.next().toString();
        System.out.print("Enter amount");
        int amountToTranfer = Integer.parseInt(scanner.next());
        for (int index = 0; index < accounts.size(); index++) {
            if (accounts.get(index).getId().equals(AccountID)) {
                if (accounts.get(index).equals(accounts.get(i))) {
                    System.out.println("========================================= ");
                    System.out.println("it you Account : ");
                    System.out.println("========================================= ");
                    return;
                }
                accounts.get(i).setMoney(accounts.get(i).getMoney() - amountToTranfer);
                accounts.get(index).addMoney(amountToTranfer);
                System.out.println("========================================= ");
                System.out.println("tranfer success");
                System.out.println("========================================= ");
            }
        }
    }

    public static void btcExchangeRate() {
        System.out.println("========================================= ");
        System.out.print("Please enter BTC rate : ");
        double btcExchangeRateIn = scanner.nextDouble();
        btcExchange = btcExchangeRateIn;
        System.out.println("BTC rate : 1BTC => " + btcExchange + "bath");
        System.out.println("========================================= ");
    }
}
