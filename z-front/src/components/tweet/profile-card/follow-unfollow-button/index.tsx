"use client";

import { Button } from "@/components/ui/button";
import { services } from "@/services";
import { useEffect, useState } from "react";

export type FollowUnfollowButtonProps = {
    follower: string;
    followed: string;
};

async function isFollowing(follower: string, followed: string) {
    const { is_following } = await services.profile.isFollowing({
        follower,
        followed,
    });
    return is_following;
}

async function follow(follower: string, followed: string) {
    await services.profile.follow({ follower, followed });
}

async function unfollow(follower: string, followed: string) {
    await services.profile.unfollow({ follower, followed });
}

export function FollowUnfollowButton({
    follower,
    followed,
}: FollowUnfollowButtonProps) {
    const [isFollowingState, setIsFollowingState] = useState<boolean>();

    useEffect(() => {
        isFollowing(follower, followed).then((isFollowing) => {
            setIsFollowingState(isFollowing);
        });
    }, []);

    const buttonMessage = isFollowingState ? "Deixar de seguir" : "Seguir";
    const buttonType = isFollowingState ? "destructive" : "default";

    function followUnfollowOnClickHandler() {
        if (isFollowingState) {
            unfollow(follower, followed);
        } else {
            follow(follower, followed);
        }
        setIsFollowingState(!isFollowingState);
    }

    return (
        <Button
            variant={buttonType}
            className="w-full rounded-full"
            onClick={() => followUnfollowOnClickHandler()}
        >
            {buttonMessage}
        </Button>
    );
}
