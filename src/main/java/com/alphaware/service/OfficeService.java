package com.alphaware.service;

import com.alphaware.service.dto.OfficeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.alphaware.domain.Office}.
 */
public interface OfficeService {
    /**
     * Save a office.
     *
     * @param officeDTO the entity to save.
     * @return the persisted entity.
     */
    OfficeDTO save(OfficeDTO officeDTO);

    /**
     * Updates a office.
     *
     * @param officeDTO the entity to update.
     * @return the persisted entity.
     */
    OfficeDTO update(OfficeDTO officeDTO);

    /**
     * Partially updates a office.
     *
     * @param officeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<OfficeDTO> partialUpdate(OfficeDTO officeDTO);

    /**
     * Get all the offices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OfficeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" office.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OfficeDTO> findOne(Long id);

    /**
     * Delete the "id" office.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
