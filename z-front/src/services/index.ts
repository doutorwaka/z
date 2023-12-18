import { CreateProfileIfNotExists } from "./auth";
import { getProfile } from "./profile";
import { createTweet, listTweetsFromFollows, listTweetsFromProfile } from "./tweet";

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
    },
};
