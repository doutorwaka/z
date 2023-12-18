"use client";

import { Button } from "@/components/ui/button";

export type FollowUnfollowButtonProps = {
    follower: string;
    followed: string;
};

export function FollowUnfollowButton({
    follower,
    followed,
}: FollowUnfollowButtonProps) {
    return (
        <Button variant={"default"} className="w-full rounded-full">
            Seguir
        </Button>
    );
}
