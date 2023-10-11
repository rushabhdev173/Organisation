package com.alphaware.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.alphaware.domain.Office} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OfficeDTO implements Serializable {

    private Long id;

    private String officeName;

    private LocalDate openingDate;

    private String externalId;

    private OfficeDTO parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public OfficeDTO getParent() {
        return parent;
    }

    public void setParent(OfficeDTO parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OfficeDTO)) {
            return false;
        }

        OfficeDTO officeDTO = (OfficeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, officeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OfficeDTO{" +
            "id=" + getId() +
            ", officeName='" + getOfficeName() + "'" +
            ", openingDate='" + getOpeningDate() + "'" +
            ", externalId='" + getExternalId() + "'" +
            ", parent=" + getParent() +
            "}";
    }
}
