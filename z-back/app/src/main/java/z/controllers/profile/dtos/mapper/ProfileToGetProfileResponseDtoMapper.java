package z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.profile.dtos.FollowedDto;
import z.controllers.profile.dtos.GetProfileResponseDto;
import z.domains.profile.entities.Profile;

public class ProfileToGetProfileResponseDtoMapper implements Function<Profile, GetProfileResponseDto> {

    public static GetProfileResponseDto mapper(final Profile aProfile) {
        return new ProfileToGetProfileResponseDtoMapper().apply(aProfile);
    }

    @Override
    public GetProfileResponseDto apply(final Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map((profile) -> {
                    return new FollowedDto(profile.getId(), profile.getLogin());
                })
                .collect(Collectors.toList());

        return new GetProfileResponseDto(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);
    }

}
