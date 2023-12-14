package z.controllers.profile.dtos;

public record CreateProfileRequestDto(
        String name,
        String login,
        String email) {

}
