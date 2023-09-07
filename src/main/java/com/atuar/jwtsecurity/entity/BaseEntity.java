package com.atuar.jwtsecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @PrePersist
    public void onCreatedAt() {
        this.createdAt = new Date();
        this.version = 0L;
    }

    @PreUpdate
    public void onUpdatedAt() {
        this.updatedAt = new Date();
        this.version = this.version == null ? 0L : this.version + 1L;
    }
}
