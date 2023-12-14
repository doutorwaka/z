package z.controllers.profile;

import org.springframework.web.bind.annotation.RestController;

import z.controllers.profile.dtos.GetProfileResponseDto;
import z.controllers.profile.dtos.mapper.ProfileToCreateProfileResponseDtoMapper;
import z.controllers.profile.dtos.mapper.ProfileToGetProfileResponseDtoMapper;
import z.repositories.profile.jpa.ProfileJpaGateway;
import z.repositories.profile.jpa.ProfileJpaRepository;
import z.services.profile.implementation.ProfileServiceImplementation;
import z.controllers.profile.dtos.CreateProfileRequestDto;
import z.controllers.profile.dtos.CreateProfileResponseDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



// http://localhost:8000/profiles
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileJpaRepository profileRepository;
    
    // http://localhost:8000/profiles/doutorwaka
    @GetMapping("/{login}")
    public GetProfileResponseDto getProfile(@PathVariable("login") final String login){

        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.get(login);

        final var aResponse = ProfileToGetProfileResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    // http://localhost:8000/profiles/create
    @PostMapping("/create")
    public CreateProfileResponseDto create(@RequestBody final CreateProfileRequestDto request){
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.create(request.name(), request.login(), request.email());

        final var aResponse = ProfileToCreateProfileResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }
    
    

}
