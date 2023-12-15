package z.controllers.profile.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IsFollowingResponseDto(
        @JsonProperty("is_following") boolean isFollowing) {

}
