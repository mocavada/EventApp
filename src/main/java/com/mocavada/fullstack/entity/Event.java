package com.mocavada.fullstack.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    //    @Column(name ="event_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String organizer;
    private String email;
    private long contact;

    @Column(name ="date_start")
    private Date dateStart;
    @Column(name ="date_end")
    private Date dateEnd;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;

    public Event() {
    }

    public Event(String title, String organizer, String email, long contact, Date dateStart, Date dateEnd, Date dateCreated) {
        this.title = title;
        this.organizer = organizer;
        this.email = email;
        this.contact = contact;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
