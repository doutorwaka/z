import { CreateProfileIfNotExists } from "./auth";
import {
    followProfile,
    getProfile,
    isFollowing,
    searchProfile,
    unfollowProfile,
} from "./profile";
import {
    createTweet,
    likeTweet,
    listTweetsFromFollows,
    listTweetsFromProfile,
    unlikeTweet,
    viewTweet,
} from "./tweet";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
    tweet: {
        create: createTweet,
        listFromProfile: listTweetsFromProfile,
        listFromFollows: listTweetsFromFollows,
        view: viewTweet,
        like: likeTweet,
        unlike: unlikeTweet,
    },
    profile: {
        get: getProfile,
        follow: followProfile,
        unfollow: unfollowProfile,
        isFollowing: isFollowing,
        search: searchProfile,
    },
};
