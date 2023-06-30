package com.astrotalk.hospitalmanagement.repository;

import com.astrotalk.hospitalmanagement.model.AdmitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmitInfoRepository extends JpaRepository<AdmitInfo, Long> {
}
