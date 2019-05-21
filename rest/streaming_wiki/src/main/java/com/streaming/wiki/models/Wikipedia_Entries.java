package com.streaming.wiki.models;

import javax.persistence.*;

@Entity
@Table(name = "wikipedia_entries")
public class Wikipedia_Entries {

    public Wikipedia_Entries() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryid")
    private Long entryid;

    @Column(name = "event")
    private String event;

    @Column(name = "item")
    private String item;

    @Column(name = "username")
    private String username;

    @Column(name = "link")
    private String link;

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Wikipedia_Entries{" +
                "entryid=" + entryid +
                ", event='" + event + '\'' +
                ", item='" + item + '\'' +
                ", username='" + username + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
