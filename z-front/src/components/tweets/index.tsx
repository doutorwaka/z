import { Tweet, TweetProps } from "@/components/tweet";
import { services } from "@/services";

export type TweetsProps = {
    tweets: TweetProps[];
};

export function Tweets({ tweets }: TweetsProps) {
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

    return <>{tweetsComponents}</>;
}
