package com.arkaces.ark_ethereum_lite_dual_channel_service.ethereum_ark_channel.service_capacity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository("ethereumArkChannel.serviceCapacityRepository")
public interface ServiceCapacityRepository extends JpaRepository<ServiceCapacityEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from com.arkaces.ark_ethereum_lite_dual_channel_service.ethereum_ark_channel.service_capacity.ServiceCapacityEntity s where s.pid = :pid")
    ServiceCapacityEntity findOneForUpdate(@Param("pid") Long pid);
    
}
