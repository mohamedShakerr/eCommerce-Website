package org.iti.utils.mappers.todtomappers;

import org.iti.db.domain.Customers;
import org.iti.dtos.CustomerDto;
import org.iti.utils.mappers.EntityDtoMapper;

public class CustomerMapper extends EntityDtoMapper<Customers, CustomerDto> {


    @Override
    public CustomerDto toDto(Customers entity) {
        CustomerDto dto = new CustomerDto();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setAddress(entity.getAddress());
        dto.setRegisterDate(entity.getRegDate());
        dto.setUrl(entity.getImage());
        dto.setCredit(entity.getCredit());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    @Override
    public Customers toEntity(CustomerDto customerDto) {
        Customers customer = new Customers();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        customer.setAddress(customerDto.getAddress());
        customer.setImage(customerDto.getUrl());
        customer.setCredit(customerDto.getCredit());
        customer.setPhone(customerDto.getPhone());

        return customer;
    }
}
