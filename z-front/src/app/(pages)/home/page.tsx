import { TweetForm } from "@/components/tweet-form";
import { Tweets } from "@/components/tweets";
import { getUserSession } from "@/lib/user-session";
import { services } from "@/services";

export default async function HomePage() {
    const user = await getUserSession();

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
