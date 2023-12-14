package z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.profile.dtos.FollowProfileResponseDto;
import z.controllers.profile.dtos.FollowedDto;
import z.domains.profile.entities.Profile;

public class ProfileToFollowProfileResponseDtoMapper implements Function<Profile, FollowProfileResponseDto> {

    public static FollowProfileResponseDto mapper(final Profile aProfile) {
        return new ProfileToFollowProfileResponseDtoMapper().apply(aProfile);
    }

    @Override
    public FollowProfileResponseDto apply(final Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map((profile) -> {
                    return new FollowedDto(profile.getId(), profile.getLogin());
                })
                .collect(Collectors.toList());

        return new FollowProfileResponseDto(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);
    }

}
