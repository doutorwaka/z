package z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.profile.dtos.CreateProfileResponseDto;
import z.controllers.profile.dtos.FollowedDto;
import z.domains.profile.entities.Profile;

public class ProfileToCreateProfileResponseDtoMapper implements Function<Profile, CreateProfileResponseDto> {
    public static CreateProfileResponseDto mapper(final Profile aProfile) {
        return new ProfileToCreateProfileResponseDtoMapper().apply(aProfile);
    }

    @Override
    public CreateProfileResponseDto apply(final Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map((profile) -> {
                    return new FollowedDto(profile.getId(), profile.getLogin());
                })
                .collect(Collectors.toList());

        return new CreateProfileResponseDto(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);
    }
}
