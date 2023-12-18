"use server";

import { backend } from "@/lib/requests";
import { string } from "zod";

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

export type ListTweetsFromProfileProps = {
    profile: string;
};

export type ListTweetsFromProfileResponseDto = {
    tweets: {
        id: string;
        content: string;
        author_id: string;
        author_login: string;
        likes: number;
        views: number;
        created_at: string;
    }[];
};

export async function listTweetsFromProfile({
    profile,
}: ListTweetsFromProfileProps) {
    try {
        const response = await backend.get(`/tweets/${profile}/list`);
        const responseData = response.data as ListTweetsFromProfileResponseDto;
        return responseData;
    } catch (e) {
        throw e;
    }
}
