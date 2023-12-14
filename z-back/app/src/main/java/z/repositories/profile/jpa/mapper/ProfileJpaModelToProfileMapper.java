package z.repositories.profile.jpa.mapper;

import java.util.function.Function;
import java.util.HashMap;
import java.util.stream.Collectors;

import z.domains.profile.entities.Profile;
import z.repositories.profile.jpa.model.ProfileJpaModel;

public class ProfileJpaModelToProfileMapper implements Function<ProfileJpaModel, Profile> {

    public static Profile mapper(final ProfileJpaModel aProfileJpaModel) {
        return new ProfileJpaModelToProfileMapper().apply(aProfileJpaModel);
    }

    @Override
    public Profile apply(final ProfileJpaModel input) {
        final var followeds = input.getFollows()
                .stream()
                .map((profile) -> {

                    final var profileFolloweds = profile.getFollows()
                            .stream()
                            .map((followed) -> {
                                return Profile.with(
                                        followed.getId(),
                                        followed.getName(),
                                        followed.getEmail(),
                                        followed.getLogin(),
                                        new HashMap<String, Profile>());
                            })
                            .collect(Collectors.toMap(Profile::getId, Function.identity()));

                    return Profile.with(
                            profile.getId(),
                            profile.getName(),
                            profile.getEmail(),
                            profile.getLogin(),
                            profileFolloweds);

                })
                .collect(Collectors.toMap(Profile::getId, Function.identity()));

        return Profile.with(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followeds);
    }

}
