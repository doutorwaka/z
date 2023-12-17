import { CreateProfileIfNotExists } from "./auth";
import { createTweet } from "./tweet";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
    tweet: {
        create: createTweet,
    },
};
