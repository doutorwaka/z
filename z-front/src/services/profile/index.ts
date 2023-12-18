import { backend } from "@/lib/requests";
import { AxiosError } from "axios";

type GetProfileProps = {
    profile: string;
};

export type GetProfileResponseDto = {
    id: string;
    name: string;
    email: string;
    login: string;
    followed: {
        id: string;
        login: string;
    }[];
};

export async function getProfile({ profile }: GetProfileProps) {
    try {
        const response = await backend.get(`/profiles/${profile}`);
        const responseData = response.data as GetProfileResponseDto;
        return responseData;
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}

export type FollowProfileProps = {
    follower: string;
    followed: string;
};

export async function followProfile({
    follower,
    followed,
}: FollowProfileProps) {
    const data = JSON.stringify({ followed });

    try {
        await backend.post(`/profiles/${follower}/follow`, data);
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}

export type UnfollowProfileProps = {
    follower: string;
    followed: string;
};

export async function unfollowProfile({
    follower,
    followed,
}: UnfollowProfileProps) {
    const data = JSON.stringify({ followed });

    try {
        await backend.post(`/profiles/${follower}/unfollow`, data);
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}

export type isFollowingProfileProps = {
    follower: string;
    followed: string;
};

export type IsFollowingProfileResponseDto = {
    is_following: boolean;
};

export async function isFollowing({
    follower,
    followed,
}: isFollowingProfileProps) {
    try {
        const response = await backend.get(
            `/profiles/${follower}/follows/${followed}`
        );
        const responseData = response.data as IsFollowingProfileResponseDto;
        return responseData;
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}

export type SearchProfileProps = {
    profile: string;
};

export type ProfileDto = {
    id: string;
    name: string;
    email: string;
    login: string;
};

export type SearchProfileResponseDto = {
    profiles: ProfileDto[];
};

export async function searchProfile({ profile }: SearchProfileProps) {
    const data = JSON.stringify({ login: profile });

    try {
        const response = await backend.post(`/profiles/search`, data);
        const responseData = response.data as SearchProfileResponseDto;
        return responseData;
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}
