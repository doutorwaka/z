import { Tweet } from "@/components/tweet";
import { services } from "@/services";

export type TweetsFromProfileProps = {
    profile: string;
};

export function TweetsFromProfile({ profile }: TweetsFromProfileProps) {
    const { tweets } = await services.tweet.listFromProfile({ profile });

    const tweetsComponents = tweets.map((tweet) => {
        return (
            <Tweet
                key={tweet.id}
                id={tweet.id}
                author_id={tweet.author_id}
                author_login={tweet.author_login}
                content={tweet.content}
                likes={tweet.likes}
                views={tweet.views}
                created_at={tweet.created_at}
            />
        );
    });

    return { tweetsComponents };
}
