package Model;

import java.sql.Date;

public class Book {
    private String id;
    private int authorId;
    private String bookName;
    private int pageNumbers ;
    private Topic topic ;
    private Date releaseDate;

    private Status Status;

    public Book() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Book.Status getStatus() {
        return Status;
    }

    public void setStatus(Book.Status status) {
        Status = status;
    }

    public Book(String id, int authorId, String bookName, int pageNumbers, Topic topic, Date releaseDate, Book.Status status) {
        this.id = id;
        this.authorId = authorId;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
        Status = status;
    }

    public enum Topic{
        Comedy,
        Romance,
        Other;

        Topic() {
        }
    }

    public enum Status {
        available,
        unavailable
    }
}
