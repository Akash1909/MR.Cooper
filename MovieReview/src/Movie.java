import java.util.List;

public class Movie {
    String moviename;
    int yearOfRelease;
    String genre;

    String language;


    public Movie(String moviename, int yearOfRelease, String genre,String language) {
        this.moviename = moviename;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.language=language;
    }

}