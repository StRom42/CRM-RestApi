package com.crm.data.Repositories;

import com.crm.data.Models.Devices.AbstractDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceRepository<T extends AbstractDevice> extends JpaRepository<T, Long> {
}
