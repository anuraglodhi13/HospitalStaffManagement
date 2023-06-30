package com.astrotalk.hospitalmanagement.service;

import com.astrotalk.hospitalmanagement.model.AdmitInfo;
import com.astrotalk.hospitalmanagement.repository.AdmitInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmitInfoServiceImpl implements AdmitInfoService{
    @Autowired
    AdmitInfoRepository admitInfoRepository;
    @Override
    public void saveAdmitInfo(AdmitInfo admitInfo) {
        admitInfoRepository.save(admitInfo);
    }
}
