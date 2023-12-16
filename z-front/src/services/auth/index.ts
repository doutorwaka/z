import { backend } from "@/lib/requests";
import { AxiosError } from "axios";

export type CreateProfileIfNotExistsProps = {
    name: string;
    login: string;
    email: string;
};

export async function CreateProfileIfNotExists({
    name,
    login,
    email,
}: CreateProfileIfNotExistsProps) {
    const data = JSON.stringify({
        name,
        login,
        email,
    });

    try {
        await backend.post("/profiles/create", data);
    } catch (e) {
        const error = e as AxiosError;
        throw error;
    }
}
