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
    listTweetsFromFollows,
    listTweetsFromProfile,
} from "./tweet";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
    tweet: {
        create: createTweet,
        listFromProfile: listTweetsFromProfile,
        listFromFollows: listTweetsFromFollows,
    },
    profile: {
        get: getProfile,
        follow: followProfile,
        unfollow: unfollowProfile,
        isFollowing: isFollowing,
        search: searchProfile,
    },
};
