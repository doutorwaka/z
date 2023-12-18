import { authOptions } from "@/app/api/auth/[...nextauth]/route";
import { getServerSession } from "next-auth/next";
import { redirect } from "next/navigation";

export async function getUserSession(){
    const session = await getServerSession(authOptions);

    const user = session?.user;

    if (user === null || user === undefined) {
        redirect("/error");
    }

    return user;
}