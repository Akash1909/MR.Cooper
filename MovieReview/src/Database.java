import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    private Set<Movie> movies1 = new HashSet<>();
    private ArrayList<Review> reviews = new ArrayList<>();


    private HashMap<String,ArrayList<Review>> ReviewMap = new HashMap<>();
    private HashMap<String, User> UserMap = new HashMap<>();

    public void addUser(String username) {
        User u = new User(username);
        UserMap.put(username, u);
        users.add(u);
    }

    public boolean checkUser(String username) {
        return UserMap.containsKey(username);
    }


    public void addMovie(String moviename, int yearOfRelease,String genre,String language) {
        movies.add(new Movie(moviename, yearOfRelease, genre, language));
    }

    public void adduserMovie(String moviename, int yearOfRelease,String genre,String language){
        movies1.add(new Movie(moviename, yearOfRelease, genre, language));
    }
    public void printusers(){
        for(User user : users){
            System.out.println(user.printusers());
        }
    }

    public void printuserMovies(){
        for (Movie movie : movies1) {
            System.out.println(movie.moviename + " is released in Year " +  movie.yearOfRelease + " has Genres " +  movie.genre+" & Language is "+ movie.language);
        }
    }
    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.moviename + " is released in Year " +  movie.yearOfRelease + " has Genres " +  movie.genre+" & Language is "+ movie.language);
        }
    }

    public boolean findMovie(String moviename1) {
        for (Movie movie : movies) {
            if(movie.moviename.equals(moviename1)) {
                    return true;
            }
        }
        return false;
    }

    public int reviewsLength() {
        return reviews.size();
    }

    public void updateUser(String username1) {
        for (User user : users) {
            if(user.username.equals(username1)) {
                User u = UserMap.get(username1);
                user.total_Reviews += 1;
                UserMap.put(username1, u);
            }
            if(user.total_Reviews > 3) {
                User u = UserMap.get(username1);
                user.status = "critic";
                UserMap.put(username1, u);
            }
        }
    }

    public void addReviews(String user1, String movie1, int rating) {
        boolean AddReview = false;
        for(User user : users) {
            if(user.username.equals(user1)) {
                if(user.status.equals("critic")) {
                    rating *= 2;
                    AddReview = true;
                }else {
                    AddReview = true;
                }
            }
        }
        if(AddReview == true) {
            Review review = new Review(user1,movie1,rating);
            ArrayList<Review> list = ReviewMap.getOrDefault(movie1, new ArrayList<>());
            list.add(review);
            ReviewMap.put(movie1,list);
            reviews.add(review);
        }else {
            System.out.println("Review cannot be added for this user");
        }
    }

    public boolean findSameReview(String user1, String movie1) {
        for (Review review : reviews) {
            if(review.moviename.equals(movie1) && review.username.equals(user1)) {
                return true;
            }
        }
        return false;

    }

    public void printreviw() {
        for(Review review : reviews) {
            System.out.println(review.reviewdetail());
        }
    }


    public double ReviewMovie(String moviename) {
        double ans = 0.0d;
        int count = 0;
        ArrayList<Review> review = ReviewMap.get(moviename);
        for(Review rev : review) {
            ans += rev.rating;
            count++;
        }
        return ans/count;

    }

    public boolean finduserMovie(String movies) {
        for(Movie movie : movies1){
            if(movie.moviename.equals(movies)){
                return true;
            }
        }
        return false;
    }

    public void Movieadd(String moviename) {
        for(Movie movie : movies1){
            if(movie.moviename.equals(moviename)){
                movies.add(movie);
            }
        }
    }
}