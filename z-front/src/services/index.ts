import { CreateProfileIfNotExists } from "./auth";
import { getProfile } from "./profile";
import { createTweet, listTweetsFromProfile } from "./tweet";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
    tweet: {
        create: createTweet,
        listFromProfile: listTweetsFromProfile,
    },
    profile: {
        get: getProfile,
    },
};
