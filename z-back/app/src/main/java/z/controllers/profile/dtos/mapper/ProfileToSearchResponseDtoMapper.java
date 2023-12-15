package z.controllers.profile.dtos.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import z.controllers.profile.dtos.ProfileDto;
import z.controllers.profile.dtos.SearchProfileResponseDto;
import z.domains.profile.entities.Profile;

public class ProfileToSearchResponseDtoMapper implements Function<List<Profile>, SearchProfileResponseDto> {

    public static SearchProfileResponseDto mapper(final List<Profile> aProfile) {
        return new ProfileToSearchResponseDtoMapper().apply(aProfile);
    }

    @Override
    public SearchProfileResponseDto apply(final List<Profile> input) {
        final var profiles = input.stream()
                .map((profile) -> {
                    return new ProfileDto(
                            profile.getId(),
                            profile.getName(),
                            profile.getEmail(),
                            profile.getLogin());
                })
                .collect(Collectors.toList());

        return new SearchProfileResponseDto(profiles);
    }

}
