package com.alphaware.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Office.
 */
@Entity
@Table(name = "office")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "opening_date")
    private LocalDate openingDate;

    @Column(name = "external_id")
    private String externalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "parent", "children" }, allowSetters = true)
    private Office parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = { "parent", "children" }, allowSetters = true)
    private Set<Office> children = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    //add
    public Long getId() {
        return this.id;
    }

    public Office id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return this.officeName;
    }

    public Office officeName(String officeName) {
        this.setOfficeName(officeName);
        return this;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public LocalDate getOpeningDate() {
        return this.openingDate;
    }

    public Office openingDate(LocalDate openingDate) {
        this.setOpeningDate(openingDate);
        return this;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public Office externalId(String externalId) {
        this.setExternalId(externalId);
        return this;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Office getParent() {
        return this.parent;
    }

    public void setParent(Office office) {
        this.parent = office;
    }

    public Office parent(Office office) {
        this.setParent(office);
        return this;
    }

    public Set<Office> getChildren() {
        return this.children;
    }

    public void setChildren(Set<Office> offices) {
        if (this.children != null) {
            this.children.forEach(i -> i.setParent(null));
        }
        if (offices != null) {
            offices.forEach(i -> i.setParent(this));
        }
        this.children = offices;
    }

    public Office children(Set<Office> offices) {
        this.setChildren(offices);
        return this;
    }

    public Office addChild(Office office) {
        this.children.add(office);
        office.setParent(this);
        return this;
    }

    public Office removeChild(Office office) {
        this.children.remove(office);
        office.setParent(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Office)) {
            return false;
        }
        return id != null && id.equals(((Office) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Office{" +
            "id=" + getId() +
            ", officeName='" + getOfficeName() + "'" +
            ", openingDate='" + getOpeningDate() + "'" +
            ", externalId='" + getExternalId() + "'" +
            "}";
    }
}
