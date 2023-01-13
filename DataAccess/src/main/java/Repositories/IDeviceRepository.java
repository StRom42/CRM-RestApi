package Repositories;

import Models.Devices.AbstractDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepository<T extends AbstractDevice> extends JpaRepository<T, Long> {
}
