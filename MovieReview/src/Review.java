public class Review{
    String username;
    String moviename;
    int rating;

    public Review(String username, String moviename, int rating) {
        this.username = username;
        this.moviename = moviename;
        this.rating = rating;
    }


    public String reviewdetail() {
        return this.username+ ": rated "+ this.moviename + " with ratings : " + this.rating;
    }
}