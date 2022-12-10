public class Account {
    private String name;
    private String id;
    private String passWord;
    private int money;
    public Account(String name,String id,String passWord,int money){
        if(money > 1000000){money = 1000000;}
        this.name = name;
        this.id = id;
        this.passWord = passWord;
        this.money = money;
    }
    public String getId() {
        return id;
    }
    public String getPassWord() {
        return passWord;
    }
    public int getMoney() {
        return money;
    }
    public String getName() {
        return name;
    }public void setMoney(int money) {
        this.money = money;
    }
}
