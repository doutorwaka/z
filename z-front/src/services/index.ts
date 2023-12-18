import { CreateProfileIfNotExists } from "./auth";
import { getProfile } from "./profile";
import { createTweet } from "./tweet";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
    tweet: {
        create: createTweet,
    },
    profile: {
        get: getProfile,
    },
};
