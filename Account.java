public class Account  extends Person{
    private String id;
    private String passWord;
    private int money;
    public Account(String name,String id,String passWord,int money,String personId){
        if(money > 1000000){money = 1000000;}
        this.Personid = personId;
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
