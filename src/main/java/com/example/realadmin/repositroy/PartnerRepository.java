package com.example.realadmin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.realadmin.system.Partner;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Partner findFirstByBusinessNumberOrderByIdDesc(String businessNumber);
}
