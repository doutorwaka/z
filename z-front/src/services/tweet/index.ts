"use server";

import { backend } from "@/lib/requests";
import { AxiosError } from "axios";

export type CreateTweetProps = {
    content: string;
    userLogin: string;
};

export async function createTweet({ content, userLogin }: CreateTweetProps) {
    const data = JSON.stringify({
        content,
        author_login: userLogin,
    });

    try {
        const response = await backend.post("/tweets/create", data);
        const responseData = await response.data;
        return responseData;
    } catch (e) {
        throw e;
    }
}
