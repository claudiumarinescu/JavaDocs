package ro.teamnet.zth.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ro.teamnet.zth.repos.EmployeeRepository;

import javax.transaction.Transactional;

/**
 * Created by Claudiu.Marinescu on 7/19/2017.
 */
@Transactional
@Service("employeeService")
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public long getCount() {
        return empRepository.count();
    }

}
