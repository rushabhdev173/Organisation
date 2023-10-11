package com.alphaware.service.impl;

import com.alphaware.domain.Office;
import com.alphaware.repository.OfficeRepository;
import com.alphaware.service.OfficeService;
import com.alphaware.service.dto.OfficeDTO;
import com.alphaware.service.mapper.OfficeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Office}.
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeRepository officeRepository;

    private final OfficeMapper officeMapper;

    public OfficeServiceImpl(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    @Override
    public OfficeDTO save(OfficeDTO officeDTO) {
        log.debug("Request to save Office : {}", officeDTO);
        Office office = officeMapper.toEntity(officeDTO);
        office = officeRepository.save(office);
        return officeMapper.toDto(office);
    }

    @Override
    public OfficeDTO update(OfficeDTO officeDTO) {
        log.debug("Request to update Office : {}", officeDTO);
        Office office = officeMapper.toEntity(officeDTO);
        office = officeRepository.save(office);
        return officeMapper.toDto(office);
    }

    @Override
    public Optional<OfficeDTO> partialUpdate(OfficeDTO officeDTO) {
        log.debug("Request to partially update Office : {}", officeDTO);

        return officeRepository
            .findById(officeDTO.getId())
            .map(existingOffice -> {
                officeMapper.partialUpdate(existingOffice, officeDTO);

                return existingOffice;
            })
            .map(officeRepository::save)
            .map(officeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OfficeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Offices");
        return officeRepository.findAll(pageable).map(officeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OfficeDTO> findOne(Long id) {
        log.debug("Request to get Office : {}", id);
        return officeRepository.findById(id).map(officeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Office : {}", id);
        officeRepository.deleteById(id);
    }
}
