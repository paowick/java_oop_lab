public class Manager extends Person{
    String id;
    String passWord;
    public Manager(String id, String passWord) {
        this.id = id;
        this.passWord = passWord;
    }
    public String getId() {
        return id;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
