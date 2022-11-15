public class User {
    String username;
    String status;
    int total_Reviews;

    public User(String name) {
        this.username = name;
        this.status = "viewer";
        this.total_Reviews = 0;
    }
    public String printusers() {
        return this.username+ ": Status is "+ this.status + " & Total No of Reviews : " + this.total_Reviews;
    }
}