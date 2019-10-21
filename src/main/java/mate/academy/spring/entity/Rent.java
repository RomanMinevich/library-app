package mate.academy.spring.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate rentDate;
    @ManyToOne(cascade = DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToOne(cascade = DETACH)
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(columnDefinition = "TINYINT")
    private Boolean active;

    public Rent() {
        this.rentDate = LocalDate.now();
        this.active = true;
    }

    public Rent(User user, Book book) {
        this.rentDate = LocalDate.now();
        this.user = user;
        this.book = book;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
