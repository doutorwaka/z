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
