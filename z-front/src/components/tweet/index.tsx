"use client";

import { MessageCircle, Repeat2, Heart, BarChart2 } from "lucide-react";
import { SplitedContainer } from "../splited-container";
import { ProfileCard } from "./profile-card";
import { services } from "@/services";
import { useState } from "react";

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

var alreadyAddedView = false;

async function addView(tweetId: string) {

    if (alreadyAddedView) {
        return;
    }

    try {
        alreadyAddedView = true;
        await services.tweet.view({ id: tweetId });
    } catch (error) {
        console.log(error);
    }
}

export function Tweet(props: TweetProps) {
    addView(props.id);

    const [isLiked, setIsLiked] = useState(false);

    function handleLike() {
        if (isLiked) {
            props.likes--;
            services.tweet.unlike({ id: props.id });
        } else {
            services.tweet.like({ id: props.id });
            props.likes++;
        }

        setIsLiked(!isLiked);
    }

    return (
        <SplitedContainer
            className="border-b-2 border-muted"
            profile={props.author_login}
        >
            <div className="flex flex-col w-full gap-2">
                <div>
                    <span className="underline">
                        <ProfileCard profile={props.author_login} />
                    </span>
                    <span className="font-light">
                        {" "}
                        {formatDate(props.created_at)}
                    </span>
                </div>

                <div>{props.content}</div>

                <div className="flex w-full justify-between">
                    <div className="flex gap-2 w-max items-center">
                        <MessageCircle size={16} />
                        <span className="font-light">13</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Repeat2 size={16} />
                        <span className="font-light">15</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <Heart
                            size={16}
                            className="hover:stroke-red-500 hover:cursor-pointer"
                            onClick={() => handleLike()}
                        />
                        <span className="font-light">{props.likes}</span>
                    </div>

                    <div className="flex gap-2 w-max items-center">
                        <BarChart2 size={16} />
                        <span className="font-light">{props.views}</span>
                    </div>
                </div>
            </div>
        </SplitedContainer>
    );
}
