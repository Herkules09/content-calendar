package com.herkules09.contentcalendar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDateTime;

@Entity
@Table(name = "Content")
public class Content {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
        @NotBlank
        @Column(nullable = false)
        private String title;
        @Column
        private String description;
        @Enumerated(EnumType.STRING)
        @Column(nullable = false,length = 20)
        private Status status;
        @Enumerated(EnumType.STRING)
        @Column(name = "content_type",nullable = false,length = 50)
        private Type contentType;
        @Column(name = "data_created",nullable = false)
        private LocalDateTime dateCreated;
        @Column(name = "data_updated")
        private LocalDateTime dateUpdated;
        private String url;

        public Content() {
        }

        public Content(String title, String description, Status status, Type contentType, LocalDateTime dataCreated, LocalDateTime dateUpdated, String url) {
                this.title = title;
                this.description = description;
                this.status = status;
                this.contentType = contentType;
                this.dateCreated = dataCreated;
                this.dateUpdated = dateUpdated;
                this.url = url;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public Type getContentType() {
                return contentType;
        }

        public void setContentType(Type contentType) {
                this.contentType = contentType;
        }

        public LocalDateTime getDateCreated() {
                return dateCreated;
        }

        public void setDateCreated(LocalDateTime dateCreated) {
                this.dateCreated = dateCreated;
        }

        public LocalDateTime getDateUpdated() {
                return dateUpdated;
        }

        public void setDateUpdated(LocalDateTime dateUpdated) {
                this.dateUpdated = dateUpdated;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }
}
