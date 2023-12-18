import { MessageCircle, Repeat2, Heart, BarChart2 } from "lucide-react";
import { SplitedContainer } from "../splited-container";
import { ProfileCard } from "./profile-card";

export type TweetProps = {
    id: string;
    content: string;
    author_id: string;
    author_login: string;
    likes: number;
    views: number;
    created_at: Date;
};

function formatDate(date: Date) {
    const today = new Date();

    const receivedDate = new Date(date);

    const diffMs = today.getTime() - receivedDate.getTime();

    if (diffMs < 1000 * 60 * 60) {
        return `${Math.floor(diffMs / (1000 * 60))}m`; // minutes
    } else if (diffMs < 1000 * 60 * 60 * 24) {
        return `${Math.floor(diffMs / (1000 * 60 * 60))}h`; // hours
    } else if (diffMs < 1000 * 60 * 60 * 24 * 30) {
        return `${Math.floor(diffMs / (1000 * 60 * 60 * 24))}d`; // days
    } else {
        return receivedDate.toLocaleDateString();
    }
}

export function Tweet(props: TweetProps) {
    return (
        <SplitedContainer className="border-b-2 border-muted">
            <div className="flex flex-col w-full gap-2">
                <div>
                    <span className="underline">
                        <ProfileCard profile={props.author_login} />
                    </span>
                    <span className="font-light"> {formatDate(props.created_at)}</span>
                </div>

                <div>{props.content}</div>

                <div className="flex w-full justify-between">
                    <div className="flex gap-2 w-max items-center">
                        <MessageCircle />
                        <span className="font-light">
                            {Math.floor(Math.random() * 100)}
                        </span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Repeat2 />
                        <span className="font-light">
                            {Math.floor(Math.random() * 100)}
                        </span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Heart />
                        <span className="font-light">{props.likes}</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <BarChart2 />
                        <span className="font-light">{props.views}</span>
                    </div>
                </div>
            </div>
        </SplitedContainer>
    );
}
