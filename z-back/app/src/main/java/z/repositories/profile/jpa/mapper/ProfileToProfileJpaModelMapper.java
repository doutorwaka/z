package z.repositories.profile.jpa.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import z.domains.profile.entities.Profile;
import z.repositories.profile.jpa.model.ProfileJpaModel;

public class ProfileToProfileJpaModelMapper implements Function<Profile, ProfileJpaModel> {

    public static ProfileJpaModel mapper(final Profile aProfile) {
        return new ProfileToProfileJpaModelMapper().apply(aProfile);
    }

    @Override
    public ProfileJpaModel apply(Profile input) {
        final var follows = input.getFollowed()
                .values()
                .stream()
                .map((followed) -> {
                    return new ProfileJpaModel(
                            followed.getId(),
                            followed.getName(),
                            followed.getEmail(),
                            followed.getLogin(),
                            null,
                            null);
                })
                .collect(Collectors.toSet());

        return new ProfileJpaModel(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                follows,
                null);
    }

}
