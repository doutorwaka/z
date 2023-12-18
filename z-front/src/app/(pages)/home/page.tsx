import { authOptions } from "@/app/api/auth/[...nextauth]/route";
import { TweetForm } from "@/components/tweet-form";
import { Tweets } from "@/components/tweets";
import { services } from "@/services";
import { getServerSession } from "next-auth/next";
import { redirect } from "next/navigation";

export default async function HomePage() {
    const session = await getServerSession(authOptions);

    const user = session?.user;

    if (user === null || user === undefined) {
        redirect("/error");
    }

    const { tweets } = await services.tweet.listFromFollows({
        profile: user.login,
    });

    return (
        <div className="flex flex-col w-full">
            <div className="border-muted border-x-[1px] border-b-[1px]">
                <TweetForm />
            </div>

            <div className="border-muted border-x-[1px]">
                <Tweets tweets={tweets} />
            </div>
        </div>
    );
}
