package com.luyenlaptrinh.templateproject.service.imp;

import com.luyenlaptrinh.templateproject.entities.Employee;
import com.luyenlaptrinh.templateproject.payload.request.CreateEmployeeReq;
import com.luyenlaptrinh.templateproject.payload.request.UpdateEmployeeReq;
import com.luyenlaptrinh.templateproject.repository.EmployeeRepo;
import com.luyenlaptrinh.templateproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getByEmployeeId(Long employeeId) {
        Optional<Employee> employeeOp = employeeRepo.findById(employeeId);
        return employeeOp.orElse(null);
    }

    @Override
    public Employee create(CreateEmployeeReq req) {
        Employee employee = new Employee();
        employee.setName(req.getName());
        employee.setEmail(req.getEmail());
        employee.setGender(req.getGender());
        return employeeRepo.save(employee);
    }

    @Override
    public Employee update(UpdateEmployeeReq req) {
        Optional<Employee> employeeOp = employeeRepo.findById(req.getId());
        if(employeeOp.isPresent()){
            if(req.getName() != null){
                employeeOp.get().setName(req.getName());
            }
            if(req.getEmail() != null){
                employeeOp.get().setEmail(req.getEmail());
            }
            if(req.getGender() != null){
                employeeOp.get().setGender(req.getGender());
            }

            return employeeRepo.save(employeeOp.get());
        }
        return null;
    }

    @Override
    public void delete(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }
}
