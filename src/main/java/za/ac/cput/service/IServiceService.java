package za.ac.cput.service;


import za.ac.cput.domain.Service;

import java.util.List;

public interface IServiceService extends IService <Service, Long> {

    List<Service> getAll();
}
