package z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.profile.dtos.FollowedDto;
import z.controllers.profile.dtos.UnfollowProfileResponseDto;
import z.domains.profile.entities.Profile;

public class ProfileToUnfollowResponseDtoMapper implements Function<Profile, UnfollowProfileResponseDto> {

    public static UnfollowProfileResponseDto mapper(final Profile aProfile) {
        return new ProfileToUnfollowResponseDtoMapper().apply(aProfile);
    }

    @Override
    public UnfollowProfileResponseDto apply(final Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map((profile) -> {
                    return new FollowedDto(profile.getId(), profile.getLogin());
                })
                .collect(Collectors.toList());

        return new UnfollowProfileResponseDto(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);
    }

}
