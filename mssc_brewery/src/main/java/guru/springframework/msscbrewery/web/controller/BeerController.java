package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    //Where we map our API Endpoint

    private final BeerService beerService;

    //Defining Beer Service
    //Abstracts Business logic in Service Interface and then in ServiceImpl
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    //Mapping GET Request by beerId
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    //Mapping POST Request
    @PostMapping
    public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {
        //Using Service to save new beer
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        //Setting Http headers to make a response body to the location of the newly created beer object
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        //Using Service to update beer
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteById(beerId);
    }

}
