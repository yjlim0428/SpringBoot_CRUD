package start.server.Domain.Dto;

import lombok.*;
import start.server.Domain.Entity.Customer;
import start.server.Domain.ResponseDto.CustomerResponseDto;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    private String name;

    public static CustomerDto of(Customer customer) {   //Entity를  Dto로 바꾸는 함수

        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();

    }

    public static Customer toEntity(CustomerDto customerDto)  {

        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();

    }  //Dto를 Entity로 바꾸는 함수


    public CustomerResponseDto toResponse() {
        return CustomerResponseDto.builder()
                .name(this.name)
                .build();
    }


}
