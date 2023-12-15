package z.controllers.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import z.controllers.tweet.dtos.CreateTweetRequestDto;
import z.controllers.tweet.dtos.CreateTweetResponseDto;
import z.controllers.tweet.dtos.LikeTweetResponseDto;
import z.controllers.tweet.dtos.ListFollowsTweetsResponseDto;
import z.controllers.tweet.dtos.ListTweetResponseDto;
import z.controllers.tweet.dtos.UnlikeTweetResponseDto;
import z.controllers.tweet.dtos.ViewTweetResponseDto;
import z.controllers.tweet.dtos.mappers.ListFollowsTweetsResponseDtoMapper;
import z.controllers.tweet.dtos.mappers.ListTweetResponseDtoMapper;
import z.controllers.tweet.dtos.mappers.TweetToCreateTweetResponseDtoMapper;
import z.controllers.tweet.dtos.mappers.TweetToLikeTweetResponseDtoMapper;
import z.controllers.tweet.dtos.mappers.TweetToUnlikeTweetResponseDtoMapper;
import z.controllers.tweet.dtos.mappers.TweetToViewTweetResponseDto;
import z.repositories.profile.jpa.ProfileJpaGateway;
import z.repositories.profile.jpa.ProfileJpaRepository;
import z.repositories.tweet.jpa.TweetJpaGateway;
import z.repositories.tweet.jpa.TweetJpaRepository;
import z.services.tweet.implementation.TweetServiceImplementation;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetJpaRepository tweetRepository;
    @Autowired
    private ProfileJpaRepository profileRepository;

    @PostMapping("/create")
    public CreateTweetResponseDto create(@RequestBody final CreateTweetRequestDto request) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweet = aService.create(request.authorLogin(), request.content());

        final var aResponse = TweetToCreateTweetResponseDtoMapper.mapper(aTweet);

        return aResponse;
    }

    @GetMapping("/{id}/like")
    public LikeTweetResponseDto like(@PathVariable("id") final String id) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweet = aService.like(id);

        final var aResponse = TweetToLikeTweetResponseDtoMapper.mapper(aTweet);

        return aResponse;
    }

    @GetMapping("/{id}/unlike")
    public UnlikeTweetResponseDto unlike(@PathVariable("id") final String id) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweet = aService.unlike(id);

        final var aResponse = TweetToUnlikeTweetResponseDtoMapper.mapper(aTweet);

        return aResponse;
    }

    @GetMapping("/{id}/view")
    public ViewTweetResponseDto view(@PathVariable("id") final String id) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweet = aService.view(id);

        final var aResponse = TweetToViewTweetResponseDto.mapper(aTweet);

        return aResponse;
    }

    @GetMapping("/{login}/list")
    public ListTweetResponseDto list(@PathVariable("login") final String login) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweets = aService.findByAuthor(login);

        final var aResponse = ListTweetResponseDtoMapper.mapper(aTweets);

        return aResponse;
    }

    @GetMapping("/{login}/follows/list")
    public ListFollowsTweetsResponseDto listFollowsTweets(@PathVariable("login") final String login) {
        final var aTweetGateway = TweetJpaGateway.build(this.tweetRepository, this.profileRepository);
        final var aProfileGateway = ProfileJpaGateway.build(this.profileRepository);

        final var aService = TweetServiceImplementation.build(aTweetGateway, aProfileGateway);

        final var aTweets = aService.findByFollowed(login);

        final var aResponse = ListFollowsTweetsResponseDtoMapper.mapper(aTweets);

        return aResponse;
    }
}
