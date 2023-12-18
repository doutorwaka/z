import { authOptions } from "@/app/api/auth/[...nextauth]/route";
import { TweetForm } from "@/components/tweet-form";
import { getServerSession } from "next-auth/next";

export default async function HomePage() {
    const session = await getServerSession(authOptions);

    const user = session?.user;

    console.log("user", user);

    return (
        <div className="flex flex-col w-full">
            <div className="border-muted border-x-[1px] border-b-[1px]">
                <TweetForm />
            </div>

            <div className="border-muted border-x-[1px]"></div>
        </div>
    );
}
