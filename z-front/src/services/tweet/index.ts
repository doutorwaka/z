"use server";

import { backend } from "@/lib/requests";
import { revalidatePath } from "next/cache";
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
        revalidatePath("/profile");
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
        created_at: Date;
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

export type ListTweetsFromFollowsResponseDto = {
    tweets: {
        id: string;
        content: string;
        author_id: string;
        author_login: string;
        likes: number;
        views: number;
        created_at: Date;
    }[];
};

export async function listTweetsFromFollows({
    profile,
}: ListTweetsFromProfileProps) {
    try {
        const response = await backend.get(`/tweets/${profile}/follows/list`);
        const responseData = response.data as ListTweetsFromFollowsResponseDto;
        return responseData;
    } catch (e) {
        throw e;
    }
}

export type ViewTweetProps = {
    id: string;
};

export async function viewTweet({ id }: ViewTweetProps) {
    try {
        await backend.get(`/tweets/${id}/view`);
    } catch (error) {
        throw error;
    }
}
