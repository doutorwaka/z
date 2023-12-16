import { CreateProfileIfNotExists } from "./auth";

export const services = {
    auth: {
        createProfileIfNotExists: CreateProfileIfNotExists,
    },
};
