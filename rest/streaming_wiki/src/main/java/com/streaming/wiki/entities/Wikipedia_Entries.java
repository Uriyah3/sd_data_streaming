package com.streaming.wiki.entities;


import javax.persistence.*;

@Entity
@Table(name = "wikipedia_entries")
@NamedQuery(name = "Wikipedia_Entries", query = "SELECT we FROM Wikipedia_Entries we")
public class Wikipedia_Entries {

    @Id
    @Column(name = "entryid", unique = true, nullable = false)
    private int entryid;

    public int getEntryid() {
        return entryid;
    }

}
