package com.scottwills.license.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scottwills.license.models.License;

public interface LicenseRepository extends CrudRepository <License, Long> {

	License getLicenseByUserId(Long id);

}
