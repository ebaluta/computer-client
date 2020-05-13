package app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class Main {

    @GetMapping("/getElectronicData")
    public void getDataFromElectronicApp(){
//do komunikacji z inną aplikacją
        RestTemplate restTemplate=new RestTemplate();
        // namiary do apki z którą się będziemy łączyli
        ResponseEntity<Computer[]> responseEntity = restTemplate.exchange("http://localhost:8080/api/computers",
                HttpMethod.GET,
                null,
                Computer[].class);
//tutaj wyświetlanie wszystkiego!!!!
        Stream.of(responseEntity.getBody()).forEach(x -> System.out.println(x));
    }


    @DeleteMapping("/deleteElectronicData")
    public void deleteDateFromElectronicApp(@RequestParam long id){
        RestTemplate restTemplate=new RestTemplate();
        //To musi być dodane, do określenia, jakiego typu będzie przekazywany parametr!!!
        // To HHTP Entity to wlasnie taki obiekt przekazywany
        HttpEntity httpEntity=new HttpEntity(id);

       ResponseEntity<Boolean> responseEntity= restTemplate.exchange(
                "http://localhost:8080/api/computer/remove?id="+id,
                HttpMethod.DELETE,
                httpEntity,
                Boolean.class
        );
        System.out.println(responseEntity.getBody());

    }


    @PostMapping("/addElectronicData")
    public void addElectronicData(@RequestBody Computer computer){

        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE,"application/json");

        HttpEntity httpEntity=new HttpEntity(computer,httpHeaders);

        restTemplate.exchange(
                "http://localhost:8080/api/computer/add",
                HttpMethod.POST,
                httpEntity,
                Void.class
        );

    }
}
