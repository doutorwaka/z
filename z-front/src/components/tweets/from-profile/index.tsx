import { Tweet } from "@/components/tweet";
import { services } from "@/services";

export type TweetsFromProfileProps = {
    profile: string;
};

export async function TweetsFromProfile({ profile }: TweetsFromProfileProps) {
    const { tweets } = await services.tweet.listFromProfile({ profile });

    const tweetsComponents = tweets.map((tweet) => {
        return <Tweet key={tweet.id} />;
    });

    return { tweetsComponents };
}
