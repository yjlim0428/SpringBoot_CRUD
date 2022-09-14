package start.server.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.server.Domain.Dto.CustomerDto;
import start.server.Domain.ResponseDto.CustomerResponseDto;
import start.server.Service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;


  @PostMapping("/create")
  public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerDto customerDto){
      return ResponseEntity
              .ok()
              .body(customerService.create(customerDto).toResponse());
  }

  @GetMapping("/read/{id}")
    public ResponseEntity<CustomerResponseDto> read(@PathVariable(value = "id") Long customerId){
      return ResponseEntity
              .ok()
              .body(customerService.read(customerId).toResponse());
  }

  @PutMapping("/update")
  public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerDto customerDto){
    return ResponseEntity
            .ok()
            .body(customerService.update(customerDto).toResponse());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") Long customerId){
    return ResponseEntity
            .ok()
            .body(customerService.delete(customerId));
  }



}
