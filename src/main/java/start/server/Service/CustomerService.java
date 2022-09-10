package start.server.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import start.server.Domain.Dto.CustomerDto;
import start.server.Domain.Entity.Customer;
import start.server.Domain.Repository.CustomerRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RequiredArgsConstructor
@Transactional
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDto create(CustomerDto customerDto){
        Customer newCustomer  = customerRepository.save(CustomerDto.toEntity(customerDto));
        return CustomerDto.of(newCustomer);

    }

    public CustomerDto read(Long customerId){
        Customer foundCustomer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "존재하지 않는 id 입니다."));
        return CustomerDto.of(foundCustomer) ;
    }


    public CustomerDto update(CustomerDto customerDto){

        //1. 읽고 나서 수정하고 쓰기 (읽기, 쓰기)

        //2. 읽고, 수정 (읽기) -> 더티체킹 -> DB를 미리 캐싱하고 있다. -> 캐싱된 데이터를 읽고 -> DB와 일치하는지 확인 -> 일치하지 않다면 자동으로 수정

        Customer foundCustomer = customerRepository.findById(customerDto.getId()).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "존재하지 않는 id 입니다."));
        foundCustomer.setName(customerDto.getName());
        return CustomerDto.of(foundCustomer);
    }
}
