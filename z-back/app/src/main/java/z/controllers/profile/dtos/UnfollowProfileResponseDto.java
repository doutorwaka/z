package z.controllers.profile.dtos;

import java.util.List;

public record UnfollowProfileResponseDto(
        String id,
        String name,
        String email,
        String login,
        List<FollowedDto> followed) {

}
