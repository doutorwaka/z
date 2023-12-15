package z.controllers.profile;

import org.springframework.web.bind.annotation.RestController;

import z.controllers.profile.dtos.GetProfileResponseDto;
import z.controllers.profile.dtos.IsFollowingResponseDto;
import z.controllers.profile.dtos.UnfollowProfileRequestDto;
import z.controllers.profile.dtos.UnfollowProfileResponseDto;
import z.controllers.profile.dtos.mapper.ProfileToCreateProfileResponseDtoMapper;
import z.controllers.profile.dtos.mapper.ProfileToFollowProfileResponseDtoMapper;
import z.controllers.profile.dtos.mapper.ProfileToGetProfileResponseDtoMapper;
import z.controllers.profile.dtos.mapper.ProfileToSearchResponseDtoMapper;
import z.controllers.profile.dtos.mapper.ProfileToUnfollowResponseDtoMapper;
import z.repositories.profile.jpa.ProfileJpaGateway;
import z.repositories.profile.jpa.ProfileJpaRepository;
import z.services.profile.implementation.ProfileServiceImplementation;
import z.controllers.profile.dtos.CreateProfileRequestDto;
import z.controllers.profile.dtos.CreateProfileResponseDto;
import z.controllers.profile.dtos.SearchProfileRequestDto;
import z.controllers.profile.dtos.SearchProfileResponseDto;
import z.controllers.profile.dtos.FollowProfileRequestDto;
import z.controllers.profile.dtos.FollowProfileResponseDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public GetProfileResponseDto getProfile(@PathVariable("login") final String login) {

        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.get(login);

        final var aResponse = ProfileToGetProfileResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    // http://localhost:8000/profiles/create
    @PostMapping("/create")
    public CreateProfileResponseDto create(@RequestBody final CreateProfileRequestDto request) {
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.create(request.name(), request.login(), request.email());

        final var aResponse = ProfileToCreateProfileResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    @PostMapping("/{login}/follow")
    public FollowProfileResponseDto follow(@PathVariable("login") final String login,
            @RequestBody final FollowProfileRequestDto request) {
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.follow(login, request.followed());

        final var aResponse = ProfileToFollowProfileResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    @PostMapping("/{login}/unfollow")
    public UnfollowProfileResponseDto follow(@PathVariable("login") final String login,
            @RequestBody final UnfollowProfileRequestDto request) {
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.unfollow(login, request.followed());

        final var aResponse = ProfileToUnfollowResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    @PostMapping("/search")
    public SearchProfileResponseDto search(@RequestBody final SearchProfileRequestDto request) {
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var aProfile = aService.search(request.login());

        final var aResponse = ProfileToSearchResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    @GetMapping("/{follower}/follows/{followed}")
    public IsFollowingResponseDto isFollowing(@PathVariable("follower") final String follower,
            @PathVariable("followed") final String followed) {
        final var aGateway = ProfileJpaGateway.build(this.profileRepository);
        final var aService = ProfileServiceImplementation.build(aGateway);

        final var isItFollowing = aService.isFollowing(follower, followed);

        final var aResponse = new IsFollowingResponseDto(isItFollowing);

        return aResponse;
    }

}
