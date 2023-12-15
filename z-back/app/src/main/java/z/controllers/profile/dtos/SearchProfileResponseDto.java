package z.controllers.profile.dtos;

import java.util.List;

public record SearchProfileResponseDto(
        List<ProfileDto> profiles) {

}
